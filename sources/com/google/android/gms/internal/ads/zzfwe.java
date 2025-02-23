package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
class zzfwe extends zzfvx implements SortedMap {
    SortedSet zzd;
    final /* synthetic */ zzfwk zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfwe(zzfwk zzfwk, SortedMap sortedMap) {
        super(zzfwk, sortedMap);
        this.zze = zzfwk;
    }

    public final Comparator comparator() {
        return zzf().comparator();
    }

    public final Object firstKey() {
        return zzf().firstKey();
    }

    public SortedMap headMap(Object obj) {
        return new zzfwe(this.zze, zzf().headMap(obj));
    }

    public final Object lastKey() {
        return zzf().lastKey();
    }

    public SortedMap subMap(Object obj, Object obj2) {
        return new zzfwe(this.zze, zzf().subMap(obj, obj2));
    }

    public SortedMap tailMap(Object obj) {
        return new zzfwe(this.zze, zzf().tailMap(obj));
    }

    public SortedMap zzf() {
        return (SortedMap) this.zza;
    }

    /* renamed from: zzg */
    public SortedSet zze() {
        return new zzfwf(this.zze, zzf());
    }

    /* renamed from: zzh */
    public SortedSet keySet() {
        SortedSet sortedSet = this.zzd;
        if (sortedSet != null) {
            return sortedSet;
        }
        SortedSet zzg = zze();
        this.zzd = zzg;
        return zzg;
    }
}
