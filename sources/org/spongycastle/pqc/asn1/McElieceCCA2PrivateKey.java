package org.spongycastle.pqc.asn1;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.pqc.math.linearalgebra.GF2mField;
import org.spongycastle.pqc.math.linearalgebra.Permutation;
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

public class McElieceCCA2PrivateKey extends ASN1Object {
    public final AlgorithmIdentifier a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6642a;
    public final byte[] b;
    public final int c;

    /* renamed from: c  reason: collision with other field name */
    public final byte[] f6643c;
    public final int d;

    public McElieceCCA2PrivateKey(int i, int i2, GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM, Permutation permutation, AlgorithmIdentifier algorithmIdentifier) {
        this.c = i;
        this.d = i2;
        int i3 = gF2mField.b;
        this.f6642a = new byte[]{(byte) i3, (byte) (i3 >>> 8), (byte) (i3 >>> 16), (byte) (i3 >>> 24)};
        this.b = polynomialGF2mSmallM.f();
        this.f6643c = permutation.a();
        this.a = algorithmIdentifier;
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(new ASN1Integer((long) this.c));
        aSN1EncodableVector.a(new ASN1Integer((long) this.d));
        aSN1EncodableVector.a(new DEROctetString(this.f6642a));
        aSN1EncodableVector.a(new DEROctetString(this.b));
        aSN1EncodableVector.a(new DEROctetString(this.f6643c));
        aSN1EncodableVector.a(this.a);
        return new DERSequence(aSN1EncodableVector);
    }

    public McElieceCCA2PrivateKey(ASN1Sequence aSN1Sequence) {
        this.c = ((ASN1Integer) aSN1Sequence.s(0)).t().intValue();
        this.d = ((ASN1Integer) aSN1Sequence.s(1)).t().intValue();
        this.f6642a = ((ASN1OctetString) aSN1Sequence.s(2)).s();
        this.b = ((ASN1OctetString) aSN1Sequence.s(3)).s();
        this.f6643c = ((ASN1OctetString) aSN1Sequence.s(4)).s();
        this.a = AlgorithmIdentifier.g(aSN1Sequence.s(5));
    }
}
