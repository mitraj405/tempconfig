package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
class zzfvy implements Iterator {
    final Iterator zza;
    Collection zzb = null;
    Iterator zzc = zzfxz.INSTANCE;
    final /* synthetic */ zzfwk zzd;

    public zzfvy(zzfwk zzfwk) {
        this.zzd = zzfwk;
        this.zza = zzfwk.zza.entrySet().iterator();
    }

    public final boolean hasNext() {
        if (this.zza.hasNext() || this.zzc.hasNext()) {
            return true;
        }
        return false;
    }

    public final Object next() {
        if (!this.zzc.hasNext()) {
            Map.Entry entry = (Map.Entry) this.zza.next();
            entry.getKey();
            Collection collection = (Collection) entry.getValue();
            this.zzb = collection;
            this.zzc = collection.iterator();
        }
        return this.zzc.next();
    }

    public final void remove() {
        this.zzc.remove();
        Collection collection = this.zzb;
        Objects.requireNonNull(collection);
        if (collection.isEmpty()) {
            this.zza.remove();
        }
        zzfwk zzfwk = this.zzd;
        zzfwk.zzb = zzfwk.zzb - 1;
    }
}
