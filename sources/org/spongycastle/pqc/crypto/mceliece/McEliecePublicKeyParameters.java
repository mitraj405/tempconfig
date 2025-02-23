package org.spongycastle.pqc.crypto.mceliece;

import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;

public class McEliecePublicKeyParameters extends McElieceKeyParameters {
    public final GF2Matrix a;
    public final int c;
    public final int d;

    public McEliecePublicKeyParameters(int i, int i2, GF2Matrix gF2Matrix) {
        super(false);
        this.c = i;
        this.d = i2;
        this.a = new GF2Matrix(gF2Matrix);
    }
}
