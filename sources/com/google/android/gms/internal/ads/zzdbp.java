package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdbp implements zzczo {
    private int zza = ((Integer) zzba.zzc().zza(zzbbw.zzaX)).intValue();
    private int zzb = ((Integer) zzba.zzc().zza(zzbbw.zzlS)).intValue();

    public final synchronized int zzc() {
        return this.zza;
    }

    public final synchronized int zzd() {
        return this.zzb;
    }

    public final synchronized void zzdo(zzfex zzfex) {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzaY)).booleanValue()) {
            try {
                zzfeo zzfeo = zzfex.zzb.zzb;
                this.zza = zzfeo.zzc;
                this.zzb = zzfeo.zzd;
            } catch (NullPointerException unused) {
            }
        }
    }

    public final void zzdn(zzbvb zzbvb) {
    }
}
