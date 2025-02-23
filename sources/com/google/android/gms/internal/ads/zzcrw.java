package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcrw implements zzcrx {
    private final Map zza;

    public zzcrw(Map map) {
        this.zza = map;
    }

    public final zzeet zza(int i, String str) {
        return (zzeet) this.zza.get(str);
    }
}
