package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
class zzfvx extends zzfyn {
    final transient Map zza;
    final /* synthetic */ zzfwk zzb;

    public zzfvx(zzfwk zzfwk, Map map) {
        this.zzb = zzfwk;
        this.zza = map;
    }

    public final void clear() {
        zzfwk zzfwk = this.zzb;
        if (this.zza == zzfwk.zza) {
            zzfwk.zzp();
        } else {
            zzfyb.zzb(new zzfvw(this));
        }
    }

    public final boolean containsKey(Object obj) {
        Map map = this.zza;
        map.getClass();
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj || this.zza.equals(obj)) {
            return true;
        }
        return false;
    }

    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        Collection collection = (Collection) zzfyo.zza(this.zza, obj);
        if (collection == null) {
            return null;
        }
        return this.zzb.zzc(obj, collection);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public Set keySet() {
        return this.zzb.zzt();
    }

    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        Collection collection = (Collection) this.zza.remove(obj);
        if (collection == null) {
            return null;
        }
        Collection zza2 = this.zzb.zza();
        zza2.addAll(collection);
        zzfwk zzfwk = this.zzb;
        zzfwk.zzb = zzfwk.zzb - collection.size();
        collection.clear();
        return zza2;
    }

    public final int size() {
        return this.zza.size();
    }

    public final String toString() {
        return this.zza.toString();
    }

    public final Map.Entry zza(Map.Entry entry) {
        Object key = entry.getKey();
        return new zzfxn(key, this.zzb.zzc(key, (Collection) entry.getValue()));
    }

    public final Set zzb() {
        return new zzfvv(this);
    }
}
