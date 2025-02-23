package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzcht extends zzewr {
    private final zzeyq zza;
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
    private final zzhfl zzm = new zzezk(zzfig.zza());
    private final zzhfl zzn;
    private final zzhfl zzo;
    private final zzhfl zzp;
    private final zzhfl zzq;
    private final zzhfl zzr;
    private final zzhfl zzs;
    private final zzhfl zzt;
    private final zzhfl zzu;
    private final zzhfl zzv;
    private final zzhfl zzw;
    private final zzhfl zzx;
    private final zzhfl zzy;
    private final zzhfl zzz;

    public /* synthetic */ zzcht(zzcif zzcif, zzeyq zzeyq, zzchs zzchs) {
        zzeyq zzeyq2 = zzeyq;
        this.zzb = zzcif;
        this.zza = zzeyq2;
        this.zzc = zzhfb.zzc(new zzfkg(zzcif.zzz));
        zzeys zzeys = new zzeys(zzeyq2);
        this.zzd = zzeys;
        zzeyt zzeyt = new zzeyt(zzeyq2);
        this.zze = zzeyt;
        zzeyv zzeyv = new zzeyv(zzeyq2);
        this.zzf = zzeyv;
        this.zzg = new zzewq(zzclq.zza, zzcif.zzh, zzcif.zze, zzfig.zza(), zzeys, zzeyt, zzeyv);
        zzeyr zzeyr = new zzeyr(zzeyq2);
        this.zzh = zzeyr;
        this.zzi = new zzext(zzclq.zza, zzeys, zzcif.zzh, zzcif.zzae, zzcif.zze, zzfig.zza(), zzeyr);
        this.zzj = new zzexx(zzclk.zza, zzfig.zza(), zzcif.zzh);
        this.zzk = new zzeyf(zzclm.zza, zzfig.zza(), zzeyr);
        this.zzl = new zzeyp(zzclo.zza, zzcif.zze, zzcif.zzh);
        zzeyu zzeyu = new zzeyu(zzeyq2);
        this.zzn = zzeyu;
        zzeyr zzeyr2 = zzeyr;
        this.zzo = new zzezg(zzcif.zzae, zzeyu, zzeyv, zzcls.zza, zzfig.zza(), zzeyr2, zzcif.zze);
        this.zzp = new zzexn(zzeyr2, zzcli.zza, zzcif.zzae, zzcif.zze, zzfig.zza());
        zzeyw zzeyw = new zzeyw(zzeyq2);
        this.zzq = zzeyw;
        zzhfl zzc2 = zzhfb.zzc(zzdrf.zza());
        this.zzr = zzc2;
        zzhfl zzc3 = zzhfb.zzc(zzdrd.zza());
        this.zzs = zzc3;
        zzhfl zzc4 = zzhfb.zzc(zzdrh.zza());
        this.zzt = zzc4;
        zzhfl zzc5 = zzhfb.zzc(zzdrj.zza());
        this.zzu = zzc5;
        zzhff zzc6 = zzhfg.zzc(4);
        zzc6.zzb(zzfjf.GMS_SIGNALS, zzc2);
        zzc6.zzb(zzfjf.BUILD_URL, zzc3);
        zzc6.zzb(zzfjf.HTTP, zzc4);
        zzc6.zzb(zzfjf.PRE_PROCESS, zzc5);
        zzhfg zzc7 = zzc6.zzc();
        this.zzv = zzc7;
        zzhfl zzc8 = zzhfb.zzc(new zzdrk(zzeyw, zzcif.zzh, zzfig.zza(), zzc7));
        this.zzw = zzc8;
        zzhfp zza2 = zzhfq.zza(0, 1);
        zza2.zza(zzc8);
        zzhfq zzc9 = zza2.zzc();
        this.zzx = zzc9;
        zzfjo zzfjo = new zzfjo(zzc9);
        this.zzy = zzfjo;
        this.zzz = zzhfb.zzc(new zzfjn(zzfig.zza(), zzcif.zze, zzfjo));
    }

    private final zzewu zze() {
        zzbyv zzbyv = new zzbyv();
        zzgcu zzgcu = zzbzo.zza;
        zzhfk.zzb(zzgcu);
        zzeyq zzeyq = this.zza;
        return new zzewu(zzbyv, zzgcu, zzeyq.zzd(), zzeyq.zzb(), zzeyq.zza());
    }

    private final zzeyh zzf() {
        zzbbf zzbbf = new zzbbf();
        zzgcu zzgcu = zzbzo.zza;
        zzhfk.zzb(zzgcu);
        List zzf2 = this.zza.zzf();
        zzhfk.zzb(zzf2);
        return new zzeyh(zzbbf, zzgcu, zzf2);
    }

    public final zzevr zza() {
        Context zzb2 = this.zzb.zza.zzb();
        Context context = zzb2;
        zzhfk.zzb(zzb2);
        zzbys zzbys = r1;
        zzbys zzbys2 = new zzbys();
        zzbyt zzbyt = r1;
        zzbyt zzbyt2 = new zzbyt();
        Object zzb3 = this.zzb.zzaL.zzb();
        zzhfl zzhfl = this.zzp;
        zzhfl zzhfl2 = this.zzo;
        zzhfl zzhfl3 = this.zzm;
        zzhfl zzhfl4 = this.zzl;
        zzhfl zzhfl5 = this.zzk;
        zzhfl zzhfl6 = this.zzj;
        zzhfl zzhfl7 = this.zzi;
        zzhfl zzhfl8 = this.zzg;
        zzewu zze2 = zze();
        zzeyh zzf2 = zzf();
        zzhew zza2 = zzhfb.zza(zzhfl8);
        zzhew zza3 = zzhfb.zza(zzhfl7);
        zzhew zza4 = zzhfb.zza(zzhfl6);
        zzhew zza5 = zzhfb.zza(zzhfl5);
        zzhew zza6 = zzhfb.zza(zzhfl4);
        zzhew zza7 = zzhfb.zza(zzhfl3);
        zzhew zza8 = zzhfb.zza(zzhfl2);
        zzhew zza9 = zzhfb.zza(zzhfl);
        zzgcu zzgcu = zzbzo.zza;
        zzhfk.zzb(zzgcu);
        return zzezb.zza(context, zzbys, zzbyt, zzb3, zze2, zzf2, zza2, zza3, zza4, zza5, zza6, zza7, zza8, zza9, zzgcu, (zzfkf) this.zzc.zzb(), (zzdsk) this.zzb.zzM.zzb());
    }

    public final zzevr zzb() {
        Context zzb2 = this.zzb.zza.zzb();
        zzhfk.zzb(zzb2);
        zzgcu zzgcu = zzbzo.zza;
        zzhfk.zzb(zzgcu);
        zzbys zzbys = new zzbys();
        zzhfk.zzb(zzgcu);
        String zzc2 = this.zza.zzc();
        zzhfk.zzb(zzc2);
        zzevo zza2 = zzeyz.zza(new zzeyd(zzbys, zzgcu, zzc2), zzetq.zza(), (ScheduledExecutorService) this.zzb.zze.zzb(), -1);
        Context zzb3 = this.zzb.zza.zzb();
        zzhfk.zzb(zzb3);
        zzevo zzb4 = zzeyz.zzb(new zzeyn(new zzbsr(), (ScheduledExecutorService) this.zzb.zze.zzb(), zzb3), (ScheduledExecutorService) this.zzb.zze.zzb());
        zzbyv zzbyv = new zzbyv();
        Context zzb5 = this.zzb.zza.zzb();
        zzhfk.zzb(zzb5);
        zzhfk.zzb(zzgcu);
        zzeyq zzeyq = this.zza;
        zzevo zza3 = zzeza.zza(zzewq.zza(zzbyv, zzb5, (ScheduledExecutorService) this.zzb.zze.zzb(), zzgcu, zzeyq.zza(), zzeyt.zzc(zzeyq), zzeyv.zzc(zzeyq)), (ScheduledExecutorService) this.zzb.zze.zzb());
        zzhfk.zzb(zzgcu);
        zzevo zzc3 = zzeyz.zzc(new zzezi(zzgcu), (ScheduledExecutorService) this.zzb.zze.zzb());
        zzeyx zzeyx = new zzeyx();
        zzbak zzbak = new zzbak();
        zzhfk.zzb(zzgcu);
        Context zzb6 = this.zzb.zza.zzb();
        zzhfk.zzb(zzb6);
        zzexv zzexv = new zzexv(zzbak, zzgcu, zzb6);
        zzevo[] zzevoArr = new zzevo[5];
        zzevoArr[0] = zzf();
        zzevoArr[1] = zze();
        zzbyv zzbyv2 = new zzbyv();
        int zza4 = this.zza.zza();
        Context zzb7 = this.zzb.zza.zzb();
        zzhfk.zzb(zzb7);
        zzhfk.zzb(zzgcu);
        String zzc4 = this.zza.zzc();
        zzhfk.zzb(zzc4);
        zzevo[] zzevoArr2 = zzevoArr;
        zzexv zzexv2 = zzexv;
        zzevoArr2[2] = new zzexr(zzbyv2, zza4, zzb7, (zzbze) this.zzb.zzae.zzb(), (ScheduledExecutorService) this.zzb.zze.zzb(), zzgcu, zzc4);
        zzevoArr2[3] = (zzevo) this.zzb.zzaL.zzb();
        String zzc5 = this.zza.zzc();
        zzhfk.zzb(zzc5);
        zzhfk.zzb(zzgcu);
        zzevoArr2[4] = zzexn.zza(zzc5, new zzazy(), (zzbze) this.zzb.zzae.zzb(), (ScheduledExecutorService) this.zzb.zze.zzb(), zzgcu);
        return new zzevr(zzb2, zzgcu, zzfxw.zzs(zza2, zzb4, zza3, zzc3, zzeyx, zzexv2, zzevoArr2), (zzfkf) this.zzc.zzb(), (zzdsk) this.zzb.zzM.zzb());
    }

    public final zzfjl zzc() {
        return (zzfjl) this.zzz.zzb();
    }

    public final zzfkf zzd() {
        return (zzfkf) this.zzc.zzb();
    }
}
