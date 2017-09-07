package org.glasscube.automation.xservice.validation;

import org.glasscube.automation.model.elements.Element;
import org.glasscube.automation.model.validation.Validation;
import org.glasscube.automation.util.errors.SGXAutomationException;
import org.glasscube.automation.util.errors.SGXValidationException;
import org.glasscube.automation.xservice.execution.ExecutionManager;
import org.glasscube.automation.xservice.execution.Executor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class Validator {

  @Autowired
  private ExecutionManager executionManager;

  public abstract boolean validate(Validation validation, WebDriver driver)
      throws SGXValidationException;

  public WebElement getWebElement(WebDriver driver, Element element) throws SGXAutomationException {
    Executor executor = executionManager.getExecutor(element.getElementType());
    return executor.getWebElement(driver, element);
  }

}
