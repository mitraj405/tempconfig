package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
abstract class zzfzv implements Iterator {
    final Iterator zzb;

    public zzfzv(Iterator it) {
        it.getClass();
        this.zzb = it;
    }

    public final boolean hasNext() {
        return this.zzb.hasNext();
    }

    public final Object next() {
        return zza(this.zzb.next());
    }

    public final void remove() {
        this.zzb.remove();
    }

    public abstract Object zza(Object obj);
}
