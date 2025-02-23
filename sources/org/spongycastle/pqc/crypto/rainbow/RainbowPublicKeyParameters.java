package org.spongycastle.pqc.crypto.rainbow;

public class RainbowPublicKeyParameters extends RainbowKeyParameters {
    public final short[] a;

    /* renamed from: a  reason: collision with other field name */
    public final short[][] f6738a;
    public final short[][] b;

    public RainbowPublicKeyParameters(int i, short[][] sArr, short[][] sArr2, short[] sArr3) {
        super(false, i);
        this.f6738a = sArr;
        this.b = sArr2;
        this.a = sArr3;
    }
}
