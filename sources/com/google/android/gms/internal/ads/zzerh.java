package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzerh implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzerh(zzhfu zzhfu, zzhfu zzhfu2) {
        this.zza = zzhfu;
        this.zzb = zzhfu2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfxw zzfxw;
        zzesi zza2 = ((zzesk) this.zza).zzb();
        Context zza3 = ((zzcgp) this.zzb).zza();
        if (((Boolean) zzba.zzc().zza(zzbbw.zzkw)).booleanValue()) {
            zzu.zzp();
            if (zzt.zzB(zza3)) {
                zzfxw = zzfxw.zzo(zza2);
                zzhfk.zzb(zzfxw);
                return zzfxw;
            }
        }
        zzfxw = zzfxw.zzn();
        zzhfk.zzb(zzfxw);
        return zzfxw;
    }
}
