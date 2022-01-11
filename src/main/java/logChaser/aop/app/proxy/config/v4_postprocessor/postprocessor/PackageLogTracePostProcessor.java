package logChaser.aop.app.proxy.config.v4_postprocessor.postprocessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

@Slf4j
public class PackageLogTracePostProcessor implements BeanPostProcessor {

    private final String basicPackage;
    private final Advisor advisor;

    public PackageLogTracePostProcessor(String basicPackage, Advisor advisor) {
        this.basicPackage = basicPackage;
        this.advisor = advisor;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("beanName = {}. bean = {}", beanName, bean.getClass());

        String packageName = bean.getClass().getPackageName();
        if (!packageName.startsWith(basicPackage)) {
            return bean;
        }

        ProxyFactory proxyFactory = new ProxyFactory(bean);
        proxyFactory.addAdvisor(advisor);
        log.info("create proxy: target = {}, proxy = {}", bean.getClass(), proxyFactory.getClass());

        return proxyFactory.getProxy();
    }
}
