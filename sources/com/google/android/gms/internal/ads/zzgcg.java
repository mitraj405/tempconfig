package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzgcg implements Runnable {
    final Future zza;
    final zzgcf zzb;

    public zzgcg(Future future, zzgcf zzgcf) {
        this.zza = future;
        this.zzb = zzgcf;
    }

    public final void run() {
        Throwable zza2;
        Future future = this.zza;
        if (!(future instanceof zzgdm) || (zza2 = zzgdn.zza((zzgdm) future)) == null) {
            try {
                this.zzb.zzb(zzgcj.zzp(this.zza));
            } catch (ExecutionException e) {
                this.zzb.zza(e.getCause());
            } catch (Throwable th) {
                this.zzb.zza(th);
            }
        } else {
            this.zzb.zza(zza2);
        }
    }

    public final String toString() {
        zzfup zza2 = zzfuq.zza(this);
        zza2.zza(this.zzb);
        return zza2.toString();
    }
}
