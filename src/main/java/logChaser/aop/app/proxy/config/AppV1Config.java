package logChaser.aop.app.proxy.config;

import logChaser.aop.app.proxy.app.v1.POrderControllerV1;
import logChaser.aop.app.proxy.app.v1.POrderControllerV1Impl;
import logChaser.aop.app.proxy.app.v1.POrderRepositoryImpl;
import logChaser.aop.app.proxy.app.v1.POrderRepositoryV1;
import logChaser.aop.app.proxy.app.v1.POrderServiceImpl;
import logChaser.aop.app.proxy.app.v1.POrderServiceV1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppV1Config {

    @Bean
    public POrderControllerV1 porderControllerV1() {
        return new POrderControllerV1Impl(porderServiceV1());
    }

    @Bean
    public POrderServiceV1 porderServiceV1() {
        return new POrderServiceImpl(porderRepositoryV1());
    }

    @Bean
    public POrderRepositoryV1 porderRepositoryV1() {
        return new POrderRepositoryImpl();
    }
}
