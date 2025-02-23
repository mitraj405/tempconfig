package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcsp implements zzp {
    private final zzcxx zza;
    private final AtomicBoolean zzb = new AtomicBoolean(false);
    private final AtomicBoolean zzc = new AtomicBoolean(false);

    public zzcsp(zzcxx zzcxx) {
        this.zza = zzcxx;
    }

    private final void zzh() {
        if (!this.zzc.get()) {
            this.zzc.set(true);
            this.zza.zza();
        }
    }

    public final void zzdq() {
        zzh();
    }

    public final void zzdr() {
        this.zza.zzc();
    }

    public final void zzdu(int i) {
        this.zzb.set(true);
        zzh();
    }

    public final boolean zzg() {
        return this.zzb.get();
    }

    public final void zzdH() {
    }

    public final void zzdk() {
    }

    public final void zzdt() {
    }
}
