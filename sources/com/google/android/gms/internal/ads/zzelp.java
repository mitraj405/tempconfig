package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzelp implements zzemz {
    final /* synthetic */ zzelq zza;

    public zzelp(zzelq zzelq) {
        this.zza = zzelq;
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzi = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcpk zzcpk = (zzcpk) obj;
        synchronized (this.zza) {
            zzelq zzelq = this.zza;
            if (zzelq.zzi != null) {
                zzelq.zzi.zzb();
            }
            this.zza.zzi = zzcpk;
            this.zza.zzi.zzk();
        }
    }
}
