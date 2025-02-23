package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzgbn extends zzgbk {
    private zzgbn() {
        throw null;
    }

    public final int zza(zzgbo zzgbo) {
        int zzz;
        synchronized (zzgbo) {
            zzz = zzgbo.remaining - 1;
            zzgbo.remaining = zzz;
        }
        return zzz;
    }

    public final void zzb(zzgbo zzgbo, Set set, Set set2) {
        synchronized (zzgbo) {
            if (zzgbo.seenExceptions == null) {
                zzgbo.seenExceptions = set2;
            }
        }
    }

    public /* synthetic */ zzgbn(zzgbm zzgbm) {
        super((zzgbj) null);
    }
}
