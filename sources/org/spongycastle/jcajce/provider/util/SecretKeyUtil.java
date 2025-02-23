package org.spongycastle.jcajce.provider.util;

import java.util.HashMap;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.ntt.NTTObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;

public class SecretKeyUtil {
    static {
        HashMap hashMap = new HashMap();
        hashMap.put(PKCSObjectIdentifiers.y.c, 192);
        hashMap.put(NISTObjectIdentifiers.s, 128);
        hashMap.put(NISTObjectIdentifiers.A, 192);
        hashMap.put(NISTObjectIdentifiers.I, 256);
        hashMap.put(NTTObjectIdentifiers.a, 128);
        hashMap.put(NTTObjectIdentifiers.b, 192);
        hashMap.put(NTTObjectIdentifiers.c, 256);
    }
}
