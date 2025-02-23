package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzac;
import com.google.android.gms.ads.internal.zzu;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcob implements zzbnh {
    private final Context zza;
    private final zzaxs zzb;
    private final PowerManager zzc;

    public zzcob(Context context, zzaxs zzaxs) {
        this.zza = context;
        this.zzb = zzaxs;
        this.zzc = (PowerManager) context.getSystemService("power");
    }

    /* renamed from: zza */
    public final JSONObject zzb(zzcoe zzcoe) throws JSONException {
        JSONObject jSONObject;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        zzaxv zzaxv = zzcoe.zzf;
        if (zzaxv == null) {
            jSONObject = new JSONObject();
        } else if (this.zzb.zzd() != null) {
            boolean z = zzaxv.zza;
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("afmaVersion", this.zzb.zzb()).put("activeViewJSON", this.zzb.zzd()).put(PaymentConstants.TIMESTAMP, zzcoe.zzd).put("adFormat", this.zzb.zza()).put("hashCode", this.zzb.zzc()).put("isMraid", false).put("isStopped", false).put("isPaused", zzcoe.zzb).put("isNative", this.zzb.zze()).put("isScreenOn", this.zzc.isInteractive()).put("appMuted", zzu.zzr().zze()).put("appVolume", (double) zzu.zzr().zza()).put("deviceVolume", (double) zzac.zzb(this.zza.getApplicationContext()));
            Rect rect = new Rect();
            Display defaultDisplay = ((WindowManager) this.zza.getSystemService("window")).getDefaultDisplay();
            rect.right = defaultDisplay.getWidth();
            rect.bottom = defaultDisplay.getHeight();
            jSONObject3.put("windowVisibility", zzaxv.zzb).put("isAttachedToWindow", z).put("viewBox", new JSONObject().put("top", zzaxv.zzc.top).put("bottom", zzaxv.zzc.bottom).put("left", zzaxv.zzc.left).put("right", zzaxv.zzc.right)).put("adBox", new JSONObject().put("top", zzaxv.zzd.top).put("bottom", zzaxv.zzd.bottom).put("left", zzaxv.zzd.left).put("right", zzaxv.zzd.right)).put("globalVisibleBox", new JSONObject().put("top", zzaxv.zze.top).put("bottom", zzaxv.zze.bottom).put("left", zzaxv.zze.left).put("right", zzaxv.zze.right)).put("globalVisibleBoxVisible", zzaxv.zzf).put("localVisibleBox", new JSONObject().put("top", zzaxv.zzg.top).put("bottom", zzaxv.zzg.bottom).put("left", zzaxv.zzg.left).put("right", zzaxv.zzg.right)).put("localVisibleBoxVisible", zzaxv.zzh).put("hitBox", new JSONObject().put("top", zzaxv.zzi.top).put("bottom", zzaxv.zzi.bottom).put("left", zzaxv.zzi.left).put("right", zzaxv.zzi.right)).put("screenDensity", (double) this.zza.getResources().getDisplayMetrics().density);
            jSONObject3.put("isVisible", zzcoe.zza);
            if (((Boolean) zzba.zzc().zza(zzbbw.zzbg)).booleanValue()) {
                JSONArray jSONArray2 = new JSONArray();
                List<Rect> list = zzaxv.zzk;
                if (list != null) {
                    for (Rect rect2 : list) {
                        jSONArray2.put(new JSONObject().put("top", rect2.top).put("bottom", rect2.bottom).put("left", rect2.left).put("right", rect2.right));
                    }
                }
                jSONObject3.put("scrollableContainerBoxes", jSONArray2);
            }
            if (!TextUtils.isEmpty(zzcoe.zze)) {
                jSONObject3.put("doneReasonCode", "u");
            }
            jSONObject = jSONObject3;
        } else {
            throw new JSONException("Active view Info cannot be null.");
        }
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }
}
