package com.helpdesk.backend.application.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.helpdesk.backend.application.exception.NotFoundException;
import com.helpdesk.backend.application.exception.StandardError;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerController {
  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<StandardError> notFoundException(
    Exception ex,
    HttpServletRequest request){
   
    StandardError error = new StandardError(
      System.currentTimeMillis(),
      HttpStatus.NOT_FOUND.value(), 
      "Not Found",
      ex.getMessage(),
      request.getRequestURI()  
    );

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
  }
}
