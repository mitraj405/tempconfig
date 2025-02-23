package org.spongycastle.pqc.crypto.gmss;

import org.spongycastle.util.Arrays;

public class GMSSParameters {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public int[] f6666a;
    public int[] b;
    public int[] c;

    public GMSSParameters(int i, int[] iArr, int[] iArr2, int[] iArr3) throws IllegalArgumentException {
        boolean z;
        String str;
        this.a = i;
        if (i == iArr2.length && i == iArr.length && i == iArr3.length) {
            z = true;
            str = "";
        } else {
            str = "Unexpected parameterset format";
            z = false;
        }
        for (int i2 = 0; i2 < this.a; i2++) {
            int i3 = iArr3[i2];
            if (i3 < 2 || (iArr[i2] - i3) % 2 != 0) {
                str = "Wrong parameter K (K >= 2 and H-K even required)!";
                z = false;
            }
            if (iArr[i2] < 4 || iArr2[i2] < 2) {
                str = "Wrong parameter H or w (H > 3 and w > 1 required)!";
                z = false;
            }
        }
        if (z) {
            this.f6666a = Arrays.d(iArr);
            this.b = Arrays.d(iArr2);
            this.c = Arrays.d(iArr3);
            return;
        }
        throw new IllegalArgumentException(str);
    }
}
