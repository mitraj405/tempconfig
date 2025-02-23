package org.spongycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;

public class ECNamedCurveSpec extends ECParameterSpec {
    public final String a;

    public ECNamedCurveSpec(String str, EllipticCurve ellipticCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        super(ellipticCurve, eCPoint, bigInteger, bigInteger2.intValue());
        this.a = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ECNamedCurveSpec(java.lang.String r7, org.spongycastle.math.ec.ECCurve r8, org.spongycastle.math.ec.ECPoint r9, java.math.BigInteger r10, java.math.BigInteger r11, byte[] r12) {
        /*
            r6 = this;
            org.spongycastle.math.field.FiniteField r0 = r8.f6613a
            int r1 = r0.a()
            r2 = 0
            r3 = 1
            if (r1 != r3) goto L_0x000c
            r1 = r3
            goto L_0x000d
        L_0x000c:
            r1 = r2
        L_0x000d:
            if (r1 == 0) goto L_0x0019
            java.security.spec.ECFieldFp r1 = new java.security.spec.ECFieldFp
            java.math.BigInteger r0 = r0.b()
            r1.<init>(r0)
            goto L_0x0041
        L_0x0019:
            org.spongycastle.math.field.PolynomialExtensionField r0 = (org.spongycastle.math.field.PolynomialExtensionField) r0
            org.spongycastle.math.field.Polynomial r0 = r0.c()
            int[] r1 = r0.a()
            int r4 = r1.length
            int r4 = r4 - r3
            int[] r1 = org.spongycastle.util.Arrays.o(r3, r4, r1)
            int r3 = r1.length
            int[] r4 = new int[r3]
        L_0x002c:
            int r3 = r3 + -1
            if (r3 < 0) goto L_0x0038
            int r5 = r2 + 1
            r2 = r1[r2]
            r4[r3] = r2
            r2 = r5
            goto L_0x002c
        L_0x0038:
            java.security.spec.ECFieldF2m r1 = new java.security.spec.ECFieldF2m
            int r0 = r0.b()
            r1.<init>(r0, r4)
        L_0x0041:
            org.spongycastle.math.ec.ECFieldElement r0 = r8.f6610a
            java.math.BigInteger r0 = r0.t()
            org.spongycastle.math.ec.ECFieldElement r8 = r8.f6614b
            java.math.BigInteger r8 = r8.t()
            java.security.spec.EllipticCurve r2 = new java.security.spec.EllipticCurve
            r2.<init>(r1, r0, r8, r12)
            org.spongycastle.math.ec.ECPoint r8 = r9.o()
            java.security.spec.ECPoint r9 = new java.security.spec.ECPoint
            r8.b()
            org.spongycastle.math.ec.ECFieldElement r12 = r8.f6621a
            java.math.BigInteger r12 = r12.t()
            org.spongycastle.math.ec.ECFieldElement r8 = r8.e()
            java.math.BigInteger r8 = r8.t()
            r9.<init>(r12, r8)
            int r8 = r11.intValue()
            r6.<init>(r2, r9, r10, r8)
            r6.a = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.spec.ECNamedCurveSpec.<init>(java.lang.String, org.spongycastle.math.ec.ECCurve, org.spongycastle.math.ec.ECPoint, java.math.BigInteger, java.math.BigInteger, byte[]):void");
    }
}
