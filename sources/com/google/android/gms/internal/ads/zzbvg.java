package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzu;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbvg implements Callable {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbvi zzb;

    public zzbvg(zzbvi zzbvi, Context context) {
        this.zza = context;
        this.zzb = zzbvi;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzbvf zzbvf;
        zzbvh zzbvh = (zzbvh) this.zzb.zza.get(this.zza);
        if (zzbvh != null) {
            if (zzbvh.zza + ((Long) zzbdh.zza.zze()).longValue() >= zzu.zzB().currentTimeMillis()) {
                zzbvf = new zzbve(this.zza, zzbvh.zzb).zza();
                zzbvi zzbvi = this.zzb;
                zzbvi.zza.put(this.zza, new zzbvh(zzbvi, zzbvf));
                return zzbvf;
            }
        }
        zzbvf = new zzbve(this.zza).zza();
        zzbvi zzbvi2 = this.zzb;
        zzbvi2.zza.put(this.zza, new zzbvh(zzbvi2, zzbvf));
        return zzbvf;
    }
}
