package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzwf implements zzug, zzuf {
    private final zzug zza;
    private final long zzb;
    private zzuf zzc;

    public zzwf(zzug zzug, long j) {
        this.zza = zzug;
        this.zzb = j;
    }

    public final long zza(long j, zzlj zzlj) {
        long j2 = this.zzb;
        return this.zza.zza(j - j2, zzlj) + j2;
    }

    public final long zzb() {
        long zzb2 = this.zza.zzb();
        if (zzb2 == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return zzb2 + this.zzb;
    }

    public final long zzc() {
        long zzc2 = this.zza.zzc();
        if (zzc2 == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return zzc2 + this.zzb;
    }

    public final long zzd() {
        long zzd = this.zza.zzd();
        if (zzd == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return zzd + this.zzb;
    }

    public final long zze(long j) {
        long j2 = this.zzb;
        return this.zza.zze(j - j2) + j2;
    }

    public final /* bridge */ /* synthetic */ void zzf(zzvz zzvz) {
        zzug zzug = (zzug) zzvz;
        zzuf zzuf = this.zzc;
        zzuf.getClass();
        zzuf.zzf(this);
    }

    public final long zzg(zzxv[] zzxvArr, boolean[] zArr, zzvx[] zzvxArr, boolean[] zArr2, long j) {
        zzvx[] zzvxArr2 = zzvxArr;
        zzvx[] zzvxArr3 = new zzvx[zzvxArr2.length];
        int i = 0;
        while (true) {
            zzvx zzvx = null;
            if (i >= zzvxArr2.length) {
                break;
            }
            zzwe zzwe = (zzwe) zzvxArr2[i];
            if (zzwe != null) {
                zzvx = zzwe.zzc();
            }
            zzvxArr3[i] = zzvx;
            i++;
        }
        long zzg = this.zza.zzg(zzxvArr, zArr, zzvxArr3, zArr2, j - this.zzb);
        for (int i2 = 0; i2 < zzvxArr2.length; i2++) {
            zzvx zzvx2 = zzvxArr3[i2];
            if (zzvx2 == null) {
                zzvxArr2[i2] = null;
            } else {
                zzvx zzvx3 = zzvxArr2[i2];
                if (zzvx3 == null || ((zzwe) zzvx3).zzc() != zzvx2) {
                    zzvxArr2[i2] = new zzwe(zzvx2, this.zzb);
                }
            }
        }
        return zzg + this.zzb;
    }

    public final void zzh(zzug zzug) {
        zzuf zzuf = this.zzc;
        zzuf.getClass();
        zzuf.zzh(this);
    }

    public final zzwi zzi() {
        return this.zza.zzi();
    }

    public final void zzj(long j, boolean z) {
        this.zza.zzj(j - this.zzb, false);
    }

    public final void zzk() throws IOException {
        this.zza.zzk();
    }

    public final void zzl(zzuf zzuf, long j) {
        this.zzc = zzuf;
        this.zza.zzl(this, j - this.zzb);
    }

    public final void zzm(long j) {
        this.zza.zzm(j - this.zzb);
    }

    public final zzug zzn() {
        return this.zza;
    }

    public final boolean zzo(zzkf zzkf) {
        long j = zzkf.zza;
        long j2 = this.zzb;
        zzkd zza2 = zzkf.zza();
        zza2.zze(j - j2);
        return this.zza.zzo(zza2.zzg());
    }

    public final boolean zzp() {
        return this.zza.zzp();
    }
}
