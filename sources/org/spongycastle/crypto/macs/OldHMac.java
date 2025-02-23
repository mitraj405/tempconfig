package org.spongycastle.crypto.macs;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.digests.LongDigest;
import org.spongycastle.crypto.params.KeyParameter;

public class OldHMac implements Mac {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final Digest f6123a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6124a = new byte[64];
    public byte[] b = new byte[64];

    public OldHMac(LongDigest longDigest) {
        this.f6123a = longDigest;
        this.a = longDigest.f();
    }

    public final void a(CipherParameters cipherParameters) {
        Digest digest = this.f6123a;
        digest.reset();
        byte[] bArr = ((KeyParameter) cipherParameters).a;
        int length = bArr.length;
        byte[] bArr2 = this.f6124a;
        if (length > 64) {
            digest.update(bArr, 0, bArr.length);
            digest.c(0, bArr2);
            for (int i = this.a; i < bArr2.length; i++) {
                bArr2[i] = 0;
            }
        } else {
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            for (int length2 = bArr.length; length2 < bArr2.length; length2++) {
                bArr2[length2] = 0;
            }
        }
        byte[] bArr3 = new byte[bArr2.length];
        this.b = bArr3;
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            bArr2[i2] = (byte) (bArr2[i2] ^ 54);
        }
        int i3 = 0;
        while (true) {
            byte[] bArr4 = this.b;
            if (i3 < bArr4.length) {
                bArr4[i3] = (byte) (bArr4[i3] ^ 92);
                i3++;
            } else {
                digest.update(bArr2, 0, bArr2.length);
                return;
            }
        }
    }

    public final String b() {
        return this.f6123a.b() + "/HMAC";
    }

    public final int c(int i, byte[] bArr) {
        int i2 = this.a;
        byte[] bArr2 = new byte[i2];
        Digest digest = this.f6123a;
        digest.c(0, bArr2);
        byte[] bArr3 = this.b;
        digest.update(bArr3, 0, bArr3.length);
        digest.update(bArr2, 0, i2);
        int c = digest.c(0, bArr);
        reset();
        return c;
    }

    public final void d(byte b2) {
        this.f6123a.d(b2);
    }

    public final int e() {
        return this.a;
    }

    public final void reset() {
        Digest digest = this.f6123a;
        digest.reset();
        byte[] bArr = this.f6124a;
        digest.update(bArr, 0, bArr.length);
    }

    public final void update(byte[] bArr, int i, int i2) {
        this.f6123a.update(bArr, i, i2);
    }
}
