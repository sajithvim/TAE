package com.sgx.automation.xservice.service;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgx.automation.model.steps.Step;
import com.sgx.automation.model.validation.Validation;
import com.sgx.automation.util.errors.SGXAutomationException;
import com.sgx.automation.util.errors.SGXValidationException;
import com.sgx.automation.xservice.execution.ExecutionManager;
import com.sgx.automation.xservice.execution.Executor;

@Service
public class StepsExecutionServiceImpl implements StepsExecutionService {

  @Autowired
  private ValidationService validationService;

  @Autowired
  private ExecutionManager executionManager;


  @Override
  public void executeStep(WebDriver webdriver, Step step)
      throws SGXAutomationException, SGXValidationException {
    Executor executor = executionManager.getExecutor(step.getElement().getElementType());
    executor.startExecution(webdriver, step);
    Validation validation = step.getValidation();
    if (validation != null) {
      validationService.validate(validation, webdriver);
    }
  }


}
