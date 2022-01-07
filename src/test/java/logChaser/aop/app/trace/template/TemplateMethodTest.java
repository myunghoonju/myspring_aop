package logChaser.aop.app.trace.template;

import logChaser.aop.app.trace.template.code.AbstractTemplate;
import logChaser.aop.app.trace.template.code.SubClassLogic1;
import logChaser.aop.app.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

    @Test
    void templateMethodV0() {
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        log.info("bizz logic1 start");
        long endTime = System.currentTimeMillis();
        long resultTime = startTime - endTime;
        log.info("resultTime = {}", resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        log.info("bizz logic2 start");
        long endTime = System.currentTimeMillis();
        long resultTime = startTime - endTime;
        log.info("resultTime = {}", resultTime);
    }

    @Test
    void templateMethodV1() {
        AbstractTemplate template1 = new SubClassLogic1();
        template1.execute();
        AbstractTemplate template2 = new SubClassLogic2();
        template2.execute();
    }
}
