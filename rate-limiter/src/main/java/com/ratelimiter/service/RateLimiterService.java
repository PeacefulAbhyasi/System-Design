package com.ratelimiter.service;

import com.ratelimiter.model.request.RateLimitRequest;
import com.ratelimiter.model.request.ThrottleRequest;
import com.ratelimiter.model.result.RateLimitResultCode;

public interface RateLimiterService {

    RateLimitResultCode throttle(ThrottleRequest request);
}
