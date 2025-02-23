package com.google.android.gms.ads.internal.util;

import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzu;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzca implements SharedPreferences.OnSharedPreferenceChangeListener {
    final /* synthetic */ zzcb zza;
    private final String zzb;

    public zzca(zzcb zzcb, String str) {
        this.zza = zzcb;
        this.zzb = str;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zza) {
            for (zzbz zzbz : this.zza.zzb) {
                String str2 = this.zzb;
                Map map = zzbz.zza;
                if (map.containsKey(str2) && ((Set) map.get(str2)).contains(str)) {
                    zzu.zzo().zzi().zzJ(false);
                }
            }
        }
    }
}
