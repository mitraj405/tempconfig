package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public final class ForwardingTimeout extends Timeout {
    public Timeout a;

    public ForwardingTimeout(Timeout timeout) {
        if (timeout != null) {
            this.a = timeout;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final Timeout clearDeadline() {
        return this.a.clearDeadline();
    }

    public final Timeout clearTimeout() {
        return this.a.clearTimeout();
    }

    public final long deadlineNanoTime() {
        return this.a.deadlineNanoTime();
    }

    public final boolean hasDeadline() {
        return this.a.hasDeadline();
    }

    public final void throwIfReached() throws IOException {
        this.a.throwIfReached();
    }

    public final Timeout timeout(long j, TimeUnit timeUnit) {
        return this.a.timeout(j, timeUnit);
    }

    public final long timeoutNanos() {
        return this.a.timeoutNanos();
    }

    public final Timeout deadlineNanoTime(long j) {
        return this.a.deadlineNanoTime(j);
    }
}
