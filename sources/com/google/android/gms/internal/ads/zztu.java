package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zztu {
    private final Map zza = new HashMap();
    private final Map zzb = new HashMap();
    private zzfr zzc;

    public zztu(zzacp zzacp, zzajy zzajy) {
    }

    public final void zza(zzfr zzfr) {
        if (zzfr != this.zzc) {
            this.zzc = zzfr;
            this.zza.clear();
            this.zzb.clear();
        }
    }
}
