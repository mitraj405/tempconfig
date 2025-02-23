package defpackage;

import com.google.firebase.perf.util.Constants;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.logging.Logger;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import okio.Buffer;
import okio.Source;
import okio.Timeout;

/* renamed from: Ke  reason: default package and case insensitive filesystem */
/* compiled from: GzipSource */
public final class C0567Ke implements Source {
    public final As a;

    /* renamed from: a  reason: collision with other field name */
    public final C0653Qf f3689a;

    /* renamed from: a  reason: collision with other field name */
    public final CRC32 f3690a = new CRC32();

    /* renamed from: a  reason: collision with other field name */
    public final Inflater f3691a;
    public int c = 0;

    public C0567Ke(Source source) {
        if (source != null) {
            Inflater inflater = new Inflater(true);
            this.f3691a = inflater;
            Logger logger = C1517zn.a;
            As as = new As(source);
            this.a = as;
            this.f3689a = new C0653Qf(as, inflater);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    public static void a(int i, int i2, String str) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}));
        }
    }

    public final void b(long j, Buffer buffer, long j2) {
        Ov ov = buffer.f5624a;
        while (true) {
            int i = ov.b;
            int i2 = ov.a;
            if (j < ((long) (i - i2))) {
                break;
            }
            j -= (long) (i - i2);
            ov = ov.f3743a;
        }
        while (j2 > 0) {
            int i3 = (int) (((long) ov.a) + j);
            int min = (int) Math.min((long) (ov.b - i3), j2);
            this.f3690a.update(ov.f3745a, i3, min);
            j2 -= (long) min;
            ov = ov.f3743a;
            j = 0;
        }
    }

    public final void close() throws IOException {
        this.f3689a.close();
    }

    public final long read(Buffer buffer, long j) throws IOException {
        As as;
        boolean z;
        Buffer buffer2;
        long j2;
        Buffer buffer3 = buffer;
        long j3 = j;
        int i = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException(C0709Uj.h("byteCount < 0: ", j3));
        } else if (i == 0) {
            return 0;
        } else {
            int i2 = this.c;
            CRC32 crc32 = this.f3690a;
            As as2 = this.a;
            if (i2 == 0) {
                as2.K(10);
                Buffer buffer4 = as2.a;
                byte h = buffer4.h(3);
                if (((h >> 1) & 1) == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    buffer2 = buffer4;
                    b(0, as2.a, 10);
                } else {
                    buffer2 = buffer4;
                }
                a(8075, as2.readShort(), "ID1ID2");
                as2.d0(8);
                if (((h >> 2) & 1) == 1) {
                    as2.K(2);
                    if (z) {
                        b(0, as2.a, 2);
                    }
                    short readShort = buffer2.readShort();
                    Charset charset = C0663RB.a;
                    short s = readShort & 65535;
                    long j4 = (long) ((short) (((s & 255) << 8) | ((s & 65280) >>> 8)));
                    as2.K(j4);
                    if (z) {
                        b(0, as2.a, j4);
                        j2 = j4;
                    } else {
                        j2 = j4;
                    }
                    as2.d0(j2);
                }
                if (((h >> 3) & 1) == 1) {
                    as = as2;
                    long a2 = as2.a((byte) 0, 0, Long.MAX_VALUE);
                    if (a2 != -1) {
                        if (z) {
                            b(0, as.a, a2 + 1);
                        }
                        as.d0(a2 + 1);
                    } else {
                        throw new EOFException();
                    }
                } else {
                    as = as2;
                }
                if (((h >> 4) & 1) == 1) {
                    long a3 = as.a((byte) 0, 0, Long.MAX_VALUE);
                    if (a3 != -1) {
                        if (z) {
                            b(0, as.a, a3 + 1);
                        }
                        as.d0(a3 + 1);
                    } else {
                        throw new EOFException();
                    }
                }
                if (z) {
                    as.K(2);
                    short readShort2 = buffer2.readShort();
                    Charset charset2 = C0663RB.a;
                    short s2 = readShort2 & 65535;
                    a((short) (((s2 & 255) << 8) | ((65280 & s2) >>> 8)), (short) ((int) crc32.getValue()), "FHCRC");
                    crc32.reset();
                }
                this.c = 1;
            } else {
                as = as2;
            }
            if (this.c == 1) {
                long j5 = buffer3.f5623a;
                long read = this.f3689a.read(buffer3, j3);
                if (read != -1) {
                    b(j5, buffer, read);
                    return read;
                }
                this.c = 2;
            }
            if (this.c == 2) {
                as.K(4);
                int readInt = as.a.readInt();
                Charset charset3 = C0663RB.a;
                a(((readInt & Constants.MAX_HOST_LENGTH) << 24) | ((readInt & -16777216) >>> 24) | ((readInt & 16711680) >>> 8) | ((65280 & readInt) << 8), (int) crc32.getValue(), "CRC");
                as.K(4);
                int readInt2 = as.a.readInt();
                a(((readInt2 & Constants.MAX_HOST_LENGTH) << 24) | ((readInt2 & -16777216) >>> 24) | ((readInt2 & 16711680) >>> 8) | ((65280 & readInt2) << 8), (int) this.f3691a.getBytesWritten(), "ISIZE");
                this.c = 3;
                if (!as.h0()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    public final Timeout timeout() {
        return this.a.timeout();
    }
}
