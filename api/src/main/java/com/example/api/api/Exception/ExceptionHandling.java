package com.example.api.api.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandling {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleException(MethodArgumentNotValidException ex){
        Map<String,String> error=new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((e) -> {
         
            String fieldName=((FieldError)e).getField();
            String message=e.getDefaultMessage();
            error.put(fieldName, message);
        });

        return new ResponseEntity<Map<String,String>>(error, HttpStatus.BAD_REQUEST);
    }
}
