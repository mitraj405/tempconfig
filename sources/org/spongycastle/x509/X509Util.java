package org.spongycastle.x509;

import java.util.HashSet;
import java.util.Hashtable;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.RSASSAPSSparams;
import org.spongycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;

class X509Util {

    public static class Implementation {
    }

    static {
        Hashtable hashtable = new Hashtable();
        Hashtable hashtable2 = new Hashtable();
        HashSet hashSet = new HashSet();
        ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.b;
        hashtable.put("MD2WITHRSAENCRYPTION", aSN1ObjectIdentifier);
        hashtable.put("MD2WITHRSA", aSN1ObjectIdentifier);
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = PKCSObjectIdentifiers.d;
        hashtable.put("MD5WITHRSAENCRYPTION", aSN1ObjectIdentifier2);
        hashtable.put("MD5WITHRSA", aSN1ObjectIdentifier2);
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = PKCSObjectIdentifiers.e;
        hashtable.put("SHA1WITHRSAENCRYPTION", aSN1ObjectIdentifier3);
        hashtable.put("SHA1WITHRSA", aSN1ObjectIdentifier3);
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = PKCSObjectIdentifiers.m;
        hashtable.put("SHA224WITHRSAENCRYPTION", aSN1ObjectIdentifier4);
        hashtable.put("SHA224WITHRSA", aSN1ObjectIdentifier4);
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = PKCSObjectIdentifiers.j;
        hashtable.put("SHA256WITHRSAENCRYPTION", aSN1ObjectIdentifier5);
        hashtable.put("SHA256WITHRSA", aSN1ObjectIdentifier5);
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = PKCSObjectIdentifiers.k;
        hashtable.put("SHA384WITHRSAENCRYPTION", aSN1ObjectIdentifier6);
        hashtable.put("SHA384WITHRSA", aSN1ObjectIdentifier6);
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = PKCSObjectIdentifiers.l;
        hashtable.put("SHA512WITHRSAENCRYPTION", aSN1ObjectIdentifier7);
        hashtable.put("SHA512WITHRSA", aSN1ObjectIdentifier7);
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = PKCSObjectIdentifiers.i;
        hashtable.put("SHA1WITHRSAANDMGF1", aSN1ObjectIdentifier8);
        hashtable.put("SHA224WITHRSAANDMGF1", aSN1ObjectIdentifier8);
        hashtable.put("SHA256WITHRSAANDMGF1", aSN1ObjectIdentifier8);
        hashtable.put("SHA384WITHRSAANDMGF1", aSN1ObjectIdentifier8);
        hashtable.put("SHA512WITHRSAANDMGF1", aSN1ObjectIdentifier8);
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = TeleTrusTObjectIdentifiers.d;
        hashtable.put("RIPEMD160WITHRSAENCRYPTION", aSN1ObjectIdentifier9);
        hashtable.put("RIPEMD160WITHRSA", aSN1ObjectIdentifier9);
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = TeleTrusTObjectIdentifiers.e;
        hashtable.put("RIPEMD128WITHRSAENCRYPTION", aSN1ObjectIdentifier10);
        hashtable.put("RIPEMD128WITHRSA", aSN1ObjectIdentifier10);
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = TeleTrusTObjectIdentifiers.f;
        hashtable.put("RIPEMD256WITHRSAENCRYPTION", aSN1ObjectIdentifier11);
        hashtable.put("RIPEMD256WITHRSA", aSN1ObjectIdentifier11);
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = X9ObjectIdentifiers.U0;
        hashtable.put("SHA1WITHDSA", aSN1ObjectIdentifier12);
        hashtable.put("DSAWITHSHA1", aSN1ObjectIdentifier12);
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = NISTObjectIdentifiers.P;
        hashtable.put("SHA224WITHDSA", aSN1ObjectIdentifier13);
        ASN1ObjectIdentifier aSN1ObjectIdentifier14 = NISTObjectIdentifiers.Q;
        hashtable.put("SHA256WITHDSA", aSN1ObjectIdentifier14);
        ASN1ObjectIdentifier aSN1ObjectIdentifier15 = NISTObjectIdentifiers.R;
        hashtable.put("SHA384WITHDSA", aSN1ObjectIdentifier15);
        ASN1ObjectIdentifier aSN1ObjectIdentifier16 = NISTObjectIdentifiers.S;
        hashtable.put("SHA512WITHDSA", aSN1ObjectIdentifier16);
        ASN1ObjectIdentifier aSN1ObjectIdentifier17 = X9ObjectIdentifiers.p0;
        hashtable.put("SHA1WITHECDSA", aSN1ObjectIdentifier17);
        hashtable.put("ECDSAWITHSHA1", aSN1ObjectIdentifier17);
        ASN1ObjectIdentifier aSN1ObjectIdentifier18 = X9ObjectIdentifiers.s0;
        hashtable.put("SHA224WITHECDSA", aSN1ObjectIdentifier18);
        ASN1ObjectIdentifier aSN1ObjectIdentifier19 = X9ObjectIdentifiers.t0;
        hashtable.put("SHA256WITHECDSA", aSN1ObjectIdentifier19);
        ASN1ObjectIdentifier aSN1ObjectIdentifier20 = X9ObjectIdentifiers.u0;
        hashtable.put("SHA384WITHECDSA", aSN1ObjectIdentifier20);
        ASN1ObjectIdentifier aSN1ObjectIdentifier21 = X9ObjectIdentifiers.v0;
        hashtable.put("SHA512WITHECDSA", aSN1ObjectIdentifier21);
        ASN1ObjectIdentifier aSN1ObjectIdentifier22 = CryptoProObjectIdentifiers.m;
        hashtable.put("GOST3411WITHGOST3410", aSN1ObjectIdentifier22);
        hashtable.put("GOST3411WITHGOST3410-94", aSN1ObjectIdentifier22);
        ASN1ObjectIdentifier aSN1ObjectIdentifier23 = CryptoProObjectIdentifiers.n;
        Hashtable hashtable3 = hashtable2;
        hashtable.put("GOST3411WITHECGOST3410", aSN1ObjectIdentifier23);
        hashtable.put("GOST3411WITHECGOST3410-2001", aSN1ObjectIdentifier23);
        hashtable.put("GOST3411WITHGOST3410-2001", aSN1ObjectIdentifier23);
        hashSet.add(aSN1ObjectIdentifier17);
        hashSet.add(aSN1ObjectIdentifier18);
        hashSet.add(aSN1ObjectIdentifier19);
        hashSet.add(aSN1ObjectIdentifier20);
        hashSet.add(aSN1ObjectIdentifier21);
        hashSet.add(aSN1ObjectIdentifier12);
        hashSet.add(aSN1ObjectIdentifier13);
        hashSet.add(aSN1ObjectIdentifier14);
        hashSet.add(aSN1ObjectIdentifier15);
        hashSet.add(aSN1ObjectIdentifier16);
        hashSet.add(aSN1ObjectIdentifier22);
        hashSet.add(aSN1ObjectIdentifier23);
        ASN1ObjectIdentifier aSN1ObjectIdentifier24 = OIWObjectIdentifiers.f;
        DERNull dERNull = DERNull.a;
        Hashtable hashtable4 = hashtable3;
        hashtable4.put("SHA1WITHRSAANDMGF1", a(20, new AlgorithmIdentifier(aSN1ObjectIdentifier24, dERNull)));
        hashtable4.put("SHA224WITHRSAANDMGF1", a(28, new AlgorithmIdentifier(NISTObjectIdentifiers.d, dERNull)));
        hashtable4.put("SHA256WITHRSAANDMGF1", a(32, new AlgorithmIdentifier(NISTObjectIdentifiers.a, dERNull)));
        hashtable4.put("SHA384WITHRSAANDMGF1", a(48, new AlgorithmIdentifier(NISTObjectIdentifiers.b, dERNull)));
        hashtable4.put("SHA512WITHRSAANDMGF1", a(64, new AlgorithmIdentifier(NISTObjectIdentifiers.c, dERNull)));
    }

    public static RSASSAPSSparams a(int i, AlgorithmIdentifier algorithmIdentifier) {
        return new RSASSAPSSparams(algorithmIdentifier, new AlgorithmIdentifier(PKCSObjectIdentifiers.g, algorithmIdentifier), new ASN1Integer((long) i), new ASN1Integer(1));
    }
}
