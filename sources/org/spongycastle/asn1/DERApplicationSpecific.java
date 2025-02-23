package org.spongycastle.asn1;

import java.io.IOException;
import org.spongycastle.util.Strings;
import org.spongycastle.util.encoders.Hex;
import org.spongycastle.util.encoders.HexEncoder;

public class DERApplicationSpecific extends ASN1ApplicationSpecific {
    public DERApplicationSpecific(byte[] bArr, int i, boolean z) {
        super(bArr, i, z);
    }

    public final void h(ASN1OutputStream aSN1OutputStream) throws IOException {
        int i;
        if (this.a) {
            i = 96;
        } else {
            i = 64;
        }
        aSN1OutputStream.h(i, this.c);
        byte[] bArr = this.f5653a;
        aSN1OutputStream.f(bArr.length);
        aSN1OutputStream.a.write(bArr);
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer("[");
        if (this.a) {
            stringBuffer.append("CONSTRUCTED ");
        }
        stringBuffer.append("APPLICATION ");
        stringBuffer.append(Integer.toString(this.c));
        stringBuffer.append("]");
        byte[] bArr = this.f5653a;
        if (bArr != null) {
            stringBuffer.append(" #");
            HexEncoder hexEncoder = Hex.a;
            stringBuffer.append(Strings.a(Hex.b(0, bArr, bArr.length)));
        } else {
            stringBuffer.append(" #null");
        }
        stringBuffer.append(" ");
        return stringBuffer.toString();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DERApplicationSpecific(int r5, org.spongycastle.asn1.DEROctetString r6) throws java.io.IOException {
        /*
            r4 = this;
            r6.getClass()
            r6.getClass()
            java.lang.String r0 = "DER"
            byte[] r6 = r6.f(r0)
            r0 = 1
            byte r0 = r6[r0]
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 128(0x80, float:1.794E-43)
            r2 = 2
            if (r0 != r1) goto L_0x0017
            goto L_0x002d
        L_0x0017:
            r1 = 127(0x7f, float:1.78E-43)
            if (r0 <= r1) goto L_0x002d
            r0 = r0 & r1
            r1 = 4
            if (r0 > r1) goto L_0x0021
            int r2 = r2 + r0
            goto L_0x002d
        L_0x0021:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "DER length more than 4 bytes: "
            java.lang.String r6 = defpackage.lf.h(r6, r0)
            r5.<init>(r6)
            throw r5
        L_0x002d:
            int r0 = r6.length
            int r0 = r0 - r2
            byte[] r1 = new byte[r0]
            r3 = 0
            java.lang.System.arraycopy(r6, r2, r1, r3, r0)
            r4.<init>(r1, r5, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.DERApplicationSpecific.<init>(int, org.spongycastle.asn1.DEROctetString):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DERApplicationSpecific(int r5, org.spongycastle.asn1.ASN1EncodableVector r6) {
        /*
            r4 = this;
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 0
        L_0x0006:
            int r2 = r6.c()
            if (r1 == r2) goto L_0x0033
            org.spongycastle.asn1.ASN1Encodable r2 = r6.b(r1)     // Catch:{ IOException -> 0x001e }
            org.spongycastle.asn1.ASN1Object r2 = (org.spongycastle.asn1.ASN1Object) r2     // Catch:{ IOException -> 0x001e }
            java.lang.String r3 = "DER"
            byte[] r2 = r2.f(r3)     // Catch:{ IOException -> 0x001e }
            r0.write(r2)     // Catch:{ IOException -> 0x001e }
            int r1 = r1 + 1
            goto L_0x0006
        L_0x001e:
            r5 = move-exception
            org.spongycastle.asn1.ASN1ParsingException r6 = new org.spongycastle.asn1.ASN1ParsingException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "malformed object: "
            r0.<init>(r1)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            r6.<init>(r0, r5)
            throw r6
        L_0x0033:
            byte[] r6 = r0.toByteArray()
            r0 = 1
            r4.<init>(r6, r5, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.DERApplicationSpecific.<init>(int, org.spongycastle.asn1.ASN1EncodableVector):void");
    }
}
