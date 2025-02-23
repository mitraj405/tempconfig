package org.spongycastle.jcajce.provider.asymmetric;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.rosstandart.RosstandartObjectIdentifiers;
import org.spongycastle.jcajce.provider.asymmetric.ecgost.KeyFactorySpi;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

public class ECGOST {

    public static class Mappings extends AsymmetricAlgorithmProvider {
        public final void a(ConfigurableProvider configurableProvider) {
            configurableProvider.b("KeyFactory.ECGOST3410", "org.spongycastle.jcajce.provider.asymmetric.ecgost.KeyFactorySpi");
            configurableProvider.b("Alg.Alias.KeyFactory.GOST-3410-2001", "ECGOST3410");
            configurableProvider.b("Alg.Alias.KeyFactory.ECGOST-3410", "ECGOST3410");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = CryptoProObjectIdentifiers.l;
            AsymmetricAlgorithmProvider.c(configurableProvider, aSN1ObjectIdentifier, "ECGOST3410", new KeyFactorySpi());
            AsymmetricAlgorithmProvider.c(configurableProvider, CryptoProObjectIdentifiers.y, "ECGOST3410", new KeyFactorySpi());
            AsymmetricAlgorithmProvider.e("ECGOST3410", aSN1ObjectIdentifier, configurableProvider);
            configurableProvider.b("KeyPairGenerator.ECGOST3410", "org.spongycastle.jcajce.provider.asymmetric.ecgost.KeyPairGeneratorSpi");
            configurableProvider.b("Alg.Alias.KeyPairGenerator.ECGOST-3410", "ECGOST3410");
            configurableProvider.b("Alg.Alias.KeyPairGenerator.GOST-3410-2001", "ECGOST3410");
            configurableProvider.b("Signature.ECGOST3410", "org.spongycastle.jcajce.provider.asymmetric.ecgost.SignatureSpi");
            configurableProvider.b("Alg.Alias.Signature.ECGOST-3410", "ECGOST3410");
            configurableProvider.b("Alg.Alias.Signature.GOST-3410-2001", "ECGOST3410");
            configurableProvider.b("KeyAgreement.ECGOST3410", "org.spongycastle.jcajce.provider.asymmetric.ecgost.KeyAgreementSpi$ECVKO");
            configurableProvider.b("Alg.Alias.KeyAgreement." + aSN1ObjectIdentifier, "ECGOST3410");
            configurableProvider.b("Alg.Alias.KeyAgreement.GOST-3410-2001", "ECGOST3410");
            C1058d.I(new StringBuilder("Alg.Alias.KeyAgreement."), CryptoProObjectIdentifiers.x, configurableProvider, "ECGOST3410");
            configurableProvider.b("AlgorithmParameters.ECGOST3410", "org.spongycastle.jcajce.provider.asymmetric.ecgost.AlgorithmParametersSpi");
            configurableProvider.b("Alg.Alias.AlgorithmParameters.GOST-3410-2001", "ECGOST3410");
            AsymmetricAlgorithmProvider.b(configurableProvider, "GOST3411", "ECGOST3410", "org.spongycastle.jcajce.provider.asymmetric.ecgost.SignatureSpi", CryptoProObjectIdentifiers.n);
            configurableProvider.b("KeyFactory.ECGOST3410-2012", "org.spongycastle.jcajce.provider.asymmetric.ecgost12.KeyFactorySpi");
            configurableProvider.b("Alg.Alias.KeyFactory.GOST-3410-2012", "ECGOST3410-2012");
            configurableProvider.b("Alg.Alias.KeyFactory.ECGOST-3410-2012", "ECGOST3410-2012");
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = RosstandartObjectIdentifiers.e;
            AsymmetricAlgorithmProvider.c(configurableProvider, aSN1ObjectIdentifier2, "ECGOST3410-2012", new org.spongycastle.jcajce.provider.asymmetric.ecgost12.KeyFactorySpi());
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = RosstandartObjectIdentifiers.i;
            AsymmetricAlgorithmProvider.c(configurableProvider, aSN1ObjectIdentifier3, "ECGOST3410-2012", new org.spongycastle.jcajce.provider.asymmetric.ecgost12.KeyFactorySpi());
            AsymmetricAlgorithmProvider.e("ECGOST3410-2012", aSN1ObjectIdentifier2, configurableProvider);
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = RosstandartObjectIdentifiers.f;
            AsymmetricAlgorithmProvider.c(configurableProvider, aSN1ObjectIdentifier4, "ECGOST3410-2012", new org.spongycastle.jcajce.provider.asymmetric.ecgost12.KeyFactorySpi());
            ASN1ObjectIdentifier aSN1ObjectIdentifier5 = RosstandartObjectIdentifiers.j;
            AsymmetricAlgorithmProvider.c(configurableProvider, aSN1ObjectIdentifier5, "ECGOST3410-2012", new org.spongycastle.jcajce.provider.asymmetric.ecgost12.KeyFactorySpi());
            AsymmetricAlgorithmProvider.e("ECGOST3410-2012", aSN1ObjectIdentifier4, configurableProvider);
            configurableProvider.b("KeyPairGenerator.ECGOST3410-2012", "org.spongycastle.jcajce.provider.asymmetric.ecgost12.KeyPairGeneratorSpi");
            configurableProvider.b("Alg.Alias.KeyPairGenerator.ECGOST3410-2012", "ECGOST3410-2012");
            configurableProvider.b("Alg.Alias.KeyPairGenerator.GOST-3410-2012", "ECGOST3410-2012");
            configurableProvider.b("Signature.ECGOST3410-2012-256", "org.spongycastle.jcajce.provider.asymmetric.ecgost12.ECGOST2012SignatureSpi256");
            configurableProvider.b("Alg.Alias.Signature.ECGOST3410-2012-256", "ECGOST3410-2012-256");
            configurableProvider.b("Alg.Alias.Signature.GOST-3410-2012-256", "ECGOST3410-2012-256");
            AsymmetricAlgorithmProvider.b(configurableProvider, "GOST3411-2012-256", "ECGOST3410-2012-256", "org.spongycastle.jcajce.provider.asymmetric.ecgost12.ECGOST2012SignatureSpi256", RosstandartObjectIdentifiers.g);
            configurableProvider.b("Signature.ECGOST3410-2012-512", "org.spongycastle.jcajce.provider.asymmetric.ecgost12.ECGOST2012SignatureSpi512");
            configurableProvider.b("Alg.Alias.Signature.ECGOST3410-2012-512", "ECGOST3410-2012-512");
            configurableProvider.b("Alg.Alias.Signature.GOST-3410-2012-512", "ECGOST3410-2012-512");
            AsymmetricAlgorithmProvider.b(configurableProvider, "GOST3411-2012-512", "ECGOST3410-2012-512", "org.spongycastle.jcajce.provider.asymmetric.ecgost12.ECGOST2012SignatureSpi512", RosstandartObjectIdentifiers.h);
            configurableProvider.b("KeyAgreement.ECGOST3410-2012-256", "org.spongycastle.jcajce.provider.asymmetric.ecgost12.KeyAgreementSpi$ECVKO256");
            configurableProvider.b("KeyAgreement.ECGOST3410-2012-512", "org.spongycastle.jcajce.provider.asymmetric.ecgost12.KeyAgreementSpi$ECVKO512");
            C1058d.I(C1058d.D(C1058d.D(C1058d.D(new StringBuilder("Alg.Alias.KeyAgreement."), aSN1ObjectIdentifier3, configurableProvider, "ECGOST3410-2012-256", "Alg.Alias.KeyAgreement."), aSN1ObjectIdentifier5, configurableProvider, "ECGOST3410-2012-512", "Alg.Alias.KeyAgreement."), aSN1ObjectIdentifier2, configurableProvider, "ECGOST3410-2012-256", "Alg.Alias.KeyAgreement."), aSN1ObjectIdentifier4, configurableProvider, "ECGOST3410-2012-512");
        }
    }
}
