package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzaue implements zzfpk {
    final /* synthetic */ zzfoh zza;

    public zzaue(zzfoh zzfoh) {
        this.zza = zzfoh;
    }

    public final void zza(int i, long j) {
        this.zza.zzd(i, System.currentTimeMillis() - j);
    }

    public final void zzb(int i, long j, String str) {
        this.zza.zze(i, System.currentTimeMillis() - j, str);
    }
}
