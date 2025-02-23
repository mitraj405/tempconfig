package org.spongycastle.crypto.engines;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.BasicAgreement;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.KeyParser;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.generators.EphemeralKeyPairGenerator;
import org.spongycastle.crypto.generators.KDF2BytesGenerator;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.IESParameters;
import org.spongycastle.crypto.params.IESWithCipherParameters;
import org.spongycastle.crypto.params.KDFParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;
import org.spongycastle.util.Pack;

public class IESEngine {
    public final BasicAgreement a;

    /* renamed from: a  reason: collision with other field name */
    public final BufferedBlockCipher f5982a;

    /* renamed from: a  reason: collision with other field name */
    public CipherParameters f5983a;

    /* renamed from: a  reason: collision with other field name */
    public final DerivationFunction f5984a;

    /* renamed from: a  reason: collision with other field name */
    public KeyParser f5985a;

    /* renamed from: a  reason: collision with other field name */
    public final Mac f5986a;

    /* renamed from: a  reason: collision with other field name */
    public EphemeralKeyPairGenerator f5987a;

    /* renamed from: a  reason: collision with other field name */
    public IESParameters f5988a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5989a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f5990a;
    public CipherParameters b;

    /* renamed from: b  reason: collision with other field name */
    public byte[] f5991b;

    public IESEngine(BasicAgreement basicAgreement, KDF2BytesGenerator kDF2BytesGenerator, HMac hMac) {
        this.a = basicAgreement;
        this.f5984a = kDF2BytesGenerator;
        this.f5986a = hMac;
        byte[] bArr = new byte[hMac.f6108a];
        this.f5982a = null;
    }

    public final byte[] a(byte[] bArr, int i) throws InvalidCipherTextException {
        byte[] bArr2;
        byte[] bArr3;
        int i2;
        byte[] bArr4;
        byte[] bArr5 = bArr;
        int i3 = i;
        int length = this.f5990a.length;
        Mac mac = this.f5986a;
        if (i3 >= mac.e() + length) {
            DerivationFunction derivationFunction = this.f5984a;
            BufferedBlockCipher bufferedBlockCipher = this.f5982a;
            if (bufferedBlockCipher == null) {
                int length2 = (i3 - this.f5990a.length) - mac.e();
                byte[] bArr6 = new byte[length2];
                int i4 = this.f5988a.c / 8;
                bArr3 = new byte[i4];
                int i5 = length2 + i4;
                byte[] bArr7 = new byte[i5];
                derivationFunction.b(bArr7, i5);
                if (this.f5990a.length != 0) {
                    System.arraycopy(bArr7, 0, bArr3, 0, i4);
                    System.arraycopy(bArr7, i4, bArr6, 0, length2);
                } else {
                    System.arraycopy(bArr7, 0, bArr6, 0, length2);
                    System.arraycopy(bArr7, length2, bArr3, 0, i4);
                }
                byte[] bArr8 = new byte[length2];
                for (int i6 = 0; i6 != length2; i6++) {
                    bArr8[i6] = (byte) (bArr5[(this.f5990a.length + 0) + i6] ^ bArr6[i6]);
                }
                bArr2 = bArr8;
                i2 = 0;
            } else {
                IESParameters iESParameters = this.f5988a;
                int i7 = ((IESWithCipherParameters) iESParameters).d / 8;
                byte[] bArr9 = new byte[i7];
                int i8 = iESParameters.c / 8;
                byte[] bArr10 = new byte[i8];
                int i9 = i7 + i8;
                byte[] bArr11 = new byte[i9];
                derivationFunction.b(bArr11, i9);
                System.arraycopy(bArr11, 0, bArr9, 0, i7);
                System.arraycopy(bArr11, i7, bArr10, 0, i8);
                CipherParameters keyParameter = new KeyParameter(bArr9, 0, i7);
                byte[] bArr12 = this.f5991b;
                if (bArr12 != null) {
                    keyParameter = new ParametersWithIV(keyParameter, bArr12, 0, bArr12.length);
                }
                bufferedBlockCipher.e(false, keyParameter);
                bArr2 = new byte[bufferedBlockCipher.c((i3 - this.f5990a.length) - mac.e())];
                BufferedBlockCipher bufferedBlockCipher2 = this.f5982a;
                byte[] bArr13 = this.f5990a;
                i2 = bufferedBlockCipher2.f(bArr, bArr13.length + 0, (i3 - bArr13.length) - mac.e(), bArr2, 0);
                bArr3 = bArr10;
            }
            byte[] bArr14 = this.f5988a.b;
            if (this.f5990a.length != 0) {
                bArr4 = d(bArr14);
            } else {
                bArr4 = null;
            }
            int i10 = 0 + i3;
            byte[] n = Arrays.n(i10 - mac.e(), bArr5, i10);
            int length3 = n.length;
            byte[] bArr15 = new byte[length3];
            mac.a(new KeyParameter(bArr3, 0, bArr3.length));
            byte[] bArr16 = this.f5990a;
            mac.update(bArr5, bArr16.length + 0, (i3 - bArr16.length) - length3);
            if (bArr14 != null) {
                mac.update(bArr14, 0, bArr14.length);
            }
            if (this.f5990a.length != 0) {
                mac.update(bArr4, 0, bArr4.length);
            }
            mac.c(0, bArr15);
            if (!Arrays.l(n, bArr15)) {
                throw new InvalidCipherTextException("invalid MAC");
            } else if (bufferedBlockCipher == null) {
                return bArr2;
            } else {
                return Arrays.n(0, bArr2, bufferedBlockCipher.a(i2, bArr2) + i2);
            }
        } else {
            throw new InvalidCipherTextException("Length of input must be greater than the MAC and V combined");
        }
    }

    public final byte[] b(byte[] bArr, int i) throws InvalidCipherTextException {
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        DerivationFunction derivationFunction = this.f5984a;
        BufferedBlockCipher bufferedBlockCipher = this.f5982a;
        if (bufferedBlockCipher == null) {
            byte[] bArr5 = new byte[i];
            int i2 = this.f5988a.c / 8;
            bArr2 = new byte[i2];
            int i3 = i + i2;
            byte[] bArr6 = new byte[i3];
            derivationFunction.b(bArr6, i3);
            if (this.f5990a.length != 0) {
                System.arraycopy(bArr6, 0, bArr2, 0, i2);
                System.arraycopy(bArr6, i2, bArr5, 0, i);
            } else {
                System.arraycopy(bArr6, 0, bArr5, 0, i);
                System.arraycopy(bArr6, i, bArr2, 0, i2);
            }
            bArr3 = new byte[i];
            for (int i4 = 0; i4 != i; i4++) {
                bArr3[i4] = (byte) (bArr[0 + i4] ^ bArr5[i4]);
            }
        } else {
            IESParameters iESParameters = this.f5988a;
            int i5 = ((IESWithCipherParameters) iESParameters).d / 8;
            byte[] bArr7 = new byte[i5];
            int i6 = iESParameters.c / 8;
            byte[] bArr8 = new byte[i6];
            int i7 = i5 + i6;
            byte[] bArr9 = new byte[i7];
            derivationFunction.b(bArr9, i7);
            System.arraycopy(bArr9, 0, bArr7, 0, i5);
            System.arraycopy(bArr9, i5, bArr8, 0, i6);
            if (this.f5991b != null) {
                bufferedBlockCipher.e(true, new ParametersWithIV(new KeyParameter(bArr7, 0, i5), this.f5991b));
            } else {
                bufferedBlockCipher.e(true, new KeyParameter(bArr7, 0, i5));
            }
            bArr3 = new byte[bufferedBlockCipher.c(i)];
            int f = this.f5982a.f(bArr, 0, i, bArr3, 0);
            i = bufferedBlockCipher.a(f, bArr3) + f;
            bArr2 = bArr8;
        }
        byte[] bArr10 = this.f5988a.b;
        if (this.f5990a.length != 0) {
            bArr4 = d(bArr10);
        } else {
            bArr4 = null;
        }
        Mac mac = this.f5986a;
        int e = mac.e();
        byte[] bArr11 = new byte[e];
        mac.a(new KeyParameter(bArr2, 0, bArr2.length));
        mac.update(bArr3, 0, bArr3.length);
        if (bArr10 != null) {
            mac.update(bArr10, 0, bArr10.length);
        }
        if (this.f5990a.length != 0) {
            mac.update(bArr4, 0, bArr4.length);
        }
        mac.c(0, bArr11);
        byte[] bArr12 = this.f5990a;
        byte[] bArr13 = new byte[(bArr12.length + i + e)];
        System.arraycopy(bArr12, 0, bArr13, 0, bArr12.length);
        System.arraycopy(bArr3, 0, bArr13, this.f5990a.length, i);
        System.arraycopy(bArr11, 0, bArr13, this.f5990a.length + i, e);
        return bArr13;
    }

    public final void c(CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.f5991b = parametersWithIV.f6233a;
            this.f5988a = (IESParameters) parametersWithIV.a;
            return;
        }
        this.f5991b = null;
        this.f5988a = (IESParameters) cipherParameters;
    }

    public byte[] d(byte[] bArr) {
        byte[] bArr2 = new byte[8];
        if (bArr != null) {
            Pack.j(((long) bArr.length) * 8, bArr2, 0);
        }
        return bArr2;
    }

    public final void e(boolean z, AsymmetricKeyParameter asymmetricKeyParameter, AsymmetricKeyParameter asymmetricKeyParameter2, CipherParameters cipherParameters) {
        this.f5989a = z;
        this.f5983a = asymmetricKeyParameter;
        this.b = asymmetricKeyParameter2;
        this.f5990a = new byte[0];
        c(cipherParameters);
    }

    public final byte[] f(byte[] bArr, int i) throws InvalidCipherTextException {
        byte[] bArr2;
        if (this.f5989a) {
            EphemeralKeyPairGenerator ephemeralKeyPairGenerator = this.f5987a;
            if (ephemeralKeyPairGenerator != null) {
                AsymmetricCipherKeyPair a2 = ephemeralKeyPairGenerator.a.a();
                this.f5983a = a2.b;
                this.f5990a = ephemeralKeyPairGenerator.f6083a.a(a2.a);
            }
        } else if (this.f5985a != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, 0, i);
            try {
                this.b = this.f5985a.a(byteArrayInputStream);
                this.f5990a = Arrays.n(0, bArr, (i - byteArrayInputStream.available()) + 0);
            } catch (IOException e) {
                throw new InvalidCipherTextException(C0709Uj.g(e, new StringBuilder("unable to recover ephemeral public key: ")), e);
            } catch (IllegalArgumentException e2) {
                throw new InvalidCipherTextException("unable to recover ephemeral public key: " + e2.getMessage(), e2);
            }
        }
        CipherParameters cipherParameters = this.f5983a;
        BasicAgreement basicAgreement = this.a;
        basicAgreement.a(cipherParameters);
        byte[] a3 = BigIntegers.a(basicAgreement.getFieldSize(), basicAgreement.b(this.b));
        byte[] bArr3 = this.f5990a;
        if (bArr3.length != 0) {
            byte[] i2 = Arrays.i(bArr3, a3);
            Arrays.p(a3, (byte) 0);
            a3 = i2;
        }
        try {
            this.f5984a.a(new KDFParameters(a3, this.f5988a.a));
            if (this.f5989a) {
                bArr2 = b(bArr, i);
            } else {
                bArr2 = a(bArr, i);
            }
            return bArr2;
        } finally {
            Arrays.p(a3, (byte) 0);
        }
    }

    public IESEngine(BasicAgreement basicAgreement, KDF2BytesGenerator kDF2BytesGenerator, HMac hMac, PaddedBufferedBlockCipher paddedBufferedBlockCipher) {
        this.a = basicAgreement;
        this.f5984a = kDF2BytesGenerator;
        this.f5986a = hMac;
        byte[] bArr = new byte[hMac.f6108a];
        this.f5982a = paddedBufferedBlockCipher;
    }
}
