package com.sxli.hotheadlines.consumer.receive;

import com.sxli.hotheadlines.config.RedisKeyConfig;
import com.sxli.hotheadlines.config.RedisValueConfig;
import com.sxli.hotheadlines.consumer.PageViewInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@EnableBinding(PageViewInput.class)
public class DefaultPageViewReceive {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisKeyConfig redisKeyConfig;

    @Autowired
    private RedisValueConfig redisValueConfig;

    // 计算UV的脚本
    @Autowired
    private RedisScript UVScript;

    @StreamListener("stream.pageview")
    public void receive(String message) {
        // 消息格式为 用户ID:头条新闻ID
        String[] values = message.split(":");
        // 用户ID
        String userId = values[0];
        // 头条ID
        String newsId = values[1];
        // key = uv.头条新闻id
        String key = new StringBuilder("uv.").append(newsId).toString();
        // 包装key集合
        List<String> keys = new ArrayList<>(2);
        keys.add(key);
        keys.add(redisKeyConfig.getHotNewsKey());
        // 执行脚本
        redisTemplate.execute(UVScript, keys, userId, newsId);
    }
}
