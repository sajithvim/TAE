package com.sgx.automation.util.errors;

import com.sgx.automation.model.errors.ErrorCodes;

public class SGXAutomationException extends Exception {

  private ErrorCodes error;

  public SGXAutomationException(ErrorCodes error, String message) {
    super(message);
    this.error = error;
  }
}
