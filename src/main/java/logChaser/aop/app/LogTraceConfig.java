package logChaser.aop.app;

import logChaser.aop.app.trace.logtrace.FieldLogTrace;
import logChaser.aop.app.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
        return new FieldLogTrace();
    }
}
