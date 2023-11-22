package com.helpdesk.backend.application.exceptions;

public class DataIntegrityViolationException extends RuntimeException {

  public DataIntegrityViolationException(String message, Throwable cause) {
    super(message, cause);
  }

  public DataIntegrityViolationException(String message) {
    super(message);
  }
}
