package com.google.android.gms.internal.ads;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
class zzfwh extends AbstractCollection {
    final Object zza;
    Collection zzb;
    final zzfwh zzc;
    final Collection zzd;
    final /* synthetic */ zzfwk zze;

    public zzfwh(zzfwk zzfwk, Object obj, Collection collection, zzfwh zzfwh) {
        Collection collection2;
        this.zze = zzfwk;
        this.zza = obj;
        this.zzb = collection;
        this.zzc = zzfwh;
        if (zzfwh == null) {
            collection2 = null;
        } else {
            collection2 = zzfwh.zzb;
        }
        this.zzd = collection2;
    }

    public final boolean add(Object obj) {
        zzb();
        boolean isEmpty = this.zzb.isEmpty();
        boolean add = this.zzb.add(obj);
        if (add) {
            zzfwk zzfwk = this.zze;
            zzfwk.zzb = zzfwk.zzb + 1;
            if (isEmpty) {
                zza();
                return true;
            }
        }
        return add;
    }

    public final boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = this.zzb.addAll(collection);
        if (!addAll) {
            return addAll;
        }
        int size2 = this.zzb.size();
        zzfwk zzfwk = this.zze;
        zzfwk.zzb = zzfwk.zzb + (size2 - size);
        if (size != 0) {
            return addAll;
        }
        zza();
        return true;
    }

    public final void clear() {
        int size = size();
        if (size != 0) {
            this.zzb.clear();
            zzfwk zzfwk = this.zze;
            zzfwk.zzb = zzfwk.zzb - size;
            zzc();
        }
    }

    public final boolean contains(Object obj) {
        zzb();
        return this.zzb.contains(obj);
    }

    public final boolean containsAll(Collection collection) {
        zzb();
        return this.zzb.containsAll(collection);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        zzb();
        return this.zzb.equals(obj);
    }

    public final int hashCode() {
        zzb();
        return this.zzb.hashCode();
    }

    public final Iterator iterator() {
        zzb();
        return new zzfwg(this);
    }

    public final boolean remove(Object obj) {
        zzb();
        boolean remove = this.zzb.remove(obj);
        if (remove) {
            zzfwk zzfwk = this.zze;
            zzfwk.zzb = zzfwk.zzb - 1;
            zzc();
        }
        return remove;
    }

    public final boolean removeAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean removeAll = this.zzb.removeAll(collection);
        if (removeAll) {
            int size2 = this.zzb.size();
            zzfwk zzfwk = this.zze;
            zzfwk.zzb = zzfwk.zzb + (size2 - size);
            zzc();
        }
        return removeAll;
    }

    public final boolean retainAll(Collection collection) {
        collection.getClass();
        int size = size();
        boolean retainAll = this.zzb.retainAll(collection);
        if (retainAll) {
            int size2 = this.zzb.size();
            zzfwk zzfwk = this.zze;
            zzfwk.zzb = zzfwk.zzb + (size2 - size);
            zzc();
        }
        return retainAll;
    }

    public final int size() {
        zzb();
        return this.zzb.size();
    }

    public final String toString() {
        zzb();
        return this.zzb.toString();
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        zzfwh zzfwh = this.zzc;
        if (zzfwh != null) {
            zzfwh.zza();
            return;
        }
        zzfwk zzfwk = this.zze;
        zzfwk.zza.put(this.zza, this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final void zzb() {
        zzfwh zzfwh = this.zzc;
        if (zzfwh != null) {
            zzfwh.zzb();
            zzfwh zzfwh2 = this.zzc;
            if (zzfwh2.zzb != this.zzd) {
                throw new ConcurrentModificationException();
            }
        } else if (this.zzb.isEmpty()) {
            zzfwk zzfwk = this.zze;
            Collection collection = (Collection) zzfwk.zza.get(this.zza);
            if (collection != null) {
                this.zzb = collection;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc() {
        zzfwh zzfwh = this.zzc;
        if (zzfwh != null) {
            zzfwh.zzc();
        } else if (this.zzb.isEmpty()) {
            zzfwk zzfwk = this.zze;
            zzfwk.zza.remove(this.zza);
        }
    }
}
