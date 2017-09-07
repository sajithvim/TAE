package com.sgx.automation.insertion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgx.automation.model.cases.TestCase;
import com.sgx.automation.model.cases.TestSuite;
import com.sgx.automation.repositories.mongo.TestCasesRepository;
import com.sgx.automation.repositories.mongo.TestSuiteRepository;

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
