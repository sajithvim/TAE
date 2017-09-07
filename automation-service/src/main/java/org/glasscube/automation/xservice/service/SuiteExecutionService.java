package org.glasscube.automation.xservice.service;

import org.glasscube.automation.util.errors.SGXAutomationException;

public interface SuiteExecutionService {

  public void executeSuite(String suiteId) throws SGXAutomationException;

}
