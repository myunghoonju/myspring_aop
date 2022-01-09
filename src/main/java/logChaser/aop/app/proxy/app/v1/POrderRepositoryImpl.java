package logChaser.aop.app.proxy.app.v1;

public class POrderRepositoryImpl implements POrderRepositoryV1 {
    @Override
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
