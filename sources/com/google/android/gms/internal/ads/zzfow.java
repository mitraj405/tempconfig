package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.OnFailureListener;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzfow implements OnFailureListener {
    public final /* synthetic */ zzfpa zza;

    public /* synthetic */ zzfow(zzfpa zzfpa) {
        this.zza = zzfpa;
    }

    public final void onFailure(Exception exc) {
        this.zza.zzf(exc);
    }
}
