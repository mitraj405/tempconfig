package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzbhx implements zzgbq {
    public final /* synthetic */ zzcni zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzbhx(zzcni zzcni, String str) {
        this.zza = zzcni;
        this.zzb = str;
    }

    public final ListenableFuture zza(Object obj) {
        zzcni zzcni;
        String str = (String) obj;
        zzbix zzbix = zzbiw.zza;
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzjg)).booleanValue() || (zzcni = this.zza) == null || !zzcni.zzj(this.zzb)) {
            return zzgcj.zzh(str);
        }
        return zzcni.zzb(str, zzay.zze());
    }
}
