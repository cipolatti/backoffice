package com.unitech.backoffice.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
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

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity erro400(HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity erroBadCredentials() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity erroAuthentication() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Falha na autenticação");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity erro500(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " +ex.getLocalizedMessage());
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity DataIntegrityViolationException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Já tem cadastro com este login!");
    }

    private record DataErrorDto(String field, String message) {
        public DataErrorDto(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
