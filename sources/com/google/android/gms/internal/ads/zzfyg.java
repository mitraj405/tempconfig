package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfyg extends AbstractSequentialList implements Serializable {
    final List zza;
    final zzful zzb;

    public zzfyg(List list, zzful zzful) {
        list.getClass();
        this.zza = list;
        this.zzb = zzful;
    }

    public final boolean isEmpty() {
        return this.zza.isEmpty();
    }

    public final ListIterator listIterator(int i) {
        return new zzfyf(this, this.zza.listIterator(i));
    }

    public final void removeRange(int i, int i2) {
        this.zza.subList(i, i2).clear();
    }

    public final int size() {
        return this.zza.size();
    }
}
