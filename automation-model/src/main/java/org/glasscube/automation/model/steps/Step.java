package org.glasscube.automation.model.steps;


import org.glasscube.automation.model.action.Action;
import org.glasscube.automation.model.elements.Element;
import org.glasscube.automation.model.validation.Validation;

public class Step {

  private Action action;

  private Element element;

  private Validation validation;

  public Action getAction() {
    return action;
  }

  public void setAction(Action action) {
    this.action = action;
  }

  public Validation getValidation() {
    return validation;
  }

  public void setValidation(Validation validation) {
    this.validation = validation;
  }

  public Element getElement() {
    return element;
  }

  public void setElement(Element element) {
    this.element = element;
  }

}
