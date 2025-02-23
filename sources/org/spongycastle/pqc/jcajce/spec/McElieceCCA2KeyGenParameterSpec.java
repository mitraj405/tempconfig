package org.spongycastle.pqc.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.pqc.math.linearalgebra.PolynomialRingGF2;

public class McElieceCCA2KeyGenParameterSpec implements AlgorithmParameterSpec {
    public final int a = 11;

    /* renamed from: a  reason: collision with other field name */
    public final String f6839a;
    public final int b = 50;

    public McElieceCCA2KeyGenParameterSpec() {
        PolynomialRingGF2.b(11);
        this.f6839a = "SHA-256";
    }
}
