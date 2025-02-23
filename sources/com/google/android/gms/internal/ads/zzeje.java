package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeje implements zzeez {
    private final Context zza;
    private final zzdou zzb;

    public zzeje(Context context, zzdou zzdou) {
        this.zza = context;
        this.zzb = zzdou;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfex zzfex, zzfel zzfel, zzeew zzeew) throws zzffn, zzeir {
        zzegy zzegy = new zzegy(zzfel, (zzbql) zzeew.zzb, AdFormat.REWARDED);
        zzdoq zze = this.zzb.zze(new zzcsk(zzfex, zzfel, zzeew.zza), new zzdor(zzegy));
        zzegy.zzb(zze.zzc());
        ((zzegp) zzeew.zzc).zzc(zze.zzo());
        return zze.zzi();
    }

    public final void zzb(zzfex zzfex, zzfel zzfel, zzeew zzeew) throws zzffn {
        try {
            ((zzbql) zzeew.zzb).zzq(zzfel.zzZ);
            if (zzfex.zza.zza.zzo.zza == 3) {
                ((zzbql) zzeew.zzb).zzo(zzfel.zzU, zzfel.zzv.toString(), zzfex.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzejd(this, zzeew, (zzejc) null), (zzbos) zzeew.zzc);
            } else {
                ((zzbql) zzeew.zzb).zzp(zzfel.zzU, zzfel.zzv.toString(), zzfex.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzejd(this, zzeew, (zzejc) null), (zzbos) zzeew.zzc);
            }
        } catch (RemoteException e) {
            zze.zzb("Remote exception loading a rewarded RTB ad", e);
        }
    }
}
