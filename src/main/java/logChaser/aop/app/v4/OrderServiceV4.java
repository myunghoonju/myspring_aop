package logChaser.aop.app.v4;

import logChaser.aop.app.trace.TraceStatus;
import logChaser.aop.app.trace.logtrace.LogTrace;
import logChaser.aop.app.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {

    private final OrderRepositoryV4 orderRepositoryV2;
    private final LogTrace logTrace;

    public void orderItem(String itemId) {

        AbstractTemplate<Void> template = new AbstractTemplate<>(logTrace) {
            @Override
            protected Void call() {
                orderRepositoryV2.save(itemId);
                return null;
            }
        };
        template.execute("OrderServiceV4.orderItem()");

    }
}
