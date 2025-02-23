package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzgyr implements Map.Entry {
    private final Map.Entry zza;

    public /* synthetic */ zzgyr(Map.Entry entry, zzgyq zzgyq) {
        this.zza = entry;
    }

    public final Object getKey() {
        return this.zza.getKey();
    }

    public final Object getValue() {
        if (((zzgyt) this.zza.getValue()) == null) {
            return null;
        }
        throw null;
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzgzj) {
            return ((zzgyt) this.zza.getValue()).zzc((zzgzj) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    public final zzgyt zza() {
        return (zzgyt) this.zza.getValue();
    }
}
