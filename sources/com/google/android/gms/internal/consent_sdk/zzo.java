package com.google.android.gms.internal.consent_sdk;

import android.app.Application;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.0.0 */
public final class zzo implements zzdn {
    private final zzds zza;
    private final zzds zzb;

    public zzo(zzds zzds, zzds zzds2) {
        this.zza = zzds;
        this.zzb = zzds2;
    }

    /* renamed from: zzb */
    public final zzl zza() {
        return new zzl((Application) this.zza.zza(), (zzap) this.zzb.zza());
    }
}
