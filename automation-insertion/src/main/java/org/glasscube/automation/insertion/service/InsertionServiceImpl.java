package org.glasscube.automation.insertion.service;

import org.glasscube.automation.model.cases.TestCase;
import org.glasscube.automation.model.cases.TestSuite;
import org.glasscube.automation.repositories.mongo.TestCasesRepository;
import org.glasscube.automation.repositories.mongo.TestSuiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertionServiceImpl implements InsertionService {

  @Autowired
  private TestCasesRepository testCasesRepository;

  @Autowired
  private TestSuiteRepository testSuiteRepository;

  @Override
  public TestCase insertTestCase(TestCase testCase) {
    return testCasesRepository.save(testCase);
  }

  @Override
  public void insertTestSuite(TestSuite testSuite) {
    testSuiteRepository.save(testSuite);
  }

}
