package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.nonagon.signalgeneration.zzan;
import com.google.android.gms.ads.nonagon.signalgeneration.zzr;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeuv implements zzevo {
    private final String zza;
    private final zzgcu zzb;
    private final ScheduledExecutorService zzc;
    private final Context zzd;
    private final zzffg zze;
    private final zzcgj zzf;

    public zzeuv(zzgcu zzgcu, ScheduledExecutorService scheduledExecutorService, String str, Context context, zzffg zzffg, zzcgj zzcgj) {
        this.zzb = zzgcu;
        this.zzc = scheduledExecutorService;
        this.zza = str;
        this.zzd = context;
        this.zze = zzffg;
        this.zzf = zzcgj;
    }

    public static /* synthetic */ ListenableFuture zzc(zzeuv zzeuv) {
        zzr zzp = zzeuv.zzf.zzp();
        zzcvy zzcvy = new zzcvy();
        zzcvy.zze(zzeuv.zzd);
        zzffe zzffe = new zzffe();
        zzffe.zzt("adUnitId");
        zzffe.zzH(zzeuv.zze.zzd);
        zzffe.zzs(new zzq());
        zzffe.zzz(true);
        zzcvy.zzi(zzffe.zzJ());
        zzp.zza(zzcvy.zzj());
        zzan zzan = new zzan();
        zzan.zza(zzeuv.zza);
        zzp.zzb(zzan.zzb());
        new zzdci();
        return zzgcj.zze(zzgcj.zzm((zzgca) zzgcj.zzo(zzgca.zzu(zzp.zzc().zzb()), ((Long) zzba.zzc().zza(zzbbw.zzgt)).longValue(), TimeUnit.MILLISECONDS, zzeuv.zzc), new zzeus(), zzeuv.zzb), Exception.class, new zzeut(), zzeuv.zzb);
    }

    public final int zza() {
        return 33;
    }

    public final ListenableFuture zzb() {
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzgs)).booleanValue() || this.zze.zzr) {
            return zzgcj.zzh(new zzeuw((String) null));
        }
        return zzgcj.zzk(new zzeuu(this), this.zzb);
    }
}
