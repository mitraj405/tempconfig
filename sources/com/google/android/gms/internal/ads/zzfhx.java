package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfhx implements ThreadFactory {
    private final AtomicInteger zza = new AtomicInteger(1);

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, lf.h("AdWorker(NG) #", this.zza.getAndIncrement()));
    }
}
