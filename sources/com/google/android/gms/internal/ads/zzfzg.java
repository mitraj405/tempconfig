package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfzg extends zzfxw {
    private final transient zzfxu zza;
    private final transient zzfxr zzb;

    public zzfzg(zzfxu zzfxu, zzfxr zzfxr) {
        this.zza = zzfxu;
        this.zzb = zzfxr;
    }

    public final boolean contains(Object obj) {
        if (this.zza.get(obj) != null) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    public final int size() {
        return this.zza.size();
    }

    public final int zza(Object[] objArr, int i) {
        return this.zzb.zza(objArr, i);
    }

    public final zzfxr zzd() {
        return this.zzb;
    }

    public final zzfzx zze() {
        return this.zzb.listIterator(0);
    }

    public final boolean zzf() {
        return true;
    }
}
