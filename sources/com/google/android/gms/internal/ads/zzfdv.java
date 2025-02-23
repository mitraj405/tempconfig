package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfdv implements zzgcf {
    final /* synthetic */ zzemz zza;
    final /* synthetic */ zzfkf zzb;
    final /* synthetic */ zzfju zzc;
    final /* synthetic */ zzfdx zzd;
    final /* synthetic */ zzfdy zze;

    public zzfdv(zzfdy zzfdy, zzemz zzemz, zzfkf zzfkf, zzfju zzfju, zzfdx zzfdx) {
        this.zza = zzemz;
        this.zzb = zzfkf;
        this.zzc = zzfju;
        this.zzd = zzfdx;
        this.zze = zzfdy;
    }

    public final void zza(Throwable th) {
        zze zze2;
        zzfkf zzfkf;
        zzdou zzdou = (zzdou) this.zze.zze.zzd();
        if (zzdou == null) {
            zze2 = zzfgi.zzb(th, (zzeey) null);
        } else {
            zze2 = zzdou.zzb().zza(th);
        }
        synchronized (this.zze) {
            if (zzdou != null) {
                zzdou.zza().zzdB(zze2);
                this.zze.zzb.execute(new zzfdt(this, zze2));
            } else {
                this.zze.zzd.zzdB(zze2);
                this.zze.zzk(this.zzd).zze().zzb().zzc().zzh();
            }
            zzfgd.zzb(zze2.zza, th, "RewardedAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbdl.zzc.zze()).booleanValue() || (zzfkf = this.zzb) == null) {
                zzfki zzg = this.zze.zzg;
                zzfju zzfju = this.zzc;
                zzfju.zza(zze2);
                zzfju.zzh(th);
                zzfju.zzg(false);
                zzg.zzb(zzfju.zzm());
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
        zzdop zzdop = (zzdop) obj;
        synchronized (this.zze) {
            zzdop.zzo().zzd(this.zze.zzd);
            this.zza.zzb(zzdop);
            zzfdy zzfdy = this.zze;
            Executor zzh = zzfdy.zzb;
            zzfdo zzf = zzfdy.zzd;
            Objects.requireNonNull(zzf);
            zzh.execute(new zzfdu(zzf));
            this.zze.zzd.onAdMetadataChanged();
            if (!((Boolean) zzbdl.zzc.zze()).booleanValue() || (zzfkf = this.zzb) == null) {
                zzfki zzg = this.zze.zzg;
                zzfju zzfju = this.zzc;
                zzfju.zzb(zzdop.zzq().zzb);
                zzfju.zzd(zzdop.zzm().zzg());
                zzfju.zzg(true);
                zzg.zzb(zzfju.zzm());
            } else {
                zzfkf.zzg(zzdop.zzq().zzb);
                zzfkf.zze(zzdop.zzm().zzg());
                zzfju zzfju2 = this.zzc;
                zzfju2.zzg(true);
                zzfkf.zza(zzfju2);
                zzfkf.zzh();
            }
        }
    }
}
