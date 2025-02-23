package org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Iterable;

public abstract class ASN1Set extends ASN1Primitive implements Iterable<ASN1Encodable> {
    public Vector a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5661a;

    /* renamed from: org.spongycastle.asn1.ASN1Set$1  reason: invalid class name */
    class AnonymousClass1 implements ASN1SetParser {
        public final ASN1Primitive a() {
            return null;
        }

        public final ASN1Primitive b() {
            return null;
        }
    }

    public ASN1Set() {
        this.a = new Vector();
        this.f5661a = false;
    }

    public static ASN1Set q(Object obj) {
        if (obj == null || (obj instanceof ASN1Set)) {
            return (ASN1Set) obj;
        }
        if (obj instanceof ASN1SetParser) {
            return q(((ASN1SetParser) obj).b());
        }
        if (obj instanceof byte[]) {
            try {
                return q(ASN1Primitive.k((byte[]) obj));
            } catch (IOException e) {
                throw new IllegalArgumentException(C0709Uj.g(e, new StringBuilder("failed to construct set from byte[]: ")));
            }
        } else {
            if (obj instanceof ASN1Encodable) {
                ASN1Primitive b = ((ASN1Encodable) obj).b();
                if (b instanceof ASN1Set) {
                    return (ASN1Set) b;
                }
            }
            throw new IllegalArgumentException("unknown object in getInstance: ".concat(obj.getClass().getName()));
        }
    }

    public static ASN1Set r(ASN1TaggedObject aSN1TaggedObject) {
        if (aSN1TaggedObject.f5664a) {
            if (aSN1TaggedObject instanceof BERTaggedObject) {
                return new BERSet(aSN1TaggedObject.r());
            }
            return new DLSet(aSN1TaggedObject.r());
        } else if (aSN1TaggedObject.r() instanceof ASN1Set) {
            return (ASN1Set) aSN1TaggedObject.r();
        } else {
            if (aSN1TaggedObject.r() instanceof ASN1Sequence) {
                ASN1Sequence aSN1Sequence = (ASN1Sequence) aSN1TaggedObject.r();
                if (aSN1TaggedObject instanceof BERTaggedObject) {
                    return new BERSet(aSN1Sequence.u());
                }
                return new DLSet(aSN1Sequence.u());
            }
            throw new IllegalArgumentException("unknown object in getInstance: ".concat(aSN1TaggedObject.getClass().getName()));
        }
    }

    public final boolean g(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1Set)) {
            return false;
        }
        ASN1Set aSN1Set = (ASN1Set) aSN1Primitive;
        if (size() != aSN1Set.size()) {
            return false;
        }
        Enumeration t = t();
        Enumeration t2 = aSN1Set.t();
        while (t.hasMoreElements()) {
            ASN1Encodable aSN1Encodable = (ASN1Encodable) t.nextElement();
            if (aSN1Encodable == null) {
                aSN1Encodable = DERNull.a;
            }
            ASN1Encodable aSN1Encodable2 = (ASN1Encodable) t2.nextElement();
            if (aSN1Encodable2 == null) {
                aSN1Encodable2 = DERNull.a;
            }
            ASN1Primitive b = aSN1Encodable.b();
            ASN1Primitive b2 = aSN1Encodable2.b();
            if (b != b2 && !b.equals(b2)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        Enumeration t = t();
        int size = size();
        while (t.hasMoreElements()) {
            Object obj = (ASN1Encodable) t.nextElement();
            if (obj == null) {
                obj = DERNull.a;
            }
            size = (size * 17) ^ obj.hashCode();
        }
        return size;
    }

    public final Iterator<ASN1Encodable> iterator() {
        ASN1Encodable[] aSN1EncodableArr = new ASN1Encodable[size()];
        for (int i = 0; i != size(); i++) {
            aSN1EncodableArr[i] = s(i);
        }
        return new Arrays.Iterator(aSN1EncodableArr);
    }

    public final boolean n() {
        return true;
    }

    public final ASN1Primitive o() {
        if (this.f5661a) {
            DERSet dERSet = new DERSet();
            dERSet.a = this.a;
            return dERSet;
        }
        Vector vector = new Vector();
        for (int i = 0; i != this.a.size(); i++) {
            vector.addElement(this.a.elementAt(i));
        }
        DERSet dERSet2 = new DERSet();
        dERSet2.a = vector;
        dERSet2.u();
        return dERSet2;
    }

    public final ASN1Primitive p() {
        DLSet dLSet = new DLSet();
        dLSet.a = this.a;
        return dLSet;
    }

    public final ASN1Encodable s(int i) {
        return (ASN1Encodable) this.a.elementAt(i);
    }

    public final int size() {
        return this.a.size();
    }

    public final Enumeration t() {
        return this.a.elements();
    }

    public final String toString() {
        return this.a.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0059, code lost:
        if ((r13 & com.google.common.primitives.UnsignedBytes.MAX_VALUE) < (r14 & com.google.common.primitives.UnsignedBytes.MAX_VALUE)) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0060, code lost:
        if (r11 == r7.length) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0062, code lost:
        r11 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0064, code lost:
        r11 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0065, code lost:
        if (r11 == false) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0067, code lost:
        r7 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0069, code lost:
        r4 = r15.a.elementAt(r8);
        r6 = r15.a;
        r6.setElementAt(r6.elementAt(r10), r8);
        r15.a.setElementAt(r4, r10);
        r6 = true;
        r4 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007f, code lost:
        r8 = r10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void u() {
        /*
            r15 = this;
            java.lang.String r0 = "cannot encode object added to SET"
            java.lang.String r1 = "DER"
            boolean r2 = r15.f5661a
            if (r2 != 0) goto L_0x0090
            r2 = 1
            r15.f5661a = r2
            java.util.Vector r3 = r15.a
            int r3 = r3.size()
            if (r3 <= r2) goto L_0x0090
            java.util.Vector r3 = r15.a
            int r3 = r3.size()
            int r3 = r3 - r2
            r4 = r2
        L_0x001b:
            if (r4 == 0) goto L_0x0090
            java.util.Vector r4 = r15.a
            r5 = 0
            java.lang.Object r4 = r4.elementAt(r5)
            org.spongycastle.asn1.ASN1Encodable r4 = (org.spongycastle.asn1.ASN1Encodable) r4
            org.spongycastle.asn1.ASN1Primitive r4 = r4.b()     // Catch:{ IOException -> 0x008a }
            byte[] r4 = r4.f(r1)     // Catch:{ IOException -> 0x008a }
            r7 = r4
            r4 = r5
            r6 = r4
            r8 = r6
        L_0x0032:
            if (r8 == r3) goto L_0x0087
            java.util.Vector r9 = r15.a
            int r10 = r8 + 1
            java.lang.Object r9 = r9.elementAt(r10)
            org.spongycastle.asn1.ASN1Encodable r9 = (org.spongycastle.asn1.ASN1Encodable) r9
            org.spongycastle.asn1.ASN1Primitive r9 = r9.b()     // Catch:{ IOException -> 0x0081 }
            byte[] r9 = r9.f(r1)     // Catch:{ IOException -> 0x0081 }
            int r11 = r7.length
            int r12 = r9.length
            int r11 = java.lang.Math.min(r11, r12)
            r12 = r5
        L_0x004d:
            if (r12 == r11) goto L_0x005f
            byte r13 = r7[r12]
            byte r14 = r9[r12]
            if (r13 == r14) goto L_0x005c
            r11 = r13 & 255(0xff, float:3.57E-43)
            r12 = r14 & 255(0xff, float:3.57E-43)
            if (r11 >= r12) goto L_0x0064
            goto L_0x0062
        L_0x005c:
            int r12 = r12 + 1
            goto L_0x004d
        L_0x005f:
            int r12 = r7.length
            if (r11 != r12) goto L_0x0064
        L_0x0062:
            r11 = r2
            goto L_0x0065
        L_0x0064:
            r11 = r5
        L_0x0065:
            if (r11 == 0) goto L_0x0069
            r7 = r9
            goto L_0x007f
        L_0x0069:
            java.util.Vector r4 = r15.a
            java.lang.Object r4 = r4.elementAt(r8)
            java.util.Vector r6 = r15.a
            java.lang.Object r9 = r6.elementAt(r10)
            r6.setElementAt(r9, r8)
            java.util.Vector r6 = r15.a
            r6.setElementAt(r4, r10)
            r6 = r2
            r4 = r8
        L_0x007f:
            r8 = r10
            goto L_0x0032
        L_0x0081:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>(r0)
            throw r1
        L_0x0087:
            r3 = r4
            r4 = r6
            goto L_0x001b
        L_0x008a:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>(r0)
            throw r1
        L_0x0090:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.ASN1Set.u():void");
    }

    public ASN1Set(ASN1Encodable aSN1Encodable) {
        Vector vector = new Vector();
        this.a = vector;
        this.f5661a = false;
        vector.addElement(aSN1Encodable);
    }

    public ASN1Set(ASN1EncodableVector aSN1EncodableVector, boolean z) {
        this.a = new Vector();
        this.f5661a = false;
        for (int i = 0; i != aSN1EncodableVector.c(); i++) {
            this.a.addElement(aSN1EncodableVector.b(i));
        }
        if (z) {
            u();
        }
    }

    public ASN1Set(ASN1Encodable[] aSN1EncodableArr, boolean z) {
        this.a = new Vector();
        this.f5661a = false;
        for (int i = 0; i != aSN1EncodableArr.length; i++) {
            this.a.addElement(aSN1EncodableArr[i]);
        }
        if (z) {
            u();
        }
    }
}
