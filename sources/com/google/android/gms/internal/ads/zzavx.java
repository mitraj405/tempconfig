package com.google.android.gms.internal.ads;

import android.app.AppOpsManager;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzavx implements AppOpsManager.OnOpActiveChangedListener {
    final /* synthetic */ zzavy zza;

    public zzavx(zzavy zzavy) {
        this.zza = zzavy;
    }

    public final void onOpActiveChanged(String str, int i, String str2, boolean z) {
        if (z) {
            this.zza.zzb = System.currentTimeMillis();
            this.zza.zze = true;
            return;
        }
        zzavy zzavy = this.zza;
        long currentTimeMillis = System.currentTimeMillis();
        if (zzavy.zzc > 0) {
            zzavy zzavy2 = this.zza;
            if (currentTimeMillis >= zzavy2.zzc) {
                zzavy2.zzd = currentTimeMillis - zzavy2.zzc;
            }
        }
        this.zza.zze = false;
    }
}
