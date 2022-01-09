package logChaser.aop.app.proxy.config.v1_proxy;

import logChaser.aop.app.proxy.app.v1.POrderControllerV1;
import logChaser.aop.app.proxy.app.v1.POrderControllerV1Impl;
import logChaser.aop.app.proxy.app.v1.POrderRepositoryImpl;
import logChaser.aop.app.proxy.app.v1.POrderRepositoryV1;
import logChaser.aop.app.proxy.app.v1.POrderServiceImpl;
import logChaser.aop.app.proxy.app.v1.POrderServiceV1;
import logChaser.aop.app.proxy.config.v1_proxy.interface_proxy.OrderControllerInterfaceProxy;
import logChaser.aop.app.proxy.config.v1_proxy.interface_proxy.OrderRepositoryInterfaceProxy;
import logChaser.aop.app.proxy.config.v1_proxy.interface_proxy.OrderServiceInterfaceProxy;
import logChaser.aop.app.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InterfaceProxyConfig {

    @Bean
    public POrderControllerV1 porderController(LogTrace logTrace) {
        POrderControllerV1Impl controllerImpl = new POrderControllerV1Impl(porderService(logTrace));
        return new OrderControllerInterfaceProxy(controllerImpl, logTrace);
    }

    @Bean
    public POrderServiceV1 porderService(LogTrace logTrace) {
        POrderServiceImpl serviceImpl = new POrderServiceImpl(porderRepository(logTrace));
        return new OrderServiceInterfaceProxy(serviceImpl, logTrace);
    }

    @Bean
    public POrderRepositoryV1 porderRepository(LogTrace logTrace) {
        POrderRepositoryImpl repositoryImpl = new POrderRepositoryImpl();
        return new OrderRepositoryInterfaceProxy(repositoryImpl, logTrace);
    }

}
