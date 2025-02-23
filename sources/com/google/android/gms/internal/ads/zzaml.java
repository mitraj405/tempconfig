package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzaml {
    private final zzadp zza;
    private final SparseArray zzb = new SparseArray();
    private final SparseArray zzc = new SparseArray();
    private final byte[] zzd;
    private int zze;
    private long zzf;
    private long zzg;
    private boolean zzh;
    private long zzi;
    private long zzj;
    private boolean zzk;
    private boolean zzl;

    public zzaml(zzadp zzadp, boolean z, boolean z2) {
        this.zza = zzadp;
        byte[] bArr = new byte[128];
        this.zzd = bArr;
        new zzfi(bArr, 0, 0);
        this.zzh = false;
    }

    private final void zzg(int i) {
        long j = this.zzj;
        if (j != -9223372036854775807L) {
            this.zza.zzs(j, this.zzk ? 1 : 0, (int) (this.zzf - this.zzi), i, (zzado) null);
        }
    }

    private final void zzh() {
        boolean z = this.zzl;
        boolean z2 = this.zzk;
        int i = this.zze;
        boolean z3 = true;
        if (i != 5 && (!z || i != 1)) {
            z3 = false;
        }
        this.zzk = z2 | z3;
    }

    public final void zza(long j) {
        zzh();
        this.zzf = j;
        zzg(0);
        this.zzh = false;
    }

    public final void zzb(zzff zzff) {
        this.zzc.append(zzff.zza, zzff);
    }

    public final void zzc(zzfg zzfg) {
        this.zzb.append(zzfg.zzd, zzfg);
    }

    public final void zzd() {
        this.zzh = false;
    }

    public final void zze(long j, int i, long j2, boolean z) {
        this.zze = i;
        this.zzg = j2;
        this.zzf = j;
        this.zzl = z;
    }

    public final boolean zzf(long j, int i, boolean z) {
        if (this.zze == 9) {
            if (z && this.zzh) {
                zzg(i + ((int) (j - this.zzf)));
            }
            this.zzi = this.zzf;
            this.zzj = this.zzg;
            this.zzk = false;
            this.zzh = true;
        }
        zzh();
        return this.zzk;
    }
}
