package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
abstract class zzfwk extends zzfwn implements Serializable {
    /* access modifiers changed from: private */
    public final transient Map zza;
    /* access modifiers changed from: private */
    public transient int zzb;

    public zzfwk(Map map) {
        zzfuu.zze(map.isEmpty());
        this.zza = map;
    }

    public static /* bridge */ /* synthetic */ void zzo(zzfwk zzfwk, Object obj) {
        Object obj2;
        try {
            obj2 = zzfwk.zza.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            obj2 = null;
        }
        Collection collection = (Collection) obj2;
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            zzfwk.zzb -= size;
        }
    }

    public abstract Collection zza();

    public Collection zzb(Collection collection) {
        throw null;
    }

    public Collection zzc(Object obj, Collection collection) {
        throw null;
    }

    public final int zze() {
        return this.zzb;
    }

    public final Collection zzf() {
        return new zzfwm(this);
    }

    /* access modifiers changed from: package-private */
    public final Iterator zzg() {
        return new zzfvu(this);
    }

    public final List zzh(Object obj, List list, zzfwh zzfwh) {
        if (list instanceof RandomAccess) {
            return new zzfwd(this, obj, list, zzfwh);
        }
        return new zzfwj(this, obj, list, zzfwh);
    }

    public Map zzj() {
        throw null;
    }

    public final Map zzk() {
        Map map = this.zza;
        if (map instanceof NavigableMap) {
            return new zzfwb(this, (NavigableMap) map);
        }
        if (map instanceof SortedMap) {
            return new zzfwe(this, (SortedMap) map);
        }
        return new zzfvx(this, map);
    }

    public Set zzl() {
        throw null;
    }

    public final Set zzm() {
        Map map = this.zza;
        if (map instanceof NavigableMap) {
            return new zzfwc(this, (NavigableMap) map);
        }
        if (map instanceof SortedMap) {
            return new zzfwf(this, (SortedMap) map);
        }
        return new zzfwa(this, map);
    }

    public final void zzp() {
        for (Collection clear : this.zza.values()) {
            clear.clear();
        }
        this.zza.clear();
        this.zzb = 0;
    }

    public final boolean zzq(Object obj, Object obj2) {
        Collection collection = (Collection) this.zza.get(obj);
        if (collection == null) {
            Collection zza2 = zza();
            if (zza2.add(obj2)) {
                this.zzb++;
                this.zza.put(obj, zza2);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        } else if (!collection.add(obj2)) {
            return false;
        } else {
            this.zzb++;
            return true;
        }
    }
}
