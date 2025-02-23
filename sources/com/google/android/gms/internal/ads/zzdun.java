package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.messaging.Constants;
import in.juspay.hypersdk.core.PaymentConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdun {
    private boolean zza = false;
    private boolean zzb = false;
    /* access modifiers changed from: private */
    public boolean zzc = false;
    /* access modifiers changed from: private */
    public final long zzd;
    /* access modifiers changed from: private */
    public final zzbzt zze = new zzbzt();
    private final Context zzf;
    private final WeakReference zzg;
    private final zzdqb zzh;
    /* access modifiers changed from: private */
    public final Executor zzi;
    private final Executor zzj;
    private final ScheduledExecutorService zzk;
    /* access modifiers changed from: private */
    public final zzdsu zzl;
    private final VersionInfoParcel zzm;
    private final Map zzn = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public final zzddp zzo;
    /* access modifiers changed from: private */
    public final zzfki zzp;
    private boolean zzq = true;

    public zzdun(Executor executor, Context context, WeakReference weakReference, Executor executor2, zzdqb zzdqb, ScheduledExecutorService scheduledExecutorService, zzdsu zzdsu, VersionInfoParcel versionInfoParcel, zzddp zzddp, zzfki zzfki) {
        this.zzh = zzdqb;
        this.zzf = context;
        this.zzg = weakReference;
        this.zzi = executor2;
        this.zzk = scheduledExecutorService;
        this.zzj = executor;
        this.zzl = zzdsu;
        this.zzm = versionInfoParcel;
        this.zzo = zzddp;
        this.zzp = zzfki;
        this.zzd = zzu.zzB().elapsedRealtime();
        zzv("com.google.android.gms.ads.MobileAds", false, "", 0);
    }

    public static /* bridge */ /* synthetic */ void zzj(zzdun zzdun, String str) {
        zzdun zzdun2 = zzdun;
        int i = 5;
        zzfju zza2 = zzfjt.zza(zzdun2.zzf, 5);
        zza2.zzi();
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str).getJSONObject("initializer_settings").getJSONObject(PaymentConstants.Category.CONFIG);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                zzfju zza3 = zzfjt.zza(zzdun2.zzf, i);
                zza3.zzi();
                zza3.zzd(next);
                Object obj = new Object();
                zzbzt zzbzt = new zzbzt();
                ListenableFuture zzo2 = zzgcj.zzo(zzbzt, ((Long) zzba.zzc().zza(zzbbw.zzbE)).longValue(), TimeUnit.SECONDS, zzdun2.zzk);
                zzdun2.zzl.zzc(next);
                zzdun2.zzo.zzc(next);
                long elapsedRealtime = zzu.zzB().elapsedRealtime();
                zzdue zzdue = r1;
                ListenableFuture listenableFuture = zzo2;
                zzdue zzdue2 = new zzdue(zzdun, obj, zzbzt, next, elapsedRealtime, zza3);
                listenableFuture.addListener(zzdue, zzdun2.zzi);
                arrayList.add(listenableFuture);
                zzdum zzdum = new zzdum(zzdun, obj, next, elapsedRealtime, zza3, zzbzt);
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                ArrayList arrayList2 = new ArrayList();
                if (optJSONObject != null) {
                    try {
                        JSONArray jSONArray = optJSONObject.getJSONArray(Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
                        int i2 = 0;
                        while (i2 < jSONArray.length()) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                            String optString = jSONObject2.optString("format", "");
                            JSONObject optJSONObject2 = jSONObject2.optJSONObject(Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
                            Bundle bundle = new Bundle();
                            if (optJSONObject2 != null) {
                                Iterator<String> keys2 = optJSONObject2.keys();
                                while (keys2.hasNext()) {
                                    String next2 = keys2.next();
                                    bundle.putString(next2, optJSONObject2.optString(next2, ""));
                                    jSONArray = jSONArray;
                                }
                            }
                            JSONArray jSONArray2 = jSONArray;
                            arrayList2.add(new zzblf(optString, bundle));
                            i2++;
                            jSONArray = jSONArray2;
                        }
                    } catch (JSONException unused) {
                    }
                }
                zzdun2.zzv(next, false, "", 0);
                try {
                    zzdun2.zzj.execute(new zzdui(zzdun, next, zzdum, zzdun2.zzh.zzc(next, new JSONObject()), arrayList2));
                } catch (zzffn unused2) {
                    try {
                        zzdum.zze("Failed to create Adapter.");
                    } catch (RemoteException e) {
                        zzm.zzh("", e);
                    }
                }
                i = 5;
            }
            zzgcj.zza(arrayList).zza(new zzduf(zzdun2, zza2), zzdun2.zzi);
        } catch (JSONException e2) {
            zze.zzb("Malformed CLD response", e2);
            zzdun2.zzo.zza("MalformedJson");
            zzdun2.zzl.zza("MalformedJson");
            zzdun2.zze.zzd(e2);
            zzu.zzo().zzw(e2, "AdapterInitializer.updateAdapterStatus");
            zzfki zzfki = zzdun2.zzp;
            zza2.zzh(e2);
            zza2.zzg(false);
            zzfki.zzb(zza2.zzm());
        }
    }

    private final synchronized ListenableFuture zzu() {
        String zzc2 = zzu.zzo().zzi().zzh().zzc();
        if (!TextUtils.isEmpty(zzc2)) {
            return zzgcj.zzh(zzc2);
        }
        zzbzt zzbzt = new zzbzt();
        zzu.zzo().zzi().zzr(new zzdug(this, zzbzt));
        return zzbzt;
    }

    /* access modifiers changed from: private */
    public final void zzv(String str, boolean z, String str2, int i) {
        this.zzn.put(str, new zzbkv(str, z, i, str2));
    }

    public final /* synthetic */ Object zzf(zzfju zzfju) throws Exception {
        this.zze.zzc(Boolean.TRUE);
        zzfju.zzg(true);
        this.zzp.zzb(zzfju.zzm());
        return null;
    }

    public final List zzg() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.zzn.keySet()) {
            zzbkv zzbkv = (zzbkv) this.zzn.get(str);
            arrayList.add(new zzbkv(str, zzbkv.zzb, zzbkv.zzc, zzbkv.zzd));
        }
        return arrayList;
    }

    public final void zzl() {
        this.zzq = false;
    }

    public final /* synthetic */ void zzm() {
        synchronized (this) {
            if (!this.zzc) {
                zzv("com.google.android.gms.ads.MobileAds", false, "Timeout.", (int) (zzu.zzB().elapsedRealtime() - this.zzd));
                this.zzl.zzb("com.google.android.gms.ads.MobileAds", "timeout");
                this.zzo.zzb("com.google.android.gms.ads.MobileAds", "timeout");
                this.zze.zzd(new Exception());
            }
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0026 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zzn(java.lang.String r3, com.google.android.gms.internal.ads.zzbkz r4, com.google.android.gms.internal.ads.zzfge r5, java.util.List r6) {
        /*
            r2 = this;
            java.lang.String r0 = "Failed to initialize adapter. "
            java.lang.String r1 = "com.google.ads.mediation.admob.AdMobAdapter"
            boolean r1 = java.util.Objects.equals(r3, r1)     // Catch:{ zzffn -> 0x0026, RemoteException -> 0x001f }
            if (r1 == 0) goto L_0x000e
            r4.zzf()     // Catch:{ zzffn -> 0x0026, RemoteException -> 0x001f }
            return
        L_0x000e:
            java.lang.ref.WeakReference r1 = r2.zzg     // Catch:{ zzffn -> 0x0026, RemoteException -> 0x001f }
            java.lang.Object r1 = r1.get()     // Catch:{ zzffn -> 0x0026, RemoteException -> 0x001f }
            android.content.Context r1 = (android.content.Context) r1     // Catch:{ zzffn -> 0x0026, RemoteException -> 0x001f }
            if (r1 == 0) goto L_0x0019
            goto L_0x001b
        L_0x0019:
            android.content.Context r1 = r2.zzf     // Catch:{ zzffn -> 0x0026, RemoteException -> 0x001f }
        L_0x001b:
            r5.zzi(r1, r4, r6)     // Catch:{ zzffn -> 0x0026, RemoteException -> 0x001f }
            return
        L_0x001f:
            r3 = move-exception
            com.google.android.gms.internal.ads.zzfvq r4 = new com.google.android.gms.internal.ads.zzfvq
            r4.<init>(r3)
            throw r4
        L_0x0026:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x003b }
            r5.<init>(r0)     // Catch:{ RemoteException -> 0x003b }
            r5.append(r3)     // Catch:{ RemoteException -> 0x003b }
            java.lang.String r3 = " does not implement the initialize() method."
            r5.append(r3)     // Catch:{ RemoteException -> 0x003b }
            java.lang.String r3 = r5.toString()     // Catch:{ RemoteException -> 0x003b }
            r4.zze(r3)     // Catch:{ RemoteException -> 0x003b }
            return
        L_0x003b:
            r3 = move-exception
            java.lang.String r4 = ""
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r4, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdun.zzn(java.lang.String, com.google.android.gms.internal.ads.zzbkz, com.google.android.gms.internal.ads.zzfge, java.util.List):void");
    }

    public final /* synthetic */ void zzo(zzbzt zzbzt) {
        this.zzi.execute(new zzdud(this, zzbzt));
    }

    public final /* synthetic */ void zzp() {
        this.zzl.zze();
        this.zzo.zze();
        this.zzb = true;
    }

    public final /* synthetic */ void zzq(Object obj, zzbzt zzbzt, String str, long j, zzfju zzfju) {
        synchronized (obj) {
            if (!zzbzt.isDone()) {
                zzv(str, false, "Timeout.", (int) (zzu.zzB().elapsedRealtime() - j));
                this.zzl.zzb(str, "timeout");
                this.zzo.zzb(str, "timeout");
                zzfki zzfki = this.zzp;
                zzfju.zzc("Timeout");
                zzfju.zzg(false);
                zzfki.zzb(zzfju.zzm());
                zzbzt.zzc(Boolean.FALSE);
            }
        }
    }

    public final void zzr() {
        if (!((Boolean) zzbdy.zza.zze()).booleanValue()) {
            if (this.zzm.clientJarVersion >= ((Integer) zzba.zzc().zza(zzbbw.zzbD)).intValue() && this.zzq) {
                if (!this.zza) {
                    synchronized (this) {
                        if (!this.zza) {
                            this.zzl.zzf();
                            this.zzo.zzf();
                            this.zze.addListener(new zzduj(this), this.zzi);
                            this.zza = true;
                            ListenableFuture zzu = zzu();
                            this.zzk.schedule(new zzduc(this), ((Long) zzba.zzc().zza(zzbbw.zzbF)).longValue(), TimeUnit.SECONDS);
                            zzgcj.zzr(zzu, new zzdul(this), this.zzi);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
        }
        if (!this.zza) {
            zzv("com.google.android.gms.ads.MobileAds", true, "", 0);
            this.zze.zzc(Boolean.FALSE);
            this.zza = true;
            this.zzb = true;
        }
    }

    public final void zzs(zzblc zzblc) {
        this.zze.addListener(new zzduh(this, zzblc), this.zzj);
    }

    public final boolean zzt() {
        return this.zzb;
    }
}
