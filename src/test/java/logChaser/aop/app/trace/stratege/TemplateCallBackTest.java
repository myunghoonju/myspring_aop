package logChaser.aop.app.trace.stratege;

import logChaser.aop.app.trace.stratege.code.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallBackTest {

    @Test
    void callBackV1() {
        TimeLogTemplate timeLogTemplate = new TimeLogTemplate();
        timeLogTemplate.execute(() -> {log.info("bizz logic1 start");});
    }
}
