package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfaw implements zzgcf {
    final /* synthetic */ zzfkf zza;
    final /* synthetic */ zzfju zzb;
    final /* synthetic */ zzcql zzc;
    final /* synthetic */ zzfax zzd;

    public zzfaw(zzfax zzfax, zzfkf zzfkf, zzfju zzfju, zzcql zzcql) {
        this.zza = zzfkf;
        this.zzb = zzfju;
        this.zzc = zzcql;
        this.zzd = zzfax;
    }

    public final void zza(Throwable th) {
        zzfkf zzfkf;
        this.zzd.zzn = this.zzc.zzd().zza(th);
        synchronized (this.zzd) {
            this.zzc.zzf().zzdB(this.zzd.zzn);
            zzfgd.zzb(this.zzd.zzn.zza, th, "BannerAdLoader.onFailure");
            zzfax zzfax = this.zzd;
            if (zzfax.zzm) {
                zzfax.zzu();
                zzfax zzfax2 = this.zzd;
                zzfax2.zzh.zzd(zzfax2.zzj.zzc());
            }
            if (!((Boolean) zzbdl.zzc.zze()).booleanValue() || (zzfkf = this.zza) == null) {
                zzfax zzfax3 = this.zzd;
                zzfki zzh = zzfax3.zzi;
                zzfju zzfju = this.zzb;
                zzfju.zza(zzfax3.zzn);
                zzfju.zzh(th);
                zzfju.zzg(false);
                zzh.zzb(zzfju.zzm());
            } else {
                zzfkf.zzc(this.zzd.zzn);
                zzfju zzfju2 = this.zzb;
                zzfju2.zzh(th);
                zzfju2.zzg(false);
                zzfkf.zza(zzfju2);
                zzfkf.zzh();
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfkf zzfkf;
        zzcpk zzcpk = (zzcpk) obj;
        synchronized (this.zzd) {
            zzfax zzfax = this.zzd;
            if (zzfax.zzm) {
                zzfax.zzr();
            }
            if (!((Boolean) zzbdl.zzc.zze()).booleanValue() || (zzfkf = this.zza) == null) {
                zzfki zzh = this.zzd.zzi;
                zzfju zzfju = this.zzb;
                zzfju.zzb(zzcpk.zzq().zzb);
                zzfju.zzd(zzcpk.zzm().zzg());
                zzfju.zzg(true);
                zzh.zzb(zzfju.zzm());
            } else {
                zzfkf.zzg(zzcpk.zzq().zzb);
                zzfkf.zze(zzcpk.zzm().zzg());
                zzfju zzfju2 = this.zzb;
                zzfju2.zzg(true);
                zzfkf.zza(zzfju2);
                zzfkf.zzh();
            }
        }
    }
}
