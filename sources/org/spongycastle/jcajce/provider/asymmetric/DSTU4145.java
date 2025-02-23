package org.spongycastle.jcajce.provider.asymmetric;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ua.UAObjectIdentifiers;
import org.spongycastle.jcajce.provider.asymmetric.dstu.KeyFactorySpi;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

public class DSTU4145 {

    public static class Mappings extends AsymmetricAlgorithmProvider {
        public final void a(ConfigurableProvider configurableProvider) {
            configurableProvider.b("KeyFactory.DSTU4145", "org.spongycastle.jcajce.provider.asymmetric.dstu.KeyFactorySpi");
            configurableProvider.b("Alg.Alias.KeyFactory.DSTU-4145-2002", "DSTU4145");
            configurableProvider.b("Alg.Alias.KeyFactory.DSTU4145-3410", "DSTU4145");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = UAObjectIdentifiers.a;
            AsymmetricAlgorithmProvider.c(configurableProvider, aSN1ObjectIdentifier, "DSTU4145", new KeyFactorySpi());
            AsymmetricAlgorithmProvider.e("DSTU4145", aSN1ObjectIdentifier, configurableProvider);
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = UAObjectIdentifiers.b;
            AsymmetricAlgorithmProvider.c(configurableProvider, aSN1ObjectIdentifier2, "DSTU4145", new KeyFactorySpi());
            AsymmetricAlgorithmProvider.e("DSTU4145", aSN1ObjectIdentifier2, configurableProvider);
            configurableProvider.b("KeyPairGenerator.DSTU4145", "org.spongycastle.jcajce.provider.asymmetric.dstu.KeyPairGeneratorSpi");
            configurableProvider.b("Alg.Alias.KeyPairGenerator.DSTU-4145", "DSTU4145");
            configurableProvider.b("Alg.Alias.KeyPairGenerator.DSTU-4145-2002", "DSTU4145");
            configurableProvider.b("Signature.DSTU4145", "org.spongycastle.jcajce.provider.asymmetric.dstu.SignatureSpi");
            configurableProvider.b("Alg.Alias.Signature.DSTU-4145", "DSTU4145");
            configurableProvider.b("Alg.Alias.Signature.DSTU-4145-2002", "DSTU4145");
            AsymmetricAlgorithmProvider.b(configurableProvider, "GOST3411", "DSTU4145LE", "org.spongycastle.jcajce.provider.asymmetric.dstu.SignatureSpiLe", aSN1ObjectIdentifier);
            AsymmetricAlgorithmProvider.b(configurableProvider, "GOST3411", "DSTU4145", "org.spongycastle.jcajce.provider.asymmetric.dstu.SignatureSpi", aSN1ObjectIdentifier2);
        }
    }
}
