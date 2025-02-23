package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
abstract class zzii extends zzij {
    private boolean zza;

    public zzii(zzhj zzhj) {
        super(zzhj);
        this.zzu.zzaa();
    }

    public final void zzac() {
        if (!zzaf()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzad() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!zzo()) {
            this.zzu.zzz();
            this.zza = true;
        }
    }

    public final void zzae() {
        if (!this.zza) {
            zzaa();
            this.zzu.zzz();
            this.zza = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    public final boolean zzaf() {
        if (this.zza) {
            return true;
        }
        return false;
    }

    public abstract boolean zzo();

    public void zzaa() {
    }
}
