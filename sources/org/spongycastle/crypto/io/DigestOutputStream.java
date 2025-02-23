package org.spongycastle.crypto.io;

import java.io.IOException;
import java.io.OutputStream;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.SHA1Digest;

public class DigestOutputStream extends OutputStream {
    public final Digest a;

    public DigestOutputStream(SHA1Digest sHA1Digest) {
        this.a = sHA1Digest;
    }

    public final void write(int i) throws IOException {
        this.a.d((byte) i);
    }

    public final void write(byte[] bArr, int i, int i2) throws IOException {
        this.a.update(bArr, i, i2);
    }
}
