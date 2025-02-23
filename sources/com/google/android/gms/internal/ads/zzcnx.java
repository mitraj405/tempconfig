package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzcnx implements zzbix {
    final /* synthetic */ zzcoa zza;

    public zzcnx(zzcoa zzcoa) {
        this.zza = zzcoa;
    }

    public final void zza(Object obj, Map map) {
        if (zzcoa.zzg(this.zza, map)) {
            this.zza.zzc.execute(new zzcnw(this));
        }
    }
}
