package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzayy implements Comparator {
    public zzayy(zzaza zzaza) {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzaze zzaze = (zzaze) obj;
        zzaze zzaze2 = (zzaze) obj2;
        int i = zzaze.zzc - zzaze2.zzc;
        if (i != 0) {
            return i;
        }
        return Long.compare(zzaze.zza, zzaze2.zza);
    }
}
