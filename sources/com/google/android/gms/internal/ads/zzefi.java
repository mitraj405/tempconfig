package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzefi implements zzeez {
    private final Context zza;
    private final zzcoy zzb;
    private final Executor zzc;

    public zzefi(Context context, zzcoy zzcoy, Executor executor) {
        this.zza = context;
        this.zzb = zzcoy;
        this.zzc = executor;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfex zzfex, zzfel zzfel, zzeew zzeew) throws zzffn, zzeir {
        zzcov zza2 = this.zzb.zza(new zzcsk(zzfex, zzfel, zzeew.zza), new zzdfs(new zzefh(zzeew), (zzcej) null), new zzcow(zzfel.zzaa));
        zza2.zzd().zzo(new zzcmy((zzfge) zzeew.zzb), this.zzc);
        ((zzegp) zzeew.zzc).zzc(zza2.zzk());
        return zza2.zza();
    }

    public final void zzb(zzfex zzfex, zzfel zzfel, zzeew zzeew) throws zzffn {
        zzffg zzffg = zzfex.zza.zza;
        ((zzfge) zzeew.zzb).zzl(this.zza, zzffg.zzd, zzfel.zzv.toString(), (zzbos) zzeew.zzc);
    }
}
