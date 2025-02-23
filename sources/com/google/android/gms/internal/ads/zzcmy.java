package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcmy implements zzcxl {
    private final zzfge zza;

    public zzcmy(zzfge zzfge) {
        this.zza = zzfge;
    }

    public final void zzdj(Context context) {
        try {
            this.zza.zzg();
        } catch (zzffn e) {
            zzm.zzk("Cannot invoke onDestroy for the mediation adapter.", e);
        }
    }

    public final void zzdl(Context context) {
        try {
            this.zza.zzt();
        } catch (zzffn e) {
            zzm.zzk("Cannot invoke onPause for the mediation adapter.", e);
        }
    }

    public final void zzdm(Context context) {
        try {
            this.zza.zzu();
            if (context != null) {
                this.zza.zzs(context);
            }
        } catch (zzffn e) {
            zzm.zzk("Cannot invoke onResume for the mediation adapter.", e);
        }
    }
}
