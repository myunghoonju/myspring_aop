package logChaser.aop.app.proxy.app.v1;

public class POrderControllerV1Impl implements POrderControllerV1 {

    private final POrderServiceV1 orderServiceV1;

    public POrderControllerV1Impl(POrderServiceV1 orderServiceV1) {
        this.orderServiceV1 = orderServiceV1;
    }

    @Override
    public String request(String itemId) {
        orderServiceV1.orderItem(itemId);
        return "ok";
    }

    @Override
    public String noLog() {
        return "ok";
    }
}
