package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfvw implements Iterator {
    final Iterator zza;
    Collection zzb;
    final /* synthetic */ zzfvx zzc;

    public zzfvw(zzfvx zzfvx) {
        this.zzc = zzfvx;
        this.zza = zzfvx.zza.entrySet().iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.zza.next();
        this.zzb = (Collection) entry.getValue();
        return this.zzc.zza(entry);
    }

    public final void remove() {
        boolean z;
        if (this.zzb != null) {
            z = true;
        } else {
            z = false;
        }
        zzfuu.zzk(z, "no calls to next() since the last call to remove()");
        this.zza.remove();
        zzfwk zzfwk = this.zzc.zzb;
        zzfwk.zzb = zzfwk.zzb - this.zzb.size();
        this.zzb.clear();
        this.zzb = null;
    }
}
