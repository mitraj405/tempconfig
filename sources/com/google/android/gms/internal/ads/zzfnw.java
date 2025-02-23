package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfnw {
    private final BlockingQueue zza;
    private final ThreadPoolExecutor zzb;
    private final ArrayDeque zzc = new ArrayDeque();
    private zzfnv zzd = null;

    public zzfnw() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.zza = linkedBlockingQueue;
        this.zzb = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    private final void zzc() {
        zzfnv zzfnv = (zzfnv) this.zzc.poll();
        this.zzd = zzfnv;
        if (zzfnv != null) {
            zzfnv.executeOnExecutor(this.zzb, new Object[0]);
        }
    }

    public final void zza(zzfnv zzfnv) {
        this.zzd = null;
        zzc();
    }

    public final void zzb(zzfnv zzfnv) {
        zzfnv.zzb(this);
        this.zzc.add(zzfnv);
        if (this.zzd == null) {
            zzc();
        }
    }
}
