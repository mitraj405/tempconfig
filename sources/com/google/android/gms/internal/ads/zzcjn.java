package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzcjn implements zzdtu {
    /* access modifiers changed from: private */
    public final Context zza;
    private final zzbjw zzb;
    private final zzcif zzc;
    private final zzcjn zzd = this;
    private final zzhfl zze;
    private final zzhfl zzf;
    private final zzhfl zzg;
    private final zzhfl zzh;

    public /* synthetic */ zzcjn(zzcif zzcif, Context context, zzbjw zzbjw, zzcjm zzcjm) {
        this.zzc = zzcif;
        this.zza = context;
        this.zzb = zzbjw;
        zzhfc zza2 = zzhfd.zza(this);
        this.zze = zza2;
        zzhfc zza3 = zzhfd.zza(zzbjw);
        this.zzf = zza3;
        zzdtq zzdtq = new zzdtq(zza3);
        this.zzg = zzdtq;
        this.zzh = zzhfb.zzc(new zzdts(zza2, zzdtq));
    }

    public final zzdtl zzb() {
        return new zzcjh(this.zzc, this.zzd, (zzcjg) null);
    }

    public final zzdtr zzd() {
        return (zzdtr) this.zzh.zzb();
    }
}
