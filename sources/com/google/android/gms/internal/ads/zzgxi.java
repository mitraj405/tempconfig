package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzgxi {
    static final zzgxi zza = new zzgxi(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private static volatile zzgxi zzd;
    private final Map zze;

    public zzgxi() {
        this.zze = new HashMap();
    }

    public static zzgxi zza() {
        int i = zzgzt.zza;
        return zza;
    }

    public static zzgxi zzb() {
        zzgxi zzgxi = zzd;
        if (zzgxi != null) {
            return zzgxi;
        }
        synchronized (zzgxi.class) {
            zzgxi zzgxi2 = zzd;
            if (zzgxi2 != null) {
                return zzgxi2;
            }
            int i = zzgzt.zza;
            zzgxi zzb2 = zzgxq.zzb(zzgxi.class);
            zzd = zzb2;
            return zzb2;
        }
    }

    public final zzgxw zzc(zzgzj zzgzj, int i) {
        return (zzgxw) this.zze.get(new zzgxh(zzgzj, i));
    }

    public zzgxi(boolean z) {
        this.zze = Collections.emptyMap();
    }
}
