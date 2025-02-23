package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzs;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcyz extends zzdch implements zzcxk, zzcyp {
    private final zzfel zzb;
    private final AtomicBoolean zzc = new AtomicBoolean();

    public zzcyz(Set set, zzfel zzfel) {
        super(set);
        this.zzb = zzfel;
    }

    private final void zzb() {
        zzs zzs;
        if (((Boolean) zzba.zzc().zza(zzbbw.zzgY)).booleanValue() && this.zzc.compareAndSet(false, true) && (zzs = this.zzb.zzae) != null && zzs.zza == 3) {
            zzq(new zzcyy(this));
        }
    }

    public final /* synthetic */ void zza(zzczb zzczb) throws Exception {
        zzczb.zzh(this.zzb.zzae);
    }

    public final void zzg() {
        if (this.zzb.zzb == 1) {
            zzb();
        }
    }

    public final void zzr() {
        int i = this.zzb.zzb;
        if (i == 2 || i == 5 || i == 4 || i == 6 || i == 7) {
            zzb();
        }
    }
}
