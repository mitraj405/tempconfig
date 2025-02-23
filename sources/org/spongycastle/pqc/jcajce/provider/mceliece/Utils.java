package org.spongycastle.pqc.jcajce.provider.mceliece;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA224Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.digests.SHA512Digest;

class Utils {
    public static AlgorithmIdentifier a(String str) {
        if (str.equals("SHA-1")) {
            return new AlgorithmIdentifier(OIWObjectIdentifiers.f, DERNull.a);
        }
        if (str.equals("SHA-224")) {
            return new AlgorithmIdentifier(NISTObjectIdentifiers.d, DERNull.a);
        }
        if (str.equals("SHA-256")) {
            return new AlgorithmIdentifier(NISTObjectIdentifiers.a, DERNull.a);
        }
        if (str.equals("SHA-384")) {
            return new AlgorithmIdentifier(NISTObjectIdentifiers.b, DERNull.a);
        }
        if (str.equals("SHA-512")) {
            return new AlgorithmIdentifier(NISTObjectIdentifiers.c, DERNull.a);
        }
        throw new IllegalArgumentException("unrecognised digest algorithm: ".concat(str));
    }

    public static Digest b(AlgorithmIdentifier algorithmIdentifier) {
        if (algorithmIdentifier.Z0.equals(OIWObjectIdentifiers.f)) {
            return new SHA1Digest();
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier = NISTObjectIdentifiers.d;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = algorithmIdentifier.Z0;
        if (aSN1ObjectIdentifier2.equals(aSN1ObjectIdentifier)) {
            return new SHA224Digest();
        }
        if (aSN1ObjectIdentifier2.equals(NISTObjectIdentifiers.a)) {
            return new SHA256Digest();
        }
        if (aSN1ObjectIdentifier2.equals(NISTObjectIdentifiers.b)) {
            return new SHA384Digest();
        }
        if (aSN1ObjectIdentifier2.equals(NISTObjectIdentifiers.c)) {
            return new SHA512Digest();
        }
        throw new IllegalArgumentException("unrecognised OID in digest algorithm identifier: " + aSN1ObjectIdentifier2);
    }
}
