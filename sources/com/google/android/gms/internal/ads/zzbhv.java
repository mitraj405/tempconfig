package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzbhv implements zzbix {
    public final /* synthetic */ zzdeq zza;
    public final /* synthetic */ zzcni zzb;

    public /* synthetic */ zzbhv(zzdeq zzdeq, zzcni zzcni) {
        this.zza = zzdeq;
        this.zzb = zzcni;
    }

    public final void zza(Object obj, Map map) {
        zzcej zzcej = (zzcej) obj;
        zzbiw.zzc(map, this.zza);
        String str = (String) map.get("u");
        if (str == null) {
            zzm.zzj("URL missing from click GMSG.");
            return;
        }
        zzcni zzcni = this.zzb;
        zzgca zzu = zzgca.zzu(zzbiw.zza(zzcej, str));
        zzbhx zzbhx = new zzbhx(zzcni, str);
        zzgcu zzgcu = zzbzo.zza;
        zzgcj.zzr(zzgcj.zzn(zzu, zzbhx, zzgcu), new zzbil(zzcej), zzgcu);
    }
}
