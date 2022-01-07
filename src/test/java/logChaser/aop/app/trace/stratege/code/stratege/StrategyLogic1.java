package logChaser.aop.app.trace.stratege.code.stratege;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StrategyLogic1 implements Strategy {

    @Override
    public void call() {
      log.info("bizz logic1 start");
    }
}
