package logChaser.aop.app.trace.stratege;

import logChaser.aop.app.trace.stratege.code.stratege.ContextV2;
import logChaser.aop.app.trace.stratege.code.stratege.StrategyLogic1;
import logChaser.aop.app.trace.stratege.code.stratege.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {
    @Test
    void strategyV1() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(new StrategyLogic1());
        contextV2.execute(new StrategyLogic2());
    }
}
