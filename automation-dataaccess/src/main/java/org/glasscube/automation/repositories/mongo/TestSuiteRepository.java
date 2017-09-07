package org.glasscube.automation.repositories.mongo;

import org.glasscube.automation.model.cases.TestSuite;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestSuiteRepository extends MongoRepository<TestSuite, String> {

  public TestSuite findByTestSuiteId(String suiteId);

}
