package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzfk;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.zzau;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzefu implements zzeet {
    private final zzcql zza;
    private final Context zzb;
    private final zzdpl zzc;
    private final zzffg zzd;
    private final Executor zze;
    private final zzful zzf;

    public zzefu(zzcql zzcql, Context context, Executor executor, zzdpl zzdpl, zzffg zzffg, zzful zzful) {
        this.zzb = context;
        this.zza = zzcql;
        this.zze = executor;
        this.zzc = zzdpl;
        this.zzd = zzffg;
        this.zzf = zzful;
    }

    public final ListenableFuture zza(zzfex zzfex, zzfel zzfel) {
        return zzgcj.zzn(zzgcj.zzh((Object) null), new zzeft(this, zzfex, zzfel), this.zze);
    }

    public final boolean zzb(zzfex zzfex, zzfel zzfel) {
        zzfeq zzfeq = zzfel.zzs;
        if (zzfeq == null || zzfeq.zza == null) {
            return false;
        }
        return true;
    }

    public final /* synthetic */ ListenableFuture zzc(zzfex zzfex, zzfel zzfel, Object obj) throws Exception {
        View view;
        zzq zza2 = zzffm.zza(this.zzb, zzfel.zzu);
        zzcej zza3 = this.zzc.zza(zza2, zzfel, zzfex.zzb.zzb);
        zza3.zzac(zzfel.zzW);
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzgZ)).booleanValue() || !zzfel.zzag) {
            view = new zzdpo(this.zzb, (View) zza3, (zzau) this.zzf.apply(zzfel));
        } else {
            view = zzcrg.zza(this.zzb, (View) zza3, zzfel);
        }
        zzcpl zza4 = this.zza.zza(new zzcsk(zzfex, zzfel, (String) null), new zzcpr(view, zza3, new zzefo(zza3), zzffm.zzb(zza2)));
        zza4.zzh().zzi(zza3, false, (zzbja) null);
        zzcxi zzc2 = zza4.zzc();
        zzefp zzefp = new zzefp(zza3);
        zzgcu zzgcu = zzbzo.zzf;
        zzc2.zzo(zzefp, zzgcu);
        String str = zzfel.zzs.zza;
        if (((Boolean) zzba.zzc().zza(zzbbw.zzeC)).booleanValue() && zza4.zzi().zze(true)) {
            str = zzcfu.zzb(str, zzcfu.zza(zzfel));
        }
        zza4.zzh();
        ListenableFuture zzj = zzdpk.zzj(zza3, zzfel.zzs.zzb, str);
        if (zzfel.zzM) {
            zzj.addListener(new zzefq(zza3), this.zze);
        }
        zzj.addListener(new zzefr(this, zza3), this.zze);
        return zzgcj.zzm(zzj, new zzefs(zza4), zzgcu);
    }

    public final /* synthetic */ void zzd(zzcej zzcej) {
        zzcej.zzab();
        zzcfl zzq = zzcej.zzq();
        zzfk zzfk = this.zzd.zza;
        if (!(zzfk == null || zzq == null)) {
            zzq.zzs(zzfk);
        }
        if (((Boolean) zzba.zzc().zza(zzbbw.zzaZ)).booleanValue() && !zzcej.isAttachedToWindow()) {
            zzcej.onPause();
            zzcej.zzav(true);
        }
    }
}
