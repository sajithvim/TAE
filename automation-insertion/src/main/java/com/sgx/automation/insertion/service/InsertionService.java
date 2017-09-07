package com.sgx.automation.insertion.service;

import com.sgx.automation.model.cases.TestCase;
import com.sgx.automation.model.cases.TestSuite;

public interface InsertionService {

  public TestCase insertTestCase(TestCase testCase);

  public void insertTestSuite(TestSuite testSuite);

}
