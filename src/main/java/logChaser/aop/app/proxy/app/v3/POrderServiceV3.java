package logChaser.aop.app.proxy.app.v3;


import logChaser.aop.app.proxy.app.v2.POrderRepositoryV2;
import org.springframework.stereotype.Service;

@Service
public class POrderServiceV3 {

    private final POrderRepositoryV2 orderRepositoryV2;

    public POrderServiceV3(POrderRepositoryV2 orderRepositoryV2) {
        this.orderRepositoryV2 = orderRepositoryV2;
    }

    public void orderItem(String itemId) {
        orderRepositoryV2.save(itemId);
    }
}
