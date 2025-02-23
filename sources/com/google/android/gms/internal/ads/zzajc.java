package com.google.android.gms.internal.ads;

import java.math.BigInteger;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzajc implements zzadi {
    final /* synthetic */ zzajd zza;

    public /* synthetic */ zzajc(zzajd zzajd, zzajb zzajb) {
        this.zza = zzajd;
    }

    public final long zza() {
        zzajd zzajd = this.zza;
        return zzajd.zzd.zzf(zzajd.zzf);
    }

    public final zzadg zzg(long j) {
        zzajd zzajd = this.zza;
        long zzg = zzajd.zzd.zzg(j);
        long zzb = zzajd.zzb;
        BigInteger valueOf = BigInteger.valueOf(zzg);
        zzajd zzajd2 = this.zza;
        long longValue = valueOf.multiply(BigInteger.valueOf(zzajd2.zzc - zzajd2.zzb)).divide(BigInteger.valueOf(this.zza.zzf)).longValue() + zzb;
        zzajd zzajd3 = this.zza;
        zzadj zzadj = new zzadj(j, Math.max(zzajd3.zzb, Math.min(longValue - 30000, zzajd3.zzc - 1)));
        return new zzadg(zzadj, zzadj);
    }

    public final boolean zzh() {
        return true;
    }
}
