package com.sgx.automation.xservice.execution;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sgx.automation.model.elements.Element;
import com.sgx.automation.model.elements.HypeLinkElement;
import com.sgx.automation.model.steps.Step;

public class HyperLinkExecutor extends Executor {

  @Override
  public WebElement startExecution(WebDriver driver, Step step) {
    HypeLinkElement link = (HypeLinkElement) step.getElement();
    WebElement linkElement = getWebElement(driver, link);
    if (linkElement == null) {
      linkElement = driver.findElement(By.linkText(link.getText()));
    }
    if (linkElement != null && step.getAction() != null) {
      executeAction(step.getAction(), linkElement);
    }
    return linkElement;
  }

  @Override
  public WebElement getWebElement(WebDriver driver, Element elementAbstract) {
    HypeLinkElement link = (HypeLinkElement) elementAbstract;
    WebElement linkElement = super.getWebElement(driver, elementAbstract);
    if (linkElement == null) {
      linkElement = driver.findElement(By.linkText(link.getText()));
    }
    return linkElement;
  }

}
