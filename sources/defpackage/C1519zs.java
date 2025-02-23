package defpackage;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* renamed from: zs  reason: default package and case insensitive filesystem */
/* compiled from: RealBufferedSink */
public final class C1519zs implements BufferedSink {
    public final Buffer a = new Buffer();

    /* renamed from: a  reason: collision with other field name */
    public final Sink f7109a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f7110a;

    public C1519zs(Sink sink) {
        if (sink != null) {
            this.f7109a = sink;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    public final BufferedSink H(byte[] bArr) throws IOException {
        if (!this.f7110a) {
            this.a.write(bArr);
            k0();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public final BufferedSink P(int i, byte[] bArr, int i2) throws IOException {
        if (!this.f7110a) {
            this.a.y(i, bArr, i2);
            k0();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public final BufferedSink R(ByteString byteString) throws IOException {
        if (!this.f7110a) {
            this.a.z(byteString);
            k0();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public final long T(Source source) throws IOException {
        long j = 0;
        while (true) {
            long read = ((C1463wn) source).read(this.a, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (read == -1) {
                return j;
            }
            j += read;
            k0();
        }
    }

    public final BufferedSink V(int i) throws IOException {
        if (!this.f7110a) {
            this.a.G(i);
            k0();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public final BufferedSink c0() throws IOException {
        if (!this.f7110a) {
            Buffer buffer = this.a;
            long j = buffer.f5623a;
            if (j > 0) {
                this.f7109a.write(buffer, j);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public final void close() throws IOException {
        Sink sink = this.f7109a;
        if (!this.f7110a) {
            try {
                Buffer buffer = this.a;
                long j = buffer.f5623a;
                if (j > 0) {
                    sink.write(buffer, j);
                }
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                sink.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
            this.f7110a = true;
            if (th != null) {
                Charset charset = C0663RB.a;
                throw th;
            }
        }
    }

    public final Buffer d() {
        return this.a;
    }

    public final BufferedSink e0(String str) throws IOException {
        if (!this.f7110a) {
            Buffer buffer = this.a;
            buffer.getClass();
            buffer.O(0, str.length(), str);
            k0();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public final void flush() throws IOException {
        if (!this.f7110a) {
            Buffer buffer = this.a;
            long j = buffer.f5623a;
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            Sink sink = this.f7109a;
            if (i > 0) {
                sink.write(buffer, j);
            }
            sink.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public final BufferedSink g(long j) throws IOException {
        if (!this.f7110a) {
            this.a.E(j);
            k0();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public final BufferedSink g0(long j) throws IOException {
        if (!this.f7110a) {
            this.a.C(j);
            k0();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public final boolean isOpen() {
        return !this.f7110a;
    }

    public final BufferedSink k(int i) throws IOException {
        if (!this.f7110a) {
            this.a.L(i);
            k0();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public final BufferedSink k0() throws IOException {
        if (!this.f7110a) {
            Buffer buffer = this.a;
            long c = buffer.c();
            if (c > 0) {
                this.f7109a.write(buffer, c);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public final BufferedSink o(int i) throws IOException {
        if (!this.f7110a) {
            this.a.A(i);
            k0();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public final Timeout timeout() {
        return this.f7109a.timeout();
    }

    public final String toString() {
        return "buffer(" + this.f7109a + ")";
    }

    public final void write(Buffer buffer, long j) throws IOException {
        if (!this.f7110a) {
            this.a.write(buffer, j);
            k0();
            return;
        }
        throw new IllegalStateException("closed");
    }

    public final int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.f7110a) {
            int write = this.a.write(byteBuffer);
            k0();
            return write;
        }
        throw new IllegalStateException("closed");
    }
}
