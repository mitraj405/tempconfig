package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfhi {
    private final HashMap zza = new HashMap();

    public final zzfhh zza(zzfgy zzfgy, Context context, zzfgq zzfgq, zzfho zzfho) {
        zzfhh zzfhh = (zzfhh) this.zza.get(zzfgy);
        if (zzfhh != null) {
            return zzfhh;
        }
        zzfgv zzfgv = new zzfgv(zzfhb.zza(zzfgy, context));
        zzfhh zzfhh2 = new zzfhh(zzfgv, new zzfhq(zzfgv, zzfgq, zzfho));
        this.zza.put(zzfgy, zzfhh2);
        return zzfhh2;
    }
}
