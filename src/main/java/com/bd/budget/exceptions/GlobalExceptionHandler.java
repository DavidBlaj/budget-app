package com.bd.budget.exceptions;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.Arrays;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Environment environment;

    public GlobalExceptionHandler(Environment environment) {
        this.environment = environment;
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiErrorResponse> handleRuntimeException(RuntimeException exception, WebRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        if (exception instanceof ConflictException) status = HttpStatus.CONFLICT;
        else if (exception instanceof ResourceNotFoundException) status = HttpStatus.NOT_FOUND;
        else if (exception instanceof ForbiddenActionException) status = HttpStatus.FORBIDDEN;
        else if (exception instanceof InvalidInputException) status = HttpStatus.BAD_REQUEST;

        boolean isDev = Arrays.asList(environment.getActiveProfiles()).contains("dev");

        ApiErrorResponse errorResponse;

        if (isDev) {
            errorResponse = new ApiErrorResponse(
                    LocalDateTime.now(),
                    status.value(),
                    status.getReasonPhrase(),
                    exception.getMessage(),
                    request.getDescription(false).replace("uri=", ""),
                    exception.getClass().getName(),
                    Arrays.toString(exception.getStackTrace())
            );
        } else {
            errorResponse = new ApiErrorResponse(
                    LocalDateTime.now(),
                    status.value(),
                    status.getReasonPhrase(),
                    exception.getMessage(),
                    request.getDescription(false).replace("uri=", ""),
                    null,
                    null
            );
        }

        return new ResponseEntity<>(errorResponse, status);

    }
}