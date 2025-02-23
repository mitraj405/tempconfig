package org.spongycastle.crypto.macs;

import java.util.Hashtable;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Memoable;

public class HMac implements Mac {
    public static final Hashtable a;

    /* renamed from: a  reason: collision with other field name */
    public final int f6108a;

    /* renamed from: a  reason: collision with other field name */
    public final Digest f6109a;

    /* renamed from: a  reason: collision with other field name */
    public Memoable f6110a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6111a;
    public final int b;

    /* renamed from: b  reason: collision with other field name */
    public Memoable f6112b;

    /* renamed from: b  reason: collision with other field name */
    public final byte[] f6113b;

    static {
        Hashtable hashtable = new Hashtable();
        a = hashtable;
        hashtable.put("GOST3411", 32);
        hashtable.put("MD2", 16);
        hashtable.put("MD4", 64);
        hashtable.put("MD5", 64);
        hashtable.put("RIPEMD128", 64);
        hashtable.put("RIPEMD160", 64);
        hashtable.put("SHA-1", 64);
        hashtable.put("SHA-224", 64);
        hashtable.put("SHA-256", 64);
        hashtable.put("SHA-384", 128);
        hashtable.put("SHA-512", 128);
        hashtable.put("Tiger", 64);
        hashtable.put("Whirlpool", 64);
    }

    public HMac(Digest digest) {
        int i;
        if (digest instanceof ExtendedDigest) {
            i = ((ExtendedDigest) digest).h();
        } else {
            Integer num = (Integer) a.get(digest.b());
            if (num != null) {
                i = num.intValue();
            } else {
                throw new IllegalArgumentException("unknown digest passed: " + digest.b());
            }
        }
        this.f6109a = digest;
        int f = digest.f();
        this.f6108a = f;
        this.b = i;
        this.f6111a = new byte[i];
        this.f6113b = new byte[(i + f)];
    }

    public final void a(CipherParameters cipherParameters) {
        Digest digest = this.f6109a;
        digest.reset();
        byte[] bArr = ((KeyParameter) cipherParameters).a;
        int length = bArr.length;
        byte[] bArr2 = this.f6111a;
        int i = this.b;
        if (length > i) {
            digest.update(bArr, 0, length);
            digest.c(0, bArr2);
            length = this.f6108a;
        } else {
            System.arraycopy(bArr, 0, bArr2, 0, length);
        }
        while (length < bArr2.length) {
            bArr2[length] = 0;
            length++;
        }
        byte[] bArr3 = this.f6113b;
        System.arraycopy(bArr2, 0, bArr3, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            bArr2[i2] = (byte) (bArr2[i2] ^ 54);
        }
        for (int i3 = 0; i3 < i; i3++) {
            bArr3[i3] = (byte) (bArr3[i3] ^ 92);
        }
        boolean z = digest instanceof Memoable;
        if (z) {
            Memoable a2 = ((Memoable) digest).a();
            this.f6112b = a2;
            ((Digest) a2).update(bArr3, 0, i);
        }
        digest.update(bArr2, 0, bArr2.length);
        if (z) {
            this.f6110a = ((Memoable) digest).a();
        }
    }

    public final String b() {
        return this.f6109a.b() + "/HMAC";
    }

    public final int c(int i, byte[] bArr) {
        Digest digest = this.f6109a;
        int i2 = this.b;
        byte[] bArr2 = this.f6113b;
        digest.c(i2, bArr2);
        Memoable memoable = this.f6112b;
        if (memoable != null) {
            ((Memoable) digest).e(memoable);
            digest.update(bArr2, i2, digest.f());
        } else {
            digest.update(bArr2, 0, bArr2.length);
        }
        int c = digest.c(0, bArr);
        while (i2 < bArr2.length) {
            bArr2[i2] = 0;
            i2++;
        }
        Memoable memoable2 = this.f6110a;
        if (memoable2 != null) {
            ((Memoable) digest).e(memoable2);
        } else {
            byte[] bArr3 = this.f6111a;
            digest.update(bArr3, 0, bArr3.length);
        }
        return c;
    }

    public final void d(byte b2) {
        this.f6109a.d(b2);
    }

    public final int e() {
        return this.f6108a;
    }

    public final void reset() {
        Digest digest = this.f6109a;
        digest.reset();
        byte[] bArr = this.f6111a;
        digest.update(bArr, 0, bArr.length);
    }

    public final void update(byte[] bArr, int i, int i2) {
        this.f6109a.update(bArr, i, i2);
    }
}
