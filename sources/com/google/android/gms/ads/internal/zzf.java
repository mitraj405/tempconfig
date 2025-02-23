package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbbn;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbne;
import com.google.android.gms.internal.ads.zzbni;
import com.google.android.gms.internal.ads.zzbnl;
import com.google.android.gms.internal.ads.zzbno;
import com.google.android.gms.internal.ads.zzbyy;
import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzdsj;
import com.google.android.gms.internal.ads.zzdsk;
import com.google.android.gms.internal.ads.zzfjt;
import com.google.android.gms.internal.ads.zzfju;
import com.google.android.gms.internal.ads.zzfki;
import com.google.android.gms.internal.ads.zzgcj;
import com.google.android.gms.internal.ads.zzgcu;
import com.google.common.util.concurrent.ListenableFuture;
import in.juspay.hyper.constants.LogCategory;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzf {
    private Context zza;
    private long zzb = 0;

    public static final /* synthetic */ ListenableFuture zzd(Long l, zzdsk zzdsk, zzfki zzfki, zzfju zzfju, JSONObject jSONObject) throws Exception {
        boolean optBoolean = jSONObject.optBoolean("isSuccessful", false);
        if (optBoolean) {
            zzu.zzo().zzi().zzv(jSONObject.getString("appSettingsJson"));
            if (l != null) {
                zzf(zzdsk, "cld_s", zzu.zzB().elapsedRealtime() - l.longValue());
            }
        }
        zzfju.zzg(optBoolean);
        zzfki.zzb(zzfju.zzm());
        return zzgcj.zzh((Object) null);
    }

    /* access modifiers changed from: private */
    public static final void zzf(zzdsk zzdsk, String str, long j) {
        if (zzdsk != null) {
            if (((Boolean) zzba.zzc().zza(zzbbw.zzlI)).booleanValue()) {
                zzdsj zza2 = zzdsk.zza();
                zza2.zzb(LogCategory.ACTION, "lat_init");
                zza2.zzb(str, Long.toString(j));
                zza2.zzf();
            }
        }
    }

    public final void zza(Context context, VersionInfoParcel versionInfoParcel, String str, Runnable runnable, zzfki zzfki, zzdsk zzdsk, Long l) {
        zzb(context, versionInfoParcel, true, (zzbyy) null, str, (String) null, runnable, zzfki, zzdsk, l);
    }

    public final void zzb(Context context, VersionInfoParcel versionInfoParcel, boolean z, zzbyy zzbyy, String str, String str2, Runnable runnable, zzfki zzfki, zzdsk zzdsk, Long l) {
        PackageInfo packageInfo;
        Context context2 = context;
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        Runnable runnable2 = runnable;
        zzfki zzfki2 = zzfki;
        Long l2 = l;
        if (zzu.zzB().elapsedRealtime() - this.zzb < 5000) {
            zzm.zzj("Not retrying to fetch app settings");
            return;
        }
        this.zzb = zzu.zzB().elapsedRealtime();
        if (zzbyy != null && !TextUtils.isEmpty(zzbyy.zzc())) {
            if (zzu.zzB().currentTimeMillis() - zzbyy.zza() <= ((Long) zzba.zzc().zza(zzbbw.zzdJ)).longValue() && zzbyy.zzi()) {
                return;
            }
        }
        if (context2 == null) {
            zzm.zzj("Context not provided to fetch application settings");
        } else if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context2;
            }
            this.zza = applicationContext;
            zzfju zza2 = zzfjt.zza(context, 4);
            zza2.zzi();
            zzbno zza3 = zzu.zzf().zza(this.zza, versionInfoParcel, zzfki2);
            zzbni zzbni = zzbnl.zza;
            zzbne zza4 = zza3.zza("google.afma.config.fetchAppSettings", zzbni, zzbni);
            try {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("app_id", str);
                } else if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("ad_unit_id", str2);
                }
                jSONObject.put("is_init", z);
                jSONObject.put("pn", context.getPackageName());
                zzbbn zzbbn = zzbbw.zza;
                jSONObject.put("experiment_ids", TextUtils.join(",", zzba.zza().zza()));
                jSONObject.put("js", versionInfoParcel2.afmaVersion);
                try {
                    ApplicationInfo applicationInfo = this.zza.getApplicationInfo();
                    if (!(applicationInfo == null || (packageInfo = Wrappers.packageManager(context).getPackageInfo(applicationInfo.packageName, 0)) == null)) {
                        jSONObject.put("version", packageInfo.versionCode);
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    zze.zza("Error fetching PackageInfo.");
                }
                ListenableFuture zzb2 = zza4.zzb(jSONObject);
                zzd zzd = new zzd(this, l, zzdsk, zzfki, zza2);
                zzgcu zzgcu = zzbzo.zzf;
                ListenableFuture zzn = zzgcj.zzn(zzb2, zzd, zzgcu);
                if (runnable2 != null) {
                    zzb2.addListener(runnable2, zzgcu);
                }
                if (l2 != null) {
                    zzb2.addListener(new zze(this, zzdsk, l2), zzgcu);
                }
                if (((Boolean) zzba.zzc().zza(zzbbw.zzgT)).booleanValue()) {
                    zzbzr.zzb(zzn, "ConfigLoader.maybeFetchNewAppSettings");
                } else {
                    zzbzr.zza(zzn, "ConfigLoader.maybeFetchNewAppSettings");
                }
            } catch (Exception e) {
                zzm.zzh("Error requesting application settings", e);
                zza2.zzh(e);
                zza2.zzg(false);
                zzfki2.zzb(zza2.zzm());
            }
        } else {
            zzm.zzj("App settings could not be fetched. Required parameters missing");
        }
    }

    public final void zzc(Context context, VersionInfoParcel versionInfoParcel, String str, zzbyy zzbyy, zzfki zzfki) {
        String str2;
        if (zzbyy != null) {
            str2 = zzbyy.zzb();
        } else {
            str2 = null;
        }
        zzb(context, versionInfoParcel, false, zzbyy, str2, str, (Runnable) null, zzfki, (zzdsk) null, (Long) null);
    }
}
