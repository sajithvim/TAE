package com.sgx.automation.repositories.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sgx.automation.model.cases.TestSuite;

@Repository
public interface TestSuiteRepository extends MongoRepository<TestSuite, String> {

  public TestSuite findByTestSuiteId(String suiteId);

}
