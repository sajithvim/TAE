package org.glasscube.automation.xservice.service;

import org.glasscube.automation.model.steps.Step;
import org.glasscube.automation.model.validation.Validation;
import org.glasscube.automation.util.errors.SGXAutomationException;
import org.glasscube.automation.util.errors.SGXValidationException;
import org.glasscube.automation.xservice.execution.ExecutionManager;
import org.glasscube.automation.xservice.execution.Executor;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
