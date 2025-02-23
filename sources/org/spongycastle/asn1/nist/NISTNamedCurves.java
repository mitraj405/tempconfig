package org.spongycastle.asn1.nist;

import java.util.Hashtable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.sec.SECNamedCurves;
import org.spongycastle.asn1.sec.SECObjectIdentifiers;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.util.Strings;

public class NISTNamedCurves {
    public static final Hashtable a = new Hashtable();
    public static final Hashtable b = new Hashtable();

    static {
        a("B-571", SECObjectIdentifiers.E);
        a("B-409", SECObjectIdentifiers.C);
        a("B-283", SECObjectIdentifiers.m);
        a("B-233", SECObjectIdentifiers.s);
        a("B-163", SECObjectIdentifiers.k);
        a("K-571", SECObjectIdentifiers.D);
        a("K-409", SECObjectIdentifiers.B);
        a("K-283", SECObjectIdentifiers.l);
        a("K-233", SECObjectIdentifiers.r);
        a("K-163", SECObjectIdentifiers.a);
        a("P-521", SECObjectIdentifiers.A);
        a("P-384", SECObjectIdentifiers.z);
        a("P-256", SECObjectIdentifiers.G);
        a("P-224", SECObjectIdentifiers.y);
        a("P-192", SECObjectIdentifiers.F);
    }

    public static void a(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        a.put(str, aSN1ObjectIdentifier);
        b.put(aSN1ObjectIdentifier, str);
    }

    public static X9ECParameters b(String str) {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) a.get(Strings.g(str));
        if (aSN1ObjectIdentifier != null) {
            return SECNamedCurves.d(aSN1ObjectIdentifier);
        }
        return null;
    }
}
