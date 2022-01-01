package logChaser.aop.app.v1;

import logChaser.aop.app.trace.TraceStatus;
import logChaser.aop.app.trace.chaseAfter.ChaseAfterV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV1 {

    private final ChaseAfterV1 chaseAfterV1;

    public void save(String itemId) {

        TraceStatus status = null;

        try {
            status = chaseAfterV1.begin("OrderRepositoryV1.save()");
            if (itemId.equals("ex")) {
                throw new IllegalStateException("error");
            }
            sleep();
            chaseAfterV1.end(status);

        } catch (Exception e) {
            chaseAfterV1.exception(status, e);
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
