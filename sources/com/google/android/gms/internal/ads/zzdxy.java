package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzdxy implements zzgcf {
    final /* synthetic */ Context zza;

    public zzdxy(Context context) {
        this.zza = context;
    }

    public final void zza(Throwable th) {
        if (((Boolean) zzbdk.zzh.zze()).booleanValue() && (th instanceof zzba)) {
            zzbbg.zze(this.zza);
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdyq zzdyq = (zzdyq) obj;
        if (((Boolean) zzbdk.zzj.zze()).booleanValue()) {
            zzbbg.zze(this.zza);
        }
    }
}
