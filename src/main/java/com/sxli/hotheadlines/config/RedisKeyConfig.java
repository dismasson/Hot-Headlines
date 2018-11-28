package com.sxli.hotheadlines.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(
        prefix = "redis.keys"
)
@Component
public class RedisKeyConfig {

    private String hotNewsKey;

    public String getHotNewsKey() {
        return hotNewsKey;
    }

    public void setHotNewsKey(String hotNewsKey) {
        this.hotNewsKey = hotNewsKey;
    }
}
