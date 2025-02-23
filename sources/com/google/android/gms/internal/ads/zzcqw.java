package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcqw implements zzaxw {
    private final zzcej zza;
    private final Executor zzb;
    private final AtomicReference zzc = new AtomicReference();

    public zzcqw(zzcej zzcej, Executor executor) {
        this.zza = zzcej;
        this.zzb = executor;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0060, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzdp(com.google.android.gms.internal.ads.zzaxv r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzcej r0 = r2.zza     // Catch:{ all -> 0x0061 }
            if (r0 == 0) goto L_0x005f
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzlF     // Catch:{ all -> 0x0061 }
            com.google.android.gms.internal.ads.zzbbu r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x0061 }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x0061 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0061 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0061 }
            if (r0 != 0) goto L_0x0018
            goto L_0x005f
        L_0x0018:
            boolean r0 = r3.zzj     // Catch:{ all -> 0x0061 }
            if (r0 == 0) goto L_0x003c
            java.util.concurrent.atomic.AtomicReference r0 = r2.zzc     // Catch:{ all -> 0x0061 }
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0061 }
            java.lang.Object r0 = r0.getAndSet(r1)     // Catch:{ all -> 0x0061 }
            boolean r0 = r1.equals(r0)     // Catch:{ all -> 0x0061 }
            if (r0 == 0) goto L_0x002b
            goto L_0x003c
        L_0x002b:
            java.util.concurrent.Executor r3 = r2.zzb     // Catch:{ all -> 0x0061 }
            com.google.android.gms.internal.ads.zzcej r0 = r2.zza     // Catch:{ all -> 0x0061 }
            java.util.Objects.requireNonNull(r0)     // Catch:{ all -> 0x0061 }
            com.google.android.gms.internal.ads.zzcqu r1 = new com.google.android.gms.internal.ads.zzcqu     // Catch:{ all -> 0x0061 }
            r1.<init>(r0)     // Catch:{ all -> 0x0061 }
            r3.execute(r1)     // Catch:{ all -> 0x0061 }
            monitor-exit(r2)
            return
        L_0x003c:
            boolean r3 = r3.zzj     // Catch:{ all -> 0x0061 }
            if (r3 != 0) goto L_0x005f
            java.util.concurrent.atomic.AtomicReference r3 = r2.zzc     // Catch:{ all -> 0x0061 }
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0061 }
            java.lang.Object r3 = r3.getAndSet(r0)     // Catch:{ all -> 0x0061 }
            boolean r3 = r0.equals(r3)     // Catch:{ all -> 0x0061 }
            if (r3 != 0) goto L_0x005f
            java.util.concurrent.Executor r3 = r2.zzb     // Catch:{ all -> 0x0061 }
            com.google.android.gms.internal.ads.zzcej r0 = r2.zza     // Catch:{ all -> 0x0061 }
            java.util.Objects.requireNonNull(r0)     // Catch:{ all -> 0x0061 }
            com.google.android.gms.internal.ads.zzcqv r1 = new com.google.android.gms.internal.ads.zzcqv     // Catch:{ all -> 0x0061 }
            r1.<init>(r0)     // Catch:{ all -> 0x0061 }
            r3.execute(r1)     // Catch:{ all -> 0x0061 }
            monitor-exit(r2)
            return
        L_0x005f:
            monitor-exit(r2)
            return
        L_0x0061:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcqw.zzdp(com.google.android.gms.internal.ads.zzaxv):void");
    }
}
