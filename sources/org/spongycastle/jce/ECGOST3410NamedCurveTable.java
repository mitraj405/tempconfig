package org.spongycastle.jce;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.jce.spec.ECNamedCurveParameterSpec;

public class ECGOST3410NamedCurveTable {
    public static ECNamedCurveParameterSpec a(String str) {
        ECDomainParameters a = ECGOST3410NamedCurves.a(str);
        if (a == null) {
            try {
                a = (ECDomainParameters) ECGOST3410NamedCurves.b.get(new ASN1ObjectIdentifier(str));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        if (a == null) {
            return null;
        }
        return new ECNamedCurveParameterSpec(str, a.a, a.f6230a, a.g, a.h, a.a());
    }
}
