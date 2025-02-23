package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeqd implements zzevo {
    private final zzfbj zza;

    public zzeqd(zzfbj zzfbj) {
        this.zza = zzfbj;
    }

    public final int zza() {
        return 15;
    }

    public final ListenableFuture zzb() {
        zzfbj zzfbj = this.zza;
        zzeqc zzeqc = null;
        if (!(zzfbj == null || zzfbj.zza() == null || zzfbj.zza().isEmpty())) {
            zzeqc = new zzeqc(this);
        }
        return zzgcj.zzh(zzeqc);
    }

    public final /* synthetic */ void zzc(Bundle bundle) {
        bundle.putString("key_schema", this.zza.zza());
    }
}
