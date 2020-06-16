package com.ratelimiter.model.result;

import java.io.Serializable;

public class RateLimitResultCode implements Serializable {

    private String id;

    private String code;

    private String status;

    private String msg;

    private RateLimitResultCode() {

    }

    public RateLimitResultCode(String id, String code, String status, String msg) {
        this.id = id;
        this.code = code;
        this.status = status;
        this.msg = msg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "RateLimitResultCode{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
