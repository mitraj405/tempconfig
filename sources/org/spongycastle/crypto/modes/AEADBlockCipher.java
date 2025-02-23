package org.spongycastle.crypto.modes;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;

public interface AEADBlockCipher {
    void a(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException;

    int c(int i, byte[] bArr) throws IllegalStateException, InvalidCipherTextException;

    int d(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException;

    int e(int i);

    int f(int i);

    BlockCipher g();

    byte[] h();

    void i(int i, byte[] bArr, int i2);
}
