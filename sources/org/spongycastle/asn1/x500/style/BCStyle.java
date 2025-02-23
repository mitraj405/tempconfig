package org.spongycastle.asn1.x500.style;

import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Hashtable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x500.RDN;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;

public class BCStyle extends AbstractX500NameStyle {
    public static final ASN1ObjectIdentifier a;

    /* renamed from: a  reason: collision with other field name */
    public static final BCStyle f5722a = new BCStyle();
    public static final Hashtable b;
    public static final Hashtable c;

    /* renamed from: a  reason: collision with other field name */
    public final Hashtable f5723a = AbstractX500NameStyle.d(b);

    static {
        ASN1ObjectIdentifier p = lf.p("2.5.4.6");
        ASN1ObjectIdentifier p2 = lf.p("2.5.4.10");
        ASN1ObjectIdentifier p3 = lf.p("2.5.4.11");
        ASN1ObjectIdentifier p4 = lf.p("2.5.4.12");
        ASN1ObjectIdentifier p5 = lf.p("2.5.4.3");
        ASN1ObjectIdentifier p6 = lf.p("2.5.4.5");
        ASN1ObjectIdentifier p7 = lf.p("2.5.4.9");
        ASN1ObjectIdentifier p8 = lf.p("2.5.4.7");
        ASN1ObjectIdentifier p9 = lf.p("2.5.4.8");
        ASN1ObjectIdentifier p10 = lf.p("2.5.4.4");
        ASN1ObjectIdentifier p11 = lf.p("2.5.4.42");
        ASN1ObjectIdentifier p12 = lf.p("2.5.4.43");
        ASN1ObjectIdentifier p13 = lf.p("2.5.4.44");
        ASN1ObjectIdentifier p14 = lf.p("2.5.4.45");
        ASN1ObjectIdentifier p15 = lf.p("2.5.4.15");
        ASN1ObjectIdentifier p16 = lf.p("2.5.4.17");
        ASN1ObjectIdentifier aSN1ObjectIdentifier = p15;
        ASN1ObjectIdentifier p17 = lf.p("2.5.4.46");
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = p16;
        ASN1ObjectIdentifier p18 = lf.p("2.5.4.65");
        ASN1ObjectIdentifier p19 = lf.p("1.3.6.1.5.5.7.9.1");
        ASN1ObjectIdentifier p20 = lf.p("1.3.6.1.5.5.7.9.2");
        ASN1ObjectIdentifier p21 = lf.p("1.3.6.1.5.5.7.9.3");
        ASN1ObjectIdentifier p22 = lf.p("1.3.6.1.5.5.7.9.4");
        ASN1ObjectIdentifier p23 = lf.p("1.3.6.1.5.5.7.9.5");
        ASN1ObjectIdentifier p24 = lf.p("1.3.36.8.3.14");
        ASN1ObjectIdentifier p25 = lf.p("2.5.4.16");
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = p17;
        new ASN1ObjectIdentifier("2.5.4.54").v();
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = X509ObjectIdentifiers.g0;
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = X509ObjectIdentifiers.h0;
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = X509ObjectIdentifiers.i0;
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = PKCSObjectIdentifiers.M;
        a = aSN1ObjectIdentifier7;
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = aSN1ObjectIdentifier4;
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = p14;
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = PKCSObjectIdentifiers.N;
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = PKCSObjectIdentifiers.O;
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.25");
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = p13;
        ASN1ObjectIdentifier aSN1ObjectIdentifier14 = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.1");
        Hashtable hashtable = new Hashtable();
        b = hashtable;
        ASN1ObjectIdentifier aSN1ObjectIdentifier15 = p12;
        Hashtable hashtable2 = new Hashtable();
        c = hashtable2;
        hashtable.put(p, "C");
        hashtable.put(p2, "O");
        hashtable.put(p4, RequestConfiguration.MAX_AD_CONTENT_RATING_T);
        hashtable.put(p3, "OU");
        hashtable.put(p5, "CN");
        hashtable.put(p8, "L");
        hashtable.put(p9, "ST");
        hashtable.put(p6, "SERIALNUMBER");
        hashtable.put(aSN1ObjectIdentifier7, "E");
        hashtable.put(aSN1ObjectIdentifier12, "DC");
        hashtable.put(aSN1ObjectIdentifier14, "UID");
        hashtable.put(p7, "STREET");
        hashtable.put(p10, "SURNAME");
        hashtable.put(p11, "GIVENNAME");
        ASN1ObjectIdentifier aSN1ObjectIdentifier16 = p11;
        hashtable.put(aSN1ObjectIdentifier15, "INITIALS");
        hashtable.put(aSN1ObjectIdentifier13, "GENERATION");
        hashtable.put(aSN1ObjectIdentifier11, "unstructuredAddress");
        hashtable.put(aSN1ObjectIdentifier10, "unstructuredName");
        hashtable.put(aSN1ObjectIdentifier9, "UniqueIdentifier");
        hashtable.put(aSN1ObjectIdentifier3, "DN");
        hashtable.put(p18, "Pseudonym");
        hashtable.put(p25, "PostalAddress");
        hashtable.put(p24, "NameAtBirth");
        hashtable.put(p22, "CountryOfCitizenship");
        hashtable.put(p23, "CountryOfResidence");
        hashtable.put(p21, "Gender");
        hashtable.put(p20, "PlaceOfBirth");
        hashtable.put(p19, "DateOfBirth");
        hashtable.put(aSN1ObjectIdentifier2, "PostalCode");
        hashtable.put(aSN1ObjectIdentifier, "BusinessCategory");
        hashtable.put(aSN1ObjectIdentifier8, "TelephoneNumber");
        hashtable.put(aSN1ObjectIdentifier5, "Name");
        ASN1ObjectIdentifier aSN1ObjectIdentifier17 = aSN1ObjectIdentifier6;
        hashtable.put(aSN1ObjectIdentifier17, "organizationIdentifier");
        Hashtable hashtable3 = hashtable2;
        hashtable3.put("c", p);
        hashtable3.put("o", p2);
        hashtable3.put("t", p4);
        hashtable3.put("ou", p3);
        hashtable3.put("cn", p5);
        hashtable3.put("l", p8);
        hashtable3.put("st", p9);
        hashtable3.put("sn", p6);
        hashtable3.put("serialnumber", p6);
        hashtable3.put("street", p7);
        hashtable3.put("emailaddress", aSN1ObjectIdentifier7);
        hashtable3.put("dc", aSN1ObjectIdentifier12);
        hashtable3.put("e", aSN1ObjectIdentifier7);
        hashtable3.put("uid", aSN1ObjectIdentifier14);
        hashtable3.put("surname", p10);
        hashtable3.put("givenname", aSN1ObjectIdentifier16);
        hashtable3.put("initials", aSN1ObjectIdentifier15);
        hashtable3.put("generation", aSN1ObjectIdentifier13);
        hashtable3.put("unstructuredaddress", aSN1ObjectIdentifier11);
        hashtable3.put("unstructuredname", aSN1ObjectIdentifier10);
        hashtable3.put("uniqueidentifier", aSN1ObjectIdentifier9);
        hashtable3.put("dn", aSN1ObjectIdentifier3);
        hashtable3.put("pseudonym", p18);
        hashtable3.put("postaladdress", p25);
        hashtable3.put("nameofbirth", p24);
        hashtable3.put("countryofcitizenship", p22);
        hashtable3.put("countryofresidence", p23);
        hashtable3.put("gender", p21);
        hashtable3.put("placeofbirth", p20);
        hashtable3.put("dateofbirth", p19);
        hashtable3.put("postalcode", aSN1ObjectIdentifier2);
        hashtable3.put("businesscategory", aSN1ObjectIdentifier);
        hashtable3.put("telephonenumber", aSN1ObjectIdentifier8);
        hashtable3.put(AppMeasurementSdk.ConditionalUserProperty.NAME, aSN1ObjectIdentifier5);
        hashtable3.put("organizationidentifier", aSN1ObjectIdentifier17);
    }

    public BCStyle() {
        AbstractX500NameStyle.d(c);
    }

    public final String a(X500Name x500Name) {
        StringBuffer stringBuffer = new StringBuffer();
        RDN[] h = x500Name.h();
        boolean z = true;
        for (RDN a2 : h) {
            if (z) {
                z = false;
            } else {
                stringBuffer.append(',');
            }
            IETFUtils.a(stringBuffer, a2, this.f5723a);
        }
        return stringBuffer.toString();
    }
}
