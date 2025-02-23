package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzeng implements zzgcf {
    final /* synthetic */ zzemz zza;
    final /* synthetic */ zzfkf zzb;
    final /* synthetic */ zzfju zzc;
    final /* synthetic */ zzdhl zzd;
    final /* synthetic */ zzenh zze;

    public zzeng(zzenh zzenh, zzemz zzemz, zzfkf zzfkf, zzfju zzfju, zzdhl zzdhl) {
        this.zza = zzemz;
        this.zzb = zzfkf;
        this.zzc = zzfju;
        this.zzd = zzdhl;
        this.zze = zzenh;
    }

    public final void zza(Throwable th) {
        zzfkf zzfkf;
        zze zza2 = this.zzd.zza().zza(th);
        this.zzd.zzb().zzdB(zza2);
        this.zze.zzb.zzB().execute(new zzenf(this, zza2));
        zzfgd.zzb(zza2.zza, th, "NativeAdLoader.onFailure");
        this.zza.zza();
        if (!((Boolean) zzbdl.zzc.zze()).booleanValue() || (zzfkf = this.zzb) == null) {
            zzenh zzenh = this.zze;
            zzfju zzfju = this.zzc;
            zzfki zze2 = zzenh.zze;
            zzfju.zza(zza2);
            zzfju.zzh(th);
            zzfju.zzg(false);
            zze2.zzb(zzfju.zzm());
            return;
        }
        zzfkf.zzc(zza2);
        zzfju zzfju2 = this.zzc;
        zzfju2.zzh(th);
        zzfju2.zzg(false);
        zzfkf.zza(zzfju2);
        zzfkf.zzh();
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfkf zzfkf;
        zzcru zzcru = (zzcru) obj;
        synchronized (this.zze) {
            zzcru.zzo().zza(this.zze.zzd.zzd());
            this.zza.zzb(zzcru);
            this.zze.zzb.zzB().execute(new zzene(this));
            if (!((Boolean) zzbdl.zzc.zze()).booleanValue() || (zzfkf = this.zzb) == null) {
                zzfki zze2 = this.zze.zze;
                zzfju zzfju = this.zzc;
                zzfju.zzb(zzcru.zzq().zzb);
                zzfju.zzd(zzcru.zzm().zzg());
                zzfju.zzg(true);
                zze2.zzb(zzfju.zzm());
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
