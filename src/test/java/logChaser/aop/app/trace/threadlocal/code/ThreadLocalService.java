package logChaser.aop.app.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalService {

    private ThreadLocal<String> nameStore = new ThreadLocal<>();

    public String logic(String name) {
        log.info("save name = {} -> nameStore= {}", name, nameStore.get());
        nameStore.set(name);
        sleep();
        log.info("search nameStore= {}", nameStore.get());
        return nameStore.get();
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
