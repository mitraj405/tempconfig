package org.spongycastle.crypto.signers;

import com.google.firebase.perf.util.Constants;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.digests.SM3Digest;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECKeyParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.ParametersWithID;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.ec.FixedPointCombMultiplier;
import org.spongycastle.util.BigIntegers;

public class SM2Signer implements DSA, ECConstants {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public ECDomainParameters f6294a;

    /* renamed from: a  reason: collision with other field name */
    public ECKeyParameters f6295a;

    /* renamed from: a  reason: collision with other field name */
    public final RandomDSAKCalculator f6296a = new RandomDSAKCalculator();

    /* renamed from: a  reason: collision with other field name */
    public ECPoint f6297a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f6298a;

    public final void a(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithID) {
            ((ParametersWithID) cipherParameters).getClass();
            cipherParameters = null;
            this.f6298a = null;
        } else {
            this.f6298a = new byte[0];
        }
        if (z) {
            boolean z2 = cipherParameters instanceof ParametersWithRandom;
            RandomDSAKCalculator randomDSAKCalculator = this.f6296a;
            if (z2) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                ECKeyParameters eCKeyParameters = (ECKeyParameters) parametersWithRandom.f6234a;
                this.f6295a = eCKeyParameters;
                ECDomainParameters eCDomainParameters = eCKeyParameters.a;
                this.f6294a = eCDomainParameters;
                randomDSAKCalculator.a = eCDomainParameters.g;
                randomDSAKCalculator.f6293a = parametersWithRandom.a;
            } else {
                ECKeyParameters eCKeyParameters2 = (ECKeyParameters) cipherParameters;
                this.f6295a = eCKeyParameters2;
                ECDomainParameters eCDomainParameters2 = eCKeyParameters2.a;
                this.f6294a = eCDomainParameters2;
                BigInteger bigInteger = eCDomainParameters2.g;
                SecureRandom secureRandom = new SecureRandom();
                randomDSAKCalculator.a = bigInteger;
                randomDSAKCalculator.f6293a = secureRandom;
            }
            this.f6297a = this.f6294a.f6230a.m(((ECPrivateKeyParameters) this.f6295a).a).o();
        } else {
            ECKeyParameters eCKeyParameters3 = (ECKeyParameters) cipherParameters;
            this.f6295a = eCKeyParameters3;
            this.f6294a = eCKeyParameters3.a;
            this.f6297a = ((ECPublicKeyParameters) eCKeyParameters3).a;
        }
        this.a = (this.f6294a.a.k() + 7) / 8;
    }

    public final BigInteger[] b(byte[] bArr) {
        SM3Digest sM3Digest = new SM3Digest();
        sM3Digest.update(e(sM3Digest), 0, 32);
        sM3Digest.update(bArr, 0, bArr.length);
        byte[] bArr2 = new byte[32];
        sM3Digest.c(0, bArr2);
        BigInteger bigInteger = this.f6294a.g;
        BigInteger bigInteger2 = new BigInteger(1, bArr2);
        BigInteger bigInteger3 = ((ECPrivateKeyParameters) this.f6295a).a;
        FixedPointCombMultiplier fixedPointCombMultiplier = new FixedPointCombMultiplier();
        while (true) {
            BigInteger b = this.f6296a.b();
            ECPoint o = fixedPointCombMultiplier.a(this.f6294a.f6230a, b).o();
            o.b();
            BigInteger mod = bigInteger2.add(o.f6621a.t()).mod(bigInteger);
            BigInteger bigInteger4 = ECConstants.a;
            if (!mod.equals(bigInteger4) && !mod.add(b).equals(bigInteger)) {
                BigInteger mod2 = bigInteger3.add(ECConstants.b).modInverse(bigInteger).multiply(b.subtract(mod.multiply(bigInteger3)).mod(bigInteger)).mod(bigInteger);
                if (!mod2.equals(bigInteger4)) {
                    return new BigInteger[]{mod, mod2};
                }
            }
        }
    }

    public final boolean c(BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        BigInteger bigInteger3 = this.f6294a.g;
        BigInteger bigInteger4 = ECConstants.b;
        if (bigInteger.compareTo(bigInteger4) < 0 || bigInteger.compareTo(bigInteger3) >= 0 || bigInteger2.compareTo(bigInteger4) < 0 || bigInteger2.compareTo(bigInteger3) >= 0) {
            return false;
        }
        ECPoint eCPoint = ((ECPublicKeyParameters) this.f6295a).a;
        SM3Digest sM3Digest = new SM3Digest();
        sM3Digest.update(e(sM3Digest), 0, 32);
        sM3Digest.update(bArr, 0, bArr.length);
        byte[] bArr2 = new byte[32];
        sM3Digest.c(0, bArr2);
        BigInteger bigInteger5 = new BigInteger(1, bArr2);
        BigInteger mod = bigInteger.add(bigInteger2).mod(bigInteger3);
        if (mod.equals(ECConstants.a)) {
            return false;
        }
        ECPoint o = this.f6294a.f6230a.m(bigInteger2).a(eCPoint.m(mod)).o();
        o.b();
        return bigInteger.equals(bigInteger5.add(o.f6621a.t()).mod(bigInteger3));
    }

    public final void d(SM3Digest sM3Digest, ECFieldElement eCFieldElement) {
        byte[] a2 = BigIntegers.a(this.a, eCFieldElement.t());
        sM3Digest.update(a2, 0, a2.length);
    }

    public final byte[] e(SM3Digest sM3Digest) {
        byte[] bArr = this.f6298a;
        int length = bArr.length * 8;
        sM3Digest.d((byte) ((length >> 8) & Constants.MAX_HOST_LENGTH));
        sM3Digest.d((byte) (length & Constants.MAX_HOST_LENGTH));
        sM3Digest.update(bArr, 0, bArr.length);
        d(sM3Digest, this.f6294a.a.f6610a);
        d(sM3Digest, this.f6294a.a.f6614b);
        ECPoint eCPoint = this.f6294a.f6230a;
        eCPoint.b();
        d(sM3Digest, eCPoint.f6621a);
        d(sM3Digest, this.f6294a.f6230a.e());
        ECPoint eCPoint2 = this.f6297a;
        eCPoint2.b();
        d(sM3Digest, eCPoint2.f6621a);
        d(sM3Digest, this.f6297a.e());
        byte[] bArr2 = new byte[32];
        sM3Digest.c(0, bArr2);
        return bArr2;
    }
}
