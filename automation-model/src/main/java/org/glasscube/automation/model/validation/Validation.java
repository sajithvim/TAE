package org.glasscube.automation.model.validation;

import org.glasscube.automation.model.elements.Element;

public class Validation {

  protected Element outputElement;

  protected String expectedText;

  protected String validationRegEx;

  protected ValidationEnum validationEnum;

  public ValidationEnum getValidationEnum() {
    return validationEnum;
  }

  public void setValidationEnum(ValidationEnum validationEnum) {
    this.validationEnum = validationEnum;
  }

  public Element getOutputElement() {
    return outputElement;
  }

  public void setOutputElement(Element outputElement) {
    this.outputElement = outputElement;
  }

  public String getExpectedText() {
    return expectedText;
  }

  public void setExpectedText(String expectedText) {
    this.expectedText = expectedText;
  }

  public String getValidationRegEx() {
    return validationRegEx;
  }

  public void setValidationRegEx(String validationRegEx) {
    this.validationRegEx = validationRegEx;
  }



}
