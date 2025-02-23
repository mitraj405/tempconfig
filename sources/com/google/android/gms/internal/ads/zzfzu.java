package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfzu extends zzfxw {
    final transient Object zza;

    public zzfzu(Object obj) {
        obj.getClass();
        this.zza = obj;
    }

    public final boolean contains(Object obj) {
        return this.zza.equals(obj);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final /* synthetic */ Iterator iterator() {
        return new zzfya(this.zza);
    }

    public final int size() {
        return 1;
    }

    public final String toString() {
        return lf.j("[", this.zza.toString(), "]");
    }

    public final int zza(Object[] objArr, int i) {
        objArr[i] = this.zza;
        return i + 1;
    }

    public final zzfxr zzd() {
        return zzfxr.zzn(this.zza);
    }

    public final zzfzx zze() {
        return new zzfya(this.zza);
    }

    public final boolean zzf() {
        return false;
    }
}
