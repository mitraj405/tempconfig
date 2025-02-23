package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfeb implements zzemz {
    final /* synthetic */ zzfec zza;

    public zzfeb(zzfec zzfec) {
        this.zza = zzfec;
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzi = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        synchronized (this.zza) {
            this.zza.zzi = (zzdop) obj;
            if (((Boolean) zzba.zzc().zza(zzbbw.zzdg)).booleanValue()) {
                ((zzdop) obj).zzd().zza = this.zza.zzd;
            }
            this.zza.zzi.zzk();
        }
    }
}
