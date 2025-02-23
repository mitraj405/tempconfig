package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayDeque;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfhq {
    private final zzfgu zza;
    private final zzfho zzb;
    private final zzfgq zzc;
    /* access modifiers changed from: private */
    public final ArrayDeque zzd;
    /* access modifiers changed from: private */
    public zzfhw zze;
    /* access modifiers changed from: private */
    public int zzf = 1;

    public zzfhq(zzfgu zzfgu, zzfgq zzfgq, zzfho zzfho) {
        this.zza = zzfgu;
        this.zzc = zzfgq;
        this.zzb = zzfho;
        this.zzd = new ArrayDeque();
        zzfgq.zzb(new zzfhl(this));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzh() {
        /*
            r4 = this;
            monitor-enter(r4)
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzfE     // Catch:{ all -> 0x006e }
            com.google.android.gms.internal.ads.zzbbu r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x006e }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x006e }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x006e }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x006e }
            if (r0 == 0) goto L_0x002d
            com.google.android.gms.internal.ads.zzbze r0 = com.google.android.gms.ads.internal.zzu.zzo()     // Catch:{ all -> 0x006e }
            com.google.android.gms.ads.internal.util.zzg r0 = r0.zzi()     // Catch:{ all -> 0x006e }
            com.google.android.gms.internal.ads.zzbyy r0 = r0.zzh()     // Catch:{ all -> 0x006e }
            boolean r0 = r0.zzh()     // Catch:{ all -> 0x006e }
            if (r0 == 0) goto L_0x0026
            goto L_0x002d
        L_0x0026:
            java.util.ArrayDeque r0 = r4.zzd     // Catch:{ all -> 0x006e }
            r0.clear()     // Catch:{ all -> 0x006e }
            monitor-exit(r4)
            return
        L_0x002d:
            boolean r0 = r4.zzi()     // Catch:{ all -> 0x006e }
            if (r0 == 0) goto L_0x006c
        L_0x0033:
            java.util.ArrayDeque r0 = r4.zzd     // Catch:{ all -> 0x006e }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x006e }
            if (r0 != 0) goto L_0x006c
            java.util.ArrayDeque r0 = r4.zzd     // Catch:{ all -> 0x006e }
            java.lang.Object r0 = r0.pollFirst()     // Catch:{ all -> 0x006e }
            com.google.android.gms.internal.ads.zzfhp r0 = (com.google.android.gms.internal.ads.zzfhp) r0     // Catch:{ all -> 0x006e }
            if (r0 == 0) goto L_0x0057
            com.google.android.gms.internal.ads.zzfhe r1 = r0.zza()     // Catch:{ all -> 0x006e }
            if (r1 == 0) goto L_0x0033
            com.google.android.gms.internal.ads.zzfgu r1 = r4.zza     // Catch:{ all -> 0x006e }
            com.google.android.gms.internal.ads.zzfhe r2 = r0.zza()     // Catch:{ all -> 0x006e }
            boolean r1 = r1.zze(r2)     // Catch:{ all -> 0x006e }
            if (r1 == 0) goto L_0x0033
        L_0x0057:
            com.google.android.gms.internal.ads.zzfgu r1 = r4.zza     // Catch:{ all -> 0x006e }
            com.google.android.gms.internal.ads.zzfho r2 = r4.zzb     // Catch:{ all -> 0x006e }
            com.google.android.gms.internal.ads.zzfhw r3 = new com.google.android.gms.internal.ads.zzfhw     // Catch:{ all -> 0x006e }
            r3.<init>(r1, r2, r0)     // Catch:{ all -> 0x006e }
            r4.zze = r3     // Catch:{ all -> 0x006e }
            com.google.android.gms.internal.ads.zzfhm r1 = new com.google.android.gms.internal.ads.zzfhm     // Catch:{ all -> 0x006e }
            r1.<init>(r4, r0)     // Catch:{ all -> 0x006e }
            r3.zzd(r1)     // Catch:{ all -> 0x006e }
            monitor-exit(r4)
            return
        L_0x006c:
            monitor-exit(r4)
            return
        L_0x006e:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfhq.zzh():void");
    }

    private final synchronized boolean zzi() {
        if (this.zze == null) {
            return true;
        }
        return false;
    }

    public final synchronized ListenableFuture zza(zzfhp zzfhp) {
        this.zzf = 2;
        if (zzi()) {
            return null;
        }
        return this.zze.zza(zzfhp);
    }

    public final synchronized void zze(zzfhp zzfhp) {
        this.zzd.add(zzfhp);
    }

    public final /* synthetic */ void zzf() {
        synchronized (this) {
            this.zzf = 1;
            zzh();
        }
    }
}
