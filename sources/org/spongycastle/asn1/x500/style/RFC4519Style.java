package org.spongycastle.asn1.x500.style;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Hashtable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.x500.RDN;
import org.spongycastle.asn1.x500.X500Name;

public class RFC4519Style extends AbstractX500NameStyle {
    public static final RFC4519Style a = new RFC4519Style();
    public static final Hashtable b;
    public static final Hashtable c;

    /* renamed from: a  reason: collision with other field name */
    public final Hashtable f5724a = AbstractX500NameStyle.d(b);

    static {
        ASN1ObjectIdentifier p = lf.p("2.5.4.15");
        ASN1ObjectIdentifier p2 = lf.p("2.5.4.6");
        ASN1ObjectIdentifier p3 = lf.p("2.5.4.3");
        ASN1ObjectIdentifier p4 = lf.p("0.9.2342.19200300.100.1.25");
        ASN1ObjectIdentifier p5 = lf.p("2.5.4.13");
        ASN1ObjectIdentifier p6 = lf.p("2.5.4.27");
        ASN1ObjectIdentifier p7 = lf.p("2.5.4.49");
        ASN1ObjectIdentifier p8 = lf.p("2.5.4.46");
        ASN1ObjectIdentifier p9 = lf.p("2.5.4.47");
        ASN1ObjectIdentifier p10 = lf.p("2.5.4.23");
        ASN1ObjectIdentifier p11 = lf.p("2.5.4.44");
        ASN1ObjectIdentifier p12 = lf.p("2.5.4.42");
        ASN1ObjectIdentifier p13 = lf.p("2.5.4.51");
        ASN1ObjectIdentifier p14 = lf.p("2.5.4.43");
        ASN1ObjectIdentifier p15 = lf.p("2.5.4.25");
        ASN1ObjectIdentifier p16 = lf.p("2.5.4.7");
        ASN1ObjectIdentifier p17 = lf.p("2.5.4.31");
        ASN1ObjectIdentifier p18 = lf.p("2.5.4.41");
        ASN1ObjectIdentifier p19 = lf.p("2.5.4.10");
        ASN1ObjectIdentifier p20 = lf.p("2.5.4.11");
        ASN1ObjectIdentifier p21 = lf.p("2.5.4.32");
        ASN1ObjectIdentifier p22 = lf.p("2.5.4.19");
        ASN1ObjectIdentifier p23 = lf.p("2.5.4.16");
        ASN1ObjectIdentifier p24 = lf.p("2.5.4.17");
        ASN1ObjectIdentifier p25 = lf.p("2.5.4.18");
        ASN1ObjectIdentifier p26 = lf.p("2.5.4.28");
        ASN1ObjectIdentifier p27 = lf.p("2.5.4.26");
        ASN1ObjectIdentifier p28 = lf.p("2.5.4.33");
        ASN1ObjectIdentifier p29 = lf.p("2.5.4.14");
        ASN1ObjectIdentifier p30 = lf.p("2.5.4.34");
        ASN1ObjectIdentifier p31 = lf.p("2.5.4.5");
        ASN1ObjectIdentifier p32 = lf.p("2.5.4.4");
        ASN1ObjectIdentifier p33 = lf.p("2.5.4.8");
        ASN1ObjectIdentifier p34 = lf.p("2.5.4.9");
        ASN1ObjectIdentifier p35 = lf.p("2.5.4.20");
        ASN1ObjectIdentifier p36 = lf.p("2.5.4.22");
        ASN1ObjectIdentifier p37 = lf.p("2.5.4.21");
        ASN1ObjectIdentifier p38 = lf.p("2.5.4.12");
        ASN1ObjectIdentifier p39 = lf.p("0.9.2342.19200300.100.1.1");
        ASN1ObjectIdentifier p40 = lf.p("2.5.4.50");
        ASN1ObjectIdentifier p41 = lf.p("2.5.4.35");
        ASN1ObjectIdentifier p42 = lf.p("2.5.4.24");
        ASN1ObjectIdentifier p43 = lf.p("2.5.4.45");
        Hashtable hashtable = new Hashtable();
        b = hashtable;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = p15;
        Hashtable hashtable2 = new Hashtable();
        c = hashtable2;
        hashtable.put(p, "businessCategory");
        hashtable.put(p2, "c");
        hashtable.put(p3, "cn");
        hashtable.put(p4, "dc");
        hashtable.put(p5, "description");
        hashtable.put(p6, "destinationIndicator");
        hashtable.put(p7, "distinguishedName");
        hashtable.put(p8, "dnQualifier");
        hashtable.put(p9, "enhancedSearchGuide");
        hashtable.put(p10, "facsimileTelephoneNumber");
        hashtable.put(p11, "generationQualifier");
        hashtable.put(p12, "givenName");
        hashtable.put(p13, "houseIdentifier");
        hashtable.put(p14, "initials");
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = p14;
        hashtable.put(aSN1ObjectIdentifier, "internationalISDNNumber");
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = p16;
        hashtable.put(aSN1ObjectIdentifier3, "l");
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = aSN1ObjectIdentifier3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = p17;
        hashtable.put(aSN1ObjectIdentifier5, "member");
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = aSN1ObjectIdentifier5;
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = p18;
        hashtable.put(aSN1ObjectIdentifier7, AppMeasurementSdk.ConditionalUserProperty.NAME);
        Object obj = AppMeasurementSdk.ConditionalUserProperty.NAME;
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = aSN1ObjectIdentifier7;
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = p19;
        hashtable.put(aSN1ObjectIdentifier9, "o");
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = aSN1ObjectIdentifier9;
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = p20;
        hashtable.put(aSN1ObjectIdentifier11, "ou");
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = aSN1ObjectIdentifier11;
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = p21;
        hashtable.put(aSN1ObjectIdentifier13, "owner");
        ASN1ObjectIdentifier aSN1ObjectIdentifier14 = aSN1ObjectIdentifier13;
        hashtable.put(p22, "physicalDeliveryOfficeName");
        hashtable.put(p23, "postalAddress");
        hashtable.put(p24, "postalCode");
        hashtable.put(p25, "postOfficeBox");
        hashtable.put(p26, "preferredDeliveryMethod");
        hashtable.put(p27, "registeredAddress");
        hashtable.put(p28, "roleOccupant");
        hashtable.put(p29, "searchGuide");
        hashtable.put(p30, "seeAlso");
        hashtable.put(p31, "serialNumber");
        ASN1ObjectIdentifier aSN1ObjectIdentifier15 = p32;
        hashtable.put(aSN1ObjectIdentifier15, "sn");
        ASN1ObjectIdentifier aSN1ObjectIdentifier16 = aSN1ObjectIdentifier15;
        ASN1ObjectIdentifier aSN1ObjectIdentifier17 = p33;
        hashtable.put(aSN1ObjectIdentifier17, "st");
        ASN1ObjectIdentifier aSN1ObjectIdentifier18 = aSN1ObjectIdentifier17;
        ASN1ObjectIdentifier aSN1ObjectIdentifier19 = p34;
        hashtable.put(aSN1ObjectIdentifier19, "street");
        ASN1ObjectIdentifier aSN1ObjectIdentifier20 = aSN1ObjectIdentifier19;
        hashtable.put(p35, "telephoneNumber");
        hashtable.put(p36, "teletexTerminalIdentifier");
        hashtable.put(p37, "telexNumber");
        ASN1ObjectIdentifier aSN1ObjectIdentifier21 = p38;
        hashtable.put(aSN1ObjectIdentifier21, "title");
        ASN1ObjectIdentifier aSN1ObjectIdentifier22 = aSN1ObjectIdentifier21;
        ASN1ObjectIdentifier aSN1ObjectIdentifier23 = p39;
        hashtable.put(aSN1ObjectIdentifier23, "uid");
        ASN1ObjectIdentifier aSN1ObjectIdentifier24 = aSN1ObjectIdentifier23;
        hashtable.put(p40, "uniqueMember");
        hashtable.put(p41, "userPassword");
        hashtable.put(p42, "x121Address");
        ASN1ObjectIdentifier aSN1ObjectIdentifier25 = p43;
        hashtable.put(aSN1ObjectIdentifier25, "x500UniqueIdentifier");
        Hashtable hashtable3 = hashtable2;
        hashtable3.put("businesscategory", p);
        hashtable3.put("c", p2);
        hashtable3.put("cn", p3);
        hashtable3.put("dc", p4);
        hashtable3.put("description", p5);
        hashtable3.put("destinationindicator", p6);
        hashtable3.put("distinguishedname", p7);
        hashtable3.put("dnqualifier", p8);
        hashtable3.put("enhancedsearchguide", p9);
        hashtable3.put("facsimiletelephonenumber", p10);
        hashtable3.put("generationqualifier", p11);
        hashtable3.put("givenname", p12);
        hashtable3.put("houseidentifier", p13);
        hashtable3.put("initials", aSN1ObjectIdentifier2);
        hashtable3.put("internationalisdnnumber", aSN1ObjectIdentifier);
        hashtable3.put("l", aSN1ObjectIdentifier4);
        hashtable3.put("member", aSN1ObjectIdentifier6);
        hashtable3.put(obj, aSN1ObjectIdentifier8);
        hashtable3.put("o", aSN1ObjectIdentifier10);
        hashtable3.put("ou", aSN1ObjectIdentifier12);
        hashtable3.put("owner", aSN1ObjectIdentifier14);
        hashtable3.put("physicaldeliveryofficename", p22);
        hashtable3.put("postaladdress", p23);
        hashtable3.put("postalcode", p24);
        hashtable3.put("postofficebox", p25);
        hashtable3.put("preferreddeliverymethod", p26);
        hashtable3.put("registeredaddress", p27);
        hashtable3.put("roleoccupant", p28);
        hashtable3.put("searchguide", p29);
        hashtable3.put("seealso", p30);
        hashtable3.put("serialnumber", p31);
        hashtable3.put("sn", aSN1ObjectIdentifier16);
        hashtable3.put("st", aSN1ObjectIdentifier18);
        hashtable3.put("street", aSN1ObjectIdentifier20);
        hashtable3.put("telephonenumber", p35);
        hashtable3.put("teletexterminalidentifier", p36);
        hashtable3.put("telexnumber", p37);
        hashtable3.put("title", aSN1ObjectIdentifier22);
        hashtable3.put("uid", aSN1ObjectIdentifier24);
        hashtable3.put("uniquemember", p40);
        hashtable3.put("userpassword", p41);
        hashtable3.put("x121address", p42);
        hashtable3.put("x500uniqueidentifier", aSN1ObjectIdentifier25);
    }

    public RFC4519Style() {
        AbstractX500NameStyle.d(c);
    }

    public final String a(X500Name x500Name) {
        StringBuffer stringBuffer = new StringBuffer();
        RDN[] h = x500Name.h();
        boolean z = true;
        for (int length = h.length - 1; length >= 0; length--) {
            if (z) {
                z = false;
            } else {
                stringBuffer.append(',');
            }
            IETFUtils.a(stringBuffer, h[length], this.f5724a);
        }
        return stringBuffer.toString();
    }
}
