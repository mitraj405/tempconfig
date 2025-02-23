package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.zzu;
import in.juspay.hyper.constants.LogCategory;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdrr implements zzczo, zzcye, zzcwt, zzdfc {
    private final zzdsf zza;
    private final zzdsp zzb;

    public zzdrr(zzdsf zzdsf, zzdsp zzdsp) {
        this.zza = zzdsf;
        this.zzb = zzdsp;
    }

    private final void zzc(Bundle bundle) {
        if (bundle != null) {
            for (String next : bundle.keySet()) {
                long j = bundle.getLong(next);
                if (j >= 0) {
                    this.zza.zzc(next, String.valueOf(j));
                }
            }
        }
    }

    private final void zzd(Bundle bundle, zzfxr zzfxr) {
        String str;
        if (((Boolean) zzba.zzc().zza(zzbbw.zzbS)).booleanValue() && bundle != null) {
            bundle.putLong(zzdrt.PUBLIC_API_CALLBACK.zza(), zzu.zzB().currentTimeMillis());
            zzdsf zzdsf = this.zza;
            if (true != bundle.getBoolean("ls")) {
                str = "0";
            } else {
                str = C0515Ga.AVLBLTY_ONLY;
            }
            zzdsf.zzc("ls", str);
            int size = zzfxr.size();
            for (int i = 0; i < size; i++) {
                zzdru zzdru = (zzdru) zzfxr.get(i);
                long j = bundle.getLong(zzdru.zza().zza(), -1);
                long j2 = bundle.getLong(zzdru.zzb().zza(), -1);
                if (j > 0 && j2 > 0) {
                    this.zza.zzc(zzdru.zzc(), String.valueOf(j2 - j));
                }
            }
            zzc(bundle.getBundle("client_sig_latency_key"));
            zzc(bundle.getBundle("gms_sig_latency_key"));
        }
    }

    public final void zzdB(zze zze) {
        this.zza.zzb().put(LogCategory.ACTION, "ftl");
        this.zza.zzc("ftl", String.valueOf(zze.zza));
        this.zza.zzc("ed", zze.zzc);
        this.zzb.zzf(this.zza.zzb());
    }

    public final void zzdn(zzbvb zzbvb) {
        this.zza.zze(zzbvb.zza);
    }

    public final void zzdo(zzfex zzfex) {
        this.zza.zzd(zzfex);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zze(com.google.android.gms.ads.nonagon.signalgeneration.zzay r5) {
        /*
            r4 = this;
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzgo
            com.google.android.gms.internal.ads.zzbbu r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0013
            return
        L_0x0013:
            java.lang.String r0 = "sgs"
            java.lang.String r1 = "action"
            if (r5 != 0) goto L_0x003b
            com.google.android.gms.internal.ads.zzdsf r5 = r4.zza
            java.util.Map r5 = r5.zzb()
            r5.put(r1, r0)
            com.google.android.gms.internal.ads.zzdsf r5 = r4.zza
            java.util.Map r5 = r5.zzb()
            java.lang.String r0 = "request_id"
            java.lang.String r1 = "-1"
            r5.put(r0, r1)
            com.google.android.gms.internal.ads.zzdsp r5 = r4.zzb
            com.google.android.gms.internal.ads.zzdsf r0 = r4.zza
            java.util.Map r0 = r0.zzb()
            r5.zzf(r0)
            return
        L_0x003b:
            com.google.android.gms.internal.ads.zzbvb r2 = r5.zzc
            if (r2 == 0) goto L_0x0046
            android.os.Bundle r2 = r2.zzm
            com.google.android.gms.internal.ads.zzfxr r3 = com.google.android.gms.internal.ads.zzdru.zza
            r4.zzd(r2, r3)
        L_0x0046:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00a7 }
            java.lang.String r3 = r5.zzb     // Catch:{ JSONException -> 0x00a7 }
            r2.<init>(r3)     // Catch:{ JSONException -> 0x00a7 }
            com.google.android.gms.internal.ads.zzdsf r3 = r4.zza
            java.util.Map r3 = r3.zzb()
            r3.put(r1, r0)
            com.google.android.gms.internal.ads.zzdsf r0 = r4.zza
            java.util.Map r0 = r0.zzb()
            com.google.android.gms.internal.ads.zzbbn r1 = com.google.android.gms.internal.ads.zzbbw.zziM
            com.google.android.gms.internal.ads.zzbbu r3 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r3.zza(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x006f
            goto L_0x0089
        L_0x006f:
            java.lang.String r1 = "extras"
            org.json.JSONObject r1 = r2.getJSONObject(r1)     // Catch:{ JSONException -> 0x0083 }
            java.lang.String r2 = "accept_3p_cookie"
            boolean r1 = r1.getBoolean(r2)     // Catch:{ JSONException -> 0x0083 }
            if (r1 == 0) goto L_0x0080
            java.lang.String r1 = "1"
            goto L_0x008b
        L_0x0080:
            java.lang.String r1 = "0"
            goto L_0x008b
        L_0x0083:
            r1 = move-exception
            java.lang.String r2 = "Error retrieving JSONObject from the requestJson, "
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r2, r1)
        L_0x0089:
            java.lang.String r1 = "na"
        L_0x008b:
            java.lang.String r2 = "tpc"
            r0.put(r2, r1)
            com.google.android.gms.internal.ads.zzbvb r5 = r5.zzc
            if (r5 == 0) goto L_0x009b
            com.google.android.gms.internal.ads.zzdsf r0 = r4.zza
            android.os.Bundle r5 = r5.zza
            r0.zze(r5)
        L_0x009b:
            com.google.android.gms.internal.ads.zzdsp r5 = r4.zzb
            com.google.android.gms.internal.ads.zzdsf r0 = r4.zza
            java.util.Map r0 = r0.zzb()
            r5.zzf(r0)
            return
        L_0x00a7:
            com.google.android.gms.internal.ads.zzdsf r5 = r4.zza
            java.util.Map r5 = r5.zzb()
            java.lang.String r0 = "sgf"
            r5.put(r1, r0)
            com.google.android.gms.internal.ads.zzdsf r5 = r4.zza
            java.util.Map r5 = r5.zzb()
            java.lang.String r0 = "sgf_reason"
            java.lang.String r1 = "request_invalid"
            r5.put(r0, r1)
            com.google.android.gms.internal.ads.zzdsp r5 = r4.zzb
            com.google.android.gms.internal.ads.zzdsf r0 = r4.zza
            java.util.Map r0 = r0.zzb()
            r5.zzf(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdrr.zze(com.google.android.gms.ads.nonagon.signalgeneration.zzay):void");
    }

    public final void zzf(String str) {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzgo)).booleanValue()) {
            this.zza.zzb().put(LogCategory.ACTION, "sgf");
            this.zza.zzc("sgf_reason", str);
            this.zzb.zzf(this.zza.zzb());
        }
    }

    public final void zzs() {
        String str;
        this.zza.zzb().put(LogCategory.ACTION, "loaded");
        zzd(this.zza.zza(), zzdru.zzb);
        if (((Boolean) zzba.zzc().zza(zzbbw.zzlG)).booleanValue()) {
            zzdsf zzdsf = this.zza;
            if (true != r1.C("MUTE_AUDIO")) {
                str = "0";
            } else {
                str = C0515Ga.AVLBLTY_ONLY;
            }
            zzdsf.zzb().put("mafe", str);
        }
        this.zzb.zzf(this.zza.zzb());
    }
}
