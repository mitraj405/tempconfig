package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import in.juspay.hyper.constants.LogCategory;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdsk {
    /* access modifiers changed from: private */
    public final zzdsp zza;
    /* access modifiers changed from: private */
    public final Executor zzb;
    /* access modifiers changed from: private */
    public final Map zzc;

    public zzdsk(zzdsp zzdsp, Executor executor) {
        this.zza = zzdsp;
        this.zzc = zzdsp.zza();
        this.zzb = executor;
    }

    public final zzdsj zza() {
        zzdsj zzdsj = new zzdsj(this);
        zzdsj unused = zzdsj.zzb.putAll(zzdsj.zza.zzc);
        return zzdsj;
    }

    public final void zze() {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzkK)).booleanValue()) {
            zzdsj zza2 = zza();
            zza2.zzb(LogCategory.ACTION, "pecr");
            zza2.zzf();
        }
    }
}
