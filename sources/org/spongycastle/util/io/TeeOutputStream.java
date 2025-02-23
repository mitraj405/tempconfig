package org.spongycastle.util.io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TeeOutputStream extends OutputStream {
    public final OutputStream a;
    public final OutputStream b;

    public TeeOutputStream(FilterOutputStream filterOutputStream, OutputStream outputStream) {
        this.a = filterOutputStream;
        this.b = outputStream;
    }

    public final void close() throws IOException {
        this.a.close();
        this.b.close();
    }

    public final void flush() throws IOException {
        this.a.flush();
        this.b.flush();
    }

    public final void write(byte[] bArr) throws IOException {
        this.a.write(bArr);
        this.b.write(bArr);
    }

    public final void write(byte[] bArr, int i, int i2) throws IOException {
        this.a.write(bArr, i, i2);
        this.b.write(bArr, i, i2);
    }

    public final void write(int i) throws IOException {
        this.a.write(i);
        this.b.write(i);
    }
}
