package com.ratelimiter.service.impl;

import com.ratelimiter.model.request.ThrottleRequest;
import com.ratelimiter.model.result.RateLimitResultCode;
import com.ratelimiter.service.RateLimiterService;
import org.springframework.stereotype.Service;

@Service("slidingWindowLimiter")
public class SlidingWindowLimiterImpl implements RateLimiterService {

    @Override
    public RateLimitResultCode throttle(ThrottleRequest request) {
        return null;
    }
}
