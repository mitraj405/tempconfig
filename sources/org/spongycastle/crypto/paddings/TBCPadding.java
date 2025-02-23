package org.spongycastle.crypto.paddings;

import com.google.firebase.perf.util.Constants;
import java.security.SecureRandom;
import org.spongycastle.crypto.InvalidCipherTextException;

public class TBCPadding implements BlockCipherPadding {
    public final int a(int i, byte[] bArr) {
        int i2;
        int length = bArr.length - i;
        if (i <= 0 ? (bArr[bArr.length - 1] & 1) != 0 : (bArr[i - 1] & 1) != 0) {
            i2 = 0;
        } else {
            i2 = Constants.MAX_HOST_LENGTH;
        }
        byte b = (byte) i2;
        while (i < bArr.length) {
            bArr[i] = b;
            i++;
        }
        return length;
    }

    public final int b(byte[] bArr) throws InvalidCipherTextException {
        byte b = bArr[bArr.length - 1];
        int length = bArr.length - 1;
        while (length > 0) {
            int i = length - 1;
            if (bArr[i] != b) {
                break;
            }
            length = i;
        }
        return bArr.length - length;
    }

    public final void c(SecureRandom secureRandom) throws IllegalArgumentException {
    }
}
