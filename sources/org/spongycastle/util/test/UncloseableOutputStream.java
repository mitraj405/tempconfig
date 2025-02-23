package org.spongycastle.util.test;

import java.io.FilterOutputStream;
import java.io.IOException;

public class UncloseableOutputStream extends FilterOutputStream {
    public final void close() {
        throw new RuntimeException("close() called on UncloseableOutputStream");
    }

    public final void write(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
    }
}
