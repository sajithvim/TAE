package org.glasscube.automation.repositories.mongo;

import org.glasscube.automation.model.cases.TestCase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestCasesRepository extends MongoRepository<TestCase, String> {

  TestCase findByTestCaseId(String testCaseId);

}
