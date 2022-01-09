package logChaser.aop.app.trace.stratege.code.template;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeLogTemplate {

    public void execute(CallBack callback) {
        long startTime = System.currentTimeMillis();

        callback.call(); // delegate

        long endTime = System.currentTimeMillis();
        long resultTime = startTime - endTime;
        log.info("resultTime = {}", resultTime);
    }
}
