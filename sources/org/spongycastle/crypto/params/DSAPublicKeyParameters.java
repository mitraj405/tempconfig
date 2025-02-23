package org.spongycastle.crypto.params;

import java.math.BigInteger;

public class DSAPublicKeyParameters extends DSAKeyParameters {
    public static final BigInteger b = BigInteger.valueOf(1);
    public static final BigInteger c = BigInteger.valueOf(2);
    public final BigInteger a;

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0026, code lost:
        if (b.equals(r3.modPow(r4.b, r1)) != false) goto L_0x0031;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DSAPublicKeyParameters(java.math.BigInteger r3, org.spongycastle.crypto.params.DSAParameters r4) {
        /*
            r2 = this;
            r0 = 0
            r2.<init>(r0, r4)
            if (r4 == 0) goto L_0x0031
            java.math.BigInteger r0 = c
            int r1 = r0.compareTo(r3)
            if (r1 > 0) goto L_0x0029
            java.math.BigInteger r1 = r4.c
            java.math.BigInteger r0 = r1.subtract(r0)
            int r0 = r0.compareTo(r3)
            if (r0 < 0) goto L_0x0029
            java.math.BigInteger r4 = r4.b
            java.math.BigInteger r4 = r3.modPow(r4, r1)
            java.math.BigInteger r0 = b
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x0029
            goto L_0x0031
        L_0x0029:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "y value does not appear to be in correct group"
            r3.<init>(r4)
            throw r3
        L_0x0031:
            r2.a = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.params.DSAPublicKeyParameters.<init>(java.math.BigInteger, org.spongycastle.crypto.params.DSAParameters):void");
    }
}
