package logChaser.aop.app.proxy.config.v1_proxy.concrete_proxy;

import logChaser.aop.app.proxy.app.v2.POrderServiceV2;
import logChaser.aop.app.trace.TraceStatus;
import logChaser.aop.app.trace.logtrace.LogTrace;


public class OrderServiceConcreteProxy extends POrderServiceV2 {

    private final POrderServiceV2 target;
    private final LogTrace logTrace;

    public OrderServiceConcreteProxy(POrderServiceV2 target,
                                     LogTrace logTrace) {
        super(null);
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public void orderItem(String itemId) {
        TraceStatus status = null;

        try {
            status = logTrace.begin("OrderServiceConcreteProxy.orderItem");
            target.orderItem(itemId);
            logTrace.end(status);

        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
