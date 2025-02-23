package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzchx extends zzexg {
    private final zzeyj zza;
    private final zzcif zzb;
    private final zzhfl zzc;
    private final zzhfl zzd;
    private final zzhfl zze;
    private final zzhfl zzf;
    private final zzhfl zzg;
    private final zzhfl zzh;
    private final zzhfl zzi;
    private final zzhfl zzj;
    private final zzhfl zzk;
    private final zzhfl zzl;
    private final zzhfl zzm;

    public /* synthetic */ zzchx(zzcif zzcif, zzeyj zzeyj, zzchw zzchw) {
        this.zzb = zzcif;
        this.zza = zzeyj;
        zzeyl zzeyl = new zzeyl(zzeyj);
        this.zzc = zzeyl;
        zzhfl zzc2 = zzhfb.zzc(zzdrf.zza());
        this.zzd = zzc2;
        zzhfl zzc3 = zzhfb.zzc(zzdrd.zza());
        this.zze = zzc3;
        zzhfl zzc4 = zzhfb.zzc(zzdrh.zza());
        this.zzf = zzc4;
        zzhfl zzc5 = zzhfb.zzc(zzdrj.zza());
        this.zzg = zzc5;
        zzhff zzc6 = zzhfg.zzc(4);
        zzc6.zzb(zzfjf.GMS_SIGNALS, zzc2);
        zzc6.zzb(zzfjf.BUILD_URL, zzc3);
        zzc6.zzb(zzfjf.HTTP, zzc4);
        zzc6.zzb(zzfjf.PRE_PROCESS, zzc5);
        zzhfg zzc7 = zzc6.zzc();
        this.zzh = zzc7;
        zzhfl zzc8 = zzhfb.zzc(new zzdrk(zzeyl, zzcif.zzh, zzfig.zza(), zzc7));
        this.zzi = zzc8;
        zzhfp zza2 = zzhfq.zza(0, 1);
        zza2.zza(zzc8);
        zzhfq zzc9 = zza2.zzc();
        this.zzj = zzc9;
        zzfjo zzfjo = new zzfjo(zzc9);
        this.zzk = zzfjo;
        this.zzl = zzhfb.zzc(new zzfjn(zzfig.zza(), zzcif.zze, zzfjo));
        this.zzm = zzhfb.zzc(new zzfkg(zzcif.zzz));
    }

    public final zzevr zza() {
        Context zzb2 = this.zzb.zza.zzb();
        zzhfk.zzb(zzb2);
        zzbys zzbys = new zzbys();
        zzgcu zzgcu = zzbzo.zza;
        zzhfk.zzb(zzgcu);
        zzeyd zzeyd = new zzeyd(zzbys, zzgcu, zzeyk.zza(this.zza));
        zzhfk.zzb(zzgcu);
        HashSet hashSet = new HashSet();
        hashSet.add(new zzetw(zzeyd, 0, (ScheduledExecutorService) this.zzb.zze.zzb()));
        return new zzevr(zzb2, zzgcu, hashSet, (zzfkf) this.zzm.zzb(), (zzdsk) this.zzb.zzM.zzb());
    }

    public final zzfjl zzb() {
        return (zzfjl) this.zzl.zzb();
    }
}
