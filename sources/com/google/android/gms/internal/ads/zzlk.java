package com.google.android.gms.internal.ads;

import android.content.Context;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzlk {
    private final zzif zza;

    @Deprecated
    public zzlk(Context context, zzcdt zzcdt) {
        this.zza = new zzif(context, zzcdt);
    }

    @Deprecated
    public final zzlk zza(zzkb zzkb) {
        zzif zzif = this.zza;
        zzdi.zzf(!zzif.zzr);
        zzkb.getClass();
        zzif.zzf = new zzhx(zzkb);
        return this;
    }

    @Deprecated
    public final zzlk zzb(zzyb zzyb) {
        zzif zzif = this.zza;
        zzdi.zzf(!zzif.zzr);
        zzyb.getClass();
        zzif.zze = new zzie(zzyb);
        return this;
    }

    @Deprecated
    public final zzll zzc() {
        zzif zzif = this.zza;
        zzdi.zzf(!zzif.zzr);
        zzif.zzr = true;
        return new zzll(zzif);
    }
}
