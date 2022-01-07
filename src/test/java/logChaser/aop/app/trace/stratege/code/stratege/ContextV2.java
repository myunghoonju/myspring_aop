package logChaser.aop.app.trace.stratege.code.stratege;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV2 {

    public void execute(Strategy strategy) {
        long startTime = System.currentTimeMillis();

        strategy.call(); // delegate

        long endTime = System.currentTimeMillis();
        long resultTime = startTime - endTime;
        log.info("resultTime = {}", resultTime);
    }
}
