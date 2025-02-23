package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzur {
    public final int zza;
    public final zzui zzb;
    private final CopyOnWriteArrayList zzc;

    private zzur(CopyOnWriteArrayList copyOnWriteArrayList, int i, zzui zzui) {
        this.zzc = copyOnWriteArrayList;
        this.zza = 0;
        this.zzb = zzui;
    }

    public final zzur zza(int i, zzui zzui) {
        return new zzur(this.zzc, 0, zzui);
    }

    public final void zzb(Handler handler, zzus zzus) {
        this.zzc.add(new zzuq(handler, zzus));
    }

    public final void zzc(zzue zzue) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzuq zzuq = (zzuq) it.next();
            zzet.zzO(zzuq.zza, new zzul(this, zzuq.zzb, zzue));
        }
    }

    public final void zzd(zztz zztz, zzue zzue) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzuq zzuq = (zzuq) it.next();
            zzet.zzO(zzuq.zza, new zzup(this, zzuq.zzb, zztz, zzue));
        }
    }

    public final void zze(zztz zztz, zzue zzue) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzuq zzuq = (zzuq) it.next();
            zzet.zzO(zzuq.zza, new zzun(this, zzuq.zzb, zztz, zzue));
        }
    }

    public final void zzf(zztz zztz, zzue zzue, IOException iOException, boolean z) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzuq zzuq = (zzuq) it.next();
            zzet.zzO(zzuq.zza, new zzuo(this, zzuq.zzb, zztz, zzue, iOException, z));
        }
    }

    public final void zzg(zztz zztz, zzue zzue) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzuq zzuq = (zzuq) it.next();
            zzet.zzO(zzuq.zza, new zzum(this, zzuq.zzb, zztz, zzue));
        }
    }

    public final void zzh(zzus zzus) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzuq zzuq = (zzuq) it.next();
            if (zzuq.zzb == zzus) {
                this.zzc.remove(zzuq);
            }
        }
    }

    public zzur() {
        this(new CopyOnWriteArrayList(), 0, (zzui) null);
    }
}
