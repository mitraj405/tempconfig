package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzcb;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.nonagon.signalgeneration.zzak;
import com.google.android.gms.ads.nonagon.signalgeneration.zzl;
import com.google.android.gms.ads.nonagon.signalgeneration.zzr;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public abstract class zzcgj implements zzclv {
    private static zzcgj zza;

    private static synchronized zzcgj zzD(Context context, zzbom zzbom, int i, boolean z, int i2, zzchn zzchn) {
        synchronized (zzcgj.class) {
            zzcgj zzcgj = zza;
            if (zzcgj != null) {
                return zzcgj;
            }
            long currentTimeMillis = zzu.zzB().currentTimeMillis();
            zzbbw.zza(context);
            if (((Boolean) zzbdk.zze.zze()).booleanValue()) {
                zzbbg.zzd(context);
            }
            zzfgc zzd = zzfgc.zzd(context);
            VersionInfoParcel zzc = zzd.zzc(242402000, false, i2);
            zzd.zzf(zzbom);
            zzcjb zzcjb = new zzcjb((zzcja) null);
            zzcgk zzcgk = new zzcgk();
            zzcgk.zzf(zzc);
            zzcgk.zze(context);
            zzcgk.zzd(currentTimeMillis);
            zzcjb.zzb(new zzcgm(zzcgk, (zzcgl) null));
            zzcjb.zzc(new zzcko(zzchn));
            zzcgj zza2 = zzcjb.zza();
            zzu.zzo().zzu(context, zzc);
            zzu.zzc().zzi(context);
            zzu.zzp().zzl(context);
            zzu.zzp().zzk(context);
            zzd.zza(context);
            zzu.zzb().zzd(context);
            zzu.zzv().zzb(context);
            zza2.zza().zzc();
            zzbyb.zzd(context);
            if (((Boolean) zzba.zzc().zza(zzbbw.zzfB)).booleanValue()) {
                if (!((Boolean) zzba.zzc().zza(zzbbw.zzap)).booleanValue()) {
                    new zzecu(context, zzc, new zzbav(new zzbbb(context)), new zzebz(new zzebv(context), zza2.zzA())).zzb(zzu.zzo().zzi().zzS());
                }
            }
            zza = zza2;
            return zza2;
        }
    }

    public static zzcgj zzb(Context context, zzbom zzbom, int i) {
        return zzD(context, zzbom, 242402000, false, i, new zzchn());
    }

    public abstract zzgcu zzA();

    public abstract Executor zzB();

    public abstract ScheduledExecutorService zzC();

    public abstract zzcb zza();

    public abstract zzcky zzc();

    public abstract zzcox zzd();

    public abstract zzcqk zze();

    public abstract zzczj zzf();

    public abstract zzdgo zzg();

    public abstract zzdhk zzh();

    public abstract zzdot zzi();

    public abstract zzdsk zzj();

    public abstract zzdtt zzk();

    public abstract zzdvi zzl();

    public abstract zzdwf zzm();

    public abstract zzeds zzn();

    public abstract zzl zzo();

    public abstract zzr zzp();

    public abstract zzak zzq();

    public final zzewr zzr(zzbvb zzbvb, int i) {
        return zzs(new zzeyq(zzbvb, i));
    }

    public abstract zzewr zzs(zzeyq zzeyq);

    public abstract zzezl zzt();

    public abstract zzfaz zzu();

    public abstract zzfcq zzv();

    public abstract zzfee zzw();

    public abstract zzffv zzx();

    public abstract zzfgf zzy();

    public abstract zzfki zzz();
}
