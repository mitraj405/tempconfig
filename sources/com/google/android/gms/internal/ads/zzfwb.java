package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfwb extends zzfwe implements NavigableMap {
    final /* synthetic */ zzfwk zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfwb(zzfwk zzfwk, NavigableMap navigableMap) {
        super(zzfwk, navigableMap);
        this.zzc = zzfwk;
    }

    public final Map.Entry ceilingEntry(Object obj) {
        Map.Entry ceilingEntry = ((NavigableMap) ((SortedMap) this.zza)).ceilingEntry(obj);
        if (ceilingEntry == null) {
            return null;
        }
        return zza(ceilingEntry);
    }

    public final Object ceilingKey(Object obj) {
        return ((NavigableMap) ((SortedMap) this.zza)).ceilingKey(obj);
    }

    public final NavigableSet descendingKeySet() {
        return (NavigableSet) super.keySet();
    }

    public final NavigableMap descendingMap() {
        return new zzfwb(this.zzc, ((NavigableMap) ((SortedMap) this.zza)).descendingMap());
    }

    public final Map.Entry firstEntry() {
        Map.Entry firstEntry = ((NavigableMap) ((SortedMap) this.zza)).firstEntry();
        if (firstEntry == null) {
            return null;
        }
        return zza(firstEntry);
    }

    public final Map.Entry floorEntry(Object obj) {
        Map.Entry floorEntry = ((NavigableMap) ((SortedMap) this.zza)).floorEntry(obj);
        if (floorEntry == null) {
            return null;
        }
        return zza(floorEntry);
    }

    public final Object floorKey(Object obj) {
        return ((NavigableMap) ((SortedMap) this.zza)).floorKey(obj);
    }

    public final /* synthetic */ SortedMap headMap(Object obj) {
        return headMap(obj, false);
    }

    public final Map.Entry higherEntry(Object obj) {
        Map.Entry higherEntry = ((NavigableMap) ((SortedMap) this.zza)).higherEntry(obj);
        if (higherEntry == null) {
            return null;
        }
        return zza(higherEntry);
    }

    public final Object higherKey(Object obj) {
        return ((NavigableMap) ((SortedMap) this.zza)).higherKey(obj);
    }

    public final /* synthetic */ Set keySet() {
        return (NavigableSet) super.keySet();
    }

    public final Map.Entry lastEntry() {
        Map.Entry lastEntry = ((NavigableMap) ((SortedMap) this.zza)).lastEntry();
        if (lastEntry == null) {
            return null;
        }
        return zza(lastEntry);
    }

    public final Map.Entry lowerEntry(Object obj) {
        Map.Entry lowerEntry = ((NavigableMap) ((SortedMap) this.zza)).lowerEntry(obj);
        if (lowerEntry == null) {
            return null;
        }
        return zza(lowerEntry);
    }

    public final Object lowerKey(Object obj) {
        return ((NavigableMap) ((SortedMap) this.zza)).lowerKey(obj);
    }

    public final NavigableSet navigableKeySet() {
        return (NavigableSet) super.keySet();
    }

    public final Map.Entry pollFirstEntry() {
        return zzc(entrySet().iterator());
    }

    public final Map.Entry pollLastEntry() {
        return zzc(descendingMap().entrySet().iterator());
    }

    public final /* bridge */ /* synthetic */ SortedMap subMap(Object obj, Object obj2) {
        return subMap(obj, true, obj2, false);
    }

    public final /* synthetic */ SortedMap tailMap(Object obj) {
        return tailMap(obj, true);
    }

    public final Map.Entry zzc(Iterator it) {
        if (!it.hasNext()) {
            return null;
        }
        Map.Entry entry = (Map.Entry) it.next();
        Collection zza = this.zzc.zza();
        zza.addAll((Collection) entry.getValue());
        it.remove();
        return new zzfxn(entry.getKey(), this.zzc.zzb(zza));
    }

    /* renamed from: zzd */
    public final NavigableSet zzg() {
        return new zzfwc(this.zzc, (NavigableMap) ((SortedMap) this.zza));
    }

    public final /* synthetic */ SortedMap zzf() {
        return (NavigableMap) ((SortedMap) this.zza);
    }

    public final /* synthetic */ SortedSet zzh() {
        return (NavigableSet) super.keySet();
    }

    public final NavigableMap headMap(Object obj, boolean z) {
        return new zzfwb(this.zzc, ((NavigableMap) ((SortedMap) this.zza)).headMap(obj, z));
    }

    public final NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
        return new zzfwb(this.zzc, ((NavigableMap) ((SortedMap) this.zza)).subMap(obj, z, obj2, z2));
    }

    public final NavigableMap tailMap(Object obj, boolean z) {
        return new zzfwb(this.zzc, ((NavigableMap) ((SortedMap) this.zza)).tailMap(obj, z));
    }
}
