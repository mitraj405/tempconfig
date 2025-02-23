package org.spongycastle.jcajce.provider.config;

import java.util.HashMap;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;

public interface ConfigurableProvider {
    void a(ASN1ObjectIdentifier aSN1ObjectIdentifier, AsymmetricKeyInfoConverter asymmetricKeyInfoConverter);

    void b(String str, String str2);

    void c(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier, String str2);

    boolean d(String str);

    void e(String str, HashMap hashMap);
}
