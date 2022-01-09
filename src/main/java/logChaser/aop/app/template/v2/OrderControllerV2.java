package logChaser.aop.app.template.v2;

import logChaser.aop.app.trace.TraceStatus;
import logChaser.aop.app.trace.chaseAfter.ChaseAfterV2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV2 {

    private final OrderServiceV2 orderServiceV2;
    private final ChaseAfterV2 chaseAfterV2;

    @GetMapping("/v2/request")
    public String request(String itemId) {
        TraceStatus status = null;

        try {
            status = chaseAfterV2.begin("OrderControllerV2.request()");
            orderServiceV2.orderItem(status.getTraceId(), itemId);
            chaseAfterV2.end(status);
            return "ok";
        } catch (Exception e) {
            chaseAfterV2.exception(status, e);
            throw e;
        }
    }
}
