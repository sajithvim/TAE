package com.sgx.automation.xservice.validation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import com.sgx.automation.model.elements.Element;
import com.sgx.automation.model.validation.Validation;
import com.sgx.automation.util.errors.SGXAutomationException;
import com.sgx.automation.util.errors.SGXValidationException;
import com.sgx.automation.xservice.execution.ExecutionManager;
import com.sgx.automation.xservice.execution.Executor;

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
