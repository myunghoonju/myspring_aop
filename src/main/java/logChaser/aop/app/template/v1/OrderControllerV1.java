package logChaser.aop.app.template.v1;

import logChaser.aop.app.trace.TraceStatus;
import logChaser.aop.app.trace.chaseAfter.ChaseAfterV1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV1 {

    private final OrderServiceV1 orderServiceV1;
    private final ChaseAfterV1 chaseAfterV1;

    @GetMapping("/v1/request")
    public String request(String itemId) {
        TraceStatus status = null;

        try {
            status = chaseAfterV1.begin("OrderControllerV1.request()");
            orderServiceV1.orderItem(itemId);
            chaseAfterV1.end(status);
            return "ok";
        } catch (Exception e) {
            chaseAfterV1.exception(status, e);
            throw e;
        }
    }
}
