package com.sxli.hotheadlines.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(
        prefix = "redis.values"
)
@Component
public class RedisValueConfig {

    private String hotNewsMaxNumberValue;

    public String getHotNewsMaxNumberValue() {
        return hotNewsMaxNumberValue;
    }

    public void setHotNewsMaxNumberValue(String hotNewsMaxNumberValue) {
        this.hotNewsMaxNumberValue = hotNewsMaxNumberValue;
    }
}
