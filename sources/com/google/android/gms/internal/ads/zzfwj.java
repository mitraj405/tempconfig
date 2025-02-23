package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
class zzfwj extends zzfwh implements List {
    final /* synthetic */ zzfwk zzf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfwj(zzfwk zzfwk, Object obj, List list, zzfwh zzfwh) {
        super(zzfwk, obj, list, zzfwh);
        this.zzf = zzfwk;
    }

    public final void add(int i, Object obj) {
        zzb();
        boolean isEmpty = this.zzb.isEmpty();
        ((List) this.zzb).add(i, obj);
        zzfwk zzfwk = this.zzf;
        zzfwk.zzb = zzfwk.zzb + 1;
        if (isEmpty) {
            zza();
        }
    }

    public final boolean addAll(int i, Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = ((List) this.zzb).addAll(i, collection);
        if (!addAll) {
            return addAll;
        }
        int size2 = this.zzb.size();
        zzfwk zzfwk = this.zzf;
        zzfwk.zzb = zzfwk.zzb + (size2 - size);
        if (size != 0) {
            return addAll;
        }
        zza();
        return true;
    }

    public final Object get(int i) {
        zzb();
        return ((List) this.zzb).get(i);
    }

    public final int indexOf(Object obj) {
        zzb();
        return ((List) this.zzb).indexOf(obj);
    }

    public final int lastIndexOf(Object obj) {
        zzb();
        return ((List) this.zzb).lastIndexOf(obj);
    }

    public final ListIterator listIterator() {
        zzb();
        return new zzfwi(this);
    }

    public final Object remove(int i) {
        zzb();
        Object remove = ((List) this.zzb).remove(i);
        zzfwk zzfwk = this.zzf;
        zzfwk.zzb = zzfwk.zzb - 1;
        zzc();
        return remove;
    }

    public final Object set(int i, Object obj) {
        zzb();
        return ((List) this.zzb).set(i, obj);
    }

    public final List subList(int i, int i2) {
        zzb();
        List subList = ((List) this.zzb).subList(i, i2);
        zzfwh zzfwh = this.zzc;
        if (zzfwh == null) {
            zzfwh = this;
        }
        return this.zzf.zzh(this.zza, subList, zzfwh);
    }

    public final ListIterator listIterator(int i) {
        zzb();
        return new zzfwi(this, i);
    }
}
