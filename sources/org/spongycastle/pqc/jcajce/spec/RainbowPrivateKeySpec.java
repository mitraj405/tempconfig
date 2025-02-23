package org.spongycastle.pqc.jcajce.spec;

import java.security.spec.KeySpec;
import org.spongycastle.pqc.crypto.rainbow.Layer;

public class RainbowPrivateKeySpec implements KeySpec {
    public final int[] a;

    /* renamed from: a  reason: collision with other field name */
    public final Layer[] f6840a;

    /* renamed from: a  reason: collision with other field name */
    public final short[] f6841a;

    /* renamed from: a  reason: collision with other field name */
    public final short[][] f6842a;
    public final short[] b;

    /* renamed from: b  reason: collision with other field name */
    public final short[][] f6843b;

    public RainbowPrivateKeySpec(short[][] sArr, short[] sArr2, short[][] sArr3, short[] sArr4, int[] iArr, Layer[] layerArr) {
        this.f6842a = sArr;
        this.f6841a = sArr2;
        this.f6843b = sArr3;
        this.b = sArr4;
        this.a = iArr;
        this.f6840a = layerArr;
    }
}
