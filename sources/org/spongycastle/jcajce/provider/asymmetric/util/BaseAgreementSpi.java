package org.spongycastle.jcajce.provider.asymmetric.util;

import com.google.android.gms.ads.AdRequest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Hashtable;
import javax.crypto.KeyAgreementSpi;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.gnu.GNUObjectIdentifiers;
import org.spongycastle.asn1.kisa.KISAObjectIdentifiers;
import org.spongycastle.asn1.misc.MiscObjectIdentifiers;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.ntt.NTTObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.agreement.kdf.DHKDFParameters;
import org.spongycastle.crypto.agreement.kdf.DHKEKGenerator;
import org.spongycastle.crypto.params.DESParameters;
import org.spongycastle.crypto.params.KDFParameters;
import org.spongycastle.util.Strings;

public abstract class BaseAgreementSpi extends KeyAgreementSpi {
    public static final HashMap a;

    /* renamed from: a  reason: collision with other field name */
    public static final Hashtable f6475a;
    public static final HashMap b;

    /* renamed from: b  reason: collision with other field name */
    public static final Hashtable f6476b;

    /* renamed from: a  reason: collision with other field name */
    public final String f6477a;

    /* renamed from: a  reason: collision with other field name */
    public final DerivationFunction f6478a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f6479a;

    static {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        a = hashMap2;
        HashMap hashMap3 = new HashMap();
        b = hashMap3;
        Hashtable hashtable = new Hashtable();
        f6475a = hashtable;
        Hashtable hashtable2 = new Hashtable();
        f6476b = hashtable2;
        hashMap2.put("DES", 64);
        hashMap2.put("DESEDE", 192);
        hashMap2.put("BLOWFISH", 128);
        hashMap2.put("AES", 256);
        hashMap2.put(NISTObjectIdentifiers.r.c, 128);
        hashMap2.put(NISTObjectIdentifiers.z.c, 192);
        hashMap2.put(NISTObjectIdentifiers.H.c, 256);
        hashMap2.put(NISTObjectIdentifiers.s.c, 128);
        hashMap2.put(NISTObjectIdentifiers.A.c, 192);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = NISTObjectIdentifiers.I;
        hashMap2.put(aSN1ObjectIdentifier.c, 256);
        hashMap2.put(NISTObjectIdentifiers.u.c, 128);
        hashMap2.put(NISTObjectIdentifiers.C.c, 192);
        hashMap2.put(NISTObjectIdentifiers.K.c, 256);
        hashMap2.put(NISTObjectIdentifiers.t.c, 128);
        hashMap2.put(NISTObjectIdentifiers.B.c, 192);
        hashMap2.put(NISTObjectIdentifiers.J.c, 256);
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = NISTObjectIdentifiers.v;
        hashMap2.put(aSN1ObjectIdentifier2.c, 128);
        hashMap2.put(NISTObjectIdentifiers.D.c, 192);
        hashMap2.put(NISTObjectIdentifiers.L.c, 256);
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NISTObjectIdentifiers.x;
        hashMap2.put(aSN1ObjectIdentifier3.c, 128);
        hashMap2.put(NISTObjectIdentifiers.F.c, 192);
        hashMap2.put(NISTObjectIdentifiers.N.c, 256);
        hashMap2.put(NISTObjectIdentifiers.w.c, 128);
        hashMap2.put(NISTObjectIdentifiers.E.c, 192);
        hashMap2.put(NISTObjectIdentifiers.M.c, 256);
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = NTTObjectIdentifiers.d;
        Hashtable hashtable3 = hashtable2;
        hashMap2.put(aSN1ObjectIdentifier4.c, 128);
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = NTTObjectIdentifiers.e;
        Hashtable hashtable4 = hashtable;
        hashMap2.put(aSN1ObjectIdentifier5.c, 192);
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = NTTObjectIdentifiers.f;
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = aSN1ObjectIdentifier3;
        hashMap2.put(aSN1ObjectIdentifier6.c, 256);
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = KISAObjectIdentifiers.c;
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = aSN1ObjectIdentifier2;
        hashMap2.put(aSN1ObjectIdentifier8.c, 128);
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = PKCSObjectIdentifiers.c0;
        hashMap2.put(aSN1ObjectIdentifier10.c, 192);
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = PKCSObjectIdentifiers.y;
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = aSN1ObjectIdentifier8;
        hashMap2.put(aSN1ObjectIdentifier11.c, 192);
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = OIWObjectIdentifiers.b;
        hashMap2.put(aSN1ObjectIdentifier13.c, 64);
        ASN1ObjectIdentifier aSN1ObjectIdentifier14 = CryptoProObjectIdentifiers.e;
        hashMap2.put(aSN1ObjectIdentifier14.c, 256);
        hashMap2.put(CryptoProObjectIdentifiers.c.c, 256);
        hashMap2.put(CryptoProObjectIdentifiers.d.c, 256);
        ASN1ObjectIdentifier aSN1ObjectIdentifier15 = PKCSObjectIdentifiers.E;
        ASN1ObjectIdentifier aSN1ObjectIdentifier16 = aSN1ObjectIdentifier14;
        ASN1ObjectIdentifier aSN1ObjectIdentifier17 = aSN1ObjectIdentifier6;
        hashMap2.put(aSN1ObjectIdentifier15.c, 160);
        ASN1ObjectIdentifier aSN1ObjectIdentifier18 = PKCSObjectIdentifiers.G;
        hashMap2.put(aSN1ObjectIdentifier18.c, 256);
        ASN1ObjectIdentifier aSN1ObjectIdentifier19 = PKCSObjectIdentifiers.H;
        ASN1ObjectIdentifier aSN1ObjectIdentifier20 = aSN1ObjectIdentifier5;
        hashMap2.put(aSN1ObjectIdentifier19.c, 384);
        ASN1ObjectIdentifier aSN1ObjectIdentifier21 = PKCSObjectIdentifiers.I;
        hashMap2.put(aSN1ObjectIdentifier21.c, Integer.valueOf(AdRequest.MAX_CONTENT_URL_LENGTH));
        hashMap.put("DESEDE", aSN1ObjectIdentifier11);
        hashMap.put("AES", aSN1ObjectIdentifier);
        ASN1ObjectIdentifier aSN1ObjectIdentifier22 = NTTObjectIdentifiers.c;
        hashMap.put("CAMELLIA", aSN1ObjectIdentifier22);
        ASN1ObjectIdentifier aSN1ObjectIdentifier23 = KISAObjectIdentifiers.a;
        hashMap.put("SEED", aSN1ObjectIdentifier23);
        hashMap.put("DES", aSN1ObjectIdentifier13);
        ASN1ObjectIdentifier aSN1ObjectIdentifier24 = aSN1ObjectIdentifier;
        hashMap3.put(MiscObjectIdentifiers.d.c, "CAST5");
        hashMap3.put(MiscObjectIdentifiers.e.c, "IDEA");
        hashMap3.put(MiscObjectIdentifiers.f.c, "Blowfish");
        hashMap3.put(MiscObjectIdentifiers.g.c, "Blowfish");
        hashMap3.put(MiscObjectIdentifiers.h.c, "Blowfish");
        hashMap3.put(MiscObjectIdentifiers.i.c, "Blowfish");
        hashMap3.put(OIWObjectIdentifiers.a.c, "DES");
        String str = aSN1ObjectIdentifier13.c;
        hashMap3.put(str, "DES");
        hashMap3.put(OIWObjectIdentifiers.d.c, "DES");
        hashMap3.put(OIWObjectIdentifiers.c.c, "DES");
        String str2 = str;
        hashMap3.put(OIWObjectIdentifiers.e.c, "DESede");
        String str3 = aSN1ObjectIdentifier11.c;
        hashMap3.put(str3, "DESede");
        String str4 = aSN1ObjectIdentifier10.c;
        hashMap3.put(str4, "DESede");
        hashMap3.put(PKCSObjectIdentifiers.d0.c, "RC2");
        hashMap3.put(aSN1ObjectIdentifier15.c, "HmacSHA1");
        hashMap3.put(PKCSObjectIdentifiers.F.c, "HmacSHA224");
        hashMap3.put(aSN1ObjectIdentifier18.c, "HmacSHA256");
        hashMap3.put(aSN1ObjectIdentifier19.c, "HmacSHA384");
        hashMap3.put(aSN1ObjectIdentifier21.c, "HmacSHA512");
        hashMap3.put(NTTObjectIdentifiers.a.c, "Camellia");
        hashMap3.put(NTTObjectIdentifiers.b.c, "Camellia");
        hashMap3.put(aSN1ObjectIdentifier22.c, "Camellia");
        hashMap3.put(aSN1ObjectIdentifier4.c, "Camellia");
        hashMap3.put(aSN1ObjectIdentifier20.c, "Camellia");
        hashMap3.put(aSN1ObjectIdentifier17.c, "Camellia");
        hashMap3.put(aSN1ObjectIdentifier12.c, "SEED");
        hashMap3.put(aSN1ObjectIdentifier23.c, "SEED");
        hashMap3.put(KISAObjectIdentifiers.b.c, "SEED");
        hashMap3.put(aSN1ObjectIdentifier16.c, "GOST28147");
        hashMap3.put(aSN1ObjectIdentifier9.c, "AES");
        String str5 = aSN1ObjectIdentifier7.c;
        hashMap3.put(str5, "AES");
        hashMap3.put(str5, "AES");
        Hashtable hashtable5 = hashtable4;
        hashtable5.put("DESEDE", aSN1ObjectIdentifier11);
        hashtable5.put("AES", aSN1ObjectIdentifier24);
        hashtable5.put("DES", aSN1ObjectIdentifier13);
        Hashtable hashtable6 = hashtable3;
        hashtable6.put("DES", "DES");
        hashtable6.put("DESEDE", "DES");
        hashtable6.put(str2, "DES");
        hashtable6.put(str3, "DES");
        hashtable6.put(str4, "DES");
    }

    public BaseAgreementSpi(String str, DerivationFunction derivationFunction) {
        this.f6477a = str;
        this.f6478a = derivationFunction;
    }

    public abstract byte[] a();

    public byte[] engineGenerateSecret() throws IllegalStateException {
        if (this.f6478a == null) {
            return a();
        }
        throw new UnsupportedOperationException("KDF can only be used when algorithm is known");
    }

    public int engineGenerateSecret(byte[] bArr, int i) throws IllegalStateException, ShortBufferException {
        byte[] engineGenerateSecret = engineGenerateSecret();
        if (bArr.length - i >= engineGenerateSecret.length) {
            System.arraycopy(engineGenerateSecret, 0, bArr, i, engineGenerateSecret.length);
            return engineGenerateSecret.length;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6477a);
        sb.append(" key agreement: need ");
        throw new ShortBufferException(lf.k(sb, engineGenerateSecret.length, " bytes"));
    }

    public SecretKey engineGenerateSecret(String str) throws NoSuchAlgorithmException {
        int i;
        byte[] a2 = a();
        String g = Strings.g(str);
        Hashtable hashtable = f6475a;
        String str2 = hashtable.containsKey(g) ? ((ASN1ObjectIdentifier) hashtable.get(g)).c : str;
        if (str2.indexOf(91) > 0) {
            i = Integer.parseInt(str2.substring(str2.indexOf(91) + 1, str2.indexOf(93)));
        } else {
            String g2 = Strings.g(str2);
            HashMap hashMap = a;
            if (!hashMap.containsKey(g2)) {
                i = -1;
            } else {
                i = ((Integer) hashMap.get(g2)).intValue();
            }
        }
        DerivationFunction derivationFunction = this.f6478a;
        if (derivationFunction != null) {
            if (i >= 0) {
                int i2 = i / 8;
                byte[] bArr = new byte[i2];
                if (derivationFunction instanceof DHKEKGenerator) {
                    try {
                        derivationFunction.a(new DHKDFParameters(new ASN1ObjectIdentifier(str2), i, a2, this.f6479a));
                    } catch (IllegalArgumentException unused) {
                        throw new NoSuchAlgorithmException("no OID for algorithm: ".concat(str2));
                    }
                } else {
                    derivationFunction.a(new KDFParameters(a2, this.f6479a));
                }
                derivationFunction.b(bArr, i2);
                a2 = bArr;
            } else {
                throw new NoSuchAlgorithmException("unknown algorithm encountered: ".concat(str2));
            }
        } else if (i > 0) {
            int i3 = i / 8;
            byte[] bArr2 = new byte[i3];
            System.arraycopy(a2, 0, bArr2, 0, i3);
            a2 = bArr2;
        }
        if (str.indexOf(91) > 0) {
            str = str.substring(0, str.indexOf(91));
        } else if (str.startsWith(NISTObjectIdentifiers.q.c)) {
            str = "AES";
        } else if (str.startsWith(GNUObjectIdentifiers.b.c)) {
            str = "Serpent";
        } else {
            String str3 = (String) b.get(Strings.g(str));
            if (str3 != null) {
                str = str3;
            }
        }
        if (f6476b.containsKey(str)) {
            DESParameters.b(a2);
        }
        return new SecretKeySpec(a2, str);
    }
}
