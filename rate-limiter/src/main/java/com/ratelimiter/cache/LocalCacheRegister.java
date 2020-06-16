package com.ratelimiter.cache;

import com.ratelimiter.cache.model.FixedWindowRateLimitCache;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.concurrent.ConcurrentHashMap;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class LocalCacheRegister {

    private static ConcurrentHashMap<String, FixedWindowRateLimitCache> fixedWindow = new ConcurrentHashMap<>();

    public static void initializeCache() {
    }

    public FixedWindowRateLimitCache getFixedWindowData(String cacheKey) {
        if(StringUtils.isEmpty(cacheKey)) {
            throw new IllegalArgumentException("Invalid CacheKey");
        }
        return fixedWindow.get(cacheKey);
    }

    public void setFixedWindowCacheValue(FixedWindowRateLimitCache cache) {
        fixedWindow.put(cache.getCacheKey(), cache);
    }
}
