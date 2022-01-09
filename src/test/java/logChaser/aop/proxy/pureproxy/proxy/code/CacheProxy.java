package logChaser.aop.proxy.pureproxy.proxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheProxy implements Subject {

    private Subject target;
    private String cacheVal;

    public CacheProxy(Subject target) {
        this.target = target;
    }

    @Override
    public String operation() {
        log.info("call proxy from cacheProxy.class");
        if (cacheVal == null) {
            cacheVal = target.operation();
        }

        return cacheVal;
    }
}
