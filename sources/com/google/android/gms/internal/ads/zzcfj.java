package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzcfj implements Runnable {
    public final /* synthetic */ zzcfl zza;
    public final /* synthetic */ Map zzb;

    public /* synthetic */ zzcfj(zzcfl zzcfl, Map map) {
        this.zza = zzcfl;
        this.zzb = map;
    }

    public final void run() {
        this.zza.zzr(this.zzb);
    }
}
