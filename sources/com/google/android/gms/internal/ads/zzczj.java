package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzczj extends zzdch {
    private final ScheduledExecutorService zzb;
    private final Clock zzc;
    private long zzd = -1;
    private long zze = -1;
    private long zzf = -1;
    private long zzg = -1;
    private boolean zzh = false;
    private ScheduledFuture zzi;
    private ScheduledFuture zzj;

    public zzczj(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        super(Collections.emptySet());
        this.zzb = scheduledExecutorService;
        this.zzc = clock;
    }

    private final synchronized void zzf(long j) {
        ScheduledFuture scheduledFuture = this.zzi;
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            this.zzi.cancel(false);
        }
        this.zzd = this.zzc.elapsedRealtime() + j;
        this.zzi = this.zzb.schedule(new zzczg(this, (zzczf) null), j, TimeUnit.MILLISECONDS);
    }

    private final synchronized void zzg(long j) {
        ScheduledFuture scheduledFuture = this.zzj;
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            this.zzj.cancel(false);
        }
        this.zze = this.zzc.elapsedRealtime() + j;
        this.zzj = this.zzb.schedule(new zzczi(this, (zzczh) null), j, TimeUnit.MILLISECONDS);
    }

    public final synchronized void zza() {
        this.zzh = false;
        zzf(0);
    }

    public final synchronized void zzb() {
        if (!this.zzh) {
            ScheduledFuture scheduledFuture = this.zzi;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                this.zzf = -1;
            } else {
                this.zzi.cancel(false);
                this.zzf = this.zzd - this.zzc.elapsedRealtime();
            }
            ScheduledFuture scheduledFuture2 = this.zzj;
            if (scheduledFuture2 == null || scheduledFuture2.isCancelled()) {
                this.zzg = -1;
            } else {
                this.zzj.cancel(false);
                this.zzg = this.zze - this.zzc.elapsedRealtime();
            }
            this.zzh = true;
        }
    }

    public final synchronized void zzc() {
        if (this.zzh) {
            if (this.zzf > 0 && this.zzi.isCancelled()) {
                zzf(this.zzf);
            }
            if (this.zzg > 0 && this.zzj.isCancelled()) {
                zzg(this.zzg);
            }
            this.zzh = false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzd(int r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            if (r7 > 0) goto L_0x0004
            goto L_0x0033
        L_0x0004:
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x003a }
            long r1 = (long) r7     // Catch:{ all -> 0x003a }
            long r0 = r0.toMillis(r1)     // Catch:{ all -> 0x003a }
            boolean r7 = r6.zzh     // Catch:{ all -> 0x003a }
            if (r7 == 0) goto L_0x0021
            long r2 = r6.zzf     // Catch:{ all -> 0x003a }
            r4 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 <= 0) goto L_0x001c
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r7 >= 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r0 = r2
        L_0x001d:
            r6.zzf = r0     // Catch:{ all -> 0x003a }
            monitor-exit(r6)
            return
        L_0x0021:
            com.google.android.gms.common.util.Clock r7 = r6.zzc     // Catch:{ all -> 0x003a }
            long r2 = r7.elapsedRealtime()     // Catch:{ all -> 0x003a }
            long r4 = r6.zzd     // Catch:{ all -> 0x003a }
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 > 0) goto L_0x0035
            long r4 = r4 - r2
            int r7 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r7 <= 0) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            monitor-exit(r6)
            return
        L_0x0035:
            r6.zzf(r0)     // Catch:{ all -> 0x003a }
            monitor-exit(r6)
            return
        L_0x003a:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzczj.zzd(int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zze(int r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            if (r7 > 0) goto L_0x0004
            goto L_0x0033
        L_0x0004:
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x003a }
            long r1 = (long) r7     // Catch:{ all -> 0x003a }
            long r0 = r0.toMillis(r1)     // Catch:{ all -> 0x003a }
            boolean r7 = r6.zzh     // Catch:{ all -> 0x003a }
            if (r7 == 0) goto L_0x0021
            long r2 = r6.zzg     // Catch:{ all -> 0x003a }
            r4 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 <= 0) goto L_0x001c
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r7 >= 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r0 = r2
        L_0x001d:
            r6.zzg = r0     // Catch:{ all -> 0x003a }
            monitor-exit(r6)
            return
        L_0x0021:
            com.google.android.gms.common.util.Clock r7 = r6.zzc     // Catch:{ all -> 0x003a }
            long r2 = r7.elapsedRealtime()     // Catch:{ all -> 0x003a }
            long r4 = r6.zze     // Catch:{ all -> 0x003a }
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 > 0) goto L_0x0035
            long r4 = r4 - r2
            int r7 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r7 <= 0) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            monitor-exit(r6)
            return
        L_0x0035:
            r6.zzg(r0)     // Catch:{ all -> 0x003a }
            monitor-exit(r6)
            return
        L_0x003a:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzczj.zze(int):void");
    }
}
