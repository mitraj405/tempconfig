package org.spongycastle.asn1;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.util.io.Streams;

class DefiniteLengthInputStream extends LimitedInputStream {
    public static final byte[] a = new byte[0];
    public final int d;
    public int e;

    public DefiniteLengthInputStream(InputStream inputStream, int i) {
        super(inputStream, i);
        if (i >= 0) {
            this.d = i;
            this.e = i;
            if (i == 0) {
                b();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("negative lengths not allowed");
    }

    public final int a() {
        return this.e;
    }

    public final byte[] c() throws IOException {
        int i = this.e;
        if (i == 0) {
            return a;
        }
        byte[] bArr = new byte[i];
        int b = i - Streams.b(this.a, bArr, 0, i);
        this.e = b;
        if (b == 0) {
            b();
            return bArr;
        }
        throw new EOFException("DEF length " + this.d + " object truncated by " + this.e);
    }

    public final int read() throws IOException {
        if (this.e == 0) {
            return -1;
        }
        int read = this.a.read();
        if (read >= 0) {
            int i = this.e - 1;
            this.e = i;
            if (i == 0) {
                b();
            }
            return read;
        }
        throw new EOFException("DEF length " + this.d + " object truncated by " + this.e);
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.e;
        if (i3 == 0) {
            return -1;
        }
        int read = this.a.read(bArr, i, Math.min(i2, i3));
        if (read >= 0) {
            int i4 = this.e - read;
            this.e = i4;
            if (i4 == 0) {
                b();
            }
            return read;
        }
        throw new EOFException("DEF length " + this.d + " object truncated by " + this.e);
    }
}
