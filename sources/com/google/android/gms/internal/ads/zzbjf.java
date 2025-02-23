package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbjf implements zzgcf {
    final /* synthetic */ Map zza;
    final /* synthetic */ zza zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzbjj zzd;

    public zzbjf(zzbjj zzbjj, Map map, zza zza2, String str) {
        this.zza = map;
        this.zzb = zza2;
        this.zzc = str;
        this.zzd = zzbjj;
    }

    public final void zza(Throwable th) {
        zzu.zzo().zzw(th, "OpenGmsgHandler.attributionReportingManager");
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        String str = (String) obj;
        if (((Boolean) zzba.zzc().zza(zzbbw.zzjh)).booleanValue()) {
            this.zza.put("u", str);
        }
        this.zzd.zzh(str, this.zzb, this.zza, this.zzc);
    }
}
