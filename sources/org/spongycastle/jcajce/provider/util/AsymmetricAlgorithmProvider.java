package org.spongycastle.jcajce.provider.util;

import com.google.firebase.sessions.settings.RemoteSettings;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;

public abstract class AsymmetricAlgorithmProvider extends AlgorithmProvider {
    public static void b(ConfigurableProvider configurableProvider, String str, String str2, String str3, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String D = xx.D(str, "WITH", str2);
        String D2 = xx.D(str, "with", str2);
        String D3 = xx.D(str, "With", str2);
        String D4 = xx.D(str, RemoteSettings.FORWARD_SLASH_STRING, str2);
        configurableProvider.b("Signature." + D, str3);
        configurableProvider.b("Alg.Alias.Signature." + D2, D);
        configurableProvider.b("Alg.Alias.Signature." + D3, D);
        configurableProvider.b("Alg.Alias.Signature." + D4, D);
        C1058d.I(C1058d.D(new StringBuilder("Alg.Alias.Signature."), aSN1ObjectIdentifier, configurableProvider, D, "Alg.Alias.Signature.OID."), aSN1ObjectIdentifier, configurableProvider, D);
    }

    public static void c(ConfigurableProvider configurableProvider, ASN1ObjectIdentifier aSN1ObjectIdentifier, String str, AsymmetricKeyInfoConverter asymmetricKeyInfoConverter) {
        configurableProvider.b("Alg.Alias.KeyFactory." + aSN1ObjectIdentifier, str);
        C1058d.I(new StringBuilder("Alg.Alias.KeyPairGenerator."), aSN1ObjectIdentifier, configurableProvider, str);
        configurableProvider.a(aSN1ObjectIdentifier, asymmetricKeyInfoConverter);
    }

    public static void d(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier, ConfigurableProvider configurableProvider) {
        configurableProvider.b("Alg.Alias.AlgorithmParameterGenerator." + aSN1ObjectIdentifier, str);
        C1058d.I(new StringBuilder("Alg.Alias.AlgorithmParameters."), aSN1ObjectIdentifier, configurableProvider, str);
    }

    public static void e(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier, ConfigurableProvider configurableProvider) {
        configurableProvider.b("Alg.Alias.AlgorithmParameters." + aSN1ObjectIdentifier, str);
    }
}
