package logChaser.aop.app.proxy.config.v3_proxyFactory;

import logChaser.aop.app.proxy.app.v1.POrderControllerV1;
import logChaser.aop.app.proxy.app.v1.POrderControllerV1Impl;
import logChaser.aop.app.proxy.app.v1.POrderRepositoryImpl;
import logChaser.aop.app.proxy.app.v1.POrderRepositoryV1;
import logChaser.aop.app.proxy.app.v1.POrderServiceImpl;
import logChaser.aop.app.proxy.app.v1.POrderServiceV1;
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
public class ProxyFactoryConfigV1 {

    @Bean
    public POrderControllerV1 orderControllerV1(LogTrace logTrace) {
        POrderControllerV1Impl pOrderController = new POrderControllerV1Impl(orderServiceV1(logTrace));
        ProxyFactory factory = new ProxyFactory(pOrderController);
        factory.addAdvisor(getAdvisor(logTrace));
        POrderControllerV1 proxy = (POrderControllerV1) factory.getProxy();
        log.info("proxyFactory proxy = {} target = {}", proxy.getClass(), pOrderController.getClass());

        return proxy;
    }

    @Bean
    public POrderServiceV1 orderServiceV1(LogTrace logTrace) {
        POrderServiceImpl pOrderService = new POrderServiceImpl(pOrderRepositoryV1(logTrace));
        ProxyFactory factory = new ProxyFactory(pOrderService);
        factory.addAdvisor(getAdvisor(logTrace));
        POrderServiceV1 proxy = (POrderServiceV1) factory.getProxy();
        log.info("proxyFactory proxy = {} target = {}", proxy.getClass(), pOrderService.getClass());

        return proxy;
    }

    @Bean
    public POrderRepositoryV1 pOrderRepositoryV1(LogTrace logTrace) {
        POrderRepositoryImpl pOrderRepository = new POrderRepositoryImpl();
        ProxyFactory factory = new ProxyFactory(pOrderRepository);
        factory.addAdvisor(getAdvisor(logTrace));
        POrderRepositoryV1 proxy = (POrderRepositoryV1) factory.getProxy();
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
