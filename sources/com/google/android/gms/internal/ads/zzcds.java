package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzcds implements Runnable {
    public final /* synthetic */ zzcbk zza;
    public final /* synthetic */ Map zzb;

    public /* synthetic */ zzcds(zzcbk zzcbk, Map map) {
        this.zza = zzcbk;
        this.zzb = map;
    }

    public final void run() {
        int i = zzcdw.zza;
        this.zza.zzd("onGcacheInfoEvent", this.zzb);
    }
}
