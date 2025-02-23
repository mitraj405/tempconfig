package com.google.android.gms.internal.ads;

import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzvo extends zzth implements zzvf {
    private final zzfr zza;
    private final zzri zzb;
    private final int zzc;
    private boolean zzd = true;
    private long zze = -9223372036854775807L;
    private boolean zzf;
    private boolean zzg;
    private zzgu zzh;
    private zzbc zzi;
    private final zzvl zzj;
    private final zzyo zzk;

    public /* synthetic */ zzvo(zzbc zzbc, zzfr zzfr, zzvl zzvl, zzri zzri, zzyo zzyo, int i, zzvn zzvn) {
        this.zzi = zzbc;
        this.zza = zzfr;
        this.zzj = zzvl;
        this.zzb = zzri;
        this.zzk = zzyo;
        this.zzc = i;
    }

    private final void zzw() {
        zzav zzav;
        zzcc zzcc;
        long j = this.zze;
        boolean z = this.zzf;
        boolean z2 = this.zzg;
        zzbc zzJ = zzJ();
        if (z2) {
            zzav = zzJ.zzc;
        } else {
            zzav = null;
        }
        zzwb zzwb = r1;
        boolean z3 = z;
        long j2 = j;
        zzwb zzwb2 = new zzwb(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, j, j2, 0, 0, z3, false, false, (Object) null, zzJ, zzav);
        if (this.zzd) {
            zzcc = new zzvk(this, zzwb);
        } else {
            zzcc = zzwb;
        }
        zzo(zzcc);
    }

    public final void zzG(zzug zzug) {
        ((zzvj) zzug).zzN();
    }

    public final zzug zzI(zzui zzui, zzyk zzyk, long j) {
        zzfs zza2 = this.zza.zza();
        zzgu zzgu = this.zzh;
        if (zzgu != null) {
            zza2.zzf(zzgu);
        }
        zzax zzax = zzJ().zzb;
        zzax.getClass();
        zzvl zzvl = this.zzj;
        zzb();
        return new zzvj(zzax.zza, zza2, new zztk(zzvl.zza), this.zzb, zzc(zzui), this.zzk, zze(zzui), this, zzyk, (String) null, this.zzc, zzet.zzr(-9223372036854775807L));
    }

    public final synchronized zzbc zzJ() {
        return this.zzi;
    }

    public final void zza(long j, boolean z, boolean z2) {
        if (j == -9223372036854775807L) {
            j = this.zze;
        }
        if (this.zzd || this.zze != j || this.zzf != z || this.zzg != z2) {
            this.zze = j;
            this.zzf = z;
            this.zzg = z2;
            this.zzd = false;
            zzw();
        }
    }

    public final void zzn(zzgu zzgu) {
        this.zzh = zzgu;
        Looper.myLooper().getClass();
        zzb();
        zzw();
    }

    public final synchronized void zzt(zzbc zzbc) {
        this.zzi = zzbc;
    }

    public final void zzq() {
    }

    public final void zzz() {
    }
}
