package org.spongycastle.pqc.crypto.xmss;

import org.spongycastle.pqc.crypto.xmss.LTreeAddress;

class XMSSNodeUtil {
    public static XMSSNode a(WOTSPlus wOTSPlus, WOTSPlusPublicKeyParameters wOTSPlusPublicKeyParameters, LTreeAddress lTreeAddress) {
        double d;
        int i;
        int i2;
        int i3;
        int i4;
        long j;
        int i5 = wOTSPlus.f6760a.c;
        byte[][] c = XMSSUtil.c(wOTSPlusPublicKeyParameters.a);
        XMSSNode[] xMSSNodeArr = new XMSSNode[c.length];
        for (int i6 = 0; i6 < c.length; i6++) {
            xMSSNodeArr[i6] = new XMSSNode(0, c[i6]);
        }
        LTreeAddress.Builder builder = (LTreeAddress.Builder) ((LTreeAddress.Builder) new LTreeAddress.Builder().c(lTreeAddress.a)).d(lTreeAddress.f6765a);
        builder.d = lTreeAddress.d;
        builder.e = 0;
        builder.f = lTreeAddress.f;
        LTreeAddress.Builder builder2 = (LTreeAddress.Builder) builder.b(lTreeAddress.c);
        builder2.getClass();
        LTreeAddress lTreeAddress2 = new LTreeAddress(builder2);
        while (i5 > 1) {
            int i7 = 0;
            while (true) {
                d = (double) (i5 / 2);
                int floor = (int) Math.floor(d);
                i = lTreeAddress2.a;
                i2 = lTreeAddress2.c;
                i3 = lTreeAddress2.e;
                i4 = lTreeAddress2.d;
                j = lTreeAddress2.f6765a;
                if (i7 >= floor) {
                    break;
                }
                LTreeAddress.Builder builder3 = (LTreeAddress.Builder) ((LTreeAddress.Builder) new LTreeAddress.Builder().c(i)).d(j);
                builder3.d = i4;
                builder3.e = i3;
                builder3.f = i7;
                LTreeAddress.Builder builder4 = (LTreeAddress.Builder) builder3.b(i2);
                builder4.getClass();
                LTreeAddress lTreeAddress3 = new LTreeAddress(builder4);
                int i8 = i7 * 2;
                xMSSNodeArr[i7] = b(wOTSPlus, xMSSNodeArr[i8], xMSSNodeArr[i8 + 1], lTreeAddress3);
                i7++;
                lTreeAddress2 = lTreeAddress3;
            }
            if (i5 % 2 == 1) {
                xMSSNodeArr[(int) Math.floor(d)] = xMSSNodeArr[i5 - 1];
            }
            i5 = (int) Math.ceil(((double) i5) / 2.0d);
            LTreeAddress.Builder builder5 = (LTreeAddress.Builder) ((LTreeAddress.Builder) new LTreeAddress.Builder().c(i)).d(j);
            builder5.d = i4;
            builder5.e = i3 + 1;
            builder5.f = lTreeAddress2.f;
            LTreeAddress.Builder builder6 = (LTreeAddress.Builder) builder5.b(i2);
            builder6.getClass();
            lTreeAddress2 = new LTreeAddress(builder6);
        }
        return xMSSNodeArr[0];
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0173 A[LOOP:0: B:26:0x0171->B:27:0x0173, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0184 A[LOOP:1: B:28:0x0182->B:29:0x0184, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x01af  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.spongycastle.pqc.crypto.xmss.XMSSNode b(org.spongycastle.pqc.crypto.xmss.WOTSPlus r12, org.spongycastle.pqc.crypto.xmss.XMSSNode r13, org.spongycastle.pqc.crypto.xmss.XMSSNode r14, org.spongycastle.pqc.crypto.xmss.XMSSAddress r15) {
        /*
            if (r13 == 0) goto L_0x01c7
            if (r14 == 0) goto L_0x01bf
            int r0 = r14.c
            int r1 = r13.c
            if (r1 != r0) goto L_0x01b7
            byte[] r0 = r12.b
            byte[] r0 = org.spongycastle.pqc.crypto.xmss.XMSSUtil.b(r0)
            boolean r2 = r15 instanceof org.spongycastle.pqc.crypto.xmss.LTreeAddress
            r3 = 0
            if (r2 == 0) goto L_0x0048
            org.spongycastle.pqc.crypto.xmss.LTreeAddress r15 = (org.spongycastle.pqc.crypto.xmss.LTreeAddress) r15
            org.spongycastle.pqc.crypto.xmss.LTreeAddress$Builder r2 = new org.spongycastle.pqc.crypto.xmss.LTreeAddress$Builder
            r2.<init>()
            int r4 = r15.a
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r2 = r2.c(r4)
            org.spongycastle.pqc.crypto.xmss.LTreeAddress$Builder r2 = (org.spongycastle.pqc.crypto.xmss.LTreeAddress.Builder) r2
            long r4 = r15.f6765a
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r2 = r2.d(r4)
            org.spongycastle.pqc.crypto.xmss.LTreeAddress$Builder r2 = (org.spongycastle.pqc.crypto.xmss.LTreeAddress.Builder) r2
            int r4 = r15.d
            r2.d = r4
            int r4 = r15.e
            r2.e = r4
            int r15 = r15.f
            r2.f = r15
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r15 = r2.b(r3)
            org.spongycastle.pqc.crypto.xmss.LTreeAddress$Builder r15 = (org.spongycastle.pqc.crypto.xmss.LTreeAddress.Builder) r15
            r15.getClass()
            org.spongycastle.pqc.crypto.xmss.LTreeAddress r2 = new org.spongycastle.pqc.crypto.xmss.LTreeAddress
            r2.<init>(r15)
        L_0x0046:
            r15 = r2
            goto L_0x007a
        L_0x0048:
            boolean r2 = r15 instanceof org.spongycastle.pqc.crypto.xmss.HashTreeAddress
            if (r2 == 0) goto L_0x007a
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress r15 = (org.spongycastle.pqc.crypto.xmss.HashTreeAddress) r15
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r2 = new org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder
            r2.<init>()
            int r4 = r15.a
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r2 = r2.c(r4)
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r2 = (org.spongycastle.pqc.crypto.xmss.HashTreeAddress.Builder) r2
            long r4 = r15.f6765a
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r2 = r2.d(r4)
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r2 = (org.spongycastle.pqc.crypto.xmss.HashTreeAddress.Builder) r2
            int r4 = r15.d
            r2.d = r4
            int r15 = r15.e
            r2.e = r15
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r15 = r2.b(r3)
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r15 = (org.spongycastle.pqc.crypto.xmss.HashTreeAddress.Builder) r15
            r15.getClass()
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress r2 = new org.spongycastle.pqc.crypto.xmss.HashTreeAddress
            r2.<init>(r15)
            goto L_0x0046
        L_0x007a:
            byte[] r2 = r15.a()
            org.spongycastle.pqc.crypto.xmss.KeyedHashFunctions r4 = r12.a
            byte[] r2 = r4.b(r0, r2)
            boolean r5 = r15 instanceof org.spongycastle.pqc.crypto.xmss.LTreeAddress
            r6 = 1
            if (r5 == 0) goto L_0x00bc
            org.spongycastle.pqc.crypto.xmss.LTreeAddress r15 = (org.spongycastle.pqc.crypto.xmss.LTreeAddress) r15
            org.spongycastle.pqc.crypto.xmss.LTreeAddress$Builder r5 = new org.spongycastle.pqc.crypto.xmss.LTreeAddress$Builder
            r5.<init>()
            int r7 = r15.a
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r5 = r5.c(r7)
            org.spongycastle.pqc.crypto.xmss.LTreeAddress$Builder r5 = (org.spongycastle.pqc.crypto.xmss.LTreeAddress.Builder) r5
            long r7 = r15.f6765a
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r5 = r5.d(r7)
            org.spongycastle.pqc.crypto.xmss.LTreeAddress$Builder r5 = (org.spongycastle.pqc.crypto.xmss.LTreeAddress.Builder) r5
            int r7 = r15.d
            r5.d = r7
            int r7 = r15.e
            r5.e = r7
            int r15 = r15.f
            r5.f = r15
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r15 = r5.b(r6)
            org.spongycastle.pqc.crypto.xmss.LTreeAddress$Builder r15 = (org.spongycastle.pqc.crypto.xmss.LTreeAddress.Builder) r15
            r15.getClass()
            org.spongycastle.pqc.crypto.xmss.LTreeAddress r5 = new org.spongycastle.pqc.crypto.xmss.LTreeAddress
            r5.<init>(r15)
        L_0x00ba:
            r15 = r5
            goto L_0x00ee
        L_0x00bc:
            boolean r5 = r15 instanceof org.spongycastle.pqc.crypto.xmss.HashTreeAddress
            if (r5 == 0) goto L_0x00ee
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress r15 = (org.spongycastle.pqc.crypto.xmss.HashTreeAddress) r15
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r5 = new org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder
            r5.<init>()
            int r7 = r15.a
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r5 = r5.c(r7)
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r5 = (org.spongycastle.pqc.crypto.xmss.HashTreeAddress.Builder) r5
            long r7 = r15.f6765a
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r5 = r5.d(r7)
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r5 = (org.spongycastle.pqc.crypto.xmss.HashTreeAddress.Builder) r5
            int r7 = r15.d
            r5.d = r7
            int r15 = r15.e
            r5.e = r15
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r15 = r5.b(r6)
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r15 = (org.spongycastle.pqc.crypto.xmss.HashTreeAddress.Builder) r15
            r15.getClass()
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress r5 = new org.spongycastle.pqc.crypto.xmss.HashTreeAddress
            r5.<init>(r15)
            goto L_0x00ba
        L_0x00ee:
            byte[] r5 = r15.a()
            byte[] r5 = r4.b(r0, r5)
            boolean r7 = r15 instanceof org.spongycastle.pqc.crypto.xmss.LTreeAddress
            r8 = 2
            if (r7 == 0) goto L_0x012e
            org.spongycastle.pqc.crypto.xmss.LTreeAddress r15 = (org.spongycastle.pqc.crypto.xmss.LTreeAddress) r15
            org.spongycastle.pqc.crypto.xmss.LTreeAddress$Builder r7 = new org.spongycastle.pqc.crypto.xmss.LTreeAddress$Builder
            r7.<init>()
            int r9 = r15.a
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r7 = r7.c(r9)
            org.spongycastle.pqc.crypto.xmss.LTreeAddress$Builder r7 = (org.spongycastle.pqc.crypto.xmss.LTreeAddress.Builder) r7
            long r9 = r15.f6765a
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r7 = r7.d(r9)
            org.spongycastle.pqc.crypto.xmss.LTreeAddress$Builder r7 = (org.spongycastle.pqc.crypto.xmss.LTreeAddress.Builder) r7
            int r9 = r15.d
            r7.d = r9
            int r9 = r15.e
            r7.e = r9
            int r15 = r15.f
            r7.f = r15
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r15 = r7.b(r8)
            org.spongycastle.pqc.crypto.xmss.LTreeAddress$Builder r15 = (org.spongycastle.pqc.crypto.xmss.LTreeAddress.Builder) r15
            r15.getClass()
            org.spongycastle.pqc.crypto.xmss.LTreeAddress r7 = new org.spongycastle.pqc.crypto.xmss.LTreeAddress
            r7.<init>(r15)
        L_0x012c:
            r15 = r7
            goto L_0x0160
        L_0x012e:
            boolean r7 = r15 instanceof org.spongycastle.pqc.crypto.xmss.HashTreeAddress
            if (r7 == 0) goto L_0x0160
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress r15 = (org.spongycastle.pqc.crypto.xmss.HashTreeAddress) r15
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r7 = new org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder
            r7.<init>()
            int r9 = r15.a
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r7 = r7.c(r9)
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r7 = (org.spongycastle.pqc.crypto.xmss.HashTreeAddress.Builder) r7
            long r9 = r15.f6765a
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r7 = r7.d(r9)
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r7 = (org.spongycastle.pqc.crypto.xmss.HashTreeAddress.Builder) r7
            int r9 = r15.d
            r7.d = r9
            int r15 = r15.e
            r7.e = r15
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r15 = r7.b(r8)
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress$Builder r15 = (org.spongycastle.pqc.crypto.xmss.HashTreeAddress.Builder) r15
            r15.getClass()
            org.spongycastle.pqc.crypto.xmss.HashTreeAddress r7 = new org.spongycastle.pqc.crypto.xmss.HashTreeAddress
            r7.<init>(r15)
            goto L_0x012c
        L_0x0160:
            byte[] r15 = r15.a()
            byte[] r15 = r4.b(r0, r15)
            org.spongycastle.pqc.crypto.xmss.WOTSPlusParameters r12 = r12.f6760a
            int r12 = r12.a
            int r0 = r12 * 2
            byte[] r7 = new byte[r0]
            r9 = r3
        L_0x0171:
            if (r9 >= r12) goto L_0x0182
            byte[] r10 = r13.b()
            byte r10 = r10[r9]
            byte r11 = r5[r9]
            r10 = r10 ^ r11
            byte r10 = (byte) r10
            r7[r9] = r10
            int r9 = r9 + 1
            goto L_0x0171
        L_0x0182:
            if (r3 >= r12) goto L_0x0195
            int r13 = r3 + r12
            byte[] r5 = r14.b()
            byte r5 = r5[r3]
            byte r9 = r15[r3]
            r5 = r5 ^ r9
            byte r5 = (byte) r5
            r7[r13] = r5
            int r3 = r3 + 1
            goto L_0x0182
        L_0x0195:
            int r12 = r2.length
            int r13 = r4.a
            if (r12 != r13) goto L_0x01af
            int r13 = r13 * r8
            if (r0 != r13) goto L_0x01a7
            byte[] r12 = r4.c(r2, r6, r7)
            org.spongycastle.pqc.crypto.xmss.XMSSNode r13 = new org.spongycastle.pqc.crypto.xmss.XMSSNode
            r13.<init>(r1, r12)
            return r13
        L_0x01a7:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r13 = "wrong in length"
            r12.<init>(r13)
            throw r12
        L_0x01af:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r13 = "wrong key length"
            r12.<init>(r13)
            throw r12
        L_0x01b7:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "height of both nodes must be equal"
            r12.<init>(r13)
            throw r12
        L_0x01bf:
            java.lang.NullPointerException r12 = new java.lang.NullPointerException
            java.lang.String r13 = "right == null"
            r12.<init>(r13)
            throw r12
        L_0x01c7:
            java.lang.NullPointerException r12 = new java.lang.NullPointerException
            java.lang.String r13 = "left == null"
            r12.<init>(r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.pqc.crypto.xmss.XMSSNodeUtil.b(org.spongycastle.pqc.crypto.xmss.WOTSPlus, org.spongycastle.pqc.crypto.xmss.XMSSNode, org.spongycastle.pqc.crypto.xmss.XMSSNode, org.spongycastle.pqc.crypto.xmss.XMSSAddress):org.spongycastle.pqc.crypto.xmss.XMSSNode");
    }
}
