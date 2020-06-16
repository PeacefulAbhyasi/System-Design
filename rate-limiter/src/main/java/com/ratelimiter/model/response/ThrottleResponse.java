package com.ratelimiter.model.response;

import java.io.Serializable;

public class ThrottleResponse implements Serializable {

    private String status;

    public ThrottleResponse(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
