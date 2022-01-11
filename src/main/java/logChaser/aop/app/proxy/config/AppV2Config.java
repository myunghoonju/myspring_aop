package logChaser.aop.app.proxy.config;

import logChaser.aop.app.proxy.app.v2.POrderControllerV2;
import logChaser.aop.app.proxy.app.v2.POrderRepositoryV2;
import logChaser.aop.app.proxy.app.v2.POrderServiceV2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppV2Config {

    @Bean
    public POrderControllerV2 porderControllerV2() {
        return new POrderControllerV2(porderServiceV2());
    }

    @Bean
    public POrderServiceV2 porderServiceV2() {
        return new POrderServiceV2(porderRepositoryV2());
    }

    @Bean
    public POrderRepositoryV2 porderRepositoryV2() {
        return new POrderRepositoryV2();
    }
}
