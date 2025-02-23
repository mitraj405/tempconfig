package org.spongycastle.jcajce.provider.digest;

import java.security.MessageDigest;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.ExtendedDigest;

public class BCMessageDigest extends MessageDigest {
    public Digest a;

    public BCMessageDigest(ExtendedDigest extendedDigest) {
        super(extendedDigest.b());
        this.a = extendedDigest;
    }

    public final byte[] engineDigest() {
        byte[] bArr = new byte[this.a.f()];
        this.a.c(0, bArr);
        return bArr;
    }

    public final void engineReset() {
        this.a.reset();
    }

    public final void engineUpdate(byte b) {
        this.a.d(b);
    }

    public final void engineUpdate(byte[] bArr, int i, int i2) {
        this.a.update(bArr, i, i2);
    }
}
