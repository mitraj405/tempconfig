package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.util.zzg;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzecb implements zzcye, zzcwt {
    private static final Object zza = new Object();
    private static int zzb;
    private final zzg zzc;
    private final zzecl zzd;

    public zzecb(zzecl zzecl, zzg zzg) {
        this.zzd = zzecl;
        this.zzc = zzg;
    }

    private final void zzb(boolean z) {
        int i;
        int intValue;
        if (((Boolean) zzba.zzc().zza(zzbbw.zzfB)).booleanValue() && !this.zzc.zzS()) {
            Object obj = zza;
            synchronized (obj) {
                i = zzb;
                intValue = ((Integer) zzba.zzc().zza(zzbbw.zzfC)).intValue();
            }
            if (i < intValue) {
                this.zzd.zzd(z);
                synchronized (obj) {
                    zzb++;
                }
            }
        }
    }

    public final void zzdB(zze zze) {
        zzb(false);
    }

    public final void zzs() {
        zzb(true);
    }
}
