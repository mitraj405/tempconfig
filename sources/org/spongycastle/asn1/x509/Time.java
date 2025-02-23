package org.spongycastle.asn1.x509;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1UTCTime;

public class Time extends ASN1Object implements ASN1Choice {
    public final ASN1Primitive a;

    public Time(ASN1Primitive aSN1Primitive) {
        if ((aSN1Primitive instanceof ASN1UTCTime) || (aSN1Primitive instanceof ASN1GeneralizedTime)) {
            this.a = aSN1Primitive;
            return;
        }
        throw new IllegalArgumentException("unknown object passed to Time");
    }

    public static Time h(ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable == null || (aSN1Encodable instanceof Time)) {
            return (Time) aSN1Encodable;
        }
        if (aSN1Encodable instanceof ASN1UTCTime) {
            return new Time((ASN1UTCTime) aSN1Encodable);
        }
        if (aSN1Encodable instanceof ASN1GeneralizedTime) {
            return new Time((ASN1GeneralizedTime) aSN1Encodable);
        }
        throw new IllegalArgumentException("unknown object in factory: ".concat(aSN1Encodable.getClass().getName()));
    }

    public final ASN1Primitive b() {
        return this.a;
    }

    public final Date g() {
        String str;
        try {
            ASN1Primitive aSN1Primitive = this.a;
            if (!(aSN1Primitive instanceof ASN1UTCTime)) {
                return ((ASN1GeneralizedTime) aSN1Primitive).q();
            }
            ASN1UTCTime aSN1UTCTime = (ASN1UTCTime) aSN1Primitive;
            aSN1UTCTime.getClass();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssz");
            simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
            String q = aSN1UTCTime.q();
            if (q.charAt(0) < '5') {
                str = "20".concat(q);
            } else {
                str = "19".concat(q);
            }
            return simpleDateFormat.parse(str);
        } catch (ParseException e) {
            throw new IllegalStateException("invalid date string: " + e.getMessage());
        }
    }

    public final String i() {
        ASN1Primitive aSN1Primitive = this.a;
        if (!(aSN1Primitive instanceof ASN1UTCTime)) {
            return ((ASN1GeneralizedTime) aSN1Primitive).s();
        }
        String q = ((ASN1UTCTime) aSN1Primitive).q();
        if (q.charAt(0) < '5') {
            return "20".concat(q);
        }
        return "19".concat(q);
    }

    public final String toString() {
        return i();
    }
}
