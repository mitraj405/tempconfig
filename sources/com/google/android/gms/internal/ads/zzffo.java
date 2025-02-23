package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzffo implements zzbix {
    public final /* synthetic */ zzdeq zza;
    public final /* synthetic */ zzcni zzb;
    public final /* synthetic */ zzfll zzc;
    public final /* synthetic */ zzedh zzd;

    public /* synthetic */ zzffo(zzdeq zzdeq, zzcni zzcni, zzfll zzfll, zzedh zzedh) {
        this.zza = zzdeq;
        this.zzb = zzcni;
        this.zzc = zzfll;
        this.zzd = zzedh;
    }

    public final void zza(Object obj, Map map) {
        zzcej zzcej = (zzcej) obj;
        zzbiw.zzc(map, this.zza);
        String str = (String) map.get("u");
        if (str == null) {
            zzm.zzj("URL missing from click GMSG.");
            return;
        }
        zzedh zzedh = this.zzd;
        zzfll zzfll = this.zzc;
        zzgcj.zzr(zzbiw.zza(zzcej, str), new zzffq(zzcej, this.zzb, zzfll, zzedh), zzbzo.zza);
    }
}
