package org.spongycastle.crypto.tls;

import com.google.common.primitives.UnsignedBytes;
import java.io.InputStream;

public class ByteQueueInputStream extends InputStream {
    public final ByteQueue a = new ByteQueue();

    public final int available() {
        return this.a.b;
    }

    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public final long skip(long j) {
        ByteQueue byteQueue = this.a;
        int min = Math.min((int) j, byteQueue.b);
        byteQueue.c(min);
        return (long) min;
    }

    public final int read() {
        ByteQueue byteQueue = this.a;
        if (byteQueue.b == 0) {
            return -1;
        }
        byte[] bArr = new byte[1];
        byteQueue.b(0, 1, bArr);
        byteQueue.c(1);
        return bArr[0] & UnsignedBytes.MAX_VALUE;
    }

    public final int read(byte[] bArr, int i, int i2) {
        ByteQueue byteQueue = this.a;
        int min = Math.min(byteQueue.b, i2);
        byteQueue.b(i, min, bArr);
        byteQueue.c(min + 0);
        return min;
    }

    public final void close() {
    }
}
