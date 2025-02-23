package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzfgb {
    public static /* synthetic */ boolean zza(AtomicReference atomicReference, Object obj, Object obj2) {
        boolean z;
        while (true) {
            if (atomicReference.compareAndSet((Object) null, obj2)) {
                z = true;
            } else if (atomicReference.get() != null) {
                z = false;
            } else {
                continue;
            }
            if (z) {
                return true;
            }
            if (atomicReference.get() != null) {
                return false;
            }
        }
    }
}
