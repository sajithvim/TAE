package org.glasscube.automation.xservice.drivers;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.glasscube.automation.model.cases.BrowsersEnum;
import org.glasscube.automation.xservice.model.BrowserDriverHolder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Component;

@Component
public class DriverInitializer {

  private static final Logger LOGGER = Logger.getLogger(DriverInitializer.class);

  public Map<BrowsersEnum, BrowserDriverHolder> init() {
    Map<BrowsersEnum, BrowserDriverHolder> drivers =
        new HashMap<BrowsersEnum, BrowserDriverHolder>();
    drivers.put(BrowsersEnum.CHROME, this.initChrome());
    return drivers;
  }

  public BrowserDriverHolder initChrome() {
    LOGGER.info("Setting up ChromeDriver Properties");
    System.setProperty("webdriver.chrome.driver", "D:\\Tools\\chromedriver\\chromedriver.exe");
    System.setProperty(ChromeDriverService.CHROME_DRIVER_VERBOSE_LOG_PROPERTY, "true");
    System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY,
        "D:\\Code\\test-automation\\test-automation\\logs\\chrome.log");
    BrowserDriverHolder browserDriverHolder = new BrowserDriverHolder();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("window-size=1024,768", "--disable-application-cache");
    LOGGER.info("Driver path : " + System.getProperty("webdriver.chrome.driver"));
    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
    WebDriver driver = new ChromeDriver(capabilities);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    browserDriverHolder.setBrowserType(BrowsersEnum.CHROME);
    browserDriverHolder.setDriver(driver);
    return browserDriverHolder;
  }

}

