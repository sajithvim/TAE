package com.sgx.automation.model.cases;

import java.util.ArrayList;
import java.util.List;

public class TestSuite {

  private List<String> testCases = new ArrayList<String>();

  private BrowsersEnum browser;

  private String testSuiteId;

  private String testSuiteName;

  public String getTestSuiteId() {
    return testSuiteId;
  }

  public void setTestSuiteId(String testSuiteId) {
    this.testSuiteId = testSuiteId;
  }

  public String getTestSuiteName() {
    return testSuiteName;
  }

  public void setTestSuiteName(String testSuiteName) {
    this.testSuiteName = testSuiteName;
  }

  public void addTestCase(String testcase) {
    this.testCases.add(testcase);
  }

  public List<String> getTestCases() {
    return testCases;
  }

  public void setTestCases(List<String> testCases) {
    this.testCases = testCases;
  }

  public BrowsersEnum getBrowser() {
    return browser;
  }

  public void setBrowser(BrowsersEnum browser) {
    this.browser = browser;
  }



}
