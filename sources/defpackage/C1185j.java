package defpackage;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: j  reason: default package and case insensitive filesystem */
/* compiled from: FlowExceptions.kt */
public final class C1185j extends CancellationException {
    public final transient FlowCollector<?> a;

    public C1185j(FlowCollector<?> flowCollector) {
        super("Flow was aborted, no more elements needed");
        this.a = flowCollector;
    }

    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
