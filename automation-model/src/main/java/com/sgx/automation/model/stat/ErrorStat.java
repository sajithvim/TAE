package com.sgx.automation.model.stat;

import com.sgx.automation.model.errors.ErrorCodes;

public class ErrorStat {

  private Exception exception;

  private ErrorCodes errorCode;

  private String errorMessage;

  public Exception getException() {
    return exception;
  }

  public void setException(Exception exception) {
    this.exception = exception;
  }

  public ErrorCodes getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(ErrorCodes errorCode) {
    this.errorCode = errorCode;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }
}
