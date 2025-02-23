package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public abstract class zzflq {
    public static zzflq zza(zzflr zzflr, zzfls zzfls) {
        zzfnj.zza();
        return new zzflu(zzflr, zzfls, UUID.randomUUID().toString());
    }

    public abstract void zzb(View view, zzflx zzflx, String str);

    public abstract void zzc();

    public abstract void zzd(View view);

    public abstract void zze();
}
