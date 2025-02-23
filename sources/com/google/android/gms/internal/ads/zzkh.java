package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzkh {
    public final zzug zza;
    public final Object zzb;
    public final zzvx[] zzc;
    public boolean zzd;
    public boolean zze;
    public zzki zzf;
    public boolean zzg;
    private final boolean[] zzh;
    private final zzlh[] zzi;
    private final zzyb zzj;
    private final zzkw zzk;
    private zzkh zzl;
    private zzwi zzm = zzwi.zza;
    private zzyc zzn;
    private long zzo;

    public zzkh(zzlh[] zzlhArr, long j, zzyb zzyb, zzyk zzyk, zzkw zzkw, zzki zzki, zzyc zzyc) {
        this.zzi = zzlhArr;
        this.zzo = j;
        this.zzj = zzyb;
        this.zzk = zzkw;
        zzui zzui = zzki.zza;
        this.zzb = zzui.zza;
        this.zzf = zzki;
        this.zzn = zzyc;
        this.zzc = new zzvx[2];
        this.zzh = new boolean[2];
        long j2 = zzki.zzb;
        long j3 = zzki.zzd;
        zzug zzp = zzkw.zzp(zzui, zzyk, j2);
        this.zza = j3 != -9223372036854775807L ? new zztm(zzp, true, 0, j3) : zzp;
    }

    private final void zzs() {
        if (zzu()) {
            int i = 0;
            while (true) {
                zzyc zzyc = this.zzn;
                if (i < zzyc.zza) {
                    zzyc.zzb(i);
                    zzxv zzxv = this.zzn.zzc[i];
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private final void zzt() {
        if (zzu()) {
            int i = 0;
            while (true) {
                zzyc zzyc = this.zzn;
                if (i < zzyc.zza) {
                    zzyc.zzb(i);
                    zzxv zzxv = this.zzn.zzc[i];
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private final boolean zzu() {
        if (this.zzl == null) {
            return true;
        }
        return false;
    }

    public final long zza(zzyc zzyc, long j, boolean z) {
        return zzb(zzyc, j, false, new boolean[2]);
    }

    public final long zzb(zzyc zzyc, long j, boolean z, boolean[] zArr) {
        boolean z2;
        zzyc zzyc2 = zzyc;
        int i = 0;
        while (true) {
            boolean z3 = true;
            if (i >= zzyc2.zza) {
                break;
            }
            boolean[] zArr2 = this.zzh;
            if (z || !zzyc.zza(this.zzn, i)) {
                z3 = false;
            }
            zArr2[i] = z3;
            i++;
        }
        int i2 = 0;
        while (true) {
            zzlh[] zzlhArr = this.zzi;
            if (i2 >= 2) {
                break;
            }
            zzlhArr[i2].zzb();
            i2++;
        }
        zzs();
        this.zzn = zzyc2;
        zzt();
        long zzg2 = this.zza.zzg(zzyc2.zzc, this.zzh, this.zzc, zArr, j);
        int i3 = 0;
        while (true) {
            zzlh[] zzlhArr2 = this.zzi;
            if (i3 >= 2) {
                break;
            }
            zzlhArr2[i3].zzb();
            i3++;
        }
        this.zze = false;
        int i4 = 0;
        while (true) {
            zzvx[] zzvxArr = this.zzc;
            if (i4 >= 2) {
                return zzg2;
            }
            if (zzvxArr[i4] != null) {
                zzdi.zzf(zzyc.zzb(i4));
                this.zzi[i4].zzb();
                this.zze = true;
            } else {
                if (zzyc2.zzc[i4] == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zzdi.zzf(z2);
            }
            i4++;
        }
    }

    public final long zzc() {
        long j;
        if (!this.zzd) {
            return this.zzf.zzb;
        }
        if (this.zze) {
            j = this.zza.zzb();
        } else {
            j = Long.MIN_VALUE;
        }
        if (j == Long.MIN_VALUE) {
            return this.zzf.zze;
        }
        return j;
    }

    public final long zzd() {
        if (!this.zzd) {
            return 0;
        }
        return this.zza.zzc();
    }

    public final long zze() {
        return this.zzo;
    }

    public final long zzf() {
        return this.zzf.zzb + this.zzo;
    }

    public final zzkh zzg() {
        return this.zzl;
    }

    public final zzwi zzh() {
        return this.zzm;
    }

    public final zzyc zzi() {
        return this.zzn;
    }

    public final zzyc zzj(float f, zzcc zzcc) throws zzhw {
        zzyc zzo2 = this.zzj.zzo(this.zzi, this.zzm, this.zzf.zza, zzcc);
        for (zzxv zzxv : zzo2.zzc) {
        }
        return zzo2;
    }

    public final void zzk(long j, float f, long j2) {
        zzdi.zzf(zzu());
        long j3 = j - this.zzo;
        zzkd zzkd = new zzkd();
        zzkd.zze(j3);
        zzkd.zzf(f);
        zzkd.zzd(j2);
        this.zza.zzo(new zzkf(zzkd, (zzke) null));
    }

    public final void zzl(float f, zzcc zzcc) throws zzhw {
        this.zzd = true;
        this.zzm = this.zza.zzi();
        zzyc zzj2 = zzj(f, zzcc);
        zzki zzki = this.zzf;
        long j = zzki.zzb;
        long j2 = zzki.zze;
        if (j2 != -9223372036854775807L && j >= j2) {
            j = Math.max(0, j2 - 1);
        }
        long zza2 = zza(zzj2, j, false);
        long j3 = this.zzo;
        zzki zzki2 = this.zzf;
        this.zzo = (zzki2.zzb - zza2) + j3;
        this.zzf = zzki2.zzb(zza2);
    }

    public final void zzm(long j) {
        zzdi.zzf(zzu());
        if (this.zzd) {
            this.zza.zzm(j - this.zzo);
        }
    }

    public final void zzn() {
        zzs();
        zzug zzug = this.zza;
        try {
            boolean z = zzug instanceof zztm;
            zzkw zzkw = this.zzk;
            if (z) {
                zzkw.zzi(((zztm) zzug).zza);
            } else {
                zzkw.zzi(zzug);
            }
        } catch (RuntimeException e) {
            zzea.zzd("MediaPeriodHolder", "Period release failed.", e);
        }
    }

    public final void zzo(zzkh zzkh) {
        if (zzkh != this.zzl) {
            zzs();
            this.zzl = zzkh;
            zzt();
        }
    }

    public final void zzp(long j) {
        this.zzo = j;
    }

    public final void zzq() {
        zzug zzug = this.zza;
        if (zzug instanceof zztm) {
            long j = this.zzf.zzd;
            if (j == -9223372036854775807L) {
                j = Long.MIN_VALUE;
            }
            ((zztm) zzug).zzn(0, j);
        }
    }

    public final boolean zzr() {
        if (!this.zzd) {
            return false;
        }
        if (!this.zze) {
            return true;
        }
        if (this.zza.zzb() != Long.MIN_VALUE) {
            return false;
        }
        return true;
    }
}
