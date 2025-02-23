package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzdhe implements zzcrx {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;
    private final zzhfu zzd;
    private final zzdjm zze;

    public zzdhe(Map map, Map map2, Map map3, zzhfu zzhfu, zzdjm zzdjm) {
        this.zza = map;
        this.zzb = map2;
        this.zzc = map3;
        this.zzd = zzhfu;
        this.zze = zzdjm;
    }

    public final zzeet zza(int i, String str) {
        zzeet zzeet;
        zzeet zzeet2 = (zzeet) this.zza.get(str);
        if (zzeet2 != null) {
            return zzeet2;
        }
        if (i != 1) {
            if (i != 4) {
                return null;
            }
            zzehh zzehh = (zzehh) this.zzc.get(str);
            if (zzehh != null) {
                return new zzeeu(zzehh, new zzcrz());
            }
            zzeet = (zzeet) this.zzb.get(str);
            if (zzeet == null) {
                return null;
            }
        } else if (this.zze.zze() == null || (zzeet = ((zzcrx) this.zzd.zzb()).zza(i, str)) == null) {
            return null;
        }
        return new zzeeu(zzeet, new zzcsa());
    }
}
