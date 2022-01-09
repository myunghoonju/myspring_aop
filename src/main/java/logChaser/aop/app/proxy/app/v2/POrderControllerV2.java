package logChaser.aop.app.proxy.app.v2;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@RequestMapping
@ResponseBody
public class POrderControllerV2 {

    private final POrderServiceV2 orderServiceV2;

    public POrderControllerV2(POrderServiceV2 orderServiceV2) {
        this.orderServiceV2 = orderServiceV2;
    }

    @GetMapping("/v2/request")
    public String request(String itemId) {
        orderServiceV2.orderItem(itemId);
        return "ok";
    }


    @GetMapping("/v2/no-log")
    public String noLog() {
        return "ok";
    }
}
