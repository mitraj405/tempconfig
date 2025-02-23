package org.spongycastle.pqc.jcajce.provider.util;

import java.io.ByteArrayOutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;

public abstract class AsymmetricBlockCipher extends CipherSpiExt {
    public final ByteArrayOutputStream a = new ByteArrayOutputStream();
    public int d;
    public int e;

    public final int a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        if (bArr2.length >= f(i2)) {
            byte[] b = b(i, bArr, i2);
            System.arraycopy(b, 0, bArr2, i3, b.length);
            return b.length;
        }
        throw new ShortBufferException("Output buffer too short.");
    }

    public final byte[] b(int i, byte[] bArr, int i2) throws IllegalBlockSizeException, BadPaddingException {
        ByteArrayOutputStream byteArrayOutputStream = this.a;
        int size = byteArrayOutputStream.size() + i2;
        int i3 = this.c;
        if (i3 == 1) {
            if (size > this.d) {
                throw new IllegalBlockSizeException(lf.k(lf.m("The length of the plaintext (", size, " bytes) is not supported by the cipher (max. "), this.d, " bytes)."));
            }
        } else if (i3 == 2 && size != this.e) {
            throw new IllegalBlockSizeException("Illegal ciphertext length (expected " + this.e + " bytes, was " + size + " bytes).");
        }
        l(i, bArr, i2);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.reset();
        int i4 = this.c;
        if (i4 == 1) {
            return p(byteArray);
        }
        if (i4 != 2) {
            return null;
        }
        return o(byteArray);
    }

    public final int c() {
        if (this.c == 1) {
            return this.d;
        }
        return this.e;
    }

    public final byte[] d() {
        return null;
    }

    public final int f(int i) {
        int size = this.a.size() + i;
        int c = c();
        if (size > c) {
            return 0;
        }
        return c;
    }

    public final void g(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.c = 2;
        m(key);
    }

    public final void h(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.c = 1;
        n(key, secureRandom);
    }

    public final int k(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        l(i, bArr, i2);
        return 0;
    }

    public final byte[] l(int i, byte[] bArr, int i2) {
        if (i2 != 0) {
            this.a.write(bArr, i, i2);
        }
        return new byte[0];
    }

    public abstract void m(Key key) throws InvalidKeyException, InvalidAlgorithmParameterException;

    public abstract void n(Key key, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException;

    public abstract byte[] o(byte[] bArr) throws IllegalBlockSizeException, BadPaddingException;

    public abstract byte[] p(byte[] bArr) throws IllegalBlockSizeException, BadPaddingException;

    public final void i() {
    }

    public final void j() {
    }
}
