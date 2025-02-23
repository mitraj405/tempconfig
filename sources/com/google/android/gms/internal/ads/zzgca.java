package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public class zzgca extends zzgck {
    public static zzgca zzu(ListenableFuture listenableFuture) {
        if (listenableFuture instanceof zzgca) {
            return (zzgca) listenableFuture;
        }
        return new zzgcb(listenableFuture);
    }
}
