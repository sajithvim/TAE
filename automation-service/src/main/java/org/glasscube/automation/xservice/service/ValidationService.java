package org.glasscube.automation.xservice.service;

import org.glasscube.automation.model.validation.Validation;
import org.glasscube.automation.util.errors.SGXAutomationException;
import org.glasscube.automation.util.errors.SGXValidationException;
import org.openqa.selenium.WebDriver;

public interface ValidationService {

  public boolean validate(Validation validation, WebDriver driver)
      throws SGXAutomationException, SGXValidationException;

}
