package org.spongycastle.jcajce.util;

import java.util.HashMap;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.gm.GMObjectIdentifiers;
import org.spongycastle.asn1.gnu.GNUObjectIdentifiers;
import org.spongycastle.asn1.iso.ISOIECObjectIdentifiers;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;

public class MessageDigestUtils {
    public static final HashMap a;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put(PKCSObjectIdentifiers.B, "MD2");
        hashMap.put(PKCSObjectIdentifiers.C, "MD4");
        hashMap.put(PKCSObjectIdentifiers.D, "MD5");
        hashMap.put(OIWObjectIdentifiers.f, "SHA-1");
        hashMap.put(NISTObjectIdentifiers.d, "SHA-224");
        hashMap.put(NISTObjectIdentifiers.a, "SHA-256");
        hashMap.put(NISTObjectIdentifiers.b, "SHA-384");
        hashMap.put(NISTObjectIdentifiers.c, "SHA-512");
        hashMap.put(TeleTrusTObjectIdentifiers.b, "RIPEMD-128");
        hashMap.put(TeleTrusTObjectIdentifiers.a, "RIPEMD-160");
        hashMap.put(TeleTrusTObjectIdentifiers.c, "RIPEMD-128");
        hashMap.put(ISOIECObjectIdentifiers.b, "RIPEMD-128");
        hashMap.put(ISOIECObjectIdentifiers.a, "RIPEMD-160");
        hashMap.put(CryptoProObjectIdentifiers.a, "GOST3411");
        hashMap.put(GNUObjectIdentifiers.a, "Tiger");
        hashMap.put(ISOIECObjectIdentifiers.c, "Whirlpool");
        hashMap.put(NISTObjectIdentifiers.g, "SHA3-224");
        hashMap.put(NISTObjectIdentifiers.h, "SHA3-256");
        hashMap.put(NISTObjectIdentifiers.i, "SHA3-384");
        hashMap.put(NISTObjectIdentifiers.j, "SHA3-512");
        hashMap.put(GMObjectIdentifiers.c, "SM3");
    }

    public static String a(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String str = (String) a.get(aSN1ObjectIdentifier);
        if (str != null) {
            return str;
        }
        return aSN1ObjectIdentifier.c;
    }
}
