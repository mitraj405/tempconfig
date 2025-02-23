package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzdm;
import com.google.android.gms.ads.internal.zzu;
import java.util.List;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcwj extends zzdm {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final List zze;
    private final long zzf;
    private final String zzg;
    private final zzeey zzh;
    private final Bundle zzi;

    public zzcwj(zzfel zzfel, String str, zzeey zzeey, zzfeo zzfeo, String str2) {
        String str3;
        String str4;
        String str5;
        String str6 = null;
        if (zzfel == null) {
            str3 = null;
        } else {
            str3 = zzfel.zzab;
        }
        this.zzb = str3;
        this.zzc = str2;
        if (zzfeo == null) {
            str4 = null;
        } else {
            str4 = zzfeo.zzb;
        }
        this.zzd = str4;
        if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            try {
                str6 = zzfel.zzv.getString("class_name");
            } catch (JSONException unused) {
            }
        }
        this.zza = str6 != null ? str6 : str;
        this.zze = zzeey.zzc();
        this.zzh = zzeey;
        this.zzf = zzu.zzB().currentTimeMillis() / 1000;
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzgf)).booleanValue() || zzfeo == null) {
            this.zzi = new Bundle();
        } else {
            this.zzi = zzfeo.zzk;
        }
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzir)).booleanValue() || zzfeo == null || TextUtils.isEmpty(zzfeo.zzi)) {
            str5 = "";
        } else {
            str5 = zzfeo.zzi;
        }
        this.zzg = str5;
    }

    public final long zzc() {
        return this.zzf;
    }

    public final String zzd() {
        return this.zzg;
    }

    public final Bundle zze() {
        return this.zzi;
    }

    public final com.google.android.gms.ads.internal.client.zzu zzf() {
        zzeey zzeey = this.zzh;
        if (zzeey != null) {
            return zzeey.zza();
        }
        return null;
    }

    public final String zzg() {
        return this.zza;
    }

    public final String zzh() {
        return this.zzc;
    }

    public final String zzi() {
        return this.zzb;
    }

    public final List zzj() {
        return this.zze;
    }

    public final String zzk() {
        return this.zzd;
    }
}
