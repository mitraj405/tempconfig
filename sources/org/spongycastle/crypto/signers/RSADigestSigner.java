package org.spongycastle.crypto.signers;

import java.util.Hashtable;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.crypto.Signer;

public class RSADigestSigner implements Signer {
    static {
        Hashtable hashtable = new Hashtable();
        hashtable.put("RIPEMD128", TeleTrusTObjectIdentifiers.b);
        hashtable.put("RIPEMD160", TeleTrusTObjectIdentifiers.a);
        hashtable.put("RIPEMD256", TeleTrusTObjectIdentifiers.c);
        hashtable.put("SHA-1", X509ObjectIdentifiers.j0);
        hashtable.put("SHA-224", NISTObjectIdentifiers.d);
        hashtable.put("SHA-256", NISTObjectIdentifiers.a);
        hashtable.put("SHA-384", NISTObjectIdentifiers.b);
        hashtable.put("SHA-512", NISTObjectIdentifiers.c);
        hashtable.put("SHA-512/224", NISTObjectIdentifiers.e);
        hashtable.put("SHA-512/256", NISTObjectIdentifiers.f);
        hashtable.put("SHA3-224", NISTObjectIdentifiers.g);
        hashtable.put("SHA3-256", NISTObjectIdentifiers.h);
        hashtable.put("SHA3-384", NISTObjectIdentifiers.i);
        hashtable.put("SHA3-512", NISTObjectIdentifiers.j);
        hashtable.put("MD2", PKCSObjectIdentifiers.B);
        hashtable.put("MD4", PKCSObjectIdentifiers.C);
        hashtable.put("MD5", PKCSObjectIdentifiers.D);
    }
}
