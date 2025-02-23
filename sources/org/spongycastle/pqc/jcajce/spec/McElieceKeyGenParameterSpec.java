package org.spongycastle.pqc.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.pqc.math.linearalgebra.PolynomialRingGF2;

public class McElieceKeyGenParameterSpec implements AlgorithmParameterSpec {
    public final int a = 11;
    public final int b = 50;

    public McElieceKeyGenParameterSpec() {
        PolynomialRingGF2.b(11);
    }
}
