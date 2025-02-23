package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzu;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbik implements zzbix {
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcej zzcej = (zzcej) obj;
        try {
            String str = (String) map.get("enabled");
            if (!zzfuf.zzc("true", str)) {
                if (!zzfuf.zzc("false", str)) {
                    return;
                }
            }
            zzfsc.zzi(zzcej.getContext()).zzm(Boolean.parseBoolean(str));
        } catch (IOException e) {
            zzu.zzo().zzw(e, "DefaultGmsgHandlers.SetPaidv2PersonalizationEnabled");
        }
    }
}
