package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzekr implements zzeet {
    private final zzbcr zza;
    private final zzgcu zzb;
    private final zzfjl zzc;
    /* access modifiers changed from: private */
    public final zzela zzd;

    public zzekr(zzfjl zzfjl, zzgcu zzgcu, zzbcr zzbcr, zzela zzela) {
        this.zzc = zzfjl;
        this.zzb = zzgcu;
        this.zza = zzbcr;
        this.zzd = zzela;
    }

    public final ListenableFuture zza(zzfex zzfex, zzfel zzfel) {
        zzbzt zzbzt = new zzbzt();
        zzekw zzekw = new zzekw();
        zzekw.zzd(new zzekq(this, zzbzt, zzfex, zzfel, zzekw));
        zzfeq zzfeq = zzfel.zzs;
        zzbcm zzbcm = new zzbcm(zzekw, zzfeq.zzb, zzfeq.zza);
        zzfjf zzfjf = zzfjf.CUSTOM_RENDER_SYN;
        return zzfiv.zzd(new zzekp(this, zzbcm), this.zzb, zzfjf, this.zzc).zzb(zzfjf.CUSTOM_RENDER_ACK).zzd(zzbzt).zza();
    }

    public final boolean zzb(zzfex zzfex, zzfel zzfel) {
        zzfeq zzfeq;
        if (this.zza == null || (zzfeq = zzfel.zzs) == null || zzfeq.zza == null) {
            return false;
        }
        return true;
    }

    public final /* synthetic */ void zzc(zzbcm zzbcm) throws Exception {
        this.zza.zze(zzbcm);
    }
}
