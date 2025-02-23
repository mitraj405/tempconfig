package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
abstract class zzmx extends zzmy {
    private boolean zza;

    public zzmx(zznc zznc) {
        super(zznc);
        this.zzf.zzu();
    }

    public final void zzal() {
        if (!zzan()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzam() {
        if (!this.zza) {
            zzc();
            this.zzf.zzt();
            this.zza = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    public final boolean zzan() {
        if (this.zza) {
            return true;
        }
        return false;
    }

    public abstract boolean zzc();
}
