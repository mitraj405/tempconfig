package org.spongycastle.asn1;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;

public class ASN1GeneralizedTime extends ASN1Primitive {
    public final byte[] a;

    public ASN1GeneralizedTime(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss'Z'");
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        this.a = Strings.d(simpleDateFormat.format(date));
    }

    public static ASN1GeneralizedTime r(ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable == null || (aSN1Encodable instanceof ASN1GeneralizedTime)) {
            return (ASN1GeneralizedTime) aSN1Encodable;
        }
        if (aSN1Encodable instanceof byte[]) {
            try {
                return (ASN1GeneralizedTime) ASN1Primitive.k((byte[]) aSN1Encodable);
            } catch (Exception e) {
                throw new IllegalArgumentException(C1058d.x(e, new StringBuilder("encoding error in getInstance: ")));
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: ".concat(aSN1Encodable.getClass().getName()));
        }
    }

    public final boolean g(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1GeneralizedTime)) {
            return false;
        }
        return Arrays.a(this.a, ((ASN1GeneralizedTime) aSN1Primitive).a);
    }

    public final void h(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.d(24, this.a);
    }

    public final int hashCode() {
        return Arrays.t(this.a);
    }

    public final int i() {
        int length = this.a.length;
        return StreamUtil.a(length) + 1 + length;
    }

    public final boolean n() {
        return false;
    }

    public final Date q() throws ParseException {
        SimpleDateFormat simpleDateFormat;
        SimpleDateFormat simpleDateFormat2;
        SimpleDateFormat simpleDateFormat3;
        String a2 = Strings.a(this.a);
        if (a2.endsWith("Z")) {
            if (t()) {
                simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss.SSS'Z'");
            } else {
                simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss'Z'");
            }
            simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        } else if (a2.indexOf(45) > 0 || a2.indexOf(43) > 0) {
            a2 = s();
            if (t()) {
                simpleDateFormat2 = new SimpleDateFormat("yyyyMMddHHmmss.SSSz");
            } else {
                simpleDateFormat2 = new SimpleDateFormat("yyyyMMddHHmmssz");
            }
            simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "Z"));
        } else {
            if (t()) {
                simpleDateFormat3 = new SimpleDateFormat("yyyyMMddHHmmss.SSS");
            } else {
                simpleDateFormat3 = new SimpleDateFormat("yyyyMMddHHmmss");
            }
            simpleDateFormat = simpleDateFormat3;
            simpleDateFormat.setTimeZone(new SimpleTimeZone(0, TimeZone.getDefault().getID()));
        }
        if (t()) {
            String substring = a2.substring(14);
            int i = 1;
            while (i < substring.length() && '0' <= (r7 = substring.charAt(i)) && r7 <= '9') {
                i++;
            }
            int i2 = i - 1;
            if (i2 > 3) {
                a2 = a2.substring(0, 14) + (substring.substring(0, 4) + substring.substring(i));
            } else if (i2 == 1) {
                a2 = a2.substring(0, 14) + (substring.substring(0, i) + "00" + substring.substring(i));
            } else if (i2 == 2) {
                a2 = a2.substring(0, 14) + (substring.substring(0, i) + "0" + substring.substring(i));
            }
        }
        return simpleDateFormat.parse(a2);
    }

    public final String s() {
        String str;
        String str2;
        String str3;
        String a2 = Strings.a(this.a);
        int i = 1;
        if (a2.charAt(a2.length() - 1) == 'Z') {
            return a2.substring(0, a2.length() - 1) + "GMT+00:00";
        }
        int length = a2.length() - 5;
        char charAt = a2.charAt(length);
        if (charAt == '-' || charAt == '+') {
            StringBuilder sb = new StringBuilder();
            sb.append(a2.substring(0, length));
            sb.append("GMT");
            int i2 = length + 3;
            sb.append(a2.substring(length, i2));
            sb.append(":");
            sb.append(a2.substring(i2));
            return sb.toString();
        }
        int length2 = a2.length() - 3;
        char charAt2 = a2.charAt(length2);
        if (charAt2 == '-' || charAt2 == '+') {
            return a2.substring(0, length2) + "GMT" + a2.substring(length2) + ":00";
        }
        StringBuilder J = xx.J(a2);
        TimeZone timeZone = TimeZone.getDefault();
        int rawOffset = timeZone.getRawOffset();
        if (rawOffset < 0) {
            rawOffset = -rawOffset;
            str = "-";
        } else {
            str = "+";
        }
        int i3 = rawOffset / 3600000;
        int i4 = (rawOffset - (((i3 * 60) * 60) * 1000)) / 60000;
        try {
            if (timeZone.useDaylightTime() && timeZone.inDaylightTime(q())) {
                if (!str.equals("+")) {
                    i = -1;
                }
                i3 += i;
            }
        } catch (ParseException unused) {
        }
        StringBuilder sb2 = new StringBuilder("GMT");
        sb2.append(str);
        if (i3 < 10) {
            str2 = lf.h("0", i3);
        } else {
            str2 = Integer.toString(i3);
        }
        sb2.append(str2);
        sb2.append(":");
        if (i4 < 10) {
            str3 = lf.h("0", i4);
        } else {
            str3 = Integer.toString(i4);
        }
        sb2.append(str3);
        J.append(sb2.toString());
        return J.toString();
    }

    public final boolean t() {
        int i = 0;
        while (true) {
            byte[] bArr = this.a;
            if (i == bArr.length) {
                return false;
            }
            if (bArr[i] == 46 && i == 14) {
                return true;
            }
            i++;
        }
    }

    public ASN1GeneralizedTime(byte[] bArr) {
        this.a = bArr;
    }
}
