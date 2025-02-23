package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public class zzgyu {
    protected volatile zzgzj zza;
    private volatile zzgwm zzb;

    static {
        int i = zzgxi.zzb;
        int i2 = zzgzt.zza;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgyu)) {
            return false;
        }
        zzgyu zzgyu = (zzgyu) obj;
        zzgzj zzgzj = this.zza;
        zzgzj zzgzj2 = zzgyu.zza;
        if (zzgzj == null && zzgzj2 == null) {
            return zzb().equals(zzgyu.zzb());
        }
        if (zzgzj != null && zzgzj2 != null) {
            return zzgzj.equals(zzgzj2);
        }
        if (zzgzj != null) {
            zzgyu.zzd(zzgzj.zzbt());
            return zzgzj.equals(zzgyu.zza);
        }
        zzd(zzgzj2.zzbt());
        return this.zza.equals(zzgzj2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzb != null) {
            return ((zzgwk) this.zzb).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzaY();
        }
        return 0;
    }

    public final zzgwm zzb() {
        if (this.zzb != null) {
            return this.zzb;
        }
        synchronized (this) {
            if (this.zzb != null) {
                zzgwm zzgwm = this.zzb;
                return zzgwm;
            }
            if (this.zza == null) {
                this.zzb = zzgwm.zzb;
            } else {
                this.zzb = this.zza.zzaN();
            }
            zzgwm zzgwm2 = this.zzb;
            return zzgwm2;
        }
    }

    public final zzgzj zzc(zzgzj zzgzj) {
        zzgzj zzgzj2 = this.zza;
        this.zzb = null;
        this.zza = zzgzj;
        return zzgzj2;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0013 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(com.google.android.gms.internal.ads.zzgzj r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.ads.zzgzj r0 = r1.zza
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzgzj r0 = r1.zza     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x000c:
            r1.zza = r2     // Catch:{ zzgyn -> 0x0013 }
            com.google.android.gms.internal.ads.zzgwm r0 = com.google.android.gms.internal.ads.zzgwm.zzb     // Catch:{ zzgyn -> 0x0013 }
            r1.zzb = r0     // Catch:{ zzgyn -> 0x0013 }
            goto L_0x0019
        L_0x0013:
            r1.zza = r2     // Catch:{ all -> 0x001b }
            com.google.android.gms.internal.ads.zzgwm r2 = com.google.android.gms.internal.ads.zzgwm.zzb     // Catch:{ all -> 0x001b }
            r1.zzb = r2     // Catch:{ all -> 0x001b }
        L_0x0019:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x001b:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgyu.zzd(com.google.android.gms.internal.ads.zzgzj):void");
    }
}
