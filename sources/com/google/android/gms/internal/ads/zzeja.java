package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeja implements zzeez {
    private final Context zza;
    private final Executor zzb;
    private final zzdou zzc;

    public zzeja(Context context, Executor executor, zzdou zzdou) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzdou;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfex zzfex, zzfel zzfel, zzeew zzeew) throws zzffn, zzeir {
        zzdoq zze = this.zzc.zze(new zzcsk(zzfex, zzfel, zzeew.zza), new zzdor(new zzeiz(zzeew)));
        zze.zzd().zzo(new zzcmy((zzfge) zzeew.zzb), this.zzb);
        ((zzegp) zzeew.zzc).zzc(zze.zzn());
        return zze.zzi();
    }

    public final void zzb(zzfex zzfex, zzfel zzfel, zzeew zzeew) throws zzffn {
        try {
            zzffg zzffg = zzfex.zza.zza;
            if (zzffg.zzo.zza == 3) {
                ((zzfge) zzeew.zzb).zzr(this.zza, zzffg.zzd, zzfel.zzv.toString(), (zzbos) zzeew.zzc);
            } else {
                ((zzfge) zzeew.zzb).zzq(this.zza, zzffg.zzd, zzfel.zzv.toString(), (zzbos) zzeew.zzc);
            }
        } catch (Exception e) {
            zzm.zzk("Fail to load ad from adapter ".concat(String.valueOf(zzeew.zza)), e);
        }
    }
}
