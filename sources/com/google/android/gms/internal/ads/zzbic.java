package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbic implements zzbix {
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject zza;
        zzcej zzcej = (zzcej) obj;
        zzber zzK = zzcej.zzK();
        if (zzK == null || (zza = zzK.zza()) == null) {
            zzcej.zze("nativeAdViewSignalsReady", new JSONObject());
        } else {
            zzcej.zze("nativeAdViewSignalsReady", zza);
        }
    }
}
