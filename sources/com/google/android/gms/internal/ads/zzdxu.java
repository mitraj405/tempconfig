package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.StringReader;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdxu {
    private final zzcgj zza;
    private final Context zzb;
    private final VersionInfoParcel zzc;
    private final zzffg zzd;
    private final Executor zze;
    private final String zzf;
    private final zzfkf zzg;
    private final zzdsf zzh;
    private final Object zzi = new Object();

    public zzdxu(zzcgj zzcgj, Context context, VersionInfoParcel versionInfoParcel, zzffg zzffg, Executor executor, String str, zzfkf zzfkf, zzdsf zzdsf) {
        this.zza = zzcgj;
        this.zzb = context;
        this.zzc = versionInfoParcel;
        this.zzd = zzffg;
        this.zze = executor;
        this.zzf = str;
        this.zzg = zzfkf;
        zzcgj.zzx();
        this.zzh = zzdsf;
    }

    private final ListenableFuture zzc(String str, String str2) {
        zzfju zza2 = zzfjt.zza(this.zzb, 11);
        zza2.zzi();
        zzbno zza3 = zzu.zzf().zza(this.zzb, this.zzc, this.zza.zzz());
        zzbni zzbni = zzbnl.zza;
        ListenableFuture zzn = zzgcj.zzn(zzgcj.zzn(zzgcj.zzn(zzgcj.zzh(""), new zzdxr(this, str, str2), this.zze), new zzdxs(zza3.zza("google.afma.response.normalize", zzbni, zzbni)), this.zze), new zzdxt(this), this.zze);
        zzfke.zza(zzn, this.zzg, zza2);
        return zzn;
    }

    private final String zzd(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray("ad_types");
            if (jSONArray != null && "unknown".equals(jSONArray.getString(0))) {
                jSONObject.put("ad_types", new JSONArray().put(this.zzf));
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            zzm.zzj("Failed to update the ad types for rendering. ".concat(e.toString()));
            return str;
        }
    }

    private static final String zze(String str) {
        try {
            return new JSONObject(str).optString("request_id", "");
        } catch (JSONException unused) {
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.lang.String zzf(java.lang.String r4, java.lang.String r5, java.lang.String r6, com.google.android.gms.internal.ads.zzdsf r7) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 != 0) goto L_0x0087
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x001c }
            r0.<init>(r6)     // Catch:{ JSONException -> 0x001c }
            java.lang.String r1 = "is_gbid"
            java.lang.String r0 = r0.optString(r1)     // Catch:{ JSONException -> 0x001c }
            java.lang.String r1 = "true"
            boolean r0 = r0.equals(r1)     // Catch:{ JSONException -> 0x001c }
            if (r0 == 0) goto L_0x001c
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ JSONException -> 0x001c }
            goto L_0x001e
        L_0x001c:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
        L_0x001e:
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0025
            goto L_0x0087
        L_0x0025:
            java.lang.String r0 = "&"
            int r0 = r4.lastIndexOf(r0)
            r1 = -1
            r2 = 0
            if (r0 == r1) goto L_0x0035
            r1 = 0
            java.lang.String r0 = r4.substring(r1, r0)
            goto L_0x0036
        L_0x0035:
            r0 = r2
        L_0x0036:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0087
            r1 = 11
            byte[] r0 = android.util.Base64.decode(r0, r1)     // Catch:{ UnsupportedEncodingException -> 0x0070 }
            java.lang.String r1 = "UTF-8"
            byte[] r5 = r5.getBytes(r1)     // Catch:{ UnsupportedEncodingException -> 0x0070 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0054 }
            r1.<init>(r6)     // Catch:{ JSONException -> 0x0054 }
            java.lang.String r6 = "arek"
            java.lang.String r2 = r1.getString(r6)     // Catch:{ JSONException -> 0x0054 }
            goto L_0x006b
        L_0x0054:
            r6 = move-exception
            java.lang.String r1 = r6.toString()     // Catch:{ UnsupportedEncodingException -> 0x0070 }
            java.lang.String r3 = "Failed to get key from QueryJSONMap"
            java.lang.String r1 = r3.concat(r1)     // Catch:{ UnsupportedEncodingException -> 0x0070 }
            com.google.android.gms.ads.internal.util.zze.zza(r1)     // Catch:{ UnsupportedEncodingException -> 0x0070 }
            com.google.android.gms.internal.ads.zzbze r1 = com.google.android.gms.ads.internal.zzu.zzo()     // Catch:{ UnsupportedEncodingException -> 0x0070 }
            java.lang.String r3 = "CryptoUtils.getKeyFromQueryJsonMap"
            r1.zzw(r6, r3)     // Catch:{ UnsupportedEncodingException -> 0x0070 }
        L_0x006b:
            java.lang.String r4 = com.google.android.gms.internal.ads.zzffv.zzb(r0, r5, r2, r7)     // Catch:{ UnsupportedEncodingException -> 0x0070 }
            return r4
        L_0x0070:
            r5 = move-exception
            java.lang.String r6 = "Failed to decode the adResponse. "
            java.lang.String r7 = r5.toString()
            java.lang.String r6 = r6.concat(r7)
            com.google.android.gms.ads.internal.util.zze.zza(r6)
            java.lang.String r6 = "PreloadedLoader.decryptAdResponseIfNecessary"
            com.google.android.gms.internal.ads.zzbze r7 = com.google.android.gms.ads.internal.zzu.zzo()
            r7.zzw(r5, r6)
        L_0x0087:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdxu.zzf(java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.ads.zzdsf):java.lang.String");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v27, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.String} */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x012e, code lost:
        if (r4.zzg(r1, r6, r2) == false) goto L_0x0130;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.common.util.concurrent.ListenableFuture zza() {
        /*
            r12 = this;
            com.google.android.gms.internal.ads.zzffg r0 = r12.zzd
            com.google.android.gms.ads.internal.client.zzl r0 = r0.zzd
            java.lang.String r0 = r0.zzx
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x016a
            java.lang.String r1 = zze(r0)
            com.google.android.gms.internal.ads.zzbbn r2 = com.google.android.gms.internal.ads.zzbbw.zzgv
            com.google.android.gms.internal.ads.zzbbu r3 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r3 = r3.zza(r2)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x003a
            boolean r3 = r1.isEmpty()
            if (r3 == 0) goto L_0x003a
            java.lang.String r1 = "&request_id="
            int r1 = r0.lastIndexOf(r1)
            r3 = -1
            if (r1 == r3) goto L_0x0038
            int r1 = r1 + 12
            java.lang.String r1 = r0.substring(r1)
            goto L_0x003a
        L_0x0038:
            java.lang.String r1 = ""
        L_0x003a:
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 == 0) goto L_0x004e
            com.google.android.gms.internal.ads.zzeir r0 = new com.google.android.gms.internal.ads.zzeir
            r1 = 15
            java.lang.String r2 = "Invalid ad string."
            r0.<init>(r1, r2)
            com.google.common.util.concurrent.ListenableFuture r0 = com.google.android.gms.internal.ads.zzgcj.zzg(r0)
            return r0
        L_0x004e:
            com.google.android.gms.internal.ads.zzbbn r3 = com.google.android.gms.internal.ads.zzbbw.zzgL
            com.google.android.gms.internal.ads.zzbbu r4 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r3 = r4.zza(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x0138
            java.lang.Object r3 = r12.zzi
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzcgj r4 = r12.zza     // Catch:{ all -> 0x0135 }
            com.google.android.gms.ads.nonagon.signalgeneration.zzl r4 = r4.zzo()     // Catch:{ all -> 0x0135 }
            com.google.android.gms.internal.ads.zzdsf r5 = r12.zzh     // Catch:{ all -> 0x0135 }
            java.lang.String r5 = r4.zzb(r1, r5)     // Catch:{ all -> 0x0135 }
            com.google.android.gms.internal.ads.zzbbu r6 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x0135 }
            java.lang.Object r2 = r6.zza(r2)     // Catch:{ all -> 0x0135 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x0135 }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x0135 }
            if (r2 == 0) goto L_0x0085
            com.google.android.gms.internal.ads.zzdsf r2 = r12.zzh     // Catch:{ all -> 0x0135 }
            java.lang.String r0 = zzf(r0, r1, r5, r2)     // Catch:{ all -> 0x0135 }
        L_0x0085:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0093 }
            r2.<init>(r0)     // Catch:{ JSONException -> 0x0093 }
            java.lang.String r6 = "render_id"
            java.lang.String r7 = ""
            java.lang.String r2 = r2.optString(r6, r7)     // Catch:{ all -> 0x0135 }
            goto L_0x0095
        L_0x0093:
            java.lang.String r2 = ""
        L_0x0095:
            boolean r6 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0135 }
            r7 = 0
            r8 = 0
            if (r6 != 0) goto L_0x00f8
            java.lang.String r6 = ""
            java.lang.String r9 = new java.lang.String     // Catch:{ IllegalArgumentException -> 0x00ac }
            byte[] r10 = android.util.Base64.decode(r2, r8)     // Catch:{ IllegalArgumentException -> 0x00ac }
            java.nio.charset.Charset r11 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IllegalArgumentException -> 0x00ac }
            r9.<init>(r10, r11)     // Catch:{ IllegalArgumentException -> 0x00ac }
            r6 = r9
            goto L_0x00c3
        L_0x00ac:
            r9 = move-exception
            java.lang.String r10 = "Ad grouping: Has render_id, but not base64 encoded: "
            java.lang.String r11 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x0135 }
            java.lang.String r10 = r10.concat(r11)     // Catch:{ all -> 0x0135 }
            com.google.android.gms.ads.internal.util.zze.zza(r10)     // Catch:{ all -> 0x0135 }
            com.google.android.gms.internal.ads.zzbze r10 = com.google.android.gms.ads.internal.zzu.zzo()     // Catch:{ all -> 0x0135 }
            java.lang.String r11 = "PreloadedLoader.decodeRenderId"
            r10.zzw(r9, r11)     // Catch:{ all -> 0x0135 }
        L_0x00c3:
            r9 = 58
            com.google.android.gms.internal.ads.zzfui r9 = com.google.android.gms.internal.ads.zzfui.zzc(r9)     // Catch:{ all -> 0x0135 }
            com.google.android.gms.internal.ads.zzfvh r9 = com.google.android.gms.internal.ads.zzfvh.zzb(r9)     // Catch:{ all -> 0x0135 }
            java.util.List r6 = r9.zze(r6)     // Catch:{ all -> 0x0135 }
            int r9 = r6.size()     // Catch:{ all -> 0x0135 }
            r10 = 2
            if (r9 != r10) goto L_0x00eb
            java.lang.Object r2 = r6.get(r8)     // Catch:{ all -> 0x0135 }
            r7 = r2
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x0135 }
            r2 = 1
            java.lang.Object r2 = r6.get(r2)     // Catch:{ all -> 0x0135 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0135 }
            int r8 = java.lang.Integer.parseInt(r2)     // Catch:{ all -> 0x0135 }
            goto L_0x00f8
        L_0x00eb:
            java.lang.String r6 = "Ad grouping: Has render_id, but invalid format: "
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x0135 }
            java.lang.String r2 = r6.concat(r2)     // Catch:{ all -> 0x0135 }
            com.google.android.gms.ads.internal.util.zze.zza(r2)     // Catch:{ all -> 0x0135 }
        L_0x00f8:
            android.util.Pair r2 = new android.util.Pair     // Catch:{ all -> 0x0135 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0135 }
            r2.<init>(r7, r6)     // Catch:{ all -> 0x0135 }
            java.lang.Object r6 = r2.first     // Catch:{ all -> 0x0135 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0135 }
            java.lang.Object r2 = r2.second     // Catch:{ all -> 0x0135 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x0135 }
            int r2 = r2.intValue()     // Catch:{ all -> 0x0135 }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0135 }
            if (r7 != 0) goto L_0x0130
            if (r2 <= 0) goto L_0x0130
            boolean r7 = r4.zzh(r1, r6)     // Catch:{ all -> 0x0135 }
            if (r7 == 0) goto L_0x012a
            com.google.android.gms.internal.ads.zzeir r0 = new com.google.android.gms.internal.ads.zzeir     // Catch:{ all -> 0x0135 }
            java.lang.String r1 = "The ad has already been shown."
            r2 = 10
            r0.<init>(r2, r1)     // Catch:{ all -> 0x0135 }
            com.google.common.util.concurrent.ListenableFuture r0 = com.google.android.gms.internal.ads.zzgcj.zzg(r0)     // Catch:{ all -> 0x0135 }
            monitor-exit(r3)     // Catch:{ all -> 0x0135 }
            return r0
        L_0x012a:
            boolean r2 = r4.zzg(r1, r6, r2)     // Catch:{ all -> 0x0135 }
            if (r2 != 0) goto L_0x0133
        L_0x0130:
            r4.zzf(r1)     // Catch:{ all -> 0x0135 }
        L_0x0133:
            monitor-exit(r3)     // Catch:{ all -> 0x0135 }
            goto L_0x015a
        L_0x0135:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0135 }
            throw r0
        L_0x0138:
            com.google.android.gms.internal.ads.zzcgj r3 = r12.zza
            com.google.android.gms.internal.ads.zzdsf r4 = r12.zzh
            com.google.android.gms.ads.nonagon.signalgeneration.zzl r3 = r3.zzo()
            java.lang.String r5 = r3.zzb(r1, r4)
            com.google.android.gms.internal.ads.zzbbu r3 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r2 = r3.zza(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x015a
            com.google.android.gms.internal.ads.zzdsf r2 = r12.zzh
            java.lang.String r0 = zzf(r0, r1, r5, r2)
        L_0x015a:
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 == 0) goto L_0x0161
            goto L_0x016a
        L_0x0161:
            java.lang.String r1 = r12.zzd(r5)
            com.google.common.util.concurrent.ListenableFuture r0 = r12.zzc(r0, r1)
            return r0
        L_0x016a:
            com.google.android.gms.internal.ads.zzffg r0 = r12.zzd
            com.google.android.gms.ads.internal.client.zzl r0 = r0.zzd
            com.google.android.gms.ads.internal.client.zzc r0 = r0.zzs
            if (r0 == 0) goto L_0x01cb
            com.google.android.gms.internal.ads.zzbbn r1 = com.google.android.gms.internal.ads.zzbbw.zzgk
            com.google.android.gms.internal.ads.zzbbu r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x0185
            goto L_0x01b1
        L_0x0185:
            java.lang.String r1 = r0.zza
            java.lang.String r2 = r0.zzb
            java.lang.String r1 = zze(r1)
            java.lang.String r2 = zze(r2)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x01be
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x01be
            com.google.android.gms.internal.ads.zzcgj r2 = r12.zza
            com.google.android.gms.ads.nonagon.signalgeneration.zzl r2 = r2.zzo()
            r2.zzf(r1)
            com.google.android.gms.internal.ads.zzdsf r2 = r12.zzh
            java.util.Map r2 = r2.zzb()
            java.lang.String r3 = "request_id"
            r2.put(r3, r1)
        L_0x01b1:
            java.lang.String r1 = r0.zza
            java.lang.String r0 = r0.zzb
            java.lang.String r0 = r12.zzd(r0)
            com.google.common.util.concurrent.ListenableFuture r0 = r12.zzc(r1, r0)
            return r0
        L_0x01be:
            com.google.android.gms.internal.ads.zzdsf r0 = r12.zzh
            java.util.Map r0 = r0.zzb()
            java.lang.String r1 = "ridmm"
            java.lang.String r2 = "true"
            r0.put(r1, r2)
        L_0x01cb:
            com.google.android.gms.internal.ads.zzeir r0 = new com.google.android.gms.internal.ads.zzeir
            r1 = 14
            java.lang.String r2 = "Mismatch request IDs."
            r0.<init>(r1, r2)
            com.google.common.util.concurrent.ListenableFuture r0 = com.google.android.gms.internal.ads.zzgcj.zzg(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdxu.zza():com.google.common.util.concurrent.ListenableFuture");
    }

    public final /* synthetic */ ListenableFuture zzb(JSONObject jSONObject) throws Exception {
        return zzgcj.zzh(new zzfex(new zzfeu(this.zzd), zzfew.zza(new StringReader(jSONObject.toString()), (zzbvb) null)));
    }
}
