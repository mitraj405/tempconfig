package org.spongycastle.asn1.x500.style;

import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.util.Hashtable;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1String;
import org.spongycastle.asn1.DERUniversalString;
import org.spongycastle.asn1.x500.AttributeTypeAndValue;
import org.spongycastle.asn1.x500.RDN;
import org.spongycastle.util.Strings;
import org.spongycastle.util.encoders.Hex;

public class IETFUtils {
    public static void a(StringBuffer stringBuffer, RDN rdn, Hashtable hashtable) {
        if (rdn.i()) {
            AttributeTypeAndValue[] h = rdn.h();
            boolean z = true;
            for (int i = 0; i != h.length; i++) {
                if (z) {
                    z = false;
                } else {
                    stringBuffer.append('+');
                }
                b(stringBuffer, h[i], hashtable);
            }
        } else if (rdn.g() != null) {
            b(stringBuffer, rdn.g(), hashtable);
        }
    }

    public static void b(StringBuffer stringBuffer, AttributeTypeAndValue attributeTypeAndValue, Hashtable hashtable) {
        String str = (String) hashtable.get(attributeTypeAndValue.Z0);
        if (str != null) {
            stringBuffer.append(str);
        } else {
            stringBuffer.append(attributeTypeAndValue.Z0.c);
        }
        stringBuffer.append('=');
        stringBuffer.append(e(attributeTypeAndValue.a));
    }

    public static boolean c(AttributeTypeAndValue attributeTypeAndValue, AttributeTypeAndValue attributeTypeAndValue2) {
        if (attributeTypeAndValue == attributeTypeAndValue2) {
            return true;
        }
        if (attributeTypeAndValue != null && attributeTypeAndValue2 != null && attributeTypeAndValue.Z0.equals(attributeTypeAndValue2.Z0) && d(e(attributeTypeAndValue.a)).equals(d(e(attributeTypeAndValue2.a)))) {
            return true;
        }
        return false;
    }

    public static String d(String str) {
        String e = Strings.e(str);
        int i = 1;
        if (e.length() > 0 && e.charAt(0) == '#') {
            try {
                ASN1Primitive k = ASN1Primitive.k(Hex.a(e.substring(1)));
                if (k instanceof ASN1String) {
                    e = Strings.e(((ASN1String) k).c());
                }
            } catch (IOException e2) {
                throw new IllegalStateException("unknown encoding in name: " + e2);
            }
        }
        if (e.length() > 1) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i3 < e.length() && e.charAt(i2) == '\\' && e.charAt(i3) == ' ') {
                    i2 += 2;
                } else {
                    int length = e.length() - 1;
                }
            }
            int length2 = e.length() - 1;
            while (true) {
                int i4 = length2 - 1;
                if (i4 > 0 && e.charAt(i4) == '\\' && e.charAt(length2) == ' ') {
                    length2 -= 2;
                } else if (i2 > 0 || length2 < e.length() - 1) {
                    e = e.substring(i2, length2 + 1);
                }
            }
            e = e.substring(i2, length2 + 1);
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (e.length() != 0) {
            char charAt = e.charAt(0);
            stringBuffer.append(charAt);
            while (i < e.length()) {
                char charAt2 = e.charAt(i);
                if (charAt != ' ' || charAt2 != ' ') {
                    stringBuffer.append(charAt2);
                }
                i++;
                charAt = charAt2;
            }
        }
        return stringBuffer.toString();
    }

    public static String e(ASN1Encodable aSN1Encodable) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        if (!(aSN1Encodable instanceof ASN1String) || (aSN1Encodable instanceof DERUniversalString)) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("#");
                byte[] c = Hex.c(aSN1Encodable.b().f("DER"));
                int length = c.length;
                char[] cArr = new char[length];
                for (int i2 = 0; i2 != length; i2++) {
                    cArr[i2] = (char) (c[i2] & UnsignedBytes.MAX_VALUE);
                }
                sb.append(new String(cArr));
                stringBuffer.append(sb.toString());
            } catch (IOException unused) {
                throw new IllegalArgumentException("Other value has no encoded form");
            }
        } else {
            String c2 = ((ASN1String) aSN1Encodable).c();
            if (c2.length() <= 0 || c2.charAt(0) != '#') {
                stringBuffer.append(c2);
            } else {
                stringBuffer.append("\\".concat(c2));
            }
        }
        int length2 = stringBuffer.length();
        int i3 = 2;
        if (!(stringBuffer.length() >= 2 && stringBuffer.charAt(0) == '\\' && stringBuffer.charAt(1) == '#')) {
            i3 = 0;
        }
        while (i3 != length2) {
            if (stringBuffer.charAt(i3) == ',' || stringBuffer.charAt(i3) == '\"' || stringBuffer.charAt(i3) == '\\' || stringBuffer.charAt(i3) == '+' || stringBuffer.charAt(i3) == '=' || stringBuffer.charAt(i3) == '<' || stringBuffer.charAt(i3) == '>' || stringBuffer.charAt(i3) == ';') {
                stringBuffer.insert(i3, "\\");
                i3++;
                length2++;
            }
            i3++;
        }
        if (stringBuffer.length() > 0) {
            while (stringBuffer.length() > i && stringBuffer.charAt(i) == ' ') {
                stringBuffer.insert(i, "\\");
                i += 2;
            }
        }
        int length3 = stringBuffer.length() - 1;
        while (length3 >= 0 && stringBuffer.charAt(length3) == ' ') {
            stringBuffer.insert(length3, '\\');
            length3--;
        }
        return stringBuffer.toString();
    }
}
