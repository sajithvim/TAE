package com.sgx.automation.repositories.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sgx.automation.model.stat.TestSuiteStat;

public interface TestSuiteStatRepository extends MongoRepository<TestSuiteStat, String> {

}
