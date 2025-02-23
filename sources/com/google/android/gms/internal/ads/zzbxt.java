package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbxt {
    private Context zza;
    private Clock zzb;
    private zzg zzc;
    private zzbya zzd;

    private zzbxt() {
        throw null;
    }

    public /* synthetic */ zzbxt(zzbxs zzbxs) {
    }

    public final zzbxt zza(zzg zzg) {
        this.zzc = zzg;
        return this;
    }

    public final zzbxt zzb(Context context) {
        context.getClass();
        this.zza = context;
        return this;
    }

    public final zzbxt zzc(Clock clock) {
        clock.getClass();
        this.zzb = clock;
        return this;
    }

    public final zzbxt zzd(zzbya zzbya) {
        this.zzd = zzbya;
        return this;
    }

    public final zzbyb zze() {
        zzhfk.zzc(this.zza, Context.class);
        zzhfk.zzc(this.zzb, Clock.class);
        zzhfk.zzc(this.zzc, zzg.class);
        zzhfk.zzc(this.zzd, zzbya.class);
        return new zzbxv(this.zza, this.zzb, this.zzc, this.zzd, (zzbxu) null);
    }
}
