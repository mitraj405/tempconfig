package org.spongycastle.crypto.engines;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.params.ElGamalKeyParameters;
import org.spongycastle.crypto.params.ElGamalPrivateKeyParameters;
import org.spongycastle.crypto.params.ElGamalPublicKeyParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.util.BigIntegers;

public class ElGamalEngine implements AsymmetricBlockCipher {
    public static final BigInteger a = BigInteger.valueOf(0);
    public static final BigInteger b = BigInteger.valueOf(1);
    public static final BigInteger c = BigInteger.valueOf(2);

    /* renamed from: a  reason: collision with other field name */
    public int f5954a;

    /* renamed from: a  reason: collision with other field name */
    public SecureRandom f5955a;

    /* renamed from: a  reason: collision with other field name */
    public ElGamalKeyParameters f5956a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5957a;

    public final void a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.f5956a = (ElGamalKeyParameters) parametersWithRandom.f6234a;
            this.f5955a = parametersWithRandom.a;
        } else {
            this.f5956a = (ElGamalKeyParameters) cipherParameters;
            this.f5955a = new SecureRandom();
        }
        this.f5957a = z;
        this.f5954a = this.f5956a.a.b.bitLength();
        if (z) {
            if (!(this.f5956a instanceof ElGamalPublicKeyParameters)) {
                throw new IllegalArgumentException("ElGamalPublicKeyParameters are required for encryption.");
            }
        } else if (!(this.f5956a instanceof ElGamalPrivateKeyParameters)) {
            throw new IllegalArgumentException("ElGamalPrivateKeyParameters are required for decryption.");
        }
    }

    public final int b() {
        if (this.f5957a) {
            return ((this.f5954a + 7) / 8) * 2;
        }
        return (this.f5954a - 1) / 8;
    }

    public final byte[] c(int i, byte[] bArr, int i2) {
        int i3;
        if (this.f5956a != null) {
            if (this.f5957a) {
                i3 = ((this.f5954a - 1) + 7) / 8;
            } else {
                i3 = d();
            }
            if (i2 <= i3) {
                ElGamalKeyParameters elGamalKeyParameters = this.f5956a;
                BigInteger bigInteger = elGamalKeyParameters.a.b;
                if (elGamalKeyParameters instanceof ElGamalPrivateKeyParameters) {
                    int i4 = i2 / 2;
                    byte[] bArr2 = new byte[i4];
                    byte[] bArr3 = new byte[i4];
                    System.arraycopy(bArr, i, bArr2, 0, i4);
                    System.arraycopy(bArr, i + i4, bArr3, 0, i4);
                    BigInteger bigInteger2 = new BigInteger(1, bArr2);
                    return BigIntegers.b(bigInteger2.modPow(bigInteger.subtract(b).subtract(((ElGamalPrivateKeyParameters) this.f5956a).a), bigInteger).multiply(new BigInteger(1, bArr3)).mod(bigInteger));
                }
                if (!(i == 0 && i2 == bArr.length)) {
                    byte[] bArr4 = new byte[i2];
                    System.arraycopy(bArr, i, bArr4, 0, i2);
                    bArr = bArr4;
                }
                BigInteger bigInteger3 = new BigInteger(1, bArr);
                if (bigInteger3.compareTo(bigInteger) < 0) {
                    ElGamalPublicKeyParameters elGamalPublicKeyParameters = (ElGamalPublicKeyParameters) this.f5956a;
                    int bitLength = bigInteger.bitLength();
                    BigInteger bigInteger4 = new BigInteger(bitLength, this.f5955a);
                    while (true) {
                        if (!bigInteger4.equals(a) && bigInteger4.compareTo(bigInteger.subtract(c)) <= 0) {
                            break;
                        }
                        bigInteger4 = new BigInteger(bitLength, this.f5955a);
                    }
                    BigInteger modPow = this.f5956a.a.a.modPow(bigInteger4, bigInteger);
                    BigInteger mod = bigInteger3.multiply(elGamalPublicKeyParameters.a.modPow(bigInteger4, bigInteger)).mod(bigInteger);
                    byte[] byteArray = modPow.toByteArray();
                    byte[] byteArray2 = mod.toByteArray();
                    int b2 = b();
                    byte[] bArr5 = new byte[b2];
                    int i5 = b2 / 2;
                    if (byteArray.length > i5) {
                        System.arraycopy(byteArray, 1, bArr5, i5 - (byteArray.length - 1), byteArray.length - 1);
                    } else {
                        System.arraycopy(byteArray, 0, bArr5, i5 - byteArray.length, byteArray.length);
                    }
                    if (byteArray2.length > i5) {
                        System.arraycopy(byteArray2, 1, bArr5, b2 - (byteArray2.length - 1), byteArray2.length - 1);
                    } else {
                        System.arraycopy(byteArray2, 0, bArr5, b2 - byteArray2.length, byteArray2.length);
                    }
                    return bArr5;
                }
                throw new DataLengthException("input too large for ElGamal cipher.\n");
            }
            throw new DataLengthException("input too large for ElGamal cipher.\n");
        }
        throw new IllegalStateException("ElGamal engine not initialised");
    }

    public final int d() {
        if (this.f5957a) {
            return (this.f5954a - 1) / 8;
        }
        return ((this.f5954a + 7) / 8) * 2;
    }
}
