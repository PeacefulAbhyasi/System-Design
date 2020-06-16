package com.ratelimiter.controller;

import com.ratelimiter.constant.ApiConstant;
import com.ratelimiter.model.request.ThrottleRequest;
import com.ratelimiter.model.response.ThrottleResponse;
import com.ratelimiter.model.result.RateLimitResultCode;
import com.ratelimiter.service.RateLimiterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiConstant.BASE_URL)
public class RateLimitController {

    @Autowired
    private RateLimiterServices rateLimiterServices;

    @PostMapping(ApiConstant.THROTTLE)
    public ResponseEntity<RateLimitResultCode> throttle(@RequestBody ThrottleRequest request) {
        return  new ResponseEntity(rateLimiterServices.getFixedWLService().throttle(request), HttpStatus.OK);
    }
}
