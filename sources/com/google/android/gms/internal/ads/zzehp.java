package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzbs;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzehp implements zzeez {
    private final Context zza;
    private final zzdhl zzb;
    private final Executor zzc;

    public zzehp(Context context, zzdhl zzdhl, Executor executor) {
        this.zza = context;
        this.zzb = zzdhl;
        this.zzc = executor;
    }

    private static final boolean zzc(zzfex zzfex, int i) {
        return zzfex.zza.zza.zzg.contains(Integer.toString(i));
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfex zzfex, zzfel zzfel, zzeew zzeew) throws zzffn, zzeir {
        zzdjb zzdjb;
        zzbox zzD = ((zzfge) zzeew.zzb).zzD();
        zzboy zzE = ((zzfge) zzeew.zzb).zzE();
        zzbpb zzd = ((zzfge) zzeew.zzb).zzd();
        if (zzd != null && zzc(zzfex, 6)) {
            zzdjb = zzdjb.zzt(zzd);
        } else if (zzD != null && zzc(zzfex, 6)) {
            zzdjb = zzdjb.zzai(zzD);
        } else if (zzD != null && zzc(zzfex, 2)) {
            zzdjb = zzdjb.zzag(zzD);
        } else if (zzE != null && zzc(zzfex, 6)) {
            zzdjb = zzdjb.zzaj(zzE);
        } else if (zzE == null || !zzc(zzfex, 1)) {
            throw new zzeir(1, "No native ad mappers");
        } else {
            zzdjb = zzdjb.zzah(zzE);
        }
        zzffg zzffg = zzfex.zza.zza;
        if (zzffg.zzg.contains(Integer.toString(zzdjb.zzc()))) {
            zzdjd zze = this.zzb.zze(new zzcsk(zzfex, zzfel, zzeew.zza), new zzdjn(zzdjb), new zzdle(zzE, zzD, zzd));
            ((zzegp) zzeew.zzc).zzc(zze.zzk());
            zze.zzd().zzo(new zzcmy((zzfge) zzeew.zzb), this.zzc);
            return zze.zza();
        }
        throw new zzeir(1, "No corresponding native ad listener");
    }

    public final void zzb(zzfex zzfex, zzfel zzfel, zzeew zzeew) throws zzffn {
        zzffg zzffg = zzfex.zza.zza;
        zzffg zzffg2 = zzfex.zza.zza;
        zzbes zzbes = zzffg2.zzi;
        ((zzfge) zzeew.zzb).zzp(this.zza, zzffg.zzd, zzfel.zzv.toString(), zzbs.zzm(zzfel.zzs), (zzbos) zzeew.zzc, zzbes, zzffg2.zzg);
    }
}
