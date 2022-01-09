package logChaser.aop.app.proxy.config.v1_proxy;

import logChaser.aop.app.proxy.app.v2.POrderControllerV2;
import logChaser.aop.app.proxy.app.v2.POrderRepositoryV2;
import logChaser.aop.app.proxy.app.v2.POrderServiceV2;
import logChaser.aop.app.proxy.config.v1_proxy.concrete_proxy.OrderControllerConcreteProxy;
import logChaser.aop.app.proxy.config.v1_proxy.concrete_proxy.OrderRepositoryConcreteProxy;
import logChaser.aop.app.proxy.config.v1_proxy.concrete_proxy.OrderServiceConcreteProxy;
import logChaser.aop.app.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConcreteProxyConfig {

    @Bean
    public POrderControllerV2 orderControllerV2(LogTrace logTrace) {
        POrderControllerV2 pOrderControllerV2 = new POrderControllerV2(orderServiceV2(logTrace));
        return new OrderControllerConcreteProxy(pOrderControllerV2, logTrace);
    }

    @Bean
    public POrderServiceV2 orderServiceV2(LogTrace logTrace) {
        POrderServiceV2 pOrderServiceV2 = new POrderServiceV2(orderRepositoryV2(logTrace));
        return new OrderServiceConcreteProxy(pOrderServiceV2, logTrace);
    }

    @Bean
    public POrderRepositoryV2 orderRepositoryV2(LogTrace logTrace) {
        POrderRepositoryV2 pOrderRepositoryV2 = new POrderRepositoryV2();
        return new OrderRepositoryConcreteProxy(pOrderRepositoryV2, logTrace);
    }
}
