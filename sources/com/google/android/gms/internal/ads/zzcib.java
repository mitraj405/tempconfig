package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzcib extends zzexi {
    private final zzeww zza;
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

    public /* synthetic */ zzcib(zzcif zzcif, zzeww zzeww, zzcia zzcia) {
        this.zzb = zzcif;
        this.zza = zzeww;
        this.zzc = zzhfb.zzc(new zzfkg(zzcif.zzz));
        zzexe zzexe = new zzexe(zzeww);
        this.zzd = zzexe;
        zzhfl zzc2 = zzhfb.zzc(zzdrf.zza());
        this.zze = zzc2;
        zzhfl zzc3 = zzhfb.zzc(zzdrd.zza());
        this.zzf = zzc3;
        zzhfl zzc4 = zzhfb.zzc(zzdrh.zza());
        this.zzg = zzc4;
        zzhfl zzc5 = zzhfb.zzc(zzdrj.zza());
        this.zzh = zzc5;
        zzhff zzc6 = zzhfg.zzc(4);
        zzc6.zzb(zzfjf.GMS_SIGNALS, zzc2);
        zzc6.zzb(zzfjf.BUILD_URL, zzc3);
        zzc6.zzb(zzfjf.HTTP, zzc4);
        zzc6.zzb(zzfjf.PRE_PROCESS, zzc5);
        zzhfg zzc7 = zzc6.zzc();
        this.zzi = zzc7;
        zzhfl zzc8 = zzhfb.zzc(new zzdrk(zzexe, zzcif.zzh, zzfig.zza(), zzc7));
        this.zzj = zzc8;
        zzhfp zza2 = zzhfq.zza(0, 1);
        zza2.zza(zzc8);
        zzhfq zzc9 = zza2.zzc();
        this.zzk = zzc9;
        zzfjo zzfjo = new zzfjo(zzc9);
        this.zzl = zzfjo;
        this.zzm = zzhfb.zzc(new zzfjn(zzfig.zza(), zzcif.zze, zzfjo));
    }

    public final zzevr zza() {
        Context zzb2 = this.zzb.zza.zzb();
        zzhfk.zzb(zzb2);
        zzgcu zzgcu = zzbzo.zza;
        zzhfk.zzb(zzgcu);
        zzbys zzbys = new zzbys();
        zzhfk.zzb(zzgcu);
        zzevo zza2 = zzeyz.zza(new zzeyd(zzbys, zzgcu, zzewx.zza(this.zza)), zzetq.zza(), (ScheduledExecutorService) this.zzb.zze.zzb(), 0);
        Context zzb3 = this.zzb.zza.zzb();
        zzhfk.zzb(zzb3);
        zzevo zzb4 = zzeyz.zzb(new zzeyn(new zzbsr(), (ScheduledExecutorService) this.zzb.zze.zzb(), zzb3), (ScheduledExecutorService) this.zzb.zze.zzb());
        zzbyv zzbyv = new zzbyv();
        Context zzb5 = this.zzb.zza.zzb();
        zzhfk.zzb(zzb5);
        zzhfk.zzb(zzgcu);
        zzeww zzeww = this.zza;
        zzevo zza3 = zzeza.zza(zzewq.zza(zzbyv, zzb5, (ScheduledExecutorService) this.zzb.zze.zzb(), zzgcu, zzewy.zza(zzeww), zzexa.zza(zzeww), zzexb.zza(zzeww)), (ScheduledExecutorService) this.zzb.zze.zzb());
        zzhfk.zzb(zzgcu);
        zzevo zzc2 = zzeyz.zzc(new zzezi(zzgcu), (ScheduledExecutorService) this.zzb.zze.zzb());
        zzeyx zzeyx = new zzeyx();
        zzbak zzbak = new zzbak();
        zzhfk.zzb(zzgcu);
        Context zzb6 = this.zzb.zza.zzb();
        zzhfk.zzb(zzb6);
        zzexv zzexv = new zzexv(zzbak, zzgcu, zzb6);
        Object[] objArr = new zzevo[5];
        zzbbf zzbbf = new zzbbf();
        zzhfk.zzb(zzgcu);
        objArr[0] = new zzeyh(zzbbf, zzgcu, zzewz.zza(this.zza));
        zzbyv zzbyv2 = new zzbyv();
        zzhfk.zzb(zzgcu);
        zzeww zzeww2 = this.zza;
        objArr[1] = new zzewu(zzbyv2, zzgcu, zzexc.zza(zzeww2), zzexd.zza(zzeww2), zzewy.zza(zzeww2));
        zzbyv zzbyv3 = new zzbyv();
        zzeww zzeww3 = this.zza;
        zzcif zzcif = this.zzb;
        int zza4 = zzewy.zza(zzeww3);
        Context zzb7 = zzcif.zza.zzb();
        zzhfk.zzb(zzb7);
        zzhfk.zzb(zzgcu);
        Object[] objArr2 = objArr;
        zzexv zzexv2 = zzexv;
        objArr2[2] = new zzexr(zzbyv3, zza4, zzb7, (zzbze) this.zzb.zzae.zzb(), (ScheduledExecutorService) this.zzb.zze.zzb(), zzgcu, zzewx.zza(this.zza));
        objArr2[3] = (zzevo) this.zzb.zzaL.zzb();
        zzhfk.zzb(zzgcu);
        objArr2[4] = zzexn.zza(zzewx.zza(this.zza), new zzazy(), (zzbze) this.zzb.zzae.zzb(), (ScheduledExecutorService) this.zzb.zze.zzb(), zzgcu);
        return new zzevr(zzb2, zzgcu, zzfxw.zzs(zza2, zzb4, zza3, zzc2, zzeyx, zzexv2, objArr2), (zzfkf) this.zzc.zzb(), (zzdsk) this.zzb.zzM.zzb());
    }

    public final zzfjl zzb() {
        return (zzfjl) this.zzm.zzb();
    }
}
