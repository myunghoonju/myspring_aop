package logChaser.aop.app.proxy.config.v3_proxyFactory;

import logChaser.aop.app.proxy.app.v1.POrderControllerV1;
import logChaser.aop.app.proxy.app.v1.POrderControllerV1Impl;
import logChaser.aop.app.proxy.app.v1.POrderRepositoryImpl;
import logChaser.aop.app.proxy.app.v1.POrderRepositoryV1;
import logChaser.aop.app.proxy.app.v1.POrderServiceImpl;
import logChaser.aop.app.proxy.app.v1.POrderServiceV1;
import logChaser.aop.app.proxy.app.v2.POrderControllerV2;
import logChaser.aop.app.proxy.app.v2.POrderRepositoryV2;
import logChaser.aop.app.proxy.app.v2.POrderServiceV2;
import logChaser.aop.app.proxy.config.v3_proxyFactory.advice.LogTraceAdvice;
import logChaser.aop.app.trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ProxyFactoryConfigV2 {

    @Bean
    public POrderControllerV2 orderControllerV2(LogTrace logTrace) {
        POrderControllerV2 pOrderController = new POrderControllerV2(orderServiceV2(logTrace));
        ProxyFactory factory = new ProxyFactory(pOrderController);
        factory.addAdvisor(getAdvisor(logTrace));
        POrderControllerV2 proxy = (POrderControllerV2) factory.getProxy();
        log.info("proxyFactory proxy = {} target = {}", proxy.getClass(), pOrderController.getClass());

        return proxy;
    }

    @Bean
    public POrderServiceV2 orderServiceV2(LogTrace logTrace) {
        POrderServiceV2 pOrderService = new POrderServiceV2(pOrderRepositoryV2(logTrace));
        ProxyFactory factory = new ProxyFactory(pOrderService);
        factory.addAdvisor(getAdvisor(logTrace));
        POrderServiceV2 proxy = (POrderServiceV2) factory.getProxy();
        log.info("proxyFactory proxy = {} target = {}", proxy.getClass(), pOrderService.getClass());

        return proxy;
    }

    @Bean
    public POrderRepositoryV2 pOrderRepositoryV2(LogTrace logTrace) {
        POrderRepositoryV2 pOrderRepository = new POrderRepositoryV2();
        ProxyFactory factory = new ProxyFactory(pOrderRepository);
        factory.addAdvisor(getAdvisor(logTrace));
        POrderRepositoryV2 proxy = (POrderRepositoryV2) factory.getProxy();
        log.info("proxyFactory proxy = {} target = {}", proxy.getClass(), pOrderRepository.getClass());

        return proxy;
    }

    private Advisor getAdvisor(LogTrace logTrace) {
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedNames("request*", "order*", "save*");
        LogTraceAdvice advice = new LogTraceAdvice(logTrace);

        return new DefaultPointcutAdvisor(pointcut, advice);
    }
}
