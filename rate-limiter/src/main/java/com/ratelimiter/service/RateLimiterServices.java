package com.ratelimiter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RateLimiterServices {

    @Autowired
    @Qualifier("fixedWindowLimiter")
    private RateLimiterService fixedWLService;

    @Autowired
    @Qualifier("slidingWindowLimiter")
    private RateLimiterService slidingWLService;

    public RateLimiterService getFixedWLService() {
        return fixedWLService;
    }

    public RateLimiterService getSlidingWLService() {
        return slidingWLService;
    }
}
