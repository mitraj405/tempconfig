package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzegn implements zzeet {
    /* access modifiers changed from: private */
    public final zzcql zza;
    private final zzefu zzb;
    private final zzgcu zzc;
    /* access modifiers changed from: private */
    public final zzcws zzd;
    private final ScheduledExecutorService zze;
    private final zzdsf zzf;

    public zzegn(zzcql zzcql, zzefu zzefu, zzcws zzcws, ScheduledExecutorService scheduledExecutorService, zzgcu zzgcu, zzdsf zzdsf) {
        this.zza = zzcql;
        this.zzb = zzefu;
        this.zzd = zzcws;
        this.zze = scheduledExecutorService;
        this.zzc = zzgcu;
        this.zzf = zzdsf;
    }

    public final ListenableFuture zza(zzfex zzfex, zzfel zzfel) {
        return this.zzc.zzb(new zzegl(this, zzfex, zzfel));
    }

    public final boolean zzb(zzfex zzfex, zzfel zzfel) {
        String str;
        zzbgu zza2 = zzfex.zza.zza.zza();
        boolean zzb2 = this.zzb.zzb(zzfex, zzfel);
        if (((Boolean) zzba.zzc().zza(zzbbw.zzkZ)).booleanValue()) {
            zzdsf zzdsf = this.zzf;
            String str2 = C0515Ga.AVLBLTY_ONLY;
            if (zza2 != null) {
                str = str2;
            } else {
                str = "0";
            }
            zzdsf.zzb().put("has_dbl", str);
            zzdsf zzdsf2 = this.zzf;
            if (true != zzb2) {
                str2 = "0";
            }
            zzdsf2.zzb().put("crdb", str2);
        }
        if (zza2 == null || !zzb2) {
            return false;
        }
        return true;
    }

    public final /* synthetic */ zzcpk zzc(zzfex zzfex, zzfel zzfel) throws Exception {
        return this.zza.zzb(new zzcsk(zzfex, zzfel, (String) null), new zzcrc(zzfex.zza.zza.zza(), new zzegk(this, zzfex, zzfel))).zza();
    }

    public final /* synthetic */ void zzf(zzfex zzfex, zzfel zzfel) {
        zzgcj.zzr(zzgcj.zzo(this.zzb.zza(zzfex, zzfel), (long) zzfel.zzR, TimeUnit.SECONDS, this.zze), new zzegm(this), this.zzc);
    }
}
