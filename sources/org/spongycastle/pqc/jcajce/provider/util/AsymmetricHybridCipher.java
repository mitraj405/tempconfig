package org.spongycastle.pqc.jcajce.provider.util;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.ShortBufferException;

public abstract class AsymmetricHybridCipher extends CipherSpiExt {
    public final int a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException, BadPaddingException {
        if (bArr2.length >= f(i2)) {
            byte[] b = b(i, bArr, i2);
            System.arraycopy(b, 0, bArr2, i3, b.length);
            return b.length;
        }
        throw new ShortBufferException("Output buffer too short.");
    }

    public final int c() {
        return 0;
    }

    public final byte[] d() {
        return null;
    }

    public final int f(int i) {
        if (this.c == 1) {
            n();
            return 0;
        }
        m();
        return 0;
    }

    public final void g(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.c = 2;
        o(key);
    }

    public final void h(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.c = 1;
        p(key, secureRandom);
    }

    public final int k(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException {
        if (bArr2.length >= f(i2)) {
            byte[] l = l(i, bArr, i2);
            System.arraycopy(l, 0, bArr2, i3, l.length);
            return l.length;
        }
        throw new ShortBufferException("output");
    }

    public abstract void m();

    public abstract void n();

    public abstract void o(Key key) throws InvalidKeyException, InvalidAlgorithmParameterException;

    public abstract void p(Key key, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException;

    public final void i() {
    }

    public final void j() {
    }
}
