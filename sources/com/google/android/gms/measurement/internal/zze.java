package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
abstract class zze extends zzf {
    private boolean zza;

    public zze(zzhj zzhj) {
        super(zzhj);
        this.zzu.zzaa();
    }

    public final void zzu() {
        if (!zzy()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzv() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!zzz()) {
            this.zzu.zzz();
            this.zza = true;
        }
    }

    public final void zzw() {
        if (!this.zza) {
            zzx();
            this.zzu.zzz();
            this.zza = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    public final boolean zzy() {
        if (this.zza) {
            return true;
        }
        return false;
    }

    public abstract boolean zzz();

    public void zzx() {
    }
}
