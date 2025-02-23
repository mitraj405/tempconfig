package org.spongycastle.crypto.params;

public class DESedeParameters extends DESParameters {
    public static boolean c(byte[] bArr) {
        boolean z;
        boolean z2;
        boolean z3;
        if (bArr.length == 16) {
            boolean z4 = false;
            for (int i = 0; i != 8; i++) {
                if (bArr[i] != bArr[i + 8]) {
                    z4 = true;
                }
            }
            return z4;
        }
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        for (int i2 = 0; i2 != 8; i2++) {
            byte b = bArr[i2];
            byte b2 = bArr[i2 + 8];
            if (b != b2) {
                z = true;
            } else {
                z = false;
            }
            z5 |= z;
            byte b3 = bArr[i2 + 16];
            if (b != b3) {
                z2 = true;
            } else {
                z2 = false;
            }
            z6 |= z2;
            if (b2 != b3) {
                z3 = true;
            } else {
                z3 = false;
            }
            z7 |= z3;
        }
        if (!z5 || !z6 || !z7) {
            return false;
        }
        return true;
    }
}
