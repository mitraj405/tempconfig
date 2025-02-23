package org.spongycastle.pqc.jcajce.provider;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.jcajce.provider.sphincs.Sphincs256KeyFactorySpi;

public class SPHINCS {

    public static class Mappings extends AsymmetricAlgorithmProvider {
        public final void a(ConfigurableProvider configurableProvider) {
            configurableProvider.b("KeyFactory.SPHINCS256", "org.spongycastle.pqc.jcajce.provider.sphincs.Sphincs256KeyFactorySpi");
            configurableProvider.b("KeyPairGenerator.SPHINCS256", "org.spongycastle.pqc.jcajce.provider.sphincs.Sphincs256KeyPairGeneratorSpi");
            AsymmetricAlgorithmProvider.b(configurableProvider, "SHA512", "SPHINCS256", "org.spongycastle.pqc.jcajce.provider.sphincs.SignatureSpi$withSha512", PQCObjectIdentifiers.i);
            AsymmetricAlgorithmProvider.b(configurableProvider, "SHA3-512", "SPHINCS256", "org.spongycastle.pqc.jcajce.provider.sphincs.SignatureSpi$withSha3_512", PQCObjectIdentifiers.j);
            Sphincs256KeyFactorySpi sphincs256KeyFactorySpi = new Sphincs256KeyFactorySpi();
            ASN1ObjectIdentifier aSN1ObjectIdentifier = PQCObjectIdentifiers.h;
            AsymmetricAlgorithmProvider.c(configurableProvider, aSN1ObjectIdentifier, "SPHINCS256", sphincs256KeyFactorySpi);
            AsymmetricAlgorithmProvider.e("SPHINCS256", aSN1ObjectIdentifier, configurableProvider);
        }
    }
}
