package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.nonagon.signalgeneration.zzq;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzenu implements zzevo {
    private final zzgcu zza;
    private final zzffg zzb;

    public zzenu(zzgcu zzgcu, zzffg zzffg, zzffv zzffv) {
        this.zza = zzgcu;
        this.zzb = zzffg;
    }

    public final int zza() {
        return 5;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzent(this));
    }

    public final /* synthetic */ zzenv zzc() throws Exception {
        String str = null;
        if (((Boolean) zzba.zzc().zza(zzbbw.zzgv)).booleanValue() && "requester_type_2".equals(zzq.zzc(this.zzb.zzd))) {
            str = zzffv.zza();
        }
        return new zzenv(str);
    }
}
