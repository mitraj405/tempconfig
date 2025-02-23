package org.spongycastle.jce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.cryptopro.GOST3410NamedParameters;
import org.spongycastle.asn1.cryptopro.GOST3410ParamSetParameters;
import org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.spongycastle.jce.interfaces.GOST3410Params;

public class GOST3410ParameterSpec implements AlgorithmParameterSpec, GOST3410Params {
    public final String a;

    /* renamed from: a  reason: collision with other field name */
    public final GOST3410PublicKeyParameterSetSpec f6605a;
    public final String b;
    public final String c;

    public GOST3410ParameterSpec(String str, String str2, String str3) {
        GOST3410ParamSetParameters gOST3410ParamSetParameters;
        try {
            gOST3410ParamSetParameters = (GOST3410ParamSetParameters) GOST3410NamedParameters.b.get(new ASN1ObjectIdentifier(str));
        } catch (IllegalArgumentException unused) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) GOST3410NamedParameters.a.get(str);
            if (aSN1ObjectIdentifier != null) {
                String str4 = aSN1ObjectIdentifier.c;
                gOST3410ParamSetParameters = (GOST3410ParamSetParameters) GOST3410NamedParameters.b.get(aSN1ObjectIdentifier);
                str = str4;
            } else {
                gOST3410ParamSetParameters = null;
            }
        }
        if (gOST3410ParamSetParameters != null) {
            this.f6605a = new GOST3410PublicKeyParameterSetSpec(gOST3410ParamSetParameters.a.s(), gOST3410ParamSetParameters.b.s(), gOST3410ParamSetParameters.f5686c.s());
            this.a = str;
            this.b = str2;
            this.c = str3;
            return;
        }
        throw new IllegalArgumentException("no key parameter set for passed in name/OID.");
    }

    public static GOST3410ParameterSpec e(GOST3410PublicKeyAlgParameters gOST3410PublicKeyAlgParameters) {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = gOST3410PublicKeyAlgParameters.b1;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = gOST3410PublicKeyAlgParameters.a1;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = gOST3410PublicKeyAlgParameters.Z0;
        if (aSN1ObjectIdentifier != null) {
            return new GOST3410ParameterSpec(aSN1ObjectIdentifier3.c, aSN1ObjectIdentifier2.c, aSN1ObjectIdentifier.c);
        }
        return new GOST3410ParameterSpec(aSN1ObjectIdentifier3.c, aSN1ObjectIdentifier2.c, (String) null);
    }

    public final GOST3410PublicKeyParameterSetSpec a() {
        return this.f6605a;
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.b;
    }

    public final String d() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof GOST3410ParameterSpec)) {
            return false;
        }
        GOST3410ParameterSpec gOST3410ParameterSpec = (GOST3410ParameterSpec) obj;
        if (!this.f6605a.equals(gOST3410ParameterSpec.f6605a) || !this.b.equals(gOST3410ParameterSpec.b)) {
            return false;
        }
        String str = this.c;
        String str2 = gOST3410ParameterSpec.c;
        if (str == str2 || (str != null && str.equals(str2))) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int hashCode = this.f6605a.hashCode() ^ this.b.hashCode();
        String str = this.c;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        return hashCode ^ i;
    }

    public GOST3410ParameterSpec(GOST3410PublicKeyParameterSetSpec gOST3410PublicKeyParameterSetSpec) {
        this.f6605a = gOST3410PublicKeyParameterSetSpec;
        this.b = CryptoProObjectIdentifiers.o.c;
        this.c = null;
    }
}
