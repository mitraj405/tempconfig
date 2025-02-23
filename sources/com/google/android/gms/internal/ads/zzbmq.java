package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbmq implements zzbzv {
    final /* synthetic */ zzbmz zza;
    final /* synthetic */ zzfju zzb;
    final /* synthetic */ zzbna zzc;

    public zzbmq(zzbna zzbna, zzbmz zzbmz, zzfju zzfju) {
        this.zza = zzbmz;
        this.zzb = zzfju;
        this.zzc = zzbna;
    }

    public final void zza() {
        zze.zza("loadNewJavascriptEngine (failure): Trying to acquire lock");
        synchronized (this.zzc.zza) {
            zze.zza("loadNewJavascriptEngine (failure): Lock acquired");
            this.zzc.zzi = 1;
            zze.zza("Failed loading new engine. Marking new engine destroyable.");
            this.zza.zzb();
            if (((Boolean) zzbdl.zzd.zze()).booleanValue()) {
                zzbna zzbna = this.zzc;
                if (zzbna.zze != null) {
                    zzfki zze = zzbna.zze;
                    zzfju zzfju = this.zzb;
                    zzfju.zzc("Failed loading new engine");
                    zzfju.zzg(false);
                    zze.zzb(zzfju.zzm());
                }
            }
        }
        zze.zza("loadNewJavascriptEngine (failure): Lock released");
    }
}
