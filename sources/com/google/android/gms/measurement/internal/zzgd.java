package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.net.URL;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
final class zzgd implements Runnable {
    private final URL zza;
    private final byte[] zzb;
    private final zzgc zzc;
    private final String zzd;
    private final Map<String, String> zze;
    private final /* synthetic */ zzfz zzf;

    public zzgd(zzfz zzfz, String str, URL url, byte[] bArr, Map<String, String> map, zzgc zzgc) {
        this.zzf = zzfz;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzgc);
        this.zza = url;
        this.zzb = bArr;
        this.zzc = zzgc;
        this.zzd = str;
        this.zze = map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00f6 A[SYNTHETIC, Splitter:B:48:0x00f6] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0131 A[SYNTHETIC, Splitter:B:61:0x0131] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x014b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r13 = this;
            java.lang.String r0 = "Error closing HTTP compressed POST connection output stream. appId"
            com.google.android.gms.measurement.internal.zzfz r1 = r13.zzf
            r1.zzr()
            r1 = 0
            r2 = 0
            java.net.URL r3 = r13.zza     // Catch:{ IOException -> 0x012a, all -> 0x00ef }
            com.google.android.gms.internal.measurement.zzcq r4 = com.google.android.gms.internal.measurement.zzcq.zza()     // Catch:{ IOException -> 0x012a, all -> 0x00ef }
            java.lang.String r5 = "client-measurement"
            java.net.URLConnection r3 = r4.zza(r3, r5)     // Catch:{ IOException -> 0x012a, all -> 0x00ef }
            boolean r4 = r3 instanceof java.net.HttpURLConnection     // Catch:{ IOException -> 0x012a, all -> 0x00ef }
            if (r4 == 0) goto L_0x00e7
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ IOException -> 0x012a, all -> 0x00ef }
            r3.setDefaultUseCaches(r2)     // Catch:{ IOException -> 0x012a, all -> 0x00ef }
            r4 = 60000(0xea60, float:8.4078E-41)
            r3.setConnectTimeout(r4)     // Catch:{ IOException -> 0x012a, all -> 0x00ef }
            r4 = 61000(0xee48, float:8.5479E-41)
            r3.setReadTimeout(r4)     // Catch:{ IOException -> 0x012a, all -> 0x00ef }
            r3.setInstanceFollowRedirects(r2)     // Catch:{ IOException -> 0x012a, all -> 0x00ef }
            r4 = 1
            r3.setDoInput(r4)     // Catch:{ IOException -> 0x012a, all -> 0x00ef }
            java.util.Map<java.lang.String, java.lang.String> r5 = r13.zze     // Catch:{ IOException -> 0x00e4, all -> 0x00e1 }
            if (r5 == 0) goto L_0x0059
            java.util.Set r5 = r5.entrySet()     // Catch:{ IOException -> 0x00e4, all -> 0x00e1 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ IOException -> 0x00e4, all -> 0x00e1 }
        L_0x003d:
            boolean r6 = r5.hasNext()     // Catch:{ IOException -> 0x00e4, all -> 0x00e1 }
            if (r6 == 0) goto L_0x0059
            java.lang.Object r6 = r5.next()     // Catch:{ IOException -> 0x00e4, all -> 0x00e1 }
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6     // Catch:{ IOException -> 0x00e4, all -> 0x00e1 }
            java.lang.Object r7 = r6.getKey()     // Catch:{ IOException -> 0x00e4, all -> 0x00e1 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ IOException -> 0x00e4, all -> 0x00e1 }
            java.lang.Object r6 = r6.getValue()     // Catch:{ IOException -> 0x00e4, all -> 0x00e1 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ IOException -> 0x00e4, all -> 0x00e1 }
            r3.addRequestProperty(r7, r6)     // Catch:{ IOException -> 0x00e4, all -> 0x00e1 }
            goto L_0x003d
        L_0x0059:
            byte[] r5 = r13.zzb     // Catch:{ IOException -> 0x00e4, all -> 0x00e1 }
            if (r5 == 0) goto L_0x00a7
            com.google.android.gms.measurement.internal.zzfz r5 = r13.zzf     // Catch:{ IOException -> 0x00e4, all -> 0x00e1 }
            com.google.android.gms.measurement.internal.zznl r5 = r5.g_()     // Catch:{ IOException -> 0x00e4, all -> 0x00e1 }
            byte[] r6 = r13.zzb     // Catch:{ IOException -> 0x00e4, all -> 0x00e1 }
            byte[] r5 = r5.zzb((byte[]) r6)     // Catch:{ IOException -> 0x00e4, all -> 0x00e1 }
            com.google.android.gms.measurement.internal.zzfz r6 = r13.zzf     // Catch:{ IOException -> 0x00e4, all -> 0x00e1 }
            com.google.android.gms.measurement.internal.zzfw r6 = r6.zzj()     // Catch:{ IOException -> 0x00e4, all -> 0x00e1 }
            com.google.android.gms.measurement.internal.zzfy r6 = r6.zzp()     // Catch:{ IOException -> 0x00e4, all -> 0x00e1 }
            java.lang.String r7 = "Uploading data. size"
            int r8 = r5.length     // Catch:{ IOException -> 0x00e4, all -> 0x00e1 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ IOException -> 0x00e4, all -> 0x00e1 }
            r6.zza(r7, r8)     // Catch:{ IOException -> 0x00e4, all -> 0x00e1 }
            r3.setDoOutput(r4)     // Catch:{ IOException -> 0x00e4, all -> 0x00e1 }
            java.lang.String r4 = "Content-Encoding"
            java.lang.String r6 = "gzip"
            r3.addRequestProperty(r4, r6)     // Catch:{ IOException -> 0x00e4, all -> 0x00e1 }
            int r4 = r5.length     // Catch:{ IOException -> 0x00e4, all -> 0x00e1 }
            r3.setFixedLengthStreamingMode(r4)     // Catch:{ IOException -> 0x00e4, all -> 0x00e1 }
            r3.connect()     // Catch:{ IOException -> 0x00e4, all -> 0x00e1 }
            java.io.OutputStream r4 = r3.getOutputStream()     // Catch:{ IOException -> 0x00e4, all -> 0x00e1 }
            r4.write(r5)     // Catch:{ IOException -> 0x00a0, all -> 0x0099 }
            r4.close()     // Catch:{ IOException -> 0x00a0, all -> 0x0099 }
            goto L_0x00a7
        L_0x0099:
            r5 = move-exception
            r10 = r1
            r7 = r2
            r1 = r4
            r2 = r5
            goto L_0x00f4
        L_0x00a0:
            r5 = move-exception
            r10 = r1
            r7 = r2
            r1 = r4
            r8 = r5
            goto L_0x012f
        L_0x00a7:
            int r8 = r3.getResponseCode()     // Catch:{ IOException -> 0x00e4, all -> 0x00e1 }
            java.util.Map r11 = r3.getHeaderFields()     // Catch:{ IOException -> 0x00dd, all -> 0x00d8 }
            com.google.android.gms.measurement.internal.zzfz r2 = r13.zzf     // Catch:{ IOException -> 0x00d3, all -> 0x00ce }
            byte[] r10 = com.google.android.gms.measurement.internal.zzfz.zza(r3)     // Catch:{ IOException -> 0x00d3, all -> 0x00ce }
            r3.disconnect()
            com.google.android.gms.measurement.internal.zzfz r0 = r13.zzf
            com.google.android.gms.measurement.internal.zzhc r0 = r0.zzl()
            com.google.android.gms.measurement.internal.zzgb r1 = new com.google.android.gms.measurement.internal.zzgb
            java.lang.String r6 = r13.zzd
            com.google.android.gms.measurement.internal.zzgc r7 = r13.zzc
            r9 = 0
            r12 = 0
            r5 = r1
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r0.zzb((java.lang.Runnable) r1)
            return
        L_0x00ce:
            r4 = move-exception
            r2 = r4
            r7 = r8
            r10 = r11
            goto L_0x00f4
        L_0x00d3:
            r4 = move-exception
            r7 = r8
            r10 = r11
            goto L_0x012e
        L_0x00d8:
            r4 = move-exception
            r10 = r1
            r2 = r4
            r7 = r8
            goto L_0x00f4
        L_0x00dd:
            r4 = move-exception
            r10 = r1
            r7 = r8
            goto L_0x012e
        L_0x00e1:
            r4 = move-exception
            r10 = r1
            goto L_0x00f2
        L_0x00e4:
            r4 = move-exception
            r10 = r1
            goto L_0x012d
        L_0x00e7:
            java.io.IOException r3 = new java.io.IOException     // Catch:{ IOException -> 0x012a, all -> 0x00ef }
            java.lang.String r4 = "Failed to obtain HTTP connection"
            r3.<init>(r4)     // Catch:{ IOException -> 0x012a, all -> 0x00ef }
            throw r3     // Catch:{ IOException -> 0x012a, all -> 0x00ef }
        L_0x00ef:
            r4 = move-exception
            r3 = r1
            r10 = r3
        L_0x00f2:
            r7 = r2
            r2 = r4
        L_0x00f4:
            if (r1 == 0) goto L_0x010e
            r1.close()     // Catch:{ IOException -> 0x00fa }
            goto L_0x010e
        L_0x00fa:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzfz r4 = r13.zzf
            com.google.android.gms.measurement.internal.zzfw r4 = r4.zzj()
            com.google.android.gms.measurement.internal.zzfy r4 = r4.zzg()
            java.lang.String r5 = r13.zzd
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r5)
            r4.zza(r0, r5, r1)
        L_0x010e:
            if (r3 == 0) goto L_0x0113
            r3.disconnect()
        L_0x0113:
            com.google.android.gms.measurement.internal.zzfz r0 = r13.zzf
            com.google.android.gms.measurement.internal.zzhc r0 = r0.zzl()
            com.google.android.gms.measurement.internal.zzgb r1 = new com.google.android.gms.measurement.internal.zzgb
            java.lang.String r5 = r13.zzd
            com.google.android.gms.measurement.internal.zzgc r6 = r13.zzc
            r8 = 0
            r9 = 0
            r11 = 0
            r4 = r1
            r4.<init>(r5, r6, r7, r8, r9, r10)
            r0.zzb((java.lang.Runnable) r1)
            throw r2
        L_0x012a:
            r4 = move-exception
            r3 = r1
            r10 = r3
        L_0x012d:
            r7 = r2
        L_0x012e:
            r8 = r4
        L_0x012f:
            if (r1 == 0) goto L_0x0149
            r1.close()     // Catch:{ IOException -> 0x0135 }
            goto L_0x0149
        L_0x0135:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzfz r2 = r13.zzf
            com.google.android.gms.measurement.internal.zzfw r2 = r2.zzj()
            com.google.android.gms.measurement.internal.zzfy r2 = r2.zzg()
            java.lang.String r4 = r13.zzd
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzfw.zza((java.lang.String) r4)
            r2.zza(r0, r4, r1)
        L_0x0149:
            if (r3 == 0) goto L_0x014e
            r3.disconnect()
        L_0x014e:
            com.google.android.gms.measurement.internal.zzfz r0 = r13.zzf
            com.google.android.gms.measurement.internal.zzhc r0 = r0.zzl()
            com.google.android.gms.measurement.internal.zzgb r1 = new com.google.android.gms.measurement.internal.zzgb
            java.lang.String r5 = r13.zzd
            com.google.android.gms.measurement.internal.zzgc r6 = r13.zzc
            r9 = 0
            r11 = 0
            r4 = r1
            r4.<init>(r5, r6, r7, r8, r9, r10)
            r0.zzb((java.lang.Runnable) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgd.run():void");
    }
}
