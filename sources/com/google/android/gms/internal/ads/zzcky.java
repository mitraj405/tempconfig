package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzcn;
import com.google.android.gms.ads.internal.client.zzda;
import com.google.android.gms.ads.internal.client.zzff;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzau;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcky extends zzcn {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private final zzdqb zzc;
    private final zzeev zzd;
    private final zzelg zze;
    private final zzdun zzf;
    private final zzbya zzg;
    private final zzdqg zzh;
    private final zzdvi zzi;
    private final zzbel zzj;
    private final zzfki zzk;
    private final zzfgc zzl;
    private final zzcui zzm;
    private final zzdsk zzn;
    private boolean zzo = false;
    private final Long zzp = Long.valueOf(zzu.zzB().elapsedRealtime());

    public zzcky(Context context, VersionInfoParcel versionInfoParcel, zzdqb zzdqb, zzeev zzeev, zzelg zzelg, zzdun zzdun, zzbya zzbya, zzdqg zzdqg, zzdvi zzdvi, zzbel zzbel, zzfki zzfki, zzfgc zzfgc, zzcui zzcui, zzdsk zzdsk) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = zzdqb;
        this.zzd = zzeev;
        this.zze = zzelg;
        this.zzf = zzdun;
        this.zzg = zzbya;
        this.zzh = zzdqg;
        this.zzi = zzdvi;
        this.zzj = zzbel;
        this.zzk = zzfki;
        this.zzl = zzfgc;
        this.zzm = zzcui;
        this.zzn = zzdsk;
    }

    public final void zzb() {
        if (zzu.zzo().zzi().zzR()) {
            String zzl2 = zzu.zzo().zzi().zzl();
            if (!zzu.zzs().zzj(this.zza, zzl2, this.zzb.afmaVersion)) {
                zzu.zzo().zzi().zzC(false);
                zzu.zzo().zzi().zzB("");
            }
        }
    }

    public final void zzc(Runnable runnable) {
        Preconditions.checkMainThread("Adapters must be initialized on the main thread.");
        Map zze2 = zzu.zzo().zzi().zzh().zze();
        if (!zze2.isEmpty()) {
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    zzm.zzk("Could not initialize rewarded ads.", th);
                    return;
                }
            }
            if (this.zzc.zzd()) {
                HashMap hashMap = new HashMap();
                for (zzbog zzbog : zze2.values()) {
                    for (zzbof zzbof : zzbog.zza) {
                        String str = zzbof.zzb;
                        for (String str2 : zzbof.zza) {
                            if (!hashMap.containsKey(str2)) {
                                hashMap.put(str2, new ArrayList());
                            }
                            if (str != null) {
                                ((List) hashMap.get(str2)).add(str);
                            }
                        }
                    }
                }
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry entry : hashMap.entrySet()) {
                    String str3 = (String) entry.getKey();
                    try {
                        zzeew zza2 = this.zzd.zza(str3, jSONObject);
                        if (zza2 != null) {
                            zzfge zzfge = (zzfge) zza2.zzb;
                            if (!zzfge.zzC() && zzfge.zzB()) {
                                zzfge.zzj(this.zza, (zzegq) zza2.zzc, (List) entry.getValue());
                                zzm.zze("Initialized rewarded video mediation adapter " + str3);
                            }
                        }
                    } catch (zzffn e) {
                        zzm.zzk("Failed to initialize rewarded video mediation adapter \"" + str3 + "\"", e);
                    }
                }
            }
        }
    }

    public final /* synthetic */ void zzd() {
        zzfgl.zzb(this.zza, true);
    }

    public final synchronized float zze() {
        return zzu.zzr().zza();
    }

    public final String zzf() {
        return this.zzb.afmaVersion;
    }

    public final List zzg() throws RemoteException {
        return this.zzf.zzg();
    }

    public final void zzh(String str) {
        this.zze.zzg(str);
    }

    public final void zzi() {
        this.zzf.zzl();
    }

    public final void zzj(boolean z) throws RemoteException {
        try {
            zzfsc.zzi(this.zza).zzn(z);
        } catch (IOException e) {
            throw new RemoteException(e.getMessage());
        }
    }

    public final synchronized void zzk() {
        if (this.zzo) {
            zzm.zzj("Mobile ads is initialized already.");
            return;
        }
        zzbbw.zza(this.zza);
        zzu.zzo().zzu(this.zza, this.zzb);
        this.zzm.zzd();
        zzu.zzc().zzi(this.zza);
        this.zzo = true;
        this.zzf.zzr();
        this.zze.zze();
        if (((Boolean) zzba.zzc().zza(zzbbw.zzdE)).booleanValue()) {
            this.zzh.zzc();
        }
        this.zzi.zzg();
        if (((Boolean) zzba.zzc().zza(zzbbw.zzip)).booleanValue()) {
            zzbzo.zza.execute(new zzckt(this));
        }
        if (((Boolean) zzba.zzc().zza(zzbbw.zzjY)).booleanValue()) {
            zzbzo.zza.execute(new zzckv(this));
        }
        if (((Boolean) zzba.zzc().zza(zzbbw.zzcA)).booleanValue()) {
            zzbzo.zza.execute(new zzcku(this));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzl(java.lang.String r12, com.google.android.gms.dynamic.IObjectWrapper r13) {
        /*
            r11 = this;
            android.content.Context r0 = r11.zza
            com.google.android.gms.internal.ads.zzbbw.zza(r0)
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzdI
            com.google.android.gms.internal.ads.zzbbu r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x002d
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ RuntimeException -> 0x0023, RemoteException -> 0x0021 }
            android.content.Context r0 = r11.zza     // Catch:{ RuntimeException -> 0x0023, RemoteException -> 0x0021 }
            java.lang.String r0 = com.google.android.gms.ads.internal.util.zzt.zzp(r0)     // Catch:{ RuntimeException -> 0x0023, RemoteException -> 0x0021 }
            goto L_0x002f
        L_0x0021:
            r0 = move-exception
            goto L_0x0024
        L_0x0023:
            r0 = move-exception
        L_0x0024:
            java.lang.String r1 = "NonagonMobileAdsSettingManager_AppId"
            com.google.android.gms.internal.ads.zzbze r2 = com.google.android.gms.ads.internal.zzu.zzo()
            r2.zzw(r0, r1)
        L_0x002d:
            java.lang.String r0 = ""
        L_0x002f:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 1
            if (r2 != r1) goto L_0x0038
            r6 = r12
            goto L_0x0039
        L_0x0038:
            r6 = r0
        L_0x0039:
            boolean r12 = android.text.TextUtils.isEmpty(r6)
            if (r12 == 0) goto L_0x0040
            goto L_0x0093
        L_0x0040:
            com.google.android.gms.internal.ads.zzbbn r12 = com.google.android.gms.internal.ads.zzbbw.zzdC
            com.google.android.gms.internal.ads.zzbbu r0 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r12 = r0.zza(r12)
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzaH
            com.google.android.gms.internal.ads.zzbbu r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r1.zza(r0)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            r12 = r12 | r1
            com.google.android.gms.internal.ads.zzbbu r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x007d
            java.lang.Object r12 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r13)
            java.lang.Runnable r12 = (java.lang.Runnable) r12
            com.google.android.gms.internal.ads.zzckw r13 = new com.google.android.gms.internal.ads.zzckw
            r13.<init>(r11, r12)
            goto L_0x007f
        L_0x007d:
            r13 = 0
            r2 = r12
        L_0x007f:
            r7 = r13
            if (r2 == 0) goto L_0x0093
            android.content.Context r4 = r11.zza
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r5 = r11.zzb
            com.google.android.gms.internal.ads.zzfki r8 = r11.zzk
            com.google.android.gms.internal.ads.zzdsk r9 = r11.zzn
            java.lang.Long r10 = r11.zzp
            com.google.android.gms.ads.internal.zzf r3 = com.google.android.gms.ads.internal.zzu.zza()
            r3.zza(r4, r5, r6, r7, r8, r9, r10)
        L_0x0093:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcky.zzl(java.lang.String, com.google.android.gms.dynamic.IObjectWrapper):void");
    }

    public final void zzm(zzda zzda) throws RemoteException {
        this.zzi.zzh(zzda, zzdvh.API);
    }

    public final void zzn(IObjectWrapper iObjectWrapper, String str) {
        if (iObjectWrapper == null) {
            zzm.zzg("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        if (context == null) {
            zzm.zzg("Context is null. Failed to open debug menu.");
            return;
        }
        zzau zzau = new zzau(context);
        zzau.zzn(str);
        zzau.zzo(this.zzb.afmaVersion);
        zzau.zzr();
    }

    public final void zzo(zzbom zzbom) throws RemoteException {
        this.zzl.zzf(zzbom);
    }

    public final synchronized void zzp(boolean z) {
        zzu.zzr().zzc(z);
    }

    public final synchronized void zzq(float f) {
        zzu.zzr().zzd(f);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0032, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzr(java.lang.String r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            android.content.Context r0 = r9.zza     // Catch:{ all -> 0x0033 }
            com.google.android.gms.internal.ads.zzbbw.zza(r0)     // Catch:{ all -> 0x0033 }
            boolean r0 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0033 }
            if (r0 != 0) goto L_0x0031
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzdC     // Catch:{ all -> 0x0033 }
            com.google.android.gms.internal.ads.zzbbu r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x0033 }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x0033 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0033 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x0031
            android.content.Context r2 = r9.zza     // Catch:{ all -> 0x0033 }
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r3 = r9.zzb     // Catch:{ all -> 0x0033 }
            com.google.android.gms.internal.ads.zzfki r6 = r9.zzk     // Catch:{ all -> 0x0033 }
            com.google.android.gms.ads.internal.zzf r1 = com.google.android.gms.ads.internal.zzu.zza()     // Catch:{ all -> 0x0033 }
            r5 = 0
            r7 = 0
            r8 = 0
            r4 = r10
            r1.zza(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0033 }
            monitor-exit(r9)
            return
        L_0x0031:
            monitor-exit(r9)
            return
        L_0x0033:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcky.zzr(java.lang.String):void");
    }

    public final void zzs(zzblc zzblc) throws RemoteException {
        this.zzf.zzs(zzblc);
    }

    public final void zzt(String str) {
        if (((Boolean) zzba.zzc().zza(zzbbw.zziA)).booleanValue()) {
            zzu.zzo().zzz(str);
        }
    }

    public final void zzu(zzff zzff) throws RemoteException {
        this.zzg.zzn(this.zza, zzff);
    }

    public final synchronized boolean zzv() {
        return zzu.zzr().zze();
    }

    public final /* synthetic */ void zzw() {
        this.zzj.zza(new zzbtv());
    }
}
