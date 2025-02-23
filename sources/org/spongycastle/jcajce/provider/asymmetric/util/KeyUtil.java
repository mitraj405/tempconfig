package org.spongycastle.jcajce.provider.asymmetric.util;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;

public class KeyUtil {
    public static byte[] a(AlgorithmIdentifier algorithmIdentifier, ASN1Object aSN1Object) {
        try {
            return new PrivateKeyInfo(algorithmIdentifier, aSN1Object.b()).f("DER");
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] b(AlgorithmIdentifier algorithmIdentifier, ASN1Object aSN1Object) {
        try {
            return c(new SubjectPublicKeyInfo(algorithmIdentifier, aSN1Object));
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] c(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        try {
            return subjectPublicKeyInfo.f("DER");
        } catch (Exception unused) {
            return null;
        }
    }
}
