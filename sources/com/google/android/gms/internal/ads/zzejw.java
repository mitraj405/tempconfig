package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzejw implements zzeez {
    private final Context zza;
    /* access modifiers changed from: private */
    public final Executor zzb;
    private final zzdou zzc;

    public zzejw(Context context, Executor executor, zzdou zzdou) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzdou;
    }

    /* access modifiers changed from: private */
    public static final void zze(zzfex zzfex, zzfel zzfel, zzeew zzeew) {
        try {
            ((zzfge) zzeew.zzb).zzk(zzfex.zza.zza.zzd, zzfel.zzv.toString());
        } catch (Exception e) {
            zzm.zzk("Fail to load ad from adapter ".concat(String.valueOf(zzeew.zza)), e);
        }
    }

    public final /* bridge */ /* synthetic */ Object zza(zzfex zzfex, zzfel zzfel, zzeew zzeew) throws zzffn, zzeir {
        zzdoq zze = this.zzc.zze(new zzcsk(zzfex, zzfel, zzeew.zza), new zzdor(new zzejs(zzeew)));
        zze.zzd().zzo(new zzcmy((zzfge) zzeew.zzb), this.zzb);
        zzcxx zze2 = zze.zze();
        zzcwo zzb2 = zze.zzb();
        ((zzegq) zzeew.zzc).zzc(new zzejv(this, zze.zza(), zzb2, zze2, zze.zzg()));
        return zze.zzi();
    }

    public final void zzb(zzfex zzfex, zzfel zzfel, zzeew zzeew) throws zzffn {
        if (!((zzfge) zzeew.zzb).zzC()) {
            ((zzegq) zzeew.zzc).zzd(new zzeju(this, zzfex, zzfel, zzeew));
            Object obj = zzeew.zzb;
            Context context = this.zza;
            zzffg zzffg = zzfex.zza.zza;
            String jSONObject = zzfel.zzv.toString();
            ((zzfge) obj).zzh(context, zzffg.zzd, (String) null, (zzbvy) zzeew.zzc, jSONObject);
            return;
        }
        zze(zzfex, zzfel, zzeew);
    }
}
