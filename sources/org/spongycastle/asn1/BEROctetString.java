package org.spongycastle.asn1;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

public class BEROctetString extends ASN1OctetString {
    public final ASN1OctetString[] a;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BEROctetString(org.spongycastle.asn1.ASN1OctetString[] r4) {
        /*
            r3 = this;
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 0
        L_0x0006:
            int r2 = r4.length
            if (r1 == r2) goto L_0x0044
            r2 = r4[r1]     // Catch:{ ClassCastException -> 0x002e, IOException -> 0x0015 }
            org.spongycastle.asn1.DEROctetString r2 = (org.spongycastle.asn1.DEROctetString) r2     // Catch:{ ClassCastException -> 0x002e, IOException -> 0x0015 }
            byte[] r2 = r2.a     // Catch:{ ClassCastException -> 0x002e, IOException -> 0x0015 }
            r0.write(r2)     // Catch:{ ClassCastException -> 0x002e, IOException -> 0x0015 }
            int r1 = r1 + 1
            goto L_0x0006
        L_0x0015:
            r4 = move-exception
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "exception converting octets "
            r1.<init>(r2)
            java.lang.String r4 = r4.toString()
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4)
            throw r0
        L_0x002e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r4 = r4[r1]
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getName()
            java.lang.String r1 = " found in input should only contain DEROctetString"
            java.lang.String r4 = r4.concat(r1)
            r0.<init>(r4)
            throw r0
        L_0x0044:
            byte[] r0 = r0.toByteArray()
            r3.<init>(r0)
            r3.a = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.BEROctetString.<init>(org.spongycastle.asn1.ASN1OctetString[]):void");
    }

    public final void h(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.c(36);
        aSN1OutputStream.c(128);
        Enumeration t = t();
        while (t.hasMoreElements()) {
            aSN1OutputStream.g((ASN1Encodable) t.nextElement());
        }
        aSN1OutputStream.c(0);
        aSN1OutputStream.c(0);
    }

    public final int i() throws IOException {
        Enumeration t = t();
        int i = 0;
        while (t.hasMoreElements()) {
            i += ((ASN1Encodable) t.nextElement()).b().i();
        }
        return i + 2 + 2;
    }

    public final boolean n() {
        return true;
    }

    public byte[] s() {
        return this.a;
    }

    public Enumeration t() {
        int i;
        if (this.a != null) {
            return new Enumeration() {
                public int a = 0;

                public final boolean hasMoreElements() {
                    if (this.a < BEROctetString.this.a.length) {
                        return true;
                    }
                    return false;
                }

                public final Object nextElement() {
                    ASN1OctetString[] aSN1OctetStringArr = BEROctetString.this.a;
                    int i = this.a;
                    this.a = i + 1;
                    return aSN1OctetStringArr[i];
                }
            };
        }
        Vector vector = new Vector();
        int i2 = 0;
        while (true) {
            byte[] bArr = this.a;
            if (i2 >= bArr.length) {
                return vector.elements();
            }
            int i3 = i2 + 1000;
            if (i3 > bArr.length) {
                i = bArr.length;
            } else {
                i = i3;
            }
            int i4 = i - i2;
            byte[] bArr2 = new byte[i4];
            System.arraycopy(bArr, i2, bArr2, 0, i4);
            vector.addElement(new DEROctetString(bArr2));
            i2 = i3;
        }
    }

    public BEROctetString(byte[] bArr) {
        super(bArr);
    }
}
