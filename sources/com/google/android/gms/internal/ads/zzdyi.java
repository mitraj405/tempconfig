package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzdyi implements zzczo {
    private final Context zza;
    private final zzbya zzb;

    public zzdyi(Context context, zzbya zzbya) {
        this.zza = context;
        this.zzb = zzbya;
    }

    public final void zzdo(zzfex zzfex) {
        if (!TextUtils.isEmpty(zzfex.zzb.zzb.zze)) {
            this.zzb.zzm(this.zza, zzfex.zza.zza.zzd);
            this.zzb.zzi(this.zza, zzfex.zzb.zzb.zze);
        }
    }

    public final void zzdn(zzbvb zzbvb) {
    }
}
