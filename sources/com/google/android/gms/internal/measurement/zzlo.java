package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.0.2 */
final class zzlo implements Iterator {
    private int zza;
    private Iterator zzb;
    private final /* synthetic */ zzlm zzc;

    private final Iterator zza() {
        if (this.zzb == null) {
            this.zzb = this.zzc.zze.entrySet().iterator();
        }
        return this.zzb;
    }

    public final boolean hasNext() {
        int i = this.zza;
        if ((i <= 0 || i > this.zzc.zza.size()) && !zza().hasNext()) {
            return false;
        }
        return true;
    }

    public final /* synthetic */ Object next() {
        if (zza().hasNext()) {
            return (Map.Entry) zza().next();
        }
        List zza2 = this.zzc.zza;
        int i = this.zza - 1;
        this.zza = i;
        return (Map.Entry) zza2.get(i);
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private zzlo(zzlm zzlm) {
        this.zzc = zzlm;
        this.zza = zzlm.zza.size();
    }
}
