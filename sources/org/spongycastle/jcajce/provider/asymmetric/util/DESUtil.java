package org.spongycastle.jcajce.provider.asymmetric.util;

import java.util.HashSet;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;

public class DESUtil {
    static {
        HashSet hashSet = new HashSet();
        hashSet.add("DES");
        hashSet.add("DESEDE");
        hashSet.add(OIWObjectIdentifiers.b.c);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.y;
        hashSet.add(aSN1ObjectIdentifier.c);
        hashSet.add(aSN1ObjectIdentifier.c);
        hashSet.add(PKCSObjectIdentifiers.c0.c);
    }
}
