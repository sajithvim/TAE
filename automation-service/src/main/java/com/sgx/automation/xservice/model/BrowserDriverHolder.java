package com.sgx.automation.xservice.model;

import org.openqa.selenium.WebDriver;

import com.sgx.automation.model.cases.BrowsersEnum;

public class BrowserDriverHolder {

  private WebDriver driver;

  private BrowsersEnum browserType;

  public WebDriver getDriver() {
    return driver;
  }

  public void setDriver(WebDriver driver) {
    this.driver = driver;
  }

  public BrowsersEnum getBrowserType() {
    return browserType;
  }

  public void setBrowserType(BrowsersEnum browserType) {
    this.browserType = browserType;
  }

}
