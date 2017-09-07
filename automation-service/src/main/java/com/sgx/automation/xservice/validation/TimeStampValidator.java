package com.sgx.automation.xservice.validation;

import static org.testng.Assert.assertEquals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sgx.automation.model.errors.ErrorCodes;
import com.sgx.automation.model.validation.TimeStampValidation;
import com.sgx.automation.model.validation.Validation;
import com.sgx.automation.util.errors.SGXAutomationException;
import com.sgx.automation.util.errors.SGXValidationException;

public class TimeStampValidator extends Validator {

  private static final Logger LOGGER = Logger.getLogger(TimeStampValidator.class);

  @Override
  public boolean validate(Validation validation, WebDriver driver) throws SGXValidationException {
    boolean validated = false;
    WebElement element;
    try {
      element = getWebElement(driver, validation.getOutputElement());
    } catch (SGXAutomationException e) {
      throw new SGXValidationException(ErrorCodes.ERROR_2002, "Validation failed as the element "
          + validation.getOutputElement().getElementType() + " was not found");
    }
    // Check against all time formats
    if (validation instanceof TimeStampValidation) {
      TimeStampValidation tValidation = (TimeStampValidation) validation;
      if (tValidation.getExpectedDate().equals(TimeStampValidation.VALIDATE_TODAY)) {
        validated = validateToday(element, tValidation.getValidationRegEx());
      } else if (tValidation.getExpectedDate().equals(TimeStampValidation.VALIDATE_LAST_MONTH)) {
        validated = validateLastMonth(element, tValidation.getValidationRegEx());
      }
    }
    if (!validated) {
      throw new SGXValidationException(ErrorCodes.ERROR_2003, "Time validation for "
          + element.getTagName() + " at " + element.getLocation().toString() + " failed");
    }
    return validated;
  }

  private boolean validateLastMonth(WebElement element, String validationRegEx) {
    DateTime dateStamp = new DateTime();
    DateTime lastMonth = dateStamp.minusMonths(1);
    String timeStampText = element.getText();
    LOGGER.info("Time stamp text : " + timeStampText);
    Pattern pattern = Pattern.compile(validationRegEx);
    Matcher matcher = pattern.matcher(timeStampText);
    if (matcher.find()) {
      String timeStamp = matcher.group();
      LOGGER.info("Time stamp : " + timeStamp);
      String[] timeParts = timeStamp.split("-");
      if (timeParts.length == 3) {
        int date = Integer.parseInt(timeParts[0]);
        int month = Integer.parseInt(timeParts[1]);
        int year = Integer.parseInt(timeParts[2]);
        assertEquals(lastMonth.getDayOfMonth(), date);
        assertEquals(lastMonth.getMonthOfYear(), month);
        assertEquals(lastMonth.getYear(), year);
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  private boolean validateToday(WebElement element, String validationRegEx) {
    DateTime currentTime = new DateTime();
    String timeStampText = element.getText();
    LOGGER.info("Time stamp text : " + timeStampText);
    Pattern pattern = Pattern.compile(validationRegEx);
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
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

}


