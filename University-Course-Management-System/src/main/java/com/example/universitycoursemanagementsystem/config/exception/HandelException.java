package com.example.universitycoursemanagementsystem.config.exception;

import com.example.universitycoursemanagementsystem.helper.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class HandelException {
    @ExceptionHandler(Exception.class)
    ResponseEntity<ExceptionResponse> handelException(Exception ex){
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new ExceptionResponse(ex.getMessage()));
    }

    ResponseEntity<List<ExceptionResponse>> handelException(MethodArgumentNotValidException exception){
        List<ExceptionResponse> errors = exception.getFieldErrors().stream()
                .map(err -> new ExceptionResponse(err.getDefaultMessage()))
                .toList();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

}
