package defpackage;

import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;
import okio.Timeout;

/* renamed from: tp  reason: default package and case insensitive filesystem */
/* compiled from: PeekSource */
public final class C1411tp implements Source {
    public long a;

    /* renamed from: a  reason: collision with other field name */
    public Ov f6967a;

    /* renamed from: a  reason: collision with other field name */
    public final Buffer f6968a;

    /* renamed from: a  reason: collision with other field name */
    public final BufferedSource f6969a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6970a;
    public int c;

    public C1411tp(BufferedSource bufferedSource) {
        int i;
        this.f6969a = bufferedSource;
        Buffer d = bufferedSource.d();
        this.f6968a = d;
        Ov ov = d.f5624a;
        this.f6967a = ov;
        if (ov != null) {
            i = ov.a;
        } else {
            i = -1;
        }
        this.c = i;
    }

    public final void close() throws IOException {
        this.f6970a = true;
    }

    public final long read(Buffer buffer, long j) throws IOException {
        Ov ov;
        Ov ov2;
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException(C0709Uj.h("byteCount < 0: ", j));
        } else if (!this.f6970a) {
            Ov ov3 = this.f6967a;
            Buffer buffer2 = this.f6968a;
            if (ov3 != null && (ov3 != (ov2 = buffer2.f5624a) || this.c != ov2.a)) {
                throw new IllegalStateException("Peek source is invalid because upstream source was used");
            } else if (i == 0) {
                return 0;
            } else {
                if (!this.f6969a.S(this.a + 1)) {
                    return -1;
                }
                if (this.f6967a == null && (ov = buffer2.f5624a) != null) {
                    this.f6967a = ov;
                    this.c = ov.a;
                }
                long min = Math.min(j, buffer2.f5623a - this.a);
                this.f6968a.e(this.a, buffer, min);
                this.a += min;
                return min;
            }
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public final Timeout timeout() {
        return this.f6969a.timeout();
    }
}
