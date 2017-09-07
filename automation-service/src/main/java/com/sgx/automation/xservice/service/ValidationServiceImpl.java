package com.sgx.automation.xservice.service;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgx.automation.model.errors.ErrorCodes;
import com.sgx.automation.model.validation.Validation;
import com.sgx.automation.util.errors.SGXAutomationException;
import com.sgx.automation.util.errors.SGXValidationException;
import com.sgx.automation.xservice.execution.ExecutionManager;
import com.sgx.automation.xservice.validation.Validator;

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
