package org.spongycastle.asn1;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

class IndefiniteLengthInputStream extends LimitedInputStream {
    public boolean a = false;
    public boolean b = true;
    public int d;
    public int e;

    public IndefiniteLengthInputStream(InputStream inputStream, int i) throws IOException {
        super(inputStream, i);
        this.d = inputStream.read();
        int read = inputStream.read();
        this.e = read;
        if (read >= 0) {
            c();
            return;
        }
        throw new EOFException();
    }

    public final boolean c() {
        if (!this.a && this.b && this.d == 0 && this.e == 0) {
            this.a = true;
            b();
        }
        return this.a;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.b || i2 < 3) {
            return super.read(bArr, i, i2);
        }
        if (this.a) {
            return -1;
        }
        InputStream inputStream = this.a;
        int read = inputStream.read(bArr, i + 2, i2 - 2);
        if (read >= 0) {
            bArr[i] = (byte) this.d;
            bArr[i + 1] = (byte) this.e;
            this.d = inputStream.read();
            int read2 = inputStream.read();
            this.e = read2;
            if (read2 >= 0) {
                return read + 2;
            }
            throw new EOFException();
        }
        throw new EOFException();
    }

    public final int read() throws IOException {
        if (c()) {
            return -1;
        }
        int read = this.a.read();
        if (read >= 0) {
            int i = this.d;
            this.d = this.e;
            this.e = read;
            return i;
        }
        throw new EOFException();
    }
}
