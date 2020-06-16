package com.ratelimiter.model.request;

import java.io.Serializable;

public class ThrottleRequest extends RateLimitRequest {

    private String id;

    private String userId;

    private String api;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    @Override
    public String toString() {
        return "ThrottleRequest{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", api='" + api + '\'' +
                '}';
    }
}
