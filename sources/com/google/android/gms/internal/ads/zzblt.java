package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzblt {
    public static void zza(zzblu zzblu, String str, Map map) {
        try {
            zzblu.zze(str, zzay.zzb().zzj(map));
        } catch (JSONException unused) {
            zzm.zzj("Could not convert parameters to JSON.");
        }
    }

    public static void zzb(zzblu zzblu, String str, JSONObject jSONObject) {
        StringBuilder b = C0437ME.b("(window.AFMA_ReceiveMessage || function() {})('", str, "',", jSONObject.toString(), ");");
        zzm.zze("Dispatching AFMA event: ".concat(b.toString()));
        zzblu.zza(b.toString());
    }

    public static void zzc(zzblu zzblu, String str, String str2) {
        zzblu.zza(str + "(" + str2 + ");");
    }

    public static void zzd(zzblu zzblu, String str, JSONObject jSONObject) {
        zzblu.zzb(str, jSONObject.toString());
    }
}
