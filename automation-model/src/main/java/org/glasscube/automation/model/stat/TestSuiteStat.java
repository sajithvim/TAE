package org.glasscube.automation.model.stat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "test_suite_stat")
public class TestSuiteStat {

  private Date startTime;

  private Date timeTaken;

  private String testSuitId;

  private String executionId;

  private String status;

  private List<TestCaseStat> testCases = new ArrayList<TestCaseStat>();

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Date getTimeTaken() {
    return timeTaken;
  }

  public void setTimeTaken(Date timeTaken) {
    this.timeTaken = timeTaken;
  }

  public String getTestSuitId() {
    return testSuitId;
  }

  public void setTestSuitId(String testSuitId) {
    this.testSuitId = testSuitId;
  }

  public String getExecutionId() {
    return executionId;
  }

  public void setExecutionId(String executionId) {
    this.executionId = executionId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public List<TestCaseStat> getTestCases() {
    return testCases;
  }

  public void setTestCases(List<TestCaseStat> testCases) {
    this.testCases = testCases;
  }

  public void addTestCase(TestCaseStat testCaseStat) {
    testCases.add(testCaseStat);
  }

}
