package org.spongycastle.pqc.crypto.ntru;

import java.text.DecimalFormat;
import org.spongycastle.crypto.Digest;

public class NTRUSigningParameters implements Cloneable {
    public final double a;

    /* renamed from: a  reason: collision with other field name */
    public final Digest f6719a;
    public double b;
    public final double c;

    /* renamed from: c  reason: collision with other field name */
    public final int f6720c;
    public double d;

    /* renamed from: d  reason: collision with other field name */
    public final int f6721d;
    public final int e;
    public final int f;

    public NTRUSigningParameters(int i, int i2, int i3, int i4, double d2, double d3, Digest digest) {
        this.f6720c = i;
        this.f6721d = i2;
        this.e = i3;
        this.f = i4;
        this.a = d2;
        this.c = d3;
        this.f6719a = digest;
        this.b = d2 * d2;
        this.d = d3 * d3;
    }

    public final Object clone() throws CloneNotSupportedException {
        return new NTRUSigningParameters(this.f6720c, this.f6721d, this.e, this.f, this.a, this.c, this.f6719a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NTRUSigningParameters)) {
            return false;
        }
        NTRUSigningParameters nTRUSigningParameters = (NTRUSigningParameters) obj;
        if (this.f != nTRUSigningParameters.f || this.f6720c != nTRUSigningParameters.f6720c || Double.doubleToLongBits(this.a) != Double.doubleToLongBits(nTRUSigningParameters.a) || Double.doubleToLongBits(this.b) != Double.doubleToLongBits(nTRUSigningParameters.b) || this.e != nTRUSigningParameters.e) {
            return false;
        }
        Digest digest = nTRUSigningParameters.f6719a;
        Digest digest2 = this.f6719a;
        if (digest2 == null) {
            if (digest != null) {
                return false;
            }
        } else if (!digest2.b().equals(digest.b())) {
            return false;
        }
        if (Double.doubleToLongBits(this.c) == Double.doubleToLongBits(nTRUSigningParameters.c) && Double.doubleToLongBits(this.d) == Double.doubleToLongBits(nTRUSigningParameters.d) && this.f6721d == nTRUSigningParameters.f6721d) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = ((this.f + 31) * 31) + this.f6720c;
        long doubleToLongBits = Double.doubleToLongBits(this.a);
        int i2 = (i * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
        long doubleToLongBits2 = Double.doubleToLongBits(this.b);
        int i3 = 0;
        int i4 = ((((((((((((i2 * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + 6) * 31) + this.e) * 31) + 0) * 31) + 0) * 31) + 0) * 31;
        Digest digest = this.f6719a;
        if (digest != null) {
            i3 = digest.b().hashCode();
        }
        int i5 = i4 + i3;
        long doubleToLongBits3 = Double.doubleToLongBits(this.c);
        int i6 = (i5 * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
        long doubleToLongBits4 = Double.doubleToLongBits(this.d);
        return (((((i6 * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)))) * 31) + this.f6721d) * 31) + 100;
    }

    public final String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        StringBuilder sb = new StringBuilder("SignatureParameters(N=" + this.f6720c + " q=" + this.f6721d);
        sb.append(" B=" + this.f + " beta=" + decimalFormat.format(this.a) + " normBound=" + decimalFormat.format(this.c) + " hashAlg=" + this.f6719a + ")");
        return sb.toString();
    }
}
