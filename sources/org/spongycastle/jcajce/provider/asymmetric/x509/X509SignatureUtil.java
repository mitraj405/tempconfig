package org.spongycastle.jcajce.provider.asymmetric.x509;

import java.security.Provider;
import java.security.Security;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.RSASSAPSSparams;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.jcajce.util.MessageDigestUtils;

class X509SignatureUtil {
    public static final DERNull a = DERNull.a;

    public static String a(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String a2 = MessageDigestUtils.a(aSN1ObjectIdentifier);
        int indexOf = a2.indexOf(45);
        if (indexOf <= 0 || a2.startsWith("SHA3")) {
            return MessageDigestUtils.a(aSN1ObjectIdentifier);
        }
        return a2.substring(0, indexOf) + a2.substring(indexOf + 1);
    }

    public static String b(AlgorithmIdentifier algorithmIdentifier) {
        ASN1Encodable aSN1Encodable = algorithmIdentifier.a;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = algorithmIdentifier.Z0;
        if (aSN1Encodable != null && !a.equals(aSN1Encodable)) {
            if (aSN1ObjectIdentifier.equals(PKCSObjectIdentifiers.i)) {
                return C0709Uj.j(new StringBuilder(), a(RSASSAPSSparams.g(aSN1Encodable).f5707a.Z0), "withRSAandMGF1");
            } else if (aSN1ObjectIdentifier.equals(X9ObjectIdentifiers.r0)) {
                return C0709Uj.j(new StringBuilder(), a((ASN1ObjectIdentifier) ASN1Sequence.q(aSN1Encodable).s(0)), "withECDSA");
            }
        }
        Provider provider = Security.getProvider("SC");
        if (provider != null) {
            String property = provider.getProperty("Alg.Alias.Signature." + aSN1ObjectIdentifier.c);
            if (property != null) {
                return property;
            }
        }
        Provider[] providers = Security.getProviders();
        for (int i = 0; i != providers.length; i++) {
            Provider provider2 = providers[i];
            String property2 = provider2.getProperty("Alg.Alias.Signature." + aSN1ObjectIdentifier.c);
            if (property2 != null) {
                return property2;
            }
        }
        return aSN1ObjectIdentifier.c;
    }
}
