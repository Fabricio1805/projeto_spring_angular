package com.helpdesk.backend.application.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.helpdesk.backend.application.exceptions.DataIntegrityViolationException;
import com.helpdesk.backend.application.exceptions.NotFoundException;
import com.helpdesk.backend.application.exceptions.StandardError;
import com.helpdesk.backend.application.exceptions.ValidationError;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerController {
  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<StandardError> notFoundException(
    NotFoundException ex,
      HttpServletRequest request) {

    StandardError error = new StandardError(
        System.currentTimeMillis(),
        HttpStatus.NOT_FOUND.value(),
        "Not Found",
        ex.getMessage(),
        request.getRequestURI());

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
  }
  
  @ExceptionHandler(DataIntegrityViolationException.class)
  public ResponseEntity<StandardError> dataIntegrityViolationException(
    DataIntegrityViolationException ex,
      HttpServletRequest request) {

    StandardError error = new StandardError(
        System.currentTimeMillis(),
        HttpStatus.BAD_REQUEST.value(),
        "Violação de dados",
        ex.getMessage(),
        request.getRequestURI());

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
  }
  
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<StandardError> validationErrors(
    MethodArgumentNotValidException ex,
    HttpServletRequest request){
    
    ValidationError errors = new ValidationError(
      System.currentTimeMillis(),
      HttpStatus.BAD_REQUEST.value(),
      "Validation error",
      "Erro na validação dos campos",
      request.getRequestURI()
    );
  
    for(FieldError e : ex.getBindingResult().getFieldErrors()){
      errors.addError(e.getField(), e.getDefaultMessage());
    } 

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
  }
}
