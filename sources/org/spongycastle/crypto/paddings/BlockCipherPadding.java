package org.spongycastle.crypto.paddings;

import java.security.SecureRandom;
import org.spongycastle.crypto.InvalidCipherTextException;

public interface BlockCipherPadding {
    int a(int i, byte[] bArr);

    int b(byte[] bArr) throws InvalidCipherTextException;

    void c(SecureRandom secureRandom) throws IllegalArgumentException;
}
