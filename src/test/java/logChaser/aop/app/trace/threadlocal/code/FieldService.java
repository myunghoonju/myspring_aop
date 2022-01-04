package logChaser.aop.app.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FieldService {

    private String nameStore;

    public String logic(String name) {
        log.info("save name = {} -> nameStore= {}", name, nameStore);
        nameStore = name;
        sleep();
        log.info("search nameStore= {}", nameStore);
        return nameStore;
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
