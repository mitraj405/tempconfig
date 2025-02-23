package com.google.android.gms.internal.ads;

import in.juspay.hyper.constants.LogCategory;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbit implements zzbix {
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcej zzcej = (zzcej) obj;
        String str = (String) map.get(LogCategory.ACTION);
        if ("pause".equals(str)) {
            zzcej.zzdg();
        } else if ("resume".equals(str)) {
            zzcej.zzdh();
        }
    }
}
