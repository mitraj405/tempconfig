package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public abstract class zzfxu implements Map, Serializable {
    private transient zzfxw zza;
    private transient zzfxw zzb;
    private transient zzfxm zzc;

    public static zzfxu zzc(Map map) {
        int i;
        Set entrySet = map.entrySet();
        if (entrySet instanceof Collection) {
            i = entrySet.size();
        } else {
            i = 4;
        }
        zzfxt zzfxt = new zzfxt(i);
        zzfxt.zzb(entrySet);
        return zzfxt.zzc();
    }

    public static zzfxu zzd() {
        return zzfzi.zza;
    }

    public static zzfxu zze(Object obj, Object obj2) {
        zzfwo.zzb("dialog_not_shown_reason", obj2);
        return zzfzi.zzj(1, new Object[]{"dialog_not_shown_reason", obj2}, (zzfxt) null);
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public final boolean containsKey(Object obj) {
        if (get(obj) != null) {
            return true;
        }
        return false;
    }

    public final boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    public final boolean equals(Object obj) {
        return zzfyo.zzb(this, obj);
    }

    public abstract Object get(Object obj);

    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        if (obj3 != null) {
            return obj3;
        }
        return obj2;
    }

    public final int hashCode() {
        return zzfzt.zza(entrySet());
    }

    public final boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        zzfwo.zza(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(((long) size) * 8, 1073741824));
        sb.append('{');
        boolean z = true;
        for (Map.Entry entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z = false;
        }
        sb.append('}');
        return sb.toString();
    }

    public abstract zzfxm zza();

    /* renamed from: zzb */
    public final zzfxm values() {
        zzfxm zzfxm = this.zzc;
        if (zzfxm != null) {
            return zzfxm;
        }
        zzfxm zza2 = zza();
        this.zzc = zza2;
        return zza2;
    }

    public abstract zzfxw zzf();

    public abstract zzfxw zzg();

    /* renamed from: zzh */
    public final zzfxw entrySet() {
        zzfxw zzfxw = this.zza;
        if (zzfxw != null) {
            return zzfxw;
        }
        zzfxw zzf = zzf();
        this.zza = zzf;
        return zzf;
    }

    /* renamed from: zzi */
    public final zzfxw keySet() {
        zzfxw zzfxw = this.zzb;
        if (zzfxw != null) {
            return zzfxw;
        }
        zzfxw zzg = zzg();
        this.zzb = zzg;
        return zzg;
    }
}
