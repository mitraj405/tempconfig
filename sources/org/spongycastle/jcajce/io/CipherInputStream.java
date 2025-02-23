package org.spongycastle.jcajce.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import org.spongycastle.crypto.io.InvalidCipherTextIOException;

public class CipherInputStream extends FilterInputStream {
    public boolean a;
    public int c;

    public final int available() throws IOException {
        return 0 - this.c;
    }

    public final void close() throws IOException {
        try {
            this.in.close();
            if (this.a) {
                this.c = 0;
                return;
            }
            try {
                this.a = true;
                throw null;
            } catch (GeneralSecurityException e) {
                throw new InvalidCipherTextIOException(e);
            }
        } catch (Throwable th) {
            if (!this.a) {
                try {
                    this.a = true;
                    throw null;
                } catch (GeneralSecurityException e2) {
                    throw new InvalidCipherTextIOException(e2);
                }
            } else {
                throw th;
            }
        }
    }

    public final boolean markSupported() {
        return false;
    }

    public final int read() throws IOException {
        int i = this.c;
        if (i < 0) {
            this.c = i + 1;
            throw null;
        } else if (this.a) {
            return -1;
        } else {
            this.c = 0;
            if (this.in.read((byte[]) null) == -1) {
                try {
                    this.a = true;
                    throw null;
                } catch (GeneralSecurityException e) {
                    throw new InvalidCipherTextIOException(e);
                }
            } else {
                throw null;
            }
        }
    }

    public final long skip(long j) throws IOException {
        if (j <= 0) {
            return 0;
        }
        int min = (int) Math.min(j, (long) available());
        this.c += min;
        return (long) min;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.c < 0) {
            int min = Math.min(i2, available());
            System.arraycopy((Object) null, this.c, bArr, i, min);
            this.c += min;
            return min;
        } else if (this.a) {
            return -1;
        } else {
            this.c = 0;
            if (this.in.read((byte[]) null) == -1) {
                try {
                    this.a = true;
                    throw null;
                } catch (GeneralSecurityException e) {
                    throw new InvalidCipherTextIOException(e);
                }
            } else {
                throw null;
            }
        }
    }

    public final void reset() throws IOException {
    }

    public final void mark(int i) {
    }
}
