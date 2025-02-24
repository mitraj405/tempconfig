package com.fasterxml.jackson.databind.util;

import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ByteBufferBackedInputStream extends InputStream {
    protected final ByteBuffer _b;

    public ByteBufferBackedInputStream(ByteBuffer byteBuffer) {
        this._b = byteBuffer;
    }

    public int available() {
        return this._b.remaining();
    }

    public int read() throws IOException {
        if (this._b.hasRemaining()) {
            return this._b.get() & UnsignedBytes.MAX_VALUE;
        }
        return -1;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (!this._b.hasRemaining()) {
            return -1;
        }
        int min = Math.min(i2, this._b.remaining());
        this._b.get(bArr, i, min);
        return min;
    }
}
