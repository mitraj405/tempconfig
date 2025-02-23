package org.spongycastle.asn1.x509;

import java.io.IOException;
import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Boolean;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class BasicConstraints extends ASN1Object {
    public final ASN1Boolean a = ASN1Boolean.a;

    /* renamed from: a  reason: collision with other field name */
    public final ASN1Integer f5728a = null;

    public BasicConstraints(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 0) {
            this.a = null;
            this.f5728a = null;
            return;
        }
        if (aSN1Sequence.s(0) instanceof ASN1Boolean) {
            this.a = ASN1Boolean.r(aSN1Sequence.s(0));
        } else {
            this.a = null;
            this.f5728a = ASN1Integer.q(aSN1Sequence.s(0));
        }
        if (aSN1Sequence.size() <= 1) {
            return;
        }
        if (this.a != null) {
            this.f5728a = ASN1Integer.q(aSN1Sequence.s(1));
            return;
        }
        throw new IllegalArgumentException("wrong sequence in constructor");
    }

    public static BasicConstraints g(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof BasicConstraints) {
            return (BasicConstraints) aSN1Primitive;
        }
        if (aSN1Primitive instanceof X509Extension) {
            X509Extension x509Extension = (X509Extension) aSN1Primitive;
            ASN1ObjectIdentifier aSN1ObjectIdentifier = X509Extension.a;
            try {
                return g(ASN1Primitive.k(x509Extension.f5773a.s()));
            } catch (IOException e) {
                throw new IllegalArgumentException("can't convert extension: " + e);
            }
        } else if (aSN1Primitive != null) {
            return new BasicConstraints(ASN1Sequence.q(aSN1Primitive));
        } else {
            return null;
        }
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1Boolean aSN1Boolean = this.a;
        if (aSN1Boolean != null) {
            aSN1EncodableVector.a(aSN1Boolean);
        }
        ASN1Integer aSN1Integer = this.f5728a;
        if (aSN1Integer != null) {
            aSN1EncodableVector.a(aSN1Integer);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public final BigInteger h() {
        ASN1Integer aSN1Integer = this.f5728a;
        if (aSN1Integer != null) {
            return aSN1Integer.t();
        }
        return null;
    }

    public final boolean i() {
        ASN1Boolean aSN1Boolean = this.a;
        if (aSN1Boolean == null || !aSN1Boolean.t()) {
            return false;
        }
        return true;
    }

    public final String toString() {
        ASN1Integer aSN1Integer = this.f5728a;
        if (aSN1Integer != null) {
            return "BasicConstraints: isCa(" + i() + "), pathLenConstraint = " + aSN1Integer.t();
        } else if (this.a == null) {
            return "BasicConstraints: isCa(false)";
        } else {
            return "BasicConstraints: isCa(" + i() + ")";
        }
    }
}
