package org.spongycastle.pqc.jcajce.provider.xmss;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.pqc.crypto.xmss.XMSSKeyPairGenerator;
import org.spongycastle.pqc.crypto.xmss.XMSSParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSPrivateKeyParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSPublicKeyParameters;
import org.spongycastle.pqc.jcajce.spec.XMSSParameterSpec;

public class XMSSKeyPairGeneratorSpi extends KeyPairGenerator {
    public final SecureRandom a = new SecureRandom();

    /* renamed from: a  reason: collision with other field name */
    public final XMSSKeyPairGenerator f6831a = new XMSSKeyPairGenerator();

    /* renamed from: a  reason: collision with other field name */
    public boolean f6832a = false;

    public XMSSKeyPairGeneratorSpi() {
        super("XMSS");
    }

    public final KeyPair generateKeyPair() {
        boolean z = this.f6832a;
        XMSSKeyPairGenerator xMSSKeyPairGenerator = this.f6831a;
        if (!z) {
            XMSSParameters xMSSParameters = new XMSSParameters(10, new SHA512Digest());
            SecureRandom secureRandom = this.a;
            xMSSKeyPairGenerator.getClass();
            xMSSKeyPairGenerator.a = secureRandom;
            xMSSKeyPairGenerator.f6767a = xMSSParameters;
            this.f6832a = true;
        }
        AsymmetricCipherKeyPair a2 = xMSSKeyPairGenerator.a();
        return new KeyPair(new BCXMSSPublicKey((XMSSPublicKeyParameters) a2.a), new BCXMSSPrivateKey((XMSSPrivateKeyParameters) a2.b));
    }

    public final void initialize(int i, SecureRandom secureRandom) {
        throw new IllegalArgumentException("use AlgorithmParameterSpec");
    }

    public final void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (!(algorithmParameterSpec instanceof XMSSParameterSpec)) {
            throw new InvalidAlgorithmParameterException("parameter object not a XMSSParameterSpec");
        }
        ((XMSSParameterSpec) algorithmParameterSpec).getClass();
        throw null;
    }
}
