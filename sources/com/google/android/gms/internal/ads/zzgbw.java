package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzgbw extends zzgbi {
    /* access modifiers changed from: private */
    public zzgbv zza;

    public zzgbw(zzfxm zzfxm, boolean z, Executor executor, Callable callable) {
        super(zzfxm, z, false);
        this.zza = new zzgbu(this, callable, executor);
        zzv();
    }

    public final void zzq() {
        zzgbv zzgbv = this.zza;
        if (zzgbv != null) {
            zzgbv.zzh();
        }
    }

    public final void zzu() {
        zzgbv zzgbv = this.zza;
        if (zzgbv != null) {
            zzgbv.zzf();
        }
    }

    public final void zzy(int i) {
        super.zzy(i);
        if (i == 1) {
            this.zza = null;
        }
    }

    public final void zzf(int i, Object obj) {
    }
}
