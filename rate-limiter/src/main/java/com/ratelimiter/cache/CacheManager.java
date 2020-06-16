package com.ratelimiter.cache;

import com.ratelimiter.cache.model.FixedWindowRateLimitCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CacheManager {

    @Autowired
    private LocalCacheRegister localCacheRegister;

    public FixedWindowRateLimitCache getData(String key) {
        return localCacheRegister.getFixedWindowData(key);
    }

    public FixedWindowRateLimitCache getOrDefaultData(FixedWindowRateLimitCache cache) {
        FixedWindowRateLimitCache cacheValue = localCacheRegister.getFixedWindowData(cache.getCacheKey());
        return (cacheValue == null) ? cache : cacheValue;
    }

    public void setData(FixedWindowRateLimitCache cache) {
        localCacheRegister.setFixedWindowCacheValue(cache);
    }
}
