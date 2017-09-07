package org.glasscube.automation.model.stat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.glasscube.automation.model.elements.Element;

public class StepsStat {

  private Element element;

  private Date startTimle;

  private Date endingTime;

  private String status;

  private List<ErrorStat> errors = new ArrayList<ErrorStat>();

  public Element getElement() {
    return element;
  }

  public void setElement(Element element) {
    this.element = element;
  }

  public Date getStartTimle() {
    return startTimle;
  }

  public void setStartTimle(Date startTimle) {
    this.startTimle = startTimle;
  }

  public Date getEndingTime() {
    return endingTime;
  }

  public void setEndingTime(Date endingTime) {
    this.endingTime = endingTime;
  }

  public List<ErrorStat> getErrors() {
    return errors;
  }

  public void setErrors(List<ErrorStat> errors) {
    this.errors = errors;
  }

  public void addErrorStat(ErrorStat errorStat) {
    this.errors.add(errorStat);
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}
