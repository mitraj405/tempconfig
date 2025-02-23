package org.spongycastle.jcajce.provider.asymmetric.ecgost12;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.asn1.x9.X9IntegerConverter;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.agreement.ECVKOAgreement;
import org.spongycastle.crypto.digests.GOST3411_2012_256Digest;
import org.spongycastle.crypto.digests.GOST3411_2012_512Digest;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ParametersWithUKM;
import org.spongycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jcajce.spec.UserKeyingMaterialSpec;
import org.spongycastle.jce.interfaces.ECPrivateKey;
import org.spongycastle.jce.interfaces.ECPublicKey;
import org.spongycastle.util.Arrays;

public class KeyAgreementSpi extends BaseAgreementSpi {
    public final ECVKOAgreement a;

    /* renamed from: a  reason: collision with other field name */
    public ECDomainParameters f6430a;
    public final String b;

    /* renamed from: b  reason: collision with other field name */
    public byte[] f6431b;

    public static class ECVKO256 extends KeyAgreementSpi {
        public ECVKO256() {
            super("ECGOST3410-2012-256", new ECVKOAgreement(new GOST3411_2012_256Digest()));
        }
    }

    public static class ECVKO512 extends KeyAgreementSpi {
        public ECVKO512() {
            super("ECGOST3410-2012-512", new ECVKOAgreement(new GOST3411_2012_512Digest()));
        }
    }

    static {
        new X9IntegerConverter();
    }

    public KeyAgreementSpi(String str, ECVKOAgreement eCVKOAgreement) {
        super(str, (DerivationFunction) null);
        this.b = str;
        this.a = eCVKOAgreement;
    }

    public final byte[] a() {
        return this.f6431b;
    }

    public final void b(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException {
        if (key instanceof PrivateKey) {
            ECPrivateKeyParameters eCPrivateKeyParameters = (ECPrivateKeyParameters) ECUtil.b((PrivateKey) key);
            this.f6430a = eCPrivateKeyParameters.a;
            byte[] bArr = null;
            if (algorithmParameterSpec instanceof UserKeyingMaterialSpec) {
                ((UserKeyingMaterialSpec) algorithmParameterSpec).getClass();
                bArr = Arrays.c((byte[]) null);
            }
            this.f6479a = bArr;
            this.a.b(new ParametersWithUKM(eCPrivateKeyParameters, bArr));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.b);
        sb.append(" key agreement requires ");
        String name = ECPrivateKey.class.getName();
        sb.append(name.substring(name.lastIndexOf(46) + 1));
        sb.append(" for initialisation");
        throw new InvalidKeyException(sb.toString());
    }

    public final Key engineDoPhase(Key key, boolean z) throws InvalidKeyException, IllegalStateException {
        AsymmetricKeyParameter asymmetricKeyParameter;
        ECDomainParameters eCDomainParameters = this.f6430a;
        String str = this.b;
        if (eCDomainParameters == null) {
            throw new IllegalStateException(C1058d.z(str, " not initialised."));
        } else if (!z) {
            throw new IllegalStateException(C1058d.z(str, " can only be between two parties."));
        } else if (key instanceof PublicKey) {
            PublicKey publicKey = (PublicKey) key;
            if (publicKey instanceof BCECGOST3410_2012PublicKey) {
                asymmetricKeyParameter = ((BCECGOST3410_2012PublicKey) publicKey).f6427a;
            } else {
                asymmetricKeyParameter = ECUtil.c(publicKey);
            }
            try {
                this.f6431b = this.a.a(asymmetricKeyParameter);
                return null;
            } catch (Exception e) {
                throw new InvalidKeyException(C1058d.M(e, new StringBuilder("calculation failed: "))) {
                    public final Throwable getCause() {
                        return e;
                    }
                };
            }
        } else {
            StringBuilder n = lf.n(str, " key agreement requires ");
            String name = ECPublicKey.class.getName();
            n.append(name.substring(name.lastIndexOf(46) + 1));
            n.append(" for doPhase");
            throw new InvalidKeyException(n.toString());
        }
    }

    public final void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (algorithmParameterSpec == null || (algorithmParameterSpec instanceof UserKeyingMaterialSpec)) {
            b(key, algorithmParameterSpec);
            return;
        }
        throw new InvalidAlgorithmParameterException("No algorithm parameters supported");
    }

    public final void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        b(key, (AlgorithmParameterSpec) null);
    }
}
