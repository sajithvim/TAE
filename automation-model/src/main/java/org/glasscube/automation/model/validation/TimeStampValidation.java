package org.glasscube.automation.model.validation;

public class TimeStampValidation extends Validation {

  public final static String VALIDATE_TODAY = "validate_today";
  public final static String VALIDATE_LAST_MONTH = "validate_last_month";

  protected String expectedDate;

  public String getExpectedDate() {
    return expectedDate;
  }

  public void setExpectedDate(String expectedDate) {
    this.expectedDate = expectedDate;
  }

}
