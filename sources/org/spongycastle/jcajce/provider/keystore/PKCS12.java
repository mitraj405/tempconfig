package org.spongycastle.jcajce.provider.keystore;

import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

public class PKCS12 {

    public static class Mappings extends AsymmetricAlgorithmProvider {
        public final void a(ConfigurableProvider configurableProvider) {
            configurableProvider.b("KeyStore.PKCS12", "org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$BCPKCS12KeyStore");
            configurableProvider.b("KeyStore.BCPKCS12", "org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$BCPKCS12KeyStore");
            configurableProvider.b("KeyStore.PKCS12-DEF", "org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$DefPKCS12KeyStore");
            configurableProvider.b("KeyStore.PKCS12-3DES-40RC2", "org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$BCPKCS12KeyStore");
            configurableProvider.b("KeyStore.PKCS12-3DES-3DES", "org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$BCPKCS12KeyStore3DES");
            configurableProvider.b("KeyStore.PKCS12-DEF-3DES-40RC2", "org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$DefPKCS12KeyStore");
            configurableProvider.b("KeyStore.PKCS12-DEF-3DES-3DES", "org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$DefPKCS12KeyStore3DES");
        }
    }
}
