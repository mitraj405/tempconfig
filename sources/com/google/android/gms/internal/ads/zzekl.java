package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzg;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzekl implements zzg {
    final AtomicBoolean zza = new AtomicBoolean(false);
    private final zzcwo zzb;
    private final zzcxi zzc;
    private final zzdes zzd;
    private final zzdek zze;
    private final zzcof zzf;

    public zzekl(zzcwo zzcwo, zzcxi zzcxi, zzdes zzdes, zzdek zzdek, zzcof zzcof) {
        this.zzb = zzcwo;
        this.zzc = zzcxi;
        this.zzd = zzdes;
        this.zze = zzdek;
        this.zzf = zzcof;
    }

    public final synchronized void zza(View view) {
        if (this.zza.compareAndSet(false, true)) {
            this.zzf.zzr();
            this.zze.zza(view);
        }
    }

    public final void zzb() {
        if (this.zza.get()) {
            this.zzb.onAdClicked();
        }
    }

    public final void zzc() {
        if (this.zza.get()) {
            this.zzc.zza();
            this.zzd.zza();
        }
    }
}
