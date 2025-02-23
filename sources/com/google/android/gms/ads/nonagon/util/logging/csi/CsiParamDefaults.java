package com.google.android.gms.ads.nonagon.util.logging.csi;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.ads.zzbbn;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzfvj;
import in.juspay.hyper.constants.LogSubCategory;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public class CsiParamDefaults {
    private final Context zza;
    private final String zzb;
    private final String zzc;

    public CsiParamDefaults(Context context, VersionInfoParcel versionInfoParcel) {
        this.zza = context;
        this.zzb = context.getPackageName();
        this.zzc = versionInfoParcel.afmaVersion;
    }

    public void set(Map<String, String> map) {
        map.put("s", "gmob_sdk");
        map.put("v", C0515Ga.FARE_AVLBLTY);
        map.put("os", Build.VERSION.RELEASE);
        map.put("api_v", Build.VERSION.SDK);
        zzu.zzp();
        map.put(LogSubCategory.Context.DEVICE, zzt.zzr());
        map.put("app", this.zzb);
        zzu.zzp();
        String str = "0";
        map.put("is_lite_sdk", true != zzt.zzE(this.zza) ? str : C0515Ga.AVLBLTY_ONLY);
        zzbbn zzbbn = zzbbw.zza;
        List zzb2 = zzba.zza().zzb();
        if (((Boolean) zzba.zzc().zza(zzbbw.zzgj)).booleanValue()) {
            zzb2.addAll(zzu.zzo().zzi().zzh().zzd());
        }
        map.put("e", TextUtils.join(",", zzb2));
        map.put("sdkVersion", this.zzc);
        if (((Boolean) zzba.zzc().zza(zzbbw.zzku)).booleanValue()) {
            zzu.zzp();
            if (true == zzt.zzB(this.zza)) {
                str = C0515Ga.AVLBLTY_ONLY;
            }
            map.put("is_bstar", str);
        }
        if (((Boolean) zzba.zzc().zza(zzbbw.zziA)).booleanValue()) {
            if (((Boolean) zzba.zzc().zza(zzbbw.zzbZ)).booleanValue()) {
                map.put("plugin", zzfvj.zzc(zzu.zzo().zzn()));
            }
        }
    }
}
