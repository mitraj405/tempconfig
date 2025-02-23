package org.spongycastle.crypto.paddings;

import com.google.common.primitives.UnsignedBytes;
import java.security.SecureRandom;
import org.spongycastle.crypto.InvalidCipherTextException;

public class PKCS7Padding implements BlockCipherPadding {
    public final int a(int i, byte[] bArr) {
        byte length = (byte) (bArr.length - i);
        while (i < bArr.length) {
            bArr[i] = length;
            i++;
        }
        return length;
    }

    public final int b(byte[] bArr) throws InvalidCipherTextException {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        byte b = bArr[bArr.length - 1] & UnsignedBytes.MAX_VALUE;
        byte b2 = (byte) b;
        if (b > bArr.length) {
            z = true;
        } else {
            z = false;
        }
        if (b == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        boolean z5 = z | z2;
        for (int i = 0; i < bArr.length; i++) {
            if (bArr.length - i <= b) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (bArr[i] != b2) {
                z4 = true;
            } else {
                z4 = false;
            }
            z5 |= z3 & z4;
        }
        if (!z5) {
            return b;
        }
        throw new InvalidCipherTextException("pad block corrupted");
    }

    public final void c(SecureRandom secureRandom) throws IllegalArgumentException {
    }
}
