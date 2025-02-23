package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzaun;
import com.google.android.gms.internal.ads.zzauo;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzp implements Callable {
    final /* synthetic */ zzt zza;

    public zzp(zzt zzt) {
        this.zza = zzt;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzt zzt = this.zza;
        return new zzauo(zzaun.zzt(zzt.zza.afmaVersion, zzt.zzd, false));
    }
}
