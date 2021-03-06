package org.glasscube.automation.xservice.execution;

import org.glasscube.automation.model.errors.ErrorCodes;
import org.glasscube.automation.model.steps.ElementEnum;
import org.glasscube.automation.util.errors.SGXAutomationException;
import org.springframework.stereotype.Component;

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
