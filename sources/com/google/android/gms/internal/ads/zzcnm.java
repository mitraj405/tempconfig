package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcnm implements zzcwt {
    private final zzfeo zza;
    private final zzfex zzb;
    private final zzflh zzc;
    private final zzfll zzd;

    public zzcnm(zzfex zzfex, zzfll zzfll, zzflh zzflh) {
        this.zzb = zzfex;
        this.zzd = zzfll;
        this.zzc = zzflh;
        this.zza = zzfex.zzb.zzb;
    }

    public final void zzdB(zze zze) {
        List list = this.zza.zza;
        this.zzd.zzd(this.zzc.zzc(this.zzb, (zzfel) null, list));
    }
}
