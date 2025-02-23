package defpackage;

/* renamed from: A1  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class A1 implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ int c;

    public /* synthetic */ A1(int i, Object obj, Object obj2) {
        this.c = i;
        this.a = obj;
        this.b = obj2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0147  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r15 = this;
            int r0 = r15.c
            java.lang.Object r1 = r15.b
            java.lang.Object r2 = r15.a
            switch(r0) {
                case 0: goto L_0x0174;
                case 1: goto L_0x016c;
                case 2: goto L_0x0164;
                case 3: goto L_0x015c;
                case 4: goto L_0x0154;
                case 5: goto L_0x0023;
                case 6: goto L_0x001b;
                case 7: goto L_0x0013;
                case 8: goto L_0x000b;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x0187
        L_0x000b:
            in.juspay.hypersdk.core.SdkTracker r2 = (in.juspay.hypersdk.core.SdkTracker) r2
            org.json.JSONObject r1 = (org.json.JSONObject) r1
            r2.lambda$addLogToPersistedQueue$14(r1)
            return
        L_0x0013:
            in.juspay.hypersdk.core.JsInterface r2 = (in.juspay.hypersdk.core.JsInterface) r2
            org.json.JSONObject r1 = (org.json.JSONObject) r1
            r2.lambda$setAnalyticsHeader$0(r1)
            return
        L_0x001b:
            in.juspay.hypersdk.core.DuiInterface r2 = (in.juspay.hypersdk.core.DuiInterface) r2
            android.app.Activity r1 = (android.app.Activity) r1
            r2.lambda$clearMerchantViews$0(r1)
            return
        L_0x0023:
            com.journeyapps.barcodescanner.a$a r2 = (com.journeyapps.barcodescanner.a.C0051a) r2
            n2 r1 = (defpackage.C1272n2) r1
            com.journeyapps.barcodescanner.a r0 = com.journeyapps.barcodescanner.a.this
            boolean r2 = r0.f3982a
            android.app.Activity r3 = r0.f3975a
            r4 = 0
            if (r2 == 0) goto L_0x00a7
            Bx r2 = r1.a
            us r5 = r2.f3537a
            android.graphics.Rect r6 = new android.graphics.Rect
            int r7 = r5.a
            int r8 = r5.b
            r6.<init>(r4, r4, r7, r8)
            android.graphics.YuvImage r7 = new android.graphics.YuvImage
            byte[] r10 = r5.f6986a
            int r11 = r2.a
            int r12 = r5.a
            int r13 = r5.b
            r14 = 0
            r9 = r7
            r9.<init>(r10, r11, r12, r13, r14)
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream
            r5.<init>()
            r8 = 90
            r7.compressToJpeg(r6, r8, r5)
            byte[] r5 = r5.toByteArray()
            android.graphics.BitmapFactory$Options r6 = new android.graphics.BitmapFactory$Options
            r6.<init>()
            r7 = 2
            r6.inSampleSize = r7
            int r7 = r5.length
            android.graphics.Bitmap r8 = android.graphics.BitmapFactory.decodeByteArray(r5, r4, r7, r6)
            int r2 = r2.b
            if (r2 == 0) goto L_0x0083
            android.graphics.Matrix r13 = new android.graphics.Matrix
            r13.<init>()
            float r2 = (float) r2
            r13.postRotate(r2)
            r9 = 0
            r10 = 0
            int r11 = r8.getWidth()
            int r12 = r8.getHeight()
            r14 = 0
            android.graphics.Bitmap r8 = android.graphics.Bitmap.createBitmap(r8, r9, r10, r11, r12, r13, r14)
        L_0x0083:
            java.lang.String r2 = "barcodeimage"
            java.lang.String r5 = ".jpg"
            java.io.File r6 = r3.getCacheDir()     // Catch:{ IOException -> 0x00a3 }
            java.io.File r2 = java.io.File.createTempFile(r2, r5, r6)     // Catch:{ IOException -> 0x00a3 }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00a3 }
            r5.<init>(r2)     // Catch:{ IOException -> 0x00a3 }
            android.graphics.Bitmap$CompressFormat r6 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ IOException -> 0x00a3 }
            r7 = 100
            r8.compress(r6, r7, r5)     // Catch:{ IOException -> 0x00a3 }
            r5.close()     // Catch:{ IOException -> 0x00a3 }
            java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ IOException -> 0x00a3 }
            goto L_0x00a8
        L_0x00a3:
            r2 = move-exception
            r2.toString()
        L_0x00a7:
            r2 = 0
        L_0x00a8:
            android.content.Intent r5 = new android.content.Intent
            java.lang.String r6 = "com.google.zxing.client.android.SCAN"
            r5.<init>(r6)
            r6 = 524288(0x80000, float:7.34684E-40)
            r5.addFlags(r6)
            java.lang.String r6 = r1.toString()
            java.lang.String r7 = "SCAN_RESULT"
            r5.putExtra(r7, r6)
            com.google.zxing.Result r1 = r1.f5599a
            com.google.zxing.BarcodeFormat r6 = r1.getBarcodeFormat()
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "SCAN_RESULT_FORMAT"
            r5.putExtra(r7, r6)
            byte[] r6 = r1.getRawBytes()
            if (r6 == 0) goto L_0x00da
            int r7 = r6.length
            if (r7 <= 0) goto L_0x00da
            java.lang.String r7 = "SCAN_RESULT_BYTES"
            r5.putExtra(r7, r6)
        L_0x00da:
            java.util.Map r1 = r1.getResultMetadata()
            if (r1 == 0) goto L_0x0145
            com.google.zxing.ResultMetadataType r6 = com.google.zxing.ResultMetadataType.UPC_EAN_EXTENSION
            boolean r7 = r1.containsKey(r6)
            if (r7 == 0) goto L_0x00f5
            java.lang.Object r6 = r1.get(r6)
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "SCAN_RESULT_UPC_EAN_EXTENSION"
            r5.putExtra(r7, r6)
        L_0x00f5:
            com.google.zxing.ResultMetadataType r6 = com.google.zxing.ResultMetadataType.ORIENTATION
            java.lang.Object r6 = r1.get(r6)
            java.lang.Number r6 = (java.lang.Number) r6
            if (r6 == 0) goto L_0x0108
            java.lang.String r7 = "SCAN_RESULT_ORIENTATION"
            int r6 = r6.intValue()
            r5.putExtra(r7, r6)
        L_0x0108:
            com.google.zxing.ResultMetadataType r6 = com.google.zxing.ResultMetadataType.ERROR_CORRECTION_LEVEL
            java.lang.Object r6 = r1.get(r6)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x0117
            java.lang.String r7 = "SCAN_RESULT_ERROR_CORRECTION_LEVEL"
            r5.putExtra(r7, r6)
        L_0x0117:
            com.google.zxing.ResultMetadataType r6 = com.google.zxing.ResultMetadataType.BYTE_SEGMENTS
            java.lang.Object r1 = r1.get(r6)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            if (r1 == 0) goto L_0x0145
            java.util.Iterator r1 = r1.iterator()
        L_0x0125:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x0145
            java.lang.Object r6 = r1.next()
            byte[] r6 = (byte[]) r6
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "SCAN_RESULT_BYTE_SEGMENTS_"
            r7.<init>(r8)
            r7.append(r4)
            java.lang.String r7 = r7.toString()
            r5.putExtra(r7, r6)
            int r4 = r4 + 1
            goto L_0x0125
        L_0x0145:
            if (r2 == 0) goto L_0x014c
            java.lang.String r1 = "SCAN_RESULT_IMAGE_PATH"
            r5.putExtra(r1, r2)
        L_0x014c:
            r1 = -1
            r3.setResult(r1, r5)
            r0.a()
            return
        L_0x0154:
            com.google.firebase.remoteconfig.interop.rollouts.RolloutsStateSubscriber r2 = (com.google.firebase.remoteconfig.interop.rollouts.RolloutsStateSubscriber) r2
            com.google.firebase.remoteconfig.interop.rollouts.RolloutsState r1 = (com.google.firebase.remoteconfig.interop.rollouts.RolloutsState) r1
            r2.onRolloutsStateChanged(r1)
            return
        L_0x015c:
            com.google.firebase.perf.session.gauges.MemoryGaugeCollector r2 = (com.google.firebase.perf.session.gauges.MemoryGaugeCollector) r2
            com.google.firebase.perf.util.Timer r1 = (com.google.firebase.perf.util.Timer) r1
            r2.lambda$scheduleMemoryMetricCollectionOnce$1(r1)
            return
        L_0x0164:
            com.google.firebase.perf.session.gauges.CpuGaugeCollector r2 = (com.google.firebase.perf.session.gauges.CpuGaugeCollector) r2
            com.google.firebase.perf.util.Timer r1 = (com.google.firebase.perf.util.Timer) r1
            r2.lambda$scheduleCpuMetricCollectionWithRate$0(r1)
            return
        L_0x016c:
            com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService r2 = (com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService) r2
            android.app.job.JobParameters r1 = (android.app.job.JobParameters) r1
            r2.lambda$onStartJob$0(r1)
            return
        L_0x0174:
            androidx.appcompat.app.g$a r2 = (androidx.appcompat.app.g.a) r2
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            r2.getClass()
            r1.run()     // Catch:{ all -> 0x0182 }
            r2.a()
            return
        L_0x0182:
            r0 = move-exception
            r2.a()
            throw r0
        L_0x0187:
            in.juspay.services.HyperServices r2 = (in.juspay.services.HyperServices) r2
            org.json.JSONObject r1 = (org.json.JSONObject) r1
            r2.lambda$setupJuspayServices$0(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.A1.run():void");
    }
}
