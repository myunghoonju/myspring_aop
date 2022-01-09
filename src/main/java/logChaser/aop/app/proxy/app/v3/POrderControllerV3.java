package logChaser.aop.app.proxy.app.v3;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class POrderControllerV3 {

    private final POrderServiceV3 orderServiceV3;

    public POrderControllerV3(POrderServiceV3 orderServiceV3) {
        this.orderServiceV3 = orderServiceV3;
    }

    @GetMapping("/v3/request")
    public String request(String itemId) {
        orderServiceV3.orderItem(itemId);
        return "ok";
    }


    @GetMapping("/v3/no-log")
    public String noLog() {
        return "ok";
    }
}
