package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfek {
    private final Clock zza;
    private final Object zzb = new Object();
    private volatile long zzc = 0;
    private volatile int zzd = 1;

    public zzfek(Clock clock) {
        this.zza = clock;
    }

    private final void zze() {
        long currentTimeMillis = this.zza.currentTimeMillis();
        synchronized (this.zzb) {
            if (this.zzd == 3) {
                if (this.zzc + ((Long) zzba.zzc().zza(zzbbw.zzfp)).longValue() <= currentTimeMillis) {
                    this.zzd = 1;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzf(int r5, int r6) {
        /*
            r4 = this;
            r4.zze()
            java.lang.Object r0 = r4.zzb
            com.google.android.gms.common.util.Clock r1 = r4.zza
            long r1 = r1.currentTimeMillis()
            monitor-enter(r0)
            int r3 = r4.zzd     // Catch:{ all -> 0x001d }
            if (r3 == r5) goto L_0x0012
            monitor-exit(r0)     // Catch:{ all -> 0x001d }
            return
        L_0x0012:
            r4.zzd = r6     // Catch:{ all -> 0x001d }
            int r5 = r4.zzd     // Catch:{ all -> 0x001d }
            r6 = 3
            if (r5 != r6) goto L_0x001b
            r4.zzc = r1     // Catch:{ all -> 0x001d }
        L_0x001b:
            monitor-exit(r0)     // Catch:{ all -> 0x001d }
            return
        L_0x001d:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001d }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfek.zzf(int, int):void");
    }

    public final void zza() {
        zzf(2, 3);
    }

    public final void zzb(boolean z) {
        if (z) {
            zzf(1, 2);
        } else {
            zzf(2, 1);
        }
    }

    public final boolean zzc() {
        boolean z;
        synchronized (this.zzb) {
            zze();
            if (this.zzd == 3) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public final boolean zzd() {
        boolean z;
        synchronized (this.zzb) {
            zze();
            if (this.zzd == 2) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }
}
