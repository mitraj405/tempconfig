package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzehe implements zzeez {
    private final Context zza;
    private final zzdgp zzb;

    public zzehe(Context context, zzdgp zzdgp) {
        this.zza = context;
        this.zzb = zzdgp;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfex zzfex, zzfel zzfel, zzeew zzeew) throws zzffn, zzeir {
        zzegy zzegy = new zzegy(zzfel, (zzbql) zzeew.zzb, AdFormat.INTERSTITIAL);
        zzdfp zze = this.zzb.zze(new zzcsk(zzfex, zzfel, zzeew.zza), new zzdfs(zzegy, (zzcej) null));
        zzegy.zzb(zze.zzc());
        ((zzegp) zzeew.zzc).zzc(zze.zzj());
        return zze.zzg();
    }

    public final void zzb(zzfex zzfex, zzfel zzfel, zzeew zzeew) throws zzffn {
        try {
            ((zzbql) zzeew.zzb).zzq(zzfel.zzZ);
            ((zzbql) zzeew.zzb).zzl(zzfel.zzU, zzfel.zzv.toString(), zzfex.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzehd(this, zzeew, (zzehc) null), (zzbos) zzeew.zzc);
        } catch (RemoteException e) {
            zze.zzb("Remote exception loading a interstitial RTB ad", e);
            throw new zzffn(e);
        }
    }
}
