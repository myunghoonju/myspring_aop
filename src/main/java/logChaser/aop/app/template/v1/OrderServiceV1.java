package logChaser.aop.app.template.v1;

import logChaser.aop.app.trace.TraceStatus;
import logChaser.aop.app.trace.chaseAfter.ChaseAfterV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV1 {

    private final OrderRepositoryV1 orderRepositoryV1;
    private final ChaseAfterV1 chaseAfterV1;

    public void orderItem(String itemId) {

        TraceStatus status = null;

        try {
            status = chaseAfterV1.begin("OrderServiceV1.orderItem()");
            orderRepositoryV1.save(itemId);
            chaseAfterV1.end(status);

        } catch (Exception e) {
            chaseAfterV1.exception(status, e);
            throw e;
        }
    }
}
