package defpackage;

import java.io.IOException;
import java.io.OutputStream;
import okio.Buffer;
import okio.Sink;
import okio.Timeout;

/* renamed from: vn  reason: default package and case insensitive filesystem */
/* compiled from: Okio */
public final class C1445vn implements Sink {
    public final /* synthetic */ OutputStream a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Timeout f7000a;

    public C1445vn(OutputStream outputStream, Timeout timeout) {
        this.f7000a = timeout;
        this.a = outputStream;
    }

    public final void close() throws IOException {
        this.a.close();
    }

    public final void flush() throws IOException {
        this.a.flush();
    }

    public final Timeout timeout() {
        return this.f7000a;
    }

    public final String toString() {
        return "sink(" + this.a + ")";
    }

    public final void write(Buffer buffer, long j) throws IOException {
        C0663RB.a(buffer.f5623a, 0, j);
        while (j > 0) {
            this.f7000a.throwIfReached();
            Ov ov = buffer.f5624a;
            int min = (int) Math.min(j, (long) (ov.b - ov.a));
            this.a.write(ov.f3745a, ov.a, min);
            int i = ov.a + min;
            ov.a = i;
            long j2 = (long) min;
            j -= j2;
            buffer.f5623a -= j2;
            if (i == ov.b) {
                buffer.f5624a = ov.a();
                Qv.a(ov);
            }
        }
    }
}
