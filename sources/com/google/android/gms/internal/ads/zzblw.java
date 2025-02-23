package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Predicate;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzblw implements Predicate {
    public final /* synthetic */ zzbix zza;

    public /* synthetic */ zzblw(zzbix zzbix) {
        this.zza = zzbix;
    }

    public final boolean apply(Object obj) {
        zzbix zzbix = (zzbix) obj;
        if (!(zzbix instanceof zzbmc)) {
            return false;
        }
        if (((zzbmc) zzbix).zzb.equals(this.zza)) {
            return true;
        }
        return false;
    }
}
