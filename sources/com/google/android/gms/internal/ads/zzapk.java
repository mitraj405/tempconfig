package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzapk {
    private final AtomicInteger zza = new AtomicInteger();
    private final Set zzb = new HashSet();
    private final PriorityBlockingQueue zzc = new PriorityBlockingQueue();
    private final PriorityBlockingQueue zzd = new PriorityBlockingQueue();
    private final zzaor zze;
    private final zzapa zzf;
    private final zzapb[] zzg;
    private zzaot zzh;
    private final List zzi = new ArrayList();
    private final List zzj = new ArrayList();
    private final zzaoy zzk;

    public zzapk(zzaor zzaor, zzapa zzapa, int i) {
        zzaoy zzaoy = new zzaoy(new Handler(Looper.getMainLooper()));
        this.zze = zzaor;
        this.zzf = zzapa;
        this.zzg = new zzapb[4];
        this.zzk = zzaoy;
    }

    public final zzaph zza(zzaph zzaph) {
        zzaph.zzf(this);
        synchronized (this.zzb) {
            this.zzb.add(zzaph);
        }
        zzaph.zzg(this.zza.incrementAndGet());
        zzaph.zzm("add-to-queue");
        zzc(zzaph, 0);
        this.zzc.add(zzaph);
        return zzaph;
    }

    public final void zzb(zzaph zzaph) {
        synchronized (this.zzb) {
            this.zzb.remove(zzaph);
        }
        synchronized (this.zzi) {
            for (zzapj zza2 : this.zzi) {
                zza2.zza();
            }
        }
        zzc(zzaph, 5);
    }

    public final void zzc(zzaph zzaph, int i) {
        synchronized (this.zzj) {
            for (zzapi zza2 : this.zzj) {
                zza2.zza();
            }
        }
    }

    public final void zzd() {
        zzaot zzaot = this.zzh;
        if (zzaot != null) {
            zzaot.zzb();
        }
        zzapb[] zzapbArr = this.zzg;
        for (int i = 0; i < 4; i++) {
            zzapb zzapb = zzapbArr[i];
            if (zzapb != null) {
                zzapb.zza();
            }
        }
        zzaot zzaot2 = new zzaot(this.zzc, this.zzd, this.zze, this.zzk);
        this.zzh = zzaot2;
        zzaot2.start();
        for (int i2 = 0; i2 < 4; i2++) {
            zzapb zzapb2 = new zzapb(this.zzd, this.zzf, this.zze, this.zzk);
            this.zzg[i2] = zzapb2;
            zzapb2.start();
        }
    }
}
