package com.google.android.gms.ads.nonagon.signalgeneration;

import android.webkit.ValueCallback;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbdc;
import com.google.android.gms.internal.ads.zzbdx;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbf extends QueryInfoGenerationCallback {
    final /* synthetic */ String zza;
    final /* synthetic */ TaggingLibraryJsInterface zzb;

    public zzbf(TaggingLibraryJsInterface taggingLibraryJsInterface, String str) {
        this.zza = str;
        this.zzb = taggingLibraryJsInterface;
    }

    public final void onFailure(String str) {
        long j;
        zzm.zzj("Failed to generate query info for the tagging library, error: ".concat(String.valueOf(str)));
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[3];
        objArr[0] = this.zza;
        objArr[1] = str;
        zzbdc zzbdc = zzbdx.zza;
        if (((Boolean) zzbdc.zze()).booleanValue()) {
            j = ((Long) zzba.zzc().zza(zzbbw.zziX)).longValue();
        } else {
            j = 0;
        }
        objArr[2] = Long.valueOf(j);
        String format = String.format(locale, "window.postMessage({'paw_id': '%1$s', 'error': '%2$s', 'sdk_ttl_ms': %3$d}, '*');", objArr);
        if (((Boolean) zzbdc.zze()).booleanValue()) {
            try {
                this.zzb.zzh.execute(new zzbd(this, format));
            } catch (RuntimeException e) {
                zzu.zzo().zzv(e, "TaggingLibraryJsInterface.getQueryInfo.onFailure");
            }
        } else {
            this.zzb.zzb.evaluateJavascript(format, (ValueCallback) null);
        }
    }

    public final void onSuccess(QueryInfo queryInfo) {
        String str;
        long j;
        String query = queryInfo.getQuery();
        long j2 = 0;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("paw_id", this.zza);
            jSONObject.put("signal", query);
            if (((Boolean) zzbdx.zza.zze()).booleanValue()) {
                j = ((Long) zzba.zzc().zza(zzbbw.zziX)).longValue();
            } else {
                j = 0;
            }
            jSONObject.put("sdk_ttl_ms", j);
            str = String.format(Locale.getDefault(), "window.postMessage(%1$s, '*');", new Object[]{jSONObject});
        } catch (JSONException unused) {
            String str2 = this.zza;
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[3];
            objArr[0] = str2;
            objArr[1] = queryInfo.getQuery();
            if (((Boolean) zzbdx.zza.zze()).booleanValue()) {
                j2 = ((Long) zzba.zzc().zza(zzbbw.zziX)).longValue();
            }
            objArr[2] = Long.valueOf(j2);
            str = String.format(locale, "window.postMessage({'paw_id': '%1$s', 'signal': '%2$s', 'sdk_ttl_ms': %3$d}, '*');", objArr);
        }
        if (((Boolean) zzbdx.zza.zze()).booleanValue()) {
            try {
                this.zzb.zzh.execute(new zzbe(this, str));
            } catch (RuntimeException e) {
                zzu.zzo().zzv(e, "TaggingLibraryJsInterface.getQueryInfo.onSuccess");
            }
        } else {
            this.zzb.zzb.evaluateJavascript(str, (ValueCallback) null);
        }
    }
}
