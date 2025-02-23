package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzegw implements zzeet {
    private final Context zza;
    private final zzdpl zzb;
    private final zzdgp zzc;
    private final zzffg zzd;
    private final Executor zze;
    private final VersionInfoParcel zzf;
    private final zzbja zzg;
    private final boolean zzh = ((Boolean) zzba.zzc().zza(zzbbw.zzhZ)).booleanValue();
    private final zzeds zzi;

    public zzegw(Context context, VersionInfoParcel versionInfoParcel, zzffg zzffg, Executor executor, zzdgp zzdgp, zzdpl zzdpl, zzbja zzbja, zzeds zzeds) {
        this.zza = context;
        this.zzd = zzffg;
        this.zzc = zzdgp;
        this.zze = executor;
        this.zzf = versionInfoParcel;
        this.zzb = zzdpl;
        this.zzg = zzbja;
        this.zzi = zzeds;
    }

    public final ListenableFuture zza(zzfex zzfex, zzfel zzfel) {
        zzdpp zzdpp = new zzdpp();
        ListenableFuture zzn = zzgcj.zzn(zzgcj.zzh((Object) null), new zzegt(this, zzfel, zzfex, zzdpp), this.zze);
        zzn.addListener(new zzegu(zzdpp), this.zze);
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
        zzffg zzffg = this.zzd;
        boolean z = this.zzh;
        Context context = this.zza;
        zzbja zzbja2 = this.zzg;
        zzbja zzbja3 = zzbja2;
        zzegv zzegv = r1;
        zzegv zzegv2 = new zzegv(context, this.zzf, zzbzt, zzfel, zza2, zzffg, z, zzbja3, this.zzi);
        zzdfp zze2 = this.zzc.zze(zzcsk, new zzdfs(zzegv, zza2));
        zzbzt.zzc(zze2);
        zze2.zzc().zzo(new zzegr(zza2), zzbzo.zzf);
        zzfel zzfel3 = zzfel;
        String str = zzfel3.zzs.zza;
        if (((Boolean) zzba.zzc().zza(zzbbw.zzeC)).booleanValue() && zze2.zzl().zze(true)) {
            str = zzcfu.zzb(str, zzcfu.zza(zzfel));
        }
        zzdpk zzi2 = zze2.zzi();
        if (this.zzh) {
            zzbja = this.zzg;
        } else {
            zzbja = null;
        }
        zzi2.zzi(zza2, true, zzbja);
        zze2.zzi();
        return zzgcj.zzm(zzdpk.zzj(zza2, zzfel3.zzs.zzb, str), new zzegs(this, zza2, zzfel3, zze2), this.zze);
    }
}
