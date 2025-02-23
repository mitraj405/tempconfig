package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzdiv implements zzgcf {
    final /* synthetic */ View zza;
    final /* synthetic */ zzdiw zzb;

    public zzdiv(zzdiw zzdiw, View view) {
        this.zza = view;
        this.zzb = zzdiw;
    }

    public final void zza(Throwable th) {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzeI)).booleanValue()) {
            zzu.zzo().zzv(th, "omid native display exp");
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzb.zzac(this.zza, (zzeeo) obj);
    }
}
