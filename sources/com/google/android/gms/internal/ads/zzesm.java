package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nonagon.signalgeneration.zzq;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzesm implements zzevo {
    private final zzgcu zza;
    private final zzffg zzb;

    public zzesm(zzgcu zzgcu, zzffg zzffg) {
        this.zza = zzgcu;
        this.zzb = zzffg;
    }

    public final int zza() {
        return 21;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzesl(this));
    }

    public final /* synthetic */ zzesn zzc() throws Exception {
        return new zzesn("requester_type_2".equals(zzq.zzc(this.zzb.zzd)));
    }
}
