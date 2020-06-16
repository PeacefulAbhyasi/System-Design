package com.ratelimiter.cache.model;

import java.io.Serializable;

public class FixedWindowRateLimitCache implements Serializable {

    private String userId;

    private String apiName;

    private String count;

    private String timeStamp;

    public FixedWindowRateLimitCache() {

    }

    public FixedWindowRateLimitCache(String userId, String apiName) {
        this.userId = userId;
        this.apiName = apiName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String getCacheKey() {
        return new StringBuilder("RATE_LIMITER_")
                .append(this.userId).append("_")
                .append(this.apiName).toString();
    }

    @Override
    public String toString() {
        return "FixedWindowRateLimitCache{" +
                "userId='" + userId + '\'' +
                ", apiName='" + apiName + '\'' +
                ", count='" + count + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                '}';
    }
}
