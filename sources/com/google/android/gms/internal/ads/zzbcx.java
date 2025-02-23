package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsSession;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.nonagon.signalgeneration.zze;
import com.google.android.gms.ads.query.QueryInfo;
import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbcx {
    private final ScheduledExecutorService zza;
    private final zze zzb;
    private Runnable zzc;
    private zzbcu zzd;
    /* access modifiers changed from: private */
    public CustomTabsSession zze;
    private String zzf;
    private long zzg = 0;
    private long zzh;
    private JSONArray zzi;
    private Context zzj;

    public zzbcx(ScheduledExecutorService scheduledExecutorService, zze zze2) {
        this.zza = scheduledExecutorService;
        this.zzb = zze2;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0049, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbbw.zziT)).booleanValue() != false) goto L_0x004b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzj() {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzbcu r0 = r6.zzd
            if (r0 != 0) goto L_0x000a
            java.lang.String r0 = "PACT callback is not present, please initialize the PawCustomTabsImpl."
            com.google.android.gms.ads.internal.util.client.zzm.zzg(r0)
            return
        L_0x000a:
            java.lang.Boolean r0 = r0.zza()
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0015
            return
        L_0x0015:
            java.lang.String r0 = r6.zzf
            if (r0 == 0) goto L_0x009c
            androidx.browser.customtabs.CustomTabsSession r0 = r6.zze
            if (r0 == 0) goto L_0x009c
            java.util.concurrent.ScheduledExecutorService r0 = r6.zza
            if (r0 == 0) goto L_0x009c
            long r0 = r6.zzg
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x002a
            goto L_0x0039
        L_0x002a:
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzu.zzB()
            long r0 = r0.elapsedRealtime()
            long r2 = r6.zzg
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x0039
            goto L_0x004b
        L_0x0039:
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zziT
            com.google.android.gms.internal.ads.zzbbu r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x009c
        L_0x004b:
            androidx.browser.customtabs.CustomTabsSession r0 = r6.zze
            java.lang.String r1 = r6.zzf
            android.net.Uri r1 = android.net.Uri.parse(r1)
            r0.getClass()
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ RemoteException -> 0x0082 }
            r3.<init>()     // Catch:{ RemoteException -> 0x0082 }
            android.app.PendingIntent r4 = r0.a     // Catch:{ RemoteException -> 0x0082 }
            if (r4 == 0) goto L_0x006b
            if (r4 == 0) goto L_0x006b
            java.lang.String r5 = "android.support.customtabs.extra.SESSION_ID"
            r3.putParcelable(r5, r4)     // Catch:{ RemoteException -> 0x0082 }
        L_0x006b:
            boolean r4 = r3.isEmpty()     // Catch:{ RemoteException -> 0x0082 }
            if (r4 == 0) goto L_0x0072
            r3 = 0
        L_0x0072:
            android.support.customtabs.ICustomTabsCallback r4 = r0.f1313a
            android.support.customtabs.ICustomTabsService r0 = r0.f1314a
            if (r3 == 0) goto L_0x007f
            r2.putAll(r3)     // Catch:{ RemoteException -> 0x0082 }
            r0.requestPostMessageChannelWithExtras(r4, r1, r2)     // Catch:{ RemoteException -> 0x0082 }
            goto L_0x0082
        L_0x007f:
            r0.requestPostMessageChannel(r4, r1)     // Catch:{ RemoteException -> 0x0082 }
        L_0x0082:
            java.util.concurrent.ScheduledExecutorService r0 = r6.zza
            java.lang.Runnable r1 = r6.zzc
            com.google.android.gms.internal.ads.zzbbn r2 = com.google.android.gms.internal.ads.zzbbw.zziU
            com.google.android.gms.internal.ads.zzbbu r3 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r2 = r3.zza(r2)
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS
            r0.schedule(r1, r2, r4)
            return
        L_0x009c:
            java.lang.String r0 = "PACT max retry connection duration timed out"
            com.google.android.gms.ads.internal.util.zze.zza(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbcx.zzj():void");
    }

    private final void zzk(JSONObject jSONObject) {
        try {
            if (this.zzi == null) {
                this.zzi = new JSONArray((String) zzba.zzc().zza(zzbbw.zziW));
            }
            jSONObject.put("eids", this.zzi);
        } catch (JSONException e) {
            zzm.zzh("Error fetching the PACT active eids JSON: ", e);
        }
    }

    public final CustomTabsSession zzb() {
        return this.zze;
    }

    public final JSONObject zzc(String str, String str2) throws JSONException {
        long j;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("paw_id", str);
        jSONObject.put("error", str2);
        if (((Boolean) zzbdx.zza.zze()).booleanValue()) {
            j = ((Long) zzba.zzc().zza(zzbbw.zziX)).longValue();
        } else {
            j = 0;
        }
        jSONObject.put("sdk_ttl_ms", j);
        zzk(jSONObject);
        return jSONObject;
    }

    public final JSONObject zzd(String str, String str2) throws JSONException {
        long j;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("paw_id", str);
        jSONObject.put("signal", str2);
        if (((Boolean) zzbdx.zza.zze()).booleanValue()) {
            j = ((Long) zzba.zzc().zza(zzbbw.zziX)).longValue();
        } else {
            j = 0;
        }
        jSONObject.put("sdk_ttl_ms", j);
        zzk(jSONObject);
        return jSONObject;
    }

    public final void zzf() {
        this.zzg = zzu.zzB().elapsedRealtime() + ((long) ((Integer) zzba.zzc().zza(zzbbw.zziS)).intValue());
        if (this.zzc == null) {
            this.zzc = new zzbcv(this);
        }
        zzj();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzg(android.content.Context r2, androidx.browser.customtabs.CustomTabsClient r3, java.lang.String r4, androidx.browser.customtabs.CustomTabsCallback r5) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x0046
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto L_0x003e
            if (r3 == 0) goto L_0x0036
            r1.zzj = r2
            r1.zzf = r4
            com.google.android.gms.internal.ads.zzbcu r2 = new com.google.android.gms.internal.ads.zzbcu
            r2.<init>(r1, r5)
            r1.zzd = r2
            J7 r4 = new J7
            r4.<init>(r2)
            android.support.customtabs.ICustomTabsService r2 = r3.f1310a
            boolean r5 = r2.newSession(r4)     // Catch:{ RemoteException -> 0x002b }
            if (r5 != 0) goto L_0x0023
            goto L_0x002b
        L_0x0023:
            androidx.browser.customtabs.CustomTabsSession r5 = new androidx.browser.customtabs.CustomTabsSession
            android.content.ComponentName r3 = r3.a
            r5.<init>(r2, r4, r3)
            goto L_0x002c
        L_0x002b:
            r5 = 0
        L_0x002c:
            r1.zze = r5
            if (r5 != 0) goto L_0x0035
            java.lang.String r2 = "CustomTabsClient failed to create new session."
            com.google.android.gms.ads.internal.util.client.zzm.zzg(r2)
        L_0x0035:
            return
        L_0x0036:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "CustomTabsClient parameter is null"
            r2.<init>(r3)
            throw r2
        L_0x003e:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Origin parameter is empty or null"
            r2.<init>(r3)
            throw r2
        L_0x0046:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "App Context parameter is null"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbcx.zzg(android.content.Context, androidx.browser.customtabs.CustomTabsClient, java.lang.String, androidx.browser.customtabs.CustomTabsCallback):void");
    }

    public final void zzh(String str) {
        try {
            CustomTabsSession customTabsSession = this.zze;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("gsppack", true);
            jSONObject.put("fpt", new Date(this.zzh).toString());
            zzk(jSONObject);
            customTabsSession.a(jSONObject.toString());
            zzbcw zzbcw = new zzbcw(this, str);
            if (((Boolean) zzbdx.zza.zze()).booleanValue()) {
                this.zzb.zzg(this.zze, zzbcw);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("query_info_type", "requester_type_6");
            QueryInfo.generate(this.zzj, AdFormat.BANNER, ((AdRequest.Builder) new AdRequest.Builder().addNetworkExtrasBundle(AdMobAdapter.class, bundle)).build(), zzbcw);
        } catch (JSONException e) {
            zzm.zzh("Error creating JSON: ", e);
        }
    }

    public final void zzi(long j) {
        this.zzh = j;
    }
}
