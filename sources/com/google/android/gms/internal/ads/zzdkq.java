package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.WindowManager;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdkq implements zzbix {
    public final /* synthetic */ zzdkv zza;
    public final /* synthetic */ WindowManager zzb;
    public final /* synthetic */ View zzc;

    public /* synthetic */ zzdkq(zzdkv zzdkv, WindowManager windowManager, View view) {
        this.zza = zzdkv;
        this.zzb = windowManager;
        this.zzc = view;
    }

    public final void zza(Object obj, Map map) {
        this.zza.zzc(this.zzb, this.zzc, (zzcej) obj, map);
    }
}
