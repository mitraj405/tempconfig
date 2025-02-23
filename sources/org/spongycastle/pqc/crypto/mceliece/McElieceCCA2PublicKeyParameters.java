package org.spongycastle.pqc.crypto.mceliece;

import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;

public class McElieceCCA2PublicKeyParameters extends McElieceCCA2KeyParameters {
    public final GF2Matrix a;
    public final int c;
    public final int d;

    public McElieceCCA2PublicKeyParameters(int i, int i2, GF2Matrix gF2Matrix, String str) {
        super(str, false);
        this.c = i;
        this.d = i2;
        this.a = new GF2Matrix(gF2Matrix);
    }
}
