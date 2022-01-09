package logChaser.aop.app.template.v5;

import logChaser.aop.app.trace.callback.TraceTemplate;
import logChaser.aop.app.trace.logtrace.LogTrace;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryV5 {

    private final TraceTemplate template;

    public OrderRepositoryV5(LogTrace logTrace) {
        this.template = new TraceTemplate(logTrace);
    }

    public void save(String itemId) {
        template.execute("OrderRepositoryV5.save()", () -> {
            if (itemId.equals("ex")) {
                throw new IllegalStateException("error");
            }
            sleep();
            return null;
        });
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
