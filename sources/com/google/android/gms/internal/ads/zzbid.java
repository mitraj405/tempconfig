package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbid implements zzbix {
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject zzb;
        zzcej zzcej = (zzcej) obj;
        zzber zzK = zzcej.zzK();
        if (zzK == null || (zzb = zzK.zzb()) == null) {
            zzcej.zze("nativeClickMetaReady", new JSONObject());
        } else {
            zzcej.zze("nativeClickMetaReady", zzb);
        }
    }
}
