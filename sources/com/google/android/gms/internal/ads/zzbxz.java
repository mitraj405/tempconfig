package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbxz implements ThreadFactory {
    private final AtomicInteger zza = new AtomicInteger(1);

    public zzbxz(zzbya zzbya) {
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, lf.h("AdWorker(SCION_TASK_EXECUTOR) #", this.zza.getAndIncrement()));
    }
}
