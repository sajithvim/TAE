package com.sgx.automation.xservice.execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sgx.automation.model.elements.TextBoxElement;
import com.sgx.automation.model.steps.Step;

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
