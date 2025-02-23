package defpackage;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.common.primitives.UnsignedBytes;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;
import okio.Source;
import okio.Timeout;

/* renamed from: As  reason: default package */
/* compiled from: RealBufferedSource */
public final class As implements BufferedSource {
    public final Buffer a = new Buffer();

    /* renamed from: a  reason: collision with other field name */
    public final Source f3524a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f3525a;

    public As(Source source) {
        if (source != null) {
            this.f3524a = source;
            return;
        }
        throw new NullPointerException("source == null");
    }

    public final As B() {
        return new As(new C1411tp(this));
    }

    public final String D() throws IOException {
        return Y(Long.MAX_VALUE);
    }

    public final byte[] F() throws IOException {
        Source source = this.f3524a;
        Buffer buffer = this.a;
        buffer.T(source);
        return buffer.F();
    }

    public final long I(Buffer buffer) throws IOException {
        Buffer buffer2;
        long j = 0;
        while (true) {
            Source source = this.f3524a;
            buffer2 = this.a;
            if (source.read(buffer2, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                break;
            }
            long c = buffer2.c();
            if (c > 0) {
                j += c;
                buffer.write(buffer2, c);
            }
        }
        long j2 = buffer2.f5623a;
        if (j2 <= 0) {
            return j;
        }
        long j3 = j + j2;
        buffer.write(buffer2, j2);
        return j3;
    }

    public final void K(long j) throws IOException {
        if (!S(j)) {
            throw new EOFException();
        }
    }

    public final InputStream M() {
        return new a();
    }

    public final boolean S(long j) throws IOException {
        Buffer buffer;
        if (j < 0) {
            throw new IllegalArgumentException(C0709Uj.h("byteCount < 0: ", j));
        } else if (!this.f3525a) {
            do {
                buffer = this.a;
                if (buffer.f5623a >= j) {
                    return true;
                }
            } while (this.f3524a.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
            return false;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long U() throws java.io.IOException {
        /*
            r7 = this;
            r0 = 1
            r7.K(r0)
            r0 = 0
            r1 = r0
        L_0x0007:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r7.S(r3)
            okio.Buffer r4 = r7.a
            if (r3 == 0) goto L_0x0040
            long r5 = (long) r1
            byte r3 = r4.h(r5)
            r5 = 48
            if (r3 < r5) goto L_0x001f
            r5 = 57
            if (r3 <= r5) goto L_0x0026
        L_0x001f:
            if (r1 != 0) goto L_0x0028
            r5 = 45
            if (r3 == r5) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r1 = r2
            goto L_0x0007
        L_0x0028:
            if (r1 == 0) goto L_0x002b
            goto L_0x0040
        L_0x002b:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
            r2[r0] = r3
            java.lang.String r0 = "Expected leading [0-9] or '-' character but was %#x"
            java.lang.String r0 = java.lang.String.format(r0, r2)
            r1.<init>(r0)
            throw r1
        L_0x0040:
            long r0 = r4.U()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.As.U():long");
    }

    public final String Y(long j) throws IOException {
        long j2;
        long j3 = j;
        if (j3 >= 0) {
            if (j3 == Long.MAX_VALUE) {
                j2 = Long.MAX_VALUE;
            } else {
                j2 = j3 + 1;
            }
            long a2 = a((byte) 10, 0, j2);
            int i = (a2 > -1 ? 1 : (a2 == -1 ? 0 : -1));
            Buffer buffer = this.a;
            if (i != 0) {
                return buffer.u(a2);
            }
            if (j2 < Long.MAX_VALUE && S(j2) && buffer.h(j2 - 1) == 13 && S(1 + j2) && buffer.h(j2) == 10) {
                return buffer.u(j2);
            }
            Buffer buffer2 = new Buffer();
            buffer.e(0, buffer2, Math.min(32, buffer.f5623a));
            throw new EOFException("\\n not found: limit=" + Math.min(buffer.f5623a, j3) + " content=" + buffer2.n().o() + 8230);
        }
        throw new IllegalArgumentException(C0709Uj.h("limit < 0: ", j3));
    }

    public final long a(byte b, long j, long j2) throws IOException {
        if (!this.f3525a) {
            long j3 = 0;
            if (j2 >= 0) {
                while (j3 < j2) {
                    long j4 = this.a.j(b, j3, j2);
                    if (j4 == -1) {
                        Buffer buffer = this.a;
                        long j5 = buffer.f5623a;
                        if (j5 >= j2 || this.f3524a.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                            break;
                        }
                        j3 = Math.max(j3, j5);
                    } else {
                        return j4;
                    }
                }
                return -1;
            }
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[]{0L, Long.valueOf(j2)}));
        }
        throw new IllegalStateException("closed");
    }

    public final byte[] a0(long j) throws IOException {
        K(j);
        return this.a.a0(j);
    }

    public final ByteString b0(long j) throws IOException {
        K(j);
        return this.a.b0(j);
    }

    public final void close() throws IOException {
        if (!this.f3525a) {
            this.f3525a = true;
            this.f3524a.close();
            this.a.a();
        }
    }

    public final Buffer d() {
        return this.a;
    }

    public final void d0(long j) throws IOException {
        if (!this.f3525a) {
            while (j > 0) {
                Buffer buffer = this.a;
                if (buffer.f5623a == 0 && this.f3524a.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j, buffer.f5623a);
                buffer.d0(min);
                j -= min;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }

    public final boolean h0() throws IOException {
        if (!this.f3525a) {
            Buffer buffer = this.a;
            if (!buffer.h0() || this.f3524a.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
                return false;
            }
            return true;
        }
        throw new IllegalStateException("closed");
    }

    public final void i(Buffer buffer, long j) throws IOException {
        Buffer buffer2 = this.a;
        try {
            K(j);
            buffer2.i(buffer, j);
        } catch (EOFException e) {
            buffer.T(buffer2);
            throw e;
        }
    }

    public final boolean isOpen() {
        return !this.f3525a;
    }

    public final long j0(ByteString byteString) throws IOException {
        if (!this.f3525a) {
            long j = 0;
            while (true) {
                Buffer buffer = this.a;
                long l = buffer.l(byteString, j);
                if (l != -1) {
                    return l;
                }
                long j2 = buffer.f5623a;
                if (this.f3524a.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                j = Math.max(j, j2);
            }
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public final long l0() throws IOException {
        Buffer buffer;
        K(1);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            boolean S = S((long) i2);
            buffer = this.a;
            if (!S) {
                break;
            }
            byte h = buffer.h((long) i);
            if ((h >= 48 && h <= 57) || ((h >= 97 && h <= 102) || (h >= 65 && h <= 70))) {
                i = i2;
            } else if (i == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(h)}));
            }
        }
        return buffer.l0();
    }

    public final String n0(Charset charset) throws IOException {
        if (charset != null) {
            Source source = this.f3524a;
            Buffer buffer = this.a;
            buffer.T(source);
            return buffer.n0(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public final int p(Options options) throws IOException {
        Buffer buffer;
        if (!this.f3525a) {
            do {
                buffer = this.a;
                int v = buffer.v(options, true);
                if (v == -1) {
                    return -1;
                }
                if (v != -2) {
                    buffer.d0((long) options.f5632a[v].A());
                    return v;
                }
            } while (this.f3524a.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
            return -1;
        }
        throw new IllegalStateException("closed");
    }

    public final long read(Buffer buffer, long j) throws IOException {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException(C0709Uj.h("byteCount < 0: ", j));
        } else if (!this.f3525a) {
            Buffer buffer2 = this.a;
            if (buffer2.f5623a == 0 && this.f3524a.read(buffer2, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1;
            }
            return buffer2.read(buffer, Math.min(j, buffer2.f5623a));
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public final byte readByte() throws IOException {
        K(1);
        return this.a.readByte();
    }

    public final void readFully(byte[] bArr) throws IOException {
        Buffer buffer = this.a;
        try {
            K((long) bArr.length);
            buffer.readFully(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (true) {
                long j = buffer.f5623a;
                if (j > 0) {
                    int read = buffer.read(bArr, i, (int) j);
                    if (read != -1) {
                        i += read;
                    } else {
                        throw new AssertionError();
                    }
                } else {
                    throw e;
                }
            }
        }
    }

    public final int readInt() throws IOException {
        K(4);
        return this.a.readInt();
    }

    public final long readLong() throws IOException {
        K(8);
        return this.a.readLong();
    }

    public final short readShort() throws IOException {
        K(2);
        return this.a.readShort();
    }

    public final Timeout timeout() {
        return this.f3524a.timeout();
    }

    public final String toString() {
        return "buffer(" + this.f3524a + ")";
    }

    public final Buffer x() {
        return this.a;
    }

    /* renamed from: As$a */
    /* compiled from: RealBufferedSource */
    public class a extends InputStream {
        public a() {
        }

        public final int available() throws IOException {
            As as = As.this;
            if (!as.f3525a) {
                return (int) Math.min(as.a.f5623a, 2147483647L);
            }
            throw new IOException("closed");
        }

        public final void close() throws IOException {
            As.this.close();
        }

        public final int read() throws IOException {
            As as = As.this;
            if (!as.f3525a) {
                Buffer buffer = as.a;
                if (buffer.f5623a == 0 && as.f3524a.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                return as.a.readByte() & UnsignedBytes.MAX_VALUE;
            }
            throw new IOException("closed");
        }

        public final String toString() {
            return As.this + ".inputStream()";
        }

        public final int read(byte[] bArr, int i, int i2) throws IOException {
            As as = As.this;
            if (!as.f3525a) {
                C0663RB.a((long) bArr.length, (long) i, (long) i2);
                Buffer buffer = as.a;
                if (buffer.f5623a == 0 && as.f3524a.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                return as.a.read(bArr, i, i2);
            }
            throw new IOException("closed");
        }
    }

    public final int read(ByteBuffer byteBuffer) throws IOException {
        Buffer buffer = this.a;
        if (buffer.f5623a == 0 && this.f3524a.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return buffer.read(byteBuffer);
    }
}
