package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzezq implements zzgcf {
    final /* synthetic */ zzemz zza;
    final /* synthetic */ zzfkf zzb;
    final /* synthetic */ zzfju zzc;
    final /* synthetic */ zzezs zzd;
    final /* synthetic */ zzezt zze;

    public zzezq(zzezt zzezt, zzemz zzemz, zzfkf zzfkf, zzfju zzfju, zzezs zzezs) {
        this.zza = zzemz;
        this.zzb = zzfkf;
        this.zzc = zzfju;
        this.zzd = zzezs;
        this.zze = zzezt;
    }

    /* JADX WARNING: type inference failed for: r0v17, types: [com.google.android.gms.internal.ads.zzcvx, java.lang.Object] */
    public final void zza(Throwable th) {
        zze zze2;
        zzfkf zzfkf;
        zzcou zzcou = (zzcou) this.zze.zze.zzd();
        if (zzcou == null) {
            zze2 = zzfgi.zzb(th, (zzeey) null);
        } else {
            zze2 = zzcou.zzb().zza(th);
        }
        synchronized (this.zze) {
            this.zze.zzj = null;
            if (zzcou != null) {
                zzcou.zzc().zzdB(zze2);
                if (((Boolean) zzba.zzc().zza(zzbbw.zzhq)).booleanValue()) {
                    this.zze.zzc.execute(new zzezp(this, zze2));
                }
            } else {
                this.zze.zzd.zzdB(zze2);
                this.zze.zzm(this.zzd).zzh().zzb().zzc().zzh();
            }
            zzfgd.zzb(zze2.zza, th, "AppOpenAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbdl.zzc.zze()).booleanValue() || (zzfkf = this.zzb) == null) {
                zzfki zzh = this.zze.zzh;
                zzfju zzfju = this.zzc;
                zzfju.zza(zze2);
                zzfju.zzh(th);
                zzfju.zzg(false);
                zzh.zzb(zzfju.zzm());
            } else {
                zzfkf.zzc(zze2);
                zzfju zzfju2 = this.zzc;
                zzfju2.zzh(th);
                zzfju2.zzg(false);
                zzfkf.zza(zzfju2);
                zzfkf.zzh();
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfkf zzfkf;
        zzcru zzcru = (zzcru) obj;
        synchronized (this.zze) {
            this.zze.zzj = null;
            if (((Boolean) zzba.zzc().zza(zzbbw.zzhq)).booleanValue()) {
                zzcru.zzo().zzb(this.zze.zzd);
            }
            this.zza.zzb(zzcru);
            if (!((Boolean) zzbdl.zzc.zze()).booleanValue() || (zzfkf = this.zzb) == null) {
                zzfki zzh = this.zze.zzh;
                zzfju zzfju = this.zzc;
                zzfju.zzb(zzcru.zzq().zzb);
                zzfju.zzd(zzcru.zzm().zzg());
                zzfju.zzg(true);
                zzh.zzb(zzfju.zzm());
            } else {
                zzfkf.zzg(zzcru.zzq().zzb);
                zzfkf.zze(zzcru.zzm().zzg());
                zzfju zzfju2 = this.zzc;
                zzfju2.zzg(true);
                zzfkf.zza(zzfju2);
                zzfkf.zzh();
            }
        }
    }
}
