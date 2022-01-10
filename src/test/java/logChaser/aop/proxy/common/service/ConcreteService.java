package logChaser.aop.proxy.common.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteService {

    public void call() {
        log.info("call ConcreteService");
    }
}