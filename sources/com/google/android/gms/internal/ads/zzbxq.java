package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzff;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbxq {
    private final Clock zza;
    private final zzbxo zzb;

    public zzbxq(Clock clock, zzbxo zzbxo) {
        this.zza = clock;
        this.zzb = zzbxo;
    }

    public static zzbxq zza(Context context) {
        return zzbyb.zzd(context).zzb();
    }

    public final void zzb(int i, long j) {
        this.zzb.zza(i, j);
    }

    public final void zzc(zzff zzff) {
        this.zzb.zza(-1, this.zza.currentTimeMillis());
    }

    public final void zzd() {
        this.zzb.zza(-1, this.zza.currentTimeMillis());
    }
}
