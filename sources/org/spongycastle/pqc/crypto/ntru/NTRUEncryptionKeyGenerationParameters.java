package org.spongycastle.pqc.crypto.ntru;

import java.security.SecureRandom;
import java.util.Arrays;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA512Digest;

public class NTRUEncryptionKeyGenerationParameters extends KeyGenerationParameters implements Cloneable {
    public final Digest a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f6704a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6705a;
    public final boolean b;
    public final boolean c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public final int q;
    public int r;
    public int s;
    public final int t;
    public int u;
    public final int v;
    public final int w;
    public final int x;
    public final int y = 1;

    static {
        new NTRUEncryptionKeyGenerationParameters(1087, 2048, 120, 120, 256, 13, 25, 14, true, new byte[]{0, 6, 3}, true, false, new SHA512Digest());
        new NTRUEncryptionKeyGenerationParameters(1171, 2048, 106, 106, 256, 13, 20, 15, true, new byte[]{0, 6, 4}, true, false, new SHA512Digest());
        new NTRUEncryptionKeyGenerationParameters(1499, 2048, 79, 79, 256, 13, 17, 19, true, new byte[]{0, 6, 5}, true, false, new SHA512Digest());
        new NTRUEncryptionKeyGenerationParameters(439, 2048, 146, 130, 128, 9, 32, 9, true, new byte[]{0, 7, 101}, true, false, new SHA256Digest());
        new NTRUEncryptionKeyGenerationParameters(439, 2048, 9, 8, 5, 130, 128, 9, 32, 9, true, new byte[]{0, 7, 101}, true, true, new SHA256Digest());
        new NTRUEncryptionKeyGenerationParameters(743, 2048, 248, 220, 256, 10, 27, 14, true, new byte[]{0, 7, 105}, false, false, new SHA512Digest());
        new NTRUEncryptionKeyGenerationParameters(743, 2048, 11, 11, 15, 220, 256, 10, 27, 14, true, new byte[]{0, 7, 105}, false, true, new SHA512Digest());
    }

    public NTRUEncryptionKeyGenerationParameters(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z, byte[] bArr, boolean z2, boolean z3, Digest digest) {
        super(i6, new SecureRandom());
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.q = i6;
        this.t = i5;
        this.v = i7;
        this.w = i8;
        this.x = i9;
        this.f6704a = z;
        this.f6705a = bArr;
        this.b = z2;
        this.c = z3;
        this.a = digest;
        a();
    }

    public final void a() {
        this.j = this.f;
        this.k = this.g;
        this.l = this.h;
        this.m = this.i;
        int i2 = this.d;
        this.n = i2 / 3;
        this.o = 1;
        int i3 = this.q;
        this.p = (((((i2 * 3) / 2) / 8) - 1) - (i3 / 8)) - 1;
        this.r = (((((i2 * 3) / 2) + 7) / 8) * 8) + 1;
        this.s = i2 - 1;
        this.u = i3;
    }

    public final Object clone() throws CloneNotSupportedException {
        if (this.y == 0) {
            return new NTRUEncryptionKeyGenerationParameters(this.d, this.e, this.f, this.t, this.q, this.v, this.w, this.x, this.f6704a, this.f6705a, this.b, this.c, this.a);
        }
        int i2 = this.d;
        int i3 = this.e;
        int i4 = this.g;
        int i5 = this.h;
        int i6 = this.i;
        int i7 = this.t;
        int i8 = this.q;
        int i9 = this.v;
        int i10 = this.w;
        int i11 = this.x;
        boolean z = this.f6704a;
        byte[] bArr = this.f6705a;
        return new NTRUEncryptionKeyGenerationParameters(i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, z, bArr, this.b, this.c, this.a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NTRUEncryptionKeyGenerationParameters nTRUEncryptionKeyGenerationParameters = (NTRUEncryptionKeyGenerationParameters) obj;
        if (this.d != nTRUEncryptionKeyGenerationParameters.d || this.r != nTRUEncryptionKeyGenerationParameters.r || this.s != nTRUEncryptionKeyGenerationParameters.s || this.v != nTRUEncryptionKeyGenerationParameters.v || this.q != nTRUEncryptionKeyGenerationParameters.q || this.f != nTRUEncryptionKeyGenerationParameters.f || this.g != nTRUEncryptionKeyGenerationParameters.g || this.h != nTRUEncryptionKeyGenerationParameters.h || this.i != nTRUEncryptionKeyGenerationParameters.i || this.n != nTRUEncryptionKeyGenerationParameters.n || this.t != nTRUEncryptionKeyGenerationParameters.t || this.j != nTRUEncryptionKeyGenerationParameters.j || this.k != nTRUEncryptionKeyGenerationParameters.k || this.l != nTRUEncryptionKeyGenerationParameters.l || this.m != nTRUEncryptionKeyGenerationParameters.m || this.c != nTRUEncryptionKeyGenerationParameters.c) {
            return false;
        }
        Digest digest = nTRUEncryptionKeyGenerationParameters.a;
        Digest digest2 = this.a;
        if (digest2 == null) {
            if (digest != null) {
                return false;
            }
        } else if (!digest2.b().equals(digest.b())) {
            return false;
        }
        if (this.f6704a == nTRUEncryptionKeyGenerationParameters.f6704a && this.o == nTRUEncryptionKeyGenerationParameters.o && this.p == nTRUEncryptionKeyGenerationParameters.p && this.x == nTRUEncryptionKeyGenerationParameters.x && this.w == nTRUEncryptionKeyGenerationParameters.w && Arrays.equals(this.f6705a, nTRUEncryptionKeyGenerationParameters.f6705a) && this.u == nTRUEncryptionKeyGenerationParameters.u && this.y == nTRUEncryptionKeyGenerationParameters.y && this.e == nTRUEncryptionKeyGenerationParameters.e && this.b == nTRUEncryptionKeyGenerationParameters.b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i2;
        int i3;
        int i4;
        int i5 = (((((((((((((((((((((((((((((this.d + 31) * 31) + this.r) * 31) + this.s) * 31) + this.v) * 31) + this.q) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31) + this.i) * 31) + this.n) * 31) + this.t) * 31) + this.j) * 31) + this.k) * 31) + this.l) * 31) + this.m) * 31;
        int i6 = 1231;
        if (this.c) {
            i2 = 1231;
        } else {
            i2 = 1237;
        }
        int i7 = (i5 + i2) * 31;
        Digest digest = this.a;
        if (digest == null) {
            i3 = 0;
        } else {
            i3 = digest.b().hashCode();
        }
        int i8 = (i7 + i3) * 31;
        if (this.f6704a) {
            i4 = 1231;
        } else {
            i4 = 1237;
        }
        int hashCode = (((((((Arrays.hashCode(this.f6705a) + ((((((((((i8 + i4) * 31) + this.o) * 31) + this.p) * 31) + this.x) * 31) + this.w) * 31)) * 31) + this.u) * 31) + this.y) * 31) + this.e) * 31;
        if (!this.b) {
            i6 = 1237;
        }
        return hashCode + i6;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("EncryptionParameters(N=" + this.d + " q=" + this.e);
        if (this.y == 0) {
            sb.append(" polyType=SIMPLE df=" + this.f);
        } else {
            sb.append(" polyType=PRODUCT df1=" + this.g + " df2=" + this.h + " df3=" + this.i);
        }
        sb.append(" dm0=" + this.t + " db=" + this.q + " c=" + this.v + " minCallsR=" + this.w + " minCallsMask=" + this.x + " hashSeed=" + this.f6704a + " hashAlg=" + this.a + " oid=" + Arrays.toString(this.f6705a) + " sparse=" + this.b + ")");
        return sb.toString();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NTRUEncryptionKeyGenerationParameters(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, boolean z, byte[] bArr, boolean z2, boolean z3, Digest digest) {
        super(i8, new SecureRandom());
        this.d = i2;
        this.e = i3;
        this.g = i4;
        this.h = i5;
        this.i = i6;
        this.q = i8;
        this.t = i7;
        this.v = i9;
        this.w = i10;
        this.x = i11;
        this.f6704a = z;
        this.f6705a = bArr;
        this.b = z2;
        this.c = z3;
        this.a = digest;
        a();
    }
}
