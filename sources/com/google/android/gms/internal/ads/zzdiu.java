package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzdiu implements zzgcf {
    final /* synthetic */ String zza = "Google";
    final /* synthetic */ zzdiw zzb;

    public zzdiu(zzdiw zzdiw, String str, boolean z) {
        this.zzb = zzdiw;
    }

    public final void zza(Throwable th) {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzeI)).booleanValue()) {
            zzu.zzo().zzv(th, "omid native display exp");
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzb.zzd.zzT((zzcej) obj);
        zzdiw zzdiw = this.zzb;
        zzbzt zzp = zzdiw.zzd.zzp();
        zzeeo zzf = zzdiw.zzf(this.zza, true);
        if (zzf != null && zzp != null) {
            zzp.zzc(zzf);
        } else if (zzp != null) {
            zzp.cancel(false);
        }
    }
}
