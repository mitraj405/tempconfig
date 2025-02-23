package org.spongycastle.pqc.crypto.mceliece;

import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
import org.spongycastle.pqc.math.linearalgebra.GF2mField;
import org.spongycastle.pqc.math.linearalgebra.GoppaCode;
import org.spongycastle.pqc.math.linearalgebra.Permutation;
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;
import org.spongycastle.pqc.math.linearalgebra.PolynomialRingGF2m;

public class McElieceCCA2PrivateKeyParameters extends McElieceCCA2KeyParameters {
    public final GF2Matrix a;

    /* renamed from: a  reason: collision with other field name */
    public final GF2mField f6676a;

    /* renamed from: a  reason: collision with other field name */
    public final Permutation f6677a;

    /* renamed from: a  reason: collision with other field name */
    public final PolynomialGF2mSmallM f6678a;

    /* renamed from: a  reason: collision with other field name */
    public final PolynomialGF2mSmallM[] f6679a;
    public final int c;
    public final int d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public McElieceCCA2PrivateKeyParameters(int i, int i2, GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM, Permutation permutation, String str) {
        super(str, true);
        GF2Matrix b = GoppaCode.b(gF2mField, polynomialGF2mSmallM);
        this.c = i;
        this.d = i2;
        this.f6676a = gF2mField;
        this.f6678a = polynomialGF2mSmallM;
        this.a = b;
        this.f6677a = permutation;
        this.f6679a = new PolynomialRingGF2m(gF2mField, polynomialGF2mSmallM).b;
    }
}
