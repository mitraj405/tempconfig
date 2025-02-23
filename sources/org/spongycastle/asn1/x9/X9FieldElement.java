package org.spongycastle.asn1.x9;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.math.ec.ECFieldElement;

public class X9FieldElement extends ASN1Object {
    public static final X9IntegerConverter a = new X9IntegerConverter();

    /* renamed from: a  reason: collision with other field name */
    public final ECFieldElement f5791a;

    public X9FieldElement(ECFieldElement eCFieldElement) {
        this.f5791a = eCFieldElement;
    }

    public final ASN1Primitive b() {
        a.getClass();
        ECFieldElement eCFieldElement = this.f5791a;
        return new DEROctetString(X9IntegerConverter.a((eCFieldElement.f() + 7) / 8, eCFieldElement.t()));
    }

    public X9FieldElement(BigInteger bigInteger, ASN1OctetString aSN1OctetString) {
        this(new ECFieldElement.Fp(bigInteger, ECFieldElement.Fp.u(bigInteger), new BigInteger(1, aSN1OctetString.s())));
    }

    public X9FieldElement(int i, int i2, int i3, int i4, ASN1OctetString aSN1OctetString) {
        this(new ECFieldElement.F2m(i, i2, i3, i4, new BigInteger(1, aSN1OctetString.s())));
    }
}
