package com.sgx.automation.xservice.execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sgx.automation.model.elements.ContainerElement;
import com.sgx.automation.model.steps.Step;

public class ContainerExecutor extends Executor {

  @Override
  public WebElement startExecution(WebDriver driver, Step step) {
    ContainerElement container = (ContainerElement) step.getElement();
    WebElement containerElement = getWebElement(driver, container);
    if (containerElement == null) {
      // TODO : Do something special to find element
    }
    if (containerElement != null && step.getAction() != null) {
      executeAction(step.getAction(), containerElement);
    }
    return containerElement;
  }

}
