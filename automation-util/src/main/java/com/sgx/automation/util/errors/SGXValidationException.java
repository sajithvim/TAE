package com.sgx.automation.util.errors;

import com.sgx.automation.model.errors.ErrorCodes;

public class SGXValidationException extends Exception {

  private ErrorCodes error;

  public SGXValidationException(ErrorCodes error, String message) {
    super(message);
    this.error = error;
  }

  public ErrorCodes getError() {
    return error;
  }

  public void setError(ErrorCodes error) {
    this.error = error;
  }


}
