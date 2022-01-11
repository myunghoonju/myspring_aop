package logChaser.aop.app.proxy.app.v2;

public class POrderServiceV2 {

    private final POrderRepositoryV2 orderRepositoryV2;

    public POrderServiceV2(POrderRepositoryV2 orderRepositoryV2) {
        this.orderRepositoryV2 = orderRepositoryV2;
    }

    public void orderItem(String itemId) {
        orderRepositoryV2.save(itemId);
    }
}
