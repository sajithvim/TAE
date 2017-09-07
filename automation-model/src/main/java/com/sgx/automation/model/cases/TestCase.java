package com.sgx.automation.model.cases;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.sgx.automation.model.steps.Step;

@Document(collection = "testcases")
public class TestCase {

  private String id;

  private String testCaseId;

  private String testCaseName;

  private String testCaseSummary;

  private String startingUrl;

  private List<Step> steps = new ArrayList<Step>();

  public String getTestCaseId() {
    return testCaseId;
  }

  public void setTestCaseId(String testCaseId) {
    this.testCaseId = testCaseId;
  }

  public String getTestCaseName() {
    return testCaseName;
  }

  public void setTestCaseName(String testCaseName) {
    this.testCaseName = testCaseName;
  }

  public String getTestCaseSummary() {
    return testCaseSummary;
  }

  public void setTestCaseSummary(String testCaseSummary) {
    this.testCaseSummary = testCaseSummary;
  }

  public List<Step> getSteps() {
    return steps;
  }

  public void setSteps(List<Step> steps) {
    this.steps = steps;
  }

  public void addStep(Step step) {
    steps.add(step);
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getStartingUrl() {
    return startingUrl;
  }

  public void setStartingUrl(String startingUrl) {
    this.startingUrl = startingUrl;
  }

}
