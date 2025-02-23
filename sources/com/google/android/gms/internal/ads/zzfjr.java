package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfjr implements zzddv, zzcxg, zzddz {
    private final zzfkf zza;
    private final zzfju zzb;

    public zzfjr(Context context, zzfkf zzfkf) {
        this.zza = zzfkf;
        this.zzb = zzfjt.zza(context, 13);
    }

    public final void zzb() {
        if (((Boolean) zzbdl.zzd.zze()).booleanValue()) {
            zzfkf zzfkf = this.zza;
            zzfju zzfju = this.zzb;
            zzfju.zzg(true);
            zzfkf.zza(zzfju);
        }
    }

    public final void zzl() {
        if (((Boolean) zzbdl.zzd.zze()).booleanValue()) {
            this.zzb.zzi();
        }
    }

    public final void zzq(zze zze) {
        if (((Boolean) zzbdl.zzd.zze()).booleanValue()) {
            zzfkf zzfkf = this.zza;
            zzfju zzfju = this.zzb;
            zzfju.zzc(zze.zza().toString());
            zzfju.zzg(false);
            zzfkf.zza(zzfju);
        }
    }

    public final void zza() {
    }

    public final void zzk() {
    }
}
