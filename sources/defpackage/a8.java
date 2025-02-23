package defpackage;

/* renamed from: a8  reason: default package */
/* compiled from: DataMigrationInitializer.kt */
public final class a8<T> {
    public static final a a = new a();

    /* renamed from: a8$a */
    /* compiled from: DataMigrationInitializer.kt */
    public static final class a {
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0043  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x006f  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0096  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0099  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static final java.lang.Object a(defpackage.a8.a r5, java.util.List r6, defpackage.Tf r7, kotlin.coroutines.Continuation r8) {
            /*
                r5.getClass()
                boolean r0 = r8 instanceof defpackage.Y7
                if (r0 == 0) goto L_0x0016
                r0 = r8
                Y7 r0 = (defpackage.Y7) r0
                int r1 = r0.c
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0016
                int r1 = r1 - r2
                r0.c = r1
                goto L_0x001b
            L_0x0016:
                Y7 r0 = new Y7
                r0.<init>(r5, r8)
            L_0x001b:
                java.lang.Object r5 = r0.f710a
                v7 r8 = defpackage.C1438v7.COROUTINE_SUSPENDED
                int r1 = r0.c
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x0043
                if (r1 == r3) goto L_0x003b
                if (r1 != r2) goto L_0x0033
                java.util.Iterator r6 = r0.f711a
                java.io.Serializable r7 = r0.f709a
                Ks r7 = (defpackage.C0571Ks) r7
                defpackage.r1.R(r5)     // Catch:{ all -> 0x0082 }
                goto L_0x0069
            L_0x0033:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L_0x003b:
                java.io.Serializable r6 = r0.f709a
                java.util.List r6 = (java.util.List) r6
                defpackage.r1.R(r5)
                goto L_0x005d
            L_0x0043:
                defpackage.r1.R(r5)
                java.util.ArrayList r5 = new java.util.ArrayList
                r5.<init>()
                Z7 r1 = new Z7
                r4 = 0
                r1.<init>(r6, r5, r4)
                r0.f709a = r5
                r0.c = r3
                java.lang.Object r6 = r7.a(r1, r0)
                if (r6 != r8) goto L_0x005c
                goto L_0x0098
            L_0x005c:
                r6 = r5
            L_0x005d:
                Ks r5 = new Ks
                r5.<init>()
                java.lang.Iterable r6 = (java.lang.Iterable) r6
                java.util.Iterator r6 = r6.iterator()
                r7 = r5
            L_0x0069:
                boolean r5 = r6.hasNext()
                if (r5 == 0) goto L_0x0090
                java.lang.Object r5 = r6.next()
                kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
                r0.f709a = r7     // Catch:{ all -> 0x0082 }
                r0.f711a = r6     // Catch:{ all -> 0x0082 }
                r0.c = r2     // Catch:{ all -> 0x0082 }
                java.lang.Object r5 = r5.invoke(r0)     // Catch:{ all -> 0x0082 }
                if (r5 != r8) goto L_0x0069
                goto L_0x0098
            L_0x0082:
                r5 = move-exception
                T r1 = r7.a
                if (r1 != 0) goto L_0x008a
                r7.a = r5
                goto L_0x0069
            L_0x008a:
                java.lang.Throwable r1 = (java.lang.Throwable) r1
                defpackage.C1354qp.g(r1, r5)
                goto L_0x0069
            L_0x0090:
                T r5 = r7.a
                java.lang.Throwable r5 = (java.lang.Throwable) r5
                if (r5 != 0) goto L_0x0099
                kotlin.Unit r8 = kotlin.Unit.a
            L_0x0098:
                return r8
            L_0x0099:
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.a8.a.a(a8$a, java.util.List, Tf, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }
}
