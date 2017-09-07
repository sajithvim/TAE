package com.sgx.automation.xservice.service;

import com.sgx.automation.model.stat.TestSuiteStat;
import com.sgx.automation.util.errors.SGXAutomationException;
import com.sgx.automation.xservice.model.BrowserDriverHolder;

public interface TestCaseExecutionService {

  public void executeTestCase(String testCaseId, BrowserDriverHolder browserDriverHolder)
      throws SGXAutomationException;

  public void executeTestCase(String testCaseId, BrowserDriverHolder browser,
      TestSuiteStat testSuiteStat) throws SGXAutomationException;

}
