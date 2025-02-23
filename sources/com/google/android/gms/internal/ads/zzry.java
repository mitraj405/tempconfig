package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzry implements zzsa {
    private final Context zza;

    @Deprecated
    public zzry() {
        this.zza = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0085  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzsc zzd(com.google.android.gms.internal.ads.zzrz r5) throws java.io.IOException {
        /*
            r4 = this;
            int r0 = com.google.android.gms.internal.ads.zzet.zza
            r1 = 23
            if (r0 < r1) goto L_0x0045
            r1 = 31
            if (r0 < r1) goto L_0x000b
            goto L_0x0020
        L_0x000b:
            android.content.Context r1 = r4.zza
            if (r1 == 0) goto L_0x0045
            r2 = 28
            if (r0 < r2) goto L_0x0045
            android.content.pm.PackageManager r0 = r1.getPackageManager()
            java.lang.String r1 = "com.amazon.hardware.tv_screen"
            boolean r0 = r0.hasSystemFeature(r1)
            if (r0 != 0) goto L_0x0020
            goto L_0x0045
        L_0x0020:
            com.google.android.gms.internal.ads.zzaf r0 = r5.zzc
            java.lang.String r0 = r0.zzm
            int r0 = com.google.android.gms.internal.ads.zzbn.zzb(r0)
            java.lang.String r1 = com.google.android.gms.internal.ads.zzet.zzC(r0)
            java.lang.String r2 = "DMCodecAdapterFactory"
            java.lang.String r3 = "Creating an asynchronous MediaCodec adapter for track type "
            java.lang.String r1 = r3.concat(r1)
            com.google.android.gms.internal.ads.zzea.zze(r2, r1)
            com.google.android.gms.internal.ads.zzro r1 = new com.google.android.gms.internal.ads.zzro
            r1.<init>(r0)
            r0 = 1
            r1.zze(r0)
            com.google.android.gms.internal.ads.zzrq r5 = r1.zzc(r5)
            return r5
        L_0x0045:
            r0 = 0
            com.google.android.gms.internal.ads.zzsf r1 = r5.zza     // Catch:{ IOException -> 0x0082, RuntimeException -> 0x0080 }
            java.lang.String r1 = r1.zza     // Catch:{ IOException -> 0x0082, RuntimeException -> 0x0080 }
            java.lang.String r2 = "createCodec:"
            java.lang.String r2 = r2.concat(r1)     // Catch:{ IOException -> 0x0082, RuntimeException -> 0x0080 }
            android.os.Trace.beginSection(r2)     // Catch:{ IOException -> 0x0082, RuntimeException -> 0x0080 }
            android.media.MediaCodec r1 = android.media.MediaCodec.createByCodecName(r1)     // Catch:{ IOException -> 0x0082, RuntimeException -> 0x0080 }
            android.os.Trace.endSection()     // Catch:{ IOException -> 0x0082, RuntimeException -> 0x0080 }
            java.lang.String r2 = "configureCodec"
            android.os.Trace.beginSection(r2)     // Catch:{ IOException -> 0x007d, RuntimeException -> 0x007b }
            android.media.MediaFormat r2 = r5.zzb     // Catch:{ IOException -> 0x007d, RuntimeException -> 0x007b }
            android.view.Surface r5 = r5.zzd     // Catch:{ IOException -> 0x007d, RuntimeException -> 0x007b }
            r3 = 0
            r1.configure(r2, r5, r0, r3)     // Catch:{ IOException -> 0x007d, RuntimeException -> 0x007b }
            android.os.Trace.endSection()     // Catch:{ IOException -> 0x007d, RuntimeException -> 0x007b }
            java.lang.String r5 = "startCodec"
            android.os.Trace.beginSection(r5)     // Catch:{ IOException -> 0x007d, RuntimeException -> 0x007b }
            r1.start()     // Catch:{ IOException -> 0x007d, RuntimeException -> 0x007b }
            android.os.Trace.endSection()     // Catch:{ IOException -> 0x007d, RuntimeException -> 0x007b }
            com.google.android.gms.internal.ads.zzte r5 = new com.google.android.gms.internal.ads.zzte     // Catch:{ IOException -> 0x007d, RuntimeException -> 0x007b }
            r5.<init>(r1, r0)     // Catch:{ IOException -> 0x007d, RuntimeException -> 0x007b }
            return r5
        L_0x007b:
            r5 = move-exception
            goto L_0x007e
        L_0x007d:
            r5 = move-exception
        L_0x007e:
            r0 = r1
            goto L_0x0083
        L_0x0080:
            r5 = move-exception
            goto L_0x0083
        L_0x0082:
            r5 = move-exception
        L_0x0083:
            if (r0 == 0) goto L_0x0088
            r0.release()
        L_0x0088:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzry.zzd(com.google.android.gms.internal.ads.zzrz):com.google.android.gms.internal.ads.zzsc");
    }

    public zzry(Context context) {
        this.zza = context;
    }
}
