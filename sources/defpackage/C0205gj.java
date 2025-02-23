package defpackage;

import android.content.Context;
import java.util.concurrent.Callable;

/* renamed from: gj  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0205gj implements Callable {
    public final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f2970a;
    public final /* synthetic */ String b;

    public /* synthetic */ C0205gj(Context context, String str, String str2) {
        this.a = context;
        this.f2970a = str;
        this.b = str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00c8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object call() {
        /*
            r11 = this;
            android.content.Context r0 = r11.a
            java.lang.String r1 = r11.f2970a
            java.lang.String r2 = r11.b
            zm r3 = defpackage.C1354qp.f6915a
            if (r3 != 0) goto L_0x0043
            java.lang.Class<zm> r4 = defpackage.C0427zm.class
            monitor-enter(r4)
            zm r3 = defpackage.C1354qp.f6915a     // Catch:{ all -> 0x0040 }
            if (r3 != 0) goto L_0x003e
            zm r3 = new zm     // Catch:{ all -> 0x0040 }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ all -> 0x0040 }
            xm r5 = defpackage.C1354qp.f6913a     // Catch:{ all -> 0x0040 }
            if (r5 != 0) goto L_0x0034
            java.lang.Class<xm> r5 = defpackage.C0397xm.class
            monitor-enter(r5)     // Catch:{ all -> 0x0040 }
            xm r6 = defpackage.C1354qp.f6913a     // Catch:{ all -> 0x0031 }
            if (r6 != 0) goto L_0x002e
            xm r6 = new xm     // Catch:{ all -> 0x0031 }
            Kh r7 = new Kh     // Catch:{ all -> 0x0031 }
            r7.<init>(r0)     // Catch:{ all -> 0x0031 }
            r6.<init>(r7)     // Catch:{ all -> 0x0031 }
            defpackage.C1354qp.f6913a = r6     // Catch:{ all -> 0x0031 }
        L_0x002e:
            monitor-exit(r5)     // Catch:{ all -> 0x0031 }
            r5 = r6
            goto L_0x0034
        L_0x0031:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0031 }
            throw r0     // Catch:{ all -> 0x0040 }
        L_0x0034:
            qp r0 = new qp     // Catch:{ all -> 0x0040 }
            r0.<init>()     // Catch:{ all -> 0x0040 }
            r3.<init>(r5, r0)     // Catch:{ all -> 0x0040 }
            defpackage.C1354qp.f6915a = r3     // Catch:{ all -> 0x0040 }
        L_0x003e:
            monitor-exit(r4)     // Catch:{ all -> 0x0040 }
            goto L_0x0043
        L_0x0040:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0040 }
            throw r0
        L_0x0043:
            gc r0 = defpackage.C0203gc.ZIP
            r4 = 0
            r5 = 0
            if (r2 != 0) goto L_0x004b
            goto L_0x00bf
        L_0x004b:
            xm r6 = r3.f3487a
            r6.getClass()
            java.io.File r7 = new java.io.File     // Catch:{ FileNotFoundException -> 0x009c }
            java.io.File r8 = r6.b()     // Catch:{ FileNotFoundException -> 0x009c }
            gc r9 = defpackage.C0203gc.JSON     // Catch:{ FileNotFoundException -> 0x009c }
            java.lang.String r10 = defpackage.C0397xm.a(r1, r9, r4)     // Catch:{ FileNotFoundException -> 0x009c }
            r7.<init>(r8, r10)     // Catch:{ FileNotFoundException -> 0x009c }
            boolean r8 = r7.exists()     // Catch:{ FileNotFoundException -> 0x009c }
            if (r8 == 0) goto L_0x0066
            goto L_0x007b
        L_0x0066:
            java.io.File r7 = new java.io.File     // Catch:{ FileNotFoundException -> 0x009c }
            java.io.File r6 = r6.b()     // Catch:{ FileNotFoundException -> 0x009c }
            java.lang.String r8 = defpackage.C0397xm.a(r1, r0, r4)     // Catch:{ FileNotFoundException -> 0x009c }
            r7.<init>(r6, r8)     // Catch:{ FileNotFoundException -> 0x009c }
            boolean r6 = r7.exists()     // Catch:{ FileNotFoundException -> 0x009c }
            if (r6 == 0) goto L_0x007a
            goto L_0x007b
        L_0x007a:
            r7 = r5
        L_0x007b:
            if (r7 != 0) goto L_0x007e
            goto L_0x009c
        L_0x007e:
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x009c }
            r6.<init>(r7)     // Catch:{ FileNotFoundException -> 0x009c }
            java.lang.String r8 = r7.getAbsolutePath()
            java.lang.String r10 = ".zip"
            boolean r8 = r8.endsWith(r10)
            if (r8 == 0) goto L_0x0090
            r9 = r0
        L_0x0090:
            r7.getAbsolutePath()
            defpackage.Ai.a()
            android.util.Pair r7 = new android.util.Pair
            r7.<init>(r9, r6)
            goto L_0x009d
        L_0x009c:
            r7 = r5
        L_0x009d:
            if (r7 != 0) goto L_0x00a0
            goto L_0x00bf
        L_0x00a0:
            java.lang.Object r6 = r7.first
            gc r6 = (defpackage.C0203gc) r6
            java.lang.Object r7 = r7.second
            java.io.InputStream r7 = (java.io.InputStream) r7
            if (r6 != r0) goto L_0x00b4
            java.util.zip.ZipInputStream r0 = new java.util.zip.ZipInputStream
            r0.<init>(r7)
            Lj r0 = defpackage.C0281nj.f(r0, r1)
            goto L_0x00b8
        L_0x00b4:
            Lj r0 = defpackage.C0281nj.c(r7, r1)
        L_0x00b8:
            V r0 = r0.a
            if (r0 == 0) goto L_0x00bf
            ej r0 = (defpackage.C0181ej) r0
            goto L_0x00c0
        L_0x00bf:
            r0 = r5
        L_0x00c0:
            if (r0 == 0) goto L_0x00c8
            Lj r1 = new Lj
            r1.<init>((defpackage.C0181ej) r0)
            goto L_0x0123
        L_0x00c8:
            defpackage.Ai.a()
            java.lang.String r0 = "LottieFetchResult close failed "
            defpackage.Ai.a()
            qp r6 = r3.a     // Catch:{ Exception -> 0x00e8 }
            r6.getClass()     // Catch:{ Exception -> 0x00e8 }
            u8 r5 = defpackage.C1354qp.J(r1)     // Catch:{ Exception -> 0x00e8 }
            java.net.HttpURLConnection r6 = r5.a
            int r7 = r6.getResponseCode()     // Catch:{ IOException -> 0x00ea }
            int r7 = r7 / 100
            r8 = 2
            if (r7 != r8) goto L_0x00ea
            r4 = 1
            goto L_0x00ea
        L_0x00e6:
            r1 = move-exception
            goto L_0x0133
        L_0x00e8:
            r1 = move-exception
            goto L_0x0113
        L_0x00ea:
            if (r4 == 0) goto L_0x00fc
            java.io.InputStream r4 = r6.getInputStream()     // Catch:{ Exception -> 0x00e8 }
            java.lang.String r6 = r6.getContentType()     // Catch:{ Exception -> 0x00e8 }
            Lj r1 = r3.a(r1, r4, r6, r2)     // Catch:{ Exception -> 0x00e8 }
            defpackage.Ai.a()     // Catch:{ Exception -> 0x00e8 }
            goto L_0x010a
        L_0x00fc:
            Lj r1 = new Lj     // Catch:{ Exception -> 0x00e8 }
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x00e8 }
            java.lang.String r4 = r5.a()     // Catch:{ Exception -> 0x00e8 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x00e8 }
            r1.<init>((java.lang.Throwable) r3)     // Catch:{ Exception -> 0x00e8 }
        L_0x010a:
            r5.close()     // Catch:{ IOException -> 0x010e }
            goto L_0x0123
        L_0x010e:
            r3 = move-exception
            defpackage.Ai.c(r0, r3)
            goto L_0x0123
        L_0x0113:
            Lj r3 = new Lj     // Catch:{ all -> 0x00e6 }
            r3.<init>((java.lang.Throwable) r1)     // Catch:{ all -> 0x00e6 }
            if (r5 == 0) goto L_0x0122
            r5.close()     // Catch:{ IOException -> 0x011e }
            goto L_0x0122
        L_0x011e:
            r1 = move-exception
            defpackage.Ai.c(r0, r1)
        L_0x0122:
            r1 = r3
        L_0x0123:
            if (r2 == 0) goto L_0x0132
            V r0 = r1.a
            if (r0 == 0) goto L_0x0132
            fj r3 = defpackage.C0196fj.a
            ej r0 = (defpackage.C0181ej) r0
            androidx.collection.LruCache<java.lang.String, ej> r3 = r3.f2940a
            r3.put(r2, r0)
        L_0x0132:
            return r1
        L_0x0133:
            if (r5 == 0) goto L_0x013d
            r5.close()     // Catch:{ IOException -> 0x0139 }
            goto L_0x013d
        L_0x0139:
            r2 = move-exception
            defpackage.Ai.c(r0, r2)
        L_0x013d:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0205gj.call():java.lang.Object");
    }
}
