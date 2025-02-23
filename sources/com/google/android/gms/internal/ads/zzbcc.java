package com.google.android.gms.internal.ads;

import android.text.TextUtils;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbcc {
    public static final void zza(zzbcb zzbcb, zzbbz zzbbz) {
        if (zzbbz.zza() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        } else if (!TextUtils.isEmpty(zzbbz.zzb())) {
            zzbcb.zzd(zzbbz.zza(), zzbbz.zzb(), zzbbz.zzc(), zzbbz.zzd());
        } else {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
    }
}
