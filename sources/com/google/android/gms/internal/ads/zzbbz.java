package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import in.juspay.hyper.constants.LogSubCategory;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbbz {
    private final String zza = ((String) zzbdm.zza.zze());
    private final Map zzb;
    private final Context zzc;
    private final String zzd;

    public zzbbz(Context context, String str) {
        String str2;
        this.zzc = context;
        this.zzd = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.zzb = linkedHashMap;
        linkedHashMap.put("s", "gmob_sdk");
        linkedHashMap.put("v", C0515Ga.FARE_AVLBLTY);
        linkedHashMap.put("os", Build.VERSION.RELEASE);
        linkedHashMap.put("api_v", Build.VERSION.SDK);
        zzu.zzp();
        linkedHashMap.put(LogSubCategory.Context.DEVICE, zzt.zzr());
        if (context.getApplicationContext() != null) {
            str2 = context.getApplicationContext().getPackageName();
        } else {
            str2 = context.getPackageName();
        }
        linkedHashMap.put("app", str2);
        zzu.zzp();
        String str3 = "0";
        linkedHashMap.put("is_lite_sdk", true != zzt.zzE(context) ? str3 : C0515Ga.AVLBLTY_ONLY);
        Future zzb2 = zzu.zzm().zzb(context);
        try {
            linkedHashMap.put("network_coarse", Integer.toString(((zzbvf) zzb2.get()).zzj));
            linkedHashMap.put("network_fine", Integer.toString(((zzbvf) zzb2.get()).zzk));
        } catch (Exception e) {
            zzu.zzo().zzw(e, "CsiConfiguration.CsiConfiguration");
        }
        if (((Boolean) zzba.zzc().zza(zzbbw.zzku)).booleanValue()) {
            Map map = this.zzb;
            zzu.zzp();
            map.put("is_bstar", true == zzt.zzB(context) ? C0515Ga.AVLBLTY_ONLY : str3);
        }
        if (((Boolean) zzba.zzc().zza(zzbbw.zziA)).booleanValue()) {
            if (((Boolean) zzba.zzc().zza(zzbbw.zzbZ)).booleanValue() && !zzfvj.zzd(zzu.zzo().zzn())) {
                this.zzb.put("plugin", zzu.zzo().zzn());
            }
        }
    }

    public final Context zza() {
        return this.zzc;
    }

    public final String zzb() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zza;
    }

    public final Map zzd() {
        return this.zzb;
    }
}
