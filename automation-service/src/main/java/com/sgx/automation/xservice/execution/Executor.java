package com.sgx.automation.xservice.execution;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sgx.automation.model.action.Action;
import com.sgx.automation.model.action.ActionEnum;
import com.sgx.automation.model.elements.Element;
import com.sgx.automation.model.steps.Step;

public abstract class Executor {

  public abstract WebElement startExecution(WebDriver webdriver, Step step);

  public WebElement getWebElement(WebDriver driver, Element elementAbstract) {
    WebElement element = null;
    if (elementAbstract.getElementId() != null && !elementAbstract.getElementId().isEmpty()) {
      element = driver.findElement(By.id(elementAbstract.getElementId()));
    } else
      if (elementAbstract.getElementName() != null && !elementAbstract.getElementName().isEmpty()) {
      element = driver.findElement(By.name(elementAbstract.getElementName()));
    } else if (elementAbstract.getElementClass() != null
        && !elementAbstract.getElementClass().isEmpty()) {
      element = driver.findElement(By.className(elementAbstract.getElementClass()));
    } else if (elementAbstract.getXpathExpression() != null
        && !elementAbstract.getXpathExpression().isEmpty()) {
      element = driver.findElement(By.xpath(elementAbstract.getXpathExpression()));
    }
    return element;
  }

  public void executeAction(Action action, WebElement element) {
    if (action.getActionEnum().equals(ActionEnum.INSERT_KEYS)
        || action.getActionEnum().equals(ActionEnum.INSERT_KEYS_PASSWORD)) {
      element.sendKeys(action.getInputParam());
    } else if (action.getActionEnum().equals(ActionEnum.CLICK)) {
      element.click();
    }
  }

}
