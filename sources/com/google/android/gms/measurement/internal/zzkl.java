package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.net.URL;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
final class zzkl implements Runnable {
    private final URL zza;
    private final zzkm zzb;
    private final String zzc;
    private final Map<String, String> zzd = null;
    private final /* synthetic */ zzkj zze;

    public zzkl(zzkj zzkj, String str, URL url, byte[] bArr, Map<String, String> map, zzkm zzkm) {
        this.zze = zzkj;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzkm);
        this.zza = url;
        this.zzb = zzkm;
        this.zzc = str;
    }

    private final void zzb(int i, Exception exc, byte[] bArr, Map<String, List<String>> map) {
        this.zze.zzl().zzb((Runnable) new zzko(this, i, exc, bArr, map));
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r5 = this;
            com.google.android.gms.measurement.internal.zzkj r0 = r5.zze
            r0.zzr()
            r0 = 0
            r1 = 0
            java.net.URL r2 = r5.zza     // Catch:{ IOException -> 0x0062, all -> 0x0056 }
            com.google.android.gms.internal.measurement.zzcq r3 = com.google.android.gms.internal.measurement.zzcq.zza()     // Catch:{ IOException -> 0x0062, all -> 0x0056 }
            java.lang.String r4 = "client-measurement"
            java.net.URLConnection r2 = r3.zza(r2, r4)     // Catch:{ IOException -> 0x0062, all -> 0x0056 }
            boolean r3 = r2 instanceof java.net.HttpURLConnection     // Catch:{ IOException -> 0x0062, all -> 0x0056 }
            if (r3 == 0) goto L_0x004e
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x0062, all -> 0x0056 }
            r2.setDefaultUseCaches(r1)     // Catch:{ IOException -> 0x0062, all -> 0x0056 }
            r3 = 60000(0xea60, float:8.4078E-41)
            r2.setConnectTimeout(r3)     // Catch:{ IOException -> 0x0062, all -> 0x0056 }
            r3 = 61000(0xee48, float:8.5479E-41)
            r2.setReadTimeout(r3)     // Catch:{ IOException -> 0x0062, all -> 0x0056 }
            r2.setInstanceFollowRedirects(r1)     // Catch:{ IOException -> 0x0062, all -> 0x0056 }
            r3 = 1
            r2.setDoInput(r3)     // Catch:{ IOException -> 0x0062, all -> 0x0056 }
            int r1 = r2.getResponseCode()     // Catch:{ IOException -> 0x004b, all -> 0x0048 }
            java.util.Map r3 = r2.getHeaderFields()     // Catch:{ IOException -> 0x004b, all -> 0x0048 }
            com.google.android.gms.measurement.internal.zzkj r4 = r5.zze     // Catch:{ IOException -> 0x0046, all -> 0x0044 }
            byte[] r4 = com.google.android.gms.measurement.internal.zzkj.zza(r2)     // Catch:{ IOException -> 0x0046, all -> 0x0044 }
            r2.disconnect()
            r5.zzb(r1, r0, r4, r3)
            return
        L_0x0044:
            r4 = move-exception
            goto L_0x0059
        L_0x0046:
            r4 = move-exception
            goto L_0x0065
        L_0x0048:
            r4 = move-exception
            r3 = r0
            goto L_0x0059
        L_0x004b:
            r4 = move-exception
            r3 = r0
            goto L_0x0065
        L_0x004e:
            java.io.IOException r2 = new java.io.IOException     // Catch:{ IOException -> 0x0062, all -> 0x0056 }
            java.lang.String r3 = "Failed to obtain HTTP connection"
            r2.<init>(r3)     // Catch:{ IOException -> 0x0062, all -> 0x0056 }
            throw r2     // Catch:{ IOException -> 0x0062, all -> 0x0056 }
        L_0x0056:
            r4 = move-exception
            r2 = r0
            r3 = r2
        L_0x0059:
            if (r2 == 0) goto L_0x005e
            r2.disconnect()
        L_0x005e:
            r5.zzb(r1, r0, r0, r3)
            throw r4
        L_0x0062:
            r4 = move-exception
            r2 = r0
            r3 = r2
        L_0x0065:
            if (r2 == 0) goto L_0x006a
            r2.disconnect()
        L_0x006a:
            r5.zzb(r1, r4, r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkl.run():void");
    }

    public final /* synthetic */ void zza(int i, Exception exc, byte[] bArr, Map map) {
        this.zzb.zza(this.zzc, i, exc, bArr, map);
    }
}
