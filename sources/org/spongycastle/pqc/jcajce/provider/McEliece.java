package org.spongycastle.pqc.jcajce.provider;

import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;

public class McEliece {

    public static class Mappings extends AsymmetricAlgorithmProvider {
        public final void a(ConfigurableProvider configurableProvider) {
            configurableProvider.b("KeyPairGenerator.McElieceKobaraImai", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceCCA2KeyPairGeneratorSpi");
            configurableProvider.b("KeyPairGenerator.McEliecePointcheval", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceCCA2KeyPairGeneratorSpi");
            configurableProvider.b("KeyPairGenerator.McElieceFujisaki", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceCCA2KeyPairGeneratorSpi");
            configurableProvider.b("KeyPairGenerator.McEliece", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceKeyPairGeneratorSpi");
            configurableProvider.b("KeyPairGenerator.McEliece-CCA2", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceCCA2KeyPairGeneratorSpi");
            configurableProvider.b("KeyFactory.McElieceKobaraImai", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceCCA2KeyFactorySpi");
            configurableProvider.b("KeyFactory.McEliecePointcheval", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceCCA2KeyFactorySpi");
            configurableProvider.b("KeyFactory.McElieceFujisaki", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceCCA2KeyFactorySpi");
            configurableProvider.b("KeyFactory.McEliece", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceKeyFactorySpi");
            configurableProvider.b("KeyFactory.McEliece-CCA2", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceCCA2KeyFactorySpi");
            C1058d.I(C1058d.D(new StringBuilder("KeyFactory."), PQCObjectIdentifiers.g, configurableProvider, "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceCCA2KeyFactorySpi", "KeyFactory."), PQCObjectIdentifiers.f, configurableProvider, "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceKeyFactorySpi");
            configurableProvider.b("Cipher.McEliece", "org.spongycastle.pqc.jcajce.provider.mceliece.McEliecePKCSCipherSpi$McEliecePKCS");
            configurableProvider.b("Cipher.McEliecePointcheval", "org.spongycastle.pqc.jcajce.provider.mceliece.McEliecePointchevalCipherSpi$McEliecePointcheval");
            configurableProvider.b("Cipher.McElieceKobaraImai", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceKobaraImaiCipherSpi$McElieceKobaraImai");
            configurableProvider.b("Cipher.McElieceFujisaki", "org.spongycastle.pqc.jcajce.provider.mceliece.McElieceFujisakiCipherSpi$McElieceFujisaki");
        }
    }
}
