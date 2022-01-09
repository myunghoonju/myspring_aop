package logChaser.aop.app.template.v4;

import logChaser.aop.app.trace.logtrace.LogTrace;
import logChaser.aop.app.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV4 {

    private final OrderServiceV4 orderServiceV2;
    private final LogTrace logTrace;

    @GetMapping("/v4/request")
    public String request(String itemId) {
        AbstractTemplate<String> template = new AbstractTemplate<>(logTrace) {
            @Override
            protected String call() {
                orderServiceV2.orderItem(itemId);
                return "ok";
            }
        };
        return template.execute("orderServiceV2.request()");
    }
}
