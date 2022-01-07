package logChaser.aop.app.v4;

import logChaser.aop.app.trace.logtrace.LogTrace;
import logChaser.aop.app.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {

    private final LogTrace logTrace;

    public void save(String itemId) {

        AbstractTemplate<Void> template = new AbstractTemplate<>(logTrace) {
            @Override
            protected Void call() {
                if (itemId.equals("ex")) {
                    throw new IllegalStateException("error");
                }
                sleep();
                return null;
            }
        };
        template.execute("OrderRepositoryV4.save()");


    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
