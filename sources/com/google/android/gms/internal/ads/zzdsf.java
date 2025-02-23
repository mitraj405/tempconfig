package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.nonagon.signalgeneration.zzq;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdsf {
    private final ConcurrentHashMap zza;
    private final zzbzi zzb;
    private final zzffg zzc;
    private final String zzd;
    private final String zze;
    private final zzj zzf;
    private final Bundle zzg = new Bundle();
    private final Context zzh;

    public zzdsf(Context context, zzdsp zzdsp, zzbzi zzbzi, zzffg zzffg, String str, String str2, zzj zzj) {
        ActivityManager.MemoryInfo zzc2;
        String str3;
        ConcurrentHashMap zzc3 = zzdsp.zzc();
        this.zza = zzc3;
        this.zzb = zzbzi;
        this.zzc = zzffg;
        this.zzd = str;
        this.zze = str2;
        this.zzf = zzj;
        this.zzh = context;
        zzc3.put(FirebaseAnalytics.Param.AD_FORMAT, str2.toUpperCase(Locale.ROOT));
        boolean booleanValue = ((Boolean) zzba.zzc().zza(zzbbw.zziF)).booleanValue();
        String str4 = C0515Ga.AVLBLTY_ONLY;
        if (booleanValue) {
            int zzj2 = zzj.zzj();
            int i = zzj2 - 1;
            if (zzj2 != 0) {
                if (i == 0) {
                    str3 = str4;
                } else if (i != 1) {
                    str3 = "na";
                } else {
                    str3 = C0515Ga.FARE_ONLY;
                }
                zzc3.put("asv", str3);
            } else {
                throw null;
            }
        }
        if (((Boolean) zzba.zzc().zza(zzbbw.zzbS)).booleanValue()) {
            Runtime runtime = Runtime.getRuntime();
            zzc("rt_f", String.valueOf(runtime.freeMemory()));
            zzc("rt_m", String.valueOf(runtime.maxMemory()));
            zzc("rt_t", String.valueOf(runtime.totalMemory()));
            zzc("wv_c", String.valueOf(zzu.zzo().zzb()));
            if (((Boolean) zzba.zzc().zza(zzbbw.zzbU)).booleanValue() && (zzc2 = zzf.zzc(context)) != null) {
                zzc("mem_avl", String.valueOf(zzc2.availMem));
                zzc("mem_tt", String.valueOf(zzc2.totalMem));
                zzc("low_m", true != zzc2.lowMemory ? "0" : str4);
            }
        }
        if (((Boolean) zzba.zzc().zza(zzbbw.zzgo)).booleanValue()) {
            int zzf2 = zzq.zzf(zzffg) - 1;
            if (zzf2 != 0) {
                if (zzf2 == 1) {
                    zzc3.put("request_id", str);
                    zzc3.put("se", "query_g");
                } else if (zzf2 == 2) {
                    zzc3.put("se", "r_adinfo");
                } else if (zzf2 != 3) {
                    zzc3.put("se", "r_both");
                } else {
                    zzc3.put("se", "r_adstring");
                }
                zzc3.put("scar", "true");
                zzc("ragent", zzffg.zzd.zzp);
                zzc("rtype", zzq.zzb(zzq.zzc(zzffg.zzd)));
                return;
            }
            zzc3.put("request_id", str);
            zzc3.put("scar", "false");
        }
    }

    public final Bundle zza() {
        return this.zzg;
    }

    public final Map zzb() {
        return this.zza;
    }

    public final void zzc(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.zza.put(str, str2);
        }
    }

    public final void zzd(zzfex zzfex) {
        String str;
        if (!zzfex.zzb.zza.isEmpty()) {
            zzfel zzfel = (zzfel) zzfex.zzb.zza.get(0);
            zzc(FirebaseAnalytics.Param.AD_FORMAT, zzfel.zza(zzfel.zzb));
            if (zzfel.zzb == 6) {
                ConcurrentHashMap concurrentHashMap = this.zza;
                if (true != this.zzb.zzm()) {
                    str = "0";
                } else {
                    str = C0515Ga.AVLBLTY_ONLY;
                }
                concurrentHashMap.put("as", str);
            }
        }
        zzc("gqi", zzfex.zzb.zzb.zzb);
    }

    public final void zze(Bundle bundle) {
        if (bundle != null) {
            if (bundle.containsKey("cnt")) {
                zzc("network_coarse", Integer.toString(bundle.getInt("cnt")));
            }
            if (bundle.containsKey("gnt")) {
                zzc("network_fine", Integer.toString(bundle.getInt("gnt")));
            }
        }
    }
}
