package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbxv extends zzbyb {
    private final Clock zzb;
    private final zzhfl zzc;
    private final zzhfl zzd;
    private final zzhfl zze;
    private final zzhfl zzf;
    private final zzhfl zzg;
    private final zzhfl zzh;
    private final zzhfl zzi;
    private final zzhfl zzj;

    public /* synthetic */ zzbxv(Context context, Clock clock, zzg zzg2, zzbya zzbya, zzbxu zzbxu) {
        this.zzb = clock;
        zzhfc zza = zzhfd.zza(context);
        this.zzc = zza;
        zzhfc zza2 = zzhfd.zza(zzg2);
        this.zzd = zza2;
        this.zze = zzhfb.zzc(new zzbxn(zza, zza2));
        zzhfc zza3 = zzhfd.zza(clock);
        this.zzf = zza3;
        zzhfc zza4 = zzhfd.zza(zzbya);
        this.zzg = zza4;
        zzhfl zzc2 = zzhfb.zzc(new zzbxp(zza3, zza2, zza4));
        this.zzh = zzc2;
        zzbxr zzbxr = new zzbxr(zza3, zzc2);
        this.zzi = zzbxr;
        this.zzj = zzhfb.zzc(new zzbyg(zza, zzbxr));
    }

    public final zzbxm zza() {
        return (zzbxm) this.zze.zzb();
    }

    public final zzbxq zzb() {
        return new zzbxq(this.zzb, (zzbxo) this.zzh.zzb());
    }

    public final zzbyf zzc() {
        return (zzbyf) this.zzj.zzb();
    }
}
