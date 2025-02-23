package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdws implements Callable {
    public final /* synthetic */ zzauo zza;
    public final /* synthetic */ Context zzb;

    public /* synthetic */ zzdws(zzauo zzauo, Context context) {
        this.zza = zzauo;
        this.zzb = context;
    }

    public final Object call() {
        return this.zza.zzc().zzg(this.zzb);
    }
}
