package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzbw;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzbia implements zzbix {
    public final void zza(Object obj, Map map) {
        zzcfq zzcfq = (zzcfq) obj;
        zzbix zzbix = zzbiw.zza;
        String str = (String) map.get("u");
        if (str == null) {
            zzm.zzj("URL missing from httpTrack GMSG.");
        } else {
            new zzbw(zzcfq.getContext(), ((zzcfx) zzcfq).zzn().afmaVersion, str).zzb();
        }
    }
}
