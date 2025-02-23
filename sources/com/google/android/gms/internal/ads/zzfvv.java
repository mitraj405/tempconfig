package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfvv extends zzfyk {
    final /* synthetic */ zzfvx zza;

    public zzfvv(zzfvx zzfvx) {
        this.zza = zzfvx;
    }

    public final boolean contains(Object obj) {
        return zzfwq.zza(this.zza.zza.entrySet(), obj);
    }

    public final Iterator iterator() {
        return new zzfvw(this.zza);
    }

    public final boolean remove(Object obj) {
        if (!contains(obj)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Objects.requireNonNull(entry);
        zzfvx zzfvx = this.zza;
        zzfwk.zzo(zzfvx.zzb, entry.getKey());
        return true;
    }

    public final Map zza() {
        return this.zza;
    }
}
