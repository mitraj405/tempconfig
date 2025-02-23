package defpackage;

import android.content.Context;

/* renamed from: i1  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class i1 implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ int c;

    public /* synthetic */ i1(Context context, int i) {
        this.c = i;
        this.a = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0067, code lost:
        if (r5 != null) goto L_0x006c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0074  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r11 = this;
            int r0 = r11.c
            android.content.Context r1 = r11.a
            switch(r0) {
                case 0: goto L_0x0009;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x008f
        L_0x0009:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 33
            r3 = 1
            if (r0 < r2) goto L_0x008c
            androidx.appcompat.app.g$a r0 = androidx.appcompat.app.AppCompatDelegate.a
            android.content.ComponentName r0 = new android.content.ComponentName
            java.lang.String r2 = "androidx.appcompat.app.AppLocalesMetadataHolderService"
            r0.<init>(r1, r2)
            android.content.pm.PackageManager r2 = r1.getPackageManager()
            int r2 = r2.getComponentEnabledSetting(r0)
            if (r2 == r3) goto L_0x008c
            boolean r2 = defpackage.s3.c()
            java.lang.String r4 = "locale"
            if (r2 == 0) goto L_0x0065
            androidx.collection.ArraySet<java.lang.ref.WeakReference<androidx.appcompat.app.AppCompatDelegate>> r2 = androidx.appcompat.app.AppCompatDelegate.f893a
            java.util.Iterator r2 = r2.iterator()
        L_0x0031:
            r5 = r2
            nk$a r5 = (defpackage.C0282nk.a) r5
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0053
            java.lang.Object r5 = r5.next()
            java.lang.ref.WeakReference r5 = (java.lang.ref.WeakReference) r5
            java.lang.Object r5 = r5.get()
            androidx.appcompat.app.AppCompatDelegate r5 = (androidx.appcompat.app.AppCompatDelegate) r5
            if (r5 == 0) goto L_0x0031
            android.content.Context r5 = r5.d()
            if (r5 == 0) goto L_0x0031
            java.lang.Object r2 = r5.getSystemService(r4)
            goto L_0x0054
        L_0x0053:
            r2 = 0
        L_0x0054:
            if (r2 == 0) goto L_0x006a
            android.os.LocaleList r2 = androidx.appcompat.app.AppCompatDelegate.b.a(r2)
            ki r5 = new ki
            mi r6 = new mi
            r6.<init>(r2)
            r5.<init>(r6)
            goto L_0x006c
        L_0x0065:
            ki r5 = androidx.appcompat.app.AppCompatDelegate.f896a
            if (r5 == 0) goto L_0x006a
            goto L_0x006c
        L_0x006a:
            ki r5 = defpackage.ki.a
        L_0x006c:
            li r2 = r5.f3053a
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0085
            java.lang.String r2 = androidx.appcompat.app.g.b(r1)
            java.lang.Object r4 = r1.getSystemService(r4)
            if (r4 == 0) goto L_0x0085
            android.os.LocaleList r2 = androidx.appcompat.app.AppCompatDelegate.a.a(r2)
            androidx.appcompat.app.AppCompatDelegate.b.b(r4, r2)
        L_0x0085:
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            r1.setComponentEnabledSetting(r0, r3, r3)
        L_0x008c:
            androidx.appcompat.app.AppCompatDelegate.f897a = r3
            return
        L_0x008f:
            java.util.concurrent.ThreadPoolExecutor r0 = new java.util.concurrent.ThreadPoolExecutor
            r5 = 0
            r6 = 1
            r7 = 0
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.MILLISECONDS
            java.util.concurrent.LinkedBlockingQueue r10 = new java.util.concurrent.LinkedBlockingQueue
            r10.<init>()
            r4 = r0
            r4.<init>(r5, r6, r7, r9, r10)
            gA r2 = new gA
            r3 = 2
            r2.<init>(r1, r3)
            r0.execute(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.i1.run():void");
    }
}
