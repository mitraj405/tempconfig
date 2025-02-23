package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzze implements Executor {
    public final /* synthetic */ zzdt zza;

    public /* synthetic */ zzze(zzdt zzdt) {
        this.zza = zzdt;
    }

    public final void execute(Runnable runnable) {
        this.zza.zzh(runnable);
    }
}
