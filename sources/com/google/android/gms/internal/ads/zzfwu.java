package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfwu extends AbstractSet {
    final /* synthetic */ zzfxa zza;

    public zzfwu(zzfxa zzfxa) {
        this.zza = zzfxa;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final boolean contains(Object obj) {
        Map zzl = this.zza.zzl();
        if (zzl != null) {
            return zzl.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            int zzd = this.zza.zzw(entry.getKey());
            if (zzd == -1 || !zzfur.zza(zzfxa.zzj(this.zza, zzd), entry.getValue())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final Iterator iterator() {
        zzfxa zzfxa = this.zza;
        Map zzl = zzfxa.zzl();
        if (zzl != null) {
            return zzl.entrySet().iterator();
        }
        return new zzfws(zzfxa);
    }

    public final boolean remove(Object obj) {
        Map zzl = this.zza.zzl();
        if (zzl != null) {
            return zzl.entrySet().remove(obj);
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        zzfxa zzfxa = this.zza;
        if (zzfxa.zzr()) {
            return false;
        }
        int zzc = zzfxa.zzv();
        Object key = entry.getKey();
        Object value = entry.getValue();
        zzfxa zzfxa2 = this.zza;
        int zzb = zzfxb.zzb(key, value, zzc, zzfxa.zzi(zzfxa2), zzfxa2.zzA(), zzfxa2.zzB(), zzfxa2.zzC());
        if (zzb == -1) {
            return false;
        }
        this.zza.zzq(zzb, zzc);
        zzfxa zzfxa3 = this.zza;
        zzfxa3.zzg = zzfxa3.zzg - 1;
        this.zza.zzo();
        return true;
    }

    public final int size() {
        return this.zza.size();
    }
}
