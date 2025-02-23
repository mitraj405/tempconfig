package defpackage;

import java.io.IOException;
import okio.Buffer;
import okio.Source;
import okio.Timeout;

/* renamed from: nd  reason: default package and case insensitive filesystem */
/* compiled from: ForwardingSource */
public abstract class C1280nd implements Source {
    private final Source delegate;

    public C1280nd(Source source) {
        if (source != null) {
            this.delegate = source;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    public final Source delegate() {
        return this.delegate;
    }

    public long read(Buffer buffer, long j) throws IOException {
        return this.delegate.read(buffer, j);
    }

    public Timeout timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.delegate.toString() + ")";
    }
}
