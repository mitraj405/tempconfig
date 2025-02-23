package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdla implements zzcxk {
    private final zzdjb zza;
    private final zzdjg zzb;
    private final Executor zzc;
    private final Executor zzd;

    public zzdla(zzdjb zzdjb, zzdjg zzdjg, Executor executor, Executor executor2) {
        this.zza = zzdjb;
        this.zzb = zzdjg;
        this.zzc = executor;
        this.zzd = executor2;
    }

    /* access modifiers changed from: private */
    public final void zzb(zzcej zzcej) {
        this.zzc.execute(new zzdky(zzcej));
    }

    public final void zzr() {
        if (this.zzb.zzd()) {
            zzdjb zzdjb = this.zza;
            zzeeo zzu = zzdjb.zzu();
            if (zzu == null && zzdjb.zzw() != null) {
                if (((Boolean) zzba.zzc().zza(zzbbw.zzeH)).booleanValue()) {
                    zzdjb zzdjb2 = this.zza;
                    ListenableFuture zzw = zzdjb2.zzw();
                    zzbzt zzp = zzdjb2.zzp();
                    if (zzw != null && zzp != null) {
                        zzgcj.zzr(zzgcj.zzl(zzw, zzp), new zzdkz(this), this.zzd);
                        return;
                    }
                    return;
                }
            }
            if (zzu != null) {
                zzdjb zzdjb3 = this.zza;
                zzcej zzr = zzdjb3.zzr();
                zzcej zzs = zzdjb3.zzs();
                if (zzr == null) {
                    if (zzs != null) {
                        zzr = zzs;
                    } else {
                        zzr = null;
                    }
                }
                if (zzr != null) {
                    zzb(zzr);
                }
            }
        }
    }
}
