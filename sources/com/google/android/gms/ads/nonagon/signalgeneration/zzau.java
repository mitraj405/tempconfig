package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzcvv;
import com.google.android.gms.internal.ads.zzdff;
import com.google.android.gms.internal.ads.zzfiq;
import com.google.android.gms.internal.ads.zzfjf;
import com.google.android.gms.internal.ads.zzfjl;
import com.google.android.gms.internal.ads.zzgcj;
import com.google.android.gms.internal.ads.zzhfc;
import com.google.android.gms.internal.ads.zzhfu;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzau implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;
    private final zzhfu zzd;

    public zzau(zzhfu zzhfu, zzhfu zzhfu2, zzhfu zzhfu3, zzhfu zzhfu4) {
        this.zza = zzhfu;
        this.zzb = zzhfu2;
        this.zzc = zzhfu3;
        this.zzd = zzhfu4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfiq zza2 = ((zzfjl) this.zza.zzb()).zzb(zzfjf.GENERATE_SIGNALS, ((zzcvv) this.zzc).zzb().zzc()).zzf(((zzax) this.zzb).zzb()).zzi((long) ((Integer) zzba.zzc().zza(zzbbw.zzeU)).intValue(), TimeUnit.SECONDS).zza();
        zzgcj.zzr(zza2, new zzam((zzdff) this.zzd.zzb()), zzbzo.zza);
        return zza2;
    }
}
