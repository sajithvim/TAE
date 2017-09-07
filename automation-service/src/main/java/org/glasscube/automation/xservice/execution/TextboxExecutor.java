package org.glasscube.automation.xservice.execution;

import org.glasscube.automation.model.elements.TextBoxElement;
import org.glasscube.automation.model.steps.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextboxExecutor extends Executor {

  @Override
  public WebElement startExecution(WebDriver driver, Step step) {
    TextBoxElement textBox = (TextBoxElement) step.getElement();
    WebElement textElement = getWebElement(driver, textBox);
    if (textElement == null) {
      // TODO : Do something special to find element
    }
    if (textElement != null && step.getAction() != null) {
      executeAction(step.getAction(), textElement);
    }
    return textElement;
  }

}
