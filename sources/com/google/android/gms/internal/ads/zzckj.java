package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nonagon.signalgeneration.zzap;
import com.google.android.gms.ads.nonagon.signalgeneration.zzr;
import com.google.android.gms.ads.nonagon.signalgeneration.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzckj implements zzr {
    private final zzcif zza;
    private zzcwa zzb;
    private zzap zzc;

    public /* synthetic */ zzckj(zzcif zzcif, zzcki zzcki) {
        this.zza = zzcif;
    }

    public final /* synthetic */ zzr zza(zzcwa zzcwa) {
        this.zzb = zzcwa;
        return this;
    }

    public final /* synthetic */ zzr zzb(zzap zzap) {
        this.zzc = zzap;
        return this;
    }

    public final zzs zzc() {
        zzhfk.zzc(this.zzb, zzcwa.class);
        zzhfk.zzc(this.zzc, zzap.class);
        return new zzckl(this.zza, this.zzc, new zzcte(), new zzcvd(), new zzdsy(), this.zzb, (zzfcg) null, (zzfbj) null, (zzckk) null);
    }
}
