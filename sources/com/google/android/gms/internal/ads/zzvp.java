package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzvp implements zzye {
    public long zza;
    public long zzb;
    public zzyd zzc;
    public zzvp zzd;

    public zzvp(long j, int i) {
        zze(j, 65536);
    }

    public final int zza(long j) {
        long j2 = j - this.zza;
        int i = this.zzc.zzb;
        return (int) j2;
    }

    public final zzvp zzb() {
        this.zzc = null;
        zzvp zzvp = this.zzd;
        this.zzd = null;
        return zzvp;
    }

    public final zzyd zzc() {
        zzyd zzyd = this.zzc;
        zzyd.getClass();
        return zzyd;
    }

    public final zzye zzd() {
        zzvp zzvp = this.zzd;
        if (zzvp == null || zzvp.zzc == null) {
            return null;
        }
        return zzvp;
    }

    public final void zze(long j, int i) {
        boolean z;
        if (this.zzc == null) {
            z = true;
        } else {
            z = false;
        }
        zzdi.zzf(z);
        this.zza = j;
        this.zzb = j + PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
    }
}
