package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzefe implements zzeet {
    private final zzcoy zza;
    private final Context zzb;
    private final zzdpl zzc;
    private final zzffg zzd;
    private final Executor zze;
    private final VersionInfoParcel zzf;
    private final zzbja zzg;
    private final boolean zzh = ((Boolean) zzba.zzc().zza(zzbbw.zzhZ)).booleanValue();
    private final zzeds zzi;

    public zzefe(zzcoy zzcoy, Context context, Executor executor, zzdpl zzdpl, zzffg zzffg, VersionInfoParcel versionInfoParcel, zzbja zzbja, zzeds zzeds) {
        this.zzb = context;
        this.zza = zzcoy;
        this.zze = executor;
        this.zzc = zzdpl;
        this.zzd = zzffg;
        this.zzf = versionInfoParcel;
        this.zzg = zzbja;
        this.zzi = zzeds;
    }

    public final ListenableFuture zza(zzfex zzfex, zzfel zzfel) {
        zzdpp zzdpp = new zzdpp();
        ListenableFuture zzn = zzgcj.zzn(zzgcj.zzh((Object) null), new zzefa(this, zzfel, zzfex, zzdpp), this.zze);
        zzn.addListener(new zzefb(zzdpp), this.zze);
        return zzn;
    }

    public final boolean zzb(zzfex zzfex, zzfel zzfel) {
        zzfeq zzfeq = zzfel.zzs;
        if (zzfeq == null || zzfeq.zza == null) {
            return false;
        }
        return true;
    }

    public final /* synthetic */ ListenableFuture zzc(zzfel zzfel, zzfex zzfex, zzdpp zzdpp, Object obj) throws Exception {
        zzbja zzbja;
        zzfel zzfel2 = zzfel;
        zzfex zzfex2 = zzfex;
        zzcej zza2 = this.zzc.zza(this.zzd.zze, zzfel2, zzfex2.zzb.zzb);
        zza2.zzac(zzfel2.zzW);
        zzdpp.zza(this.zzb, (View) zza2);
        zzbzt zzbzt = new zzbzt();
        zzcsk zzcsk = new zzcsk(zzfex2, zzfel2, (String) null);
        zzffg zzffg = this.zzd;
        boolean z = this.zzh;
        zzbja zzbja2 = this.zzg;
        zzefg zzefg = r1;
        zzefg zzefg2 = new zzefg(this.zzf, zzbzt, zzfel, zza2, zzffg, z, zzbja2, this.zzi);
        zzcov zza3 = this.zza.zza(zzcsk, new zzdfs(zzefg, zza2), new zzcow(zzfel2.zzaa));
        zzdpk zzh2 = zza3.zzh();
        if (this.zzh) {
            zzbja = this.zzg;
        } else {
            zzbja = null;
        }
        zzh2.zzi(zza2, false, zzbja);
        zzbzt.zzc(zza3);
        zza3.zzc().zzo(new zzefc(zza2), zzbzo.zzf);
        String str = zzfel2.zzs.zza;
        if (((Boolean) zzba.zzc().zza(zzbbw.zzeC)).booleanValue() && zza3.zzi().zze(true)) {
            str = zzcfu.zzb(str, zzcfu.zza(zzfel));
        }
        zza3.zzh();
        return zzgcj.zzm(zzdpk.zzj(zza2, zzfel2.zzs.zzb, str), new zzefd(this, zza2, zzfel2, zza3), this.zze);
    }
}
