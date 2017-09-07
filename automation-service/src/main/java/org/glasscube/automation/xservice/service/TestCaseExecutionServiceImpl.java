package org.glasscube.automation.xservice.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.glasscube.automation.model.cases.TestCase;
import org.glasscube.automation.model.stat.ErrorStat;
import org.glasscube.automation.model.stat.StepsStat;
import org.glasscube.automation.model.stat.TestCaseStat;
import org.glasscube.automation.model.stat.TestSuiteStat;
import org.glasscube.automation.model.steps.Step;
import org.glasscube.automation.model.utility.Constants;
import org.glasscube.automation.repositories.mongo.TestCasesRepository;
import org.glasscube.automation.util.errors.SGXAutomationException;
import org.glasscube.automation.util.errors.SGXValidationException;
import org.glasscube.automation.xservice.model.BrowserDriverHolder;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestCaseExecutionServiceImpl implements TestCaseExecutionService {

  private static final Logger LOGGER = Logger.getLogger(TestCaseExecutionServiceImpl.class);


  @Autowired
  private TestCasesRepository testCasesRepository;

  @Autowired
  private StepsExecutionService stepsExecutionService;

  @Override
  public void executeTestCase(String testCaseId, BrowserDriverHolder browserDriverHolder)
      throws SGXAutomationException {
    executeTestCase(testCaseId, browserDriverHolder, null);
  }

  @Override
  public void executeTestCase(String testCaseId, BrowserDriverHolder browserDriverHolder,
      TestSuiteStat testSuiteStat) throws SGXAutomationException {
    if (testSuiteStat == null) {
      testSuiteStat = new TestSuiteStat();
    }
    WebDriver driver = browserDriverHolder.getDriver();
    TestCase testCase = testCasesRepository.findByTestCaseId(testCaseId);
    TestCaseStat testCaseStat = new TestCaseStat();
    testCaseStat.setTestCaseId(testCase.getTestCaseId());
    testCaseStat.setStartingUrl(testCase.getStartingUrl());
    testCaseStat.setStartTime(new Date());
    LOGGER.info("Preparing to execute " + testCase.getTestCaseName());
    driver.get(testCase.getStartingUrl());
    List<Step> steps = testCase.getSteps();
    for (Step step : steps) {
      StepsStat stepsStat = null;
      try {
        stepsStat = new StepsStat();
        stepsStat.setStartTimle(new Date());
        stepsExecutionService.executeStep(driver, step);
      } catch (SGXValidationException e) {
        ErrorStat errorStat = new ErrorStat();
        errorStat.setException(e);
        errorStat.setErrorMessage(e.getMessage());
        errorStat.setErrorCode(e.getError());
        e.printStackTrace();
        stepsStat.addErrorStat(errorStat);
      } finally {
        stepsStat.setEndingTime(new Date());
        stepsStat.setStatus(Constants.STATUS_COMPLETED);
        testCaseStat.addTestStepStat(stepsStat);
      }
    }

    testCaseStat.setEndTime(new Date());
    testSuiteStat.addTestCase(testCaseStat);
  }

}
