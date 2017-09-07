package org.glasscube.automation.model.action;

public class Action {

  private ActionEnum actionEnum;
  private String inputParam;

  public ActionEnum getActionEnum() {
    return actionEnum;
  }

  public void setActionEnum(ActionEnum actionEnum) {
    this.actionEnum = actionEnum;
  }

  public String getInputParam() {
    return inputParam;
  }

  public void setInputParam(String inputParam) {
    this.inputParam = inputParam;
  }

}
