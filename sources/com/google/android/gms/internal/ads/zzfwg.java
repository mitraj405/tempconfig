package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
class zzfwg implements Iterator {
    final Iterator zza;
    final Collection zzb;
    final /* synthetic */ zzfwh zzc;

    public zzfwg(zzfwh zzfwh, Iterator it) {
        this.zzc = zzfwh;
        this.zzb = zzfwh.zzb;
        this.zza = it;
    }

    public final boolean hasNext() {
        zza();
        return this.zza.hasNext();
    }

    public final Object next() {
        zza();
        return this.zza.next();
    }

    public final void remove() {
        this.zza.remove();
        zzfwk zzfwk = this.zzc.zze;
        zzfwk.zzb = zzfwk.zzb - 1;
        this.zzc.zzc();
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zzc.zzb();
        if (this.zzc.zzb != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }

    public zzfwg(zzfwh zzfwh) {
        Iterator it;
        this.zzc = zzfwh;
        Collection collection = zzfwh.zzb;
        this.zzb = collection;
        if (collection instanceof List) {
            it = ((List) collection).listIterator();
        } else {
            it = collection.iterator();
        }
        this.zza = it;
    }
}
