package com.ratelimiter.enums;

import com.ratelimiter.model.result.RateLimitResultCode;

import java.util.HashMap;
import java.util.Map;

public enum ResultCode {

    SUCCESS("00", new RateLimitResultCode("00", "S", "SUCCESS", "Success")),
    FAIL("01", new RateLimitResultCode("01", "F", "FAIL", "Requests are throttled"));

    private String resultCodeId;

    private RateLimitResultCode resultCode;

    private static Map<String,ResultCode> cache = new HashMap<>();

    ResultCode(String resultCodeId, RateLimitResultCode resultCode) {
        this.resultCodeId = resultCodeId;
        this.resultCode = resultCode;
    }

    static {
        for(ResultCode resultCode1 : values()) {
            cache.put(resultCode1.resultCodeId, resultCode1);
        }
    }

    public static ResultCode getResultCode(String resultCodeId) {
        return cache.get(resultCodeId);
    }

    public String getResultCodeId() {
        return resultCodeId;
    }

    public RateLimitResultCode getResultCode() {
        return resultCode;
    }
}
