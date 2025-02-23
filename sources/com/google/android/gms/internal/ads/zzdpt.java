package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdpt implements zzcxl {
    private final zzcej zza;

    public zzdpt(zzcej zzcej) {
        this.zza = zzcej;
    }

    public final void zzdj(Context context) {
        zzcej zzcej = this.zza;
        if (zzcej != null) {
            zzcej.destroy();
        }
    }

    public final void zzdl(Context context) {
        zzcej zzcej = this.zza;
        if (zzcej != null) {
            zzcej.onPause();
        }
    }

    public final void zzdm(Context context) {
        zzcej zzcej = this.zza;
        if (zzcej != null) {
            zzcej.onResume();
        }
    }
}
