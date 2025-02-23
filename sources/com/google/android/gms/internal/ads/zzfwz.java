package com.google.android.gms.internal.ads;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfwz extends AbstractCollection {
    final /* synthetic */ zzfxa zza;

    public zzfwz(zzfxa zzfxa) {
        this.zza = zzfxa;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final Iterator iterator() {
        zzfxa zzfxa = this.zza;
        Map zzl = zzfxa.zzl();
        if (zzl != null) {
            return zzl.values().iterator();
        }
        return new zzfwt(zzfxa);
    }

    public final int size() {
        return this.zza.size();
    }
}
