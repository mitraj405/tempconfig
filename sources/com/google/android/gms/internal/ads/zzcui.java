package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.nonagon.signalgeneration.zzay;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcui implements zzczo, zzdfc {
    private zzbuv zza;
    private final AtomicBoolean zzb = new AtomicBoolean();
    private final Context zzc;
    private final zzfki zzd;
    private final VersionInfoParcel zze;
    private final Executor zzf;
    private boolean zzg = false;
    private boolean zzh = false;

    public zzcui(Context context, zzfki zzfki, VersionInfoParcel versionInfoParcel, Executor executor) {
        this.zzc = context;
        this.zzd = zzfki;
        this.zze = versionInfoParcel;
        this.zzf = executor;
    }

    public final /* synthetic */ void zzc() {
        zzbbg.zze(this.zzc);
        this.zzh = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0066, code lost:
        if (android.text.TextUtils.equals(r0, in.juspay.hypersdk.core.PaymentConstants.SERVICE) != false) goto L_0x0068;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0080  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd() {
        /*
            r5 = this;
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.zzb
            r1 = 1
            boolean r0 = r0.getAndSet(r1)
            if (r0 == 0) goto L_0x000b
            goto L_0x00a5
        L_0x000b:
            com.google.android.gms.internal.ads.zzbdc r0 = com.google.android.gms.internal.ads.zzbds.zzk
            java.lang.Object r0 = r0.zze()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r2 = 2
            if (r0 == 0) goto L_0x001c
        L_0x001a:
            r3 = r2
            goto L_0x0068
        L_0x001c:
            com.google.android.gms.internal.ads.zzbdc r0 = com.google.android.gms.internal.ads.zzbds.zzl
            java.lang.Object r0 = r0.zze()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r3 = 3
            if (r0 == 0) goto L_0x002c
            goto L_0x0068
        L_0x002c:
            com.google.android.gms.internal.ads.zzbdc r0 = com.google.android.gms.internal.ads.zzbds.zzj
            java.lang.Object r0 = r0.zze()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x003c
        L_0x003a:
            r3 = r1
            goto L_0x0068
        L_0x003c:
            com.google.android.gms.internal.ads.zzbze r0 = com.google.android.gms.ads.internal.zzu.zzo()
            com.google.android.gms.ads.internal.util.zzg r0 = r0.zzi()
            com.google.android.gms.internal.ads.zzbyy r0 = r0.zzh()
            java.lang.String r0 = r0.zzc()
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x003a }
            r4.<init>(r0)     // Catch:{ JSONException -> 0x003a }
            java.lang.String r0 = "local_flag_write"
            java.lang.String r0 = r4.optString(r0)     // Catch:{ JSONException -> 0x003a }
            java.lang.String r4 = "client"
            boolean r4 = android.text.TextUtils.equals(r0, r4)     // Catch:{ JSONException -> 0x003a }
            if (r4 == 0) goto L_0x0060
            goto L_0x001a
        L_0x0060:
            java.lang.String r4 = "service"
            boolean r0 = android.text.TextUtils.equals(r0, r4)     // Catch:{ JSONException -> 0x003a }
            if (r0 == 0) goto L_0x003a
        L_0x0068:
            int r3 = r3 + -1
            if (r3 == r1) goto L_0x0080
            if (r3 == r2) goto L_0x006f
            goto L_0x00a5
        L_0x006f:
            android.content.Context r0 = r5.zzc
            com.google.android.gms.internal.ads.zzfki r2 = r5.zzd
            com.google.android.gms.internal.ads.zzbnf r3 = com.google.android.gms.ads.internal.zzu.zzf()
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r4 = com.google.android.gms.ads.internal.util.client.VersionInfoParcel.forPackage()
            com.google.android.gms.internal.ads.zzbno r0 = r3.zzb(r0, r4, r2)
            goto L_0x0090
        L_0x0080:
            android.content.Context r0 = r5.zzc
            com.google.android.gms.internal.ads.zzfki r2 = r5.zzd
            com.google.android.gms.internal.ads.zzbnf r3 = com.google.android.gms.ads.internal.zzu.zzf()
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r4 = com.google.android.gms.ads.internal.util.client.VersionInfoParcel.forPackage()
            com.google.android.gms.internal.ads.zzbno r0 = r3.zza(r0, r4, r2)
        L_0x0090:
            java.lang.String r2 = "google.afma.sdkConstants.getSdkConstants"
            com.google.android.gms.internal.ads.zzbni r3 = com.google.android.gms.internal.ads.zzbnl.zza
            com.google.android.gms.internal.ads.zzbne r0 = r0.zza(r2, r3, r3)
            android.content.Context r2 = r5.zzc
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r3 = r5.zze
            com.google.android.gms.internal.ads.zzbux r4 = new com.google.android.gms.internal.ads.zzbux
            r4.<init>(r2, r0, r3)
            r5.zza = r4
            r5.zzg = r1
        L_0x00a5:
            boolean r0 = r5.zzg
            if (r0 != 0) goto L_0x00aa
            goto L_0x00d3
        L_0x00aa:
            com.google.android.gms.internal.ads.zzbuv r0 = r5.zza
            if (r0 == 0) goto L_0x00d3
            com.google.common.util.concurrent.ListenableFuture r0 = r0.zza()
            boolean r1 = r5.zzh
            if (r1 != 0) goto L_0x00ce
            com.google.android.gms.internal.ads.zzbdc r1 = com.google.android.gms.internal.ads.zzbdk.zzi
            java.lang.Object r1 = r1.zze()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x00ce
            com.google.android.gms.internal.ads.zzcuh r1 = new com.google.android.gms.internal.ads.zzcuh
            r1.<init>(r5)
            java.util.concurrent.Executor r2 = r5.zzf
            r0.addListener(r1, r2)
        L_0x00ce:
            java.lang.String r1 = "persistFlagsClient"
            com.google.android.gms.internal.ads.zzbzr.zza(r0, r1)
        L_0x00d3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcui.zzd():void");
    }

    public final void zzdn(zzbvb zzbvb) {
        zzd();
    }

    public final void zze(zzay zzay) {
        zzd();
    }

    public final void zzf(String str) {
        zzd();
    }

    public final void zzdo(zzfex zzfex) {
    }
}
