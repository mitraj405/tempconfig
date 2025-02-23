package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzegy implements zzdgx {
    private final zzfel zza;
    private final zzbql zzb;
    private final AdFormat zzc;
    private zzcxi zzd = null;

    public zzegy(zzfel zzfel, zzbql zzbql, AdFormat adFormat) {
        this.zza = zzfel;
        this.zzb = zzbql;
        this.zzc = adFormat;
    }

    public final void zza(boolean z, Context context, zzcxd zzcxd) throws zzdgw {
        boolean z2;
        try {
            AdFormat adFormat = AdFormat.BANNER;
            int ordinal = this.zzc.ordinal();
            if (ordinal == 1) {
                z2 = this.zzb.zzs(ObjectWrapper.wrap(context));
            } else if (ordinal != 2) {
                if (ordinal == 5) {
                    z2 = this.zzb.zzr(ObjectWrapper.wrap(context));
                }
                throw new zzdgw("Adapter failed to show.");
            } else {
                z2 = this.zzb.zzt(ObjectWrapper.wrap(context));
            }
            if (z2) {
                if (this.zzd != null) {
                    if (!((Boolean) zzba.zzc().zza(zzbbw.zzbm)).booleanValue() && this.zza.zzY == 2) {
                        this.zzd.zza();
                        return;
                    }
                    return;
                }
                return;
            }
            throw new zzdgw("Adapter failed to show.");
        } catch (Throwable th) {
            throw new zzdgw(th);
        }
    }

    public final void zzb(zzcxi zzcxi) {
        this.zzd = zzcxi;
    }
}
