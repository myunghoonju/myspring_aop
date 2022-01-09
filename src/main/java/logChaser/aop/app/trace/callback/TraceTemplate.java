package logChaser.aop.app.trace.callback;

import logChaser.aop.app.trace.TraceStatus;
import logChaser.aop.app.trace.logtrace.LogTrace;

public class TraceTemplate {

    private final LogTrace logTrace;

    public TraceTemplate(LogTrace logTrace) {
        this.logTrace = logTrace;
    }

    public <T> T execute(String message, TraceCallBack<T> callBack) {
        TraceStatus status = null;

        try {
            status = logTrace.begin(message);

            T result = callBack.call();

            logTrace.end(status);
            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }

}
