package org.glasscube.automation.xservice.execution;

import org.glasscube.automation.model.elements.ContainerElement;
import org.glasscube.automation.model.steps.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
