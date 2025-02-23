package org.spongycastle.pqc.crypto.mceliece;

import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
import org.spongycastle.pqc.math.linearalgebra.GF2mField;
import org.spongycastle.pqc.math.linearalgebra.GoppaCode;
import org.spongycastle.pqc.math.linearalgebra.Permutation;
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;
import org.spongycastle.pqc.math.linearalgebra.PolynomialRingGF2m;

public class McEliecePrivateKeyParameters extends McElieceKeyParameters {
    public final GF2Matrix a;

    /* renamed from: a  reason: collision with other field name */
    public final GF2mField f6699a;

    /* renamed from: a  reason: collision with other field name */
    public final Permutation f6700a;

    /* renamed from: a  reason: collision with other field name */
    public final PolynomialGF2mSmallM f6701a;

    /* renamed from: a  reason: collision with other field name */
    public final PolynomialGF2mSmallM[] f6702a;
    public final GF2Matrix b;

    /* renamed from: b  reason: collision with other field name */
    public final Permutation f6703b;
    public final int c;
    public final int d;

    public McEliecePrivateKeyParameters(int i, int i2, GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM, Permutation permutation, Permutation permutation2, GF2Matrix gF2Matrix) {
        super(true);
        this.d = i2;
        this.c = i;
        this.f6699a = gF2mField;
        this.f6701a = polynomialGF2mSmallM;
        this.a = gF2Matrix;
        this.f6700a = permutation;
        this.f6703b = permutation2;
        this.b = GoppaCode.b(gF2mField, polynomialGF2mSmallM);
        this.f6702a = new PolynomialRingGF2m(gF2mField, polynomialGF2mSmallM).b;
    }
}
