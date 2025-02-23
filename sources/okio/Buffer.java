package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.perf.util.Constants;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.util.logging.Logger;

public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    public static final byte[] a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: a  reason: collision with other field name */
    public long f5623a;

    /* renamed from: a  reason: collision with other field name */
    public Ov f5624a;

    public static final class UnsafeCursor implements Closeable {
        public long a = -1;

        /* renamed from: a  reason: collision with other field name */
        public Ov f5625a;

        /* renamed from: a  reason: collision with other field name */
        public Buffer f5626a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f5627a;

        /* renamed from: a  reason: collision with other field name */
        public byte[] f5628a;
        public int c = -1;
        public int d = -1;

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
            r1 = r13.f5626a;
            r2 = r1.f5623a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int a(long r14) {
            /*
                r13 = this;
                r0 = -1
                int r0 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
                if (r0 < 0) goto L_0x00a8
                okio.Buffer r1 = r13.f5626a
                long r2 = r1.f5623a
                int r4 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
                if (r4 > 0) goto L_0x00a8
                if (r0 == 0) goto L_0x009b
                if (r4 != 0) goto L_0x0014
                goto L_0x009b
            L_0x0014:
                Ov r0 = r1.f5624a
                Ov r1 = r13.f5625a
                r4 = 0
                if (r1 == 0) goto L_0x0030
                long r6 = r13.a
                int r8 = r13.c
                int r9 = r1.a
                int r8 = r8 - r9
                long r8 = (long) r8
                long r6 = r6 - r8
                int r8 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
                if (r8 <= 0) goto L_0x002b
                r2 = r6
                goto L_0x0031
            L_0x002b:
                r4 = r6
                r12 = r1
                r1 = r0
                r0 = r12
                goto L_0x0031
            L_0x0030:
                r1 = r0
            L_0x0031:
                long r6 = r2 - r14
                long r8 = r14 - r4
                int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r6 <= 0) goto L_0x0048
            L_0x0039:
                int r1 = r0.b
                int r2 = r0.a
                int r1 = r1 - r2
                long r1 = (long) r1
                long r1 = r1 + r4
                int r3 = (r14 > r1 ? 1 : (r14 == r1 ? 0 : -1))
                if (r3 < 0) goto L_0x0058
                Ov r0 = r0.f3743a
                r4 = r1
                goto L_0x0039
            L_0x0048:
                int r0 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
                if (r0 <= 0) goto L_0x0056
                Ov r1 = r1.f3746b
                int r0 = r1.b
                int r4 = r1.a
                int r0 = r0 - r4
                long r4 = (long) r0
                long r2 = r2 - r4
                goto L_0x0048
            L_0x0056:
                r0 = r1
                r4 = r2
            L_0x0058:
                boolean r1 = r13.f5627a
                if (r1 == 0) goto L_0x0086
                boolean r1 = r0.f3744a
                if (r1 == 0) goto L_0x0086
                Ov r1 = new Ov
                byte[] r2 = r0.f3745a
                java.lang.Object r2 = r2.clone()
                r7 = r2
                byte[] r7 = (byte[]) r7
                int r8 = r0.a
                int r9 = r0.b
                r10 = 0
                r11 = 1
                r6 = r1
                r6.<init>(r7, r8, r9, r10, r11)
                okio.Buffer r2 = r13.f5626a
                Ov r3 = r2.f5624a
                if (r3 != r0) goto L_0x007d
                r2.f5624a = r1
            L_0x007d:
                r0.b(r1)
                Ov r0 = r1.f3746b
                r0.a()
                r0 = r1
            L_0x0086:
                r13.f5625a = r0
                r13.a = r14
                byte[] r1 = r0.f3745a
                r13.f5628a = r1
                int r1 = r0.a
                long r14 = r14 - r4
                int r14 = (int) r14
                int r1 = r1 + r14
                r13.c = r1
                int r14 = r0.b
                r13.d = r14
                int r14 = r14 - r1
                return r14
            L_0x009b:
                r0 = 0
                r13.f5625a = r0
                r13.a = r14
                r13.f5628a = r0
                r14 = -1
                r13.c = r14
                r13.d = r14
                return r14
            L_0x00a8:
                java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
                r1 = 2
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r2 = 0
                java.lang.Long r14 = java.lang.Long.valueOf(r14)
                r1[r2] = r14
                okio.Buffer r14 = r13.f5626a
                long r14 = r14.f5623a
                java.lang.Long r14 = java.lang.Long.valueOf(r14)
                r15 = 1
                r1[r15] = r14
                java.lang.String r14 = "offset=%s > size=%s"
                java.lang.String r14 = java.lang.String.format(r14, r1)
                r0.<init>(r14)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.UnsafeCursor.a(long):int");
        }

        public final void close() {
            if (this.f5626a != null) {
                this.f5626a = null;
                this.f5625a = null;
                this.a = -1;
                this.f5628a = null;
                this.c = -1;
                this.d = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer");
        }
    }

    public class a extends InputStream {
        public a() {
        }

        public final int available() {
            return (int) Math.min(Buffer.this.f5623a, 2147483647L);
        }

        public final int read() {
            Buffer buffer = Buffer.this;
            if (buffer.f5623a > 0) {
                return buffer.readByte() & UnsignedBytes.MAX_VALUE;
            }
            return -1;
        }

        public final String toString() {
            return Buffer.this + ".inputStream()";
        }

        public final int read(byte[] bArr, int i, int i2) {
            return Buffer.this.read(bArr, i, i2);
        }

        public final void close() {
        }
    }

    public final void A(int i) {
        Ov w = w(1);
        int i2 = w.b;
        w.b = i2 + 1;
        w.f3745a[i2] = (byte) i;
        this.f5623a++;
    }

    public final As B() {
        C1411tp tpVar = new C1411tp(this);
        Logger logger = C1517zn.a;
        return new As(tpVar);
    }

    public final Buffer C(long j) {
        byte[] bArr;
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i == 0) {
            A(48);
            return this;
        }
        int i2 = 1;
        boolean z = false;
        if (i < 0) {
            j = -j;
            if (j < 0) {
                O(0, 20, "-9223372036854775808");
                return this;
            }
            z = true;
        }
        if (j < 100000000) {
            if (j < 10000) {
                if (j < 100) {
                    if (j >= 10) {
                        i2 = 2;
                    }
                } else if (j < 1000) {
                    i2 = 3;
                } else {
                    i2 = 4;
                }
            } else if (j < 1000000) {
                if (j < 100000) {
                    i2 = 5;
                } else {
                    i2 = 6;
                }
            } else if (j < 10000000) {
                i2 = 7;
            } else {
                i2 = 8;
            }
        } else if (j < 1000000000000L) {
            if (j < 10000000000L) {
                if (j < 1000000000) {
                    i2 = 9;
                } else {
                    i2 = 10;
                }
            } else if (j < 100000000000L) {
                i2 = 11;
            } else {
                i2 = 12;
            }
        } else if (j < 1000000000000000L) {
            if (j < 10000000000000L) {
                i2 = 13;
            } else if (j < 100000000000000L) {
                i2 = 14;
            } else {
                i2 = 15;
            }
        } else if (j < 100000000000000000L) {
            if (j < 10000000000000000L) {
                i2 = 16;
            } else {
                i2 = 17;
            }
        } else if (j < 1000000000000000000L) {
            i2 = 18;
        } else {
            i2 = 19;
        }
        if (z) {
            i2++;
        }
        Ov w = w(i2);
        int i3 = w.b + i2;
        while (true) {
            int i4 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            bArr = w.f3745a;
            if (i4 == 0) {
                break;
            }
            i3--;
            bArr[i3] = a[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i3 - 1] = 45;
        }
        w.b += i2;
        this.f5623a += (long) i2;
        return this;
    }

    public final String D() throws EOFException {
        return Y(Long.MAX_VALUE);
    }

    public final Buffer E(long j) {
        if (j == 0) {
            A(48);
            return this;
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        Ov w = w(numberOfTrailingZeros);
        int i = w.b;
        int i2 = i + numberOfTrailingZeros;
        while (true) {
            i2--;
            if (i2 >= i) {
                w.f3745a[i2] = a[(int) (15 & j)];
                j >>>= 4;
            } else {
                w.b += numberOfTrailingZeros;
                this.f5623a += (long) numberOfTrailingZeros;
                return this;
            }
        }
    }

    public final byte[] F() {
        try {
            return a0(this.f5623a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final void G(int i) {
        Ov w = w(4);
        int i2 = w.b;
        int i3 = i2 + 1;
        byte[] bArr = w.f3745a;
        bArr[i2] = (byte) ((i >>> 24) & Constants.MAX_HOST_LENGTH);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & Constants.MAX_HOST_LENGTH);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & Constants.MAX_HOST_LENGTH);
        bArr[i5] = (byte) (i & Constants.MAX_HOST_LENGTH);
        w.b = i5 + 1;
        this.f5623a += 4;
    }

    public final /* bridge */ /* synthetic */ BufferedSink H(byte[] bArr) throws IOException {
        write(bArr);
        return this;
    }

    public final long I(Buffer buffer) throws IOException {
        long j = this.f5623a;
        if (j > 0) {
            buffer.write(this, j);
        }
        return j;
    }

    public final void J(long j) {
        Ov w = w(8);
        int i = w.b;
        int i2 = i + 1;
        byte[] bArr = w.f3745a;
        bArr[i] = (byte) ((int) ((j >>> 56) & 255));
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 48) & 255));
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((int) ((j >>> 40) & 255));
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((int) ((j >>> 32) & 255));
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((int) ((j >>> 24) & 255));
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((int) ((j >>> 16) & 255));
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((int) ((j >>> 8) & 255));
        bArr[i8] = (byte) ((int) (j & 255));
        w.b = i8 + 1;
        this.f5623a += 8;
    }

    public final void K(long j) throws EOFException {
        if (this.f5623a < j) {
            throw new EOFException();
        }
    }

    public final void L(int i) {
        Ov w = w(2);
        int i2 = w.b;
        int i3 = i2 + 1;
        byte[] bArr = w.f3745a;
        bArr[i2] = (byte) ((i >>> 8) & Constants.MAX_HOST_LENGTH);
        bArr[i3] = (byte) (i & Constants.MAX_HOST_LENGTH);
        w.b = i3 + 1;
        this.f5623a += 2;
    }

    public final InputStream M() {
        return new a();
    }

    public final Buffer N(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalAccessError(lf.h("beginIndex < 0: ", i));
        } else if (i2 < i) {
            throw new IllegalArgumentException(lf.i("endIndex < beginIndex: ", i2, " < ", i));
        } else if (i2 > str.length()) {
            StringBuilder m = lf.m("endIndex > string.length: ", i2, " > ");
            m.append(str.length());
            throw new IllegalArgumentException(m.toString());
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(C0663RB.a)) {
            O(i, i2, str);
            return this;
        } else {
            byte[] bytes = str.substring(i, i2).getBytes(charset);
            y(0, bytes, bytes.length);
            return this;
        }
    }

    public final void O(int i, int i2, String str) {
        char c;
        char charAt;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i < 0) {
            throw new IllegalArgumentException(lf.h("beginIndex < 0: ", i));
        } else if (i2 < i) {
            throw new IllegalArgumentException(lf.i("endIndex < beginIndex: ", i2, " < ", i));
        } else if (i2 <= str.length()) {
            while (i < i2) {
                char charAt2 = str.charAt(i);
                if (charAt2 < 128) {
                    Ov w = w(1);
                    int i3 = w.b - i;
                    int min = Math.min(i2, 8192 - i3);
                    int i4 = i + 1;
                    byte[] bArr = w.f3745a;
                    bArr[i + i3] = (byte) charAt2;
                    while (true) {
                        i = i4;
                        if (i >= min || (charAt = str.charAt(i)) >= 128) {
                            int i5 = w.b;
                            int i6 = (i3 + i) - i5;
                            w.b = i5 + i6;
                            this.f5623a += (long) i6;
                        } else {
                            i4 = i + 1;
                            bArr[i + i3] = (byte) charAt;
                        }
                    }
                    int i52 = w.b;
                    int i62 = (i3 + i) - i52;
                    w.b = i52 + i62;
                    this.f5623a += (long) i62;
                } else {
                    if (charAt2 < 2048) {
                        A((charAt2 >> 6) | 192);
                        A((charAt2 & '?') | 128);
                    } else if (charAt2 < 55296 || charAt2 > 57343) {
                        A((charAt2 >> 12) | 224);
                        A(((charAt2 >> 6) & 63) | 128);
                        A((charAt2 & '?') | 128);
                    } else {
                        int i7 = i + 1;
                        if (i7 < i2) {
                            c = str.charAt(i7);
                        } else {
                            c = 0;
                        }
                        if (charAt2 > 56319 || c < 56320 || c > 57343) {
                            A(63);
                            i = i7;
                        } else {
                            int i8 = (((charAt2 & 10239) << 10) | (9215 & c)) + Ascii.MIN;
                            A((i8 >> 18) | 240);
                            A(((i8 >> 12) & 63) | 128);
                            A(((i8 >> 6) & 63) | 128);
                            A((i8 & 63) | 128);
                            i += 2;
                        }
                    }
                    i++;
                }
            }
        } else {
            StringBuilder m = lf.m("endIndex > string.length: ", i2, " > ");
            m.append(str.length());
            throw new IllegalArgumentException(m.toString());
        }
    }

    public final /* bridge */ /* synthetic */ BufferedSink P(int i, byte[] bArr, int i2) throws IOException {
        y(i, bArr, i2);
        return this;
    }

    public final void Q(int i) {
        if (i < 128) {
            A(i);
        } else if (i < 2048) {
            A((i >> 6) | 192);
            A((i & 63) | 128);
        } else if (i < 65536) {
            if (i < 55296 || i > 57343) {
                A((i >> 12) | 224);
                A(((i >> 6) & 63) | 128);
                A((i & 63) | 128);
                return;
            }
            A(63);
        } else if (i <= 1114111) {
            A((i >> 18) | 240);
            A(((i >> 12) & 63) | 128);
            A(((i >> 6) & 63) | 128);
            A((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
    }

    public final /* bridge */ /* synthetic */ BufferedSink R(ByteString byteString) throws IOException {
        z(byteString);
        return this;
    }

    public final boolean S(long j) {
        if (this.f5623a >= j) {
            return true;
        }
        return false;
    }

    public final long T(Source source) throws IOException {
        if (source != null) {
            long j = 0;
            while (true) {
                long read = source.read(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
                if (read == -1) {
                    return j;
                }
                j += read;
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0047, code lost:
        if (r1 != false) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0049, code lost:
        r0.readByte();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005b, code lost:
        throw new java.lang.NumberFormatException("Number too large: ".concat(r0.r()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0088, code lost:
        if (r9 != r10) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008a, code lost:
        r15.f5624a = r7.a();
        defpackage.Qv.a(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0094, code lost:
        r7.a = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0096, code lost:
        if (r2 != false) goto L_0x009c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0070 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long U() {
        /*
            r15 = this;
            long r0 = r15.f5623a
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x00a7
            r0 = 0
            r4 = -7
            r1 = r0
            r5 = r4
            r3 = r2
            r2 = r1
        L_0x000f:
            Ov r7 = r15.f5624a
            byte[] r8 = r7.f3745a
            int r9 = r7.a
            int r10 = r7.b
        L_0x0017:
            if (r9 >= r10) goto L_0x0088
            byte r11 = r8[r9]
            r12 = 48
            if (r11 < r12) goto L_0x005c
            r12 = 57
            if (r11 > r12) goto L_0x005c
            int r12 = 48 - r11
            r13 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r13 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r13 < 0) goto L_0x003c
            if (r13 != 0) goto L_0x0036
            long r13 = (long) r12
            int r13 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r13 >= 0) goto L_0x0036
            goto L_0x003c
        L_0x0036:
            r13 = 10
            long r3 = r3 * r13
            long r11 = (long) r12
            long r3 = r3 + r11
            goto L_0x0067
        L_0x003c:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            r0.C(r3)
            r0.A(r11)
            if (r1 != 0) goto L_0x004c
            r0.readByte()
        L_0x004c:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.String r0 = r0.r()
            java.lang.String r2 = "Number too large: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        L_0x005c:
            r12 = 45
            r13 = 1
            if (r11 != r12) goto L_0x006c
            if (r0 != 0) goto L_0x006c
            r11 = 1
            long r5 = r5 - r11
            r1 = r13
        L_0x0067:
            int r9 = r9 + 1
            int r0 = r0 + 1
            goto L_0x0017
        L_0x006c:
            if (r0 == 0) goto L_0x0070
            r2 = r13
            goto L_0x0088
        L_0x0070:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Expected leading [0-9] or '-' character but was 0x"
            r1.<init>(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r11)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0088:
            if (r9 != r10) goto L_0x0094
            Ov r8 = r7.a()
            r15.f5624a = r8
            defpackage.Qv.a(r7)
            goto L_0x0096
        L_0x0094:
            r7.a = r9
        L_0x0096:
            if (r2 != 0) goto L_0x009c
            Ov r7 = r15.f5624a
            if (r7 != 0) goto L_0x000f
        L_0x009c:
            long r5 = r15.f5623a
            long r7 = (long) r0
            long r5 = r5 - r7
            r15.f5623a = r5
            if (r1 == 0) goto L_0x00a5
            goto L_0x00a6
        L_0x00a5:
            long r3 = -r3
        L_0x00a6:
            return r3
        L_0x00a7:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.U():long");
    }

    public final /* bridge */ /* synthetic */ BufferedSink V(int i) throws IOException {
        G(i);
        return this;
    }

    public final String Y(long j) throws EOFException {
        if (j >= 0) {
            long j2 = Long.MAX_VALUE;
            if (j != Long.MAX_VALUE) {
                j2 = j + 1;
            }
            long j3 = j((byte) 10, 0, j2);
            if (j3 != -1) {
                return u(j3);
            }
            if (j2 < this.f5623a && h(j2 - 1) == 13 && h(j2) == 10) {
                return u(j2);
            }
            Buffer buffer = new Buffer();
            e(0, buffer, Math.min(32, this.f5623a));
            throw new EOFException("\\n not found: limit=" + Math.min(this.f5623a, j) + " content=" + buffer.n().o() + 8230);
        }
        throw new IllegalArgumentException(C0709Uj.h("limit < 0: ", j));
    }

    public final void a() {
        try {
            d0(this.f5623a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final byte[] a0(long j) throws EOFException {
        C0663RB.a(this.f5623a, 0, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[((int) j)];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException(C0709Uj.h("byteCount > Integer.MAX_VALUE: ", j));
    }

    /* renamed from: b */
    public final Buffer clone() {
        Buffer buffer = new Buffer();
        if (this.f5623a == 0) {
            return buffer;
        }
        Ov c = this.f5624a.c();
        buffer.f5624a = c;
        c.f3746b = c;
        c.f3743a = c;
        Ov ov = this.f5624a;
        while (true) {
            ov = ov.f3743a;
            if (ov != this.f5624a) {
                buffer.f5624a.f3746b.b(ov.c());
            } else {
                buffer.f5623a = this.f5623a;
                return buffer;
            }
        }
    }

    public final ByteString b0(long j) throws EOFException {
        return new ByteString(a0(j));
    }

    public final long c() {
        long j = this.f5623a;
        if (j == 0) {
            return 0;
        }
        Ov ov = this.f5624a.f3746b;
        int i = ov.b;
        if (i >= 8192 || !ov.f3747b) {
            return j;
        }
        return j - ((long) (i - ov.a));
    }

    public final void d0(long j) throws EOFException {
        while (j > 0) {
            Ov ov = this.f5624a;
            if (ov != null) {
                int min = (int) Math.min(j, (long) (ov.b - ov.a));
                long j2 = (long) min;
                this.f5623a -= j2;
                j -= j2;
                Ov ov2 = this.f5624a;
                int i = ov2.a + min;
                ov2.a = i;
                if (i == ov2.b) {
                    this.f5624a = ov2.a();
                    Qv.a(ov2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public final void e(long j, Buffer buffer, long j2) {
        if (buffer != null) {
            C0663RB.a(this.f5623a, j, j2);
            if (j2 != 0) {
                buffer.f5623a += j2;
                Ov ov = this.f5624a;
                while (true) {
                    long j3 = (long) (ov.b - ov.a);
                    if (j < j3) {
                        break;
                    }
                    j -= j3;
                    ov = ov.f3743a;
                }
                while (j2 > 0) {
                    Ov c = ov.c();
                    int i = (int) (((long) c.a) + j);
                    c.a = i;
                    c.b = Math.min(i + ((int) j2), c.b);
                    Ov ov2 = buffer.f5624a;
                    if (ov2 == null) {
                        c.f3746b = c;
                        c.f3743a = c;
                        buffer.f5624a = c;
                    } else {
                        ov2.f3746b.b(c);
                    }
                    j2 -= (long) (c.b - c.a);
                    ov = ov.f3743a;
                    j = 0;
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("out == null");
    }

    public final BufferedSink e0(String str) throws IOException {
        O(0, str.length(), str);
        return this;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer = (Buffer) obj;
        long j = this.f5623a;
        if (j != buffer.f5623a) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        Ov ov = this.f5624a;
        Ov ov2 = buffer.f5624a;
        int i = ov.a;
        int i2 = ov2.a;
        while (j2 < this.f5623a) {
            long min = (long) Math.min(ov.b - i, ov2.b - i2);
            int i3 = 0;
            while (((long) i3) < min) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (ov.f3745a[i] != ov2.f3745a[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == ov.b) {
                ov = ov.f3743a;
                i = ov.a;
            }
            if (i2 == ov2.b) {
                ov2 = ov2.f3743a;
                i2 = ov2.a;
            }
            j2 += min;
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ BufferedSink g(long j) throws IOException {
        E(j);
        return this;
    }

    public final /* bridge */ /* synthetic */ BufferedSink g0(long j) throws IOException {
        C(j);
        return this;
    }

    public final byte h(long j) {
        int i;
        C0663RB.a(this.f5623a, j, 1);
        long j2 = this.f5623a;
        if (j2 - j > j) {
            Ov ov = this.f5624a;
            while (true) {
                int i2 = ov.b;
                int i3 = ov.a;
                long j3 = (long) (i2 - i3);
                if (j < j3) {
                    return ov.f3745a[i3 + ((int) j)];
                }
                j -= j3;
                ov = ov.f3743a;
            }
        } else {
            long j4 = j - j2;
            Ov ov2 = this.f5624a;
            do {
                ov2 = ov2.f3746b;
                int i4 = ov2.b;
                i = ov2.a;
                j4 += (long) (i4 - i);
            } while (j4 < 0);
            return ov2.f3745a[i + ((int) j4)];
        }
    }

    public final boolean h0() {
        if (this.f5623a == 0) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        Ov ov = this.f5624a;
        if (ov == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = ov.b;
            for (int i3 = ov.a; i3 < i2; i3++) {
                i = (i * 31) + ov.f3745a[i3];
            }
            ov = ov.f3743a;
        } while (ov != this.f5624a);
        return i;
    }

    public final void i(Buffer buffer, long j) throws EOFException {
        long j2 = this.f5623a;
        if (j2 >= j) {
            buffer.write(this, j);
        } else {
            buffer.write(this, j2);
            throw new EOFException();
        }
    }

    public final boolean isOpen() {
        return true;
    }

    public final long j(byte b, long j, long j2) {
        long j3;
        Ov ov;
        long j4 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(this.f5623a), Long.valueOf(j), Long.valueOf(j2)}));
        }
        long j5 = this.f5623a;
        if (j2 > j5) {
            j3 = j5;
        } else {
            j3 = j2;
        }
        if (j == j3 || (ov = this.f5624a) == null) {
            return -1;
        }
        if (j5 - j < j) {
            while (j5 > j) {
                ov = ov.f3746b;
                j5 -= (long) (ov.b - ov.a);
            }
        } else {
            while (true) {
                long j6 = ((long) (ov.b - ov.a)) + j4;
                if (j6 >= j) {
                    break;
                }
                ov = ov.f3743a;
                j4 = j6;
            }
            j5 = j4;
        }
        long j7 = j;
        while (j5 < j3) {
            byte[] bArr = ov.f3745a;
            int min = (int) Math.min((long) ov.b, (((long) ov.a) + j3) - j5);
            for (int i = (int) ((((long) ov.a) + j7) - j5); i < min; i++) {
                if (bArr[i] == b) {
                    return ((long) (i - ov.a)) + j5;
                }
            }
            byte b2 = b;
            j5 += (long) (ov.b - ov.a);
            ov = ov.f3743a;
            j7 = j5;
        }
        return -1;
    }

    public final long j0(ByteString byteString) {
        return l(byteString, 0);
    }

    public final /* bridge */ /* synthetic */ BufferedSink k(int i) throws IOException {
        L(i);
        return this;
    }

    public final long l(ByteString byteString, long j) {
        int i;
        int i2;
        long j2 = 0;
        if (j >= 0) {
            Ov ov = this.f5624a;
            if (ov == null) {
                return -1;
            }
            long j3 = this.f5623a;
            if (j3 - j < j) {
                while (j3 > j) {
                    ov = ov.f3746b;
                    j3 -= (long) (ov.b - ov.a);
                }
            } else {
                while (true) {
                    long j4 = ((long) (ov.b - ov.a)) + j2;
                    if (j4 >= j) {
                        break;
                    }
                    ov = ov.f3743a;
                    j2 = j4;
                }
                j3 = j2;
            }
            if (byteString.A() == 2) {
                byte n = byteString.n(0);
                byte n2 = byteString.n(1);
                while (j3 < this.f5623a) {
                    byte[] bArr = ov.f3745a;
                    i = (int) ((((long) ov.a) + j) - j3);
                    int i3 = ov.b;
                    while (i < i3) {
                        byte b = bArr[i];
                        if (b == n || b == n2) {
                            i2 = ov.a;
                        } else {
                            i++;
                        }
                    }
                    j3 += (long) (ov.b - ov.a);
                    ov = ov.f3743a;
                    j = j3;
                }
                return -1;
            }
            byte[] p = byteString.p();
            while (j3 < this.f5623a) {
                byte[] bArr2 = ov.f3745a;
                int i4 = (int) ((((long) ov.a) + j) - j3);
                int i5 = ov.b;
                while (i < i5) {
                    byte b2 = bArr2[i];
                    int length = p.length;
                    int i6 = 0;
                    while (i6 < length) {
                        if (b2 == p[i6]) {
                            i2 = ov.a;
                        } else {
                            i6++;
                        }
                    }
                    i4 = i + 1;
                }
                j3 += (long) (ov.b - ov.a);
                ov = ov.f3743a;
                j = j3;
            }
            return -1;
            return ((long) (i - i2)) + j3;
        }
        throw new IllegalArgumentException("fromIndex < 0");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0080, code lost:
        if (r8 != r9) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0082, code lost:
        r14.f5624a = r6.a();
        defpackage.Qv.a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008c, code lost:
        r6.a = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x008e, code lost:
        if (r1 != false) goto L_0x0094;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0068 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long l0() {
        /*
            r14 = this;
            long r0 = r14.f5623a
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x009b
            r0 = 0
            r1 = r0
            r4 = r2
        L_0x000b:
            Ov r6 = r14.f5624a
            byte[] r7 = r6.f3745a
            int r8 = r6.a
            int r9 = r6.b
        L_0x0013:
            if (r8 >= r9) goto L_0x0080
            byte r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L_0x0022
            r11 = 57
            if (r10 > r11) goto L_0x0022
            int r11 = r10 + -48
            goto L_0x0039
        L_0x0022:
            r11 = 97
            if (r10 < r11) goto L_0x002d
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L_0x002d
            int r11 = r10 + -97
            goto L_0x0037
        L_0x002d:
            r11 = 65
            if (r10 < r11) goto L_0x0064
            r11 = 70
            if (r10 > r11) goto L_0x0064
            int r11 = r10 + -65
        L_0x0037:
            int r11 = r11 + 10
        L_0x0039:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L_0x0049
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L_0x0013
        L_0x0049:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            r0.E(r4)
            r0.A(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.String r0 = r0.r()
            java.lang.String r2 = "Number too large: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        L_0x0064:
            if (r0 == 0) goto L_0x0068
            r1 = 1
            goto L_0x0080
        L_0x0068:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.<init>(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0080:
            if (r8 != r9) goto L_0x008c
            Ov r7 = r6.a()
            r14.f5624a = r7
            defpackage.Qv.a(r6)
            goto L_0x008e
        L_0x008c:
            r6.a = r8
        L_0x008e:
            if (r1 != 0) goto L_0x0094
            Ov r6 = r14.f5624a
            if (r6 != 0) goto L_0x000b
        L_0x0094:
            long r1 = r14.f5623a
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.f5623a = r1
            return r4
        L_0x009b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.l0():long");
    }

    public final void m(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.f5626a == null) {
            unsafeCursor.f5626a = this;
            unsafeCursor.f5627a = true;
            return;
        }
        throw new IllegalStateException("already attached to a buffer");
    }

    public final ByteString n() {
        return new ByteString(F());
    }

    public final String n0(Charset charset) {
        try {
            return q(this.f5623a, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final /* bridge */ /* synthetic */ BufferedSink o(int i) throws IOException {
        A(i);
        return this;
    }

    public final int p(Options options) {
        int v = v(options, false);
        if (v == -1) {
            return -1;
        }
        try {
            d0((long) options.f5632a[v].A());
            return v;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    public final String q(long j, Charset charset) throws EOFException {
        C0663RB.a(this.f5623a, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException(C0709Uj.h("byteCount > Integer.MAX_VALUE: ", j));
        } else if (j == 0) {
            return "";
        } else {
            Ov ov = this.f5624a;
            int i = ov.a;
            if (((long) i) + j > ((long) ov.b)) {
                return new String(a0(j), charset);
            }
            String str = new String(ov.f3745a, i, (int) j, charset);
            int i2 = (int) (((long) ov.a) + j);
            ov.a = i2;
            this.f5623a -= j;
            if (i2 == ov.b) {
                this.f5624a = ov.a();
                Qv.a(ov);
            }
            return str;
        }
    }

    public final String r() {
        try {
            return q(this.f5623a, C0663RB.a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public final int read(byte[] bArr, int i, int i2) {
        C0663RB.a((long) bArr.length, (long) i, (long) i2);
        Ov ov = this.f5624a;
        if (ov == null) {
            return -1;
        }
        int min = Math.min(i2, ov.b - ov.a);
        System.arraycopy(ov.f3745a, ov.a, bArr, i, min);
        int i3 = ov.a + min;
        ov.a = i3;
        this.f5623a -= (long) min;
        if (i3 == ov.b) {
            this.f5624a = ov.a();
            Qv.a(ov);
        }
        return min;
    }

    public final byte readByte() {
        long j = this.f5623a;
        if (j != 0) {
            Ov ov = this.f5624a;
            int i = ov.a;
            int i2 = ov.b;
            int i3 = i + 1;
            byte b = ov.f3745a[i];
            this.f5623a = j - 1;
            if (i3 == i2) {
                this.f5624a = ov.a();
                Qv.a(ov);
            } else {
                ov.a = i3;
            }
            return b;
        }
        throw new IllegalStateException("size == 0");
    }

    public final void readFully(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int read = read(bArr, i, bArr.length - i);
            if (read != -1) {
                i += read;
            } else {
                throw new EOFException();
            }
        }
    }

    public final int readInt() {
        long j = this.f5623a;
        if (j >= 4) {
            Ov ov = this.f5624a;
            int i = ov.a;
            int i2 = ov.b;
            if (i2 - i < 4) {
                return ((readByte() & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | ((readByte() & UnsignedBytes.MAX_VALUE) << Ascii.DLE) | ((readByte() & UnsignedBytes.MAX_VALUE) << 8) | (readByte() & UnsignedBytes.MAX_VALUE);
            }
            int i3 = i + 1;
            byte[] bArr = ov.f3745a;
            int i4 = i3 + 1;
            byte b = ((bArr[i] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | ((bArr[i3] & UnsignedBytes.MAX_VALUE) << Ascii.DLE);
            int i5 = i4 + 1;
            byte b2 = b | ((bArr[i4] & UnsignedBytes.MAX_VALUE) << 8);
            int i6 = i5 + 1;
            byte b3 = b2 | (bArr[i5] & UnsignedBytes.MAX_VALUE);
            this.f5623a = j - 4;
            if (i6 == i2) {
                this.f5624a = ov.a();
                Qv.a(ov);
            } else {
                ov.a = i6;
            }
            return b3;
        }
        throw new IllegalStateException("size < 4: " + this.f5623a);
    }

    public final long readLong() {
        long j = this.f5623a;
        if (j >= 8) {
            Ov ov = this.f5624a;
            int i = ov.a;
            int i2 = ov.b;
            if (i2 - i < 8) {
                return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
            }
            int i3 = i + 1;
            byte[] bArr = ov.f3745a;
            int i4 = i3 + 1;
            long j2 = (((long) bArr[i3]) & 255) << 48;
            int i5 = i4 + 1;
            int i6 = i5 + 1;
            long j3 = j2 | ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i4]) & 255) << 40) | ((((long) bArr[i5]) & 255) << 32);
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            long j4 = j3 | ((((long) bArr[i6]) & 255) << 24) | ((((long) bArr[i7]) & 255) << 16);
            int i9 = i8 + 1;
            int i10 = i9 + 1;
            long j5 = j4 | ((((long) bArr[i8]) & 255) << 8) | (((long) bArr[i9]) & 255);
            this.f5623a = j - 8;
            if (i10 == i2) {
                this.f5624a = ov.a();
                Qv.a(ov);
            } else {
                ov.a = i10;
            }
            return j5;
        }
        throw new IllegalStateException("size < 8: " + this.f5623a);
    }

    public final short readShort() {
        long j = this.f5623a;
        if (j >= 2) {
            Ov ov = this.f5624a;
            int i = ov.a;
            int i2 = ov.b;
            if (i2 - i < 2) {
                return (short) (((readByte() & UnsignedBytes.MAX_VALUE) << 8) | (readByte() & UnsignedBytes.MAX_VALUE));
            }
            int i3 = i + 1;
            byte[] bArr = ov.f3745a;
            int i4 = i3 + 1;
            byte b = ((bArr[i] & UnsignedBytes.MAX_VALUE) << 8) | (bArr[i3] & UnsignedBytes.MAX_VALUE);
            this.f5623a = j - 2;
            if (i4 == i2) {
                this.f5624a = ov.a();
                Qv.a(ov);
            } else {
                ov.a = i4;
            }
            return (short) b;
        }
        throw new IllegalStateException("size < 2: " + this.f5623a);
    }

    public final String s(long j) throws EOFException {
        return q(j, C0663RB.a);
    }

    public final int t() throws EOFException {
        byte b;
        int i;
        byte b2;
        if (this.f5623a != 0) {
            byte h = h(0);
            int i2 = 1;
            if ((h & UnsignedBytes.MAX_POWER_OF_TWO) == 0) {
                b2 = h & Ascii.DEL;
                b = 0;
                i = 1;
            } else if ((h & 224) == 192) {
                b2 = h & Ascii.US;
                i = 2;
                b = 128;
            } else if ((h & 240) == 224) {
                b2 = h & Ascii.SI;
                i = 3;
                b = Ascii.NUL;
            } else if ((h & 248) == 240) {
                b2 = h & 7;
                i = 4;
                b = Ascii.NUL;
            } else {
                d0(1);
                return 65533;
            }
            long j = (long) i;
            if (this.f5623a >= j) {
                while (i2 < i) {
                    long j2 = (long) i2;
                    byte h2 = h(j2);
                    if ((h2 & 192) == 128) {
                        b2 = (b2 << 6) | (h2 & 63);
                        i2++;
                    } else {
                        d0(j2);
                        return 65533;
                    }
                }
                d0(j);
                if (b2 > 1114111) {
                    return 65533;
                }
                if ((b2 < 55296 || b2 > 57343) && b2 >= b) {
                    return b2;
                }
                return 65533;
            }
            StringBuilder m = lf.m("size < ", i, ": ");
            m.append(this.f5623a);
            m.append(" (to read code point prefixed 0x");
            m.append(Integer.toHexString(h));
            m.append(")");
            throw new EOFException(m.toString());
        }
        throw new EOFException();
    }

    public final Timeout timeout() {
        return Timeout.NONE;
    }

    public final String toString() {
        ByteString byteString;
        long j = this.f5623a;
        if (j <= 2147483647L) {
            int i = (int) j;
            if (i == 0) {
                byteString = ByteString.a;
            } else {
                byteString = new Rv(this, i);
            }
            return byteString.toString();
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f5623a);
    }

    public final String u(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (h(j2) == 13) {
                String s = s(j2);
                d0(2);
                return s;
            }
        }
        String s2 = s(j);
        d0(1);
        return s2;
    }

    public final int v(Options options, boolean z) {
        int i;
        int i2;
        boolean z2;
        byte[] bArr;
        Ov ov;
        int i3;
        Options options2 = options;
        Ov ov2 = this.f5624a;
        int i4 = -2;
        if (ov2 != null) {
            int i5 = ov2.a;
            int i6 = ov2.b;
            int[] iArr = options2.a;
            byte[] bArr2 = ov2.f3745a;
            Ov ov3 = ov2;
            int i7 = 0;
            int i8 = -1;
            loop0:
            while (true) {
                int i9 = i7 + 1;
                int i10 = iArr[i7];
                int i11 = i9 + 1;
                int i12 = iArr[i9];
                if (i12 != -1) {
                    i8 = i12;
                }
                if (ov3 == null) {
                    break;
                }
                if (i10 < 0) {
                    int i13 = (i10 * -1) + i11;
                    while (true) {
                        int i14 = i5 + 1;
                        int i15 = i11 + 1;
                        if ((bArr2[i5] & UnsignedBytes.MAX_VALUE) != iArr[i11]) {
                            return i8;
                        }
                        if (i15 == i13) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (i14 == i6) {
                            Ov ov4 = ov3.f3743a;
                            i3 = ov4.a;
                            int i16 = ov4.b;
                            bArr = ov4.f3745a;
                            if (ov4 != ov2) {
                                int i17 = i16;
                                ov = ov4;
                                i6 = i17;
                            } else if (!z2) {
                                break loop0;
                            } else {
                                i6 = i16;
                                ov = null;
                            }
                        } else {
                            Ov ov5 = ov3;
                            bArr = bArr2;
                            i3 = i14;
                            ov = ov5;
                        }
                        if (z2) {
                            i = iArr[i15];
                            i2 = i3;
                            bArr2 = bArr;
                            ov3 = ov;
                            break;
                        }
                        i5 = i3;
                        bArr2 = bArr;
                        i11 = i15;
                        ov3 = ov;
                    }
                } else {
                    int i18 = i5 + 1;
                    byte b = bArr2[i5] & UnsignedBytes.MAX_VALUE;
                    int i19 = i11 + i10;
                    while (i11 != i19) {
                        if (b == iArr[i11]) {
                            i = iArr[i11 + i10];
                            if (i18 == i6) {
                                ov3 = ov3.f3743a;
                                i2 = ov3.a;
                                i6 = ov3.b;
                                bArr2 = ov3.f3745a;
                                if (ov3 == ov2) {
                                    ov3 = null;
                                }
                            } else {
                                i2 = i18;
                            }
                        } else {
                            i11++;
                        }
                    }
                    return i8;
                }
                if (i >= 0) {
                    return i;
                }
                i7 = -i;
                i5 = i2;
                i4 = -2;
            }
            if (z) {
                return i4;
            }
            return i8;
        } else if (z) {
            return -2;
        } else {
            return options2.indexOf(ByteString.a);
        }
    }

    public final Ov w(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        }
        Ov ov = this.f5624a;
        if (ov == null) {
            Ov b = Qv.b();
            this.f5624a = b;
            b.f3746b = b;
            b.f3743a = b;
            return b;
        }
        Ov ov2 = ov.f3746b;
        if (ov2.b + i <= 8192 && ov2.f3747b) {
            return ov2;
        }
        Ov b2 = Qv.b();
        ov2.b(b2);
        return b2;
    }

    public final void write(byte[] bArr) {
        if (bArr != null) {
            y(0, bArr, bArr.length);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    public final void y(int i, byte[] bArr, int i2) {
        if (bArr != null) {
            long j = (long) i2;
            C0663RB.a((long) bArr.length, (long) i, j);
            int i3 = i2 + i;
            while (i < i3) {
                Ov w = w(1);
                int min = Math.min(i3 - i, 8192 - w.b);
                System.arraycopy(bArr, i, w.f3745a, w.b, min);
                i += min;
                w.b += min;
            }
            this.f5623a += j;
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    public final void z(ByteString byteString) {
        if (byteString != null) {
            byteString.F(this);
            return;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    public final int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i = remaining;
            while (i > 0) {
                Ov w = w(1);
                int min = Math.min(i, 8192 - w.b);
                byteBuffer.get(w.f3745a, w.b, min);
                i -= min;
                w.b += min;
            }
            this.f5623a += (long) remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    public final int read(ByteBuffer byteBuffer) throws IOException {
        Ov ov = this.f5624a;
        if (ov == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), ov.b - ov.a);
        byteBuffer.put(ov.f3745a, ov.a, min);
        int i = ov.a + min;
        ov.a = i;
        this.f5623a -= (long) min;
        if (i == ov.b) {
            this.f5624a = ov.a();
            Qv.a(ov);
        }
        return min;
    }

    public final void write(Buffer buffer, long j) {
        Ov ov;
        int i;
        if (buffer == null) {
            throw new IllegalArgumentException("source == null");
        } else if (buffer != this) {
            C0663RB.a(buffer.f5623a, 0, j);
            while (j > 0) {
                Ov ov2 = buffer.f5624a;
                int i2 = ov2.b - ov2.a;
                int i3 = 0;
                if (j < ((long) i2)) {
                    Ov ov3 = this.f5624a;
                    Ov ov4 = ov3 != null ? ov3.f3746b : null;
                    if (ov4 != null && ov4.f3747b) {
                        long j2 = ((long) ov4.b) + j;
                        if (ov4.f3744a) {
                            i = 0;
                        } else {
                            i = ov4.a;
                        }
                        if (j2 - ((long) i) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                            ov2.d(ov4, (int) j);
                            buffer.f5623a -= j;
                            this.f5623a += j;
                            return;
                        }
                    }
                    int i4 = (int) j;
                    if (i4 <= 0 || i4 > i2) {
                        throw new IllegalArgumentException();
                    }
                    if (i4 >= 1024) {
                        ov = ov2.c();
                    } else {
                        ov = Qv.b();
                        System.arraycopy(ov2.f3745a, ov2.a, ov.f3745a, 0, i4);
                    }
                    ov.b = ov.a + i4;
                    ov2.a += i4;
                    ov2.f3746b.b(ov);
                    buffer.f5624a = ov;
                }
                Ov ov5 = buffer.f5624a;
                long j3 = (long) (ov5.b - ov5.a);
                buffer.f5624a = ov5.a();
                Ov ov6 = this.f5624a;
                if (ov6 == null) {
                    this.f5624a = ov5;
                    ov5.f3746b = ov5;
                    ov5.f3743a = ov5;
                } else {
                    ov6.f3746b.b(ov5);
                    Ov ov7 = ov5.f3746b;
                    if (ov7 == ov5) {
                        throw new IllegalStateException();
                    } else if (ov7.f3747b) {
                        int i5 = ov5.b - ov5.a;
                        int i6 = 8192 - ov7.b;
                        if (!ov7.f3744a) {
                            i3 = ov7.a;
                        }
                        if (i5 <= i6 + i3) {
                            ov5.d(ov7, i5);
                            ov5.a();
                            Qv.a(ov5);
                        }
                    }
                }
                buffer.f5623a -= j3;
                this.f5623a += j3;
                j -= j3;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }

    public final long read(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j >= 0) {
            long j2 = this.f5623a;
            if (j2 == 0) {
                return -1;
            }
            if (j > j2) {
                j = j2;
            }
            buffer.write(this, j);
            return j;
        } else {
            throw new IllegalArgumentException(C0709Uj.h("byteCount < 0: ", j));
        }
    }

    public final BufferedSink c0() {
        return this;
    }

    public final void close() {
    }

    public final Buffer d() {
        return this;
    }

    public final void flush() {
    }

    public final BufferedSink k0() throws IOException {
        return this;
    }

    public final Buffer x() {
        return this;
    }
}
