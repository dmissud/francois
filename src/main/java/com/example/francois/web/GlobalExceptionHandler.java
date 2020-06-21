package com.example.francois.web;

import com.fasterxml.jackson.databind.exc.ValueInstantiationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ValueInstantiationException.class)
    public ResponseEntity<Object> handleValueInstantiationException(ValueInstantiationException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.PRECONDITION_FAILED);
        body.put("error", "Command is not valid");
        String message = ex.getLocalizedMessage();
        body.put("message", message.substring(message.indexOf("problem:")+9, message.indexOf("\n")));
        return new ResponseEntity<>(body, HttpStatus.PRECONDITION_FAILED);
    }
}
