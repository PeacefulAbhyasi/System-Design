package com.ratelimiter.service;


import com.ratelimiter.cache.CacheManager;
import com.ratelimiter.cache.model.FixedWindowRateLimitCache;
import com.ratelimiter.config.RateLimiterClientConfig;
import com.ratelimiter.constant.UserConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.concurrent.locks.ReentrantLock;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class RateLimiterThrottleService {

    private static final ReentrantLock lock = new ReentrantLock();

    @Autowired
    private RateLimiterClientConfig clientConfig;

    @Autowired
    private CacheManager cacheManager;

    public boolean throttle(FixedWindowRateLimitCache cacheRequest) {
        FixedWindowRateLimitCache cache = cacheManager.getOrDefaultData(cacheRequest);
        long maxRequestPerSecond = Long.parseLong(clientConfig.getUserConfig(UserConstant.MAX_REQUEST_COUNT_SECOND));
        long maxRequestPerMinute = Long.parseLong(clientConfig.getUserConfig(UserConstant.MAX_REQUEST_COUNT_MINUTE));
        boolean throttle = false;
        try {
            lock.lock();
            System.out.println("Lock Acquired !!");
            long currTime = System.currentTimeMillis();
            if(StringUtils.isEmpty(cache.getCount())) {
                cache.setCount(String.valueOf(1));
                cache.setTimeStamp(String.valueOf(currTime));
                cacheManager.setData(cache);
                System.out.println("Set Data : " + cache);
                return throttle;
            }
            long lastTime = Long.parseLong(cache.getTimeStamp());
            long count = Long.valueOf(cache.getCount()) + 1;
            if((currTime-lastTime)/1000 <= 1) {
                throttle = count > maxRequestPerSecond;
            } else {
                cache.setCount(String.valueOf(1));
                cache.setTimeStamp(String.valueOf(currTime));
                cacheManager.setData(cache);
            }
            if(!throttle) {
                cache.setCount(String.valueOf(count));
                cache.setTimeStamp(String.valueOf(currTime));
                cacheManager.setData(cache);
            }
            System.out.println("Set Data : " + cache);
            return throttle;
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            lock.unlock();
            System.out.println("Lock Released !!");
        }
        return throttle;
    }
}
