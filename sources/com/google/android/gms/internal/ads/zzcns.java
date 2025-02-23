package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzu;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzcns implements zzgcf {
    final /* synthetic */ zzcnu zza;

    public zzcns(zzcnu zzcnu) {
        this.zza = zzcnu;
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcnu zzcnu = this.zza;
        zzffs zzj = zzcnu.zzh;
        List zzd = zzcnu.zzg.zzd(zzcnu.zze, zzcnu.zzf, false, "", (String) obj, zzcnu.zzf.zzc);
        int i = 1;
        if (true == zzu.zzo().zzA(this.zza.zza)) {
            i = 2;
        }
        zzj.zzc(zzd, i);
    }

    public final void zza(Throwable th) {
    }
}
