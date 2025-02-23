package org.spongycastle.pqc.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;

public class RainbowParameterSpec implements AlgorithmParameterSpec {
    public static final int[] b = {6, 12, 17, 22, 33};
    public final int[] a = b;
}
