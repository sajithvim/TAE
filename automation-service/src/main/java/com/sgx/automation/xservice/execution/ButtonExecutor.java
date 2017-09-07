package com.sgx.automation.xservice.execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sgx.automation.model.elements.ButtonElement;
import com.sgx.automation.model.steps.Step;

public class ButtonExecutor extends Executor {

  @Override
  public WebElement startExecution(WebDriver driver, Step step) {
    ButtonElement button = (ButtonElement) step.getElement();
    WebElement buttonElement = getWebElement(driver, button);
    if (buttonElement == null) {
      // TODO : Do something special to find element
    }
    if (buttonElement != null && step.getAction() != null) {
      executeAction(step.getAction(), buttonElement);
    }
    return buttonElement;
  }

}
