package defpackage;

/* renamed from: f6  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0189f6 implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ int c;

    public /* synthetic */ C0189f6(Object obj, int i) {
        this.c = i;
        this.a = obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:105:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r4 = r0.d();
        r5 = r4.c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006f, code lost:
        if (r5 != 2) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0071, code lost:
        r6 = r0.f2025a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0073, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0079, code lost:
        if (r5 != 0) goto L_0x00db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r5 = defpackage.C0337tA.a;
        android.os.Trace.beginSection("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
        r3 = r0.f2024a;
        r5 = r0.f2021a;
        r3.getClass();
        r1 = defpackage.TA.a.b(r5, new defpackage.C0204gd[]{r4}, 0);
        r2 = defpackage.C0116aB.e(r0.f2021a, r4.f2968a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x009b, code lost:
        if (r2 == null) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x009d, code lost:
        if (r1 == null) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        android.os.Trace.beginSection("EmojiCompat.MetadataRepo.create");
        r3 = new androidx.emoji2.text.h(r1, defpackage.ml.a(r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        android.os.Trace.endSection();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        android.os.Trace.endSection();
        r1 = r0.f2025a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00b5, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        r2 = r0.f2023a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00b8, code lost:
        if (r2 == null) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00ba, code lost:
        r2.b(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00bd, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        r0.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00c5, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        r2 = defpackage.C0337tA.a;
        android.os.Trace.endSection();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00cb, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00d3, code lost:
        throw new java.lang.RuntimeException("Unable to open file.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00d4, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
        r2 = defpackage.C0337tA.a;
        android.os.Trace.endSection();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00da, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00f1, code lost:
        throw new java.lang.RuntimeException("fetchFonts result is not OK. (" + r5 + ")");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00f2, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00f5, code lost:
        monitor-enter(r0.f2025a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:?, code lost:
        r3 = r0.f2023a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x00f8, code lost:
        if (r3 != null) goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x00fa, code lost:
        r3.a(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x00fe, code lost:
        r0.b();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r7 = this;
            int r0 = r7.c
            r1 = 1
            r2 = 0
            switch(r0) {
                case 0: goto L_0x0113;
                case 1: goto L_0x0108;
                case 2: goto L_0x0057;
                case 3: goto L_0x004f;
                case 4: goto L_0x0047;
                case 5: goto L_0x003f;
                case 6: goto L_0x0035;
                case 7: goto L_0x0019;
                case 8: goto L_0x0011;
                case 9: goto L_0x0009;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x011b
        L_0x0009:
            java.lang.Object r0 = r7.a
            in.juspay.services.HyperServices r0 = (in.juspay.services.HyperServices) r0
            r0.lambda$initiate$2()
            return
        L_0x0011:
            java.lang.Object r0 = r7.a
            cris.org.in.ima.activities.PinValidationActivity r0 = (cris.org.in.ima.activities.PinValidationActivity) r0
            cris.org.in.ima.activities.PinValidationActivity.m(r0)
            return
        L_0x0019:
            java.lang.Object r0 = r7.a
            com.journeyapps.barcodescanner.a r0 = (com.journeyapps.barcodescanner.a) r0
            r0.getClass()
            android.content.Intent r3 = new android.content.Intent
            java.lang.String r4 = "com.google.zxing.client.android.SCAN"
            r3.<init>(r4)
            java.lang.String r4 = "TIMEOUT"
            r3.putExtra(r4, r1)
            android.app.Activity r1 = r0.f3975a
            r1.setResult(r2, r3)
            r0.a()
            return
        L_0x0035:
            java.lang.Object r0 = r7.a
            com.journeyapps.barcodescanner.CameraPreview$c r0 = (com.journeyapps.barcodescanner.CameraPreview.c) r0
            com.journeyapps.barcodescanner.CameraPreview r0 = com.journeyapps.barcodescanner.CameraPreview.this
            com.journeyapps.barcodescanner.CameraPreview.a(r0)
            return
        L_0x003f:
            java.lang.Object r0 = r7.a
            com.google.firebase.perf.transport.TransportManager r0 = (com.google.firebase.perf.transport.TransportManager) r0
            r0.syncInit()
            return
        L_0x0047:
            java.lang.Object r0 = r7.a
            com.google.firebase.perf.metrics.AppStartTrace r0 = (com.google.firebase.perf.metrics.AppStartTrace) r0
            r0.recordPreDraw()
            return
        L_0x004f:
            java.lang.Object r0 = r7.a
            android.view.View r0 = (android.view.View) r0
            com.google.android.material.internal.ViewUtils.requestFocusAndShowKeyboard(r0, false)
            return
        L_0x0057:
            java.lang.Object r0 = r7.a
            androidx.emoji2.text.g$b r0 = (androidx.emoji2.text.g.b) r0
            java.lang.String r3 = "fetchFonts result is not OK. ("
            java.lang.Object r4 = r0.f2025a
            monitor-enter(r4)
            androidx.emoji2.text.d$h r5 = r0.f2023a     // Catch:{ all -> 0x0105 }
            if (r5 != 0) goto L_0x0067
            monitor-exit(r4)     // Catch:{ all -> 0x0105 }
            goto L_0x0101
        L_0x0067:
            monitor-exit(r4)     // Catch:{ all -> 0x0105 }
            gd r4 = r0.d()     // Catch:{ all -> 0x00f2 }
            int r5 = r4.c     // Catch:{ all -> 0x00f2 }
            r6 = 2
            if (r5 != r6) goto L_0x0079
            java.lang.Object r6 = r0.f2025a     // Catch:{ all -> 0x00f2 }
            monitor-enter(r6)     // Catch:{ all -> 0x00f2 }
            monitor-exit(r6)     // Catch:{ all -> 0x0076 }
            goto L_0x0079
        L_0x0076:
            r1 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0076 }
            throw r1     // Catch:{ all -> 0x00f2 }
        L_0x0079:
            if (r5 != 0) goto L_0x00db
            java.lang.String r3 = "EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface"
            int r5 = defpackage.C0337tA.a     // Catch:{ all -> 0x00d4 }
            android.os.Trace.beginSection(r3)     // Catch:{ all -> 0x00d4 }
            androidx.emoji2.text.g$a r3 = r0.f2024a     // Catch:{ all -> 0x00d4 }
            android.content.Context r5 = r0.f2021a     // Catch:{ all -> 0x00d4 }
            r3.getClass()     // Catch:{ all -> 0x00d4 }
            gd[] r1 = new defpackage.C0204gd[r1]     // Catch:{ all -> 0x00d4 }
            r1[r2] = r4     // Catch:{ all -> 0x00d4 }
            ZA r3 = defpackage.TA.a     // Catch:{ all -> 0x00d4 }
            android.graphics.Typeface r1 = r3.b(r5, r1, r2)     // Catch:{ all -> 0x00d4 }
            android.content.Context r2 = r0.f2021a     // Catch:{ all -> 0x00d4 }
            android.net.Uri r3 = r4.f2968a     // Catch:{ all -> 0x00d4 }
            java.nio.MappedByteBuffer r2 = defpackage.C0116aB.e(r2, r3)     // Catch:{ all -> 0x00d4 }
            if (r2 == 0) goto L_0x00cc
            if (r1 == 0) goto L_0x00cc
            java.lang.String r3 = "EmojiCompat.MetadataRepo.create"
            android.os.Trace.beginSection(r3)     // Catch:{ all -> 0x00c5 }
            androidx.emoji2.text.h r3 = new androidx.emoji2.text.h     // Catch:{ all -> 0x00c5 }
            ll r2 = defpackage.ml.a(r2)     // Catch:{ all -> 0x00c5 }
            r3.<init>(r1, r2)     // Catch:{ all -> 0x00c5 }
            android.os.Trace.endSection()     // Catch:{ all -> 0x00d4 }
            android.os.Trace.endSection()     // Catch:{ all -> 0x00f2 }
            java.lang.Object r1 = r0.f2025a     // Catch:{ all -> 0x00f2 }
            monitor-enter(r1)     // Catch:{ all -> 0x00f2 }
            androidx.emoji2.text.d$h r2 = r0.f2023a     // Catch:{ all -> 0x00c2 }
            if (r2 == 0) goto L_0x00bd
            r2.b(r3)     // Catch:{ all -> 0x00c2 }
        L_0x00bd:
            monitor-exit(r1)     // Catch:{ all -> 0x00c2 }
            r0.b()     // Catch:{ all -> 0x00f2 }
            goto L_0x0101
        L_0x00c2:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00c2 }
            throw r2     // Catch:{ all -> 0x00f2 }
        L_0x00c5:
            r1 = move-exception
            int r2 = defpackage.C0337tA.a     // Catch:{ all -> 0x00d4 }
            android.os.Trace.endSection()     // Catch:{ all -> 0x00d4 }
            throw r1     // Catch:{ all -> 0x00d4 }
        L_0x00cc:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x00d4 }
            java.lang.String r2 = "Unable to open file."
            r1.<init>(r2)     // Catch:{ all -> 0x00d4 }
            throw r1     // Catch:{ all -> 0x00d4 }
        L_0x00d4:
            r1 = move-exception
            int r2 = defpackage.C0337tA.a     // Catch:{ all -> 0x00f2 }
            android.os.Trace.endSection()     // Catch:{ all -> 0x00f2 }
            throw r1     // Catch:{ all -> 0x00f2 }
        L_0x00db:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x00f2 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f2 }
            r2.<init>(r3)     // Catch:{ all -> 0x00f2 }
            r2.append(r5)     // Catch:{ all -> 0x00f2 }
            java.lang.String r3 = ")"
            r2.append(r3)     // Catch:{ all -> 0x00f2 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00f2 }
            r1.<init>(r2)     // Catch:{ all -> 0x00f2 }
            throw r1     // Catch:{ all -> 0x00f2 }
        L_0x00f2:
            r1 = move-exception
            java.lang.Object r2 = r0.f2025a
            monitor-enter(r2)
            androidx.emoji2.text.d$h r3 = r0.f2023a     // Catch:{ all -> 0x0102 }
            if (r3 == 0) goto L_0x00fd
            r3.a(r1)     // Catch:{ all -> 0x0102 }
        L_0x00fd:
            monitor-exit(r2)     // Catch:{ all -> 0x0102 }
            r0.b()
        L_0x0101:
            return
        L_0x0102:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0102 }
            throw r0
        L_0x0105:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0105 }
            throw r0
        L_0x0108:
            java.lang.Object r0 = r7.a
            kA r0 = (defpackage.C0245kA) r0
            r0.getClass()
            java.util.WeakHashMap<android.view.View, GC> r0 = androidx.core.view.f.f1839a
            r0 = 0
            throw r0
        L_0x0113:
            java.lang.Object r0 = r7.a
            androidx.activity.ComponentDialog r0 = (androidx.activity.ComponentDialog) r0
            androidx.activity.ComponentDialog.onBackPressedDispatcher$lambda$1(r0)
            return
        L_0x011b:
            java.lang.Object r0 = r7.a
            okhttp3.internal.connection.RealConnectionPool r0 = (okhttp3.internal.connection.RealConnectionPool) r0
            r0.lambda$new$0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0189f6.run():void");
    }
}
