package org.spongycastle.pqc.math.ntru.polynomial;

public class LongPolynomial2 {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public long[] f6856a;

    public LongPolynomial2(long[] jArr) {
        this.f6856a = jArr;
    }

    public final Object clone() {
        LongPolynomial2 longPolynomial2 = new LongPolynomial2((long[]) this.f6856a.clone());
        longPolynomial2.a = this.a;
        return longPolynomial2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof LongPolynomial2)) {
            return false;
        }
        long[] jArr = this.f6856a;
        long[] jArr2 = ((LongPolynomial2) obj).f6856a;
        if (jArr != jArr2) {
            if (jArr == null || jArr2 == null || jArr.length != jArr2.length) {
                return false;
            }
            for (int i = 0; i != jArr.length; i++) {
                if (jArr[i] != jArr2[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
