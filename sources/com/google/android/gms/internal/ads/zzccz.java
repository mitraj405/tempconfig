package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzccz extends zzccv {
    public zzccz(zzcbk zzcbk) {
        super(zzcbk);
    }

    public final boolean zzt(String str) {
        String zzf = zzf.zzf(str);
        zzcbk zzcbk = (zzcbk) this.zzc.get();
        if (!(zzcbk == null || zzf == null)) {
            zzcbk.zzt(zzf, this);
        }
        zzm.zzj("VideoStreamNoopCache is doing nothing.");
        zzg(str, zzf, "noop", "Noop cache is a noop.");
        return false;
    }

    public final void zzf() {
    }
}
