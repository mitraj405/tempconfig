package com.google.android.gms.internal.ads;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfwm extends AbstractCollection {
    final /* synthetic */ zzfwn zza;

    public zzfwm(zzfwn zzfwn) {
        this.zza = zzfwn;
    }

    public final void clear() {
        this.zza.zzp();
    }

    public final boolean contains(Object obj) {
        for (Collection contains : this.zza.zzs().values()) {
            if (contains.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public final Iterator iterator() {
        return this.zza.zzg();
    }

    public final int size() {
        return this.zza.zze();
    }
}
