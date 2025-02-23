package defpackage;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import defpackage.C0218ho;
import java.util.HashSet;

/* renamed from: Fa  reason: default package */
/* compiled from: EnqueueRunnable */
public final class Fa implements Runnable {
    public final ND a;

    /* renamed from: a  reason: collision with other field name */
    public final io f203a = new io();

    static {
        zi.e("EnqueueRunnable");
    }

    public Fa(ND nd) {
        this.a = nd;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01d9, code lost:
        r3.a(((defpackage.C0214hE.a) r4.next()).f2998a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01e5, code lost:
        r16 = false;
        r17 = false;
        r9 = java.util.Collections.emptyList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01c3, code lost:
        if (r17 != false) goto L_0x01c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01c5, code lost:
        r3 = (defpackage.C0236jE) r8.n();
        r4 = r3.j(r2).iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01d7, code lost:
        if (r4.hasNext() == false) goto L_0x01e5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x01a7 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x018e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(defpackage.ND r25) {
        /*
            r0 = r25
            java.util.List<ND> r1 = r0.f447b
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x003e
            java.util.Iterator r1 = r1.iterator()
            r4 = r3
        L_0x000d:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x003f
            java.lang.Object r5 = r1.next()
            ND r5 = (defpackage.ND) r5
            boolean r6 = r5.f446a
            if (r6 != 0) goto L_0x0023
            boolean r5 = a(r5)
            r4 = r4 | r5
            goto L_0x000d
        L_0x0023:
            zi r6 = defpackage.zi.c()
            java.lang.Object[] r7 = new java.lang.Object[r2]
            java.util.ArrayList r5 = r5.f444a
            java.lang.String r8 = ", "
            java.lang.String r5 = android.text.TextUtils.join(r8, r5)
            r7[r3] = r5
            java.lang.String r5 = "Already enqueued work ids (%s)."
            java.lang.String.format(r5, r7)
            java.lang.Throwable[] r5 = new java.lang.Throwable[r3]
            r6.f(r5)
            goto L_0x000d
        L_0x003e:
            r4 = r3
        L_0x003f:
            java.util.HashSet r1 = defpackage.ND.e(r25)
            java.lang.String[] r5 = new java.lang.String[r3]
            java.lang.Object[] r1 = r1.toArray(r5)
            java.lang.String[] r1 = (java.lang.String[]) r1
            long r5 = java.lang.System.currentTimeMillis()
            VD r7 = r0.f441a
            androidx.work.impl.WorkDatabase r8 = r7.f594a
            if (r1 == 0) goto L_0x005a
            int r9 = r1.length
            if (r9 <= 0) goto L_0x005a
            r9 = r2
            goto L_0x005b
        L_0x005a:
            r9 = r3
        L_0x005b:
            UD r10 = defpackage.UD.SUCCEEDED
            UD r11 = defpackage.UD.CANCELLED
            UD r12 = defpackage.UD.FAILED
            if (r9 == 0) goto L_0x00aa
            int r13 = r1.length
            r15 = r2
            r14 = r3
            r16 = r14
            r17 = r16
        L_0x006a:
            if (r14 >= r13) goto L_0x00af
            r3 = r1[r14]
            iE r18 = r8.n()
            r2 = r18
            jE r2 = (defpackage.C0236jE) r2
            hE r2 = r2.i(r3)
            if (r2 != 0) goto L_0x0094
            zi r1 = defpackage.zi.c()
            r2 = 1
            java.lang.Object[] r5 = new java.lang.Object[r2]
            r2 = 0
            r5[r2] = r3
            java.lang.String r3 = "Prerequisite %s doesn't exist; not enqueuing"
            java.lang.String.format(r3, r5)
            java.lang.Throwable[] r3 = new java.lang.Throwable[r2]
            r1.b(r3)
            r20 = r4
            goto L_0x00fc
        L_0x0094:
            UD r2 = r2.f2989a
            if (r2 != r10) goto L_0x009a
            r3 = 1
            goto L_0x009b
        L_0x009a:
            r3 = 0
        L_0x009b:
            r15 = r15 & r3
            if (r2 != r12) goto L_0x00a1
            r17 = 1
            goto L_0x00a5
        L_0x00a1:
            if (r2 != r11) goto L_0x00a5
            r16 = 1
        L_0x00a5:
            int r14 = r14 + 1
            r2 = 1
            r3 = 0
            goto L_0x006a
        L_0x00aa:
            r15 = 1
            r16 = 0
            r17 = 0
        L_0x00af:
            java.lang.String r2 = r0.f443a
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            r13 = 1
            r3 = r3 ^ r13
            if (r3 == 0) goto L_0x00bd
            if (r9 != 0) goto L_0x00bd
            r13 = 1
            goto L_0x00be
        L_0x00bd:
            r13 = 0
        L_0x00be:
            UD r14 = defpackage.UD.ENQUEUED
            if (r13 == 0) goto L_0x01fb
            iE r13 = r8.n()
            jE r13 = (defpackage.C0236jE) r13
            java.util.ArrayList r13 = r13.j(r2)
            boolean r18 = r13.isEmpty()
            if (r18 != 0) goto L_0x01fb
            r18 = r9
            r9 = 3
            r19 = r15
            r15 = 4
            r20 = r4
            int r4 = r0.a
            if (r4 == r9) goto L_0x0131
            if (r4 != r15) goto L_0x00e1
            goto L_0x0131
        L_0x00e1:
            r9 = 2
            if (r4 != r9) goto L_0x0100
            java.util.Iterator r4 = r13.iterator()
        L_0x00e8:
            boolean r9 = r4.hasNext()
            if (r9 == 0) goto L_0x0100
            java.lang.Object r9 = r4.next()
            hE$a r9 = (defpackage.C0214hE.a) r9
            UD r9 = r9.a
            if (r9 == r14) goto L_0x00fc
            UD r10 = defpackage.UD.RUNNING
            if (r9 != r10) goto L_0x00e8
        L_0x00fc:
            r1 = 1
            r3 = 0
            goto L_0x031e
        L_0x0100:
            s4 r4 = new s4
            r4.<init>(r7, r2)
            r4.run()
            iE r4 = r8.n()
            java.util.Iterator r7 = r13.iterator()
        L_0x0110:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x0125
            java.lang.Object r9 = r7.next()
            hE$a r9 = (defpackage.C0214hE.a) r9
            java.lang.String r9 = r9.f2998a
            r10 = r4
            jE r10 = (defpackage.C0236jE) r10
            r10.a(r9)
            goto L_0x0110
        L_0x0125:
            r22 = r3
            r24 = r14
            r9 = r18
            r15 = r19
            r3 = 1
            r13 = 0
            goto L_0x020b
        L_0x0131:
            K8 r7 = r8.i()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.Iterator r13 = r13.iterator()
        L_0x013e:
            boolean r18 = r13.hasNext()
            if (r18 == 0) goto L_0x01b9
            java.lang.Object r18 = r13.next()
            r15 = r18
            hE$a r15 = (defpackage.C0214hE.a) r15
            r18 = r13
            java.lang.String r13 = r15.f2998a
            r22 = r3
            r3 = r7
            L8 r3 = (defpackage.L8) r3
            r3.getClass()
            r23 = r7
            java.lang.String r7 = "SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?"
            r24 = r14
            r14 = 1
            bu r7 = defpackage.bu.c(r14, r7)
            if (r13 != 0) goto L_0x0169
            r7.h(r14)
            goto L_0x016c
        L_0x0169:
            r7.j(r14, r13)
        L_0x016c:
            Zt r3 = r3.f383a
            r3.b()
            android.database.Cursor r3 = r3.g(r7)
            boolean r13 = r3.moveToFirst()     // Catch:{ all -> 0x01b1 }
            if (r13 == 0) goto L_0x0184
            r13 = 0
            int r14 = r3.getInt(r13)     // Catch:{ all -> 0x01b1 }
            if (r14 == 0) goto L_0x0185
            r14 = 1
            goto L_0x0186
        L_0x0184:
            r13 = 0
        L_0x0185:
            r14 = r13
        L_0x0186:
            r3.close()
            r7.release()
            if (r14 != 0) goto L_0x01a7
            UD r3 = r15.a
            if (r3 != r10) goto L_0x0194
            r7 = 1
            goto L_0x0195
        L_0x0194:
            r7 = r13
        L_0x0195:
            r7 = r7 & r19
            if (r3 != r12) goto L_0x019c
            r17 = 1
            goto L_0x01a0
        L_0x019c:
            if (r3 != r11) goto L_0x01a0
            r16 = 1
        L_0x01a0:
            java.lang.String r3 = r15.f2998a
            r9.add(r3)
            r19 = r7
        L_0x01a7:
            r13 = r18
            r3 = r22
            r7 = r23
            r14 = r24
            r15 = 4
            goto L_0x013e
        L_0x01b1:
            r0 = move-exception
            r3.close()
            r7.release()
            throw r0
        L_0x01b9:
            r22 = r3
            r24 = r14
            r3 = r15
            r13 = 0
            if (r4 != r3) goto L_0x01ed
            if (r16 != 0) goto L_0x01c5
            if (r17 == 0) goto L_0x01ed
        L_0x01c5:
            iE r3 = r8.n()
            jE r3 = (defpackage.C0236jE) r3
            java.util.ArrayList r4 = r3.j(r2)
            java.util.Iterator r4 = r4.iterator()
        L_0x01d3:
            boolean r7 = r4.hasNext()
            if (r7 == 0) goto L_0x01e5
            java.lang.Object r7 = r4.next()
            hE$a r7 = (defpackage.C0214hE.a) r7
            java.lang.String r7 = r7.f2998a
            r3.a(r7)
            goto L_0x01d3
        L_0x01e5:
            java.util.List r9 = java.util.Collections.emptyList()
            r16 = r13
            r17 = r16
        L_0x01ed:
            java.lang.Object[] r1 = r9.toArray(r1)
            java.lang.String[] r1 = (java.lang.String[]) r1
            int r3 = r1.length
            if (r3 <= 0) goto L_0x01f8
            r9 = 1
            goto L_0x01f9
        L_0x01f8:
            r9 = r13
        L_0x01f9:
            r3 = r13
            goto L_0x0209
        L_0x01fb:
            r22 = r3
            r20 = r4
            r18 = r9
            r24 = r14
            r19 = r15
            r13 = 0
            r3 = r13
            r9 = r18
        L_0x0209:
            r15 = r19
        L_0x020b:
            java.util.List<? extends gE> r4 = r0.f445a
            java.util.Iterator r4 = r4.iterator()
        L_0x0211:
            boolean r7 = r4.hasNext()
            if (r7 == 0) goto L_0x031d
            java.lang.Object r7 = r4.next()
            gE r7 = (defpackage.C0202gE) r7
            hE r10 = r7.a
            if (r9 == 0) goto L_0x0232
            if (r15 != 0) goto L_0x0232
            if (r17 == 0) goto L_0x0228
            r10.f2989a = r12
            goto L_0x023f
        L_0x0228:
            if (r16 == 0) goto L_0x022d
            r10.f2989a = r11
            goto L_0x023f
        L_0x022d:
            UD r14 = defpackage.UD.BLOCKED
            r10.f2989a = r14
            goto L_0x023f
        L_0x0232:
            boolean r14 = r10.c()
            if (r14 != 0) goto L_0x023b
            r10.e = r5
            goto L_0x023f
        L_0x023b:
            r13 = 0
            r10.e = r13
        L_0x023f:
            UD r13 = r10.f2989a
            r14 = r24
            if (r13 != r14) goto L_0x0246
            r3 = 1
        L_0x0246:
            iE r13 = r8.n()
            jE r13 = (defpackage.C0236jE) r13
            r18 = r3
            Zt r3 = r13.a
            r3.b()
            r3.c()
            jE$a r13 = r13.f3025a     // Catch:{ all -> 0x0318 }
            r13.e(r10)     // Catch:{ all -> 0x0318 }
            r3.h()     // Catch:{ all -> 0x0318 }
            r3.f()
            java.util.UUID r3 = r7.f2964a
            if (r9 == 0) goto L_0x02a1
            int r10 = r1.length
            r13 = 0
        L_0x0267:
            if (r13 >= r10) goto L_0x02a1
            r19 = r4
            r4 = r1[r13]
            r21 = r1
            I8 r1 = new I8
            r23 = r5
            java.lang.String r5 = r3.toString()
            r1.<init>(r5, r4)
            K8 r4 = r8.i()
            L8 r4 = (defpackage.L8) r4
            Zt r5 = r4.f383a
            r5.b()
            r5.c()
            L8$a r4 = r4.a     // Catch:{ all -> 0x029c }
            r4.e(r1)     // Catch:{ all -> 0x029c }
            r5.h()     // Catch:{ all -> 0x029c }
            r5.f()
            int r13 = r13 + 1
            r4 = r19
            r1 = r21
            r5 = r23
            goto L_0x0267
        L_0x029c:
            r0 = move-exception
            r5.f()
            throw r0
        L_0x02a1:
            r21 = r1
            r19 = r4
            r23 = r5
            java.util.Set<java.lang.String> r1 = r7.f2963a
            java.util.Iterator r1 = r1.iterator()
        L_0x02ad:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x02e1
            java.lang.Object r4 = r1.next()
            java.lang.String r4 = (java.lang.String) r4
            lE r5 = r8.o()
            kE r6 = new kE
            java.lang.String r7 = r3.toString()
            r6.<init>(r4, r7)
            mE r5 = (defpackage.mE) r5
            Zt r4 = r5.a
            r4.b()
            r4.c()
            mE$a r5 = r5.f3099a     // Catch:{ all -> 0x02dc }
            r5.e(r6)     // Catch:{ all -> 0x02dc }
            r4.h()     // Catch:{ all -> 0x02dc }
            r4.f()
            goto L_0x02ad
        L_0x02dc:
            r0 = move-exception
            r4.f()
            throw r0
        L_0x02e1:
            if (r22 == 0) goto L_0x030b
            YD r1 = r8.l()
            XD r4 = new XD
            java.lang.String r3 = r3.toString()
            r4.<init>(r2, r3)
            ZD r1 = (defpackage.ZD) r1
            Zt r3 = r1.f761a
            r3.b()
            r3.c()
            ZD$a r1 = r1.a     // Catch:{ all -> 0x0306 }
            r1.e(r4)     // Catch:{ all -> 0x0306 }
            r3.h()     // Catch:{ all -> 0x0306 }
            r3.f()
            goto L_0x030b
        L_0x0306:
            r0 = move-exception
            r3.f()
            throw r0
        L_0x030b:
            r3 = r18
            r4 = r19
            r1 = r21
            r5 = r23
            r13 = 0
            r24 = r14
            goto L_0x0211
        L_0x0318:
            r0 = move-exception
            r3.f()
            throw r0
        L_0x031d:
            r1 = 1
        L_0x031e:
            r0.f446a = r1
            r0 = r20 | r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Fa.a(ND):boolean");
    }

    public final void run() {
        WorkDatabase workDatabase;
        io ioVar = this.f203a;
        ND nd = this.a;
        try {
            nd.getClass();
            VD vd = nd.f441a;
            if (!ND.d(nd, new HashSet())) {
                workDatabase = vd.f594a;
                workDatabase.c();
                boolean a2 = a(nd);
                workDatabase.h();
                workDatabase.f();
                if (a2) {
                    wo.a(vd.f592a, RescheduleReceiver.class, true);
                    jv.a(vd.f593a, vd.f594a, vd.f597a);
                }
                ioVar.a(C0218ho.f3000a);
                return;
            }
            throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", new Object[]{nd}));
        } catch (Throwable th) {
            ioVar.a(new C0218ho.a.C0031a(th));
        }
    }
}
