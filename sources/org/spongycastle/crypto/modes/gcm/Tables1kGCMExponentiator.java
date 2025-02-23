package org.spongycastle.crypto.modes.gcm;

import java.util.Vector;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;

public class Tables1kGCMExponentiator implements GCMExponentiator {
    public Vector a;

    public final void a(byte[] bArr, long j) {
        int[] iArr = GCMUtil.a;
        int[] iArr2 = new int[4];
        int i = 0;
        iArr2[0] = Integer.MIN_VALUE;
        while (j > 0) {
            if ((1 & j) != 0) {
                int size = this.a.size();
                if (size <= i) {
                    int[] iArr3 = (int[]) this.a.elementAt(size - 1);
                    do {
                        iArr3 = Arrays.d(iArr3);
                        GCMUtil.b(iArr3, iArr3);
                        this.a.addElement(iArr3);
                        size++;
                    } while (size <= i);
                }
                GCMUtil.b(iArr2, (int[]) this.a.elementAt(i));
            }
            i++;
            j >>>= 1;
        }
        Pack.d(bArr, iArr2);
    }

    public final void b(byte[] bArr) {
        int[] a2 = GCMUtil.a(bArr);
        Vector vector = this.a;
        if (vector == null || !Arrays.b(a2, (int[]) vector.elementAt(0))) {
            Vector vector2 = new Vector(8);
            this.a = vector2;
            vector2.addElement(a2);
        }
    }
}
