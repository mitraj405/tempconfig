package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcsc implements zzeio {
    public final List zza;

    public zzcsc(List list) {
        this.zza = list;
    }

    public final void zzr() {
        for (ListenableFuture zzr : this.zza) {
            zzgcj.zzr(zzr, new zzcsb(this), zzgda.zzb());
        }
    }

    public zzcsc(zzcru zzcru) {
        this.zza = Collections.singletonList(zzgcj.zzh(zzcru));
    }
}
