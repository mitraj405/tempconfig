package org.spongycastle.jcajce.provider.asymmetric.x509;

import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.util.encoders.Base64;

class PEMUtil {
    public final String a;
    public final String b;
    public final String c = "-----BEGIN PKCS7-----";
    public final String d;
    public final String e;
    public final String f;

    public PEMUtil(String str) {
        this.a = lf.j("-----BEGIN ", str, "-----");
        this.b = lf.j("-----BEGIN X509 ", str, "-----");
        this.d = lf.j("-----END ", str, "-----");
        this.e = lf.j("-----END X509 ", str, "-----");
        this.f = "-----END PKCS7-----";
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0022 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.io.InputStream r5) throws java.io.IOException {
        /*
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
        L_0x0005:
            int r1 = r5.read()
            r2 = 10
            r3 = 13
            if (r1 == r3) goto L_0x0018
            if (r1 == r2) goto L_0x0018
            if (r1 < 0) goto L_0x0018
            char r1 = (char) r1
            r0.append(r1)
            goto L_0x0005
        L_0x0018:
            if (r1 < 0) goto L_0x0020
            int r4 = r0.length()
            if (r4 == 0) goto L_0x0005
        L_0x0020:
            if (r1 >= 0) goto L_0x0024
            r5 = 0
            return r5
        L_0x0024:
            if (r1 != r3) goto L_0x0038
            r1 = 1
            r5.mark(r1)
            int r3 = r5.read()
            if (r3 != r2) goto L_0x0033
            r5.mark(r1)
        L_0x0033:
            if (r3 <= 0) goto L_0x0038
            r5.reset()
        L_0x0038:
            java.lang.String r5 = r0.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.x509.PEMUtil.a(java.io.InputStream):java.lang.String");
    }

    public final ASN1Sequence b(InputStream inputStream) throws IOException {
        String a2;
        StringBuffer stringBuffer = new StringBuffer();
        do {
            a2 = a(inputStream);
            if (a2 == null || a2.startsWith(this.a) || a2.startsWith(this.b) || a2.startsWith(this.c)) {
            }
            a2 = a(inputStream);
            break;
        } while (a2.startsWith(this.c));
        while (true) {
            String a3 = a(inputStream);
            if (a3 != null && !a3.startsWith(this.d) && !a3.startsWith(this.e) && !a3.startsWith(this.f)) {
                stringBuffer.append(a3);
            }
        }
        if (stringBuffer.length() == 0) {
            return null;
        }
        try {
            return ASN1Sequence.q(Base64.a(stringBuffer.toString()));
        } catch (Exception unused) {
            throw new IOException("malformed PEM data encountered");
        }
    }
}
