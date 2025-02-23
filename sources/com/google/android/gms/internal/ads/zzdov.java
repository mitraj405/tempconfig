package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdov implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;

    public zzdov(zzhfu zzhfu, zzhfu zzhfu2, zzhfu zzhfu3) {
        this.zza = zzhfu;
        this.zzb = zzhfu2;
        this.zzc = zzhfu3;
    }

    public final /* synthetic */ Object zzb() {
        int i = ((zzcwh) this.zzc).zza().zzo.zza;
        if (i == 0) {
            throw null;
        } else if (i - 1 != 0) {
            return ((zzekg) this.zzb).zzb();
        } else {
            return ((zzekg) this.zza).zzb();
        }
    }
}
