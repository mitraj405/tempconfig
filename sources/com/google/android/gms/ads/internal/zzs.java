package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzad;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbde;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzs {
    private final Context zza;
    private final String zzb;
    private final Map zzc = new TreeMap();
    private String zzd;
    private String zze;
    private final String zzf;

    public zzs(Context context, String str) {
        String str2;
        this.zza = context.getApplicationContext();
        this.zzb = str;
        String packageName = context.getPackageName();
        try {
            str2 = packageName + "-" + Wrappers.packageManager(context).getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            zzm.zzh("Unable to get package version name for reporting", e);
            str2 = String.valueOf(packageName).concat("-missing");
        }
        this.zzf = str2;
    }

    public final String zza() {
        return this.zzf;
    }

    public final String zzb() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zzd;
    }

    public final Map zze() {
        return this.zzc;
    }

    public final void zzf(zzl zzl, VersionInfoParcel versionInfoParcel) {
        Bundle bundle;
        this.zzd = zzl.zzj.zza;
        Bundle bundle2 = zzl.zzm;
        if (bundle2 != null) {
            bundle = bundle2.getBundle(AdMobAdapter.class.getName());
        } else {
            bundle = null;
        }
        if (bundle != null) {
            String str = (String) zzbde.zzc.zze();
            for (String next : bundle.keySet()) {
                if (str.equals(next)) {
                    this.zze = bundle.getString(next);
                } else if (next.startsWith("csa_")) {
                    this.zzc.put(next.substring(4), bundle.getString(next));
                }
            }
            this.zzc.put("SDKVersion", versionInfoParcel.afmaVersion);
            if (((Boolean) zzbde.zza.zze()).booleanValue()) {
                Bundle zzb2 = zzad.zzb(this.zza, (String) zzbde.zzb.zze());
                for (String next2 : zzb2.keySet()) {
                    this.zzc.put(next2, zzb2.get(next2).toString());
                }
            }
        }
    }
}
