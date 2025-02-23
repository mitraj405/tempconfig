package org.spongycastle.asn1.x9;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERNull;

public class X962Parameters extends ASN1Object implements ASN1Choice {
    public final ASN1Primitive a = null;

    public X962Parameters(X9ECParameters x9ECParameters) {
        this.a = x9ECParameters.b();
    }

    public static X962Parameters g(Object obj) {
        if (obj == null || (obj instanceof X962Parameters)) {
            return (X962Parameters) obj;
        }
        if (obj instanceof ASN1Primitive) {
            return new X962Parameters((ASN1Primitive) obj);
        }
        if (obj instanceof byte[]) {
            try {
                return new X962Parameters(ASN1Primitive.k((byte[]) obj));
            } catch (Exception e) {
                throw new IllegalArgumentException(C1058d.M(e, new StringBuilder("unable to parse encoded data: ")));
            }
        } else {
            throw new IllegalArgumentException("unknown object in getInstance()");
        }
    }

    public final ASN1Primitive b() {
        return this.a;
    }

    public X962Parameters(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.a = aSN1ObjectIdentifier;
    }

    public X962Parameters(DERNull dERNull) {
        this.a = dERNull;
    }

    public X962Parameters(ASN1Primitive aSN1Primitive) {
        this.a = aSN1Primitive;
    }
}
