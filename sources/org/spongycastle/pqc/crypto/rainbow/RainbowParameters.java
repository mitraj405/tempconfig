package org.spongycastle.pqc.crypto.rainbow;

import org.spongycastle.crypto.CipherParameters;

public class RainbowParameters implements CipherParameters {
    public final int[] a;

    public RainbowParameters() {
        this.a = new int[]{6, 12, 17, 22, 33};
    }

    public final void a() throws Exception {
        int[] iArr = this.a;
        if (iArr == null) {
            throw new Exception("no layers defined.");
        } else if (iArr.length > 1) {
            int i = 0;
            while (i < iArr.length - 1) {
                int i2 = iArr[i];
                i++;
                if (i2 >= iArr[i]) {
                    throw new Exception("v[i] has to be smaller than v[i+1]");
                }
            }
        } else {
            throw new Exception("Rainbow needs at least 1 layer, such that v1 < v2.");
        }
    }

    public RainbowParameters(int[] iArr) {
        this.a = iArr;
        try {
            a();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
