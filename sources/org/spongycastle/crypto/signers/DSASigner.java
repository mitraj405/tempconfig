package org.spongycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.params.DSAKeyParameters;
import org.spongycastle.crypto.params.DSAParameters;
import org.spongycastle.crypto.params.DSAPrivateKeyParameters;
import org.spongycastle.crypto.params.DSAPublicKeyParameters;

public class DSASigner implements DSA {
    public SecureRandom a;

    /* renamed from: a  reason: collision with other field name */
    public DSAKeyParameters f6267a;

    /* renamed from: a  reason: collision with other field name */
    public final DSAKCalculator f6268a;

    public DSASigner() {
        this.f6268a = new RandomDSAKCalculator();
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(boolean r3, org.spongycastle.crypto.CipherParameters r4) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto L_0x0017
            boolean r1 = r4 instanceof org.spongycastle.crypto.params.ParametersWithRandom
            if (r1 == 0) goto L_0x0012
            org.spongycastle.crypto.params.ParametersWithRandom r4 = (org.spongycastle.crypto.params.ParametersWithRandom) r4
            org.spongycastle.crypto.CipherParameters r1 = r4.f6234a
            org.spongycastle.crypto.params.DSAPrivateKeyParameters r1 = (org.spongycastle.crypto.params.DSAPrivateKeyParameters) r1
            r2.f6267a = r1
            java.security.SecureRandom r4 = r4.a
            goto L_0x001c
        L_0x0012:
            org.spongycastle.crypto.params.DSAPrivateKeyParameters r4 = (org.spongycastle.crypto.params.DSAPrivateKeyParameters) r4
            r2.f6267a = r4
            goto L_0x001b
        L_0x0017:
            org.spongycastle.crypto.params.DSAPublicKeyParameters r4 = (org.spongycastle.crypto.params.DSAPublicKeyParameters) r4
            r2.f6267a = r4
        L_0x001b:
            r4 = r0
        L_0x001c:
            if (r3 == 0) goto L_0x0028
            org.spongycastle.crypto.signers.DSAKCalculator r3 = r2.f6268a
            boolean r3 = r3.a()
            if (r3 != 0) goto L_0x0028
            r3 = 1
            goto L_0x0029
        L_0x0028:
            r3 = 0
        L_0x0029:
            if (r3 != 0) goto L_0x002c
            goto L_0x0035
        L_0x002c:
            if (r4 == 0) goto L_0x0030
            r0 = r4
            goto L_0x0035
        L_0x0030:
            java.security.SecureRandom r0 = new java.security.SecureRandom
            r0.<init>()
        L_0x0035:
            r2.a = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.signers.DSASigner.a(boolean, org.spongycastle.crypto.CipherParameters):void");
    }

    public final BigInteger[] b(byte[] bArr) {
        DSAParameters dSAParameters = this.f6267a.a;
        BigInteger bigInteger = dSAParameters.b;
        BigInteger d = d(bigInteger, bArr);
        BigInteger bigInteger2 = ((DSAPrivateKeyParameters) this.f6267a).a;
        DSAKCalculator dSAKCalculator = this.f6268a;
        if (dSAKCalculator.a()) {
            dSAKCalculator.c(bigInteger, bigInteger2, bArr);
        } else {
            dSAKCalculator.d(bigInteger, this.a);
        }
        BigInteger b = dSAKCalculator.b();
        SecureRandom secureRandom = this.a;
        if (secureRandom == null) {
            secureRandom = new SecureRandom();
        }
        BigInteger mod = dSAParameters.a.modPow(b.add(new BigInteger(7, secureRandom).add(BigInteger.valueOf(128)).multiply(bigInteger)), dSAParameters.c).mod(bigInteger);
        return new BigInteger[]{mod, b.modInverse(bigInteger).multiply(d.add(bigInteger2.multiply(mod))).mod(bigInteger)};
    }

    public final boolean c(BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        DSAParameters dSAParameters = this.f6267a.a;
        BigInteger bigInteger3 = dSAParameters.b;
        BigInteger d = d(bigInteger3, bArr);
        BigInteger valueOf = BigInteger.valueOf(0);
        if (valueOf.compareTo(bigInteger) >= 0 || bigInteger3.compareTo(bigInteger) <= 0 || valueOf.compareTo(bigInteger2) >= 0 || bigInteger3.compareTo(bigInteger2) <= 0) {
            return false;
        }
        BigInteger modInverse = bigInteger2.modInverse(bigInteger3);
        BigInteger mod = d.multiply(modInverse).mod(bigInteger3);
        BigInteger mod2 = bigInteger.multiply(modInverse).mod(bigInteger3);
        BigInteger bigInteger4 = dSAParameters.a;
        BigInteger bigInteger5 = dSAParameters.c;
        return bigInteger4.modPow(mod, bigInteger5).multiply(((DSAPublicKeyParameters) this.f6267a).a.modPow(mod2, bigInteger5)).mod(bigInteger5).mod(bigInteger3).equals(bigInteger);
    }

    public final BigInteger d(BigInteger bigInteger, byte[] bArr) {
        if (bigInteger.bitLength() >= bArr.length * 8) {
            return new BigInteger(1, bArr);
        }
        int bitLength = bigInteger.bitLength() / 8;
        byte[] bArr2 = new byte[bitLength];
        System.arraycopy(bArr, 0, bArr2, 0, bitLength);
        return new BigInteger(1, bArr2);
    }

    public DSASigner(HMacDSAKCalculator hMacDSAKCalculator) {
        this.f6268a = hMacDSAKCalculator;
    }
}
