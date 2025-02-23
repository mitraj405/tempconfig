package org.spongycastle.asn1.x500.style;

import java.util.Enumeration;
import java.util.Hashtable;
import org.spongycastle.asn1.x500.AttributeTypeAndValue;
import org.spongycastle.asn1.x500.RDN;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x500.X500NameStyle;

public abstract class AbstractX500NameStyle implements X500NameStyle {
    public static Hashtable d(Hashtable hashtable) {
        Hashtable hashtable2 = new Hashtable();
        Enumeration keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            Object nextElement = keys.nextElement();
            hashtable2.put(nextElement, hashtable.get(nextElement));
        }
        return hashtable2;
    }

    public static boolean e(RDN rdn, RDN rdn2) {
        if (rdn.i()) {
            if (!rdn2.i()) {
                return false;
            }
            AttributeTypeAndValue[] h = rdn.h();
            AttributeTypeAndValue[] h2 = rdn2.h();
            if (h.length != h2.length) {
                return false;
            }
            for (int i = 0; i != h.length; i++) {
                if (!IETFUtils.c(h[i], h2[i])) {
                    return false;
                }
            }
            return true;
        } else if (!rdn2.i()) {
            return IETFUtils.c(rdn.g(), rdn2.g());
        } else {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c A[LOOP:0: B:10:0x0037->B:35:0x006c, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(org.spongycastle.asn1.x500.X500Name r9, org.spongycastle.asn1.x500.X500Name r10) {
        /*
            r8 = this;
            org.spongycastle.asn1.x500.RDN[] r9 = r9.h()
            org.spongycastle.asn1.x500.RDN[] r10 = r10.h()
            int r0 = r9.length
            int r1 = r10.length
            r2 = 0
            if (r0 == r1) goto L_0x000e
            return r2
        L_0x000e:
            r0 = r9[r2]
            org.spongycastle.asn1.x500.AttributeTypeAndValue r0 = r0.g()
            r1 = 1
            if (r0 == 0) goto L_0x0035
            r0 = r10[r2]
            org.spongycastle.asn1.x500.AttributeTypeAndValue r0 = r0.g()
            if (r0 == 0) goto L_0x0035
            r0 = r9[r2]
            org.spongycastle.asn1.x500.AttributeTypeAndValue r0 = r0.g()
            org.spongycastle.asn1.ASN1ObjectIdentifier r0 = r0.Z0
            r3 = r10[r2]
            org.spongycastle.asn1.x500.AttributeTypeAndValue r3 = r3.g()
            org.spongycastle.asn1.ASN1ObjectIdentifier r3 = r3.Z0
            boolean r0 = r0.equals(r3)
            r0 = r0 ^ r1
            goto L_0x0036
        L_0x0035:
            r0 = r2
        L_0x0036:
            r3 = r2
        L_0x0037:
            int r4 = r9.length
            if (r3 == r4) goto L_0x006f
            r4 = r9[r3]
            r5 = 0
            if (r0 == 0) goto L_0x0053
            int r6 = r10.length
            int r6 = r6 - r1
        L_0x0041:
            if (r6 < 0) goto L_0x0068
            r7 = r10[r6]
            if (r7 == 0) goto L_0x0050
            boolean r7 = e(r4, r7)
            if (r7 == 0) goto L_0x0050
            r10[r6] = r5
            goto L_0x0063
        L_0x0050:
            int r6 = r6 + -1
            goto L_0x0041
        L_0x0053:
            r6 = r2
        L_0x0054:
            int r7 = r10.length
            if (r6 == r7) goto L_0x0068
            r7 = r10[r6]
            if (r7 == 0) goto L_0x0065
            boolean r7 = e(r4, r7)
            if (r7 == 0) goto L_0x0065
            r10[r6] = r5
        L_0x0063:
            r4 = r1
            goto L_0x0069
        L_0x0065:
            int r6 = r6 + 1
            goto L_0x0054
        L_0x0068:
            r4 = r2
        L_0x0069:
            if (r4 != 0) goto L_0x006c
            return r2
        L_0x006c:
            int r3 = r3 + 1
            goto L_0x0037
        L_0x006f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.x500.style.AbstractX500NameStyle.b(org.spongycastle.asn1.x500.X500Name, org.spongycastle.asn1.x500.X500Name):boolean");
    }

    public final int c(X500Name x500Name) {
        RDN[] h = x500Name.h();
        int i = 0;
        for (int i2 = 0; i2 != h.length; i2++) {
            if (h[i2].i()) {
                AttributeTypeAndValue[] h2 = h[i2].h();
                for (int i3 = 0; i3 != h2.length; i3++) {
                    i = (i ^ h2[i3].Z0.hashCode()) ^ IETFUtils.d(IETFUtils.e(h2[i3].a)).hashCode();
                }
            } else {
                i = (i ^ h[i2].g().Z0.hashCode()) ^ IETFUtils.d(IETFUtils.e(h[i2].g().a)).hashCode();
            }
        }
        return i;
    }
}
