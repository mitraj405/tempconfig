package defpackage;

import java.io.IOException;
import java.io.InputStream;
import okio.Buffer;
import okio.Source;
import okio.Timeout;

/* renamed from: wn  reason: default package and case insensitive filesystem */
/* compiled from: Okio */
public final class C1463wn implements Source {
    public final /* synthetic */ InputStream a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Timeout f7036a;

    public C1463wn(InputStream inputStream, Timeout timeout) {
        this.f7036a = timeout;
        this.a = inputStream;
    }

    public final void close() throws IOException {
        this.a.close();
    }

    public final long read(Buffer buffer, long j) throws IOException {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException(C0709Uj.h("byteCount < 0: ", j));
        } else if (i == 0) {
            return 0;
        } else {
            boolean z = true;
            try {
                this.f7036a.throwIfReached();
                Ov w = buffer.w(1);
                int read = this.a.read(w.f3745a, w.b, (int) Math.min(j, (long) (8192 - w.b)));
                if (read == -1) {
                    return -1;
                }
                w.b += read;
                long j2 = (long) read;
                buffer.f5623a += j2;
                return j2;
            } catch (AssertionError e) {
                if (e.getCause() == null || e.getMessage() == null || !e.getMessage().contains("getsockname failed")) {
                    z = false;
                }
                if (z) {
                    throw new IOException(e);
                }
                throw e;
            }
        }
    }

    public final Timeout timeout() {
        return this.f7036a;
    }

    public final String toString() {
        return "source(" + this.a + ")";
    }
}
