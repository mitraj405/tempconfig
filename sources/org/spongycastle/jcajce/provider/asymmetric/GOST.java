package org.spongycastle.jcajce.provider.asymmetric;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.jcajce.provider.asymmetric.gost.KeyFactorySpi;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

public class GOST {

    public static class Mappings extends AsymmetricAlgorithmProvider {
        public final void a(ConfigurableProvider configurableProvider) {
            configurableProvider.b("KeyPairGenerator.GOST3410", "org.spongycastle.jcajce.provider.asymmetric.gost.KeyPairGeneratorSpi");
            configurableProvider.b("Alg.Alias.KeyPairGenerator.GOST-3410", "GOST3410");
            configurableProvider.b("Alg.Alias.KeyPairGenerator.GOST-3410-94", "GOST3410");
            configurableProvider.b("KeyFactory.GOST3410", "org.spongycastle.jcajce.provider.asymmetric.gost.KeyFactorySpi");
            configurableProvider.b("Alg.Alias.KeyFactory.GOST-3410", "GOST3410");
            configurableProvider.b("Alg.Alias.KeyFactory.GOST-3410-94", "GOST3410");
            configurableProvider.b("AlgorithmParameters.GOST3410", "org.spongycastle.jcajce.provider.asymmetric.gost.AlgorithmParametersSpi");
            configurableProvider.b("AlgorithmParameterGenerator.GOST3410", "org.spongycastle.jcajce.provider.asymmetric.gost.AlgorithmParameterGeneratorSpi");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = CryptoProObjectIdentifiers.k;
            AsymmetricAlgorithmProvider.c(configurableProvider, aSN1ObjectIdentifier, "GOST3410", new KeyFactorySpi());
            AsymmetricAlgorithmProvider.d("GOST3410", aSN1ObjectIdentifier, configurableProvider);
            configurableProvider.b("Signature.GOST3410", "org.spongycastle.jcajce.provider.asymmetric.gost.SignatureSpi");
            configurableProvider.b("Alg.Alias.Signature.GOST-3410", "GOST3410");
            configurableProvider.b("Alg.Alias.Signature.GOST-3410-94", "GOST3410");
            configurableProvider.b("Alg.Alias.Signature.GOST3411withGOST3410", "GOST3410");
            configurableProvider.b("Alg.Alias.Signature.GOST3411WITHGOST3410", "GOST3410");
            configurableProvider.b("Alg.Alias.Signature.GOST3411WithGOST3410", "GOST3410");
            C1058d.I(new StringBuilder("Alg.Alias.Signature."), CryptoProObjectIdentifiers.m, configurableProvider, "GOST3410");
            configurableProvider.b("Alg.Alias.AlgorithmParameterGenerator.GOST-3410", "GOST3410");
            configurableProvider.b("Alg.Alias.AlgorithmParameters.GOST-3410", "GOST3410");
        }
    }
}
