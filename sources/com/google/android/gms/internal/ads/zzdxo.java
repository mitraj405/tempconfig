package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.regex.Matcher;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzdxo implements zzgcf {
    final /* synthetic */ zzdxp zza;

    public zzdxo(zzdxp zzdxp) {
        this.zza = zzdxp;
    }

    public final void zza(Throwable th) {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzfB)).booleanValue()) {
            Matcher matcher = zzdxp.zza.matcher(th.getMessage());
            if (matcher.matches()) {
                this.zza.zzf.zzi(Integer.parseInt(matcher.group(1)));
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfex zzfex = (zzfex) obj;
        if (((Boolean) zzba.zzc().zza(zzbbw.zzfB)).booleanValue()) {
            this.zza.zzf.zzi(zzfex.zzb.zzb.zzf);
            this.zza.zzf.zzj(zzfex.zzb.zzb.zzg);
        }
    }
}
