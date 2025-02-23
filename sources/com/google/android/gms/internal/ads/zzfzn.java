package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfzn extends zzfzs {
    final /* synthetic */ Set zza;
    final /* synthetic */ Set zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfzn(Set set, Set set2) {
        super((zzfzr) null);
        this.zza = set;
        this.zzb = set2;
    }

    public final boolean contains(Object obj) {
        if (!this.zza.contains(obj) || !this.zzb.contains(obj)) {
            return false;
        }
        return true;
    }

    public final boolean containsAll(Collection collection) {
        if (!this.zza.containsAll(collection) || !this.zzb.containsAll(collection)) {
            return false;
        }
        return true;
    }

    public final boolean isEmpty() {
        return Collections.disjoint(this.zzb, this.zza);
    }

    public final /* synthetic */ Iterator iterator() {
        return new zzfzm(this);
    }

    public final int size() {
        int i = 0;
        for (Object contains : this.zza) {
            if (this.zzb.contains(contains)) {
                i++;
            }
        }
        return i;
    }

    public final zzfzx zza() {
        return new zzfzm(this);
    }
}
