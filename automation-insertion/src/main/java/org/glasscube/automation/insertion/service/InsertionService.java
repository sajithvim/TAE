package org.glasscube.automation.insertion.service;

import org.glasscube.automation.model.cases.TestCase;
import org.glasscube.automation.model.cases.TestSuite;

public interface InsertionService {

  public TestCase insertTestCase(TestCase testCase);

  public void insertTestSuite(TestSuite testSuite);

}
