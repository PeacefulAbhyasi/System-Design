package com.ratelimiter.controller;

import com.ratelimiter.constant.ApiConstant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConstant.BASE_URL)
public class HealthCheck {

    @GetMapping(ApiConstant.HEALTH_CHECK)
    public ResponseEntity<String> healthCheck() {
        return new ResponseEntity(new String("{\"status\":\"UP\"}"), HttpStatus.OK);
    }
}
