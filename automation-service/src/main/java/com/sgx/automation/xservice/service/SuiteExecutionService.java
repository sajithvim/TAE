package com.sgx.automation.xservice.service;

import com.sgx.automation.util.errors.SGXAutomationException;

public interface SuiteExecutionService {

  public void executeSuite(String suiteId) throws SGXAutomationException;

}
