package logChaser.aop.app.proxy.config.v1_proxy.concrete_proxy;

import logChaser.aop.app.proxy.app.v2.POrderControllerV2;
import logChaser.aop.app.trace.TraceStatus;
import logChaser.aop.app.trace.logtrace.LogTrace;

public class OrderControllerConcreteProxy extends POrderControllerV2 {

    private final POrderControllerV2 target;
    private final LogTrace logTrace;

    public OrderControllerConcreteProxy(POrderControllerV2 target, LogTrace logTrace) {
        super(null);
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public String request(String itemId) {
        TraceStatus status = null;

        try {
            status = logTrace.begin("OrderControllerConcreteProxy.request");
            String result = target.request(itemId);
            logTrace.end(status);
            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }

    @Override
    public String noLog() {
        return target.noLog();
    }
}
