package com.bd.budget.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class ConflictException extends RuntimeException {

    public ConflictException(String message) {
        super(message);
    }
}