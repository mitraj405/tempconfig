package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzfve implements Iterable {
    final /* synthetic */ CharSequence zza;
    final /* synthetic */ zzfvh zzb;

    public zzfve(zzfvh zzfvh, CharSequence charSequence) {
        this.zza = charSequence;
        this.zzb = zzfvh;
    }

    public final Iterator iterator() {
        return this.zzb.zzf(this.zza);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        zzfum.zzb(sb, this, ", ");
        sb.append(']');
        return sb.toString();
    }
}
