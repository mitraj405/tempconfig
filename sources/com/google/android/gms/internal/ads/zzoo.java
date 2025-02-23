package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzoo {
    /* access modifiers changed from: private */
    public boolean zza;
    /* access modifiers changed from: private */
    public boolean zzb;
    /* access modifiers changed from: private */
    public boolean zzc;

    public final zzoo zza(boolean z) {
        this.zza = true;
        return this;
    }

    public final zzoo zzb(boolean z) {
        this.zzb = z;
        return this;
    }

    public final zzoo zzc(boolean z) {
        this.zzc = z;
        return this;
    }

    public final zzoq zzd() {
        if (this.zza || (!this.zzb && !this.zzc)) {
            return new zzoq(this, (zzop) null);
        }
        throw new IllegalStateException("Secondary offload attribute fields are true but primary isFormatSupported is false");
    }
}
