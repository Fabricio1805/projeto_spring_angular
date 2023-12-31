package com.helpdesk.backend.application.exceptions;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FieldMessage  implements Serializable {

  private static final long serialVersionUID = 1L;

  private String fieldName;
  private String message;
 
  public FieldMessage() {
    super();
  }

  public FieldMessage(String fildName, String message) {
    super();
    this.fieldName = fildName;
    this.message = message;
  }
}
