package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbmp implements zzbzx {
    final /* synthetic */ zzbmz zza;
    final /* synthetic */ zzfju zzb;
    final /* synthetic */ zzbna zzc;

    public zzbmp(zzbna zzbna, zzbmz zzbmz, zzfju zzfju) {
        this.zza = zzbmz;
        this.zzb = zzfju;
        this.zzc = zzbna;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        zzblv zzblv = (zzblv) obj;
        zze.zza("loadNewJavascriptEngine (success): Trying to acquire lock");
        synchronized (this.zzc.zza) {
            zze.zza("loadNewJavascriptEngine (success): Lock acquired");
            this.zzc.zzi = 0;
            zzbna zzbna = this.zzc;
            if (!(zzbna.zzh == null || this.zza == zzbna.zzh)) {
                zze.zza("New JS engine is loaded, marking previous one as destroyable.");
                this.zzc.zzh.zzb();
            }
            this.zzc.zzh = this.zza;
            if (((Boolean) zzbdl.zzd.zze()).booleanValue()) {
                zzbna zzbna2 = this.zzc;
                if (zzbna2.zze != null) {
                    zzfki zze = zzbna2.zze;
                    zzfju zzfju = this.zzb;
                    zzfju.zzg(true);
                    zze.zzb(zzfju.zzm());
                }
            }
        }
        zze.zza("loadNewJavascriptEngine (success): Lock released");
    }
}
