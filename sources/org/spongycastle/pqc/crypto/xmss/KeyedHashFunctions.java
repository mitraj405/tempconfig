package org.spongycastle.pqc.crypto.xmss;

import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Xof;

final class KeyedHashFunctions {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final Digest f6759a;

    public KeyedHashFunctions(int i, Digest digest) {
        if (digest != null) {
            this.f6759a = digest;
            this.a = i;
            return;
        }
        throw new NullPointerException("digest == null");
    }

    public final byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr.length == this.a * 3) {
            return c(bArr, 2, bArr2);
        }
        throw new IllegalArgumentException("wrong key length");
    }

    public final byte[] b(byte[] bArr, byte[] bArr2) {
        if (bArr.length != this.a) {
            throw new IllegalArgumentException("wrong key length");
        } else if (bArr2.length == 32) {
            return c(bArr, 3, bArr2);
        } else {
            throw new IllegalArgumentException("wrong address length");
        }
    }

    public final byte[] c(byte[] bArr, int i, byte[] bArr2) {
        long j = (long) i;
        int i2 = this.a;
        byte[] j2 = XMSSUtil.j(i2, j);
        int length = j2.length;
        Digest digest = this.f6759a;
        digest.update(j2, 0, length);
        digest.update(bArr, 0, bArr.length);
        digest.update(bArr2, 0, bArr2.length);
        byte[] bArr3 = new byte[i2];
        if (digest instanceof Xof) {
            ((Xof) digest).g(0, bArr3, i2);
        } else {
            digest.c(0, bArr3);
        }
        return bArr3;
    }
}
