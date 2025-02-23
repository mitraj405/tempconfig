package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdmv {
    private final Executor zza;
    private final zzcop zzb;
    private final zzdek zzc;
    private final zzcni zzd;

    public zzdmv(Executor executor, zzcop zzcop, zzdek zzdek, zzcni zzcni) {
        this.zza = executor;
        this.zzc = zzdek;
        this.zzb = zzcop;
        this.zzd = zzcni;
    }

    public final void zza(zzcej zzcej) {
        if (zzcej != null) {
            this.zzc.zza(zzcej.zzF());
            this.zzc.zzo(new zzdmr(zzcej), this.zza);
            this.zzc.zzo(new zzdms(zzcej), this.zza);
            this.zzc.zzo(this.zzb, this.zza);
            this.zzb.zzf(zzcej);
            zzcgb zzN = zzcej.zzN();
            if (((Boolean) zzba.zzc().zza(zzbbw.zzjl)).booleanValue() && zzN != null) {
                zzN.zzJ(this.zzd);
                zzN.zzK(this.zzd, (zzedh) null, (zzdsk) null);
            }
            zzcej.zzag("/trackActiveViewUnit", new zzdmt(this));
            zzcej.zzag("/untrackActiveViewUnit", new zzdmu(this));
        }
    }

    public final /* synthetic */ void zzb(zzcej zzcej, Map map) {
        this.zzb.zzb();
    }

    public final /* synthetic */ void zzc(zzcej zzcej, Map map) {
        this.zzb.zza();
    }
}
