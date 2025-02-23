package org.spongycastle.jcajce.provider.util;

import java.util.HashMap;
import java.util.HashSet;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.digests.MD5Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA224Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.digests.SHA512tDigest;
import org.spongycastle.util.Strings;

public class DigestFactory {
    public static final HashMap a;

    /* renamed from: a  reason: collision with other field name */
    public static final HashSet f6562a;
    public static final HashSet b;
    public static final HashSet c;
    public static final HashSet d;
    public static final HashSet e;
    public static final HashSet f;
    public static final HashSet g;
    public static final HashSet h;
    public static final HashSet i;
    public static final HashSet j;
    public static final HashSet k;
    public static final HashSet l;

    static {
        HashSet hashSet = new HashSet();
        f6562a = hashSet;
        HashSet hashSet2 = new HashSet();
        b = hashSet2;
        HashSet hashSet3 = new HashSet();
        c = hashSet3;
        HashSet hashSet4 = new HashSet();
        d = hashSet4;
        HashSet hashSet5 = new HashSet();
        e = hashSet5;
        HashSet hashSet6 = new HashSet();
        f = hashSet6;
        HashSet hashSet7 = new HashSet();
        g = hashSet7;
        HashSet hashSet8 = new HashSet();
        h = hashSet8;
        HashSet hashSet9 = new HashSet();
        i = hashSet9;
        HashSet hashSet10 = new HashSet();
        j = hashSet10;
        HashSet hashSet11 = new HashSet();
        k = hashSet11;
        HashSet hashSet12 = new HashSet();
        l = hashSet12;
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashSet.add("MD5");
        ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.D;
        hashSet.add(aSN1ObjectIdentifier.c);
        hashSet2.add("SHA1");
        hashSet2.add("SHA-1");
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = OIWObjectIdentifiers.f;
        hashSet2.add(aSN1ObjectIdentifier2.c);
        hashSet3.add("SHA224");
        hashSet3.add("SHA-224");
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NISTObjectIdentifiers.d;
        hashSet3.add(aSN1ObjectIdentifier3.c);
        hashSet4.add("SHA256");
        hashSet4.add("SHA-256");
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = NISTObjectIdentifiers.a;
        hashSet4.add(aSN1ObjectIdentifier4.c);
        hashSet5.add("SHA384");
        hashSet5.add("SHA-384");
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = NISTObjectIdentifiers.b;
        hashSet5.add(aSN1ObjectIdentifier5.c);
        hashSet6.add("SHA512");
        hashSet6.add("SHA-512");
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = NISTObjectIdentifiers.c;
        hashSet6.add(aSN1ObjectIdentifier6.c);
        hashSet7.add("SHA512(224)");
        hashSet7.add("SHA-512(224)");
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = NISTObjectIdentifiers.e;
        hashSet7.add(aSN1ObjectIdentifier7.c);
        hashSet8.add("SHA512(256)");
        hashSet8.add("SHA-512(256)");
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = NISTObjectIdentifiers.f;
        hashSet8.add(aSN1ObjectIdentifier8.c);
        hashSet9.add("SHA3-224");
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = NISTObjectIdentifiers.g;
        hashSet9.add(aSN1ObjectIdentifier9.c);
        hashSet10.add("SHA3-256");
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = NISTObjectIdentifiers.h;
        hashSet10.add(aSN1ObjectIdentifier10.c);
        hashSet11.add("SHA3-384");
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = NISTObjectIdentifiers.i;
        hashSet11.add(aSN1ObjectIdentifier11.c);
        hashSet12.add("SHA3-512");
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = NISTObjectIdentifiers.j;
        hashSet12.add(aSN1ObjectIdentifier12.c);
        hashMap.put("MD5", aSN1ObjectIdentifier);
        hashMap.put(aSN1ObjectIdentifier.c, aSN1ObjectIdentifier);
        hashMap.put("SHA1", aSN1ObjectIdentifier2);
        hashMap.put("SHA-1", aSN1ObjectIdentifier2);
        hashMap.put(aSN1ObjectIdentifier2.c, aSN1ObjectIdentifier2);
        hashMap.put("SHA224", aSN1ObjectIdentifier3);
        hashMap.put("SHA-224", aSN1ObjectIdentifier3);
        hashMap.put(aSN1ObjectIdentifier3.c, aSN1ObjectIdentifier3);
        hashMap.put("SHA256", aSN1ObjectIdentifier4);
        hashMap.put("SHA-256", aSN1ObjectIdentifier4);
        hashMap.put(aSN1ObjectIdentifier4.c, aSN1ObjectIdentifier4);
        hashMap.put("SHA384", aSN1ObjectIdentifier5);
        hashMap.put("SHA-384", aSN1ObjectIdentifier5);
        hashMap.put(aSN1ObjectIdentifier5.c, aSN1ObjectIdentifier5);
        hashMap.put("SHA512", aSN1ObjectIdentifier6);
        hashMap.put("SHA-512", aSN1ObjectIdentifier6);
        hashMap.put(aSN1ObjectIdentifier6.c, aSN1ObjectIdentifier6);
        hashMap.put("SHA512(224)", aSN1ObjectIdentifier7);
        hashMap.put("SHA-512(224)", aSN1ObjectIdentifier7);
        hashMap.put(aSN1ObjectIdentifier7.c, aSN1ObjectIdentifier7);
        hashMap.put("SHA512(256)", aSN1ObjectIdentifier8);
        hashMap.put("SHA-512(256)", aSN1ObjectIdentifier8);
        hashMap.put(aSN1ObjectIdentifier8.c, aSN1ObjectIdentifier8);
        hashMap.put("SHA3-224", aSN1ObjectIdentifier9);
        hashMap.put(aSN1ObjectIdentifier9.c, aSN1ObjectIdentifier9);
        hashMap.put("SHA3-256", aSN1ObjectIdentifier10);
        hashMap.put(aSN1ObjectIdentifier10.c, aSN1ObjectIdentifier10);
        hashMap.put("SHA3-384", aSN1ObjectIdentifier11);
        hashMap.put(aSN1ObjectIdentifier11.c, aSN1ObjectIdentifier11);
        hashMap.put("SHA3-512", aSN1ObjectIdentifier12);
        hashMap.put(aSN1ObjectIdentifier12.c, aSN1ObjectIdentifier12);
    }

    public static ExtendedDigest a(String str) {
        String g2 = Strings.g(str);
        if (b.contains(g2)) {
            return new SHA1Digest();
        }
        if (f6562a.contains(g2)) {
            return new MD5Digest();
        }
        if (c.contains(g2)) {
            return new SHA224Digest();
        }
        if (d.contains(g2)) {
            return new SHA256Digest();
        }
        if (e.contains(g2)) {
            return new SHA384Digest();
        }
        if (f.contains(g2)) {
            return new SHA512Digest();
        }
        if (g.contains(g2)) {
            return new SHA512tDigest(224);
        }
        if (h.contains(g2)) {
            return new SHA512tDigest(256);
        }
        if (i.contains(g2)) {
            return org.spongycastle.crypto.util.DigestFactory.a();
        }
        if (j.contains(g2)) {
            return org.spongycastle.crypto.util.DigestFactory.b();
        }
        if (k.contains(g2)) {
            return org.spongycastle.crypto.util.DigestFactory.c();
        }
        if (l.contains(g2)) {
            return org.spongycastle.crypto.util.DigestFactory.d();
        }
        return null;
    }

    public static boolean b(String str, String str2) {
        HashSet hashSet = b;
        if (!hashSet.contains(str) || !hashSet.contains(str2)) {
            HashSet hashSet2 = c;
            if (!hashSet2.contains(str) || !hashSet2.contains(str2)) {
                HashSet hashSet3 = d;
                if (!hashSet3.contains(str) || !hashSet3.contains(str2)) {
                    HashSet hashSet4 = e;
                    if (!hashSet4.contains(str) || !hashSet4.contains(str2)) {
                        HashSet hashSet5 = f;
                        if (!hashSet5.contains(str) || !hashSet5.contains(str2)) {
                            HashSet hashSet6 = g;
                            if (!hashSet6.contains(str) || !hashSet6.contains(str2)) {
                                HashSet hashSet7 = h;
                                if (!hashSet7.contains(str) || !hashSet7.contains(str2)) {
                                    HashSet hashSet8 = i;
                                    if (!hashSet8.contains(str) || !hashSet8.contains(str2)) {
                                        HashSet hashSet9 = j;
                                        if (!hashSet9.contains(str) || !hashSet9.contains(str2)) {
                                            HashSet hashSet10 = k;
                                            if (!hashSet10.contains(str) || !hashSet10.contains(str2)) {
                                                HashSet hashSet11 = l;
                                                if (!hashSet11.contains(str) || !hashSet11.contains(str2)) {
                                                    HashSet hashSet12 = f6562a;
                                                    if (!hashSet12.contains(str) || !hashSet12.contains(str2)) {
                                                        return false;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
