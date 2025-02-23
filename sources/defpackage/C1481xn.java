package defpackage;

import java.io.IOException;
import okio.Buffer;
import okio.Sink;
import okio.Timeout;

/* renamed from: xn  reason: default package and case insensitive filesystem */
/* compiled from: Okio */
public final class C1481xn implements Sink {
    public final Timeout timeout() {
        return Timeout.NONE;
    }

    public final void write(Buffer buffer, long j) throws IOException {
        buffer.d0(j);
    }

    public final void close() throws IOException {
    }

    public final void flush() throws IOException {
    }
}
