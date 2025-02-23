package org.spongycastle.crypto.engines;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.crypto.params.RSAPrivateCrtKeyParameters;

class RSACoreEngine {
    public RSAKeyParameters a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6029a;

    public final BigInteger a(int i, byte[] bArr, int i2) {
        if (i2 > c() + 1) {
            throw new DataLengthException("input too large for RSA cipher.");
        } else if (i2 != c() + 1 || this.f6029a) {
            if (!(i == 0 && i2 == bArr.length)) {
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, i, bArr2, 0, i2);
                bArr = bArr2;
            }
            BigInteger bigInteger = new BigInteger(1, bArr);
            if (bigInteger.compareTo(this.a.a) < 0) {
                return bigInteger;
            }
            throw new DataLengthException("input too large for RSA cipher.");
        } else {
            throw new DataLengthException("input too large for RSA cipher.");
        }
    }

    public final byte[] b(BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (this.f6029a) {
            if (byteArray[0] == 0 && byteArray.length > d()) {
                int length = byteArray.length - 1;
                byte[] bArr = new byte[length];
                System.arraycopy(byteArray, 1, bArr, 0, length);
                return bArr;
            } else if (byteArray.length < d()) {
                int d = d();
                byte[] bArr2 = new byte[d];
                System.arraycopy(byteArray, 0, bArr2, d - byteArray.length, byteArray.length);
                return bArr2;
            }
        } else if (byteArray[0] == 0) {
            int length2 = byteArray.length - 1;
            byte[] bArr3 = new byte[length2];
            System.arraycopy(byteArray, 1, bArr3, 0, length2);
            return bArr3;
        }
        return byteArray;
    }

    public final int c() {
        int bitLength = this.a.a.bitLength();
        if (this.f6029a) {
            return ((bitLength + 7) / 8) - 1;
        }
        return (bitLength + 7) / 8;
    }

    public final int d() {
        int bitLength = this.a.a.bitLength();
        if (this.f6029a) {
            return (bitLength + 7) / 8;
        }
        return ((bitLength + 7) / 8) - 1;
    }

    public final void e(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithRandom) {
            this.a = (RSAKeyParameters) ((ParametersWithRandom) cipherParameters).f6234a;
        } else {
            this.a = (RSAKeyParameters) cipherParameters;
        }
        this.f6029a = z;
    }

    public final BigInteger f(BigInteger bigInteger) {
        RSAKeyParameters rSAKeyParameters = this.a;
        if (!(rSAKeyParameters instanceof RSAPrivateCrtKeyParameters)) {
            return bigInteger.modPow(rSAKeyParameters.b, rSAKeyParameters.a);
        }
        RSAPrivateCrtKeyParameters rSAPrivateCrtKeyParameters = (RSAPrivateCrtKeyParameters) rSAKeyParameters;
        BigInteger bigInteger2 = rSAPrivateCrtKeyParameters.e;
        BigInteger modPow = bigInteger.remainder(bigInteger2).modPow(rSAPrivateCrtKeyParameters.g, bigInteger2);
        BigInteger bigInteger3 = rSAPrivateCrtKeyParameters.f;
        BigInteger modPow2 = bigInteger.remainder(bigInteger3).modPow(rSAPrivateCrtKeyParameters.h, bigInteger3);
        return modPow.subtract(modPow2).multiply(rSAPrivateCrtKeyParameters.i).mod(bigInteger2).multiply(bigInteger3).add(modPow2);
    }
}
