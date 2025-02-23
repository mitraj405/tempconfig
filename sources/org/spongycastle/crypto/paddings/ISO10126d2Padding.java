package org.spongycastle.crypto.paddings;

import com.google.common.primitives.UnsignedBytes;
import java.security.SecureRandom;
import org.spongycastle.crypto.InvalidCipherTextException;

public class ISO10126d2Padding implements BlockCipherPadding {
    public SecureRandom a;

    public final int a(int i, byte[] bArr) {
        byte length = (byte) (bArr.length - i);
        while (i < bArr.length - 1) {
            bArr[i] = (byte) this.a.nextInt();
            i++;
        }
        bArr[i] = length;
        return length;
    }

    public final int b(byte[] bArr) throws InvalidCipherTextException {
        byte b = bArr[bArr.length - 1] & UnsignedBytes.MAX_VALUE;
        if (b <= bArr.length) {
            return b;
        }
        throw new InvalidCipherTextException("pad block corrupted");
    }

    public final void c(SecureRandom secureRandom) throws IllegalArgumentException {
        if (secureRandom != null) {
            this.a = secureRandom;
        } else {
            this.a = new SecureRandom();
        }
    }
}
