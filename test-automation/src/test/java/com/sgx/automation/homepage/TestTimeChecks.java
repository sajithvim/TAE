package com.sgx.automation.homepage;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class TestTimeChecks {

  private static final Logger LOGGER = Logger.getLogger(TestTimeChecks.class);
  private static final String DATE_REGEX =
      "(0[1-9]|[12][0-9]|3[01])[-](0[1-9]|1[012])[-](19|20)\\d\\d";

  private WebDriver driver;


  @BeforeClass
  public void setup() {
    LOGGER.info("Starting the setup...");
    System.setProperty("webdriver.chrome.driver", "D:\\Tools\\chromedriver\\chromedriver.exe");
    System.setProperty(ChromeDriverService.CHROME_DRIVER_VERBOSE_LOG_PROPERTY, "true");
    System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY,
        "D:\\Code\\test-automation\\test-automation\\logs\\chrome.log");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("window-size=1024,768", "--disable-application-cache");
    LOGGER.info("Driver path : " + System.getProperty("webdriver.chrome.driver"));
    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
    driver = new ChromeDriver(capabilities);
    // driver = new ChromeDriver();
    // driver = new HtmlUnitDriver(BrowserVersion.CHROME);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get(
        "https://gateway.zscaler.net/auT?origurl=http%3A%2F%2Fwww%2esgx%2ecom%2f&_ordtok=qkk3WVRQkqhBrTDWkZLTk5knPH");
    driver.findElement(By.name("lognsfc")).sendKeys("sajith.weerakoon@sgx.com");
    driver.findElement(By.name("lsubmit")).click();
    driver.findElement(By.name("passsfc")).sendKeys("Password@123");
    driver.findElement(By.name("bsubmit")).click();
  }

  @BeforeMethod
  public void bringToOriginal() {
    driver.get("http://www.sgx.com");
  }

  @Test(priority = 1)
  public void testMarketInTimeStamp() {
    driver.findElement(By.linkText("Market Information")).click();
    LOGGER.info("The current URL : " + driver.getCurrentUrl());
    WebElement webElement = driver.findElement(By.id("timestamp"));
    String timeStampText = webElement.getText();
    vaidateTime(timeStampText, new DateTime());
  }

  @Test(priority = 2)
  public void testStocksTimestamp() {
    WebElement marketElement = driver.findElement(By.linkText("Market Information"));
    Actions action = new Actions(driver);
    action.moveToElement(marketElement).build().perform();
    driver.findElement(By.linkText("Stocks")).click();
    LOGGER.info("The current URL : " + driver.getCurrentUrl());
    String timeStampText = driver.findElement(By.id("timestamp")).getText();
    vaidateTime(timeStampText, new DateTime());
  }

  @Test(priority = 3)
  public void testFuturesTimestamp() {
    WebElement marketElement = driver.findElement(By.linkText("Market Information"));
    Actions action = new Actions(driver);
    action.moveToElement(marketElement).build().perform();
    driver.findElement(By.linkText("Futures")).click();
    LOGGER.info("The current URL : " + driver.getCurrentUrl());
    String timeStampText = driver.findElement(By.id("tstamp")).getText();
    vaidateTime(timeStampText, new DateTime());
  }

  @Test(priority = 4)
  public void testOptionsTimestamp() {
    WebElement marketElement = driver.findElement(By.linkText("Market Information"));
    Actions action = new Actions(driver);
    action.moveToElement(marketElement).build().perform();
    driver.findElement(By.linkText("Options")).click();
    LOGGER.info("The current URL : " + driver.getCurrentUrl());
    String timeStampText = driver.findElement(By.id("tstamp")).getText();
    vaidateTime(timeStampText, new DateTime());
  }

  @Test(priority = 5)
  public void testIndicesTimestamp() {
    WebElement marketElement = driver.findElement(By.linkText("Market Information"));
    Actions action = new Actions(driver);
    action.moveToElement(marketElement).build().perform();
    driver.findElement(By.linkText("Indices")).click();
    LOGGER.info("The current URL : " + driver.getCurrentUrl());
    String timeStampText = driver.findElement(By.id("indice_ts")).getText();
    vaidateTime(timeStampText, new DateTime());
  }

  public void vaidateTime(String timeStampText, DateTime currentTime) {
    LOGGER.info("Time stamp text : " + timeStampText);
    Pattern pattern = Pattern.compile(DATE_REGEX);
    Matcher matcher = pattern.matcher(timeStampText);
    if (matcher.find()) {
      String timeStamp = matcher.group();
      LOGGER.info("Time stamp : " + timeStamp);
      String[] timeParts = timeStamp.split("-");
      if (timeParts.length == 3) {
        int date = Integer.parseInt(timeParts[0]);
        int month = Integer.parseInt(timeParts[1]);
        int year = Integer.parseInt(timeParts[2]);
        assertEquals(currentTime.getDayOfMonth(), date);
        assertEquals(currentTime.getMonthOfYear(), month);
        assertEquals(currentTime.getYear(), year);
      } else {
        assert(false);
      }
    } else {
      assert(false);
    }
  }

  @AfterClass
  public void cleanup() {
    LOGGER.info("Closing the browser");
    driver.quit();
  }

}
