package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzhv implements zzkg {
    private final zzlm zza;
    private final zzhu zzb;
    private zzle zzc;
    private zzkg zzd;
    private boolean zze = true;
    private boolean zzf;

    public zzhv(zzhu zzhu, zzdj zzdj) {
        this.zzb = zzhu;
        this.zza = new zzlm(zzdj);
    }

    public final long zza() {
        throw null;
    }

    public final long zzb(boolean z) {
        zzle zzle = this.zzc;
        if (zzle == null || zzle.zzW() || ((z && this.zzc.zzcV() != 2) || (!this.zzc.zzX() && (z || this.zzc.zzQ())))) {
            this.zze = true;
            if (this.zzf) {
                this.zza.zzd();
            }
        } else {
            zzkg zzkg = this.zzd;
            zzkg.getClass();
            long zza2 = zzkg.zza();
            if (this.zze) {
                if (zza2 < this.zza.zza()) {
                    this.zza.zze();
                } else {
                    this.zze = false;
                    if (this.zzf) {
                        this.zza.zzd();
                    }
                }
            }
            this.zza.zzb(zza2);
            zzbq zzc2 = zzkg.zzc();
            if (!zzc2.equals(this.zza.zzc())) {
                this.zza.zzg(zzc2);
                this.zzb.zza(zzc2);
            }
        }
        if (this.zze) {
            return this.zza.zza();
        }
        zzkg zzkg2 = this.zzd;
        zzkg2.getClass();
        return zzkg2.zza();
    }

    public final zzbq zzc() {
        zzkg zzkg = this.zzd;
        if (zzkg != null) {
            return zzkg.zzc();
        }
        return this.zza.zzc();
    }

    public final void zzd(zzle zzle) {
        if (zzle == this.zzc) {
            this.zzd = null;
            this.zzc = null;
            this.zze = true;
        }
    }

    public final void zze(zzle zzle) throws zzhw {
        zzkg zzkg;
        zzkg zzk = zzle.zzk();
        if (zzk != null && zzk != (zzkg = this.zzd)) {
            if (zzkg == null) {
                this.zzd = zzk;
                this.zzc = zzle;
                zzk.zzg(this.zza.zzc());
                return;
            }
            throw zzhw.zzd(new IllegalStateException("Multiple renderer media clocks enabled."), 1000);
        }
    }

    public final void zzf(long j) {
        this.zza.zzb(j);
    }

    public final void zzg(zzbq zzbq) {
        zzkg zzkg = this.zzd;
        if (zzkg != null) {
            zzkg.zzg(zzbq);
            zzbq = this.zzd.zzc();
        }
        this.zza.zzg(zzbq);
    }

    public final void zzh() {
        this.zzf = true;
        this.zza.zzd();
    }

    public final void zzi() {
        this.zzf = false;
        this.zza.zze();
    }

    public final boolean zzj() {
        if (this.zze) {
            return false;
        }
        zzkg zzkg = this.zzd;
        zzkg.getClass();
        return zzkg.zzj();
    }
}
