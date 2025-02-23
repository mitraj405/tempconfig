package org.spongycastle.jcajce.provider.keystore;

import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

public class BCFKS {

    public static class Mappings extends AsymmetricAlgorithmProvider {
        public final void a(ConfigurableProvider configurableProvider) {
            configurableProvider.b("KeyStore.BCFKS", "org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi$Std");
            configurableProvider.b("KeyStore.BCFKS-DEF", "org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi$Def");
        }
    }
}
