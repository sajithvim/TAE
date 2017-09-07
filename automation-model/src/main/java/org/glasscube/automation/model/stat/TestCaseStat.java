package org.glasscube.automation.model.stat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestCaseStat {

  private Date startTime;

  private Date endTime;

  private String executionId;

  private String testCaseId;

  private String startingUrl;

  private List<StepsStat> stepsStat = new ArrayList<StepsStat>();

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  public String getExecutionId() {
    return executionId;
  }

  public void setExecutionId(String executionId) {
    this.executionId = executionId;
  }

  public String getTestCaseId() {
    return testCaseId;
  }

  public void setTestCaseId(String testCaseId) {
    this.testCaseId = testCaseId;
  }

  public List<StepsStat> getStepsStat() {
    return stepsStat;
  }

  public void setStepsStat(List<StepsStat> stepsStat) {
    this.stepsStat = stepsStat;
  }

  public String getStartingUrl() {
    return startingUrl;
  }

  public void setStartingUrl(String startingUrl) {
    this.startingUrl = startingUrl;
  }

  public void addTestStepStat(StepsStat stepsStat) {
    this.stepsStat.add(stepsStat);
  }

}
