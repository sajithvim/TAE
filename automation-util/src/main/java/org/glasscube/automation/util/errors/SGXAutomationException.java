package org.glasscube.automation.util.errors;

import org.glasscube.automation.model.errors.ErrorCodes;

public class SGXAutomationException extends Exception {

  private ErrorCodes error;

  public SGXAutomationException(ErrorCodes error, String message) {
    super(message);
    this.error = error;
  }
}
