package defpackage;

import java.security.Key;

/* renamed from: h9  reason: default package and case insensitive filesystem */
/* compiled from: DirectKeyManagementAlgorithm */
public final class C1150h9 extends C1379s0 implements C1387sh {
    public C1150h9() {
        this.f6950a = "dir";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r5 = r5.getEncoded().length;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.security.Key r5, defpackage.X6 r6) throws defpackage.C1259mg {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x0056
            byte[] r0 = r5.getEncoded()
            if (r0 == 0) goto L_0x0055
            byte[] r5 = r5.getEncoded()
            int r5 = r5.length
            Qp r0 = r6.h()
            int r0 = r0.b
            if (r0 != r5) goto L_0x0016
            goto L_0x0055
        L_0x0016:
            mg r1 = new mg
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Invalid key for "
            r2.<init>(r3)
            java.lang.String r3 = r4.f6950a
            r2.append(r3)
            java.lang.String r3 = " with "
            r2.append(r3)
            java.lang.String r6 = r6.e()
            r2.append(r6)
            java.lang.String r6 = ", expected a "
            r2.append(r6)
            int r6 = defpackage.C1354qp.l(r0)
            r2.append(r6)
            java.lang.String r6 = " bit key but a "
            r2.append(r6)
            int r5 = defpackage.C1354qp.l(r5)
            r2.append(r5)
            java.lang.String r5 = " bit key was provided."
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            r1.<init>(r5)
            throw r1
        L_0x0055:
            return
        L_0x0056:
            mg r5 = new mg
            java.lang.String r6 = "The key must not be null."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1150h9.a(java.security.Key, X6):void");
    }

    public final boolean b() {
        return true;
    }

    public final ng g(Key key, Qp qp, C0638Pe pe, byte[] bArr, Nq nq) throws C0626Og {
        C1354qp.p(this.f6950a, bArr);
        return new ng(key.getEncoded(), C1354qp.f6923b);
    }
}
