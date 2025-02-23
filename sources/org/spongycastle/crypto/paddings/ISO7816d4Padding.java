package org.spongycastle.crypto.paddings;

import com.google.common.primitives.UnsignedBytes;
import java.security.SecureRandom;
import org.spongycastle.crypto.InvalidCipherTextException;

public class ISO7816d4Padding implements BlockCipherPadding {
    public final int a(int i, byte[] bArr) {
        int length = bArr.length - i;
        bArr[i] = UnsignedBytes.MAX_POWER_OF_TWO;
        while (true) {
            i++;
            if (i >= bArr.length) {
                return length;
            }
            bArr[i] = 0;
        }
    }

    public final int b(byte[] bArr) throws InvalidCipherTextException {
        int length = bArr.length;
        do {
            length--;
            if (length <= 0 || bArr[length] != 0) {
            }
            length--;
            break;
        } while (bArr[length] != 0);
        if (bArr[length] == Byte.MIN_VALUE) {
            return bArr.length - length;
        }
        throw new InvalidCipherTextException("pad block corrupted");
    }

    public final void c(SecureRandom secureRandom) throws IllegalArgumentException {
    }
}
