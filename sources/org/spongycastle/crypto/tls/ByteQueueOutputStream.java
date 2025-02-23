package org.spongycastle.crypto.tls;

import java.io.IOException;
import java.io.OutputStream;

public class ByteQueueOutputStream extends OutputStream {
    public final ByteQueue a = new ByteQueue();

    public final void write(int i) throws IOException {
        this.a.a(0, new byte[]{(byte) i}, 1);
    }

    public final void write(byte[] bArr, int i, int i2) throws IOException {
        this.a.a(i, bArr, i2);
    }
}
