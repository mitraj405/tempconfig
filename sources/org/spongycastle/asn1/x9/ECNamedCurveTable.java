package org.spongycastle.asn1.x9;

import java.util.Enumeration;
import java.util.Vector;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.anssi.ANSSINamedCurves;
import org.spongycastle.asn1.gm.GMNamedCurves;
import org.spongycastle.asn1.nist.NISTNamedCurves;
import org.spongycastle.asn1.sec.SECNamedCurves;
import org.spongycastle.asn1.teletrust.TeleTrusTNamedCurves;
import org.spongycastle.util.Strings;

public class ECNamedCurveTable {
    public static void a(Vector vector, Enumeration enumeration) {
        while (enumeration.hasMoreElements()) {
            vector.addElement(enumeration.nextElement());
        }
    }

    public static X9ECParameters b(String str) {
        X9ECParameters x9ECParameters;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) X962NamedCurves.a.get(Strings.e(str));
        X9ECParameters x9ECParameters2 = null;
        if (aSN1ObjectIdentifier != null) {
            x9ECParameters = X962NamedCurves.b(aSN1ObjectIdentifier);
        } else {
            x9ECParameters = null;
        }
        if (x9ECParameters == null) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = (ASN1ObjectIdentifier) SECNamedCurves.a.get(Strings.e(str));
            if (aSN1ObjectIdentifier2 == null) {
                x9ECParameters = null;
            } else {
                x9ECParameters = SECNamedCurves.d(aSN1ObjectIdentifier2);
            }
        }
        if (x9ECParameters == null) {
            x9ECParameters = NISTNamedCurves.b(str);
        }
        if (x9ECParameters == null) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = (ASN1ObjectIdentifier) TeleTrusTNamedCurves.a.get(Strings.e(str));
            if (aSN1ObjectIdentifier3 != null) {
                x9ECParameters = TeleTrusTNamedCurves.b(aSN1ObjectIdentifier3);
            } else {
                x9ECParameters = null;
            }
        }
        if (x9ECParameters == null) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = (ASN1ObjectIdentifier) ANSSINamedCurves.a.get(Strings.e(str));
            if (aSN1ObjectIdentifier4 == null) {
                x9ECParameters = null;
            } else {
                x9ECParameters = ANSSINamedCurves.a(aSN1ObjectIdentifier4);
            }
        }
        if (x9ECParameters != null) {
            return x9ECParameters;
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = (ASN1ObjectIdentifier) GMNamedCurves.a.get(Strings.e(str));
        if (aSN1ObjectIdentifier5 != null) {
            x9ECParameters2 = GMNamedCurves.b(aSN1ObjectIdentifier5);
        }
        return x9ECParameters2;
    }

    public static X9ECParameters c(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        X9ECParameters b = X962NamedCurves.b(aSN1ObjectIdentifier);
        if (b == null) {
            b = SECNamedCurves.d(aSN1ObjectIdentifier);
        }
        if (b == null) {
            b = TeleTrusTNamedCurves.b(aSN1ObjectIdentifier);
        }
        if (b == null) {
            b = ANSSINamedCurves.a(aSN1ObjectIdentifier);
        }
        if (b == null) {
            return GMNamedCurves.b(aSN1ObjectIdentifier);
        }
        return b;
    }
}
