package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbiu implements zzbix {
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcej zzcej = (zzcej) obj;
        if (map.keySet().contains("start")) {
            zzcej.zzN().zzl();
        } else if (map.keySet().contains("stop")) {
            zzcej.zzN().zzm();
        } else if (map.keySet().contains("cancel")) {
            zzcej.zzN().zzk();
        }
    }
}
