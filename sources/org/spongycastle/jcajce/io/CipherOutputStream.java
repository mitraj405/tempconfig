package org.spongycastle.jcajce.io;

import java.io.FilterOutputStream;
import java.io.IOException;

public class CipherOutputStream extends FilterOutputStream {
    public final void close() throws IOException {
        try {
            throw null;
        } catch (Exception e) {
            IOException iOException = new IOException("Error closing stream: " + e);
            try {
                flush();
                this.out.close();
            } catch (IOException unused) {
            }
            throw iOException;
        }
    }

    public final void flush() throws IOException {
        this.out.flush();
    }

    public final void write(int i) throws IOException {
        throw null;
    }

    public final void write(byte[] bArr, int i, int i2) throws IOException {
        throw null;
    }
}
