package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeht implements zzeez {
    private final Context zza;
    private final zzdhl zzb;
    /* access modifiers changed from: private */
    public zzbpb zzc;
    private final VersionInfoParcel zzd;

    public zzeht(Context context, zzdhl zzdhl, VersionInfoParcel versionInfoParcel) {
        this.zza = context;
        this.zzb = zzdhl;
        this.zzd = versionInfoParcel;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfex zzfex, zzfel zzfel, zzeew zzeew) throws zzffn, zzeir {
        if (zzfex.zza.zza.zzg.contains(Integer.toString(6))) {
            zzdjb zzt = zzdjb.zzt(this.zzc);
            zzffg zzffg = zzfex.zza.zza;
            if (zzffg.zzg.contains(Integer.toString(zzt.zzc()))) {
                zzdjd zze = this.zzb.zze(new zzcsk(zzfex, zzfel, zzeew.zza), new zzdjn(zzt), new zzdle((zzboy) null, (zzbox) null, this.zzc));
                ((zzegp) zzeew.zzc).zzc(zze.zzj());
                return zze.zza();
            }
            throw new zzeir(1, "No corresponding native ad listener");
        }
        throw new zzeir(2, "Unified must be used for RTB.");
    }

    public final void zzb(zzfex zzfex, zzfel zzfel, zzeew zzeew) throws zzffn {
        try {
            ((zzbql) zzeew.zzb).zzq(zzfel.zzZ);
            if (this.zzd.clientJarVersion < ((Integer) zzba.zzc().zza(zzbbw.zzbx)).intValue()) {
                ((zzbql) zzeew.zzb).zzm(zzfel.zzU, zzfel.zzv.toString(), zzfex.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzehs(this, zzeew, (zzehr) null), (zzbos) zzeew.zzc);
            } else {
                ((zzbql) zzeew.zzb).zzn(zzfel.zzU, zzfel.zzv.toString(), zzfex.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzehs(this, zzeew, (zzehr) null), (zzbos) zzeew.zzc, zzfex.zza.zza.zzi);
            }
        } catch (RemoteException e) {
            throw new zzffn(e);
        }
    }
}
