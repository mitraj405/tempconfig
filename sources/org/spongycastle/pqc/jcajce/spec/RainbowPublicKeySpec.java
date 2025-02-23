package org.spongycastle.pqc.jcajce.spec;

import java.security.spec.KeySpec;

public class RainbowPublicKeySpec implements KeySpec {
    public final short[] a;

    /* renamed from: a  reason: collision with other field name */
    public final short[][] f6844a;
    public final short[][] b;
    public final int c;

    public RainbowPublicKeySpec(int i, short[][] sArr, short[][] sArr2, short[] sArr3) {
        this.c = i;
        this.f6844a = sArr;
        this.b = sArr2;
        this.a = sArr3;
    }
}
