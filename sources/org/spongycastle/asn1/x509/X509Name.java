package org.spongycastle.asn1.x509;

import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1String;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERSet;
import org.spongycastle.asn1.DERUniversalString;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.util.Strings;
import org.spongycastle.util.encoders.Hex;

public class X509Name extends ASN1Object {
    public static final Boolean a = new Boolean(true);

    /* renamed from: a  reason: collision with other field name */
    public static final Hashtable f5776a;
    public static final Boolean b = new Boolean(false);

    /* renamed from: a  reason: collision with other field name */
    public final Vector f5777a = new Vector();

    /* renamed from: a  reason: collision with other field name */
    public ASN1Sequence f5778a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5779a;

    /* renamed from: b  reason: collision with other field name */
    public final Vector f5780b = new Vector();
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public final Vector f5781c = new Vector();

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("2.5.4.6");
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier("2.5.4.10");
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = new ASN1ObjectIdentifier("2.5.4.11");
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = new ASN1ObjectIdentifier("2.5.4.12");
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = new ASN1ObjectIdentifier("2.5.4.3");
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = new ASN1ObjectIdentifier("2.5.4.5");
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = new ASN1ObjectIdentifier("2.5.4.9");
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = new ASN1ObjectIdentifier("2.5.4.7");
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = new ASN1ObjectIdentifier("2.5.4.8");
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = new ASN1ObjectIdentifier("2.5.4.4");
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = new ASN1ObjectIdentifier("2.5.4.42");
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = new ASN1ObjectIdentifier("2.5.4.43");
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = new ASN1ObjectIdentifier("2.5.4.44");
        ASN1ObjectIdentifier aSN1ObjectIdentifier14 = new ASN1ObjectIdentifier("2.5.4.45");
        ASN1ObjectIdentifier aSN1ObjectIdentifier15 = new ASN1ObjectIdentifier("2.5.4.15");
        ASN1ObjectIdentifier aSN1ObjectIdentifier16 = new ASN1ObjectIdentifier("2.5.4.17");
        ASN1ObjectIdentifier aSN1ObjectIdentifier17 = new ASN1ObjectIdentifier("2.5.4.46");
        ASN1ObjectIdentifier aSN1ObjectIdentifier18 = new ASN1ObjectIdentifier("2.5.4.65");
        ASN1ObjectIdentifier aSN1ObjectIdentifier19 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.1");
        ASN1ObjectIdentifier aSN1ObjectIdentifier20 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.2");
        ASN1ObjectIdentifier aSN1ObjectIdentifier21 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.3");
        ASN1ObjectIdentifier aSN1ObjectIdentifier22 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.4");
        ASN1ObjectIdentifier aSN1ObjectIdentifier23 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.5");
        ASN1ObjectIdentifier aSN1ObjectIdentifier24 = new ASN1ObjectIdentifier("1.3.36.8.3.14");
        ASN1ObjectIdentifier aSN1ObjectIdentifier25 = new ASN1ObjectIdentifier("2.5.4.16");
        new ASN1ObjectIdentifier("2.5.4.54");
        ASN1ObjectIdentifier aSN1ObjectIdentifier26 = X509ObjectIdentifiers.g0;
        ASN1ObjectIdentifier aSN1ObjectIdentifier27 = X509ObjectIdentifiers.h0;
        ASN1ObjectIdentifier aSN1ObjectIdentifier28 = PKCSObjectIdentifiers.M;
        ASN1ObjectIdentifier aSN1ObjectIdentifier29 = aSN1ObjectIdentifier26;
        ASN1ObjectIdentifier aSN1ObjectIdentifier30 = aSN1ObjectIdentifier14;
        ASN1ObjectIdentifier aSN1ObjectIdentifier31 = PKCSObjectIdentifiers.N;
        ASN1ObjectIdentifier aSN1ObjectIdentifier32 = PKCSObjectIdentifiers.O;
        ASN1ObjectIdentifier aSN1ObjectIdentifier33 = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.25");
        ASN1ObjectIdentifier aSN1ObjectIdentifier34 = aSN1ObjectIdentifier13;
        ASN1ObjectIdentifier aSN1ObjectIdentifier35 = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.1");
        Hashtable hashtable = new Hashtable();
        f5776a = hashtable;
        ASN1ObjectIdentifier aSN1ObjectIdentifier36 = aSN1ObjectIdentifier12;
        Hashtable hashtable2 = new Hashtable();
        Hashtable hashtable3 = new Hashtable();
        Hashtable hashtable4 = new Hashtable();
        ASN1ObjectIdentifier aSN1ObjectIdentifier37 = aSN1ObjectIdentifier11;
        hashtable.put(aSN1ObjectIdentifier, "C");
        hashtable.put(aSN1ObjectIdentifier2, "O");
        hashtable.put(aSN1ObjectIdentifier4, RequestConfiguration.MAX_AD_CONTENT_RATING_T);
        hashtable.put(aSN1ObjectIdentifier3, "OU");
        ASN1ObjectIdentifier aSN1ObjectIdentifier38 = aSN1ObjectIdentifier4;
        hashtable.put(aSN1ObjectIdentifier5, "CN");
        hashtable.put(aSN1ObjectIdentifier8, "L");
        Object obj = "L";
        hashtable.put(aSN1ObjectIdentifier9, "ST");
        hashtable.put(aSN1ObjectIdentifier6, "SERIALNUMBER");
        hashtable.put(aSN1ObjectIdentifier28, "E");
        hashtable.put(aSN1ObjectIdentifier33, "DC");
        hashtable.put(aSN1ObjectIdentifier35, "UID");
        ASN1ObjectIdentifier aSN1ObjectIdentifier39 = aSN1ObjectIdentifier6;
        hashtable.put(aSN1ObjectIdentifier7, "STREET");
        ASN1ObjectIdentifier aSN1ObjectIdentifier40 = aSN1ObjectIdentifier35;
        hashtable.put(aSN1ObjectIdentifier10, "SURNAME");
        ASN1ObjectIdentifier aSN1ObjectIdentifier41 = aSN1ObjectIdentifier10;
        hashtable.put(aSN1ObjectIdentifier37, "GIVENNAME");
        hashtable.put(aSN1ObjectIdentifier36, "INITIALS");
        hashtable.put(aSN1ObjectIdentifier34, "GENERATION");
        hashtable.put(aSN1ObjectIdentifier32, "unstructuredAddress");
        hashtable.put(aSN1ObjectIdentifier31, "unstructuredName");
        hashtable.put(aSN1ObjectIdentifier30, "UniqueIdentifier");
        hashtable.put(aSN1ObjectIdentifier17, "DN");
        hashtable.put(aSN1ObjectIdentifier18, "Pseudonym");
        hashtable.put(aSN1ObjectIdentifier25, "PostalAddress");
        hashtable.put(aSN1ObjectIdentifier24, "NameAtBirth");
        hashtable.put(aSN1ObjectIdentifier22, "CountryOfCitizenship");
        hashtable.put(aSN1ObjectIdentifier23, "CountryOfResidence");
        hashtable.put(aSN1ObjectIdentifier21, "Gender");
        hashtable.put(aSN1ObjectIdentifier20, "PlaceOfBirth");
        hashtable.put(aSN1ObjectIdentifier19, "DateOfBirth");
        hashtable.put(aSN1ObjectIdentifier16, "PostalCode");
        hashtable.put(aSN1ObjectIdentifier15, "BusinessCategory");
        hashtable.put(aSN1ObjectIdentifier29, "TelephoneNumber");
        hashtable.put(aSN1ObjectIdentifier27, "Name");
        Hashtable hashtable5 = hashtable2;
        hashtable5.put(aSN1ObjectIdentifier, "C");
        ASN1ObjectIdentifier aSN1ObjectIdentifier42 = aSN1ObjectIdentifier2;
        hashtable5.put(aSN1ObjectIdentifier42, "O");
        hashtable5.put(aSN1ObjectIdentifier3, "OU");
        Object obj2 = "CN";
        hashtable5.put(aSN1ObjectIdentifier5, obj2);
        ASN1ObjectIdentifier aSN1ObjectIdentifier43 = aSN1ObjectIdentifier5;
        hashtable5.put(aSN1ObjectIdentifier8, obj);
        Object obj3 = "ST";
        hashtable5.put(aSN1ObjectIdentifier9, obj3);
        hashtable5.put(aSN1ObjectIdentifier7, "STREET");
        hashtable5.put(aSN1ObjectIdentifier33, "DC");
        ASN1ObjectIdentifier aSN1ObjectIdentifier44 = aSN1ObjectIdentifier40;
        hashtable5.put(aSN1ObjectIdentifier44, "UID");
        Hashtable hashtable6 = hashtable3;
        hashtable6.put(aSN1ObjectIdentifier, "C");
        hashtable6.put(aSN1ObjectIdentifier42, "O");
        hashtable6.put(aSN1ObjectIdentifier3, "OU");
        ASN1ObjectIdentifier aSN1ObjectIdentifier45 = aSN1ObjectIdentifier43;
        hashtable6.put(aSN1ObjectIdentifier45, obj2);
        hashtable6.put(aSN1ObjectIdentifier8, obj);
        hashtable6.put(aSN1ObjectIdentifier9, obj3);
        hashtable6.put(aSN1ObjectIdentifier7, "STREET");
        Hashtable hashtable7 = hashtable4;
        hashtable7.put("c", aSN1ObjectIdentifier);
        hashtable7.put("o", aSN1ObjectIdentifier42);
        hashtable7.put("t", aSN1ObjectIdentifier38);
        hashtable7.put("ou", aSN1ObjectIdentifier3);
        hashtable7.put("cn", aSN1ObjectIdentifier45);
        hashtable7.put("l", aSN1ObjectIdentifier8);
        hashtable7.put("st", aSN1ObjectIdentifier9);
        ASN1ObjectIdentifier aSN1ObjectIdentifier46 = aSN1ObjectIdentifier39;
        hashtable7.put("sn", aSN1ObjectIdentifier46);
        hashtable7.put("serialnumber", aSN1ObjectIdentifier46);
        hashtable7.put("street", aSN1ObjectIdentifier7);
        ASN1ObjectIdentifier aSN1ObjectIdentifier47 = aSN1ObjectIdentifier28;
        hashtable7.put("emailaddress", aSN1ObjectIdentifier47);
        hashtable7.put("dc", aSN1ObjectIdentifier33);
        hashtable7.put("e", aSN1ObjectIdentifier47);
        hashtable7.put("uid", aSN1ObjectIdentifier44);
        hashtable7.put("surname", aSN1ObjectIdentifier41);
        hashtable7.put("givenname", aSN1ObjectIdentifier37);
        hashtable7.put("initials", aSN1ObjectIdentifier36);
        hashtable7.put("generation", aSN1ObjectIdentifier34);
        hashtable7.put("unstructuredaddress", aSN1ObjectIdentifier32);
        hashtable7.put("unstructuredname", aSN1ObjectIdentifier31);
        hashtable7.put("uniqueidentifier", aSN1ObjectIdentifier30);
        hashtable7.put("dn", aSN1ObjectIdentifier17);
        hashtable7.put("pseudonym", aSN1ObjectIdentifier18);
        hashtable7.put("postaladdress", aSN1ObjectIdentifier25);
        hashtable7.put("nameofbirth", aSN1ObjectIdentifier24);
        hashtable7.put("countryofcitizenship", aSN1ObjectIdentifier22);
        hashtable7.put("countryofresidence", aSN1ObjectIdentifier23);
        hashtable7.put("gender", aSN1ObjectIdentifier21);
        hashtable7.put("placeofbirth", aSN1ObjectIdentifier20);
        hashtable7.put("dateofbirth", aSN1ObjectIdentifier19);
        hashtable7.put("postalcode", aSN1ObjectIdentifier16);
        hashtable7.put("businesscategory", aSN1ObjectIdentifier15);
        hashtable7.put("telephonenumber", aSN1ObjectIdentifier29);
        hashtable7.put(AppMeasurementSdk.ConditionalUserProperty.NAME, aSN1ObjectIdentifier27);
    }

    public X509Name() {
    }

    public static void g(StringBuffer stringBuffer, Hashtable hashtable, ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        int i;
        String str2 = (String) hashtable.get(aSN1ObjectIdentifier);
        if (str2 != null) {
            stringBuffer.append(str2);
        } else {
            stringBuffer.append(aSN1ObjectIdentifier.c);
        }
        stringBuffer.append('=');
        int length = stringBuffer.length();
        stringBuffer.append(str);
        int length2 = stringBuffer.length();
        if (str.length() >= 2 && str.charAt(0) == '\\' && str.charAt(1) == '#') {
            length += 2;
        }
        while (i < length2 && stringBuffer.charAt(i) == ' ') {
            stringBuffer.insert(i, "\\");
            length = i + 2;
            length2++;
        }
        while (true) {
            length2--;
            if (length2 > i && stringBuffer.charAt(length2) == ' ') {
                stringBuffer.insert(length2, '\\');
            }
        }
        while (i <= length2) {
            char charAt = stringBuffer.charAt(i);
            if (!(charAt == '\"' || charAt == '\\' || charAt == '+' || charAt == ',')) {
                switch (charAt) {
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                        break;
                    default:
                        i++;
                        continue;
                }
            }
            stringBuffer.insert(i, "\\");
            i += 2;
            length2++;
        }
    }

    public static String h(String str) {
        String e = Strings.e(str.trim());
        if (e.length() <= 0 || e.charAt(0) != '#') {
            return e;
        }
        try {
            ASN1Primitive k = ASN1Primitive.k(Hex.a(e.substring(1)));
            if (k instanceof ASN1String) {
                return Strings.e(((ASN1String) k).c().trim());
            }
            return e;
        } catch (IOException e2) {
            throw new IllegalStateException("unknown encoding in name: " + e2);
        }
    }

    public static X509Name i(Object obj) {
        if (obj == null || (obj instanceof X509Name)) {
            return (X509Name) obj;
        }
        if (obj instanceof X500Name) {
            return new X509Name(ASN1Sequence.q(((X500Name) obj).b()));
        }
        return new X509Name(ASN1Sequence.q(obj));
    }

    public static String k(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str.length() != 0) {
            char charAt = str.charAt(0);
            stringBuffer.append(charAt);
            int i = 1;
            while (i < str.length()) {
                char charAt2 = str.charAt(i);
                if (charAt != ' ' || charAt2 != ' ') {
                    stringBuffer.append(charAt2);
                }
                i++;
                charAt = charAt2;
            }
        }
        return stringBuffer.toString();
    }

    public final ASN1Primitive b() {
        if (this.f5778a == null) {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            Vector vector = this.f5777a;
            if (vector.size() == 0) {
                aSN1EncodableVector.a(new DERSet(aSN1EncodableVector2));
                this.f5778a = new DERSequence(aSN1EncodableVector);
            } else {
                new ASN1EncodableVector().a((ASN1ObjectIdentifier) vector.elementAt(0));
                String str = (String) this.f5780b.elementAt(0);
                throw null;
            }
        }
        return this.f5778a;
    }

    /* JADX WARNING: type inference failed for: r18v0, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = 1
            if (r1 != r0) goto L_0x0008
            return r2
        L_0x0008:
            boolean r3 = r1 instanceof org.spongycastle.asn1.x509.X509Name
            r4 = 0
            if (r3 != 0) goto L_0x0012
            boolean r3 = r1 instanceof org.spongycastle.asn1.ASN1Sequence
            if (r3 != 0) goto L_0x0012
            return r4
        L_0x0012:
            r3 = r1
            org.spongycastle.asn1.ASN1Encodable r3 = (org.spongycastle.asn1.ASN1Encodable) r3
            org.spongycastle.asn1.ASN1Primitive r3 = r3.b()
            org.spongycastle.asn1.ASN1Primitive r5 = r17.b()
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x0024
            return r2
        L_0x0024:
            org.spongycastle.asn1.x509.X509Name r1 = i(r18)     // Catch:{ IllegalArgumentException -> 0x00ac }
            java.util.Vector r3 = r0.f5777a
            int r5 = r3.size()
            java.util.Vector r6 = r1.f5777a
            int r6 = r6.size()
            if (r5 == r6) goto L_0x0037
            return r4
        L_0x0037:
            boolean[] r6 = new boolean[r5]
            java.lang.Object r7 = r3.elementAt(r4)
            java.util.Vector r8 = r1.f5777a
            java.lang.Object r9 = r8.elementAt(r4)
            boolean r7 = r7.equals(r9)
            if (r7 == 0) goto L_0x004d
            r10 = r2
            r7 = r4
            r9 = r5
            goto L_0x0051
        L_0x004d:
            int r7 = r5 + -1
            r9 = -1
            r10 = r9
        L_0x0051:
            if (r7 == r9) goto L_0x00ab
            java.lang.Object r11 = r3.elementAt(r7)
            org.spongycastle.asn1.ASN1ObjectIdentifier r11 = (org.spongycastle.asn1.ASN1ObjectIdentifier) r11
            java.util.Vector r12 = r0.f5780b
            java.lang.Object r12 = r12.elementAt(r7)
            java.lang.String r12 = (java.lang.String) r12
            r13 = r4
        L_0x0062:
            if (r13 >= r5) goto L_0x00a5
            boolean r14 = r6[r13]
            if (r14 == 0) goto L_0x0069
            goto L_0x00a2
        L_0x0069:
            java.lang.Object r14 = r8.elementAt(r13)
            org.spongycastle.asn1.ASN1ObjectIdentifier r14 = (org.spongycastle.asn1.ASN1ObjectIdentifier) r14
            boolean r14 = r11.equals(r14)
            if (r14 == 0) goto L_0x00a2
            java.util.Vector r14 = r1.f5780b
            java.lang.Object r14 = r14.elementAt(r13)
            java.lang.String r14 = (java.lang.String) r14
            java.lang.String r15 = h(r12)
            java.lang.String r14 = h(r14)
            boolean r16 = r15.equals(r14)
            if (r16 != 0) goto L_0x009b
            java.lang.String r15 = k(r15)
            java.lang.String r14 = k(r14)
            boolean r14 = r15.equals(r14)
            if (r14 != 0) goto L_0x009b
            r14 = r4
            goto L_0x009c
        L_0x009b:
            r14 = r2
        L_0x009c:
            if (r14 == 0) goto L_0x00a2
            r6[r13] = r2
            r11 = r2
            goto L_0x00a6
        L_0x00a2:
            int r13 = r13 + 1
            goto L_0x0062
        L_0x00a5:
            r11 = r4
        L_0x00a6:
            if (r11 != 0) goto L_0x00a9
            return r4
        L_0x00a9:
            int r7 = r7 + r10
            goto L_0x0051
        L_0x00ab:
            return r2
        L_0x00ac:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.x509.X509Name.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        if (this.f5779a) {
            return this.c;
        }
        this.f5779a = true;
        int i = 0;
        while (true) {
            Vector vector = this.f5777a;
            if (i == vector.size()) {
                return this.c;
            }
            String k = k(h((String) this.f5780b.elementAt(i)));
            int hashCode = vector.elementAt(i).hashCode() ^ this.c;
            this.c = hashCode;
            this.c = hashCode ^ k.hashCode();
            i++;
        }
    }

    public final String toString() {
        Hashtable hashtable = f5776a;
        StringBuffer stringBuffer = new StringBuffer();
        Vector vector = new Vector();
        StringBuffer stringBuffer2 = null;
        int i = 0;
        while (true) {
            Vector vector2 = this.f5777a;
            if (i >= vector2.size()) {
                break;
            }
            boolean booleanValue = ((Boolean) this.f5781c.elementAt(i)).booleanValue();
            Vector vector3 = this.f5780b;
            if (booleanValue) {
                stringBuffer2.append('+');
                g(stringBuffer2, hashtable, (ASN1ObjectIdentifier) vector2.elementAt(i), (String) vector3.elementAt(i));
            } else {
                stringBuffer2 = new StringBuffer();
                g(stringBuffer2, hashtable, (ASN1ObjectIdentifier) vector2.elementAt(i), (String) vector3.elementAt(i));
                vector.addElement(stringBuffer2);
            }
            i++;
        }
        boolean z = true;
        for (int i2 = 0; i2 < vector.size(); i2++) {
            if (z) {
                z = false;
            } else {
                stringBuffer.append(',');
            }
            stringBuffer.append(vector.elementAt(i2).toString());
        }
        return stringBuffer.toString();
    }

    public X509Name(ASN1Sequence aSN1Sequence) {
        this.f5778a = aSN1Sequence;
        Enumeration t = aSN1Sequence.t();
        while (t.hasMoreElements()) {
            ASN1Set q = ASN1Set.q(((ASN1Encodable) t.nextElement()).b());
            int i = 0;
            while (true) {
                if (i < q.size()) {
                    ASN1Sequence q2 = ASN1Sequence.q(q.s(i).b());
                    if (q2.size() == 2) {
                        this.f5777a.addElement(ASN1ObjectIdentifier.u(q2.s(0)));
                        ASN1Encodable s = q2.s(1);
                        if (!(s instanceof ASN1String) || (s instanceof DERUniversalString)) {
                            try {
                                Vector vector = this.f5780b;
                                StringBuilder sb = new StringBuilder();
                                sb.append("#");
                                byte[] c2 = Hex.c(s.b().f("DER"));
                                int length = c2.length;
                                char[] cArr = new char[length];
                                for (int i2 = 0; i2 != length; i2++) {
                                    cArr[i2] = (char) (c2[i2] & UnsignedBytes.MAX_VALUE);
                                }
                                sb.append(new String(cArr));
                                vector.addElement(sb.toString());
                            } catch (IOException unused) {
                                throw new IllegalArgumentException("cannot encode value");
                            }
                        } else {
                            String c3 = ((ASN1String) s).c();
                            if (c3.length() <= 0 || c3.charAt(0) != '#') {
                                this.f5780b.addElement(c3);
                            } else {
                                this.f5780b.addElement("\\".concat(c3));
                            }
                        }
                        this.f5781c.addElement(i != 0 ? a : b);
                        i++;
                    } else {
                        throw new IllegalArgumentException("badly sized pair");
                    }
                }
            }
        }
    }
}
