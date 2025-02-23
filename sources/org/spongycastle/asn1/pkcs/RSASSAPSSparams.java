package org.spongycastle.asn1.pkcs;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class RSASSAPSSparams extends ASN1Object {
    public static final ASN1Integer c = new ASN1Integer(20);

    /* renamed from: c  reason: collision with other field name */
    public static final AlgorithmIdentifier f5705c;
    public static final ASN1Integer d = new ASN1Integer(1);

    /* renamed from: d  reason: collision with other field name */
    public static final AlgorithmIdentifier f5706d;
    public final ASN1Integer a;

    /* renamed from: a  reason: collision with other field name */
    public final AlgorithmIdentifier f5707a;
    public final ASN1Integer b;

    /* renamed from: b  reason: collision with other field name */
    public final AlgorithmIdentifier f5708b;

    static {
        AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(OIWObjectIdentifiers.f, DERNull.a);
        f5705c = algorithmIdentifier;
        f5706d = new AlgorithmIdentifier(PKCSObjectIdentifiers.g, algorithmIdentifier);
    }

    public RSASSAPSSparams() {
        this.f5707a = f5705c;
        this.f5708b = f5706d;
        this.a = c;
        this.b = d;
    }

    public static RSASSAPSSparams g(Object obj) {
        if (obj instanceof RSASSAPSSparams) {
            return (RSASSAPSSparams) obj;
        }
        if (obj != null) {
            return new RSASSAPSSparams(ASN1Sequence.q(obj));
        }
        return null;
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        AlgorithmIdentifier algorithmIdentifier = f5705c;
        AlgorithmIdentifier algorithmIdentifier2 = this.f5707a;
        if (!algorithmIdentifier2.equals(algorithmIdentifier)) {
            aSN1EncodableVector.a(new DERTaggedObject(true, 0, algorithmIdentifier2));
        }
        AlgorithmIdentifier algorithmIdentifier3 = f5706d;
        AlgorithmIdentifier algorithmIdentifier4 = this.f5708b;
        if (!algorithmIdentifier4.equals(algorithmIdentifier3)) {
            aSN1EncodableVector.a(new DERTaggedObject(true, 1, algorithmIdentifier4));
        }
        ASN1Integer aSN1Integer = c;
        ASN1Integer aSN1Integer2 = this.a;
        if (!aSN1Integer2.equals(aSN1Integer)) {
            aSN1EncodableVector.a(new DERTaggedObject(true, 2, aSN1Integer2));
        }
        ASN1Integer aSN1Integer3 = d;
        ASN1Integer aSN1Integer4 = this.b;
        if (!aSN1Integer4.equals(aSN1Integer3)) {
            aSN1EncodableVector.a(new DERTaggedObject(true, 3, aSN1Integer4));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public RSASSAPSSparams(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2, ASN1Integer aSN1Integer, ASN1Integer aSN1Integer2) {
        this.f5707a = algorithmIdentifier;
        this.f5708b = algorithmIdentifier2;
        this.a = aSN1Integer;
        this.b = aSN1Integer2;
    }

    public RSASSAPSSparams(ASN1Sequence aSN1Sequence) {
        this.f5707a = f5705c;
        this.f5708b = f5706d;
        this.a = c;
        this.b = d;
        for (int i = 0; i != aSN1Sequence.size(); i++) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Sequence.s(i);
            int i2 = aSN1TaggedObject.c;
            if (i2 == 0) {
                this.f5707a = AlgorithmIdentifier.g(ASN1Sequence.r(aSN1TaggedObject, true));
            } else if (i2 == 1) {
                this.f5708b = AlgorithmIdentifier.g(ASN1Sequence.r(aSN1TaggedObject, true));
            } else if (i2 == 2) {
                this.a = ASN1Integer.r(aSN1TaggedObject, true);
            } else if (i2 == 3) {
                this.b = ASN1Integer.r(aSN1TaggedObject, true);
            } else {
                throw new IllegalArgumentException("unknown tag");
            }
        }
    }
}
