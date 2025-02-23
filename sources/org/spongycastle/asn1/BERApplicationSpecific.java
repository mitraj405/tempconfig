package org.spongycastle.asn1;

import java.io.IOException;

public class BERApplicationSpecific extends ASN1ApplicationSpecific {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BERApplicationSpecific(int r5, org.spongycastle.asn1.ASN1EncodableVector r6) {
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
            java.lang.String r3 = "BER"
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
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.BERApplicationSpecific.<init>(int, org.spongycastle.asn1.ASN1EncodableVector):void");
    }

    public final void h(ASN1OutputStream aSN1OutputStream) throws IOException {
        int i;
        if (this.a) {
            i = 96;
        } else {
            i = 64;
        }
        aSN1OutputStream.h(i, this.c);
        aSN1OutputStream.c(128);
        aSN1OutputStream.a.write(this.f5653a);
        aSN1OutputStream.c(0);
        aSN1OutputStream.c(0);
    }
}
