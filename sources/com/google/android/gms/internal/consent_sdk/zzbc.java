package com.google.android.gms.internal.consent_sdk;

import android.app.Application;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.0.0 */
public final class zzbc implements zzdn {
    private final zzds zza;
    private final zzds zzb;
    private final zzds zzc;
    private final zzds zzd;
    private final zzds zze;
    private final zzds zzf;

    public zzbc(zzds zzds, zzds zzds2, zzds zzds3, zzds zzds4, zzds zzds5, zzds zzds6) {
        this.zza = zzds;
        this.zzb = zzds2;
        this.zzc = zzds3;
        this.zzd = zzds4;
        this.zze = zzds5;
        this.zzf = zzds6;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        return new zzbb((Application) this.zza.zza(), (zzab) this.zzb.zza(), (zzbw) this.zzc.zza(), (zzap) this.zzd.zza(), (zzbp) this.zze.zza(), this.zzf);
    }
}
