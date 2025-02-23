package org.spongycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECKeyParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.ec.FixedPointCombMultiplier;

public class ECDSASigner implements ECConstants, DSA {
    public SecureRandom a;

    /* renamed from: a  reason: collision with other field name */
    public ECKeyParameters f6270a;

    /* renamed from: a  reason: collision with other field name */
    public final DSAKCalculator f6271a;

    public ECDSASigner() {
        this.f6271a = new RandomDSAKCalculator();
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
            org.spongycastle.crypto.params.ECPrivateKeyParameters r1 = (org.spongycastle.crypto.params.ECPrivateKeyParameters) r1
            r2.f6270a = r1
            java.security.SecureRandom r4 = r4.a
            goto L_0x001c
        L_0x0012:
            org.spongycastle.crypto.params.ECPrivateKeyParameters r4 = (org.spongycastle.crypto.params.ECPrivateKeyParameters) r4
            r2.f6270a = r4
            goto L_0x001b
        L_0x0017:
            org.spongycastle.crypto.params.ECPublicKeyParameters r4 = (org.spongycastle.crypto.params.ECPublicKeyParameters) r4
            r2.f6270a = r4
        L_0x001b:
            r4 = r0
        L_0x001c:
            if (r3 == 0) goto L_0x0028
            org.spongycastle.crypto.signers.DSAKCalculator r3 = r2.f6271a
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
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.signers.ECDSASigner.a(boolean, org.spongycastle.crypto.CipherParameters):void");
    }

    public final BigInteger[] b(byte[] bArr) {
        ECDomainParameters eCDomainParameters = this.f6270a.a;
        BigInteger bigInteger = eCDomainParameters.g;
        int bitLength = bigInteger.bitLength();
        int length = bArr.length * 8;
        BigInteger bigInteger2 = new BigInteger(1, bArr);
        if (bitLength < length) {
            bigInteger2 = bigInteger2.shiftRight(length - bitLength);
        }
        BigInteger bigInteger3 = ((ECPrivateKeyParameters) this.f6270a).a;
        DSAKCalculator dSAKCalculator = this.f6271a;
        if (dSAKCalculator.a()) {
            dSAKCalculator.c(bigInteger, bigInteger3, bArr);
        } else {
            dSAKCalculator.d(bigInteger, this.a);
        }
        FixedPointCombMultiplier fixedPointCombMultiplier = new FixedPointCombMultiplier();
        while (true) {
            BigInteger b = dSAKCalculator.b();
            ECPoint o = fixedPointCombMultiplier.a(eCDomainParameters.f6230a, b).o();
            o.b();
            BigInteger mod = o.f6621a.t().mod(bigInteger);
            BigInteger bigInteger4 = ECConstants.a;
            if (!mod.equals(bigInteger4)) {
                BigInteger mod2 = b.modInverse(bigInteger).multiply(bigInteger2.add(bigInteger3.multiply(mod))).mod(bigInteger);
                if (!mod2.equals(bigInteger4)) {
                    return new BigInteger[]{mod, mod2};
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean c(java.math.BigInteger r7, java.math.BigInteger r8, byte[] r9) {
        /*
            r6 = this;
            org.spongycastle.crypto.params.ECKeyParameters r0 = r6.f6270a
            org.spongycastle.crypto.params.ECDomainParameters r0 = r0.a
            java.math.BigInteger r1 = r0.g
            int r2 = r1.bitLength()
            int r3 = r9.length
            int r3 = r3 * 8
            java.math.BigInteger r4 = new java.math.BigInteger
            r5 = 1
            r4.<init>(r5, r9)
            if (r2 >= r3) goto L_0x001a
            int r3 = r3 - r2
            java.math.BigInteger r4 = r4.shiftRight(r3)
        L_0x001a:
            java.math.BigInteger r9 = org.spongycastle.math.ec.ECConstants.b
            int r2 = r7.compareTo(r9)
            r3 = 0
            if (r2 < 0) goto L_0x00cd
            int r2 = r7.compareTo(r1)
            if (r2 < 0) goto L_0x002b
            goto L_0x00cd
        L_0x002b:
            int r9 = r8.compareTo(r9)
            if (r9 < 0) goto L_0x00cd
            int r9 = r8.compareTo(r1)
            if (r9 < 0) goto L_0x0039
            goto L_0x00cd
        L_0x0039:
            java.math.BigInteger r8 = r8.modInverse(r1)
            java.math.BigInteger r9 = r4.multiply(r8)
            java.math.BigInteger r9 = r9.mod(r1)
            java.math.BigInteger r8 = r7.multiply(r8)
            java.math.BigInteger r8 = r8.mod(r1)
            org.spongycastle.crypto.params.ECKeyParameters r2 = r6.f6270a
            org.spongycastle.crypto.params.ECPublicKeyParameters r2 = (org.spongycastle.crypto.params.ECPublicKeyParameters) r2
            org.spongycastle.math.ec.ECPoint r2 = r2.a
            org.spongycastle.math.ec.ECPoint r0 = r0.f6230a
            org.spongycastle.math.ec.ECPoint r8 = org.spongycastle.math.ec.ECAlgorithms.g(r0, r9, r2, r8)
            boolean r9 = r8.k()
            if (r9 == 0) goto L_0x0060
            return r3
        L_0x0060:
            org.spongycastle.math.ec.ECCurve r9 = r8.f6620a
            if (r9 == 0) goto L_0x00b7
            java.math.BigInteger r0 = r9.b
            if (r0 == 0) goto L_0x00b7
            java.math.BigInteger r2 = org.spongycastle.math.ec.ECConstants.f
            int r0 = r0.compareTo(r2)
            if (r0 > 0) goto L_0x00b7
            int r0 = r9.a
            if (r0 == r5) goto L_0x008e
            r2 = 2
            if (r0 == r2) goto L_0x0085
            r2 = 3
            if (r0 == r2) goto L_0x0085
            r2 = 4
            if (r0 == r2) goto L_0x0085
            r2 = 6
            if (r0 == r2) goto L_0x008e
            r2 = 7
            if (r0 == r2) goto L_0x008e
            r0 = 0
            goto L_0x0092
        L_0x0085:
            org.spongycastle.math.ec.ECFieldElement r0 = r8.j()
            org.spongycastle.math.ec.ECFieldElement r0 = r0.o()
            goto L_0x0092
        L_0x008e:
            org.spongycastle.math.ec.ECFieldElement r0 = r8.j()
        L_0x0092:
            if (r0 == 0) goto L_0x00b7
            boolean r2 = r0.i()
            if (r2 != 0) goto L_0x00b7
        L_0x009a:
            boolean r2 = r9.o(r7)
            if (r2 == 0) goto L_0x00b6
            org.spongycastle.math.ec.ECFieldElement r2 = r9.j(r7)
            org.spongycastle.math.ec.ECFieldElement r2 = r2.j(r0)
            org.spongycastle.math.ec.ECFieldElement r4 = r8.f6621a
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x00b1
            return r5
        L_0x00b1:
            java.math.BigInteger r7 = r7.add(r1)
            goto L_0x009a
        L_0x00b6:
            return r3
        L_0x00b7:
            org.spongycastle.math.ec.ECPoint r8 = r8.o()
            r8.b()
            org.spongycastle.math.ec.ECFieldElement r8 = r8.f6621a
            java.math.BigInteger r8 = r8.t()
            java.math.BigInteger r8 = r8.mod(r1)
            boolean r7 = r8.equals(r7)
            return r7
        L_0x00cd:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.signers.ECDSASigner.c(java.math.BigInteger, java.math.BigInteger, byte[]):boolean");
    }

    public ECDSASigner(HMacDSAKCalculator hMacDSAKCalculator) {
        this.f6271a = hMacDSAKCalculator;
    }
}
