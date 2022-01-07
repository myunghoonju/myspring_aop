package logChaser.aop.app.trace.stratege.code.stratege;

import lombok.extern.slf4j.Slf4j;

/**
 * save strategy in field
 */
@Slf4j
public class ContextV1 {

    private Strategy strategy;

    public ContextV1(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        long startTime = System.currentTimeMillis();

        strategy.call(); // delegate

        long endTime = System.currentTimeMillis();
        long resultTime = startTime - endTime;
        log.info("resultTime = {}", resultTime);
    }
}
