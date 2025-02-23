package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.Digest;

class CombinedHash implements TlsHandshakeHash {
    public final Digest a = TlsUtils.a(1);
    public final Digest b = TlsUtils.a(2);

    public final void a(Digest digest, byte[] bArr, byte[] bArr2, int i) {
        throw null;
    }

    public final String b() {
        return this.a.b() + " and " + this.b.b();
    }

    public final int c(int i, byte[] bArr) {
        Digest digest = this.b;
        int c = this.a.c(i, bArr);
        return digest.c(i + c, bArr) + c;
    }

    public final void d(byte b2) {
        this.a.d(b2);
        this.b.d(b2);
    }

    public final int f() {
        return this.b.f() + this.a.f();
    }

    public final void reset() {
        this.a.reset();
        this.b.reset();
    }

    public final void update(byte[] bArr, int i, int i2) {
        this.a.update(bArr, i, i2);
        this.b.update(bArr, i, i2);
    }
}
