package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbye implements SharedPreferences.OnSharedPreferenceChangeListener {
    final /* synthetic */ zzbyf zza;
    private final String zzb;

    public zzbye(zzbyf zzbyf, String str) {
        this.zza = zzbyf;
        this.zzb = str;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zza) {
            for (zzbyd zzbyd : this.zza.zzb) {
                zzbyd.zza.zzb(zzbyd.zzb, sharedPreferences, this.zzb, str);
            }
        }
    }
}
