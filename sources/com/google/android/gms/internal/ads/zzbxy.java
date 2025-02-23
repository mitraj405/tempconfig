package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzbxy implements Callable {
    public final /* synthetic */ zzbya zza;
    public final /* synthetic */ Context zzb;

    public /* synthetic */ zzbxy(zzbya zzbya, Context context) {
        this.zza = zzbya;
        this.zzb = context;
    }

    public final Object call() {
        return this.zza.zze(this.zzb);
    }
}
