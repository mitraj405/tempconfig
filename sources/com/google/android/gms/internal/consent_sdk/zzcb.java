package com.google.android.gms.internal.consent_sdk;

import android.app.Application;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.0.0 */
public final class zzcb implements zzdn {
    private final zzds zza;
    private final zzds zzb;
    private final zzds zzc;
    private final zzds zzd;
    private final zzds zze;
    private final zzds zzf;

    public zzcb(zzds zzds, zzds zzds2, zzds zzds3, zzds zzds4, zzds zzds5, zzds zzds6, zzds zzds7, zzds zzds8) {
        this.zza = zzds;
        this.zzb = zzds2;
        this.zzc = zzds5;
        this.zzd = zzds6;
        this.zze = zzds7;
        this.zzf = zzds8;
    }

    /* renamed from: zzb */
    public final zzca zza() {
        return new zzca((Application) this.zza.zza(), (zzbw) this.zzb.zza(), zzas.zzb(), zzau.zzb(), (zze) this.zzc.zza(), ((zzao) this.zzd).zza(), (zzbb) this.zze.zza(), (zzap) this.zzf.zza());
    }
}
