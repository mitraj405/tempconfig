package defpackage;

import java.security.SecureRandom;
import java.util.Arrays;

/* renamed from: Ca  reason: default package */
/* compiled from: EmvTerminal */
public final class Ca {
    static {
        new SecureRandom();
    }

    public static byte[] a(sz szVar) {
        byte[] bArr;
        int i = szVar.a;
        byte[] bArr2 = new byte[i];
        if (szVar.f3282a == Ba.h) {
            byte[] bArr3 = new byte[4];
            byte O = r1.O(bArr3[0], 5);
            bArr3[0] = O;
            bArr3[0] = r1.O(O, 3);
            bArr = Arrays.copyOf(bArr3, 4);
        } else {
            bArr = null;
        }
        r1.g(bArr);
        if (bArr != null) {
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i));
        }
        return bArr2;
    }
}
