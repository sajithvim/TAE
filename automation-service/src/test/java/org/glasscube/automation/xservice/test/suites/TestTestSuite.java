package org.glasscube.automation.xservice.test.suites;

import javax.annotation.Resource;

import org.glasscube.automation.util.errors.SGXAutomationException;
import org.glasscube.automation.xservice.service.SuiteExecutionService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

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
