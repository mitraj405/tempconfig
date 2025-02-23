package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzwe implements zzvx {
    private final zzvx zza;
    private final long zzb;

    public zzwe(zzvx zzvx, long j) {
        this.zza = zzvx;
        this.zzb = j;
    }

    public final int zza(zzjz zzjz, zzhd zzhd, int i) {
        int zza2 = this.zza.zza(zzjz, zzhd, i);
        if (zza2 != -4) {
            return zza2;
        }
        zzhd.zze += this.zzb;
        return -4;
    }

    public final int zzb(long j) {
        return this.zza.zzb(j - this.zzb);
    }

    public final zzvx zzc() {
        return this.zza;
    }

    public final void zzd() throws IOException {
        this.zza.zzd();
    }

    public final boolean zze() {
        return this.zza.zze();
    }
}
