package org.spongycastle.crypto.io;

import java.io.FilterInputStream;
import java.io.IOException;
import javax.crypto.CipherInputStream;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.SHA1Digest;

public class DigestInputStream extends FilterInputStream {
    public final Digest a;

    public DigestInputStream(CipherInputStream cipherInputStream, SHA1Digest sHA1Digest) {
        super(cipherInputStream);
        this.a = sHA1Digest;
    }

    public final int read() throws IOException {
        int read = this.in.read();
        if (read >= 0) {
            this.a.d((byte) read);
        }
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.in.read(bArr, i, i2);
        if (read > 0) {
            this.a.update(bArr, i, read);
        }
        return read;
    }
}
