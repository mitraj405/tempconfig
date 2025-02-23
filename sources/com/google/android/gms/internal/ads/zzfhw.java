package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfhw {
    private final zzfhp zza;
    private final ListenableFuture zzb;
    private boolean zzc = false;
    private boolean zzd = false;

    public zzfhw(zzfgu zzfgu, zzfho zzfho, zzfhp zzfhp) {
        this.zza = zzfhp;
        this.zzb = zzgcj.zzf(zzgcj.zzn(zzfho.zza(zzfhp), new zzfhu(this, zzfho, zzfgu, zzfhp), zzfhp.zzb()), Exception.class, new zzfhv(this, zzfho), zzfhp.zzb());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0030, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.google.common.util.concurrent.ListenableFuture zza(com.google.android.gms.internal.ads.zzfhp r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.zzd     // Catch:{ all -> 0x0032 }
            if (r0 != 0) goto L_0x002f
            boolean r0 = r1.zzc     // Catch:{ all -> 0x0032 }
            if (r0 == 0) goto L_0x000a
            goto L_0x002f
        L_0x000a:
            com.google.android.gms.internal.ads.zzfhp r0 = r1.zza     // Catch:{ all -> 0x0032 }
            com.google.android.gms.internal.ads.zzfhe r0 = r0.zza()     // Catch:{ all -> 0x0032 }
            if (r0 == 0) goto L_0x002f
            com.google.android.gms.internal.ads.zzfhe r0 = r2.zza()     // Catch:{ all -> 0x0032 }
            if (r0 == 0) goto L_0x002f
            com.google.android.gms.internal.ads.zzfhp r0 = r1.zza     // Catch:{ all -> 0x0032 }
            com.google.android.gms.internal.ads.zzfhe r0 = r0.zza()     // Catch:{ all -> 0x0032 }
            com.google.android.gms.internal.ads.zzfhe r2 = r2.zza()     // Catch:{ all -> 0x0032 }
            boolean r2 = r0.equals(r2)     // Catch:{ all -> 0x0032 }
            if (r2 == 0) goto L_0x002f
            r2 = 1
            r1.zzc = r2     // Catch:{ all -> 0x0032 }
            com.google.common.util.concurrent.ListenableFuture r2 = r1.zzb     // Catch:{ all -> 0x0032 }
            monitor-exit(r1)
            return r2
        L_0x002f:
            monitor-exit(r1)
            r2 = 0
            return r2
        L_0x0032:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfhw.zza(com.google.android.gms.internal.ads.zzfhp):com.google.common.util.concurrent.ListenableFuture");
    }

    public final /* synthetic */ ListenableFuture zzb(zzfho zzfho, zzfgu zzfgu, zzfhp zzfhp, zzfhd zzfhd) throws Exception {
        synchronized (this) {
            this.zzd = true;
            zzfho.zzb(zzfhd);
            if (!this.zzc) {
                zzfgu.zzd(zzfhp.zza(), zzfhd);
                ListenableFuture zzh = zzgcj.zzh((Object) null);
                return zzh;
            }
            ListenableFuture zzh2 = zzgcj.zzh(new zzfhn(zzfhd, zzfhp));
            return zzh2;
        }
    }

    public final /* synthetic */ ListenableFuture zzc(zzfho zzfho, Exception exc) throws Exception {
        synchronized (this) {
            this.zzd = true;
            throw exc;
        }
    }

    public final synchronized void zzd(zzgcf zzgcf) {
        zzgcj.zzr(zzgcj.zzn(this.zzb, new zzfht(), this.zza.zzb()), zzgcf, this.zza.zzb());
    }
}
