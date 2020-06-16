package com.ratelimiter.config;

import com.ratelimiter.constant.UserConstant;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class RateLimiterClientConfig {

    private static ConcurrentHashMap<String, String> userConfig = new ConcurrentHashMap<>();

    static {
        initializeUserConfig();
    }

    public static void initializeUserConfig() {
        userConfig.put(UserConstant.MAX_REQUEST_COUNT_SECOND, "1");
        userConfig.put(UserConstant.MAX_REQUEST_COUNT_MINUTE, "3");
        userConfig.put(UserConstant.MAX_REQUEST_COUNT_HOUR, "120");
        userConfig.put(UserConstant.MAX_REQUEST_COUNT_DAY, "2880");
    }

    public String getUserConfig(String key) {
        return userConfig.get(key);
    }
}
