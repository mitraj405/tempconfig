package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public interface zzfrq {
    ExecutorService zza(int i);

    ExecutorService zzb(ThreadFactory threadFactory, int i);

    ExecutorService zzc(int i, ThreadFactory threadFactory, int i2);
}
