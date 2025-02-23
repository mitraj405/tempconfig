package org.spongycastle.asn1.ua;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.util.Arrays;

public class DSTU4145Params extends ASN1Object {
    public static final byte[] b = {-87, -42, -21, 69, -15, 60, 112, -126, UnsignedBytes.MAX_POWER_OF_TWO, -60, -106, 123, 35, Ascii.US, 94, -83, -10, 88, -21, -92, -64, 55, 41, Ascii.GS, 56, -39, 107, -16, 37, -54, 78, Ascii.ETB, -8, -23, 114, Ascii.CR, -58, Ascii.NAK, -76, 58, 40, -105, 95, Ascii.VT, -63, -34, -93, 100, 56, -75, 100, -22, 44, Ascii.ETB, -97, -48, Ascii.DC2, 62, 109, -72, -6, -59, 121, 4};
    public final ASN1ObjectIdentifier Z0;
    public final DSTU4145ECBinary a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f5718a = b;

    public DSTU4145Params(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.Z0 = aSN1ObjectIdentifier;
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this.Z0;
        if (aSN1ObjectIdentifier != null) {
            aSN1EncodableVector.a(aSN1ObjectIdentifier);
        } else {
            aSN1EncodableVector.a(this.a);
        }
        if (!Arrays.a(this.f5718a, b)) {
            aSN1EncodableVector.a(new DEROctetString(this.f5718a));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public DSTU4145Params(DSTU4145ECBinary dSTU4145ECBinary) {
        this.a = dSTU4145ECBinary;
    }
}
