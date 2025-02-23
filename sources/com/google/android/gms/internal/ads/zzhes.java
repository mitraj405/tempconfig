package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzhes implements Iterator {
    int zza = 0;
    final /* synthetic */ zzhet zzb;

    public zzhes(zzhet zzhet) {
        this.zzb = zzhet;
    }

    public final boolean hasNext() {
        if (this.zza < this.zzb.zza.size() || this.zzb.zzb.hasNext()) {
            return true;
        }
        return false;
    }

    public final Object next() {
        if (this.zza < this.zzb.zza.size()) {
            zzhet zzhet = this.zzb;
            int i = this.zza;
            this.zza = i + 1;
            return zzhet.zza.get(i);
        }
        zzhet zzhet2 = this.zzb;
        zzhet2.zza.add(zzhet2.zzb.next());
        return next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
