package com.google.android.gms.internal.ads;

import android.os.Build;
import android.webkit.WebView;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.Date;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public class zzfmz {
    private final String zza;
    private zzfob zzb = new zzfob((WebView) null);
    private long zzc;
    private int zzd;

    public zzfmz(String str) {
        zzb();
        this.zza = str;
    }

    public final WebView zza() {
        return (WebView) this.zzb.get();
    }

    public final void zzb() {
        this.zzc = System.nanoTime();
        this.zzd = 1;
    }

    public void zzc() {
        this.zzb.clear();
    }

    public final void zzd(String str, long j) {
        if (j >= this.zzc && this.zzd != 3) {
            this.zzd = 3;
            zzfms.zza().zzg(zza(), this.zza, str);
        }
    }

    public final void zze() {
        zzfms.zza().zzc(zza(), this.zza);
    }

    public final void zzf(zzflr zzflr) {
        zzfms.zza().zzd(zza(), this.zza, zzflr.zzb());
    }

    public final void zzg(Date date) {
        if (date != null) {
            JSONObject jSONObject = new JSONObject();
            zzfnf.zze(jSONObject, PaymentConstants.TIMESTAMP, Long.valueOf(date.getTime()));
            zzfms.zza().zzf(zza(), jSONObject);
        }
    }

    public final void zzh(String str, long j) {
        if (j >= this.zzc) {
            this.zzd = 2;
            zzfms.zza().zzg(zza(), this.zza, str);
        }
    }

    public void zzi(zzflu zzflu, zzfls zzfls) {
        zzj(zzflu, zzfls, (JSONObject) null);
    }

    public final void zzj(zzflu zzflu, zzfls zzfls, JSONObject jSONObject) {
        String zzh = zzflu.zzh();
        JSONObject jSONObject2 = new JSONObject();
        zzfnf.zze(jSONObject2, PaymentConstants.ENV, "app");
        zzfnf.zze(jSONObject2, "adSessionType", zzfls.zzd());
        JSONObject jSONObject3 = new JSONObject();
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        zzfnf.zze(jSONObject3, "deviceType", str + "; " + str2);
        zzfnf.zze(jSONObject3, "osVersion", Integer.toString(Build.VERSION.SDK_INT));
        zzfnf.zze(jSONObject3, "os", "Android");
        zzfnf.zze(jSONObject2, "deviceInfo", jSONObject3);
        zzfnf.zze(jSONObject2, "deviceCategory", zzfne.zza().toString());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        zzfnf.zze(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject4 = new JSONObject();
        zzfnf.zze(jSONObject4, "partnerName", zzfls.zze().zzb());
        zzfnf.zze(jSONObject4, "partnerVersion", zzfls.zze().zzc());
        zzfnf.zze(jSONObject2, "omidNativeInfo", jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        zzfnf.zze(jSONObject5, "libraryVersion", "1.4.10-google_20240110");
        zzfnf.zze(jSONObject5, RemoteConfigConstants.RequestFieldKey.APP_ID, zzfmq.zzb().zza().getApplicationContext().getPackageName());
        zzfnf.zze(jSONObject2, "app", jSONObject5);
        if (zzfls.zzf() != null) {
            zzfnf.zze(jSONObject2, "contentUrl", zzfls.zzf());
        }
        if (zzfls.zzg() != null) {
            zzfnf.zze(jSONObject2, "customReferenceData", zzfls.zzg());
        }
        JSONObject jSONObject6 = new JSONObject();
        Iterator it = zzfls.zzh().iterator();
        if (!it.hasNext()) {
            zzfms.zza().zzi(zza(), zzh, jSONObject2, jSONObject6, jSONObject);
        } else {
            zzfme zzfme = (zzfme) it.next();
            throw null;
        }
    }

    public final void zzk(boolean z) {
        String str;
        if (this.zzb.get() != null) {
            if (true != z) {
                str = "backgrounded";
            } else {
                str = "foregrounded";
            }
            zzfms.zza().zzh(zza(), this.zza, str);
        }
    }

    public final void zzl(float f) {
        zzfms.zza().zze(zza(), this.zza, f);
    }

    public final void zzm(WebView webView) {
        this.zzb = new zzfob(webView);
    }

    public void zzn() {
    }
}
