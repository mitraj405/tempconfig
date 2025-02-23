package org.spongycastle.pqc.jcajce.provider.xmss;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.pqc.crypto.xmss.XMSSMTKeyPairGenerator;
import org.spongycastle.pqc.crypto.xmss.XMSSMTParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSMTPrivateKeyParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSMTPublicKeyParameters;
import org.spongycastle.pqc.jcajce.spec.XMSSMTParameterSpec;

public class XMSSMTKeyPairGeneratorSpi extends KeyPairGenerator {
    public final SecureRandom a = new SecureRandom();

    /* renamed from: a  reason: collision with other field name */
    public final XMSSMTKeyPairGenerator f6833a = new XMSSMTKeyPairGenerator();

    /* renamed from: a  reason: collision with other field name */
    public boolean f6834a = false;

    public XMSSMTKeyPairGeneratorSpi() {
        super("XMSSMT");
    }

    public final KeyPair generateKeyPair() {
        boolean z = this.f6834a;
        XMSSMTKeyPairGenerator xMSSMTKeyPairGenerator = this.f6833a;
        if (!z) {
            XMSSMTParameters xMSSMTParameters = new XMSSMTParameters(10, 20, new SHA512Digest());
            SecureRandom secureRandom = this.a;
            xMSSMTKeyPairGenerator.getClass();
            xMSSMTKeyPairGenerator.a = secureRandom;
            xMSSMTKeyPairGenerator.f6768a = xMSSMTParameters;
            xMSSMTKeyPairGenerator.f6769a = xMSSMTParameters.f6770a;
            this.f6834a = true;
        }
        AsymmetricCipherKeyPair a2 = xMSSMTKeyPairGenerator.a();
        return new KeyPair(new BCXMSSMTPublicKey((XMSSMTPublicKeyParameters) a2.a), new BCXMSSMTPrivateKey((XMSSMTPrivateKeyParameters) a2.b));
    }

    public final void initialize(int i, SecureRandom secureRandom) {
        throw new IllegalArgumentException("use AlgorithmParameterSpec");
    }

    public final void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (!(algorithmParameterSpec instanceof XMSSMTParameterSpec)) {
            throw new InvalidAlgorithmParameterException("parameter object not a XMSSMTParameterSpec");
        }
        ((XMSSMTParameterSpec) algorithmParameterSpec).getClass();
        throw null;
    }
}
