package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfzt {
    public static int zza(Set set) {
        int i;
        int i2 = 0;
        for (Object next : set) {
            if (next != null) {
                i = next.hashCode();
            } else {
                i = 0;
            }
            i2 += i;
        }
        return i2;
    }

    public static zzfzs zzb(Set set, Set set2) {
        zzfuu.zzc(set, "set1");
        zzfuu.zzc(set2, "set2");
        return new zzfzn(set, set2);
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [java.util.Collection, java.util.Set] */
    public static Set zzc(Set set, zzfuv zzfuv) {
        if (set instanceof SortedSet) {
            SortedSet sortedSet = (SortedSet) set;
            if (sortedSet instanceof zzfzo) {
                zzfzo zzfzo = (zzfzo) sortedSet;
                return new zzfzp((SortedSet) zzfzo.zza, zzfuy.zza(zzfzo.zzb, zzfuv));
            }
            sortedSet.getClass();
            return new zzfzp(sortedSet, zzfuv);
        } else if (set instanceof zzfzo) {
            zzfzo zzfzo2 = (zzfzo) set;
            return new zzfzo(zzfzo2.zza, zzfuy.zza(zzfzo2.zzb, zzfuv));
        } else {
            set.getClass();
            return new zzfzo(set, zzfuv);
        }
    }

    public static boolean zzd(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() != set2.size() || !set.containsAll(set2)) {
                    return false;
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static boolean zze(Set set, Collection collection) {
        collection.getClass();
        if (collection instanceof zzfyz) {
            collection = ((zzfyz) collection).zza();
        }
        if (!(collection instanceof Set) || collection.size() <= set.size()) {
            return zzf(set, collection.iterator());
        }
        Iterator it = set.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static boolean zzf(Set set, Iterator it) {
        boolean z = false;
        while (it.hasNext()) {
            z |= set.remove(it.next());
        }
        return z;
    }
}
