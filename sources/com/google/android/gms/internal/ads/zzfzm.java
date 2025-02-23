package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfzm extends zzfvs {
    final Iterator zza;
    final /* synthetic */ zzfzn zzb;

    public zzfzm(zzfzn zzfzn) {
        this.zzb = zzfzn;
        this.zza = zzfzn.zza.iterator();
    }

    public final Object zza() {
        while (this.zza.hasNext()) {
            Iterator it = this.zza;
            Set set = this.zzb.zzb;
            Object next = it.next();
            if (set.contains(next)) {
                return next;
            }
        }
        zzb();
        return null;
    }
}
