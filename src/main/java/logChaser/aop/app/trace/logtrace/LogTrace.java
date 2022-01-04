package logChaser.aop.app.trace.logtrace;

import logChaser.aop.app.trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);

    void end(TraceStatus status);

    void exception(TraceStatus status, Exception e);
}
