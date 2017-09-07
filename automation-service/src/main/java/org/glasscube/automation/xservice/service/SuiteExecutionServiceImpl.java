package org.glasscube.automation.xservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.glasscube.automation.model.cases.BrowsersEnum;
import org.glasscube.automation.model.cases.TestSuite;
import org.glasscube.automation.model.stat.TestSuiteStat;
import org.glasscube.automation.repositories.mongo.TestSuiteRepository;
import org.glasscube.automation.repositories.mongo.TestSuiteStatRepository;
import org.glasscube.automation.util.errors.SGXAutomationException;
import org.glasscube.automation.xservice.drivers.DriverInitializer;
import org.glasscube.automation.xservice.model.BrowserDriverHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SuiteExecutionServiceImpl implements SuiteExecutionService {

  private static final Logger LOGGER = Logger.getLogger(SuiteExecutionServiceImpl.class);

  @Autowired
  private TestSuiteRepository testSuiteRepository;

  @Autowired
  private TestCaseExecutionService testCaseExecutionService;

  @Autowired
  private TestSuiteStatRepository testSuiteStatRepository;

  @Autowired
  private DriverInitializer driverInitializer;

  private Map<BrowsersEnum, BrowserDriverHolder> webdrivers =
      new HashMap<BrowsersEnum, BrowserDriverHolder>();

  @PostConstruct
  public void loadDrivers() {
    webdrivers = driverInitializer.init();
  }

  @Override
  public void executeSuite(String suiteId) throws SGXAutomationException {
    TestSuite testSuite = testSuiteRepository.findByTestSuiteId(suiteId);
    LOGGER.info("Preparing to run " + testSuite.getTestSuiteName());
    List<String> testcaseIds = testSuite.getTestCases();
    LOGGER.info("Total test cases found " + testcaseIds.size());
    List<BrowsersEnum> openedBrowsers = new ArrayList<BrowsersEnum>();
    String executionId = UUID.randomUUID().toString();
    TestSuiteStat testSuiteStat = new TestSuiteStat();
    testSuiteStat.setTestSuitId(suiteId);
    testSuiteStat.setExecutionId(executionId);
    testSuiteStat.setStartTime(new Date());
    for (String testCaseId : testcaseIds) {
      BrowserDriverHolder browser = webdrivers.get(testSuite.getBrowser());
      openedBrowsers.add(testSuite.getBrowser());
      testCaseExecutionService.executeTestCase(testCaseId, browser, testSuiteStat);
    }
    LOGGER.info("Closing all browsers");
    for (BrowsersEnum browser : openedBrowsers) {
      webdrivers.get(browser).getDriver().quit();
    }
    testSuiteStatRepository.save(testSuiteStat);
  }

}
