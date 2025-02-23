package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.ads.zzbbw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcb {
    private final Map zza = new HashMap();
    /* access modifiers changed from: private */
    public final List zzb = new ArrayList();
    private final Context zzc;

    public zzcb(Context context) {
        this.zzc = context;
    }

    public final synchronized void zzb(String str) {
        SharedPreferences sharedPreferences;
        if (!this.zza.containsKey(str)) {
            if (Objects.equals(str, "__default__")) {
                sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.zzc);
            } else {
                sharedPreferences = this.zzc.getSharedPreferences(str, 0);
            }
            zzca zzca = new zzca(this, str);
            this.zza.put(str, zzca);
            sharedPreferences.registerOnSharedPreferenceChangeListener(zzca);
        }
    }

    public final void zzc() {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzjz)).booleanValue()) {
            zzu.zzp();
            Map zzv = zzt.zzv((String) zzba.zzc().zza(zzbbw.zzjE));
            for (String zzb2 : zzv.keySet()) {
                zzb(zzb2);
            }
            zzd(new zzbz(zzv));
        }
    }

    public final synchronized void zzd(zzbz zzbz) {
        this.zzb.add(zzbz);
    }
}
