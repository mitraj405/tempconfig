package org.spongycastle.crypto.tls;

import java.util.Enumeration;
import java.util.Hashtable;
import org.spongycastle.crypto.Digest;

class DeferredHash implements TlsHandshakeHash {
    public final Hashtable a = new Hashtable();

    /* renamed from: a  reason: collision with other field name */
    public DigestInputBuffer f6305a = new DigestInputBuffer();

    public final String b() {
        throw new IllegalStateException("Use fork() to get a definite Digest");
    }

    public final int c(int i, byte[] bArr) {
        throw new IllegalStateException("Use fork() to get a definite Digest");
    }

    public final void d(byte b) {
        DigestInputBuffer digestInputBuffer = this.f6305a;
        if (digestInputBuffer != null) {
            digestInputBuffer.write(b);
            return;
        }
        Enumeration elements = this.a.elements();
        while (elements.hasMoreElements()) {
            ((Digest) elements.nextElement()).d(b);
        }
    }

    public final int f() {
        throw new IllegalStateException("Use fork() to get a definite Digest");
    }

    public final void reset() {
        DigestInputBuffer digestInputBuffer = this.f6305a;
        if (digestInputBuffer != null) {
            digestInputBuffer.reset();
            return;
        }
        Enumeration elements = this.a.elements();
        while (elements.hasMoreElements()) {
            ((Digest) elements.nextElement()).reset();
        }
    }

    public final void update(byte[] bArr, int i, int i2) {
        DigestInputBuffer digestInputBuffer = this.f6305a;
        if (digestInputBuffer != null) {
            digestInputBuffer.write(bArr, i, i2);
            return;
        }
        Enumeration elements = this.a.elements();
        while (elements.hasMoreElements()) {
            ((Digest) elements.nextElement()).update(bArr, i, i2);
        }
    }
}
