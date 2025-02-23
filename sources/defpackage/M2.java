package defpackage;

import androidx.biometric.d;
import androidx.lifecycle.Observer;

/* renamed from: M2  reason: default package */
/* compiled from: BiometricFragment */
public final class M2 implements Observer<L2> {
    public final /* synthetic */ d a;

    public M2(d dVar) {
        this.a = dVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x009e, code lost:
        if (r9 != false) goto L_0x00a3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.Object r9) {
        /*
            r8 = this;
            L2 r9 = (defpackage.L2) r9
            if (r9 == 0) goto L_0x00d2
            androidx.biometric.d r0 = r8.a
            r0.getClass()
            r1 = 0
            int r2 = r9.a
            r3 = 1
            switch(r2) {
                case 1: goto L_0x0012;
                case 2: goto L_0x0012;
                case 3: goto L_0x0012;
                case 4: goto L_0x0012;
                case 5: goto L_0x0012;
                case 6: goto L_0x0010;
                case 7: goto L_0x0012;
                case 8: goto L_0x0012;
                case 9: goto L_0x0012;
                case 10: goto L_0x0012;
                case 11: goto L_0x0012;
                case 12: goto L_0x0012;
                case 13: goto L_0x0012;
                case 14: goto L_0x0012;
                case 15: goto L_0x0012;
                default: goto L_0x0010;
            }
        L_0x0010:
            r4 = r1
            goto L_0x0013
        L_0x0012:
            r4 = r3
        L_0x0013:
            if (r4 == 0) goto L_0x0016
            goto L_0x0018
        L_0x0016:
            r2 = 8
        L_0x0018:
            android.content.Context r4 = r0.getContext()
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 29
            if (r5 >= r6) goto L_0x0050
            r6 = 7
            if (r2 == r6) goto L_0x002c
            r6 = 9
            if (r2 != r6) goto L_0x002a
            goto L_0x002c
        L_0x002a:
            r6 = r1
            goto L_0x002d
        L_0x002c:
            r6 = r3
        L_0x002d:
            if (r6 == 0) goto L_0x0050
            if (r4 == 0) goto L_0x0050
            android.app.KeyguardManager r4 = defpackage.Fh.a(r4)
            if (r4 != 0) goto L_0x0039
            r4 = r1
            goto L_0x003d
        L_0x0039:
            boolean r4 = defpackage.Fh.b(r4)
        L_0x003d:
            if (r4 == 0) goto L_0x0050
            androidx.biometric.j r4 = r0.f1290a
            int r4 = r4.c()
            boolean r4 = androidx.biometric.c.a(r4)
            if (r4 == 0) goto L_0x0050
            r0.j()
            goto L_0x00cc
        L_0x0050:
            boolean r4 = r0.i()
            java.lang.CharSequence r9 = r9.f381a
            if (r4 == 0) goto L_0x00ac
            if (r9 == 0) goto L_0x005b
            goto L_0x0063
        L_0x005b:
            android.content.Context r9 = r0.getContext()
            java.lang.String r9 = defpackage.C1354qp.O(r9, r2)
        L_0x0063:
            r4 = 5
            if (r2 != r4) goto L_0x0076
            androidx.biometric.j r1 = r0.f1290a
            int r1 = r1.a
            if (r1 == 0) goto L_0x006f
            r3 = 3
            if (r1 != r3) goto L_0x0072
        L_0x006f:
            r0.l(r2, r9)
        L_0x0072:
            r0.dismiss()
            goto L_0x00cc
        L_0x0076:
            androidx.biometric.j r4 = r0.f1290a
            boolean r4 = r4.f1308g
            if (r4 == 0) goto L_0x0080
            r0.k(r2, r9)
            goto L_0x00a7
        L_0x0080:
            r0.m(r9)
            android.os.Handler r4 = r0.a
            S2 r6 = new S2
            r6.<init>(r0, r2, r9)
            android.content.Context r9 = r0.getContext()
            if (r9 == 0) goto L_0x00a1
            java.lang.String r2 = android.os.Build.MODEL
            r7 = 28
            if (r5 == r7) goto L_0x0098
            r9 = r1
            goto L_0x009e
        L_0x0098:
            int r5 = defpackage.Zq.hide_fingerprint_instantly_prefixes
            boolean r9 = defpackage.R8.b(r9, r5, r2)
        L_0x009e:
            if (r9 == 0) goto L_0x00a1
            goto L_0x00a3
        L_0x00a1:
            r1 = 2000(0x7d0, float:2.803E-42)
        L_0x00a3:
            long r1 = (long) r1
            r4.postDelayed(r6, r1)
        L_0x00a7:
            androidx.biometric.j r9 = r0.f1290a
            r9.f1308g = r3
            goto L_0x00cc
        L_0x00ac:
            if (r9 == 0) goto L_0x00af
            goto L_0x00c9
        L_0x00af:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            int r1 = defpackage.Wr.default_error_msg
            java.lang.String r1 = r0.getString(r1)
            r9.append(r1)
            java.lang.String r1 = " "
            r9.append(r1)
            r9.append(r2)
            java.lang.String r9 = r9.toString()
        L_0x00c9:
            r0.k(r2, r9)
        L_0x00cc:
            androidx.biometric.j r9 = r0.f1290a
            r0 = 0
            r9.e(r0)
        L_0x00d2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.M2.a(java.lang.Object):void");
    }
}
