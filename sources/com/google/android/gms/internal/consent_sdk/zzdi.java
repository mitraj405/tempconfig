package com.google.android.gms.internal.consent_sdk;

import java.util.Iterator;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.0.0 */
final class zzdi extends zzde {
    final transient Object zza;

    public zzdi(Object obj) {
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
        return new zzdf(this.zza);
    }

    public final int size() {
        return 1;
    }

    public final String toString() {
        return lf.j("[", this.zza.toString(), "]");
    }

    public final int zza(Object[] objArr, int i) {
        objArr[0] = this.zza;
        return 1;
    }

    public final zzdj zzd() {
        return new zzdf(this.zza);
    }
}
