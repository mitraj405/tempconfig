package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzrd {
    public final int zza;
    public final zzui zzb;
    private final CopyOnWriteArrayList zzc;

    private zzrd(CopyOnWriteArrayList copyOnWriteArrayList, int i, zzui zzui) {
        this.zzc = copyOnWriteArrayList;
        this.zza = 0;
        this.zzb = zzui;
    }

    public final zzrd zza(int i, zzui zzui) {
        return new zzrd(this.zzc, 0, zzui);
    }

    public final void zzb(Handler handler, zzre zzre) {
        this.zzc.add(new zzrc(handler, zzre));
    }

    public final void zzc(zzre zzre) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzrc zzrc = (zzrc) it.next();
            if (zzrc.zza == zzre) {
                this.zzc.remove(zzrc);
            }
        }
    }

    public zzrd() {
        this(new CopyOnWriteArrayList(), 0, (zzui) null);
    }
}
