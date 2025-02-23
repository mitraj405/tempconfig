package org.spongycastle.crypto.agreement;

import java.math.BigInteger;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.ParametersWithUKM;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.BigIntegers;

public class ECVKOAgreement {
    public BigInteger a;

    /* renamed from: a  reason: collision with other field name */
    public final Digest f5802a;

    /* renamed from: a  reason: collision with other field name */
    public ECPrivateKeyParameters f5803a;

    public ECVKOAgreement(Digest digest) {
        this.f5802a = digest;
    }

    public final byte[] a(AsymmetricKeyParameter asymmetricKeyParameter) {
        int i;
        ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) asymmetricKeyParameter;
        ECDomainParameters eCDomainParameters = eCPublicKeyParameters.a;
        if (eCDomainParameters.equals(this.f5803a.a)) {
            ECPoint o = eCPublicKeyParameters.a.m(eCDomainParameters.h.multiply(this.a).multiply(this.f5803a.a).mod(eCDomainParameters.g)).o();
            if (!o.k()) {
                ECPoint o2 = o.o();
                o2.b();
                BigInteger t = o2.f6621a.t();
                BigInteger t2 = o2.e().t();
                if (t.toByteArray().length > 33) {
                    i = 64;
                } else {
                    i = 32;
                }
                int i2 = i * 2;
                byte[] bArr = new byte[i2];
                byte[] a2 = BigIntegers.a(i, t);
                byte[] a3 = BigIntegers.a(i, t2);
                for (int i3 = 0; i3 != i; i3++) {
                    bArr[i3] = a2[(i - i3) - 1];
                }
                for (int i4 = 0; i4 != i; i4++) {
                    bArr[i + i4] = a3[(i - i4) - 1];
                }
                Digest digest = this.f5802a;
                digest.update(bArr, 0, i2);
                byte[] bArr2 = new byte[digest.f()];
                digest.c(0, bArr2);
                return bArr2;
            }
            throw new IllegalStateException("Infinity is not a valid agreement value for ECVKO");
        }
        throw new IllegalStateException("ECVKO public key has wrong domain parameters");
    }

    public final void b(ParametersWithUKM parametersWithUKM) {
        this.f5803a = (ECPrivateKeyParameters) parametersWithUKM.a;
        byte[] bArr = parametersWithUKM.f6236a;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        for (int i = 0; i != length; i++) {
            bArr2[i] = bArr[(bArr.length - i) - 1];
        }
        this.a = new BigInteger(1, bArr2);
    }
}
