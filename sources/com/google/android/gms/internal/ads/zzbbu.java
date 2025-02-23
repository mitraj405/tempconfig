package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.ConditionVariable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzbbu implements SharedPreferences.OnSharedPreferenceChangeListener {
    volatile boolean zza = false;
    private final Object zzb = new Object();
    private final ConditionVariable zzc = new ConditionVariable();
    private volatile boolean zzd = false;
    private SharedPreferences zze = null;
    private Bundle zzf = new Bundle();
    private Context zzg;
    private JSONObject zzh = new JSONObject();
    private boolean zzi = false;
    private boolean zzj = false;

    private final void zzg(SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            try {
                this.zzh = new JSONObject((String) zzbby.zza(new zzbbr(sharedPreferences)));
            } catch (JSONException unused) {
            }
        }
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            zzg(sharedPreferences);
        }
    }

    public final Object zza(zzbbn zzbbn) {
        if (!this.zzc.block(5000)) {
            synchronized (this.zzb) {
                if (!this.zza) {
                    throw new IllegalStateException("Flags.initialize() was not called!");
                }
            }
        }
        if (!this.zzd || this.zze == null || this.zzj) {
            synchronized (this.zzb) {
                if (this.zzd && this.zze != null) {
                    if (this.zzj) {
                    }
                }
                Object zzm = zzbbn.zzm();
                return zzm;
            }
        }
        if (zzbbn.zze() == 2) {
            Bundle bundle = this.zzf;
            if (bundle == null) {
                return zzbbn.zzm();
            }
            return zzbbn.zzb(bundle);
        } else if (zzbbn.zze() != 1 || !this.zzh.has(zzbbn.zzn())) {
            return zzbby.zza(new zzbbs(this, zzbbn));
        } else {
            return zzbbn.zza(this.zzh);
        }
    }

    public final Object zzb(zzbbn zzbbn) {
        if (this.zzd || this.zza) {
            return zza(zzbbn);
        }
        return zzbbn.zzm();
    }

    public final /* synthetic */ Object zzc(zzbbn zzbbn) {
        return zzbbn.zzc(this.zze);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0113, code lost:
        if (new org.json.JSONObject((java.lang.String) com.google.android.gms.internal.ads.zzbby.zza(new com.google.android.gms.internal.ads.zzbbq(r3))).optBoolean("local_flags_enabled") != false) goto L_0x0115;
     */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0119 A[SYNTHETIC, Splitter:B:72:0x0119] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0122 A[SYNTHETIC, Splitter:B:76:0x0122] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(android.content.Context r11) {
        /*
            r10 = this;
            boolean r0 = r10.zzd
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            java.lang.Object r0 = r10.zzb
            monitor-enter(r0)
            boolean r1 = r10.zzd     // Catch:{ all -> 0x0159 }
            if (r1 == 0) goto L_0x000e
            monitor-exit(r0)     // Catch:{ all -> 0x0159 }
            return
        L_0x000e:
            boolean r1 = r10.zza     // Catch:{ all -> 0x0159 }
            r2 = 1
            if (r1 != 0) goto L_0x0015
            r10.zza = r2     // Catch:{ all -> 0x0159 }
        L_0x0015:
            java.lang.String r1 = r11.getPackageName()     // Catch:{ all -> 0x0159 }
            java.lang.String r3 = "com.google.android.gms"
            boolean r1 = android.text.TextUtils.equals(r1, r3)     // Catch:{ all -> 0x0159 }
            r10.zzi = r1     // Catch:{ all -> 0x0159 }
            android.content.Context r1 = r11.getApplicationContext()     // Catch:{ all -> 0x0159 }
            if (r1 == 0) goto L_0x002b
            android.content.Context r11 = r11.getApplicationContext()     // Catch:{ all -> 0x0159 }
        L_0x002b:
            r10.zzg = r11     // Catch:{ all -> 0x0159 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r11 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r11)     // Catch:{ NameNotFoundException | NullPointerException -> 0x0041 }
            android.content.Context r1 = r10.zzg     // Catch:{ NameNotFoundException | NullPointerException -> 0x0041 }
            java.lang.String r1 = r1.getPackageName()     // Catch:{ NameNotFoundException | NullPointerException -> 0x0041 }
            r3 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r11 = r11.getApplicationInfo(r1, r3)     // Catch:{ NameNotFoundException | NullPointerException -> 0x0041 }
            android.os.Bundle r11 = r11.metaData     // Catch:{ NameNotFoundException | NullPointerException -> 0x0041 }
            r10.zzf = r11     // Catch:{ NameNotFoundException | NullPointerException -> 0x0041 }
        L_0x0041:
            r11 = 0
            android.content.Context r1 = r10.zzg     // Catch:{ all -> 0x0150 }
            android.content.Context r3 = com.google.android.gms.common.GooglePlayServicesUtilLight.getRemoteContext(r1)     // Catch:{ all -> 0x0150 }
            if (r3 != 0) goto L_0x0052
            if (r1 == 0) goto L_0x0052
            android.content.Context r3 = r1.getApplicationContext()     // Catch:{ all -> 0x0150 }
            if (r3 == 0) goto L_0x0053
        L_0x0052:
            r1 = r3
        L_0x0053:
            if (r1 == 0) goto L_0x005d
            com.google.android.gms.ads.internal.client.zzba.zzb()     // Catch:{ all -> 0x0150 }
            android.content.SharedPreferences r3 = com.google.android.gms.internal.ads.zzbbp.zza(r1)     // Catch:{ all -> 0x0150 }
            goto L_0x005e
        L_0x005d:
            r3 = 0
        L_0x005e:
            if (r3 == 0) goto L_0x0068
            com.google.android.gms.internal.ads.zzbbt r4 = new com.google.android.gms.internal.ads.zzbbt     // Catch:{ all -> 0x0150 }
            r4.<init>(r10, r3)     // Catch:{ all -> 0x0150 }
            com.google.android.gms.internal.ads.zzbej.zzc(r4)     // Catch:{ all -> 0x0150 }
        L_0x0068:
            boolean r3 = r10.zzi     // Catch:{ all -> 0x0150 }
            r4 = 0
            if (r3 != 0) goto L_0x00a0
            com.google.android.gms.internal.ads.zzbdc r3 = com.google.android.gms.internal.ads.zzbdk.zzd     // Catch:{ all -> 0x0150 }
            java.lang.Object r6 = r3.zze()     // Catch:{ all -> 0x0150 }
            java.lang.Long r6 = (java.lang.Long) r6     // Catch:{ all -> 0x0150 }
            long r6 = r6.longValue()     // Catch:{ all -> 0x0150 }
            int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x00a0
            android.content.Context r6 = r10.zzg     // Catch:{ all -> 0x0150 }
            int r6 = com.google.android.gms.internal.ads.zzbbg.zza(r6)     // Catch:{ all -> 0x0150 }
            long r6 = (long) r6     // Catch:{ all -> 0x0150 }
            java.lang.Object r3 = r3.zze()     // Catch:{ all -> 0x0150 }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ all -> 0x0150 }
            long r8 = r3.longValue()     // Catch:{ all -> 0x0150 }
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 < 0) goto L_0x00a0
            r10.zzj = r2     // Catch:{ all -> 0x0150 }
            r10.zzd = r2     // Catch:{ all -> 0x0150 }
            r10.zza = r11     // Catch:{ all -> 0x0159 }
            android.os.ConditionVariable r11 = r10.zzc     // Catch:{ all -> 0x0159 }
            r11.open()     // Catch:{ all -> 0x0159 }
            monitor-exit(r0)     // Catch:{ all -> 0x0159 }
            return
        L_0x00a0:
            boolean r3 = r10.zzi     // Catch:{ all -> 0x0150 }
            if (r3 != 0) goto L_0x00d6
            com.google.android.gms.internal.ads.zzbdc r3 = com.google.android.gms.internal.ads.zzbdk.zzf     // Catch:{ all -> 0x0150 }
            java.lang.Object r6 = r3.zze()     // Catch:{ all -> 0x0150 }
            java.lang.Long r6 = (java.lang.Long) r6     // Catch:{ all -> 0x0150 }
            long r6 = r6.longValue()     // Catch:{ all -> 0x0150 }
            int r4 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x00d6
            android.content.Context r4 = r10.zzg     // Catch:{ all -> 0x0150 }
            int r4 = com.google.android.gms.internal.ads.zzbbg.zzb(r4)     // Catch:{ all -> 0x0150 }
            long r4 = (long) r4     // Catch:{ all -> 0x0150 }
            java.lang.Object r3 = r3.zze()     // Catch:{ all -> 0x0150 }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ all -> 0x0150 }
            long r6 = r3.longValue()     // Catch:{ all -> 0x0150 }
            int r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r3 < 0) goto L_0x00d6
            r10.zzj = r2     // Catch:{ all -> 0x0150 }
            r10.zzd = r2     // Catch:{ all -> 0x0150 }
            r10.zza = r11     // Catch:{ all -> 0x0159 }
            android.os.ConditionVariable r11 = r10.zzc     // Catch:{ all -> 0x0159 }
            r11.open()     // Catch:{ all -> 0x0159 }
            monitor-exit(r0)     // Catch:{ all -> 0x0159 }
            return
        L_0x00d6:
            android.content.Context r3 = r10.zzg     // Catch:{ all -> 0x0150 }
            com.google.android.gms.internal.ads.zzbdc r4 = com.google.android.gms.internal.ads.zzbds.zzh     // Catch:{ all -> 0x0150 }
            java.lang.Object r4 = r4.zze()     // Catch:{ all -> 0x0150 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x0150 }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x0150 }
            if (r4 == 0) goto L_0x00e7
            goto L_0x0115
        L_0x00e7:
            com.google.android.gms.internal.ads.zzbdc r4 = com.google.android.gms.internal.ads.zzbds.zzi     // Catch:{ all -> 0x0150 }
            java.lang.Object r4 = r4.zze()     // Catch:{ all -> 0x0150 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x0150 }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x0150 }
            if (r4 == 0) goto L_0x0117
            java.lang.String r4 = "admob"
            android.content.SharedPreferences r3 = r3.getSharedPreferences(r4, r11)     // Catch:{ all -> 0x0150 }
            if (r3 == 0) goto L_0x0117
            com.google.android.gms.internal.ads.zzbbq r4 = new com.google.android.gms.internal.ads.zzbbq     // Catch:{ all -> 0x0150 }
            r4.<init>(r3)     // Catch:{ all -> 0x0150 }
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzbby.zza(r4)     // Catch:{ all -> 0x0150 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0150 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0117 }
            r4.<init>(r3)     // Catch:{ JSONException -> 0x0117 }
            java.lang.String r3 = "local_flags_enabled"
            boolean r3 = r4.optBoolean(r3)     // Catch:{ JSONException -> 0x0117 }
            if (r3 == 0) goto L_0x0117
        L_0x0115:
            android.content.Context r1 = r10.zzg     // Catch:{ all -> 0x0150 }
        L_0x0117:
            if (r1 != 0) goto L_0x0122
            r10.zza = r11     // Catch:{ all -> 0x0159 }
            android.os.ConditionVariable r11 = r10.zzc     // Catch:{ all -> 0x0159 }
            r11.open()     // Catch:{ all -> 0x0159 }
            monitor-exit(r0)     // Catch:{ all -> 0x0159 }
            return
        L_0x0122:
            com.google.android.gms.ads.internal.client.zzba.zzb()     // Catch:{ all -> 0x0150 }
            android.content.SharedPreferences r1 = com.google.android.gms.internal.ads.zzbbp.zza(r1)     // Catch:{ all -> 0x0150 }
            r10.zze = r1     // Catch:{ all -> 0x0150 }
            com.google.android.gms.internal.ads.zzbdc r1 = com.google.android.gms.internal.ads.zzbds.zza     // Catch:{ all -> 0x0150 }
            java.lang.Object r1 = r1.zze()     // Catch:{ all -> 0x0150 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x0150 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x0150 }
            if (r1 != 0) goto L_0x0140
            android.content.SharedPreferences r1 = r10.zze     // Catch:{ all -> 0x0150 }
            if (r1 == 0) goto L_0x0140
            r1.registerOnSharedPreferenceChangeListener(r10)     // Catch:{ all -> 0x0150 }
        L_0x0140:
            android.content.SharedPreferences r1 = r10.zze     // Catch:{ all -> 0x0150 }
            r10.zzg(r1)     // Catch:{ all -> 0x0150 }
            r10.zzd = r2     // Catch:{ all -> 0x0150 }
            r10.zza = r11     // Catch:{ all -> 0x0159 }
            android.os.ConditionVariable r11 = r10.zzc     // Catch:{ all -> 0x0159 }
            r11.open()     // Catch:{ all -> 0x0159 }
            monitor-exit(r0)     // Catch:{ all -> 0x0159 }
            return
        L_0x0150:
            r1 = move-exception
            r10.zza = r11     // Catch:{ all -> 0x0159 }
            android.os.ConditionVariable r11 = r10.zzc     // Catch:{ all -> 0x0159 }
            r11.open()     // Catch:{ all -> 0x0159 }
            throw r1     // Catch:{ all -> 0x0159 }
        L_0x0159:
            r11 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0159 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbu.zzd(android.content.Context):void");
    }

    public final boolean zze() {
        return this.zzj;
    }

    public final boolean zzf() {
        return this.zzi;
    }
}
