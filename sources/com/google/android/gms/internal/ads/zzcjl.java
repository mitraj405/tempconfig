package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzcjl implements zzdtt {
    private final zzcif zza;
    private Context zzb;
    private zzbjw zzc;

    public /* synthetic */ zzcjl(zzcif zzcif, zzcjk zzcjk) {
        this.zza = zzcif;
    }

    public final /* synthetic */ zzdtt zza(zzbjw zzbjw) {
        zzbjw.getClass();
        this.zzc = zzbjw;
        return this;
    }

    public final /* synthetic */ zzdtt zzb(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }

    public final zzdtu zzc() {
        zzhfk.zzc(this.zzb, Context.class);
        zzhfk.zzc(this.zzc, zzbjw.class);
        return new zzcjn(this.zza, this.zzb, this.zzc, (zzcjm) null);
    }
}
