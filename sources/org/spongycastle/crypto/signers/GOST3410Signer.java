package org.spongycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.params.GOST3410KeyParameters;
import org.spongycastle.crypto.params.GOST3410Parameters;
import org.spongycastle.crypto.params.GOST3410PrivateKeyParameters;
import org.spongycastle.crypto.params.GOST3410PublicKeyParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;

public class GOST3410Signer implements DSA {
    public SecureRandom a;

    /* renamed from: a  reason: collision with other field name */
    public GOST3410KeyParameters f6276a;

    public final void a(boolean z, CipherParameters cipherParameters) {
        if (!z) {
            this.f6276a = (GOST3410PublicKeyParameters) cipherParameters;
        } else if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.a = parametersWithRandom.a;
            this.f6276a = (GOST3410PrivateKeyParameters) parametersWithRandom.f6234a;
        } else {
            this.a = new SecureRandom();
            this.f6276a = (GOST3410PrivateKeyParameters) cipherParameters;
        }
    }

    public final BigInteger[] b(byte[] bArr) {
        BigInteger bigInteger;
        BigInteger bigInteger2;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        for (int i = 0; i != length; i++) {
            bArr2[i] = bArr[(length - 1) - i];
        }
        BigInteger bigInteger3 = new BigInteger(1, bArr2);
        GOST3410Parameters gOST3410Parameters = this.f6276a.a;
        do {
            bigInteger = new BigInteger(gOST3410Parameters.b.bitLength(), this.a);
            bigInteger2 = gOST3410Parameters.b;
        } while (bigInteger.compareTo(bigInteger2) >= 0);
        BigInteger mod = gOST3410Parameters.c.modPow(bigInteger, gOST3410Parameters.a).mod(bigInteger2);
        return new BigInteger[]{mod, bigInteger.multiply(bigInteger3).add(((GOST3410PrivateKeyParameters) this.f6276a).a.multiply(mod)).mod(bigInteger2)};
    }

    public final boolean c(BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        for (int i = 0; i != length; i++) {
            bArr2[i] = bArr[(length - 1) - i];
        }
        BigInteger bigInteger3 = new BigInteger(1, bArr2);
        GOST3410Parameters gOST3410Parameters = this.f6276a.a;
        BigInteger valueOf = BigInteger.valueOf(0);
        if (valueOf.compareTo(bigInteger) < 0 && gOST3410Parameters.b.compareTo(bigInteger) > 0 && valueOf.compareTo(bigInteger2) < 0) {
            BigInteger bigInteger4 = gOST3410Parameters.b;
            if (bigInteger4.compareTo(bigInteger2) > 0) {
                BigInteger modPow = bigInteger3.modPow(bigInteger4.subtract(new BigInteger(C0515Ga.FARE_ONLY)), bigInteger4);
                BigInteger mod = bigInteger2.multiply(modPow).mod(bigInteger4);
                BigInteger mod2 = bigInteger4.subtract(bigInteger).multiply(modPow).mod(bigInteger4);
                BigInteger bigInteger5 = gOST3410Parameters.c;
                BigInteger bigInteger6 = gOST3410Parameters.a;
                return bigInteger5.modPow(mod, bigInteger6).multiply(((GOST3410PublicKeyParameters) this.f6276a).a.modPow(mod2, bigInteger6)).mod(bigInteger6).mod(bigInteger4).equals(bigInteger);
            }
        }
        return false;
    }
}
