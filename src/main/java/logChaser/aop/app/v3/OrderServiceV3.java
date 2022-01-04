package logChaser.aop.app.v3;

import logChaser.aop.app.trace.TraceStatus;
import logChaser.aop.app.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {

    private final OrderRepositoryV3 orderRepositoryV2;
    private final LogTrace logTrace;

    public void orderItem(String itemId) {

        TraceStatus status = null;

        try {
            status = logTrace.begin("OrderServiceV3.orderItem()");
            orderRepositoryV2.save(itemId);
            logTrace.end(status);

        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
