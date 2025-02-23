package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzgbl extends zzgbk {
    final AtomicReferenceFieldUpdater zza;
    final AtomicIntegerFieldUpdater zzb;

    public zzgbl(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
        super((zzgbj) null);
        this.zza = atomicReferenceFieldUpdater;
        this.zzb = atomicIntegerFieldUpdater;
    }

    public final int zza(zzgbo zzgbo) {
        return this.zzb.decrementAndGet(zzgbo);
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(com.google.android.gms.internal.ads.zzgbo r2, java.util.Set r3, java.util.Set r4) {
        /*
            r1 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = r1.zza
        L_0x0002:
            r0 = 0
            boolean r0 = r3.compareAndSet(r2, r0, r4)
            if (r0 == 0) goto L_0x000b
            r0 = 1
            goto L_0x0012
        L_0x000b:
            java.lang.Object r0 = r3.get(r2)
            if (r0 == 0) goto L_0x0002
            r0 = 0
        L_0x0012:
            if (r0 == 0) goto L_0x0015
            goto L_0x001b
        L_0x0015:
            java.lang.Object r3 = r3.get(r2)
            if (r3 == 0) goto L_0x0000
        L_0x001b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgbl.zzb(com.google.android.gms.internal.ads.zzgbo, java.util.Set, java.util.Set):void");
    }
}
