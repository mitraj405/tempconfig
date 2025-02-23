package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzyh {
    private final CopyOnWriteArrayList zza = new CopyOnWriteArrayList();

    public final void zza(Handler handler, zzyi zzyi) {
        zzc(zzyi);
        this.zza.add(new zzyg(handler, zzyi));
    }

    public final void zzb(int i, long j, long j2) {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            zzyg zzyg = (zzyg) it.next();
            if (!zzyg.zzc) {
                zzyg.zza.post(new zzyf(zzyg, i, j, j2));
            }
        }
    }

    public final void zzc(zzyi zzyi) {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            zzyg zzyg = (zzyg) it.next();
            if (zzyg.zzb == zzyi) {
                zzyg.zzc();
                this.zza.remove(zzyg);
            }
        }
    }
}
