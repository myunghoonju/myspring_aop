package logChaser.aop.app.template.v2;

import logChaser.aop.app.trace.TraceId;
import logChaser.aop.app.trace.TraceStatus;
import logChaser.aop.app.trace.chaseAfter.ChaseAfterV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {

    private final ChaseAfterV2 chaseAfterV2;

    public void save(TraceId traceId, String itemId) {

        TraceStatus status = null;

        try {
            status = chaseAfterV2.beginSync(traceId, "OrderRepositoryV2.save()");
            if (itemId.equals("ex")) {
                throw new IllegalStateException("error");
            }
            sleep();
            chaseAfterV2.end(status);

        } catch (Exception e) {
            chaseAfterV2.exception(status, e);
            throw e;
        }
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
