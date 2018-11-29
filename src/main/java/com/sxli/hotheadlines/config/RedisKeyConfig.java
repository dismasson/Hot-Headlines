package com.sxli.hotheadlines.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(
        prefix = "redis.keys"
)
@Component
public class RedisKeyConfig {

    private String hotNewsKey;

    private String hotNewsMaxNumberKey;

    public String getHotNewsKey() {
        return hotNewsKey;
    }

    public void setHotNewsKey(String hotNewsKey) {
        this.hotNewsKey = hotNewsKey;
    }

    public String getHotNewsMaxNumberKey() {
        return hotNewsMaxNumberKey;
    }

    public void setHotNewsMaxNumberKey(String hotNewsMaxNumberKey) {
        this.hotNewsMaxNumberKey = hotNewsMaxNumberKey;
    }
}
