package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdsr implements SharedPreferences.OnSharedPreferenceChangeListener {
    public final /* synthetic */ zzdss zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzdsr(zzdss zzdss, String str) {
        this.zza = zzdss;
        this.zzb = str;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        this.zza.zzd(this.zzb, sharedPreferences, str);
    }
}
