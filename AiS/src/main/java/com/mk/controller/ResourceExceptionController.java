package com.mk.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mk.exception.ResourceNotFoundException;


@ControllerAdvice
public class ResourceExceptionController {
   @ExceptionHandler(value = Exception.class)
   public ResponseEntity<Object> exception(Exception exception) {
      return new ResponseEntity<>("Exception ... :  "+ exception.getMessage(), HttpStatus.NOT_FOUND);
   }
   
   
   @ExceptionHandler(value = ResourceNotFoundException.class)
   public ResponseEntity<Object> exception(ResourceNotFoundException exception) {
      return new ResponseEntity<>("Resource not found "+ exception.getMessage(), HttpStatus.NOT_FOUND);
   }
   
}
