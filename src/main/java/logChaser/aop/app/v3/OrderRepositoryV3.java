package logChaser.aop.app.v3;

import logChaser.aop.app.trace.TraceStatus;
import logChaser.aop.app.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3 {

    private final LogTrace logTrace;

    public void save(String itemId) {

        TraceStatus status = null;

        try {
            status = logTrace.begin("OrderRepositoryV3.save()");
            if (itemId.equals("ex")) {
                throw new IllegalStateException("error");
            }
            sleep();
            logTrace.end(status);

        } catch (Exception e) {
            logTrace.exception(status, e);
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
