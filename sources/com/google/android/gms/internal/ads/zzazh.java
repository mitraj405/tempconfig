package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzazh implements Comparator {
    public zzazh(zzazi zzazi) {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzayw zzayw = (zzayw) obj;
        zzayw zzayw2 = (zzayw) obj2;
        if (zzayw.zzd() < zzayw2.zzd()) {
            return -1;
        }
        if (zzayw.zzd() <= zzayw2.zzd()) {
            if (zzayw.zzb() < zzayw2.zzb()) {
                return -1;
            }
            if (zzayw.zzb() <= zzayw2.zzb()) {
                float zza = (zzayw.zza() - zzayw.zzd()) * (zzayw.zzc() - zzayw.zzb());
                float zza2 = (zzayw2.zza() - zzayw2.zzd()) * (zzayw2.zzc() - zzayw2.zzb());
                if (zza > zza2) {
                    return -1;
                }
                if (zza >= zza2) {
                    return 0;
                }
            }
        }
        return 1;
    }
}
