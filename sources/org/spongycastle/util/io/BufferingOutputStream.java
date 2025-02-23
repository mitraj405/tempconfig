package org.spongycastle.util.io;

import java.io.IOException;
import java.io.OutputStream;

public class BufferingOutputStream extends OutputStream {
    public final void close() throws IOException {
        flush();
        throw null;
    }

    public final void flush() throws IOException {
        throw null;
    }

    public final void write(byte[] bArr, int i, int i2) throws IOException {
        throw null;
    }

    public final void write(int i) throws IOException {
        throw null;
    }
}
