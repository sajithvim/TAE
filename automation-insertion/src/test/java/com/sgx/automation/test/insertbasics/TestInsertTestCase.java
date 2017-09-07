package com.sgx.automation.test.insertbasics;

import javax.annotation.Resource;

import org.glasscube.automation.insertion.service.InsertionService;
import org.glasscube.automation.model.action.Action;
import org.glasscube.automation.model.action.ActionEnum;
import org.glasscube.automation.model.cases.BrowsersEnum;
import org.glasscube.automation.model.cases.TestCase;
import org.glasscube.automation.model.cases.TestSuite;
import org.glasscube.automation.model.elements.ButtonElement;
import org.glasscube.automation.model.elements.ContainerElement;
import org.glasscube.automation.model.elements.HypeLinkElement;
import org.glasscube.automation.model.elements.TextBoxElement;
import org.glasscube.automation.model.steps.ElementEnum;
import org.glasscube.automation.model.steps.Step;
import org.glasscube.automation.model.validation.TimeStampValidation;
import org.glasscube.automation.model.validation.ValidationEnum;
import org.glasscube.automation.repositories.mongo.TestCasesRepository;
import org.glasscube.automation.repositories.mongo.TestSuiteRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
@ContextConfiguration(
    locations = {"classpath:sgx-test-root-context.xml", "classpath:sgx-test-data-context.xml"})
public class TestInsertTestCase extends AbstractTestNGSpringContextTests {

  @Resource
  private InsertionService insertionService;

  @Resource
  private TestCasesRepository testCasesRepository;

  @Resource
  private TestSuiteRepository testSuiteRepository;

  @BeforeClass
  public void setup() {
    cleanup();
  }

  public void cleanup() {
    testCasesRepository.deleteAll();
    testSuiteRepository.deleteAll();
  }

  @Test(priority = 1)
  public void addWarmupTestCase() {
    TestCase testCase = new TestCase();
    testCase.setStartingUrl(
        "https://gateway.zscaler.net/auT?origurl=http%3A%2F%2Fwww%2esgx%2ecom%2fwps%2fportal%2fsgxweb");
    testCase.setTestCaseId("testcase-warmup-1");
    testCase.setTestCaseName("overcome zscalar");

    Step typeEmailAddress = new Step();
    TextBoxElement emailTextBox = new TextBoxElement();
    emailTextBox.setElementName("lognsfc");
    emailTextBox.setElementType(ElementEnum.INBOX);
    typeEmailAddress.setElement(emailTextBox);
    Action enterEmail = new Action();
    enterEmail.setActionEnum(ActionEnum.INSERT_KEYS);
    enterEmail.setInputParam("sajith.weerakoon@sgx.com");
    typeEmailAddress.setAction(enterEmail);
    testCase.addStep(typeEmailAddress);

    Step clickEmailSubmitBtn = new Step();
    ButtonElement emailSubmitButton = new ButtonElement();
    emailSubmitButton.setElementName("lsubmit");
    emailSubmitButton.setElementType(ElementEnum.BUTTON);
    clickEmailSubmitBtn.setElement(emailSubmitButton);
    Action clickEmailSubmitButton = new Action();
    clickEmailSubmitButton.setActionEnum(ActionEnum.CLICK);
    clickEmailSubmitBtn.setAction(clickEmailSubmitButton);
    testCase.addStep(clickEmailSubmitBtn);

    Step typepasswd = new Step();
    TextBoxElement passWordBox = new TextBoxElement();
    passWordBox.setElementName("passsfc");
    passWordBox.setElementType(ElementEnum.PASSWORD);
    typepasswd.setElement(passWordBox);
    Action enterPasswd = new Action();
    enterPasswd.setActionEnum(ActionEnum.INSERT_KEYS_PASSWORD);
    enterPasswd.setInputParam("Password@123");
    typepasswd.setAction(enterPasswd);
    testCase.addStep(typepasswd);

    Step clickPwdSubmitBtn = new Step();
    ButtonElement pwdButton = new ButtonElement();
    pwdButton.setElementName("bsubmit");
    pwdButton.setElementType(ElementEnum.BUTTON);
    clickPwdSubmitBtn.setElement(pwdButton);
    Action clickPwdSubmitButton = new Action();
    clickPwdSubmitButton.setActionEnum(ActionEnum.CLICK);
    clickPwdSubmitBtn.setAction(clickPwdSubmitButton);
    testCase.addStep(clickPwdSubmitBtn);


    testCase = insertionService.insertTestCase(testCase);
  }

  @Test(priority = 2)
  public void checkTimeStamp() {
    TestCase testCase = new TestCase();
    testCase.setStartingUrl("http://sgx.com/");
    testCase.setTestCaseId("MarketInfoTimestamp");
    testCase.setTestCaseName("Marker Info Time Stamp");

    Step clickMarketLink = new Step();
    HypeLinkElement hypeLinkElement = new HypeLinkElement();
    hypeLinkElement.setText("Market Information");
    hypeLinkElement.setElementType(ElementEnum.LINK);
    clickMarketLink.setElement(hypeLinkElement);
    Action clickLink = new Action();
    clickLink.setActionEnum(ActionEnum.CLICK);
    clickMarketLink.setAction(clickLink);
    testCase.addStep(clickMarketLink);

    TimeStampValidation timeStampValidation = new TimeStampValidation();
    timeStampValidation.setValidationEnum(ValidationEnum.TIMESTAMP);
    timeStampValidation
        .setValidationRegEx("(0[1-9]|[12][0-9]|3[01])[-](0[1-9]|1[012])[-](19|20)\\d\\d");
    timeStampValidation.setExpectedDate(TimeStampValidation.VALIDATE_TODAY);
    ContainerElement timeStampContainer = new ContainerElement();
    timeStampContainer.setElementId("timestamp");
    timeStampContainer.setElementType(ElementEnum.CONTAINER);
    timeStampValidation.setOutputElement(timeStampContainer);
    clickMarketLink.setValidation(timeStampValidation);

    testCase = insertionService.insertTestCase(testCase);
  }

  @Test(priority = 3)
  public void addTestSuite() {
    TestSuite testSuite = new TestSuite();
    testSuite.setTestSuiteId("test-suite-1");
    testSuite.setTestSuiteName("test-suite-123");
    testSuite.addTestCase("testcase-warmup-1");
    testSuite.addTestCase("MarketInfoTimestamp");
    testSuite.setBrowser(BrowsersEnum.CHROME);
    insertionService.insertTestSuite(testSuite);
  }

}
