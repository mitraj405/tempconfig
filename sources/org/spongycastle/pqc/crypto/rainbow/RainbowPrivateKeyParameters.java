package org.spongycastle.pqc.crypto.rainbow;

public class RainbowPrivateKeyParameters extends RainbowKeyParameters {
    public final int[] a;

    /* renamed from: a  reason: collision with other field name */
    public final Layer[] f6734a;

    /* renamed from: a  reason: collision with other field name */
    public final short[] f6735a;

    /* renamed from: a  reason: collision with other field name */
    public final short[][] f6736a;
    public final short[] b;

    /* renamed from: b  reason: collision with other field name */
    public final short[][] f6737b;

    public RainbowPrivateKeyParameters(short[][] sArr, short[] sArr2, short[][] sArr3, short[] sArr4, int[] iArr, Layer[] layerArr) {
        super(true, iArr[iArr.length - 1] - iArr[0]);
        this.f6736a = sArr;
        this.f6735a = sArr2;
        this.f6737b = sArr3;
        this.b = sArr4;
        this.a = iArr;
        this.f6734a = layerArr;
    }
}
