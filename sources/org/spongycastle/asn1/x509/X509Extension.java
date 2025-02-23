package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Boolean;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;

public class X509Extension {
    public static final ASN1ObjectIdentifier a = new ASN1ObjectIdentifier("2.5.29.21");
    public static final ASN1ObjectIdentifier b = new ASN1ObjectIdentifier("2.5.29.29");

    /* renamed from: a  reason: collision with other field name */
    public final ASN1OctetString f5773a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f5774a;

    static {
        new ASN1ObjectIdentifier("2.5.29.9");
        new ASN1ObjectIdentifier("2.5.29.14");
        new ASN1ObjectIdentifier("2.5.29.15");
        new ASN1ObjectIdentifier("2.5.29.16");
        new ASN1ObjectIdentifier("2.5.29.17");
        new ASN1ObjectIdentifier("2.5.29.18");
        new ASN1ObjectIdentifier("2.5.29.19");
        new ASN1ObjectIdentifier("2.5.29.20");
        new ASN1ObjectIdentifier("2.5.29.23");
        new ASN1ObjectIdentifier("2.5.29.24");
        new ASN1ObjectIdentifier("2.5.29.27");
        new ASN1ObjectIdentifier("2.5.29.28");
        new ASN1ObjectIdentifier("2.5.29.30");
        new ASN1ObjectIdentifier("2.5.29.31");
        new ASN1ObjectIdentifier("2.5.29.32");
        new ASN1ObjectIdentifier("2.5.29.33");
        new ASN1ObjectIdentifier("2.5.29.35");
        new ASN1ObjectIdentifier("2.5.29.36");
        new ASN1ObjectIdentifier("2.5.29.37");
        new ASN1ObjectIdentifier("2.5.29.46");
        new ASN1ObjectIdentifier("2.5.29.54");
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.1");
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.11");
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.12");
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.2");
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.3");
        new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.4");
        new ASN1ObjectIdentifier("2.5.29.56");
        new ASN1ObjectIdentifier("2.5.29.55");
    }

    public X509Extension(ASN1Boolean aSN1Boolean, ASN1OctetString aSN1OctetString) {
        this.f5774a = aSN1Boolean.t();
        this.f5773a = aSN1OctetString;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof X509Extension)) {
            return false;
        }
        X509Extension x509Extension = (X509Extension) obj;
        if (!x509Extension.f5773a.equals(this.f5773a) || x509Extension.f5774a != this.f5774a) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        ASN1OctetString aSN1OctetString = this.f5773a;
        if (this.f5774a) {
            return aSN1OctetString.hashCode();
        }
        return ~aSN1OctetString.hashCode();
    }

    public X509Extension(ASN1OctetString aSN1OctetString) {
        this.f5774a = false;
        this.f5773a = aSN1OctetString;
    }
}
