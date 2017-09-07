package org.glasscube.automation.xservice.service;

import java.util.Map;

import org.glasscube.automation.model.errors.ErrorCodes;
import org.glasscube.automation.model.validation.Validation;
import org.glasscube.automation.util.errors.SGXAutomationException;
import org.glasscube.automation.util.errors.SGXValidationException;
import org.glasscube.automation.xservice.execution.ExecutionManager;
import org.glasscube.automation.xservice.validation.Validator;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidationServiceImpl implements ValidationService {

  @Autowired
  private ExecutionManager executionManager;

  @Autowired
  Map<String, Validator> validators;

  @Override
  public boolean validate(Validation validation, WebDriver driver)
      throws SGXAutomationException, SGXValidationException {
    Validator validator = validators.get(validation.getValidationEnum().toString());
    if (validator == null) {
      throw new SGXValidationException(ErrorCodes.ERROR_2004,
          "Validator not supported " + validation.getValidationEnum().toString());
    }
    boolean result = validator.validate(validation, driver);
    return result;
  }

}
