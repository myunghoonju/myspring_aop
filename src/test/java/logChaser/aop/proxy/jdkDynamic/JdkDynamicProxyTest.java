package logChaser.aop.proxy.jdkDynamic;

import logChaser.aop.proxy.jdkDynamic.code.AImpl;
import logChaser.aop.proxy.jdkDynamic.code.AInterface;
import logChaser.aop.proxy.jdkDynamic.code.BImpl;
import logChaser.aop.proxy.jdkDynamic.code.BInterface;
import logChaser.aop.proxy.jdkDynamic.code.TimeInvocationHandler;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

@Slf4j
public class JdkDynamicProxyTest {

    @Test
    void dynamicA() {
        AImpl target = new AImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(target);
        // new proxy!
        AInterface proxy = (AInterface) Proxy.newProxyInstance(AInterface.class.getClassLoader(), new Class[]{AInterface.class}, handler);

        proxy.call();
        log.info("targetClass = {}", target.getClass());
        log.info("proxyClass = {}", proxy.getClass());
    }

    @Test
    void dynamicB() {
        BImpl target = new BImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(target);
        // new proxy!
        BInterface proxy = (BInterface) Proxy.newProxyInstance(BInterface.class.getClassLoader(), new Class[]{BInterface.class}, handler);

        proxy.call();
        log.info("targetClass = {}", target.getClass());
        log.info("proxyClass = {}", proxy.getClass());
    }
}
