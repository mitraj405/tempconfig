package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzb;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbza extends zzb {
    final /* synthetic */ zzbze zza;

    public zzbza(zzbze zzbze) {
        this.zza = zzbze;
    }

    public final void zza() {
        zzbze zzbze = this.zza;
        zzbbz zzbbz = new zzbbz(zzbze.zze, zzbze.zzf.afmaVersion);
        synchronized (this.zza.zza) {
            try {
                zzu.zze();
                zzbcc.zza(this.zza.zzh, zzbbz);
            } catch (IllegalArgumentException e) {
                zzm.zzk("Cannot config CSI reporter.", e);
            }
        }
    }
}
