package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzdsf;
import com.google.android.gms.internal.ads.zzdsp;
import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzf extends QueryInfoGenerationCallback {
    private final zze zza;
    private final zzdsp zzb;
    private final boolean zzc;
    private final int zzd;
    private final long zze = zzu.zzB().currentTimeMillis();
    private final Boolean zzf;

    public zzf(zze zze2, boolean z, int i, Boolean bool, zzdsp zzdsp) {
        this.zza = zze2;
        this.zzc = z;
        this.zzd = i;
        this.zzf = bool;
        this.zzb = zzdsp;
    }

    private static long zza() {
        return ((Long) zzba.zzc().zza(zzbbw.zziX)).longValue() + zzu.zzB().currentTimeMillis();
    }

    private final long zzb() {
        return zzu.zzB().currentTimeMillis() - this.zze;
    }

    public final void onFailure(String str) {
        String str2;
        Pair[] pairArr = new Pair[9];
        pairArr[0] = new Pair("sgf_reason", str);
        pairArr[1] = new Pair("se", "query_g");
        pairArr[2] = new Pair(FirebaseAnalytics.Param.AD_FORMAT, AdFormat.BANNER.name());
        pairArr[3] = new Pair("rtype", Integer.toString(6));
        pairArr[4] = new Pair("scar", "true");
        pairArr[5] = new Pair("lat_ms", Long.toString(zzb()));
        pairArr[6] = new Pair("sgpc_rn", Integer.toString(this.zzd));
        pairArr[7] = new Pair("sgpc_lsu", String.valueOf(this.zzf));
        if (true != this.zzc) {
            str2 = "0";
        } else {
            str2 = C0515Ga.AVLBLTY_ONLY;
        }
        pairArr[8] = new Pair("tpc", str2);
        zzq.zzd(this.zzb, (zzdsf) null, "sgpcf", pairArr);
        this.zza.zzf(this.zzc, new zzg((QueryInfo) null, str, zza(), this.zzd));
    }

    public final void onSuccess(QueryInfo queryInfo) {
        String str;
        Pair[] pairArr = new Pair[8];
        pairArr[0] = new Pair("se", "query_g");
        pairArr[1] = new Pair(FirebaseAnalytics.Param.AD_FORMAT, AdFormat.BANNER.name());
        pairArr[2] = new Pair("rtype", Integer.toString(6));
        pairArr[3] = new Pair("scar", "true");
        pairArr[4] = new Pair("lat_ms", Long.toString(zzb()));
        pairArr[5] = new Pair("sgpc_rn", Integer.toString(this.zzd));
        pairArr[6] = new Pair("sgpc_lsu", String.valueOf(this.zzf));
        if (true != this.zzc) {
            str = "0";
        } else {
            str = C0515Ga.AVLBLTY_ONLY;
        }
        pairArr[7] = new Pair("tpc", str);
        zzq.zzd(this.zzb, (zzdsf) null, "sgpcs", pairArr);
        this.zza.zzf(this.zzc, new zzg(queryInfo, "", zza(), this.zzd));
    }
}
