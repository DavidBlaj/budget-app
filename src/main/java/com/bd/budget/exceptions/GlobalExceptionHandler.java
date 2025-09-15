package com.bd.budget.exceptions;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {


    private final Environment env;

    public GlobalExceptionHandler(Environment env) {
        this.env=env;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFound(ResourceNotFoundException exception, HttpServletRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("message", exception.getMessage());

        // Extra information only shows in "dev" mode
        if(Arrays.asList(env.getActiveProfiles()).contains("dev")) {
            body.put("path", request.getRequestURI());
            body.put("exception", exception.getClass().getSimpleName());
            body.put("timestamp", new Date());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }
}