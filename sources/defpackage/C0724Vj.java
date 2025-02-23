package defpackage;

/* renamed from: Vj  reason: default package and case insensitive filesystem */
/* compiled from: MainDispatchers.kt */
public final class C0724Vj {
    public static final C0682Sj a;

    /* JADX WARNING: type inference failed for: r0v7, types: [N6] */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r3.b();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x006c */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.fast.service.loader"
            int r1 = defpackage.C1121fz.a
            r1 = 0
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch:{ SecurityException -> 0x000a }
            goto L_0x000b
        L_0x000a:
            r0 = r1
        L_0x000b:
            if (r0 == 0) goto L_0x0010
            java.lang.Boolean.parseBoolean(r0)
        L_0x0010:
            java.util.Iterator r0 = defpackage.C0709Uj.l()     // Catch:{ all -> 0x007c }
            java.lang.String r2 = "<this>"
            defpackage.C1177ig.f(r0, r2)     // Catch:{ all -> 0x007c }
            fw r2 = new fw     // Catch:{ all -> 0x007c }
            r2.<init>(r0)     // Catch:{ all -> 0x007c }
            boolean r0 = r2 instanceof defpackage.C0603N6     // Catch:{ all -> 0x007c }
            if (r0 == 0) goto L_0x0023
            goto L_0x0029
        L_0x0023:
            N6 r0 = new N6     // Catch:{ all -> 0x007c }
            r0.<init>(r2)     // Catch:{ all -> 0x007c }
            r2 = r0
        L_0x0029:
            java.util.List r0 = defpackage.C1097ew.Y(r2)     // Catch:{ all -> 0x007c }
            r2 = r0
            java.lang.Iterable r2 = (java.lang.Iterable) r2     // Catch:{ all -> 0x007c }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x007c }
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x007c }
            if (r3 != 0) goto L_0x003c
            r3 = r1
            goto L_0x0063
        L_0x003c:
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x007c }
            boolean r4 = r2.hasNext()     // Catch:{ all -> 0x007c }
            if (r4 != 0) goto L_0x0047
            goto L_0x0063
        L_0x0047:
            r4 = r3
            Tj r4 = (defpackage.C0695Tj) r4     // Catch:{ all -> 0x007c }
            int r4 = r4.c()     // Catch:{ all -> 0x007c }
        L_0x004e:
            java.lang.Object r5 = r2.next()     // Catch:{ all -> 0x007c }
            r6 = r5
            Tj r6 = (defpackage.C0695Tj) r6     // Catch:{ all -> 0x007c }
            int r6 = r6.c()     // Catch:{ all -> 0x007c }
            if (r4 >= r6) goto L_0x005d
            r3 = r5
            r4 = r6
        L_0x005d:
            boolean r5 = r2.hasNext()     // Catch:{ all -> 0x007c }
            if (r5 != 0) goto L_0x004e
        L_0x0063:
            Tj r3 = (defpackage.C0695Tj) r3     // Catch:{ all -> 0x007c }
            if (r3 == 0) goto L_0x0074
            Sj r1 = r3.a(r0)     // Catch:{ all -> 0x006c }
            goto L_0x006f
        L_0x006c:
            r3.b()     // Catch:{ all -> 0x007c }
        L_0x006f:
            if (r1 == 0) goto L_0x0074
            a = r1
            return
        L_0x0074:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x007c }
            java.lang.String r1 = "Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'"
            r0.<init>(r1)     // Catch:{ all -> 0x007c }
            throw r0     // Catch:{ all -> 0x007c }
        L_0x007c:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0724Vj.<clinit>():void");
    }
}
