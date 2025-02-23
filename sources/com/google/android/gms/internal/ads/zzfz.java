package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfz implements zzfr {
    private final Context zza;
    private final zzfr zzb;

    public zzfz(Context context) {
        zzgb zzgb = new zzgb();
        this.zza = context.getApplicationContext();
        this.zzb = zzgb;
    }

    public final /* bridge */ /* synthetic */ zzfs zza() {
        return new zzga(this.zza, ((zzgb) this.zzb).zza());
    }
}
