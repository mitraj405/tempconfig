package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzapb extends Thread {
    private final BlockingQueue zza;
    private final zzapa zzb;
    private final zzaor zzc;
    private volatile boolean zzd = false;
    private final zzaoy zze;

    public zzapb(BlockingQueue blockingQueue, zzapa zzapa, zzaor zzaor, zzaoy zzaoy) {
        this.zza = blockingQueue;
        this.zzb = zzapa;
        this.zzc = zzaor;
        this.zze = zzaoy;
    }

    private void zzb() throws InterruptedException {
        zzaph zzaph = (zzaph) this.zza.take();
        SystemClock.elapsedRealtime();
        zzaph.zzt(3);
        try {
            zzaph.zzm("network-queue-take");
            zzaph.zzw();
            TrafficStats.setThreadStatsTag(zzaph.zzc());
            zzapd zza2 = this.zzb.zza(zzaph);
            zzaph.zzm("network-http-complete");
            if (!zza2.zze || !zzaph.zzv()) {
                zzapn zzh = zzaph.zzh(zza2);
                zzaph.zzm("network-parse-complete");
                if (zzh.zzb != null) {
                    this.zzc.zzd(zzaph.zzj(), zzh.zzb);
                    zzaph.zzm("network-cache-written");
                }
                zzaph.zzq();
                this.zze.zzb(zzaph, zzh, (Runnable) null);
                zzaph.zzs(zzh);
                zzaph.zzt(4);
            }
            zzaph.zzp("not-modified");
            zzaph.zzr();
            zzaph.zzt(4);
        } catch (zzapq e) {
            SystemClock.elapsedRealtime();
            this.zze.zza(zzaph, e);
            zzaph.zzr();
        } catch (Exception e2) {
            zzapt.zzc(e2, "Unhandled exception %s", e2.toString());
            zzapq zzapq = new zzapq((Throwable) e2);
            SystemClock.elapsedRealtime();
            this.zze.zza(zzaph, zzapq);
            zzaph.zzr();
        } catch (Throwable th) {
            zzaph.zzt(4);
            throw th;
        }
    }

    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                zzb();
            } catch (InterruptedException unused) {
                if (this.zzd) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzapt.zzb("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    public final void zza() {
        this.zzd = true;
        interrupt();
    }
}
