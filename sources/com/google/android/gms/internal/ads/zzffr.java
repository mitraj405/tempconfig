package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzffr implements zzgcf {
    final /* synthetic */ zzffs zza;
    final /* synthetic */ int zzb;

    public zzffr(zzffs zzffs, int i) {
        this.zzb = i;
        this.zza = zzffs;
    }

    public final void zza(Throwable th) {
        zzu.zzo().zzw(th, "BufferingUrlPinger.attributionReportingManager");
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        int i = this.zzb;
        this.zza.zzb((String) obj, i);
    }
}
