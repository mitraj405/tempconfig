package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
class zzfwa extends zzfyl {
    final /* synthetic */ zzfwk zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfwa(zzfwk zzfwk, Map map) {
        super(map);
        this.zza = zzfwk;
    }

    public final void clear() {
        zzfyb.zzb(iterator());
    }

    public final boolean containsAll(Collection collection) {
        return this.zzd.keySet().containsAll(collection);
    }

    public final boolean equals(Object obj) {
        if (this == obj || this.zzd.keySet().equals(obj)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.zzd.keySet().hashCode();
    }

    public final Iterator iterator() {
        return new zzfvz(this, this.zzd.entrySet().iterator());
    }

    public final boolean remove(Object obj) {
        Collection collection = (Collection) this.zzd.remove(obj);
        if (collection == null) {
            return false;
        }
        int size = collection.size();
        collection.clear();
        zzfwk zzfwk = this.zza;
        zzfwk.zzb = zzfwk.zzb - size;
        if (size > 0) {
            return true;
        }
        return false;
    }
}
