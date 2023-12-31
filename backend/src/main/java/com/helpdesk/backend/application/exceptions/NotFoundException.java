package com.helpdesk.backend.application.exceptions;

public class NotFoundException extends RuntimeException {

  public NotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public NotFoundException(String message) {
    super(message);
  }
}
