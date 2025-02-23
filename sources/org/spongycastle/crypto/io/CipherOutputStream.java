package org.spongycastle.crypto.io;

import java.io.FilterOutputStream;
import java.io.IOException;

public class CipherOutputStream extends FilterOutputStream {
    public byte[] a;

    public final void close() throws IOException {
        byte[] bArr = this.a;
        if (bArr == null || bArr.length < 0) {
            this.a = new byte[0];
        }
        try {
            flush();
            this.out.close();
            e = null;
        } catch (IOException e) {
            e = e;
        }
        if (e != null) {
            throw e;
        }
    }

    public final void flush() throws IOException {
        this.out.flush();
    }

    public final void write(int i) throws IOException {
        throw null;
    }

    public final void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public final void write(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArr2 = this.a;
        if (bArr2 == null || bArr2.length < i2) {
            this.a = new byte[i2];
        }
        throw null;
    }
}
