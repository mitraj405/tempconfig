package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdv implements Runnable {
    public final /* synthetic */ CopyOnWriteArraySet zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ zzdw zzc;

    public /* synthetic */ zzdv(CopyOnWriteArraySet copyOnWriteArraySet, int i, zzdw zzdw) {
        this.zza = copyOnWriteArraySet;
        this.zzb = i;
        this.zzc = zzdw;
    }

    public final void run() {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            zzdw zzdw = this.zzc;
            ((zzdy) it.next()).zza(this.zzb, zzdw);
        }
    }
}
