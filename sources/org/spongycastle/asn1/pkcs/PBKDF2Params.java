package org.spongycastle.asn1.pkcs;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.util.Arrays;

public class PBKDF2Params extends ASN1Object {
    public static final AlgorithmIdentifier b = new AlgorithmIdentifier(PKCSObjectIdentifiers.E, DERNull.a);
    public final ASN1Integer a;

    /* renamed from: a  reason: collision with other field name */
    public final ASN1OctetString f5696a;

    /* renamed from: a  reason: collision with other field name */
    public final AlgorithmIdentifier f5697a;

    /* renamed from: b  reason: collision with other field name */
    public final ASN1Integer f5698b;

    public PBKDF2Params(byte[] bArr, int i, int i2, AlgorithmIdentifier algorithmIdentifier) {
        this.f5696a = new DEROctetString(Arrays.c(bArr));
        this.a = new ASN1Integer((long) i);
        if (i2 > 0) {
            this.f5698b = new ASN1Integer((long) i2);
        } else {
            this.f5698b = null;
        }
        this.f5697a = algorithmIdentifier;
    }

    public static PBKDF2Params g(ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable instanceof PBKDF2Params) {
            return (PBKDF2Params) aSN1Encodable;
        }
        if (aSN1Encodable != null) {
            return new PBKDF2Params(ASN1Sequence.q(aSN1Encodable));
        }
        return null;
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(this.f5696a);
        aSN1EncodableVector.a(this.a);
        ASN1Integer aSN1Integer = this.f5698b;
        if (aSN1Integer != null) {
            aSN1EncodableVector.a(aSN1Integer);
        }
        AlgorithmIdentifier algorithmIdentifier = this.f5697a;
        if (algorithmIdentifier != null && !algorithmIdentifier.equals(b)) {
            aSN1EncodableVector.a(algorithmIdentifier);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public PBKDF2Params(ASN1Sequence aSN1Sequence) {
        Enumeration t = aSN1Sequence.t();
        this.f5696a = (ASN1OctetString) t.nextElement();
        this.a = (ASN1Integer) t.nextElement();
        if (t.hasMoreElements()) {
            Object nextElement = t.nextElement();
            if (nextElement instanceof ASN1Integer) {
                this.f5698b = ASN1Integer.q(nextElement);
                nextElement = t.hasMoreElements() ? t.nextElement() : null;
            } else {
                this.f5698b = null;
            }
            if (nextElement != null) {
                this.f5697a = AlgorithmIdentifier.g(nextElement);
            } else {
                this.f5697a = null;
            }
        } else {
            this.f5698b = null;
            this.f5697a = null;
        }
    }
}
