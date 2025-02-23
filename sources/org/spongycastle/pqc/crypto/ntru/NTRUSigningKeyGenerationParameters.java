package org.spongycastle.pqc.crypto.ntru;

import java.security.SecureRandom;
import java.text.DecimalFormat;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA512Digest;

public class NTRUSigningKeyGenerationParameters extends KeyGenerationParameters implements Cloneable {
    public final double a;

    /* renamed from: a  reason: collision with other field name */
    public final Digest f6713a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f6714a;
    public double b;

    /* renamed from: b  reason: collision with other field name */
    public final boolean f6715b;
    public final double c;
    public double d;

    /* renamed from: d  reason: collision with other field name */
    public final int f6716d;
    public final double e;

    /* renamed from: e  reason: collision with other field name */
    public final int f6717e;
    public double f;

    /* renamed from: f  reason: collision with other field name */
    public final int f6718f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final int k = 100;
    public final int l;
    public final int m = 6;
    public final int n;
    public final int o;

    static {
        new NTRUSigningKeyGenerationParameters(439, 2048, 146, 1, 1, 0.165d, 490.0d, 280.0d, false, true, 0, new SHA256Digest());
        SHA256Digest sHA256Digest = r0;
        SHA256Digest sHA256Digest2 = new SHA256Digest();
        new NTRUSigningKeyGenerationParameters(439, 2048, 9, 8, 5, 1, 1, 0.165d, 490.0d, 280.0d, false, true, 0, sHA256Digest);
        new NTRUSigningKeyGenerationParameters(743, 2048, 248, 1, 1, 0.127d, 560.0d, 360.0d, true, false, 0, new SHA512Digest());
        SHA512Digest sHA512Digest = r18;
        SHA512Digest sHA512Digest2 = new SHA512Digest();
        new NTRUSigningKeyGenerationParameters(743, 2048, 11, 11, 15, 1, 1, 0.127d, 560.0d, 360.0d, true, false, 0, sHA512Digest);
        new NTRUSigningKeyGenerationParameters(157, 256, 29, 1, 1, 0.38d, 200.0d, 80.0d, false, false, 0, new SHA256Digest());
        SHA256Digest sHA256Digest3 = r18;
        SHA256Digest sHA256Digest4 = new SHA256Digest();
        new NTRUSigningKeyGenerationParameters(157, 256, 5, 5, 8, 1, 1, 0.38d, 200.0d, 80.0d, false, false, 0, sHA256Digest3);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NTRUSigningKeyGenerationParameters(int i2, int i3, int i4, int i5, int i6, double d2, double d3, double d4, boolean z, boolean z2, int i7, Digest digest) {
        super(i2, new SecureRandom());
        double d5 = d2;
        double d6 = d3;
        double d7 = d4;
        this.f6716d = i2;
        this.f6717e = i3;
        this.f6718f = i4;
        this.j = i5;
        this.l = i6;
        this.a = d5;
        this.c = d6;
        this.e = d7;
        this.f6714a = z;
        this.f6715b = z2;
        this.n = i7;
        this.f6713a = digest;
        this.o = 0;
        this.b = d5 * d5;
        this.d = d6 * d6;
        this.f = d7 * d7;
    }

    public final Object clone() throws CloneNotSupportedException {
        if (this.o != 0) {
            return new NTRUSigningKeyGenerationParameters(this.f6716d, this.f6717e, this.g, this.h, this.i, this.j, this.l, this.a, this.c, this.e, this.f6714a, this.f6715b, this.n, this.f6713a);
        }
        int i2 = this.f6716d;
        int i3 = this.f6717e;
        int i4 = this.f6718f;
        int i5 = this.j;
        int i6 = this.l;
        double d2 = this.a;
        double d3 = this.c;
        double d4 = this.e;
        boolean z = this.f6714a;
        boolean z2 = this.f6715b;
        return new NTRUSigningKeyGenerationParameters(i2, i3, i4, i5, i6, d2, d3, d4, z, z2, this.n, this.f6713a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NTRUSigningKeyGenerationParameters)) {
            return false;
        }
        NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters = (NTRUSigningKeyGenerationParameters) obj;
        if (this.j != nTRUSigningKeyGenerationParameters.j || this.f6716d != nTRUSigningKeyGenerationParameters.f6716d || this.l != nTRUSigningKeyGenerationParameters.l || Double.doubleToLongBits(this.a) != Double.doubleToLongBits(nTRUSigningKeyGenerationParameters.a) || Double.doubleToLongBits(this.b) != Double.doubleToLongBits(nTRUSigningKeyGenerationParameters.b) || this.m != nTRUSigningKeyGenerationParameters.m || this.f6718f != nTRUSigningKeyGenerationParameters.f6718f || this.g != nTRUSigningKeyGenerationParameters.g || this.h != nTRUSigningKeyGenerationParameters.h || this.i != nTRUSigningKeyGenerationParameters.i) {
            return false;
        }
        Digest digest = nTRUSigningKeyGenerationParameters.f6713a;
        Digest digest2 = this.f6713a;
        if (digest2 == null) {
            if (digest != null) {
                return false;
            }
        } else if (!digest2.b().equals(digest.b())) {
            return false;
        }
        if (this.n == nTRUSigningKeyGenerationParameters.n && Double.doubleToLongBits(this.e) == Double.doubleToLongBits(nTRUSigningKeyGenerationParameters.e) && Double.doubleToLongBits(this.f) == Double.doubleToLongBits(nTRUSigningKeyGenerationParameters.f) && Double.doubleToLongBits(this.c) == Double.doubleToLongBits(nTRUSigningKeyGenerationParameters.c) && Double.doubleToLongBits(this.d) == Double.doubleToLongBits(nTRUSigningKeyGenerationParameters.d) && this.o == nTRUSigningKeyGenerationParameters.o && this.f6714a == nTRUSigningKeyGenerationParameters.f6714a && this.f6717e == nTRUSigningKeyGenerationParameters.f6717e && this.k == nTRUSigningKeyGenerationParameters.k && this.f6715b == nTRUSigningKeyGenerationParameters.f6715b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i2;
        int i3;
        int i4 = ((((this.j + 31) * 31) + this.f6716d) * 31) + this.l;
        long doubleToLongBits = Double.doubleToLongBits(this.a);
        int i5 = (i4 * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
        long doubleToLongBits2 = Double.doubleToLongBits(this.b);
        int i6 = ((((((((((((i5 * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + this.m) * 31) + this.f6718f) * 31) + this.g) * 31) + this.h) * 31) + this.i) * 31;
        Digest digest = this.f6713a;
        if (digest == null) {
            i2 = 0;
        } else {
            i2 = digest.b().hashCode();
        }
        int i7 = ((i6 + i2) * 31) + this.n;
        long doubleToLongBits3 = Double.doubleToLongBits(this.e);
        int i8 = (i7 * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
        long doubleToLongBits4 = Double.doubleToLongBits(this.f);
        int i9 = (i8 * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)));
        long doubleToLongBits5 = Double.doubleToLongBits(this.c);
        int i10 = (i9 * 31) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)));
        long doubleToLongBits6 = Double.doubleToLongBits(this.d);
        int i11 = ((((i10 * 31) + ((int) (doubleToLongBits6 ^ (doubleToLongBits6 >>> 32)))) * 31) + this.o) * 31;
        int i12 = 1231;
        if (this.f6714a) {
            i3 = 1231;
        } else {
            i3 = 1237;
        }
        int i13 = (((((i11 + i3) * 31) + this.f6717e) * 31) + this.k) * 31;
        if (!this.f6715b) {
            i12 = 1237;
        }
        return i13 + i12;
    }

    public final String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        StringBuilder sb = new StringBuilder("SignatureParameters(N=" + this.f6716d + " q=" + this.f6717e);
        if (this.o == 0) {
            sb.append(" polyType=SIMPLE d=" + this.f6718f);
        } else {
            sb.append(" polyType=PRODUCT d1=" + this.g + " d2=" + this.h + " d3=" + this.i);
        }
        sb.append(" B=" + this.j + " basisType=" + this.l + " beta=" + decimalFormat.format(this.a) + " normBound=" + decimalFormat.format(this.c) + " keyNormBound=" + decimalFormat.format(this.e) + " prime=" + this.f6714a + " sparse=" + this.f6715b + " keyGenAlg=" + this.n + " hashAlg=" + this.f6713a + ")");
        return sb.toString();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NTRUSigningKeyGenerationParameters(int i2, int i3, int i4, int i5, int i6, int i7, int i8, double d2, double d3, double d4, boolean z, boolean z2, int i9, Digest digest) {
        super(i2, new SecureRandom());
        double d5 = d2;
        double d6 = d3;
        double d7 = d4;
        this.f6716d = i2;
        this.f6717e = i3;
        this.g = i4;
        this.h = i5;
        this.i = i6;
        this.j = i7;
        this.l = i8;
        this.a = d5;
        this.c = d6;
        this.e = d7;
        this.f6714a = z;
        this.f6715b = z2;
        this.n = i9;
        this.f6713a = digest;
        this.o = 1;
        this.b = d5 * d5;
        this.d = d6 * d6;
        this.f = d7 * d7;
    }
}
