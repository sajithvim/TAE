package com.sgx.automation.model.elements;

import com.sgx.automation.model.steps.ElementEnum;

public abstract class Element {

  private String xpathExpression;

  private String elementId;

  private String elementClass;

  private ElementEnum elementType;

  private String elementName;

  public String getXpathExpression() {
    return xpathExpression;
  }

  public void setXpathExpression(String xpathExpression) {
    this.xpathExpression = xpathExpression;
  }

  public String getElementId() {
    return elementId;
  }

  public void setElementId(String elementId) {
    this.elementId = elementId;
  }

  public String getElementClass() {
    return elementClass;
  }

  public void setElementClass(String elementClass) {
    this.elementClass = elementClass;
  }

  public String getElementName() {
    return elementName;
  }

  public void setElementName(String elementName) {
    this.elementName = elementName;
  }

  public ElementEnum getElementType() {
    return elementType;
  }

  public void setElementType(ElementEnum elementType) {
    this.elementType = elementType;
  }

}
