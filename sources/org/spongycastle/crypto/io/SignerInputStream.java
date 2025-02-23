package org.spongycastle.crypto.io;

import java.io.FilterInputStream;
import java.io.IOException;

public class SignerInputStream extends FilterInputStream {
    public final int read() throws IOException {
        int read = this.in.read();
        if (read < 0) {
            return read;
        }
        throw null;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.in.read(bArr, i, i2);
        if (read <= 0) {
            return read;
        }
        throw null;
    }
}
