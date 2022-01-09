package logChaser.aop.proxy.jdkDynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

@Slf4j
public class ReflectionTest {

    @Test
    void reflection0() {
        Hello target = new Hello();
        log.info("1 start");
        String result1 = target.callA();
        log.info("result1 = {}", result1);

        log.info("2 start");
        String result2 = target.callB();
        log.info("result2 = {}", result2);
    }

    @Test
    void reflection1() throws Exception {
        Class classHello = Class.forName("logChaser.aop.proxy.jdkDynamic.ReflectionTest$Hello");

        Hello target = new Hello();

        Method callA = classHello.getMethod("callA");
        Object result1 = callA.invoke(target);
        log.info("result1 = {}", result1);

        Method callB = classHello.getMethod("callB");
        Object result2 = callB.invoke(target);
        log.info("result2 = {}", result2);
    }

    @Test
    void reflection2() throws Exception {
        Class classHello = Class.forName("logChaser.aop.proxy.jdkDynamic.ReflectionTest$Hello");
        Hello target = new Hello();
        Method callA = classHello.getMethod("callA");
        Method callB = classHello.getMethod("callB");

        dynamicCall(callA, target);
        dynamicCall(callB, target);
    }

    private void dynamicCall(Method method, Object target) throws Exception {
        log.info("dynamicCall start");
        Object result = method.invoke(target);
        log.info("result = {}", result);
    }

    static class Hello {
        public String callA() {
            log.info("callA");
            return "A";
        }

        public String callB() {
            log.info("callB");
            return "B";
        }
    }
}
