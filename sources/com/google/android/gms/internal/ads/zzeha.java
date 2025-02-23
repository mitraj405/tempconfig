package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzbs;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeha implements zzeez {
    private final Context zza;
    private final zzdgp zzb;
    private final VersionInfoParcel zzc;
    private final Executor zzd;

    public zzeha(Context context, VersionInfoParcel versionInfoParcel, zzdgp zzdgp, Executor executor) {
        this.zza = context;
        this.zzc = versionInfoParcel;
        this.zzb = zzdgp;
        this.zzd = executor;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfex zzfex, zzfel zzfel, zzeew zzeew) throws zzffn, zzeir {
        zzdfp zze = this.zzb.zze(new zzcsk(zzfex, zzfel, zzeew.zza), new zzdfs(new zzegz(this, zzeew), (zzcej) null));
        zze.zzd().zzo(new zzcmy((zzfge) zzeew.zzb), this.zzd);
        ((zzegp) zzeew.zzc).zzc(zze.zzk());
        return zze.zzg();
    }

    public final void zzb(zzfex zzfex, zzfel zzfel, zzeew zzeew) throws zzffn {
        zzffg zzffg = zzfex.zza.zza;
        ((zzfge) zzeew.zzb).zzo(this.zza, zzffg.zzd, zzfel.zzv.toString(), zzbs.zzm(zzfel.zzs), (zzbos) zzeew.zzc);
    }

    public final /* synthetic */ void zzc(zzeew zzeew, boolean z, Context context, zzcxd zzcxd) throws zzdgw {
        try {
            ((zzfge) zzeew.zzb).zzv(z);
            if (this.zzc.clientJarVersion < ((Integer) zzba.zzc().zza(zzbbw.zzaz)).intValue()) {
                ((zzfge) zzeew.zzb).zzx();
            } else {
                ((zzfge) zzeew.zzb).zzy(context);
            }
        } catch (zzffn e) {
            zzm.zzi("Cannot show interstitial.");
            throw new zzdgw(e.getCause());
        }
    }
}
