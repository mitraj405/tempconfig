package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzaoy {
    private final Executor zza;

    public zzaoy(Handler handler) {
        this.zza = new zzaow(this, handler);
    }

    public final void zza(zzaph zzaph, zzapq zzapq) {
        zzaph.zzm("post-error");
        ((zzaow) this.zza).zza.post(new zzaox(zzaph, zzapn.zza(zzapq), (Runnable) null));
    }

    public final void zzb(zzaph zzaph, zzapn zzapn, Runnable runnable) {
        zzaph.zzq();
        zzaph.zzm("post-response");
        ((zzaow) this.zza).zza.post(new zzaox(zzaph, zzapn, runnable));
    }
}
