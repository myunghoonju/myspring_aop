package logChaser.aop.app.trace.chaseAfter;

import logChaser.aop.app.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class ChaseAfterV1Test {

    @Test
    void end() {
        ChaseAfterV1 chaseAfterV1 = new ChaseAfterV1();
        TraceStatus status = chaseAfterV1.begin("g");
        chaseAfterV1.end(status);

    }

    @Test
    void exception() {
        ChaseAfterV1 chaseAfterV1 = new ChaseAfterV1();
        TraceStatus status = chaseAfterV1.begin("g");
        chaseAfterV1.exception(status, new IllegalStateException());
    }
}