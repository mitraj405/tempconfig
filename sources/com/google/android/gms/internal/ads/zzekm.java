package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzekm implements zzeet {
    private final Context zza;
    private final zzcql zzb;
    private final zzbcr zzc;
    private final zzgcu zzd;
    private final zzfjl zze;

    public zzekm(Context context, zzcql zzcql, zzfjl zzfjl, zzgcu zzgcu, zzbcr zzbcr) {
        this.zza = context;
        this.zzb = zzcql;
        this.zze = zzfjl;
        this.zzd = zzgcu;
        this.zzc = zzbcr;
    }

    public final ListenableFuture zza(zzfex zzfex, zzfel zzfel) {
        zzekk zzekk = new zzekk(this, new View(this.zza), (zzcej) null, new zzeki(), (zzfem) zzfel.zzu.get(0));
        zzcpl zza2 = this.zzb.zza(new zzcsk(zzfex, zzfel, (String) null), zzekk);
        zzekl zzl = zza2.zzl();
        zzfeq zzfeq = zzfel.zzs;
        zzbcm zzbcm = new zzbcm(zzl, zzfeq.zzb, zzfeq.zza);
        zzfjf zzfjf = zzfjf.CUSTOM_RENDER_SYN;
        return zzfiv.zzd(new zzekj(this, zzbcm), this.zzd, zzfjf, this.zze).zzb(zzfjf.CUSTOM_RENDER_ACK).zzd(zzgcj.zzh(zza2.zza())).zza();
    }

    public final boolean zzb(zzfex zzfex, zzfel zzfel) {
        zzfeq zzfeq;
        if (this.zzc == null || (zzfeq = zzfel.zzs) == null || zzfeq.zza == null) {
            return false;
        }
        return true;
    }

    public final /* synthetic */ void zzc(zzbcm zzbcm) throws Exception {
        this.zzc.zze(zzbcm);
    }
}
