package logChaser.aop.app.template.v5;

import logChaser.aop.app.trace.callback.TraceTemplate;
import logChaser.aop.app.trace.logtrace.LogTrace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class OrderControllerV5 {

    private final OrderServiceV5 orderServiceV5;
    private final TraceTemplate template;

    public OrderControllerV5(OrderServiceV5 orderServiceV5, LogTrace logTrace) {
        this.orderServiceV5 = orderServiceV5;
        this.template = new TraceTemplate(logTrace);
    }

    @GetMapping("/v5/request")
    public String request(String itemId) {
        return template.execute("orderServiceV5.request()", () -> {
            orderServiceV5.orderItem(itemId);
            return "ok";
        });
    }
}
