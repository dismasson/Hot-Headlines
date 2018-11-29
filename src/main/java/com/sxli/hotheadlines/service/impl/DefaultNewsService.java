package com.sxli.hotheadlines.service.impl;

import com.sxli.hotheadlines.config.RedisKeyConfig;
import com.sxli.hotheadlines.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class DefaultNewsService implements NewsService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisKeyConfig keyConfig;

    @Override
    public List<String> hotNews() {
        Set<String> hots = redisTemplate.opsForZSet().reverseRange(keyConfig.getHotNewsKey(), -10, -1);
        return new ArrayList<>(hots);
    }
}
