package org.spongycastle.crypto.io;

import com.google.common.primitives.UnsignedBytes;
import java.io.FilterInputStream;
import java.io.IOException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.util.Arrays;

public class CipherInputStream extends FilterInputStream {
    public boolean a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f6088a;
    public byte[] b;
    public int c;

    public final void a() throws IOException {
        try {
            this.a = true;
            byte[] bArr = this.f6088a;
            if (bArr == null || bArr.length < 0) {
                this.f6088a = new byte[0];
            }
        } catch (InvalidCipherTextException e) {
            throw new InvalidCipherTextIOException(e);
        } catch (Exception e2) {
            throw new IOException("Error finalising cipher " + e2);
        }
    }

    public final int available() throws IOException {
        return 0 - this.c;
    }

    public final int b() throws IOException {
        if (this.a) {
            return -1;
        }
        this.c = 0;
        int read = this.in.read((byte[]) null);
        if (read == -1) {
            a();
            return -1;
        }
        try {
            byte[] bArr = this.f6088a;
            if (bArr == null || bArr.length < read) {
                this.f6088a = new byte[read];
            }
            throw null;
        } catch (Exception e) {
            throw new CipherIOException("Error processing stream ", e);
        }
    }

    public final void close() throws IOException {
        try {
            this.in.close();
            this.c = 0;
            byte[] bArr = this.b;
            if (bArr != null) {
                Arrays.p(bArr, (byte) 0);
                this.b = null;
            }
            byte[] bArr2 = this.f6088a;
            if (bArr2 != null) {
                Arrays.p(bArr2, (byte) 0);
                this.f6088a = null;
            }
            Arrays.p((byte[]) null, (byte) 0);
            throw null;
        } finally {
            if (!this.a) {
                a();
            }
        }
    }

    public final void mark(int i) {
        this.in.mark(i);
        byte[] bArr = this.f6088a;
        if (bArr != null) {
            byte[] bArr2 = new byte[bArr.length];
            this.b = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        }
    }

    public final boolean markSupported() {
        return false;
    }

    public final int read() throws IOException {
        if (this.c >= 0 && b() < 0) {
            return -1;
        }
        byte[] bArr = this.f6088a;
        int i = this.c;
        this.c = i + 1;
        return bArr[i] & UnsignedBytes.MAX_VALUE;
    }

    public final void reset() throws IOException {
        throw new IOException("cipher must implement SkippingCipher to be used with reset()");
    }

    public final long skip(long j) throws IOException {
        if (j <= 0) {
            return 0;
        }
        int min = (int) Math.min(j, (long) available());
        this.c += min;
        return (long) min;
    }

    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.c >= 0 && b() < 0) {
            return -1;
        }
        int min = Math.min(i2, available());
        System.arraycopy(this.f6088a, this.c, bArr, i, min);
        this.c += min;
        return min;
    }
}
