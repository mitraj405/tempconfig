package org.spongycastle.crypto.paddings;

import java.security.SecureRandom;
import org.spongycastle.crypto.InvalidCipherTextException;

public class ZeroBytePadding implements BlockCipherPadding {
    public final int a(int i, byte[] bArr) {
        int length = bArr.length - i;
        while (i < bArr.length) {
            bArr[i] = 0;
            i++;
        }
        return length;
    }

    public final int b(byte[] bArr) throws InvalidCipherTextException {
        int length = bArr.length;
        while (length > 0) {
            int i = length - 1;
            if (bArr[i] != 0) {
                break;
            }
            length = i;
        }
        return bArr.length - length;
    }

    public final void c(SecureRandom secureRandom) throws IllegalArgumentException {
    }
}
