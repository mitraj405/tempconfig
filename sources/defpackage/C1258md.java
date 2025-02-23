package defpackage;

import java.io.IOException;
import okio.Buffer;
import okio.Sink;
import okio.Timeout;

/* renamed from: md  reason: default package and case insensitive filesystem */
/* compiled from: ForwardingSink */
public abstract class C1258md implements Sink {
    private final Sink delegate;

    public C1258md(Sink sink) {
        if (sink != null) {
            this.delegate = sink;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    public final Sink delegate() {
        return this.delegate;
    }

    public void flush() throws IOException {
        this.delegate.flush();
    }

    public Timeout timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.delegate.toString() + ")";
    }

    public void write(Buffer buffer, long j) throws IOException {
        this.delegate.write(buffer, j);
    }
}
