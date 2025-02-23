package org.spongycastle.pqc.crypto.xmss;

import java.io.Serializable;
import java.util.TreeMap;

public class BDSStateMap implements Serializable {
    public final TreeMap a = new TreeMap();

    public BDSStateMap() {
    }

    public final BDS a(int i) {
        return (BDS) this.a.get(Integer.valueOf(i));
    }

    public final void b(int i, byte[] bArr, byte[] bArr2, OTSHashAddress oTSHashAddress) {
        Integer valueOf = Integer.valueOf(i);
        Integer valueOf2 = Integer.valueOf(i);
        TreeMap treeMap = this.a;
        BDS bds = (BDS) treeMap.get(valueOf2);
        bds.getClass();
        BDS bds2 = (BDS) treeMap.put(valueOf, new BDS(bds, bArr, bArr2, oTSHashAddress));
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a9 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(org.spongycastle.pqc.crypto.xmss.XMSSMTParameters r24, long r25, byte[] r27, byte[] r28) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            r4 = r27
            r5 = r28
            org.spongycastle.pqc.crypto.xmss.XMSSParameters r6 = r1.f6770a
            int r7 = r6.a
            long r8 = r2 >> r7
            int r10 = org.spongycastle.pqc.crypto.xmss.XMSSUtil.f(r7, r2)
            org.spongycastle.pqc.crypto.xmss.OTSHashAddress$Builder r11 = new org.spongycastle.pqc.crypto.xmss.OTSHashAddress$Builder
            r11.<init>()
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r11 = r11.d(r8)
            org.spongycastle.pqc.crypto.xmss.OTSHashAddress$Builder r11 = (org.spongycastle.pqc.crypto.xmss.OTSHashAddress.Builder) r11
            r11.d = r10
            org.spongycastle.pqc.crypto.xmss.OTSHashAddress r12 = new org.spongycastle.pqc.crypto.xmss.OTSHashAddress
            r12.<init>(r11)
            r11 = 1
            int r13 = r11 << r7
            int r14 = r13 + -1
            java.util.TreeMap r15 = r0.a
            r11 = 0
            if (r10 >= r14) goto L_0x0047
            org.spongycastle.pqc.crypto.xmss.BDS r16 = r0.a(r11)
            if (r16 == 0) goto L_0x0038
            if (r10 != 0) goto L_0x0044
        L_0x0038:
            org.spongycastle.pqc.crypto.xmss.BDS r10 = new org.spongycastle.pqc.crypto.xmss.BDS
            r10.<init>((org.spongycastle.pqc.crypto.xmss.XMSSParameters) r6, (byte[]) r4, (byte[]) r5, (org.spongycastle.pqc.crypto.xmss.OTSHashAddress) r12)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r11)
            r15.put(r6, r10)
        L_0x0044:
            r0.b(r11, r4, r5, r12)
        L_0x0047:
            r6 = 1
        L_0x0048:
            int r10 = r1.b
            if (r6 >= r10) goto L_0x00b2
            int r10 = org.spongycastle.pqc.crypto.xmss.XMSSUtil.f(r7, r8)
            long r8 = r8 >> r7
            org.spongycastle.pqc.crypto.xmss.OTSHashAddress$Builder r12 = new org.spongycastle.pqc.crypto.xmss.OTSHashAddress$Builder
            r12.<init>()
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r12 = r12.c(r6)
            org.spongycastle.pqc.crypto.xmss.OTSHashAddress$Builder r12 = (org.spongycastle.pqc.crypto.xmss.OTSHashAddress.Builder) r12
            org.spongycastle.pqc.crypto.xmss.XMSSAddress$Builder r12 = r12.d(r8)
            org.spongycastle.pqc.crypto.xmss.OTSHashAddress$Builder r12 = (org.spongycastle.pqc.crypto.xmss.OTSHashAddress.Builder) r12
            r12.d = r10
            org.spongycastle.pqc.crypto.xmss.OTSHashAddress r11 = new org.spongycastle.pqc.crypto.xmss.OTSHashAddress
            r11.<init>(r12)
            if (r10 >= r14) goto L_0x00a6
            r17 = 0
            int r10 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r10 != 0) goto L_0x0075
            r10 = r7
            r21 = r8
            goto L_0x008b
        L_0x0075:
            r19 = 1
            long r19 = r2 + r19
            double r2 = (double) r13
            r10 = r7
            r21 = r8
            double r7 = (double) r6
            double r2 = java.lang.Math.pow(r2, r7)
            long r2 = (long) r2
            long r19 = r19 % r2
            int r2 = (r19 > r17 ? 1 : (r19 == r17 ? 0 : -1))
            if (r2 != 0) goto L_0x008b
            r2 = 1
            goto L_0x008c
        L_0x008b:
            r2 = 0
        L_0x008c:
            if (r2 == 0) goto L_0x00a9
            org.spongycastle.pqc.crypto.xmss.BDS r2 = r0.a(r6)
            if (r2 != 0) goto L_0x00a2
            org.spongycastle.pqc.crypto.xmss.BDS r2 = new org.spongycastle.pqc.crypto.xmss.BDS
            org.spongycastle.pqc.crypto.xmss.XMSSParameters r3 = r1.f6770a
            r2.<init>((org.spongycastle.pqc.crypto.xmss.XMSSParameters) r3, (byte[]) r4, (byte[]) r5, (org.spongycastle.pqc.crypto.xmss.OTSHashAddress) r11)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)
            r15.put(r3, r2)
        L_0x00a2:
            r0.b(r6, r4, r5, r11)
            goto L_0x00a9
        L_0x00a6:
            r10 = r7
            r21 = r8
        L_0x00a9:
            int r6 = r6 + 1
            r2 = r25
            r7 = r10
            r8 = r21
            r11 = 0
            goto L_0x0048
        L_0x00b2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.pqc.crypto.xmss.BDSStateMap.c(org.spongycastle.pqc.crypto.xmss.XMSSMTParameters, long, byte[], byte[]):void");
    }

    public BDSStateMap(XMSSMTParameters xMSSMTParameters, long j, byte[] bArr, byte[] bArr2) {
        for (long j2 = 0; j2 < j; j2++) {
            c(xMSSMTParameters, j2, bArr, bArr2);
        }
    }

    public BDSStateMap(BDSStateMap bDSStateMap, XMSSMTParameters xMSSMTParameters, long j, byte[] bArr, byte[] bArr2) {
        for (Integer num : bDSStateMap.a.keySet()) {
            this.a.put(num, bDSStateMap.a.get(num));
        }
        c(xMSSMTParameters, j, bArr, bArr2);
    }
}
