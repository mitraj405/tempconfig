package org.spongycastle.jcajce.provider.digest;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;

abstract class DigestAlgorithmProvider extends AlgorithmProvider {
    public static void b(ConfigurableProvider configurableProvider, String str, String str2, String str3) {
        String concat = "HMAC".concat(str);
        configurableProvider.b("Mac." + concat, str2);
        configurableProvider.b("Alg.Alias.Mac.HMAC-".concat(str), concat);
        configurableProvider.b("Alg.Alias.Mac.HMAC/".concat(str), concat);
        configurableProvider.b("KeyGenerator." + concat, str3);
        configurableProvider.b("Alg.Alias.KeyGenerator.HMAC-".concat(str), concat);
        configurableProvider.b("Alg.Alias.KeyGenerator.HMAC/".concat(str), concat);
    }

    public static void c(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier, ConfigurableProvider configurableProvider) {
        String concat = "HMAC".concat(str);
        configurableProvider.b("Alg.Alias.Mac." + aSN1ObjectIdentifier, concat);
        C1058d.I(new StringBuilder("Alg.Alias.KeyGenerator."), aSN1ObjectIdentifier, configurableProvider, concat);
    }
}
