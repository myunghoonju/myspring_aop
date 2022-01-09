package logChaser.aop.proxy.pureproxy.concreteproxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeProxy extends ConcreteLogic {

    private ConcreteLogic target;

    public TimeProxy(ConcreteLogic target) {
        this.target = target;
    }

    @Override
    public String operation() {
      log.info("start TimeProxy");
      log.info("call TimeDecorator");
      long startTime = System.currentTimeMillis();
      String result = target.operation();
      long endTime = System.currentTimeMillis();
      long resultTime = endTime - startTime;
      log.info("End TimeDecorator = resultTime = {} ms", resultTime);

      return result;
    }
}
