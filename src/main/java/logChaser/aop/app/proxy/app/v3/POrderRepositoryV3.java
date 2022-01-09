package logChaser.aop.app.proxy.app.v3;


import org.springframework.stereotype.Repository;

@Repository
public class POrderRepositoryV3 {

    public void save(String itemId) {
        if (itemId.equals("ex")) {
            throw new IllegalStateException("error");
        }
        sleep();
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
