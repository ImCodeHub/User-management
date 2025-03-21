package com.example.User_management.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.UserNotFoundException.class)
    public ResponseEntity<?> handlerUserNotFoundException(CustomException.UserNotFoundException userException, WebRequest webRequest){
        return new ResponseEntity<>(userException.getMessage(), HttpStatus.NOT_FOUND);
    }

}
