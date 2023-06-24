package com.unitech.backoffice.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Handlers {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity error404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity erro400(MethodArgumentNotValidException ex) {
        var error = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(error.stream().map(DataErrorDto::new).toList());
    }

    private record DataErrorDto(String field, String message) {
        public DataErrorDto(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
