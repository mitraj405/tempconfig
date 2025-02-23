package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzgys implements Iterator {
    private final Iterator zza;

    public zzgys(Iterator it) {
        this.zza = it;
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.zza.next();
        if (entry.getValue() instanceof zzgyt) {
            return new zzgyr(entry, (zzgyq) null);
        }
        return entry;
    }

    public final void remove() {
        this.zza.remove();
    }
}
