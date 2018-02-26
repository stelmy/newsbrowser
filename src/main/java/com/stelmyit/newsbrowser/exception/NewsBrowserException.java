package com.stelmyit.newsbrowser.exception;

public class NewsBrowserException extends Exception {
  private static final long serialVersionUID = 3943426325267509574L;

  public NewsBrowserException(String message) {
    super(message);
  }

  public NewsBrowserException(String message, Throwable cause) {
    super(message, cause);
  }
  
}
