package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfcn implements zzgcf {
    final /* synthetic */ zzemz zza;
    final /* synthetic */ zzfkf zzb;
    final /* synthetic */ zzfju zzc;
    final /* synthetic */ zzdgp zzd;
    final /* synthetic */ zzfco zze;

    public zzfcn(zzfco zzfco, zzemz zzemz, zzfkf zzfkf, zzfju zzfju, zzdgp zzdgp) {
        this.zza = zzemz;
        this.zzb = zzfkf;
        this.zzc = zzfju;
        this.zzd = zzdgp;
        this.zze = zzfco;
    }

    public final void zza(Throwable th) {
        zzfkf zzfkf;
        zze zza2 = this.zzd.zza().zza(th);
        synchronized (this.zze) {
            this.zze.zzi = null;
            this.zzd.zzb().zzdB(zza2);
            if (((Boolean) zzba.zzc().zza(zzbbw.zzhr)).booleanValue()) {
                this.zze.zzb.execute(new zzfcj(this, zza2));
                this.zze.zzb.execute(new zzfck(this, zza2));
            }
            zzfgd.zzb(zza2.zza, th, "InterstitialAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbdl.zzc.zze()).booleanValue() || (zzfkf = this.zzb) == null) {
                zzfki zze2 = this.zze.zzg;
                zzfju zzfju = this.zzc;
                zzfju.zza(zza2);
                zzfju.zzh(th);
                zzfju.zzg(false);
                zze2.zzb(zzfju.zzm());
            } else {
                zzfkf.zzc(zza2);
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
        zzdfo zzdfo = (zzdfo) obj;
        synchronized (this.zze) {
            this.zze.zzi = null;
            zzbbn zzbbn = zzbbw.zzhr;
            if (((Boolean) zzba.zzc().zza(zzbbn)).booleanValue()) {
                zzday zzo = zzdfo.zzo();
                zzo.zza(this.zze.zzd);
                zzo.zzd(this.zze.zze);
            }
            this.zza.zzb(zzdfo);
            if (((Boolean) zzba.zzc().zza(zzbbn)).booleanValue()) {
                this.zze.zzb.execute(new zzfcl(this));
                this.zze.zzb.execute(new zzfcm(this));
            }
            if (!((Boolean) zzbdl.zzc.zze()).booleanValue() || (zzfkf = this.zzb) == null) {
                zzfki zze2 = this.zze.zzg;
                zzfju zzfju = this.zzc;
                zzfju.zzb(zzdfo.zzq().zzb);
                zzfju.zzd(zzdfo.zzm().zzg());
                zzfju.zzg(true);
                zze2.zzb(zzfju.zzm());
            } else {
                zzfkf.zzg(zzdfo.zzq().zzb);
                zzfkf.zze(zzdfo.zzm().zzg());
                zzfju zzfju2 = this.zzc;
                zzfju2.zzg(true);
                zzfkf.zza(zzfju2);
                zzfkf.zzh();
            }
        }
    }
}
