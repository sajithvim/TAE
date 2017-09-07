package com.sgx.automation.repositories.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sgx.automation.model.cases.TestCase;

@Repository
public interface TestCasesRepository extends MongoRepository<TestCase, String> {

  TestCase findByTestCaseId(String testCaseId);

}
