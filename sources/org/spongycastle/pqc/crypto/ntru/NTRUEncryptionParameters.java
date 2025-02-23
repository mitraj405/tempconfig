package org.spongycastle.pqc.crypto.ntru;

import java.util.Arrays;
import org.spongycastle.crypto.Digest;

public class NTRUEncryptionParameters implements Cloneable {
    public final Digest a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f6706a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6707a;
    public final boolean b;
    public final int c;

    /* renamed from: c  reason: collision with other field name */
    public final boolean f6708c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public final int p;
    public int q;
    public int r;
    public final int s;
    public int t;
    public final int u;
    public final int v;
    public final int w;
    public final int x = 1;

    public NTRUEncryptionParameters(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z, byte[] bArr, boolean z2, boolean z3, Digest digest) {
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.p = i6;
        this.s = i5;
        this.u = i7;
        this.v = i8;
        this.w = i9;
        this.f6706a = z;
        this.f6707a = bArr;
        this.b = z2;
        this.f6708c = z3;
        this.a = digest;
        a();
    }

    public final void a() {
        this.i = this.e;
        this.j = this.f;
        this.k = this.g;
        this.l = this.h;
        int i2 = this.c;
        this.m = i2 / 3;
        this.n = 1;
        int i3 = this.p;
        this.o = (((((i2 * 3) / 2) / 8) - 1) - (i3 / 8)) - 1;
        this.q = (((((i2 * 3) / 2) + 7) / 8) * 8) + 1;
        this.r = i2 - 1;
        this.t = i3;
    }

    public final Object clone() throws CloneNotSupportedException {
        if (this.x == 0) {
            return new NTRUEncryptionParameters(this.c, this.d, this.e, this.s, this.p, this.u, this.v, this.w, this.f6706a, this.f6707a, this.b, this.f6708c, this.a);
        }
        int i2 = this.c;
        int i3 = this.d;
        int i4 = this.f;
        int i5 = this.g;
        int i6 = this.h;
        int i7 = this.s;
        int i8 = this.p;
        int i9 = this.u;
        int i10 = this.v;
        int i11 = this.w;
        boolean z = this.f6706a;
        byte[] bArr = this.f6707a;
        return new NTRUEncryptionParameters(i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, z, bArr, this.b, this.f6708c, this.a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NTRUEncryptionParameters nTRUEncryptionParameters = (NTRUEncryptionParameters) obj;
        if (this.c != nTRUEncryptionParameters.c || this.q != nTRUEncryptionParameters.q || this.r != nTRUEncryptionParameters.r || this.u != nTRUEncryptionParameters.u || this.p != nTRUEncryptionParameters.p || this.e != nTRUEncryptionParameters.e || this.f != nTRUEncryptionParameters.f || this.g != nTRUEncryptionParameters.g || this.h != nTRUEncryptionParameters.h || this.m != nTRUEncryptionParameters.m || this.s != nTRUEncryptionParameters.s || this.i != nTRUEncryptionParameters.i || this.j != nTRUEncryptionParameters.j || this.k != nTRUEncryptionParameters.k || this.l != nTRUEncryptionParameters.l || this.f6708c != nTRUEncryptionParameters.f6708c) {
            return false;
        }
        Digest digest = nTRUEncryptionParameters.a;
        Digest digest2 = this.a;
        if (digest2 == null) {
            if (digest != null) {
                return false;
            }
        } else if (!digest2.b().equals(digest.b())) {
            return false;
        }
        if (this.f6706a == nTRUEncryptionParameters.f6706a && this.n == nTRUEncryptionParameters.n && this.o == nTRUEncryptionParameters.o && this.w == nTRUEncryptionParameters.w && this.v == nTRUEncryptionParameters.v && Arrays.equals(this.f6707a, nTRUEncryptionParameters.f6707a) && this.t == nTRUEncryptionParameters.t && this.x == nTRUEncryptionParameters.x && this.d == nTRUEncryptionParameters.d && this.b == nTRUEncryptionParameters.b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i2;
        int i3;
        int i4;
        int i5 = (((((((((((((((((((((((((((((this.c + 31) * 31) + this.q) * 31) + this.r) * 31) + this.u) * 31) + this.p) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31) + this.m) * 31) + this.s) * 31) + this.i) * 31) + this.j) * 31) + this.k) * 31) + this.l) * 31;
        int i6 = 1231;
        if (this.f6708c) {
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
        if (this.f6706a) {
            i4 = 1231;
        } else {
            i4 = 1237;
        }
        int hashCode = (((((((Arrays.hashCode(this.f6707a) + ((((((((((i8 + i4) * 31) + this.n) * 31) + this.o) * 31) + this.w) * 31) + this.v) * 31)) * 31) + this.t) * 31) + this.x) * 31) + this.d) * 31;
        if (!this.b) {
            i6 = 1237;
        }
        return hashCode + i6;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("EncryptionParameters(N=" + this.c + " q=" + this.d);
        if (this.x == 0) {
            sb.append(" polyType=SIMPLE df=" + this.e);
        } else {
            sb.append(" polyType=PRODUCT df1=" + this.f + " df2=" + this.g + " df3=" + this.h);
        }
        sb.append(" dm0=" + this.s + " db=" + this.p + " c=" + this.u + " minCallsR=" + this.v + " minCallsMask=" + this.w + " hashSeed=" + this.f6706a + " hashAlg=" + this.a + " oid=" + Arrays.toString(this.f6707a) + " sparse=" + this.b + ")");
        return sb.toString();
    }

    public NTRUEncryptionParameters(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, boolean z, byte[] bArr, boolean z2, boolean z3, Digest digest) {
        this.c = i2;
        this.d = i3;
        this.f = i4;
        this.g = i5;
        this.h = i6;
        this.p = i8;
        this.s = i7;
        this.u = i9;
        this.v = i10;
        this.w = i11;
        this.f6706a = z;
        this.f6707a = bArr;
        this.b = z2;
        this.f6708c = z3;
        this.a = digest;
        a();
    }
}
