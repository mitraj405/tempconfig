package org.spongycastle.asn1.cryptopro;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class GOST3410ParamSetParameters extends ASN1Object {
    public final ASN1Integer a;
    public final ASN1Integer b;
    public final int c = UserMetadata.MAX_ATTRIBUTE_SIZE;

    /* renamed from: c  reason: collision with other field name */
    public final ASN1Integer f5686c;

    public GOST3410ParamSetParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.a = new ASN1Integer(bigInteger);
        this.b = new ASN1Integer(bigInteger2);
        this.f5686c = new ASN1Integer(bigInteger3);
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(new ASN1Integer((long) this.c));
        aSN1EncodableVector.a(this.a);
        aSN1EncodableVector.a(this.b);
        aSN1EncodableVector.a(this.f5686c);
        return new DERSequence(aSN1EncodableVector);
    }
}
