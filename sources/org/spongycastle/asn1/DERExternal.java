package org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class DERExternal extends ASN1Primitive {
    public final ASN1ObjectIdentifier Z0;
    public final ASN1Integer a;

    /* renamed from: a  reason: collision with other field name */
    public final ASN1Primitive f5669a;
    public final ASN1Primitive b;
    public int c;

    public DERExternal(ASN1EncodableVector aSN1EncodableVector) {
        int i = 0;
        ASN1Primitive q = q(0, aSN1EncodableVector);
        if (q instanceof ASN1ObjectIdentifier) {
            this.Z0 = (ASN1ObjectIdentifier) q;
            q = q(1, aSN1EncodableVector);
            i = 1;
        }
        if (q instanceof ASN1Integer) {
            this.a = (ASN1Integer) q;
            i++;
            q = q(i, aSN1EncodableVector);
        }
        if (!(q instanceof ASN1TaggedObject)) {
            this.f5669a = q;
            i++;
            q = q(i, aSN1EncodableVector);
        }
        if (aSN1EncodableVector.c() != i + 1) {
            throw new IllegalArgumentException("input vector too large");
        } else if (q instanceof ASN1TaggedObject) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) q;
            int i2 = aSN1TaggedObject.c;
            if (i2 < 0 || i2 > 2) {
                throw new IllegalArgumentException(lf.h("invalid encoding value: ", i2));
            }
            this.c = i2;
            this.b = aSN1TaggedObject.r();
        } else {
            throw new IllegalArgumentException("No tagged object found in vector. Structure doesn't seem to be of type External");
        }
    }

    public static ASN1Primitive q(int i, ASN1EncodableVector aSN1EncodableVector) {
        if (aSN1EncodableVector.c() > i) {
            return aSN1EncodableVector.b(i).b();
        }
        throw new IllegalArgumentException("too few objects in input vector");
    }

    public final boolean g(ASN1Primitive aSN1Primitive) {
        ASN1Primitive aSN1Primitive2;
        ASN1Integer aSN1Integer;
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        if (!(aSN1Primitive instanceof DERExternal)) {
            return false;
        }
        if (this == aSN1Primitive) {
            return true;
        }
        DERExternal dERExternal = (DERExternal) aSN1Primitive;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = this.Z0;
        if (aSN1ObjectIdentifier2 != null && ((aSN1ObjectIdentifier = dERExternal.Z0) == null || !aSN1ObjectIdentifier.equals(aSN1ObjectIdentifier2))) {
            return false;
        }
        ASN1Integer aSN1Integer2 = this.a;
        if (aSN1Integer2 != null && ((aSN1Integer = dERExternal.a) == null || !aSN1Integer.equals(aSN1Integer2))) {
            return false;
        }
        ASN1Primitive aSN1Primitive3 = this.f5669a;
        if (aSN1Primitive3 == null || ((aSN1Primitive2 = dERExternal.f5669a) != null && aSN1Primitive2.equals(aSN1Primitive3))) {
            return this.b.equals(dERExternal.b);
        }
        return false;
    }

    public final void h(ASN1OutputStream aSN1OutputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this.Z0;
        if (aSN1ObjectIdentifier != null) {
            byteArrayOutputStream.write(aSN1ObjectIdentifier.f("DER"));
        }
        ASN1Integer aSN1Integer = this.a;
        if (aSN1Integer != null) {
            byteArrayOutputStream.write(aSN1Integer.f("DER"));
        }
        ASN1Primitive aSN1Primitive = this.f5669a;
        if (aSN1Primitive != null) {
            byteArrayOutputStream.write(aSN1Primitive.f("DER"));
        }
        byteArrayOutputStream.write(new DERTaggedObject(true, this.c, this.b).f("DER"));
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        aSN1OutputStream.h(32, 8);
        aSN1OutputStream.f(byteArray.length);
        aSN1OutputStream.a.write(byteArray);
    }

    public final int hashCode() {
        int i;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this.Z0;
        if (aSN1ObjectIdentifier != null) {
            i = aSN1ObjectIdentifier.hashCode();
        } else {
            i = 0;
        }
        ASN1Integer aSN1Integer = this.a;
        if (aSN1Integer != null) {
            i ^= aSN1Integer.hashCode();
        }
        ASN1Primitive aSN1Primitive = this.f5669a;
        if (aSN1Primitive != null) {
            i ^= aSN1Primitive.hashCode();
        }
        return i ^ this.b.hashCode();
    }

    public final int i() throws IOException {
        return e().length;
    }

    public final boolean n() {
        return true;
    }
}
