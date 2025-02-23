package org.spongycastle.pqc.jcajce.provider.util;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;

public abstract class CipherSpiExt extends CipherSpi {
    public int c;

    public abstract int a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException;

    public abstract byte[] b(int i, byte[] bArr, int i2) throws IllegalBlockSizeException, BadPaddingException;

    public abstract int c();

    public abstract byte[] d();

    public abstract int e(Key key) throws InvalidKeyException;

    public final byte[] engineDoFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        return b(i, bArr, i2);
    }

    public final int engineGetBlockSize() {
        return c();
    }

    public final byte[] engineGetIV() {
        return d();
    }

    public final int engineGetKeySize(Key key) throws InvalidKeyException {
        if (key instanceof Key) {
            return e(key);
        }
        throw new InvalidKeyException("Unsupported key.");
    }

    public final int engineGetOutputSize(int i) {
        return f(i);
    }

    public final AlgorithmParameters engineGetParameters() {
        return null;
    }

    public final void engineInit(int i, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e) {
            throw new InvalidParameterException(e.getMessage());
        }
    }

    public final void engineSetMode(String str) throws NoSuchAlgorithmException {
        i();
    }

    public final void engineSetPadding(String str) throws NoSuchPaddingException {
        j();
    }

    public final byte[] engineUpdate(byte[] bArr, int i, int i2) {
        return l(i, bArr, i2);
    }

    public abstract int f(int i);

    public abstract void g(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException;

    public abstract void h(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException;

    public abstract void i() throws NoSuchAlgorithmException;

    public abstract void j() throws NoSuchPaddingException;

    public abstract int k(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException;

    public abstract byte[] l(int i, byte[] bArr, int i2);

    public final int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        return a(bArr, i, i2, bArr2, i3);
    }

    public final int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException {
        return k(bArr, i, i2, bArr2, i3);
    }

    public final void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (algorithmParameters == null) {
            engineInit(i, key, secureRandom);
        } else {
            engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
        }
    }

    public final void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (key != null) {
            this.c = i;
            if (i == 1) {
                h(key, algorithmParameterSpec, secureRandom);
            } else if (i == 2) {
                g(key, algorithmParameterSpec);
            }
        } else {
            throw new InvalidKeyException();
        }
    }
}
