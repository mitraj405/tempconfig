package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfxy extends zzfvs {
    final /* synthetic */ Iterator zza;
    final /* synthetic */ zzfuv zzb;

    public zzfxy(Iterator it, zzfuv zzfuv) {
        this.zza = it;
        this.zzb = zzfuv;
    }

    public final Object zza() {
        while (this.zza.hasNext()) {
            Iterator it = this.zza;
            zzfuv zzfuv = this.zzb;
            Object next = it.next();
            if (zzfuv.zza(next)) {
                return next;
            }
        }
        zzb();
        return null;
    }
}
