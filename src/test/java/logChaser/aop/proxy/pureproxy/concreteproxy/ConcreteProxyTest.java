package logChaser.aop.proxy.pureproxy.concreteproxy;

import logChaser.aop.proxy.pureproxy.concreteproxy.code.ConcreteClient;
import logChaser.aop.proxy.pureproxy.concreteproxy.code.ConcreteLogic;
import logChaser.aop.proxy.pureproxy.concreteproxy.code.TimeProxy;
import org.junit.jupiter.api.Test;

public class ConcreteProxyTest {

    @Test
    void noProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteClient concreteClient = new ConcreteClient(concreteLogic);
        concreteClient.execute();
    }

    @Test
    void withProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        TimeProxy timeProxy = new TimeProxy(concreteLogic);
        ConcreteClient concreteClient = new ConcreteClient(timeProxy);
        concreteClient.execute();
    }
}
