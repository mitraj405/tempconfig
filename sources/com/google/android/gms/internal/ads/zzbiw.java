package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbiw {
    public static final zzbix zzA = new zzbik();
    public static final zzbix zzB = new zzbim();
    public static final zzbix zzC = new zzbin();
    public static final zzbix zza = new zzbhu();
    public static final zzbix zzb = new zzbhw();
    public static final zzbix zzc = new zzbhz();
    public static final zzbix zzd = new zzbio();
    public static final zzbix zze = new zzbip();
    public static final zzbix zzf = new zzbia();
    public static final zzbix zzg = new zzbiq();
    public static final zzbix zzh = new zzbir();
    public static final zzbix zzi = new zzbhy();
    public static final zzbix zzj = new zzbis();
    public static final zzbix zzk = new zzbit();
    public static final zzbix zzl = new zzccj();
    public static final zzbix zzm = new zzcck();
    public static final zzbix zzn = new zzbhq();
    public static final zzbjn zzo = new zzbjn();
    public static final zzbix zzp = new zzbiu();
    public static final zzbix zzq = new zzbiv();
    public static final zzbix zzr = new zzbib();
    public static final zzbix zzs = new zzbic();
    public static final zzbix zzt = new zzbid();
    public static final zzbix zzu = new zzbie();
    public static final zzbix zzv = new zzbif();
    public static final zzbix zzw = new zzbig();
    public static final zzbix zzx = new zzbih();
    public static final zzbix zzy = new zzbii();
    public static final zzbix zzz = new zzbij();

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.common.util.concurrent.ListenableFuture zza(com.google.android.gms.internal.ads.zzcej r5, java.lang.String r6) {
        /*
            android.net.Uri r0 = android.net.Uri.parse(r6)
            com.google.android.gms.internal.ads.zzauo r1 = r5.zzI()     // Catch:{ zzaup -> 0x0052 }
            com.google.android.gms.internal.ads.zzffk r2 = r5.zzS()     // Catch:{ zzaup -> 0x0052 }
            com.google.android.gms.internal.ads.zzbbn r3 = com.google.android.gms.internal.ads.zzbbw.zzla     // Catch:{ zzaup -> 0x0052 }
            com.google.android.gms.internal.ads.zzbbu r4 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ zzaup -> 0x0052 }
            java.lang.Object r3 = r4.zza(r3)     // Catch:{ zzaup -> 0x0052 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ zzaup -> 0x0052 }
            boolean r3 = r3.booleanValue()     // Catch:{ zzaup -> 0x0052 }
            if (r3 == 0) goto L_0x0039
            if (r2 == 0) goto L_0x0039
            if (r1 == 0) goto L_0x005b
            boolean r1 = r1.zzf(r0)     // Catch:{ zzaup -> 0x0052 }
            if (r1 == 0) goto L_0x005b
            android.content.Context r1 = r5.getContext()     // Catch:{ zzaup -> 0x0052 }
            android.view.View r3 = r5.zzF()     // Catch:{ zzaup -> 0x0052 }
            android.app.Activity r4 = r5.zzi()     // Catch:{ zzaup -> 0x0052 }
            android.net.Uri r0 = r2.zza(r0, r1, r3, r4)     // Catch:{ zzaup -> 0x0052 }
            goto L_0x005b
        L_0x0039:
            if (r1 == 0) goto L_0x005b
            boolean r2 = r1.zzf(r0)     // Catch:{ zzaup -> 0x0052 }
            if (r2 == 0) goto L_0x005b
            android.content.Context r2 = r5.getContext()     // Catch:{ zzaup -> 0x0052 }
            android.view.View r3 = r5.zzF()     // Catch:{ zzaup -> 0x0052 }
            android.app.Activity r4 = r5.zzi()     // Catch:{ zzaup -> 0x0052 }
            android.net.Uri r0 = r1.zza(r0, r2, r3, r4)     // Catch:{ zzaup -> 0x0052 }
            goto L_0x005b
        L_0x0052:
            java.lang.String r1 = "Unable to append parameter to URL: "
            java.lang.String r6 = r1.concat(r6)
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r6)
        L_0x005b:
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            com.google.android.gms.internal.ads.zzfel r1 = r5.zzD()
            if (r1 == 0) goto L_0x006c
            com.google.android.gms.internal.ads.zzfel r6 = r5.zzD()
            java.util.Map r6 = r6.zzaw
        L_0x006c:
            android.content.Context r1 = r5.getContext()
            java.lang.String r6 = com.google.android.gms.internal.ads.zzbyc.zzb(r0, r1, r6)
            com.google.android.gms.internal.ads.zzbdc r0 = com.google.android.gms.internal.ads.zzbdr.zze
            java.lang.Object r0 = r0.zze()
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x00b5
            r2 = 242402501(0xe72c4c5, double:1.19762748E-315)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x00b5
            com.google.common.util.concurrent.ListenableFuture r5 = r5.zzT()
            com.google.android.gms.internal.ads.zzgca r5 = com.google.android.gms.internal.ads.zzgca.zzu(r5)
            com.google.android.gms.internal.ads.zzbhr r0 = new com.google.android.gms.internal.ads.zzbhr
            r0.<init>()
            com.google.android.gms.internal.ads.zzgcu r1 = com.google.android.gms.internal.ads.zzbzo.zzf
            java.lang.Class<java.lang.Throwable> r2 = java.lang.Throwable.class
            com.google.common.util.concurrent.ListenableFuture r5 = com.google.android.gms.internal.ads.zzgcj.zze(r5, r2, r0, r1)
            com.google.android.gms.internal.ads.zzbhs r0 = new com.google.android.gms.internal.ads.zzbhs
            r0.<init>(r6)
            com.google.common.util.concurrent.ListenableFuture r5 = com.google.android.gms.internal.ads.zzgcj.zzm(r5, r0, r1)
            com.google.android.gms.internal.ads.zzbht r0 = new com.google.android.gms.internal.ads.zzbht
            r0.<init>(r6)
            com.google.common.util.concurrent.ListenableFuture r5 = com.google.android.gms.internal.ads.zzgcj.zze(r5, r2, r0, r1)
            return r5
        L_0x00b5:
            com.google.common.util.concurrent.ListenableFuture r5 = com.google.android.gms.internal.ads.zzgcj.zzh(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbiw.zza(com.google.android.gms.internal.ads.zzcej, java.lang.String):com.google.common.util.concurrent.ListenableFuture");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00da  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void zzb(com.google.android.gms.internal.ads.zzcfq r16, java.util.Map r17) {
        /*
            java.lang.String r1 = "openableIntents"
            android.content.Context r0 = r16.getContext()
            android.content.pm.PackageManager r2 = r0.getPackageManager()
            java.lang.String r0 = "data"
            r3 = r17
            java.lang.Object r0 = r3.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0107 }
            r3.<init>(r0)     // Catch:{ JSONException -> 0x0107 }
            java.lang.String r0 = "intents"
            org.json.JSONArray r3 = r3.getJSONArray(r0)     // Catch:{ JSONException -> 0x00fa }
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            r5 = 0
            r6 = r5
        L_0x0026:
            int r0 = r3.length()
            if (r6 >= r0) goto L_0x00f2
            org.json.JSONObject r0 = r3.getJSONObject(r6)     // Catch:{ JSONException -> 0x00e7 }
            java.lang.String r7 = "id"
            java.lang.String r7 = r0.optString(r7)
            java.lang.String r8 = "u"
            java.lang.String r8 = r0.optString(r8)
            java.lang.String r9 = "i"
            java.lang.String r9 = r0.optString(r9)
            java.lang.String r10 = "m"
            java.lang.String r10 = r0.optString(r10)
            java.lang.String r11 = "p"
            java.lang.String r11 = r0.optString(r11)
            java.lang.String r12 = "c"
            java.lang.String r12 = r0.optString(r12)
            java.lang.String r13 = "intent_url"
            java.lang.String r13 = r0.optString(r13)
            boolean r0 = android.text.TextUtils.isEmpty(r13)
            r14 = 0
            if (r0 != 0) goto L_0x0075
            android.content.Intent r0 = android.content.Intent.parseUri(r13, r5)     // Catch:{ URISyntaxException -> 0x0066 }
            goto L_0x0076
        L_0x0066:
            r0 = move-exception
            r15 = r0
            java.lang.String r0 = java.lang.String.valueOf(r13)
            java.lang.String r13 = "Error parsing the url: "
            java.lang.String r0 = r13.concat(r0)
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r0, r15)
        L_0x0075:
            r0 = r14
        L_0x0076:
            r13 = 1
            if (r0 != 0) goto L_0x00c2
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            boolean r15 = android.text.TextUtils.isEmpty(r8)
            if (r15 != 0) goto L_0x008b
            android.net.Uri r8 = android.net.Uri.parse(r8)
            r0.setData(r8)
        L_0x008b:
            boolean r8 = android.text.TextUtils.isEmpty(r9)
            if (r8 != 0) goto L_0x0094
            r0.setAction(r9)
        L_0x0094:
            boolean r8 = android.text.TextUtils.isEmpty(r10)
            if (r8 != 0) goto L_0x009d
            r0.setType(r10)
        L_0x009d:
            boolean r8 = android.text.TextUtils.isEmpty(r11)
            if (r8 != 0) goto L_0x00a6
            r0.setPackage(r11)
        L_0x00a6:
            boolean r8 = android.text.TextUtils.isEmpty(r12)
            if (r8 != 0) goto L_0x00c2
            java.lang.String r8 = "/"
            r9 = 2
            java.lang.String[] r8 = r12.split(r8, r9)
            int r10 = r8.length
            if (r10 != r9) goto L_0x00c2
            android.content.ComponentName r9 = new android.content.ComponentName
            r10 = r8[r5]
            r8 = r8[r13]
            r9.<init>(r10, r8)
            r0.setComponent(r9)
        L_0x00c2:
            r8 = r0
            r0 = 65536(0x10000, float:9.18355E-41)
            android.content.pm.ResolveInfo r14 = r2.resolveActivity(r8, r0)     // Catch:{ NullPointerException -> 0x00ca }
            goto L_0x00d7
        L_0x00ca:
            r0 = move-exception
            r9 = r0
            com.google.android.gms.internal.ads.zzbze r0 = com.google.android.gms.ads.internal.zzu.zzo()
            java.lang.String r8 = r8.toString()
            r0.zzw(r9, r8)
        L_0x00d7:
            if (r14 == 0) goto L_0x00da
            goto L_0x00db
        L_0x00da:
            r13 = r5
        L_0x00db:
            r4.put(r7, r13)     // Catch:{ JSONException -> 0x00df }
            goto L_0x00ee
        L_0x00df:
            r0 = move-exception
            r7 = r0
            java.lang.String r0 = "Error constructing openable urls response."
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r0, r7)
            goto L_0x00ee
        L_0x00e7:
            r0 = move-exception
            r7 = r0
            java.lang.String r0 = "Error parsing the intent data."
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r0, r7)
        L_0x00ee:
            int r6 = r6 + 1
            goto L_0x0026
        L_0x00f2:
            r0 = r16
            com.google.android.gms.internal.ads.zzbls r0 = (com.google.android.gms.internal.ads.zzbls) r0
            r0.zze(r1, r4)
            return
        L_0x00fa:
            r0 = r16
            com.google.android.gms.internal.ads.zzbls r0 = (com.google.android.gms.internal.ads.zzbls) r0
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            r0.zze(r1, r2)
            return
        L_0x0107:
            r0 = r16
            com.google.android.gms.internal.ads.zzbls r0 = (com.google.android.gms.internal.ads.zzbls) r0
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            r0.zze(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbiw.zzb(com.google.android.gms.internal.ads.zzcfq, java.util.Map):void");
    }

    public static void zzc(Map map, zzdeq zzdeq) {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzjQ)).booleanValue() && map.containsKey("sc") && ((String) map.get("sc")).equals(C0515Ga.AVLBLTY_ONLY) && zzdeq != null) {
            zzdeq.zzdG();
        }
    }
}
