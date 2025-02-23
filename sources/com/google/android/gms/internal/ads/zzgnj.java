package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgnj {
    private final Map zza;
    private final zzgnh zzb;
    private final Class zzc;
    private final zzgln zzd;

    public /* synthetic */ zzgnj(Map map, List list, zzgnh zzgnh, zzgln zzgln, Class cls, zzgni zzgni) {
        this.zza = map;
        this.zzb = zzgnh;
        this.zzc = cls;
        this.zzd = zzgln;
    }

    public static zzgnf zzb(Class cls) {
        return new zzgnf(cls, (zzgne) null);
    }

    public final zzgln zza() {
        return this.zzd;
    }

    public final zzgnh zzc() {
        return this.zzb;
    }

    public final Class zzd() {
        return this.zzc;
    }

    public final Collection zze() {
        return this.zza.values();
    }

    public final List zzf(byte[] bArr) {
        List list = (List) this.zza.get(zzgvr.zzb(bArr));
        if (list != null) {
            return list;
        }
        return Collections.emptyList();
    }

    public final boolean zzg() {
        if (!this.zzd.zza().isEmpty()) {
            return true;
        }
        return false;
    }
}
