package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzua implements zzug, zzuf {
    public final zzui zza;
    private final long zzb;
    private zzuk zzc;
    private zzug zzd;
    private zzuf zze;
    private long zzf = -9223372036854775807L;
    private final zzyk zzg;

    public zzua(zzui zzui, zzyk zzyk, long j) {
        this.zza = zzui;
        this.zzg = zzyk;
        this.zzb = j;
    }

    private final long zzv(long j) {
        long j2 = this.zzf;
        if (j2 != -9223372036854775807L) {
            return j2;
        }
        return j;
    }

    public final long zza(long j, zzlj zzlj) {
        zzug zzug = this.zzd;
        int i = zzet.zza;
        return zzug.zza(j, zzlj);
    }

    public final long zzb() {
        zzug zzug = this.zzd;
        int i = zzet.zza;
        return zzug.zzb();
    }

    public final long zzc() {
        zzug zzug = this.zzd;
        int i = zzet.zza;
        return zzug.zzc();
    }

    public final long zzd() {
        zzug zzug = this.zzd;
        int i = zzet.zza;
        return zzug.zzd();
    }

    public final long zze(long j) {
        zzug zzug = this.zzd;
        int i = zzet.zza;
        return zzug.zze(j);
    }

    public final /* bridge */ /* synthetic */ void zzf(zzvz zzvz) {
        zzug zzug = (zzug) zzvz;
        zzuf zzuf = this.zze;
        int i = zzet.zza;
        zzuf.zzf(this);
    }

    public final long zzg(zzxv[] zzxvArr, boolean[] zArr, zzvx[] zzvxArr, boolean[] zArr2, long j) {
        long j2;
        long j3 = this.zzf;
        if (j3 == -9223372036854775807L || j != this.zzb) {
            j2 = j;
        } else {
            j2 = j3;
        }
        this.zzf = -9223372036854775807L;
        zzug zzug = this.zzd;
        int i = zzet.zza;
        return zzug.zzg(zzxvArr, zArr, zzvxArr, zArr2, j2);
    }

    public final void zzh(zzug zzug) {
        zzuf zzuf = this.zze;
        int i = zzet.zza;
        zzuf.zzh(this);
    }

    public final zzwi zzi() {
        zzug zzug = this.zzd;
        int i = zzet.zza;
        return zzug.zzi();
    }

    public final void zzj(long j, boolean z) {
        zzug zzug = this.zzd;
        int i = zzet.zza;
        zzug.zzj(j, false);
    }

    public final void zzk() throws IOException {
        try {
            zzug zzug = this.zzd;
            if (zzug != null) {
                zzug.zzk();
                return;
            }
            zzuk zzuk = this.zzc;
            if (zzuk != null) {
                zzuk.zzz();
            }
        } catch (IOException e) {
            throw e;
        }
    }

    public final void zzl(zzuf zzuf, long j) {
        this.zze = zzuf;
        zzug zzug = this.zzd;
        if (zzug != null) {
            zzug.zzl(this, zzv(this.zzb));
        }
    }

    public final void zzm(long j) {
        zzug zzug = this.zzd;
        int i = zzet.zza;
        zzug.zzm(j);
    }

    public final long zzn() {
        return this.zzf;
    }

    public final boolean zzo(zzkf zzkf) {
        zzug zzug = this.zzd;
        if (zzug == null || !zzug.zzo(zzkf)) {
            return false;
        }
        return true;
    }

    public final boolean zzp() {
        zzug zzug = this.zzd;
        if (zzug == null || !zzug.zzp()) {
            return false;
        }
        return true;
    }

    public final long zzq() {
        return this.zzb;
    }

    public final void zzr(zzui zzui) {
        long zzv = zzv(this.zzb);
        zzuk zzuk = this.zzc;
        zzuk.getClass();
        zzug zzI = zzuk.zzI(zzui, this.zzg, zzv);
        this.zzd = zzI;
        if (this.zze != null) {
            zzI.zzl(this, zzv);
        }
    }

    public final void zzs(long j) {
        this.zzf = j;
    }

    public final void zzt() {
        zzug zzug = this.zzd;
        if (zzug != null) {
            zzuk zzuk = this.zzc;
            zzuk.getClass();
            zzuk.zzG(zzug);
        }
    }

    public final void zzu(zzuk zzuk) {
        boolean z;
        if (this.zzc == null) {
            z = true;
        } else {
            z = false;
        }
        zzdi.zzf(z);
        this.zzc = zzuk;
    }
}
