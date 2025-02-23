package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzafa extends zzacw {
    private final long zza;

    public zzafa(zzacl zzacl, long j) {
        super(zzacl);
        boolean z;
        if (zzacl.zzf() >= j) {
            z = true;
        } else {
            z = false;
        }
        zzdi.zzd(z);
        this.zza = j;
    }

    public final long zzd() {
        return super.zzd() - this.zza;
    }

    public final long zze() {
        return super.zze() - this.zza;
    }

    public final long zzf() {
        return super.zzf() - this.zza;
    }
}
