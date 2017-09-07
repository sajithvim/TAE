package org.glasscube.automation.xservice.service;

import org.glasscube.automation.model.stat.TestSuiteStat;
import org.glasscube.automation.util.errors.SGXAutomationException;
import org.glasscube.automation.xservice.model.BrowserDriverHolder;

public interface TestCaseExecutionService {

  public void executeTestCase(String testCaseId, BrowserDriverHolder browserDriverHolder)
      throws SGXAutomationException;

  public void executeTestCase(String testCaseId, BrowserDriverHolder browser,
      TestSuiteStat testSuiteStat) throws SGXAutomationException;

}
