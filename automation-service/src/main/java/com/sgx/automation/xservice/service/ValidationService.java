package com.sgx.automation.xservice.service;

import org.openqa.selenium.WebDriver;

import com.sgx.automation.model.validation.Validation;
import com.sgx.automation.util.errors.SGXAutomationException;
import com.sgx.automation.util.errors.SGXValidationException;

public interface ValidationService {

  public boolean validate(Validation validation, WebDriver driver)
      throws SGXAutomationException, SGXValidationException;

}
