package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcrh implements zzcye, zzcxk {
    private final Context zza;
    private final zzcej zzb;
    private final zzfel zzc;
    private final VersionInfoParcel zzd;
    private zzeeo zze;
    private boolean zzf;
    private final zzeem zzg;

    public zzcrh(Context context, zzcej zzcej, zzfel zzfel, VersionInfoParcel versionInfoParcel, zzeem zzeem) {
        this.zza = context;
        this.zzb = zzcej;
        this.zzc = zzfel;
        this.zzd = versionInfoParcel;
        this.zzg = zzeem;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00dd, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void zza() {
        /*
            r12 = this;
            monitor-enter(r12)
            com.google.android.gms.internal.ads.zzfel r0 = r12.zzc     // Catch:{ all -> 0x00de }
            boolean r0 = r0.zzT     // Catch:{ all -> 0x00de }
            if (r0 != 0) goto L_0x0009
            goto L_0x00dc
        L_0x0009:
            com.google.android.gms.internal.ads.zzcej r0 = r12.zzb     // Catch:{ all -> 0x00de }
            if (r0 == 0) goto L_0x00dc
            android.content.Context r0 = r12.zza     // Catch:{ all -> 0x00de }
            com.google.android.gms.internal.ads.zzeej r1 = com.google.android.gms.ads.internal.zzu.zzA()     // Catch:{ all -> 0x00de }
            boolean r0 = r1.zzl(r0)     // Catch:{ all -> 0x00de }
            if (r0 == 0) goto L_0x00dc
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r0 = r12.zzd     // Catch:{ all -> 0x00de }
            int r1 = r0.buddyApkVersion     // Catch:{ all -> 0x00de }
            int r0 = r0.clientJarVersion     // Catch:{ all -> 0x00de }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00de }
            r2.<init>()     // Catch:{ all -> 0x00de }
            r2.append(r1)     // Catch:{ all -> 0x00de }
            java.lang.String r1 = "."
            r2.append(r1)     // Catch:{ all -> 0x00de }
            r2.append(r0)     // Catch:{ all -> 0x00de }
            java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x00de }
            com.google.android.gms.internal.ads.zzfel r0 = r12.zzc     // Catch:{ all -> 0x00de }
            com.google.android.gms.internal.ads.zzffj r0 = r0.zzV     // Catch:{ all -> 0x00de }
            java.lang.String r8 = r0.zza()     // Catch:{ all -> 0x00de }
            int r0 = r0.zzc()     // Catch:{ all -> 0x00de }
            r1 = 1
            if (r0 != r1) goto L_0x0049
            com.google.android.gms.internal.ads.zzeek r0 = com.google.android.gms.internal.ads.zzeek.VIDEO     // Catch:{ all -> 0x00de }
            com.google.android.gms.internal.ads.zzeel r2 = com.google.android.gms.internal.ads.zzeel.DEFINED_BY_JAVASCRIPT     // Catch:{ all -> 0x00de }
            r10 = r0
            r9 = r2
            goto L_0x0058
        L_0x0049:
            com.google.android.gms.internal.ads.zzfel r0 = r12.zzc     // Catch:{ all -> 0x00de }
            com.google.android.gms.internal.ads.zzeek r2 = com.google.android.gms.internal.ads.zzeek.HTML_DISPLAY     // Catch:{ all -> 0x00de }
            int r0 = r0.zze     // Catch:{ all -> 0x00de }
            if (r0 != r1) goto L_0x0054
            com.google.android.gms.internal.ads.zzeel r0 = com.google.android.gms.internal.ads.zzeel.ONE_PIXEL     // Catch:{ all -> 0x00de }
            goto L_0x0056
        L_0x0054:
            com.google.android.gms.internal.ads.zzeel r0 = com.google.android.gms.internal.ads.zzeel.BEGIN_TO_RENDER     // Catch:{ all -> 0x00de }
        L_0x0056:
            r9 = r0
            r10 = r2
        L_0x0058:
            com.google.android.gms.internal.ads.zzcej r0 = r12.zzb     // Catch:{ all -> 0x00de }
            com.google.android.gms.internal.ads.zzfel r2 = r12.zzc     // Catch:{ all -> 0x00de }
            com.google.android.gms.internal.ads.zzeej r3 = com.google.android.gms.ads.internal.zzu.zzA()     // Catch:{ all -> 0x00de }
            android.webkit.WebView r5 = r0.zzG()     // Catch:{ all -> 0x00de }
            java.lang.String r11 = r2.zzal     // Catch:{ all -> 0x00de }
            java.lang.String r6 = ""
            java.lang.String r7 = "javascript"
            com.google.android.gms.internal.ads.zzeeo r0 = r3.zza(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x00de }
            r12.zze = r0     // Catch:{ all -> 0x00de }
            com.google.android.gms.internal.ads.zzcej r2 = r12.zzb     // Catch:{ all -> 0x00de }
            if (r0 == 0) goto L_0x00dc
            com.google.android.gms.internal.ads.zzflq r0 = r0.zza()     // Catch:{ all -> 0x00de }
            com.google.android.gms.internal.ads.zzbbn r3 = com.google.android.gms.internal.ads.zzbbw.zzeB     // Catch:{ all -> 0x00de }
            com.google.android.gms.internal.ads.zzbbu r4 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x00de }
            java.lang.Object r3 = r4.zza(r3)     // Catch:{ all -> 0x00de }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x00de }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x00de }
            if (r3 == 0) goto L_0x00b5
            com.google.android.gms.internal.ads.zzcej r2 = r12.zzb     // Catch:{ all -> 0x00de }
            com.google.android.gms.internal.ads.zzeej r3 = com.google.android.gms.ads.internal.zzu.zzA()     // Catch:{ all -> 0x00de }
            android.webkit.WebView r2 = r2.zzG()     // Catch:{ all -> 0x00de }
            r3.zzj(r0, r2)     // Catch:{ all -> 0x00de }
            com.google.android.gms.internal.ads.zzcej r2 = r12.zzb     // Catch:{ all -> 0x00de }
            java.util.List r2 = r2.zzV()     // Catch:{ all -> 0x00de }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x00de }
        L_0x00a1:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x00de }
            if (r3 == 0) goto L_0x00be
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x00de }
            android.view.View r3 = (android.view.View) r3     // Catch:{ all -> 0x00de }
            com.google.android.gms.internal.ads.zzeej r4 = com.google.android.gms.ads.internal.zzu.zzA()     // Catch:{ all -> 0x00de }
            r4.zzg(r0, r3)     // Catch:{ all -> 0x00de }
            goto L_0x00a1
        L_0x00b5:
            com.google.android.gms.internal.ads.zzeej r3 = com.google.android.gms.ads.internal.zzu.zzA()     // Catch:{ all -> 0x00de }
            android.view.View r2 = (android.view.View) r2     // Catch:{ all -> 0x00de }
            r3.zzj(r0, r2)     // Catch:{ all -> 0x00de }
        L_0x00be:
            com.google.android.gms.internal.ads.zzcej r2 = r12.zzb     // Catch:{ all -> 0x00de }
            com.google.android.gms.internal.ads.zzeeo r3 = r12.zze     // Catch:{ all -> 0x00de }
            r2.zzat(r3)     // Catch:{ all -> 0x00de }
            com.google.android.gms.internal.ads.zzeej r2 = com.google.android.gms.ads.internal.zzu.zzA()     // Catch:{ all -> 0x00de }
            r2.zzk(r0)     // Catch:{ all -> 0x00de }
            r12.zzf = r1     // Catch:{ all -> 0x00de }
            com.google.android.gms.internal.ads.zzcej r0 = r12.zzb     // Catch:{ all -> 0x00de }
            androidx.collection.ArrayMap r1 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x00de }
            r1.<init>()     // Catch:{ all -> 0x00de }
            java.lang.String r2 = "onSdkLoaded"
            r0.zzd(r2, r1)     // Catch:{ all -> 0x00de }
            monitor-exit(r12)
            return
        L_0x00dc:
            monitor-exit(r12)
            return
        L_0x00de:
            r0 = move-exception
            monitor-exit(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcrh.zza():void");
    }

    private final boolean zzb() {
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzeC)).booleanValue() || !this.zzg.zzd()) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0030, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzr() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzb()     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x000e
            com.google.android.gms.internal.ads.zzeem r0 = r3.zzg     // Catch:{ all -> 0x0031 }
            r0.zzb()     // Catch:{ all -> 0x0031 }
            monitor-exit(r3)
            return
        L_0x000e:
            boolean r0 = r3.zzf     // Catch:{ all -> 0x0031 }
            if (r0 != 0) goto L_0x0015
            r3.zza()     // Catch:{ all -> 0x0031 }
        L_0x0015:
            com.google.android.gms.internal.ads.zzfel r0 = r3.zzc     // Catch:{ all -> 0x0031 }
            boolean r0 = r0.zzT     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x002f
            com.google.android.gms.internal.ads.zzeeo r0 = r3.zze     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x002f
            com.google.android.gms.internal.ads.zzcej r0 = r3.zzb     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x002f
            androidx.collection.ArrayMap r1 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x0031 }
            r1.<init>()     // Catch:{ all -> 0x0031 }
            java.lang.String r2 = "onSdkImpression"
            r0.zzd(r2, r1)     // Catch:{ all -> 0x0031 }
            monitor-exit(r3)
            return
        L_0x002f:
            monitor-exit(r3)
            return
        L_0x0031:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcrh.zzr():void");
    }

    public final synchronized void zzs() {
        if (zzb()) {
            this.zzg.zzc();
        } else if (!this.zzf) {
            zza();
        }
    }
}
