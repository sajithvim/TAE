package com.sgx.automation.xservice.execution;

import org.springframework.stereotype.Component;

import com.sgx.automation.model.errors.ErrorCodes;
import com.sgx.automation.model.steps.ElementEnum;
import com.sgx.automation.util.errors.SGXAutomationException;

@Component
public class ExecutionManager {

  public Executor getExecutor(ElementEnum elementType) throws SGXAutomationException {
    Executor executor = null;
    if (elementType.equals(ElementEnum.PASSWORD) || elementType.equals(ElementEnum.INBOX)) {
      executor = new TextboxExecutor();
    } else if (elementType.equals(ElementEnum.BUTTON)) {
      executor = new ButtonExecutor();
    } else if (elementType.equals(ElementEnum.LINK)) {
      executor = new HyperLinkExecutor();
    } else if (elementType.equals(ElementEnum.CONTAINER)) {
      executor = new ContainerExecutor();
    } else {
      throw new SGXAutomationException(ErrorCodes.ERROR_1001,
          "The element not supported : " + elementType);
    }
    return executor;
  }

}
