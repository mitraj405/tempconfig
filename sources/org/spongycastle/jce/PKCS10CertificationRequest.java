package org.spongycastle.jce;

import java.io.IOException;
import java.util.HashSet;
import java.util.Hashtable;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.CertificationRequest;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.RSASSAPSSparams;
import org.spongycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;

public class PKCS10CertificationRequest extends CertificationRequest {
    static {
        Hashtable hashtable = new Hashtable();
        Hashtable hashtable2 = new Hashtable();
        Hashtable hashtable3 = new Hashtable();
        Hashtable hashtable4 = new Hashtable();
        HashSet hashSet = new HashSet();
        hashtable.put("MD2WITHRSAENCRYPTION", new ASN1ObjectIdentifier("1.2.840.113549.1.1.2"));
        hashtable.put("MD2WITHRSA", new ASN1ObjectIdentifier("1.2.840.113549.1.1.2"));
        hashtable.put("MD5WITHRSAENCRYPTION", new ASN1ObjectIdentifier("1.2.840.113549.1.1.4"));
        hashtable.put("MD5WITHRSA", new ASN1ObjectIdentifier("1.2.840.113549.1.1.4"));
        hashtable.put("RSAWITHMD5", new ASN1ObjectIdentifier("1.2.840.113549.1.1.4"));
        hashtable.put("SHA1WITHRSAENCRYPTION", new ASN1ObjectIdentifier("1.2.840.113549.1.1.5"));
        hashtable.put("SHA1WITHRSA", new ASN1ObjectIdentifier("1.2.840.113549.1.1.5"));
        ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.m;
        hashtable.put("SHA224WITHRSAENCRYPTION", aSN1ObjectIdentifier);
        hashtable.put("SHA224WITHRSA", aSN1ObjectIdentifier);
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = PKCSObjectIdentifiers.j;
        hashtable.put("SHA256WITHRSAENCRYPTION", aSN1ObjectIdentifier2);
        hashtable.put("SHA256WITHRSA", aSN1ObjectIdentifier2);
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = PKCSObjectIdentifiers.k;
        Hashtable hashtable5 = hashtable2;
        hashtable.put("SHA384WITHRSAENCRYPTION", aSN1ObjectIdentifier3);
        hashtable.put("SHA384WITHRSA", aSN1ObjectIdentifier3);
        HashSet hashSet2 = hashSet;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = PKCSObjectIdentifiers.l;
        Hashtable hashtable6 = hashtable3;
        hashtable.put("SHA512WITHRSAENCRYPTION", aSN1ObjectIdentifier4);
        hashtable.put("SHA512WITHRSA", aSN1ObjectIdentifier4);
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = PKCSObjectIdentifiers.i;
        hashtable.put("SHA1WITHRSAANDMGF1", aSN1ObjectIdentifier5);
        hashtable.put("SHA224WITHRSAANDMGF1", aSN1ObjectIdentifier5);
        hashtable.put("SHA256WITHRSAANDMGF1", aSN1ObjectIdentifier5);
        hashtable.put("SHA384WITHRSAANDMGF1", aSN1ObjectIdentifier5);
        hashtable.put("SHA512WITHRSAANDMGF1", aSN1ObjectIdentifier5);
        hashtable.put("RSAWITHSHA1", new ASN1ObjectIdentifier("1.2.840.113549.1.1.5"));
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = TeleTrusTObjectIdentifiers.e;
        hashtable.put("RIPEMD128WITHRSAENCRYPTION", aSN1ObjectIdentifier6);
        hashtable.put("RIPEMD128WITHRSA", aSN1ObjectIdentifier6);
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = TeleTrusTObjectIdentifiers.d;
        hashtable.put("RIPEMD160WITHRSAENCRYPTION", aSN1ObjectIdentifier7);
        hashtable.put("RIPEMD160WITHRSA", aSN1ObjectIdentifier7);
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = TeleTrusTObjectIdentifiers.f;
        hashtable.put("RIPEMD256WITHRSAENCRYPTION", aSN1ObjectIdentifier8);
        hashtable.put("RIPEMD256WITHRSA", aSN1ObjectIdentifier8);
        hashtable.put("SHA1WITHDSA", new ASN1ObjectIdentifier("1.2.840.10040.4.3"));
        hashtable.put("DSAWITHSHA1", new ASN1ObjectIdentifier("1.2.840.10040.4.3"));
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = NISTObjectIdentifiers.P;
        hashtable.put("SHA224WITHDSA", aSN1ObjectIdentifier9);
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = aSN1ObjectIdentifier9;
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = NISTObjectIdentifiers.Q;
        hashtable.put("SHA256WITHDSA", aSN1ObjectIdentifier11);
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = aSN1ObjectIdentifier11;
        hashtable.put("SHA384WITHDSA", NISTObjectIdentifiers.R);
        hashtable.put("SHA512WITHDSA", NISTObjectIdentifiers.S);
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = X9ObjectIdentifiers.p0;
        hashtable.put("SHA1WITHECDSA", aSN1ObjectIdentifier13);
        ASN1ObjectIdentifier aSN1ObjectIdentifier14 = X9ObjectIdentifiers.s0;
        hashtable.put("SHA224WITHECDSA", aSN1ObjectIdentifier14);
        ASN1ObjectIdentifier aSN1ObjectIdentifier15 = X9ObjectIdentifiers.t0;
        hashtable.put("SHA256WITHECDSA", aSN1ObjectIdentifier15);
        ASN1ObjectIdentifier aSN1ObjectIdentifier16 = aSN1ObjectIdentifier15;
        ASN1ObjectIdentifier aSN1ObjectIdentifier17 = X9ObjectIdentifiers.u0;
        hashtable.put("SHA384WITHECDSA", aSN1ObjectIdentifier17);
        ASN1ObjectIdentifier aSN1ObjectIdentifier18 = aSN1ObjectIdentifier17;
        ASN1ObjectIdentifier aSN1ObjectIdentifier19 = X9ObjectIdentifiers.v0;
        hashtable.put("SHA512WITHECDSA", aSN1ObjectIdentifier19);
        ASN1ObjectIdentifier aSN1ObjectIdentifier20 = aSN1ObjectIdentifier19;
        hashtable.put("ECDSAWITHSHA1", aSN1ObjectIdentifier13);
        ASN1ObjectIdentifier aSN1ObjectIdentifier21 = CryptoProObjectIdentifiers.m;
        hashtable.put("GOST3411WITHGOST3410", aSN1ObjectIdentifier21);
        ASN1ObjectIdentifier aSN1ObjectIdentifier22 = aSN1ObjectIdentifier13;
        hashtable.put("GOST3410WITHGOST3411", aSN1ObjectIdentifier21);
        ASN1ObjectIdentifier aSN1ObjectIdentifier23 = CryptoProObjectIdentifiers.n;
        hashtable.put("GOST3411WITHECGOST3410", aSN1ObjectIdentifier23);
        hashtable.put("GOST3411WITHECGOST3410-2001", aSN1ObjectIdentifier23);
        hashtable.put("GOST3411WITHGOST3410-2001", aSN1ObjectIdentifier23);
        hashtable4.put(new ASN1ObjectIdentifier("1.2.840.113549.1.1.5"), "SHA1WITHRSA");
        hashtable4.put(aSN1ObjectIdentifier, "SHA224WITHRSA");
        hashtable4.put(aSN1ObjectIdentifier2, "SHA256WITHRSA");
        hashtable4.put(aSN1ObjectIdentifier3, "SHA384WITHRSA");
        hashtable4.put(aSN1ObjectIdentifier4, "SHA512WITHRSA");
        hashtable4.put(aSN1ObjectIdentifier21, "GOST3411WITHGOST3410");
        hashtable4.put(aSN1ObjectIdentifier23, "GOST3411WITHECGOST3410");
        hashtable4.put(new ASN1ObjectIdentifier("1.2.840.113549.1.1.4"), "MD5WITHRSA");
        hashtable4.put(new ASN1ObjectIdentifier("1.2.840.113549.1.1.2"), "MD2WITHRSA");
        Object obj = "SHA1WITHDSA";
        hashtable4.put(new ASN1ObjectIdentifier("1.2.840.10040.4.3"), obj);
        ASN1ObjectIdentifier aSN1ObjectIdentifier24 = aSN1ObjectIdentifier22;
        hashtable4.put(aSN1ObjectIdentifier24, "SHA1WITHECDSA");
        ASN1ObjectIdentifier aSN1ObjectIdentifier25 = aSN1ObjectIdentifier14;
        hashtable4.put(aSN1ObjectIdentifier25, "SHA224WITHECDSA");
        ASN1ObjectIdentifier aSN1ObjectIdentifier26 = aSN1ObjectIdentifier16;
        hashtable4.put(aSN1ObjectIdentifier26, "SHA256WITHECDSA");
        ASN1ObjectIdentifier aSN1ObjectIdentifier27 = aSN1ObjectIdentifier18;
        hashtable4.put(aSN1ObjectIdentifier27, "SHA384WITHECDSA");
        ASN1ObjectIdentifier aSN1ObjectIdentifier28 = aSN1ObjectIdentifier20;
        hashtable4.put(aSN1ObjectIdentifier28, "SHA512WITHECDSA");
        hashtable4.put(OIWObjectIdentifiers.h, "SHA1WITHRSA");
        hashtable4.put(OIWObjectIdentifiers.g, obj);
        ASN1ObjectIdentifier aSN1ObjectIdentifier29 = aSN1ObjectIdentifier10;
        hashtable4.put(aSN1ObjectIdentifier29, "SHA224WITHDSA");
        ASN1ObjectIdentifier aSN1ObjectIdentifier30 = aSN1ObjectIdentifier12;
        hashtable4.put(aSN1ObjectIdentifier30, "SHA256WITHDSA");
        Hashtable hashtable7 = hashtable6;
        hashtable7.put(PKCSObjectIdentifiers.a, "RSA");
        hashtable7.put(X9ObjectIdentifiers.T0, "DSA");
        HashSet hashSet3 = hashSet2;
        hashSet3.add(aSN1ObjectIdentifier24);
        hashSet3.add(aSN1ObjectIdentifier25);
        hashSet3.add(aSN1ObjectIdentifier26);
        hashSet3.add(aSN1ObjectIdentifier27);
        hashSet3.add(aSN1ObjectIdentifier28);
        hashSet3.add(X9ObjectIdentifiers.U0);
        hashSet3.add(aSN1ObjectIdentifier29);
        hashSet3.add(aSN1ObjectIdentifier30);
        hashSet3.add(aSN1ObjectIdentifier21);
        hashSet3.add(aSN1ObjectIdentifier23);
        ASN1ObjectIdentifier aSN1ObjectIdentifier31 = OIWObjectIdentifiers.f;
        DERNull dERNull = DERNull.a;
        Hashtable hashtable8 = hashtable5;
        hashtable8.put("SHA1WITHRSAANDMGF1", g(20, new AlgorithmIdentifier(aSN1ObjectIdentifier31, dERNull)));
        hashtable8.put("SHA224WITHRSAANDMGF1", g(28, new AlgorithmIdentifier(NISTObjectIdentifiers.d, dERNull)));
        hashtable8.put("SHA256WITHRSAANDMGF1", g(32, new AlgorithmIdentifier(NISTObjectIdentifiers.a, dERNull)));
        hashtable8.put("SHA384WITHRSAANDMGF1", g(48, new AlgorithmIdentifier(NISTObjectIdentifiers.b, dERNull)));
        hashtable8.put("SHA512WITHRSAANDMGF1", g(64, new AlgorithmIdentifier(NISTObjectIdentifiers.c, dERNull)));
    }

    public static RSASSAPSSparams g(int i, AlgorithmIdentifier algorithmIdentifier) {
        return new RSASSAPSSparams(algorithmIdentifier, new AlgorithmIdentifier(PKCSObjectIdentifiers.g, algorithmIdentifier), new ASN1Integer((long) i), new ASN1Integer(1));
    }

    public final byte[] e() {
        try {
            return f("DER");
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
    }
}
