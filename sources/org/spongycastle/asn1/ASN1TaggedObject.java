package org.spongycastle.asn1;

import java.io.IOException;

public abstract class ASN1TaggedObject extends ASN1Primitive implements ASN1TaggedObjectParser {
    public final ASN1Encodable a = null;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f5664a = true;
    public final int c;

    public ASN1TaggedObject(boolean z, int i, ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable instanceof ASN1Choice) {
            this.f5664a = true;
        } else {
            this.f5664a = z;
        }
        this.c = i;
        if (this.f5664a) {
            this.a = aSN1Encodable;
            return;
        }
        boolean z2 = aSN1Encodable.b() instanceof ASN1Set;
        this.a = aSN1Encodable;
    }

    public static ASN1TaggedObject q(Object obj) {
        if (obj == null || (obj instanceof ASN1TaggedObject)) {
            return (ASN1TaggedObject) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return q(ASN1Primitive.k((byte[]) obj));
            } catch (IOException e) {
                throw new IllegalArgumentException(C0709Uj.g(e, new StringBuilder("failed to construct tagged object from byte[]: ")));
            }
        } else {
            throw new IllegalArgumentException("unknown object in getInstance: ".concat(obj.getClass().getName()));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r4 = (org.spongycastle.asn1.ASN1TaggedObject) r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean g(org.spongycastle.asn1.ASN1Primitive r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof org.spongycastle.asn1.ASN1TaggedObject
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            org.spongycastle.asn1.ASN1TaggedObject r4 = (org.spongycastle.asn1.ASN1TaggedObject) r4
            int r0 = r4.c
            int r2 = r3.c
            if (r2 != r0) goto L_0x002f
            boolean r0 = r3.f5664a
            boolean r2 = r4.f5664a
            if (r0 == r2) goto L_0x0015
            goto L_0x002f
        L_0x0015:
            org.spongycastle.asn1.ASN1Encodable r4 = r4.a
            org.spongycastle.asn1.ASN1Encodable r0 = r3.a
            if (r0 != 0) goto L_0x001e
            if (r4 == 0) goto L_0x002d
            return r1
        L_0x001e:
            org.spongycastle.asn1.ASN1Primitive r0 = r0.b()
            org.spongycastle.asn1.ASN1Primitive r4 = r4.b()
            boolean r4 = r0.equals(r4)
            if (r4 != 0) goto L_0x002d
            return r1
        L_0x002d:
            r4 = 1
            return r4
        L_0x002f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.ASN1TaggedObject.g(org.spongycastle.asn1.ASN1Primitive):boolean");
    }

    public final int hashCode() {
        int i = this.c;
        ASN1Encodable aSN1Encodable = this.a;
        if (aSN1Encodable != null) {
            return i ^ aSN1Encodable.hashCode();
        }
        return i;
    }

    public final ASN1Primitive o() {
        return new DERTaggedObject(this.f5664a, this.c, this.a);
    }

    public final ASN1Primitive p() {
        return new DLTaggedObject(this.f5664a, this.c, this.a);
    }

    public final ASN1Primitive r() {
        ASN1Encodable aSN1Encodable = this.a;
        if (aSN1Encodable != null) {
            return aSN1Encodable.b();
        }
        return null;
    }

    public final String toString() {
        return "[" + this.c + "]" + this.a;
    }

    public final ASN1Primitive a() {
        return this;
    }
}
