package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzqd {
    private final zzct[] zza;
    private final zzqx zzb;
    private final zzcw zzc;

    public zzqd(zzct... zzctArr) {
        zzqx zzqx = new zzqx();
        zzcw zzcw = new zzcw();
        zzct[] zzctArr2 = new zzct[2];
        this.zza = zzctArr2;
        System.arraycopy(zzctArr, 0, zzctArr2, 0, 0);
        this.zzb = zzqx;
        this.zzc = zzcw;
        zzctArr2[0] = zzqx;
        zzctArr2[1] = zzcw;
    }

    public final long zza(long j) {
        if (this.zzc.zzg()) {
            return this.zzc.zzi(j);
        }
        return j;
    }

    public final long zzb() {
        return this.zzb.zzo();
    }

    public final zzbq zzc(zzbq zzbq) {
        this.zzc.zzk(zzbq.zzb);
        this.zzc.zzj(zzbq.zzc);
        return zzbq;
    }

    public final boolean zzd(boolean z) {
        this.zzb.zzp(z);
        return z;
    }

    public final zzct[] zze() {
        return this.zza;
    }
}
