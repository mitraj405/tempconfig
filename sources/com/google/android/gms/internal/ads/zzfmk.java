package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfmk extends zzfmn {
    @SuppressLint({"StaticFieldLeak"})
    private static final zzfmk zzb = new zzfmk();

    private zzfmk() {
    }

    public static zzfmk zza() {
        return zzb;
    }

    public final void zzb(boolean z) {
        for (zzflu zzg : zzfml.zza().zzc()) {
            zzg.zzg().zzk(z);
        }
    }

    public final boolean zzc() {
        for (zzflu zzf : zzfml.zza().zzb()) {
            View zzf2 = zzf.zzf();
            if (zzf2 != null && zzf2.hasWindowFocus()) {
                return true;
            }
        }
        return false;
    }
}
