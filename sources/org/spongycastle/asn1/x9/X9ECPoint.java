package org.spongycastle.asn1.x9;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.Arrays;

public class X9ECPoint extends ASN1Object {
    public final DEROctetString a;

    /* renamed from: a  reason: collision with other field name */
    public final ECCurve f5789a;

    /* renamed from: a  reason: collision with other field name */
    public ECPoint f5790a;

    public X9ECPoint() {
        throw null;
    }

    public X9ECPoint(ECPoint eCPoint) {
        this.f5790a = eCPoint.o();
        this.a = new DEROctetString(eCPoint.h(false));
    }

    public final ASN1Primitive b() {
        return this.a;
    }

    public final synchronized ECPoint g() {
        if (this.f5790a == null) {
            this.f5790a = this.f5789a.g(this.a.a).o();
        }
        return this.f5790a;
    }

    public X9ECPoint(ECCurve eCCurve, byte[] bArr) {
        this.f5789a = eCCurve;
        this.a = new DEROctetString(Arrays.c(bArr));
    }

    public X9ECPoint(ECCurve eCCurve, ASN1OctetString aSN1OctetString) {
        this(eCCurve, aSN1OctetString.s());
    }
}
