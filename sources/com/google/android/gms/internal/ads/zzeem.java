package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeem {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private final zzfel zzc;
    private final zzcej zzd;
    private zzfmb zze;

    public zzeem(Context context, VersionInfoParcel versionInfoParcel, zzfel zzfel, zzcej zzcej) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = zzfel;
        this.zzd = zzcej;
    }

    public final synchronized void zza(View view) {
        zzfmb zzfmb = this.zze;
        if (zzfmb != null) {
            zzu.zzA().zzh(zzfmb, view);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0015, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzb() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzfmb r0 = r3.zze     // Catch:{ all -> 0x0016 }
            if (r0 == 0) goto L_0x0014
            com.google.android.gms.internal.ads.zzcej r0 = r3.zzd     // Catch:{ all -> 0x0016 }
            if (r0 == 0) goto L_0x0014
            java.lang.String r1 = "onSdkImpression"
            com.google.android.gms.internal.ads.zzfxu r2 = com.google.android.gms.internal.ads.zzfxu.zzd()     // Catch:{ all -> 0x0016 }
            r0.zzd(r1, r2)     // Catch:{ all -> 0x0016 }
            monitor-exit(r3)
            return
        L_0x0014:
            monitor-exit(r3)
            return
        L_0x0016:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeem.zzb():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzc() {
        /*
            r4 = this;
            monitor-enter(r4)
            com.google.android.gms.internal.ads.zzfmb r0 = r4.zze     // Catch:{ all -> 0x0034 }
            if (r0 == 0) goto L_0x0032
            com.google.android.gms.internal.ads.zzcej r1 = r4.zzd     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0032
            java.util.List r1 = r1.zzV()     // Catch:{ all -> 0x0034 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0034 }
        L_0x0011:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0034 }
            if (r2 == 0) goto L_0x0025
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0034 }
            android.view.View r2 = (android.view.View) r2     // Catch:{ all -> 0x0034 }
            com.google.android.gms.internal.ads.zzeej r3 = com.google.android.gms.ads.internal.zzu.zzA()     // Catch:{ all -> 0x0034 }
            r3.zzh(r0, r2)     // Catch:{ all -> 0x0034 }
            goto L_0x0011
        L_0x0025:
            com.google.android.gms.internal.ads.zzcej r0 = r4.zzd     // Catch:{ all -> 0x0034 }
            java.lang.String r1 = "onSdkLoaded"
            com.google.android.gms.internal.ads.zzfxu r2 = com.google.android.gms.internal.ads.zzfxu.zzd()     // Catch:{ all -> 0x0034 }
            r0.zzd(r1, r2)     // Catch:{ all -> 0x0034 }
            monitor-exit(r4)
            return
        L_0x0032:
            monitor-exit(r4)
            return
        L_0x0034:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeem.zzc():void");
    }

    public final synchronized boolean zzd() {
        if (this.zze != null) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0082, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zze(boolean r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            com.google.android.gms.internal.ads.zzfel r5 = r4.zzc     // Catch:{ all -> 0x0083 }
            boolean r5 = r5.zzT     // Catch:{ all -> 0x0083 }
            r0 = 0
            if (r5 == 0) goto L_0x0081
            com.google.android.gms.internal.ads.zzbbn r5 = com.google.android.gms.internal.ads.zzbbw.zzez     // Catch:{ all -> 0x0083 }
            com.google.android.gms.internal.ads.zzbbu r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x0083 }
            java.lang.Object r5 = r1.zza(r5)     // Catch:{ all -> 0x0083 }
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ all -> 0x0083 }
            boolean r5 = r5.booleanValue()     // Catch:{ all -> 0x0083 }
            if (r5 == 0) goto L_0x0081
            com.google.android.gms.internal.ads.zzbbn r5 = com.google.android.gms.internal.ads.zzbbw.zzeC     // Catch:{ all -> 0x0083 }
            com.google.android.gms.internal.ads.zzbbu r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x0083 }
            java.lang.Object r5 = r1.zza(r5)     // Catch:{ all -> 0x0083 }
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ all -> 0x0083 }
            boolean r5 = r5.booleanValue()     // Catch:{ all -> 0x0083 }
            if (r5 == 0) goto L_0x0081
            com.google.android.gms.internal.ads.zzcej r5 = r4.zzd     // Catch:{ all -> 0x0083 }
            if (r5 != 0) goto L_0x0031
            goto L_0x0081
        L_0x0031:
            com.google.android.gms.internal.ads.zzfmb r5 = r4.zze     // Catch:{ all -> 0x0083 }
            if (r5 == 0) goto L_0x003c
            java.lang.String r5 = "Omid javascript session service already started for ad."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r5)     // Catch:{ all -> 0x0083 }
            monitor-exit(r4)
            return r0
        L_0x003c:
            android.content.Context r5 = r4.zza     // Catch:{ all -> 0x0083 }
            com.google.android.gms.internal.ads.zzeej r1 = com.google.android.gms.ads.internal.zzu.zzA()     // Catch:{ all -> 0x0083 }
            boolean r5 = r1.zzl(r5)     // Catch:{ all -> 0x0083 }
            if (r5 != 0) goto L_0x004f
            java.lang.String r5 = "Unable to initialize omid."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r5)     // Catch:{ all -> 0x0083 }
            monitor-exit(r4)
            return r0
        L_0x004f:
            com.google.android.gms.internal.ads.zzfel r5 = r4.zzc     // Catch:{ all -> 0x0083 }
            com.google.android.gms.internal.ads.zzffj r5 = r5.zzV     // Catch:{ all -> 0x0083 }
            boolean r5 = r5.zzb()     // Catch:{ all -> 0x0083 }
            if (r5 == 0) goto L_0x0081
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r5 = r4.zzb     // Catch:{ all -> 0x0083 }
            com.google.android.gms.internal.ads.zzcej r1 = r4.zzd     // Catch:{ all -> 0x0083 }
            com.google.android.gms.internal.ads.zzeej r2 = com.google.android.gms.ads.internal.zzu.zzA()     // Catch:{ all -> 0x0083 }
            android.webkit.WebView r1 = r1.zzG()     // Catch:{ all -> 0x0083 }
            r3 = 1
            com.google.android.gms.internal.ads.zzfmb r5 = r2.zze(r5, r1, r3)     // Catch:{ all -> 0x0083 }
            if (r5 != 0) goto L_0x0073
            java.lang.String r5 = "Unable to create javascript session service."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r5)     // Catch:{ all -> 0x0083 }
            monitor-exit(r4)
            return r0
        L_0x0073:
            java.lang.String r0 = "Created omid javascript session service."
            com.google.android.gms.ads.internal.util.client.zzm.zzi(r0)     // Catch:{ all -> 0x0083 }
            r4.zze = r5     // Catch:{ all -> 0x0083 }
            com.google.android.gms.internal.ads.zzcej r5 = r4.zzd     // Catch:{ all -> 0x0083 }
            r5.zzas(r4)     // Catch:{ all -> 0x0083 }
            monitor-exit(r4)
            return r3
        L_0x0081:
            monitor-exit(r4)
            return r0
        L_0x0083:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeem.zze(boolean):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzf(com.google.android.gms.internal.ads.zzcey r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzfmb r0 = r2.zze     // Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x001a
            com.google.android.gms.internal.ads.zzcej r1 = r2.zzd     // Catch:{ all -> 0x001c }
            if (r1 == 0) goto L_0x001a
            com.google.android.gms.internal.ads.zzeej r1 = com.google.android.gms.ads.internal.zzu.zzA()     // Catch:{ all -> 0x001c }
            r1.zzm(r0, r3)     // Catch:{ all -> 0x001c }
            r3 = 0
            r2.zze = r3     // Catch:{ all -> 0x001c }
            com.google.android.gms.internal.ads.zzcej r0 = r2.zzd     // Catch:{ all -> 0x001c }
            r0.zzas(r3)     // Catch:{ all -> 0x001c }
            monitor-exit(r2)
            return
        L_0x001a:
            monitor-exit(r2)
            return
        L_0x001c:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeem.zzf(com.google.android.gms.internal.ads.zzcey):void");
    }
}
