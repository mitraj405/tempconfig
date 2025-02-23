package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeiw {
    private zzein zza;

    public zzeiw() {
    }

    private zzeiw(zzein zzein) {
        this.zza = zzein;
    }

    public static zzeiw zzb(zzein zzein) {
        return new zzeiw(zzein);
    }

    public final zzein zza(Clock clock, zzeip zzeip, zzeey zzeey, zzfll zzfll) {
        zzein zzein = this.zza;
        if (zzein != null) {
            return zzein;
        }
        return new zzein(clock, zzeip, zzeey, zzfll);
    }
}
