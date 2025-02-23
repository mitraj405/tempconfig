package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfcf implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;

    public zzfcf(zzhfu zzhfu, zzhfu zzhfu2, zzhfu zzhfu3) {
        this.zza = zzhfu;
        this.zzb = zzhfu2;
        this.zzc = zzhfu3;
    }

    /* renamed from: zza */
    public final zzfcc zzb() {
        zzbyy zzbyy;
        Context context = (Context) this.zza.zzb();
        zzfgq zzfgq = (zzfgq) this.zzb.zzb();
        zzfhi zzfhi = (zzfhi) this.zzc.zzb();
        if (((Boolean) zzba.zzc().zza(zzbbw.zzfG)).booleanValue()) {
            zzbyy = zzu.zzo().zzi().zzh();
        } else {
            zzbyy = zzu.zzo().zzi().zzi();
        }
        boolean z = false;
        if (zzbyy != null && zzbyy.zzh()) {
            z = true;
        }
        if (((Integer) zzba.zzc().zza(zzbbw.zzfI)).intValue() > 0) {
            if (!((Boolean) zzba.zzc().zza(zzbbw.zzfF)).booleanValue() || z) {
                zzfhh zza2 = zzfhi.zza(zzfgy.Rewarded, context, zzfgq, new zzfbg(new zzfbd()));
                zzfbs zzfbs = new zzfbs(new zzfbr());
                zzfgu zzfgu = zza2.zza;
                zzgcu zzgcu = zzbzo.zza;
                return new zzfbi(zzfbs, new zzfbo(zzfgu, zzgcu), zza2.zzb, zza2.zza.zza().zzf, zzgcu);
            }
        }
        return new zzfbr();
    }
}
