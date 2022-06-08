package com.masai.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserException extends RuntimeException {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public UserException() {
    // TODO Auto-generated constructor stub
  }

  public UserException(String message) {
    // TODO Auto-generated constructor stub
    super(message);
  }
}
