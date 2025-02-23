package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
final class MultiInputStream extends InputStream {

    /* renamed from: in  reason: collision with root package name */
    private InputStream f7125in;
    private Iterator<? extends ByteSource> it;

    public MultiInputStream(Iterator<? extends ByteSource> it2) throws IOException {
        this.it = (Iterator) Preconditions.checkNotNull(it2);
        advance();
    }

    private void advance() throws IOException {
        close();
        if (this.it.hasNext()) {
            this.f7125in = ((ByteSource) this.it.next()).openStream();
        }
    }

    public int available() throws IOException {
        InputStream inputStream = this.f7125in;
        if (inputStream == null) {
            return 0;
        }
        return inputStream.available();
    }

    public void close() throws IOException {
        InputStream inputStream = this.f7125in;
        if (inputStream != null) {
            try {
                inputStream.close();
            } finally {
                this.f7125in = null;
            }
        }
    }

    public boolean markSupported() {
        return false;
    }

    public int read() throws IOException {
        while (true) {
            InputStream inputStream = this.f7125in;
            if (inputStream == null) {
                return -1;
            }
            int read = inputStream.read();
            if (read != -1) {
                return read;
            }
            advance();
        }
    }

    public long skip(long j) throws IOException {
        InputStream inputStream = this.f7125in;
        if (inputStream == null || j <= 0) {
            return 0;
        }
        long skip = inputStream.skip(j);
        if (skip != 0) {
            return skip;
        }
        if (read() == -1) {
            return 0;
        }
        return this.f7125in.skip(j - 1) + 1;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        Preconditions.checkNotNull(bArr);
        while (true) {
            InputStream inputStream = this.f7125in;
            if (inputStream == null) {
                return -1;
            }
            int read = inputStream.read(bArr, i, i2);
            if (read != -1) {
                return read;
            }
            advance();
        }
    }
}
