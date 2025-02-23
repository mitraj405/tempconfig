package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbxo {
    private final zzg zza;

    public zzbxo(Clock clock, zzg zzg, zzbya zzbya) {
        this.zza = zzg;
    }

    public final void zza(int i, long j) {
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzak)).booleanValue()) {
            if (j - this.zza.zzf() < 0) {
                zze.zza("Receiving npa decision in the past, ignoring.");
                return;
            }
            if (!((Boolean) zzba.zzc().zza(zzbbw.zzal)).booleanValue()) {
                this.zza.zzM(-1);
                this.zza.zzN(j);
                return;
            }
            this.zza.zzM(i);
            this.zza.zzN(j);
        }
    }
}
