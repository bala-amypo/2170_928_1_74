package com.example.demo.exception;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> notFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("message", ex.getMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> badRequest(IllegalArgumentException ex) {
        return ResponseEntity.badRequest()
                .body(Map.of("message", ex.getMessage()));
    }
}
