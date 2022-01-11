package logChaser.aop.app.proxy.config.v5_autoproxy;

import logChaser.aop.app.proxy.config.AppV1Config;
import logChaser.aop.app.proxy.config.AppV2Config;
import logChaser.aop.app.proxy.config.v3_proxyFactory.advice.LogTraceAdvice;
import logChaser.aop.app.trace.logtrace.LogTrace;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
/*
* AnnotationAwareAspectJAutoProxyCreator 빈 후처리기
*   - 포인트 컷은 생성, 사용단계에서 두번 사용된다.
*   - 생성단계: 포인트컷을 사용해서 빈이 프록시를 생성할 필요가 있는지 확인
*   - 사용단계(호출되었을 때): 부가 기능인 advice를 적용여부를 포인트컷을 보고 판단
* implementation 'org.springframework.boot:spring-boot-starter-aop' 추가
*
* */
@Configuration
@Import({AppV1Config.class, AppV2Config.class})
public class AutoProxyConfig {

    //@Bean
    public Advisor advisor1(LogTrace logTrace) {
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedNames("request*", "order*", "save*");
        LogTraceAdvice advice = new LogTraceAdvice(logTrace);

        return new DefaultPointcutAdvisor(pointcut, advice);
    }

    @Bean
    public Advisor advisor2(LogTrace logTrace) {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* logChaser.aop.app.proxy.app..*(..)) && !execution(* logChaser.aop.app.proxy.app..noLog(..))");

        LogTraceAdvice advice = new LogTraceAdvice(logTrace);
        return new DefaultPointcutAdvisor(pointcut, advice);
    }
}
