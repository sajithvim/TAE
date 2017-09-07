package com.sgx.automation.xservice.service;

import org.openqa.selenium.WebDriver;

import com.sgx.automation.model.steps.Step;
import com.sgx.automation.util.errors.SGXAutomationException;
import com.sgx.automation.util.errors.SGXValidationException;

public interface StepsExecutionService {

  void executeStep(WebDriver webdriver, Step step)
      throws SGXAutomationException, SGXValidationException;

}
