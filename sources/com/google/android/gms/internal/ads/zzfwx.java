package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfwx extends AbstractSet {
    final /* synthetic */ zzfxa zza;

    public zzfwx(zzfxa zzfxa) {
        this.zza = zzfxa;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final boolean contains(Object obj) {
        return this.zza.containsKey(obj);
    }

    public final Iterator iterator() {
        zzfxa zzfxa = this.zza;
        Map zzl = zzfxa.zzl();
        if (zzl != null) {
            return zzl.keySet().iterator();
        }
        return new zzfwr(zzfxa);
    }

    public final boolean remove(Object obj) {
        Map zzl = this.zza.zzl();
        if (zzl != null) {
            return zzl.keySet().remove(obj);
        }
        if (this.zza.zzy(obj) == zzfxa.zzd) {
            return false;
        }
        return true;
    }

    public final int size() {
        return this.zza.size();
    }
}
