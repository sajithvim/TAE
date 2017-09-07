package org.glasscube.automation.repositories.mongo;

import org.glasscube.automation.model.stat.TestSuiteStat;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestSuiteStatRepository extends MongoRepository<TestSuiteStat, String> {

}
