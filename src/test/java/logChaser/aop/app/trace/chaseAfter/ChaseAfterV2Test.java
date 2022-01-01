package logChaser.aop.app.trace.chaseAfter;

import logChaser.aop.app.trace.TraceStatus;
import org.junit.jupiter.api.Test;


class ChaseAfterV2Test {

    @Test
    void end() {
        ChaseAfterV2 chaseAfterV2 = new ChaseAfterV2();
        TraceStatus status = chaseAfterV2.begin("g");
        TraceStatus status1 = chaseAfterV2.beginSync(status.getTraceId(), "g2");

        chaseAfterV2.end(status1);
        chaseAfterV2.end(status);

    }

    @Test
    void exception() {
        ChaseAfterV2 chaseAfterV2 = new ChaseAfterV2();
        TraceStatus status = chaseAfterV2.begin("g");
        TraceStatus status1 = chaseAfterV2.beginSync(status.getTraceId(), "g2");
        chaseAfterV2.exception(status1, new IllegalStateException());
        chaseAfterV2.exception(status, new IllegalStateException());
    }
}