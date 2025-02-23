package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzge extends zzfxh {
    private final Map zza;

    public zzge(Map map) {
        this.zza = map;
    }

    public final boolean containsKey(Object obj) {
        if (obj == null || !super.containsKey(obj)) {
            return false;
        }
        return true;
    }

    public final boolean containsValue(Object obj) {
        return super.zzd(obj);
    }

    public final Set entrySet() {
        return zzfzt.zzc(this.zza.entrySet(), new zzgc());
    }

    public final boolean equals(Object obj) {
        if (obj == null || !super.zze(obj)) {
            return false;
        }
        return true;
    }

    public final /* synthetic */ Object get(Object obj) {
        if (obj == null) {
            return null;
        }
        return (List) this.zza.get(obj);
    }

    public final int hashCode() {
        return super.zzc();
    }

    public final boolean isEmpty() {
        if (this.zza.isEmpty()) {
            return true;
        }
        if (super.size() != 1) {
            return false;
        }
        if (super.containsKey((Object) null)) {
            return true;
        }
        return false;
    }

    public final Set keySet() {
        return zzfzt.zzc(this.zza.keySet(), new zzgd());
    }

    public final int size() {
        return super.size() - (super.containsKey((Object) null) ? 1 : 0);
    }

    public final /* synthetic */ Object zza() {
        return this.zza;
    }

    public final Map zzb() {
        return this.zza;
    }
}
