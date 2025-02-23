package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfeg implements zzemz {
    final /* synthetic */ zzfei zza;

    public zzfeg(zzfei zzfei) {
        this.zza = zzfei;
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzd = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        synchronized (this.zza) {
            this.zza.zzd = (zzdop) obj;
            if (((Boolean) zzba.zzc().zza(zzbbw.zzdg)).booleanValue()) {
                ((zzdop) obj).zzd().zza = this.zza.zzc;
            }
            this.zza.zzd.zzk();
        }
    }
}
