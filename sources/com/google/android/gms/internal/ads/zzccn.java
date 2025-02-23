package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzb;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzccn extends zzb {
    final zzcbk zza;
    final zzccv zzb;
    private final String zzc;
    private final String[] zzd;

    public zzccn(zzcbk zzcbk, zzccv zzccv, String str, String[] strArr) {
        this.zza = zzcbk;
        this.zzb = zzccv;
        this.zzc = str;
        this.zzd = strArr;
        zzu.zzy().zzb(this);
    }

    public final void zza() {
        try {
            this.zzb.zzu(this.zzc, this.zzd);
        } finally {
            zzt.zza.post(new zzccm(this));
        }
    }

    public final ListenableFuture zzb() {
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzbM)).booleanValue() || !(this.zzb instanceof zzcde)) {
            return super.zzb();
        }
        return zzbzo.zze.zzb(new zzccl(this));
    }

    public final /* synthetic */ Boolean zzd() throws Exception {
        return Boolean.valueOf(this.zzb.zzw(this.zzc, this.zzd, this));
    }

    public final String zze() {
        return this.zzc;
    }
}
