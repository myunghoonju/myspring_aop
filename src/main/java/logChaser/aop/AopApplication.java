package logChaser.aop;

import logChaser.aop.app.proxy.config.AppV1Config;
import logChaser.aop.app.proxy.config.AppV2Config;
import logChaser.aop.app.proxy.config.v1_proxy.ConcreteProxyConfig;
import logChaser.aop.app.proxy.config.v1_proxy.InterfaceProxyConfig;
import logChaser.aop.app.proxy.config.v2_dynamic_proxy.DynamicProxyBasicConfig;
import logChaser.aop.app.proxy.config.v2_dynamic_proxy.DynamicProxyFilterConfig;
import logChaser.aop.app.proxy.config.v3_proxyFactory.ProxyFactoryConfigV1;
import logChaser.aop.app.proxy.config.v3_proxyFactory.ProxyFactoryConfigV2;
import logChaser.aop.app.proxy.config.v4_postprocessor.BeanPostProcessorConfig;
import logChaser.aop.app.proxy.config.v5_autoproxy.AutoProxyConfig;
import logChaser.aop.app.proxy.config.v6_aop.AopConfig;
import logChaser.aop.app.trace.logtrace.LogTrace;
import logChaser.aop.app.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import({AppV1Config.class, AppV2Config.class})
//@Import(InterfaceProxyConfig.class)
//@Import(ConcreteProxyConfig.class)
//@Import(DynamicProxyBasicConfig.class)
//@Import(DynamicProxyFilterConfig.class)
//@Import(ProxyFactoryConfigV1.class)
//@Import(ProxyFactoryConfigV2.class)
//@Import(BeanPostProcessorConfig.class)
//@Import(AutoProxyConfig.class)
@Import(AopConfig.class)
@SpringBootApplication(scanBasePackages = "logChaser.aop.app.proxy.app")
public class AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}

	@Bean
	public LogTrace logTrace() {
		return new ThreadLocalLogTrace();
	}

}
