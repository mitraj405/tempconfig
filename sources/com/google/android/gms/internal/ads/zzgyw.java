package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzgyw {
    public static final List zza(Object obj, long j) {
        int i;
        zzgyk zzgyk = (zzgyk) zzhaz.zzh(obj, j);
        if (zzgyk.zzc()) {
            return zzgyk;
        }
        int size = zzgyk.size();
        if (size == 0) {
            i = 10;
        } else {
            i = size + size;
        }
        zzgyk zzf = zzgyk.zzf(i);
        zzhaz.zzv(obj, j, zzf);
        return zzf;
    }
}
