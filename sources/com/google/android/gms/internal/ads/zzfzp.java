package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfzp extends zzfzo implements SortedSet {
    public zzfzp(SortedSet sortedSet, zzfuv zzfuv) {
        super(sortedSet, zzfuv);
    }

    public final Comparator comparator() {
        return ((SortedSet) this.zza).comparator();
    }

    public final Object first() {
        Iterator it = this.zza.iterator();
        it.getClass();
        zzfuv zzfuv = this.zzb;
        zzfuv.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            if (zzfuv.zza(next)) {
                return next;
            }
        }
        throw new NoSuchElementException();
    }

    public final SortedSet headSet(Object obj) {
        return new zzfzp(((SortedSet) this.zza).headSet(obj), this.zzb);
    }

    public final Object last() {
        SortedSet sortedSet = (SortedSet) this.zza;
        while (true) {
            zzfuv zzfuv = this.zzb;
            Object last = sortedSet.last();
            if (zzfuv.zza(last)) {
                return last;
            }
            sortedSet = sortedSet.headSet(last);
        }
    }

    public final SortedSet subSet(Object obj, Object obj2) {
        return new zzfzp(((SortedSet) this.zza).subSet(obj, obj2), this.zzb);
    }

    public final SortedSet tailSet(Object obj) {
        return new zzfzp(((SortedSet) this.zza).tailSet(obj), this.zzb);
    }
}
