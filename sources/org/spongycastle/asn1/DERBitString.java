package org.spongycastle.asn1;

import java.io.IOException;

public class DERBitString extends ASN1BitString {
    public DERBitString(byte[] bArr) {
        super(bArr, 0);
    }

    public static DERBitString u(Object obj) {
        if (obj == null || (obj instanceof DERBitString)) {
            return (DERBitString) obj;
        }
        if (obj instanceof DLBitString) {
            DLBitString dLBitString = (DLBitString) obj;
            return new DERBitString(dLBitString.f5654a, dLBitString.c);
        } else if (obj instanceof byte[]) {
            try {
                return (DERBitString) ASN1Primitive.k((byte[]) obj);
            } catch (Exception e) {
                throw new IllegalArgumentException(C1058d.x(e, new StringBuilder("encoding error in getInstance: ")));
            }
        } else {
            throw new IllegalArgumentException("illegal object in getInstance: ".concat(obj.getClass().getName()));
        }
    }

    public static DERBitString v(ASN1TaggedObject aSN1TaggedObject) {
        ASN1Primitive r = aSN1TaggedObject.r();
        if (r instanceof DERBitString) {
            return u(r);
        }
        byte[] s = ((ASN1OctetString) r).s();
        if (s.length >= 1) {
            byte b = s[0];
            int length = s.length - 1;
            byte[] bArr = new byte[length];
            if (length != 0) {
                System.arraycopy(s, 1, bArr, 0, s.length - 1);
            }
            return new DERBitString(bArr, b);
        }
        throw new IllegalArgumentException("truncated BIT STRING detected");
    }

    public final void h(ASN1OutputStream aSN1OutputStream) throws IOException {
        int i = this.c;
        byte[] q = ASN1BitString.q(i, this.f5654a);
        int length = q.length + 1;
        byte[] bArr = new byte[length];
        bArr[0] = (byte) i;
        System.arraycopy(q, 0, bArr, 1, length - 1);
        aSN1OutputStream.d(3, bArr);
    }

    public final int i() {
        byte[] bArr = this.f5654a;
        return StreamUtil.a(bArr.length + 1) + 1 + bArr.length + 1;
    }

    public final boolean n() {
        return false;
    }

    public DERBitString(byte[] bArr, int i) {
        super(bArr, i);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DERBitString() {
        /*
            r5 = this;
            r0 = 0
            byte[] r1 = new byte[r0]
            r2 = 3
        L_0x0004:
            if (r2 < 0) goto L_0x0014
            if (r2 == 0) goto L_0x0011
            int r3 = r2 * 8
            int r3 = r0 >> r3
            if (r3 == 0) goto L_0x0011
            r2 = r3 & 255(0xff, float:3.57E-43)
            goto L_0x0015
        L_0x0011:
            int r2 = r2 + -1
            goto L_0x0004
        L_0x0014:
            r2 = r0
        L_0x0015:
            if (r2 != 0) goto L_0x0018
            goto L_0x0024
        L_0x0018:
            r0 = 1
            r3 = r0
        L_0x001a:
            int r2 = r2 << r0
            r4 = r2 & 255(0xff, float:3.57E-43)
            if (r4 == 0) goto L_0x0022
            int r3 = r3 + 1
            goto L_0x001a
        L_0x0022:
            int r0 = 8 - r3
        L_0x0024:
            r5.<init>(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.DERBitString.<init>():void");
    }

    public DERBitString(ASN1Object aSN1Object) throws IOException {
        super(aSN1Object.b().f("DER"), 0);
    }
}
