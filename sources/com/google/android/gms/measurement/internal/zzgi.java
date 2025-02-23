package com.google.android.gms.measurement.internal;

import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
final class zzgi {
    private final zzim zza;

    public zzgi(zzim zzim) {
        this.zza = zzim;
    }

    public static zzgi zza(String str) {
        zzim zzim;
        if (TextUtils.isEmpty(str) || str.length() > 1) {
            zzim = zzim.UNINITIALIZED;
        } else {
            zzim = zzin.zza(str.charAt(0));
        }
        return new zzgi(zzim);
    }

    public final String zzb() {
        return String.valueOf(zzin.zza(this.zza));
    }

    public final zzim zza() {
        return this.zza;
    }
}
