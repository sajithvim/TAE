package com.sgx.automation.xservice.test.suites;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.sgx.automation.util.errors.SGXAutomationException;
import com.sgx.automation.xservice.service.SuiteExecutionService;

@Test
@ContextConfiguration(locations = {"classpath:sgx-service-test-root-context.xml",
    "classpath:sgx-service-test-data-context.xml"})
public class TestTestSuite extends AbstractTestNGSpringContextTests {

  private String testSuiteId = "test-suite-1";

  @Resource
  private SuiteExecutionService executionService;

  @Test
  public void executeTestSuite() throws SGXAutomationException {
    executionService.executeSuite(testSuiteId);
  }

}
