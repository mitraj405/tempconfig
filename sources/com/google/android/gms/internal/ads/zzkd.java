package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzkd {
    /* access modifiers changed from: private */
    public long zza;
    /* access modifiers changed from: private */
    public float zzb;
    /* access modifiers changed from: private */
    public long zzc;

    public zzkd() {
        this.zza = -9223372036854775807L;
        this.zzb = -3.4028235E38f;
        this.zzc = -9223372036854775807L;
    }

    public final zzkd zzd(long j) {
        boolean z = true;
        if (j < 0) {
            if (j == -9223372036854775807L) {
                j = -9223372036854775807L;
            } else {
                z = false;
            }
        }
        zzdi.zzd(z);
        this.zzc = j;
        return this;
    }

    public final zzkd zze(long j) {
        this.zza = j;
        return this;
    }

    public final zzkd zzf(float f) {
        boolean z = true;
        if (f <= 0.0f && f != -3.4028235E38f) {
            z = false;
        }
        zzdi.zzd(z);
        this.zzb = f;
        return this;
    }

    public final zzkf zzg() {
        return new zzkf(this, (zzke) null);
    }

    public /* synthetic */ zzkd(zzkf zzkf, zzkc zzkc) {
        this.zza = zzkf.zza;
        this.zzb = zzkf.zzb;
        this.zzc = zzkf.zzc;
    }
}
