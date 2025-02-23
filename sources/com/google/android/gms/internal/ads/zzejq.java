package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzejq implements zzeet {
    private final Context zza;
    private final zzdpl zzb;
    private final zzdou zzc;
    private final zzffg zzd;
    private final Executor zze;
    private final VersionInfoParcel zzf;
    private final zzbja zzg;
    private final boolean zzh = ((Boolean) zzba.zzc().zza(zzbbw.zzhZ)).booleanValue();
    private final zzeds zzi;

    public zzejq(Context context, VersionInfoParcel versionInfoParcel, zzffg zzffg, Executor executor, zzdou zzdou, zzdpl zzdpl, zzbja zzbja, zzeds zzeds) {
        this.zza = context;
        this.zzd = zzffg;
        this.zzc = zzdou;
        this.zze = executor;
        this.zzf = versionInfoParcel;
        this.zzb = zzdpl;
        this.zzg = zzbja;
        this.zzi = zzeds;
    }

    public final ListenableFuture zza(zzfex zzfex, zzfel zzfel) {
        zzdpp zzdpp = new zzdpp();
        ListenableFuture zzn = zzgcj.zzn(zzgcj.zzh((Object) null), new zzejj(this, zzfel, zzfex, zzdpp), this.zze);
        zzn.addListener(new zzejk(zzdpp), this.zze);
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
        zzcej zza2 = this.zzb.zza(this.zzd.zze, zzfel2, zzfex2.zzb.zzb);
        zza2.zzac(zzfel2.zzW);
        zzdpp.zza(this.zza, (View) zza2);
        zzbzt zzbzt = new zzbzt();
        zzcsk zzcsk = new zzcsk(zzfex2, zzfel2, (String) null);
        Context context = this.zza;
        zzdpl zzdpl = this.zzb;
        zzbja zzbja2 = this.zzg;
        zzbja zzbja3 = zzbja2;
        zzejp zzejp = r1;
        zzejp zzejp2 = new zzejp(context, zzdpl, this.zzd, this.zzf, zzfel, zzbzt, zza2, zzbja3, this.zzh, this.zzi);
        zzdoq zze2 = this.zzc.zze(zzcsk, new zzdor(zzejp, zza2));
        zzbzt.zzc(zze2);
        zzbjp.zzb(zza2, zze2.zzg());
        zze2.zzc().zzo(new zzejl(zza2), zzbzo.zzf);
        zzdpk zzl = zze2.zzl();
        if (this.zzh) {
            zzbja = this.zzg;
        } else {
            zzbja = null;
        }
        zzl.zzi(zza2, true, zzbja);
        zzfel zzfel3 = zzfel;
        String str = zzfel3.zzs.zza;
        if (((Boolean) zzba.zzc().zza(zzbbw.zzeC)).booleanValue() && zze2.zzm().zze(true)) {
            str = zzcfu.zzb(str, zzcfu.zza(zzfel));
        }
        zze2.zzl();
        return zzgcj.zzm(zzdpk.zzj(zza2, zzfel3.zzs.zzb, str), new zzejm(this, zza2, zzfel3, zze2), this.zze);
    }
}
