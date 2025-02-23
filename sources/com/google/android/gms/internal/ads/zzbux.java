package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.perf.FirebasePerformance;
import in.juspay.hypersdk.core.PaymentConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbux extends zzbuv {
    private final Object zza = new Object();
    private final Context zzb;
    private SharedPreferences zzc;
    private final zzbne zzd;
    private final VersionInfoParcel zze;

    public zzbux(Context context, zzbne zzbne, VersionInfoParcel versionInfoParcel) {
        this.zzb = context.getApplicationContext();
        this.zze = versionInfoParcel;
        this.zzd = zzbne;
    }

    public static JSONObject zzc(Context context, VersionInfoParcel versionInfoParcel) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (((Boolean) zzbds.zzb.zze()).booleanValue()) {
                jSONObject.put("package_name", context.getPackageName());
            }
            jSONObject.put("js", versionInfoParcel.afmaVersion);
            jSONObject.put("mf", zzbds.zzc.zze());
            jSONObject.put("cl", "661295874");
            jSONObject.put("rapid_rc", PaymentConstants.ENVIRONMENT.DEV);
            jSONObject.put("rapid_rollup", FirebasePerformance.HttpMethod.HEAD);
            jSONObject.put("admob_module_version", GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            jSONObject.put("dynamite_local_version", ModuleDescriptor.MODULE_VERSION);
            jSONObject.put("dynamite_version", DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID));
            jSONObject.put("container_version", GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final ListenableFuture zza() {
        synchronized (this.zza) {
            if (this.zzc == null) {
                this.zzc = this.zzb.getSharedPreferences("google_ads_flags_meta", 0);
            }
        }
        SharedPreferences sharedPreferences = this.zzc;
        long j = 0;
        if (sharedPreferences != null) {
            j = sharedPreferences.getLong("js_last_update", 0);
        }
        if (zzu.zzB().currentTimeMillis() - j < ((Long) zzbds.zzd.zze()).longValue()) {
            return zzgcj.zzh((Object) null);
        }
        return zzgcj.zzm(this.zzd.zzb(zzc(this.zzb, this.zze)), new zzbuw(this), zzbzo.zzf);
    }

    public final /* synthetic */ Void zzb(JSONObject jSONObject) {
        zzbbn zzbbn = zzbbw.zza;
        zzba.zzb();
        SharedPreferences zza2 = zzbbp.zza(this.zzb);
        if (zza2 == null) {
            return null;
        }
        SharedPreferences.Editor edit = zza2.edit();
        zzba.zza();
        int i = zzbdi.zza;
        zzba.zza().zze(edit, 1, jSONObject);
        zzba.zzb();
        edit.commit();
        SharedPreferences sharedPreferences = this.zzc;
        if (sharedPreferences == null) {
            return null;
        }
        sharedPreferences.edit().putLong("js_last_update", zzu.zzB().currentTimeMillis()).apply();
        return null;
    }
}
