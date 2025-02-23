package org.spongycastle.pqc.jcajce.provider;

import org.spongycastle.asn1.bc.BCObjectIdentifiers;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.jcajce.provider.xmss.XMSSKeyFactorySpi;
import org.spongycastle.pqc.jcajce.provider.xmss.XMSSMTKeyFactorySpi;

public class XMSS {

    public static class Mappings extends AsymmetricAlgorithmProvider {
        public final void a(ConfigurableProvider configurableProvider) {
            configurableProvider.b("KeyFactory.XMSS", "org.spongycastle.pqc.jcajce.provider.xmss.XMSSKeyFactorySpi");
            configurableProvider.b("KeyPairGenerator.XMSS", "org.spongycastle.pqc.jcajce.provider.xmss.XMSSKeyPairGeneratorSpi");
            AsymmetricAlgorithmProvider.b(configurableProvider, "SHA256", "XMSS", "org.spongycastle.pqc.jcajce.provider.xmss.XMSSSignatureSpi$withSha256", BCObjectIdentifiers.k);
            AsymmetricAlgorithmProvider.b(configurableProvider, "SHAKE128", "XMSS", "org.spongycastle.pqc.jcajce.provider.xmss.XMSSSignatureSpi$withShake128", BCObjectIdentifiers.m);
            AsymmetricAlgorithmProvider.b(configurableProvider, "SHA512", "XMSS", "org.spongycastle.pqc.jcajce.provider.xmss.XMSSSignatureSpi$withSha512", BCObjectIdentifiers.l);
            AsymmetricAlgorithmProvider.b(configurableProvider, "SHAKE256", "XMSS", "org.spongycastle.pqc.jcajce.provider.xmss.XMSSSignatureSpi$withShake256", BCObjectIdentifiers.n);
            configurableProvider.b("KeyFactory.XMSSMT", "org.spongycastle.pqc.jcajce.provider.xmss.XMSSMTKeyFactorySpi");
            configurableProvider.b("KeyPairGenerator.XMSSMT", "org.spongycastle.pqc.jcajce.provider.xmss.XMSSMTKeyPairGeneratorSpi");
            AsymmetricAlgorithmProvider.b(configurableProvider, "SHA256", "XMSSMT", "org.spongycastle.pqc.jcajce.provider.xmss.XMSSMTSignatureSpi$withSha256", BCObjectIdentifiers.p);
            AsymmetricAlgorithmProvider.b(configurableProvider, "SHAKE128", "XMSSMT", "org.spongycastle.pqc.jcajce.provider.xmss.XMSSMTSignatureSpi$withShake128", BCObjectIdentifiers.r);
            AsymmetricAlgorithmProvider.b(configurableProvider, "SHA512", "XMSSMT", "org.spongycastle.pqc.jcajce.provider.xmss.XMSSMTSignatureSpi$withSha512", BCObjectIdentifiers.q);
            AsymmetricAlgorithmProvider.b(configurableProvider, "SHAKE256", "XMSSMT", "org.spongycastle.pqc.jcajce.provider.xmss.XMSSMTSignatureSpi$withShake256", BCObjectIdentifiers.s);
            AsymmetricAlgorithmProvider.c(configurableProvider, PQCObjectIdentifiers.l, "XMSS", new XMSSKeyFactorySpi());
            AsymmetricAlgorithmProvider.c(configurableProvider, PQCObjectIdentifiers.m, "XMSSMT", new XMSSMTKeyFactorySpi());
        }
    }
}
