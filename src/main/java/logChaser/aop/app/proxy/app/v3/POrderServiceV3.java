package logChaser.aop.app.proxy.app.v3;

import org.springframework.stereotype.Service;

@Service
public class POrderServiceV3 {

    private final POrderRepositoryV3 orderRepositoryV3;

    public POrderServiceV3(POrderRepositoryV3 orderRepositoryV3) {
        this.orderRepositoryV3 = orderRepositoryV3;
    }

    public void orderItem(String itemId) {
        orderRepositoryV3.save(itemId);
    }
}
