package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.ListIterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfwi extends zzfwg implements ListIterator {
    final /* synthetic */ zzfwj zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfwi(zzfwj zzfwj) {
        super(zzfwj);
        this.zzd = zzfwj;
    }

    public final void add(Object obj) {
        boolean isEmpty = this.zzd.isEmpty();
        zza();
        ((ListIterator) this.zza).add(obj);
        zzfwk zzfwk = this.zzd.zzf;
        zzfwk.zzb = zzfwk.zzb + 1;
        if (isEmpty) {
            this.zzd.zza();
        }
    }

    public final boolean hasPrevious() {
        zza();
        return ((ListIterator) this.zza).hasPrevious();
    }

    public final int nextIndex() {
        zza();
        return ((ListIterator) this.zza).nextIndex();
    }

    public final Object previous() {
        zza();
        return ((ListIterator) this.zza).previous();
    }

    public final int previousIndex() {
        zza();
        return ((ListIterator) this.zza).previousIndex();
    }

    public final void set(Object obj) {
        zza();
        ((ListIterator) this.zza).set(obj);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfwi(zzfwj zzfwj, int i) {
        super(zzfwj, ((List) zzfwj.zzb).listIterator(i));
        this.zzd = zzfwj;
    }
}
