package logChaser.aop.app.proxy.config.v2_dynamic_proxy;

import logChaser.aop.app.proxy.app.v1.POrderControllerV1;
import logChaser.aop.app.proxy.app.v1.POrderControllerV1Impl;
import logChaser.aop.app.proxy.app.v1.POrderRepositoryImpl;
import logChaser.aop.app.proxy.app.v1.POrderRepositoryV1;
import logChaser.aop.app.proxy.app.v1.POrderServiceImpl;
import logChaser.aop.app.proxy.app.v1.POrderServiceV1;
import logChaser.aop.app.proxy.config.v2_dynamic_proxy.handler.LogTraceBasicHandler;
import logChaser.aop.app.proxy.config.v2_dynamic_proxy.handler.LogTraceFilterHandler;
import logChaser.aop.app.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Proxy;

@Configuration
public class DynamicProxyFilterConfig {

    private static final String[] PATTERNS = {"request*", "order*", "save*"};

    @Bean
    public POrderControllerV1 orderControllerV1(LogTrace logTrace) {
        POrderControllerV1 pOrderControllerV1 = new POrderControllerV1Impl(orderServiceV1(logTrace));

        return (POrderControllerV1) Proxy.newProxyInstance(
                POrderControllerV1.class.getClassLoader(),
                new Class[]{POrderControllerV1.class},
                new LogTraceFilterHandler(pOrderControllerV1, logTrace, PATTERNS));
    }

    @Bean
    public POrderServiceV1 orderServiceV1(LogTrace logTrace) {
        POrderServiceImpl pOrderService = new POrderServiceImpl(orderRepositoryV(logTrace));

        return (POrderServiceV1) Proxy.newProxyInstance(
                POrderServiceV1.class.getClassLoader(),
                new Class[]{POrderServiceV1.class},
                new LogTraceFilterHandler(pOrderService, logTrace, PATTERNS));
    }

    @Bean
    public POrderRepositoryV1 orderRepositoryV(LogTrace logTrace) {
        POrderRepositoryImpl pOrderRepository = new POrderRepositoryImpl();

        return (POrderRepositoryV1) Proxy.newProxyInstance(
                POrderRepositoryV1.class.getClassLoader(),
                new Class[]{POrderRepositoryV1.class},
                new LogTraceFilterHandler(pOrderRepository, logTrace, PATTERNS));
    }
}
