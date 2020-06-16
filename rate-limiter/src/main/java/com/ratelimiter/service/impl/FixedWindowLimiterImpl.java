package com.ratelimiter.service.impl;

import com.ratelimiter.cache.model.FixedWindowRateLimitCache;
import com.ratelimiter.constant.RateLimiterConstant;
import com.ratelimiter.enums.ResultCode;
import com.ratelimiter.model.request.ThrottleRequest;
import com.ratelimiter.model.result.RateLimitResultCode;
import com.ratelimiter.service.RateLimiterService;
import com.ratelimiter.service.RateLimiterThrottleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("fixedWindowLimiter")
public class FixedWindowLimiterImpl implements RateLimiterService {

    @Autowired
    private RateLimiterThrottleService throttleService;

    @Override
    public RateLimitResultCode throttle(ThrottleRequest request) {
        if(request == null) {
            throw new IllegalArgumentException("Null Request Found");
        }
        try {
            return throttleService.throttle(new FixedWindowRateLimitCache(request.getUserId(), request.getApi()))
                    ? ResultCode.getResultCode(RateLimiterConstant.ResponseCode.FAIL_01).getResultCode()
                    : ResultCode.getResultCode(RateLimiterConstant.ResponseCode.SUCCESS_00).getResultCode();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return ResultCode.getResultCode(RateLimiterConstant.ResponseCode.FAIL_01).getResultCode();
    }
}
