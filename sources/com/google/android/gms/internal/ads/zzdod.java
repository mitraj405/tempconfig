package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.overlay.zzaa;
import com.google.android.gms.ads.internal.overlay.zzp;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdod extends zzdnn implements zzdeq {
    private zzdeq zza;

    public final synchronized void zzdG() {
        zzdeq zzdeq = this.zza;
        if (zzdeq != null) {
            zzdeq.zzdG();
        }
    }

    public final synchronized void zzdf() {
        zzdeq zzdeq = this.zza;
        if (zzdeq != null) {
            zzdeq.zzdf();
        }
    }

    public final synchronized void zzi(zza zza2, zzbhn zzbhn, zzp zzp, zzbhp zzbhp, zzaa zzaa, zzdeq zzdeq) {
        super.zzh(zza2, zzbhn, zzp, zzbhp, zzaa);
        this.zza = zzdeq;
    }
}
