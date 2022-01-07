package logChaser.aop.app.trace.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubClassLogic2 extends AbstractTemplate {

    @Override
    protected void call() {
      log.info("bizz logic2 start");
    }
}
