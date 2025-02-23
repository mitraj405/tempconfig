package org.spongycastle.pqc.jcajce.provider;

import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.jcajce.provider.newhope.NHKeyFactorySpi;

public class NH {

    public static class Mappings extends AsymmetricAlgorithmProvider {
        public final void a(ConfigurableProvider configurableProvider) {
            configurableProvider.b("KeyFactory.NH", "org.spongycastle.pqc.jcajce.provider.newhope.NHKeyFactorySpi");
            configurableProvider.b("KeyPairGenerator.NH", "org.spongycastle.pqc.jcajce.provider.newhope.NHKeyPairGeneratorSpi");
            configurableProvider.b("KeyAgreement.NH", "org.spongycastle.pqc.jcajce.provider.newhope.KeyAgreementSpi");
            AsymmetricAlgorithmProvider.c(configurableProvider, PQCObjectIdentifiers.k, "NH", new NHKeyFactorySpi());
        }
    }
}
