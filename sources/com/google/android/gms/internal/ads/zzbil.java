package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbw;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbil implements zzgcf {
    final /* synthetic */ zzcej zza;

    public zzbil(zzcej zzcej) {
        this.zza = zzcej;
    }

    public final void zza(Throwable th) {
        zzu.zzo().zzw(th, "DefaultGmsgHandlers.attributionReportingManager");
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcej zzcej = this.zza;
        new zzbw(zzcej.getContext(), zzcej.zzn().afmaVersion, (String) obj).zzb();
    }
}
