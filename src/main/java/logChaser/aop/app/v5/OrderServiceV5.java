package logChaser.aop.app.v5;

import logChaser.aop.app.trace.callback.TraceTemplate;
import logChaser.aop.app.trace.logtrace.LogTrace;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV5 {

    private final OrderRepositoryV5 orderRepositoryV5;
    private final TraceTemplate template;

    public OrderServiceV5(OrderRepositoryV5 orderRepositoryV5, LogTrace logTrace) {
        this.orderRepositoryV5 = orderRepositoryV5;
        this.template = new TraceTemplate(logTrace);
    }

    public void orderItem(String itemId) {
        template.execute("OrderServiceV5.orderItem()", () -> {
            orderRepositoryV5.save(itemId);
            return null;
        });
    }
}
