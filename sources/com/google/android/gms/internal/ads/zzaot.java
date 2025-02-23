package com.google.android.gms.internal.ads;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzaot extends Thread {
    private static final boolean zza = zzapt.zzb;
    private final BlockingQueue zzb;
    /* access modifiers changed from: private */
    public final BlockingQueue zzc;
    private final zzaor zzd;
    private volatile boolean zze = false;
    private final zzapu zzf;
    private final zzaoy zzg;

    public zzaot(BlockingQueue blockingQueue, BlockingQueue blockingQueue2, zzaor zzaor, zzaoy zzaoy) {
        this.zzb = blockingQueue;
        this.zzc = blockingQueue2;
        this.zzd = zzaor;
        this.zzg = zzaoy;
        this.zzf = new zzapu(this, blockingQueue2, zzaoy);
    }

    private void zzc() throws InterruptedException {
        zzaph zzaph = (zzaph) this.zzb.take();
        zzaph.zzm("cache-queue-take");
        zzaph.zzt(1);
        try {
            zzaph.zzw();
            zzaoq zza2 = this.zzd.zza(zzaph.zzj());
            if (zza2 == null) {
                zzaph.zzm("cache-miss");
                if (!this.zzf.zzc(zzaph)) {
                    this.zzc.put(zzaph);
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                if (zza2.zza(currentTimeMillis)) {
                    zzaph.zzm("cache-hit-expired");
                    zzaph.zze(zza2);
                    if (!this.zzf.zzc(zzaph)) {
                        this.zzc.put(zzaph);
                    }
                } else {
                    zzaph.zzm("cache-hit");
                    zzapn zzh = zzaph.zzh(new zzapd(zza2.zza, zza2.zzg));
                    zzaph.zzm("cache-hit-parsed");
                    if (!zzh.zzc()) {
                        zzaph.zzm("cache-parsing-failed");
                        this.zzd.zzc(zzaph.zzj(), true);
                        zzaph.zze((zzaoq) null);
                        if (!this.zzf.zzc(zzaph)) {
                            this.zzc.put(zzaph);
                        }
                    } else if (zza2.zzf < currentTimeMillis) {
                        zzaph.zzm("cache-hit-refresh-needed");
                        zzaph.zze(zza2);
                        zzh.zzd = true;
                        if (!this.zzf.zzc(zzaph)) {
                            this.zzg.zzb(zzaph, zzh, new zzaos(this, zzaph));
                        } else {
                            this.zzg.zzb(zzaph, zzh, (Runnable) null);
                        }
                    } else {
                        this.zzg.zzb(zzaph, zzh, (Runnable) null);
                    }
                }
            }
        } finally {
            zzaph.zzt(2);
        }
    }

    public final void run() {
        if (zza) {
            zzapt.zzd("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.zzd.zzb();
        while (true) {
            try {
                zzc();
            } catch (InterruptedException unused) {
                if (this.zze) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzapt.zzb("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    public final void zzb() {
        this.zze = true;
        interrupt();
    }
}
