package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzffp implements zzbix {
    public final /* synthetic */ zzfll zza;
    public final /* synthetic */ zzedh zzb;

    public /* synthetic */ zzffp(zzfll zzfll, zzedh zzedh) {
        this.zza = zzfll;
        this.zzb = zzedh;
    }

    public final void zza(Object obj, Map map) {
        zzcea zzcea = (zzcea) obj;
        String str = (String) map.get("u");
        if (str == null) {
            zzm.zzj("URL missing from httpTrack GMSG.");
        } else if (!zzcea.zzD().zzai) {
            this.zza.zzc(str, (zzfkf) null);
        } else {
            this.zzb.zzd(new zzedj(zzu.zzB().currentTimeMillis(), ((zzcfm) zzcea).zzR().zzb, str, 2));
        }
    }
}
