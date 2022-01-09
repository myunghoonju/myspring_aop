package logChaser.aop.app.proxy.app.v1;


public class POrderServiceImpl implements POrderServiceV1 {


    private final POrderRepositoryV1 orderRepositoryV1;

    public POrderServiceImpl(POrderRepositoryV1 orderRepositoryV1) {
        this.orderRepositoryV1 = orderRepositoryV1;
    }

    @Override
    public void orderItem(String itemId) {
        orderRepositoryV1.save(itemId);
    }
}
