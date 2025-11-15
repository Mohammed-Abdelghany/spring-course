package com.example.teacherstudents.config.exception;


import com.example.teacherstudents.helper.MessageResponse;
import com.example.teacherstudents.service.imp.BundleMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final BundleMessageService bundleMessageService;
    @Autowired
    public GlobalExceptionHandler(BundleMessageService bundleMessageService) {
        this.bundleMessageService = bundleMessageService;
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MessageResponse> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(bundleMessageService.getMessageResponse(ex.getMessage()));
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<MessageResponse>> handleException(MethodArgumentNotValidException exception) {
        List<MessageResponse> errors = exception.getFieldErrors().stream().map(
                err -> bundleMessageService.getMessageResponse(err.getDefaultMessage())
        ).toList();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);

    }


    }

