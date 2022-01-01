package logChaser.aop.app.v2;

import logChaser.aop.app.trace.TraceId;
import logChaser.aop.app.trace.TraceStatus;
import logChaser.aop.app.trace.chaseAfter.ChaseAfterV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

    private final OrderRepositoryV2 orderRepositoryV2;
    private final ChaseAfterV2 chaseAfterV2;

    public void orderItem(TraceId traceId, String itemId) {

        TraceStatus status = null;

        try {
            status = chaseAfterV2.beginSync(traceId, "OrderServiceV2.orderItem()");
            orderRepositoryV2.save(status.getTraceId(), itemId);
            chaseAfterV2.end(status);

        } catch (Exception e) {
            chaseAfterV2.exception(status, e);
            throw e;
        }
    }
}
