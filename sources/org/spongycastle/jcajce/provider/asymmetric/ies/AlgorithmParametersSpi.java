package org.spongycastle.jcajce.provider.asymmetric.ies;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.jce.spec.IESParameterSpec;
import org.spongycastle.util.Arrays;

public class AlgorithmParametersSpi extends java.security.AlgorithmParametersSpi {
    public IESParameterSpec a;

    public final byte[] engineGetEncoded(String str) {
        if ((str == null || str.equals("ASN.1")) || str.equalsIgnoreCase("X.509")) {
            return engineGetEncoded();
        }
        return null;
    }

    public final AlgorithmParameterSpec engineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
        if (cls == null) {
            throw new NullPointerException("argument to getParameterSpec must not be null");
        } else if (cls == IESParameterSpec.class || cls == AlgorithmParameterSpec.class) {
            return this.a;
        } else {
            throw new InvalidParameterSpecException("unknown parameter spec passed to ElGamal parameters object.");
        }
    }

    public final void engineInit(byte[] bArr, String str) throws IOException {
        if ((str == null || str.equals("ASN.1")) || str.equalsIgnoreCase("X.509")) {
            engineInit(bArr);
            return;
        }
        throw new IOException("Unknown parameter format ".concat(str));
    }

    public final String engineToString() {
        return "IES Parameters";
    }

    public final byte[] engineGetEncoded() {
        try {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            if (Arrays.c(this.a.f6607a) != null) {
                aSN1EncodableVector.a(new DERTaggedObject(false, 0, new DEROctetString(Arrays.c(this.a.f6607a))));
            }
            if (Arrays.c(this.a.f6608b) != null) {
                aSN1EncodableVector.a(new DERTaggedObject(false, 1, new DEROctetString(Arrays.c(this.a.f6608b))));
            }
            aSN1EncodableVector.a(new ASN1Integer((long) this.a.a));
            if (this.a.a() != null) {
                ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                aSN1EncodableVector2.a(new ASN1Integer((long) this.a.b));
                aSN1EncodableVector2.a(new ASN1Integer(this.a.a(), true));
                aSN1EncodableVector.a(new DERSequence(aSN1EncodableVector2));
            }
            return new DERSequence(aSN1EncodableVector).f("DER");
        } catch (IOException unused) {
            throw new RuntimeException("Error encoding IESParameters");
        }
    }

    public final void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
        if (algorithmParameterSpec instanceof IESParameterSpec) {
            this.a = (IESParameterSpec) algorithmParameterSpec;
            return;
        }
        throw new InvalidParameterSpecException("IESParameterSpec required to initialise a IES algorithm parameters object");
    }

    public final void engineInit(byte[] bArr) throws IOException {
        try {
            ASN1Sequence aSN1Sequence = (ASN1Sequence) ASN1Primitive.k(bArr);
            if (aSN1Sequence.size() == 1) {
                this.a = new IESParameterSpec((byte[]) null, ASN1Integer.q(aSN1Sequence.s(0)).t().intValue(), (byte[]) null);
            } else if (aSN1Sequence.size() == 2) {
                ASN1TaggedObject q = ASN1TaggedObject.q(aSN1Sequence.s(0));
                if (q.c == 0) {
                    this.a = new IESParameterSpec(ASN1OctetString.r(q, false).s(), ASN1Integer.q(aSN1Sequence.s(1)).t().intValue(), (byte[]) null);
                    return;
                }
                this.a = new IESParameterSpec((byte[]) null, ASN1Integer.q(aSN1Sequence.s(1)).t().intValue(), ASN1OctetString.r(q, false).s());
            } else if (aSN1Sequence.size() == 3) {
                ASN1TaggedObject q2 = ASN1TaggedObject.q(aSN1Sequence.s(0));
                ASN1TaggedObject q3 = ASN1TaggedObject.q(aSN1Sequence.s(1));
                this.a = new IESParameterSpec(ASN1OctetString.r(q2, false).s(), ASN1Integer.q(aSN1Sequence.s(2)).t().intValue(), ASN1OctetString.r(q3, false).s());
            } else if (aSN1Sequence.size() == 4) {
                ASN1TaggedObject q4 = ASN1TaggedObject.q(aSN1Sequence.s(0));
                ASN1TaggedObject q5 = ASN1TaggedObject.q(aSN1Sequence.s(1));
                ASN1Sequence q6 = ASN1Sequence.q(aSN1Sequence.s(3));
                this.a = new IESParameterSpec(ASN1Integer.q(aSN1Sequence.s(2)).t().intValue(), ASN1Integer.q(q6.s(0)).t().intValue(), ASN1OctetString.r(q4, false).s(), ASN1OctetString.r(q5, false).s(), ASN1OctetString.q(q6.s(1)).s());
            }
        } catch (ClassCastException unused) {
            throw new IOException("Not a valid IES Parameter encoding.");
        } catch (ArrayIndexOutOfBoundsException unused2) {
            throw new IOException("Not a valid IES Parameter encoding.");
        }
    }
}
