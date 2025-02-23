package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzefm implements zzeez {
    private final Context zza;
    private final zzcoy zzb;

    public zzefm(Context context, zzcoy zzcoy) {
        this.zza = context;
        this.zzb = zzcoy;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfex zzfex, zzfel zzfel, zzeew zzeew) throws zzffn, zzeir {
        zzegy zzegy = new zzegy(zzfel, (zzbql) zzeew.zzb, AdFormat.APP_OPEN_AD);
        zzcov zza2 = this.zzb.zza(new zzcsk(zzfex, zzfel, zzeew.zza), new zzdfs(zzegy, (zzcej) null), new zzcow(zzfel.zzaa));
        zzegy.zzb(zza2.zzc());
        ((zzegp) zzeew.zzc).zzc(zza2.zzj());
        return zza2.zza();
    }

    public final void zzb(zzfex zzfex, zzfel zzfel, zzeew zzeew) throws zzffn {
        try {
            ((zzbql) zzeew.zzb).zzq(zzfel.zzZ);
            ((zzbql) zzeew.zzb).zzi(zzfel.zzU, zzfel.zzv.toString(), zzfex.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzefl(zzeew, (zzefk) null), (zzbos) zzeew.zzc);
        } catch (RemoteException e) {
            zze.zzb("Remote exception loading an app open RTB ad", e);
            throw new zzffn(e);
        }
    }
}
