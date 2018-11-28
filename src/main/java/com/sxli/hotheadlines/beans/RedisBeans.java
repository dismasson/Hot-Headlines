package com.sxli.hotheadlines.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;

/**
 * Redis 相关bean
 */
@Configuration
public class RedisBeans {

    /**
     * 计算UV跟计算热点头条的Lua Script
     *
     * @return
     */
    @Bean("UVScript")
    public RedisScript uvScript() {
        DefaultRedisScript script = new DefaultRedisScript();
        Resource resource = new FileSystemResource("classpath:uvandhotnewsscriptscript.lua");
        script.setLocation(resource);
        return script;
    }

    public static void main(String[] args) {
        Resource resource = new FileSystemResource("uvandhotnewsscriptscript.lua");
        System.out.println(resource);
    }
}
