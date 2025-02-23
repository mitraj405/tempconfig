package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzffs {
    private final zzfel zza;
    private final zzfeo zzb;
    private final zzedh zzc;
    private final zzfll zzd;
    private final zzfkf zze;
    private final zzcni zzf;

    public zzffs(zzedh zzedh, zzfll zzfll, zzfel zzfel, zzfeo zzfeo, zzcni zzcni, zzfkf zzfkf) {
        this.zza = zzfel;
        this.zzb = zzfeo;
        this.zzc = zzedh;
        this.zzd = zzfll;
        this.zzf = zzcni;
        this.zze = zzfkf;
    }

    public final void zza(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzb((String) it.next(), 2);
        }
    }

    public final void zzb(String str, int i) {
        if (!this.zza.zzai) {
            this.zzd.zzc(str, this.zze);
            return;
        }
        this.zzc.zzd(new zzedj(zzu.zzB().currentTimeMillis(), this.zzb.zzb, str, i));
    }

    public final void zzc(List list, int i) {
        ListenableFuture listenableFuture;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!((Boolean) zzba.zzc().zza(zzbbw.zzjg)).booleanValue() || !zzcni.zzj(str)) {
                listenableFuture = zzgcj.zzh(str);
            } else {
                listenableFuture = this.zzf.zzb(str, zzay.zze());
            }
            zzgcj.zzr(listenableFuture, new zzffr(this, i), zzbzo.zza);
        }
    }
}
