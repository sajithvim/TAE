package org.glasscube.automation.xservice.service;

import org.glasscube.automation.model.steps.Step;
import org.glasscube.automation.util.errors.SGXAutomationException;
import org.glasscube.automation.util.errors.SGXValidationException;
import org.openqa.selenium.WebDriver;

public interface StepsExecutionService {

  void executeStep(WebDriver webdriver, Step step)
      throws SGXAutomationException, SGXValidationException;

}
