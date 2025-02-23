package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzdum extends zzbky {
    final /* synthetic */ Object zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ zzfju zzd;
    final /* synthetic */ zzbzt zze;
    final /* synthetic */ zzdun zzf;

    public zzdum(zzdun zzdun, Object obj, String str, long j, zzfju zzfju, zzbzt zzbzt) {
        this.zza = obj;
        this.zzb = str;
        this.zzc = j;
        this.zzd = zzfju;
        this.zze = zzbzt;
        this.zzf = zzdun;
    }

    public final void zze(String str) {
        synchronized (this.zza) {
            this.zzf.zzv(this.zzb, false, str, (int) (zzu.zzB().elapsedRealtime() - this.zzc));
            this.zzf.zzl.zzb(this.zzb, "error");
            this.zzf.zzo.zzb(this.zzb, "error");
            zzfki zze2 = this.zzf.zzp;
            zzfju zzfju = this.zzd;
            zzfju.zzc(str);
            zzfju.zzg(false);
            zze2.zzb(zzfju.zzm());
            this.zze.zzc(Boolean.FALSE);
        }
    }

    public final void zzf() {
        synchronized (this.zza) {
            this.zzf.zzv(this.zzb, true, "", (int) (zzu.zzB().elapsedRealtime() - this.zzc));
            this.zzf.zzl.zzd(this.zzb);
            this.zzf.zzo.zzd(this.zzb);
            zzfki zze2 = this.zzf.zzp;
            zzfju zzfju = this.zzd;
            zzfju.zzg(true);
            zze2.zzb(zzfju.zzm());
            this.zze.zzc(Boolean.TRUE);
        }
    }
}
